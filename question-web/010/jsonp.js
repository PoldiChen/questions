/**
 * @user chenxihong
 * @date 2018/3/4 10:11
 * @desc jsonp实现跨域
 */

// 网页动态插入<script>元素，由它向其他源发送请 求

function addScriptTag(src) {
    var script = document.createElement('script');
    script.setAttribute('type', 'text/javascript');
    script.src = src;
    document.body.appendChild(script);
}

window.onload = function() {
    addScriptTag("host:port/url?callback=foo");
};

function foo(data) {
    console.log(data)
}