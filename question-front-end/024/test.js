
if (!Array.prototype.indexOf) { // 判断浏览器是否支持Array.indexOf
    Array.prototype.indexOf = function(obj, start) {
        for (var index = (start || 0), j = this.length; index < j; index++) {
            if (this[index] === obj) {
                return index;
            }
        }
        return -1;
    };
}