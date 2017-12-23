<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta http-equiv="content-type" content="application/json">
</head>
<body>
<form action="/login" method="post">
    用户名:<br>
    <input type="text" name="name" >
    <br>
    口令:<br>
    <input type="text" name="keyword" >
    <br><br>
    <input type="submit" value="Submit">
</form>

Hello,${name}.欢迎阅读《${bookTitle}》
userId:${userId}
userName:${userName}

</body>
</html>