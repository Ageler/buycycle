<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as log>

<@c.page>
    <@log.login user, "/admin", "/logout", "/login"/>
<hr>
<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#--<# - способ обращения через freemaker к атрибутам шаблонизатора-->
<#--products as product - прохождение в цикле по всем элементам списка products (foreach)-->
<#list products as product>
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
<#--    срабатывает если ничего не вывелось в предыдущем (коллекция пустая)-->
<#else>
    <h3>Товаров нет</h3>
</#list>
<#if user.email??>
<hr>
<h3>Создать новый товар</h3>
<#--Атрибут action (HTML тега <form>) определяет адрес,
    куда отправляется форма (по умолчанию действие установлено на текущую страницу).
    Значение атрибута может быть переопределено с помощью атрибута formactionhtml5 элементов <button>,
        или <input> относящиxся к форме.-->
<#--enctype добавлен чтобы показать что данная форма может передавать и файловый тип-->
<form action="/product/create" method="post" enctype="multipart/form-data">
    <#-- Название объявления <input(Главным образом <input> предназначен для создания текстовых полей,
     различных кнопок, переключателей и флажков) type (тип формы)="text" name(Имя поля, предназначено для того,
     чтобы обработчик формы мог его идентифицировать !важно должно совпадать с названием в модели.)="title"/><br><br>-->
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Photo 1: <input type="file" name="file1"/><br><br>
    Photo 2: <input type="file" name="file2"/><br><br>
    Photo 3: <input type="file" name="file3"/><br><br>
    <#--    каждый post запрос должен сопровождаться _csrf токеном-->
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Добавить товар"/>
</form>
</#if>
</@c.page>