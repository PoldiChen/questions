
function isArray(val) {
	if (typeof val === 'object') {
		return Object.prototype.toString.call(val) === '[object Array]';
	} else {
		return false;
	}
}