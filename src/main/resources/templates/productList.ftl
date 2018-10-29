<#import "parts/common.ftl" as c>

<@c.page>

    <#include "parts/tab.ftl">

<div class="col mt-3 md-6">
    <h3>Product list</h3>
</div>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Category</th>
        <th>Price</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list products as product>
        <tr>
            <td>${product.name}</td>
            <td>${product.discription}</td>
            <td><#if product.category??>${product.category.category}<#else>none</#if></td>
            <td><#if product.price??>${product.price}<#else>none</#if></td>
            <td><a href="/admin/productList/${product.id}">edit</a></td>
            <td><a href="/admin/productList/delete/${product.id}">delete</a></td>
        </tr>
        </#list>
    </tbody>
</table>
<div>
    <a class="btn btn-primary" href="/admin/productList/addProduct" role="button">Add product</a>
</div>

</@c.page>
