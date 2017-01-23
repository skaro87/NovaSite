var app = angular.module('app', ['ngRoute', 'chart.js']);
app
		.config(function($routeProvider, $httpProvider) {

			$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest'

			$routeProvider.when('/', {
				templateUrl : '/home.html',
				controller : 'homeController'
			}).when('/articles', {
				templateUrl : '/articlesview.html',
				controller : 'articlesController'
			}).when('/articles/:id', {
				templateUrl : '/articleview.html',
				controller : 'articleViewController'
			}).when('/cards', {
				templateUrl : '/cardsview.html',
				controller : 'cardsController'
			}).when('/decks', {
				templateUrl : '/decksview.html',
				controller : 'decksController'
			}).when('/decks/:id', {
				templateUrl : '/singledeck.html',
				controller : 'deckViewController'
			}).when('/editdeck', {
				templateUrl : '/deckedit.html',
				controller : 'deckEditController'
			}).when('/login', {
				templateUrl : 'login.html',
				controller : 'loginController',
				controllerAs : 'controller'
			}).when('/register', {
				templateUrl : 'register.html',
				controller : 'registrationController',
				controllerAs : 'controller'
			}).when('/about', {
				templateUrl : '/about.html',
				controller : 'siteController'
			}).otherwise({
				redirectTo : '/'
			});
		});