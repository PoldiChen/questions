/**
 * @user chenxihong
 * @date 2018/2/10 9:37
 * @desc ajax请求原生js代码
 */

// readyStatus五个阶段：
// 0：未初始化。尚未调用open方法
// 1：启动。已调用open方法，未调用send方法
// 2：发送。已调用send方法，未接收到响应
// 3：接收。已接收部分响应数据
// 4：完成。已接收所有数据，且可以在客户端使用了

function rawAjax() {
    // 获取一个XMLHttpRequest对象
    var xmlHttpRequest = null;
    if (window.ActiveXObject) { // IE5 IE6以ActiveXObject的方式引入XMLHttpRequest
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.xmlHttpRequest) { // 其他浏览器，XMLHttpRequest是window的子对象
        xmlHttpRequest = new XMLHttpRequest();
    }

    if (xmlHttpRequest != null) {
        xmlHttpRequest.onreadystatechange = function() { // 设置回调函数
            if (xmlHttpRequest.readyState == 4) { // 响应已经成功返回
                if ((xmlHttpRequest.status >= 200 && xmlHttpRequest.status < 300) || xmlHttpRequest.status == 304) {
                    alert(xmlHttpRequest.responseText); // 304表示资源没有修改，可以直接使用浏览器缓存
                } else {
                    alert("request fail:"+xmlHttpRequest.status);
                }
            }
        };
        // 启动请求
        xmlHttpRequest.open("get", "url", true); // 第三个参数，是否异步
        // 设置请求header头信息
        xmlHttpRequest.setRequestHeader("key", "value");
        // 发送数据
        xmlHttpRequest.send(null); // 参数：发送的数据
    }
}
