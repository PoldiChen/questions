
function generateList() {
    var list = [];
    for (var i=100000; i>0; i--) {
        list.push(i);
    }
    return list;
}

var list = generateList();
var nextListItem = function() {
    var item = list.pop();
    console.log(item);
    if (item) {
        setTimeout(nextListItem, 0);
        // nextListItem();
    }
};

nextListItem();