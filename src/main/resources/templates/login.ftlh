<#import "parts/common.ftlh" as c>

<@c.page>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта <input type="email" name="username"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход">
</form>
<a href="/registration">Зарегистрироваться</a>
</body>
</html>
</@c.page>