<#import "parts/common.ftlh" as c>


<@c.page>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    Имя пользователя <input type="text" name="name"><br><br>
    Эл. почта <input type="email" name="email"><br><br>
    Номер телефона <input type="text" name="phoneNumber"><br><br>
    Пароль: <input type="password" name="password"><br><br>
<#--    для невозоможности перехвата тела метода-->
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>
</@c.page>