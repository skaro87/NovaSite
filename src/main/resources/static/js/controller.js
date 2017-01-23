app.controller('siteController', function($scope, $http, $location) {
	
});

app.controller('homeController', function($scope, $http) {
	$scope.content = {header: 'Welcome to DeckBlitz', text: 'This site is currently being developed. Come back when the site is finished for your Nova Blitz fix!'}
});

app.controller('articlesController', function($scope, $http) {
	$http.get("/articles")
	.success(function(response) {
		$scope.content = response.data;
	});	
});

app.controller('articleViewController', function($scope, $http, $routeParams) {		
	$http.get("/articles/"+$routeParams.id)
	.success(function(response) {	
		$scope.article = response.data;
	});
});

app.controller('loginController', function($rootScope, $scope, $http, $location) {
		  var self = this;
		  var authenticate = function(credentials, callback) {

		    var headers = credentials ? {authorization : "Basic "
		        + btoa(credentials.username + ":" + credentials.password)
		    } : {};

		    $http.get('/user', {headers : headers}).then(function(response) {
		      if (response.data.name) {
		        $rootScope.authenticated = true;
		        $rootScope.username = (response.data.name);
		      } else {
		        $rootScope.authenticated = false;
		      }
		      callback && callback();
		    }, function() {
		      $rootScope.authenticated = false;
		      callback && callback();
		    });

		  }

		  self.credentials = {};
		  self.login = function() {
		      authenticate(self.credentials, function() {
		        if ($rootScope.authenticated) {
		          $location.path("/#/user");
		          self.error = false;
		        } else {
		          $location.path("/login");
		          self.error = true;
		        }
		      });
		  };
});

app.controller('logoutController', function($rootScope, $scope, $http, $location) {
	var self = this;
	self.logout = function() {
		  $http.post('logout', {}).finally(function() {
		    $rootScope.authenticated = false;
		  });
		}
});


app.controller('registrationController', function($rootScope, $http, $scope, $route, $location) {
	var self = this;
	self.register = function() {
		
		var username = self.credentials.username;
		
		if (!/^([a-zA-Z0-9]{5,})$/.test(username)){
			self.error = true;
		}
		else {
		
		var dataObj = {
				username : self.credentials.username,
				password : self.credentials.password, 
				email : self.credentials.email 
		};
		
		$http.post('registeruser', dataObj).then(function(data) {
			if (data.status == 202) {
				self.error = true;
			}
			
			if (data.status == 201) {
				$location.path("/#/user");
				self.error = false;
				$rootScope.authenticated = true;
				$rootScope.username = self.credentials.username;
			}
			
			
		  });
		}
	}
});


app.controller('cardsController', function($scope, $http, $route) {
	$http.get("/cards")
	.success(function(response) {
		$scope.cards = response.data;
	});
	
	// filter
	$scope.sortType     = 'name';
	$scope.sortReverse  = false; 
	$scope.search   = '';
	$scope.aspect = [1,2,3,4,5];
	$scope.rarity = [1,2,3,4];
	$scope.cost = [0,1,2,3,4,5,6,7,8,9,10];
	$scope.type = ['Unit','Power'];
	
	$scope.clearFilter = function() {
	    $scope.searchCost = '';
	    $scope.searchRarity = '';
	    $scope.searchAspect = '';
	    $scope.searchType = '';
	    $scope.searchSubtype = '';
	    $scope.searchText = '';
	    $scope.searchName = '';
	  }
	
	
});

app.controller('decksController', function($scope, $http, $route) {
	
	$http.get("/decks") .success(function(response) { 
		$scope.decks = response.data; });
	
});

app.controller('deckViewController', function($rootScope, $scope, $http, $routeParams, $q, $filter) {
	
	$q.all([
	 $http.get("/decks/"+$routeParams.id),
	 $http.get("/cards")
	]).then(function(values){
		
		$scope.deck = values[0].data.data;
		$scope.cards = values[1].data.data;
		
		$scope.deckowner = ($scope.deck.owner === $rootScope.username);
		
		$scope.cost = {
				'0':{'u':0, 'p':0},
				'1':{'u':0, 'p':0},
				'2':{'u':0, 'p':0},
				'3':{'u':0, 'p':0},
				'4':{'u':0, 'p':0},
				'5':{'u':0, 'p':0},
				'6':{'u':0, 'p':0},
				'7':{'u':0, 'p':0},
				'8':{'u':0, 'p':0},
				'9':{'u':0, 'p':0},
				'10':{'u':0, 'p':0}
				};
		
		
		fillCostChart = function(){
			angular.forEach($scope.deck.cardsInDeck, function(item){
				var type = $scope.cards[item.id-1].type;
				var cost = $scope.cards[item.id-1].cost;
				var quantity = item.quantity;
				
				if (type === 'Unit'){
					$scope.cost[cost].u += quantity;
				}
				else if (type === 'Power'){
					$scope.cost[cost].p += quantity;
				}
				
			})
		};
		
		fillCostChart();
		
		
		$scope.chartLabels = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10'];
		  $scope.chartSeries = ['Units', 'Powers'];
		  $scope.chartColours = [{fillColor:"#FF0000"}];

		  $scope.chartData = [
		    [$scope.cost[0].u, $scope.cost[1].u, $scope.cost[2].u, $scope.cost[3].u,
		    $scope.cost[4].u, $scope.cost[5].u, $scope.cost[6].u, $scope.cost[7].u,
		    $scope.cost[8].u, $scope.cost[9].u, $scope.cost[10].u],
		    
		    [$scope.cost[0].p, $scope.cost[1].p, $scope.cost[2].p, $scope.cost[3].p,
			 $scope.cost[4].p, $scope.cost[5].p, $scope.cost[6].p, $scope.cost[7].p,
			$scope.cost[8].p, $scope.cost[9].p, $scope.cost[10].p]
		  ];
		  
		
		  $scope.chartOptions = {
				  legend: { display: true },
			      scales: {
			        xAxes: [{
			          stacked: true,
			        }],
			        yAxes: [{
			          stacked: true
			        }]
			      }
			    };
		  
		  $scope.chartColors = [];
		
		$scope.getTotalCards = function(){
			var total = 0;
			angular.forEach($scope.deck.cardsInDeck, function(item){
				total += item.quantity;
			})
			return total;
		};
		
		$scope.getTotalCostInBots = function(){
			var total = 0;
			angular.forEach($scope.deck.cardsInDeck, function(item){
				total += item.quantity * $filter('nanobots')($scope.cards[item.id].rarity);
			})
			return total;
		};
		
		$scope.cardCost = function(item){
			return $scope.cards[item.id-1].cost;
		}
		
		
		
	});	
});

app.controller('deckEditController', function($scope, $http, $route) {
	
	$scope.deleteCard = function(item) { 
		  $scope.deck.cardsInDeck.splice($scope.deck.cardsInDeck.indexOf(item), 1);     
		}
	$scope.addCard = function(item) {   
		if (item.quantity < 3){
			item.quantity +=1;
		}
		
		}
	$scope.removeCard = function(item) {   
		if (item.quantity > 1){
			item.quantity -=1;
		}
		else if (item.quantity == 1)
			$scope.deleteCard(item);
		}
	
});