<!DOCTYPE html>
<html>
<body>
Hello,${name}.欢迎阅读《${bookTitle}》
userId:${userId}
userName:${userName}
<#if userName == "Big Joe"></#if>
<#list userName as name>
<tr><td>${name.empty}</td>
</#list>
</body>
</html>