<!DOCTYPE html>
<html>
<head>
    <title>INFO PRODUCT</title>
</head>
<body>
<h1>INFO PRODUCT</h1><br>
<#list images as image>
    <img src="/images/${image.id}" height="60px"/><br><br>
</#list>
    <b>Название продукта: </b>${product.title}<br>
    <b>Описание продукта: </b>${product.description}<br>
    <b>Цена: </b>${product.price}<br>
    <b>Город: </b>${product.city}<br>
    <b>Автор: </b>${product.author}<br>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>