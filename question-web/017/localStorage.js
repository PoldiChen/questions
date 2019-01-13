/**
 * @user chenxihong
 * @date 2018/3/4 9:47
 * @desc 浏览器localStorage读写
 */

function saveLocalStorage(id, key, value) {
    var seller = window.localStorage.__seller__;
    if (!seller) { // 已有的storage为 空
        seller = {};
        seller[id] = {};
    } else { // 已有的storage不为空
        seller = JSON.parse(seller);
        if (!seller[id]) { // id不存在
            seller[id] = {};
        } else {
            seller[id][key] = value; // id存在
        }
        window.localStorage.__seller__ = JSON.stringify(seller); // 转化为json字符串写回storage
    }
}

function loadLocalStorage(id, key, def) {
    var seller = window.localStorage.__seller__;
    if (!seller) {
        return def;
    } else {
        seller = JSON.parse(seller)[id];
        if (!seller) {
            return def;
        } else {
            var ret = seller[key];
            return ret || def;
        }
    }
}
