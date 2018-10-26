<#import "parts/common.ftl" as c>

<@c.page>
<div class="col mt-3 md-6">
    <h3>User edit</h3>
</div>
<form action="/admin/userList" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group col-md-6">
        <input type="text" class="form-control" name="userName" value="${user.username}"/>
    </div>
        <input type="hidden" name="userId" value="${user.id}"/>
    <div class="form-group col-md-6">
        <#list roles as role>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>
            <label class="custom-control-label" for="customCheck1">${role}</label>
        </div>
    </#list>
    </div>
    <div class="form-group col-md-6">
        <button type="submit" class="btn btn-primary">Save</button>
        <a class="btn btn-secondary" href="/admin/userList" role="button">Back</a>
    </div>
</form>
</@c.page>