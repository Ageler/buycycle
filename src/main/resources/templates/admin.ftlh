<!DOCTYPE html>
<html>
<head>
    <title>BUYCYCLE</title>
</head>
<body>
<#--<hr> - отступ-->
<#--?? -  exist-->
<h1>BUYCYCLE</h1><hr>
<h4>Панель администратора</h4>

<table border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>User Ban</th>
        <th>Редактирование</th>
        <th>Подробнее</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>
<#-- <#sep>,  разделяет элементы коллекции-->
                ${role}<#sep>, </#list></th>
            <th><form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Ban">
                </form> </th>
            <th><a href="admin/user/edit/${user.id}">Редактирование</a></th>
            <th><a href="/user/${user.id}">Подробнее</a></th>
        </tr>
        <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
</body>
</html>