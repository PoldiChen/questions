
function isFunction(val) {
	if (val) {
		if (typeof (/./) === 'function') {
			return Object.prototype.toString.call(val) === '[object Function]';
		} else {
			return typeof val === 'function';
		}
	}
	return false;
}