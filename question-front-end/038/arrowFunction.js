
let obj = {
    val: 2,
    func: function() {
        setTimeout(function() { // 传递普通function给setTimeout，this指向window
            console.log(this.val);
        }, 1)
    }
};


let obj2 = {
    val: 2,
    func: function() {
        setTimeout(()=>{ // 传递箭头函数给setTimeout，箭头往上层作用域查找this，上层func的this指向obj2
            console.log(this.val);
        }, 1)
    }
};


obj.func();
obj2.func();