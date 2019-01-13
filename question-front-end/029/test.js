

function setTimeoutTest() {
	var bb = 0;
	var testSet = setInterval(function() {
		bb++;
		console.log(11);
		if (bb < 10) {
			clearInterval(testSet);
		}
	}, 200);

	var testSet2 = setTimeout(function() {
		console.log(22);
	}, 1000);

	for (var i=0; i<10; i++) {
		console.log('aa');
	}
}

setTimeoutTest();