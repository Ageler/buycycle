<#macro login user, adminPath, logoutPath, loginPath>

    <#if user.email??>
        <h3>Имя пользователя: <i>${user.name}</i></h3>
        <form action="${logoutPath}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Выйти">
        </form>
        <#if user.isAdmin()>
            <a href="${adminPath}">Панель администратора</a>
        </#if>
    <#else>
        <a href="${loginPath}">Войти</a> </h1>
    </#if>
    <#nested >
</#macro>