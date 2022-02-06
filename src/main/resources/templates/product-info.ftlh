<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as log>

<@c.page>
    <@log.login false, "/admin", "/logout", "/login"/>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b> ${product.title}<br>
<b>Описание товара: </b> ${product.description}<br>
<b>Цена: </b> ${product.price}<br>
<b>Город: </b> ${product.city}<br>
<b>Автор: </b><a href="/user/${product.user.id}">${product.user.name}</a><br>
</body>
</html>
</@c.page>