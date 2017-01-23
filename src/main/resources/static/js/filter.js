app.filter('rarity', function() {
	return function(input) {

		switch (input) {
		case 1:
			return 'Common';
		case 2:
			return 'Rare';
		case 3:
			return 'Epic';
		case 4:
			return 'Legendary';
		default:
			return '---';
		}
	}
});

app.filter('aspect', function() {
	return function(input) {

		switch (input) {
		case 1:
			return 'Arcane';
		case 2:
			return 'Tech';
		case 3:
			return 'Divine';
		case 4:
			return 'Nature';
		case 5:
			return 'Chaos';
		default:
			return '---';
		}
	}
});

app.filter('nanobots', function() {
	return function(input) {

		switch (input) {
		case 1:
			return 40;
		case 2:
			return 200;
		case 3:
			return 1000;
		case 4:
			return 4000;
		default:
			return 0;
		}
	}
});

