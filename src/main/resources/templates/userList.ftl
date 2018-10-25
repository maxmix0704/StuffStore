<#import "parts/common.ftl" as c>

<@c.page>
<h3>List of user</h3>
<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list userList as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/admin/userList/${user.id}">edit</a></td>
        </tr>
        </#list>
    </tbody>
</table>
</@c.page>