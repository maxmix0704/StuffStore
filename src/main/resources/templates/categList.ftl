<#import "parts/common.ftl" as c>

<@c.page>

    <#include "parts/tab.ftl">

<div class="col mt-3 md-6">
    <h3>Categories list</h3>
</div>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list categories as category>
        <tr>
            <td>${category.id}</td>
            <td>${category.category}</td>
            <td><a href="/admin/categoriesList/${category.id}">edit</a></td>
            <td><a href="/admin/categoriesList/delete/${category.id}">delete</a></td>
        </tr>
        </#list>
    </tbody>
</table>
<div>
    <a class="btn btn-primary" href="/admin/categoriesList/addCategory" role="button">Add category</a>
</div>

</@c.page>
