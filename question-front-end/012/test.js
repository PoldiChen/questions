
for (var i = 0; i < 5; i++) {
	setTimeout(function() {
		console.log(i);
	}, 100);
}

for (var i = 0; i < 5; i++) {
	(function(i) {
		setTimeout(function() {
			console.log(i);
		}, 100);
	}(i))
}