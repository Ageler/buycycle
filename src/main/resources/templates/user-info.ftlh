<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as log>

<@c.page>
    <@log.login user, "/admin", "/logout", "/login"/>
<h3>Подробная информация о пользователе ${user.name}</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Email: </b> ${user.email}<br>
<h4>Товары пользователя</h4>
<#list allProducts as product>
    <div>
        <p>
            <#--обращение происходит через геттеры-->
            <#--<b></b> - жирный шрифт-->
            <#--${} - ссылка-->
            <b>${product.title}</b>
            <#--href="/product/${product.id} - используем для того чтобы была уникальная ссылка на каждый товар-->
            ${product.price} | <a href="/product/${product.id}">Подробнее...</a>
        </p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>
</@c.page>