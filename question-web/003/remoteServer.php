<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2018/3/10
 * Time: 10:27
 */

function getNameById($id) {
    $result = array(
        'code' => 0,
        'message' => 'ok',
        'data' => 100
    );
    return $result;
}

$id = $_GET['id']; // 客户端传递的查询 参数
$callback = $_GET['callback']; // 客户端指定的需要回调的函数名

$result = getNameById($id);

echo $callback . '(' . json_encode($result) . ')'; // 返回的js文件中的js代码，调用客户端的回调函数，实际需要获取的数据作为实参