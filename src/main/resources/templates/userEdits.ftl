<#import "parts/common.ftl" as c>

<@c.page>
User edit
<form action="/admin/userList" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="text" name="userName" value="${user.username}"/>
    <input type="hidden" name="userId" value="${user.id}"/>
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}/>${role}</label>
        </div>
    </#list>
    <button type="submit">Save</button>
</form>
</@c.page>