
var func = function() {
    console.log(this.bar);
};

var bar = 1;
var obj = {
    func: func,
    bar: 2
};

func();
obj.func();