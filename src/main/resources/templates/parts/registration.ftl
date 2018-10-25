<#macro registration>
    <#if message??>
        ${message}
    </#if>
<form action="/registration" method="post">
    <div class="form-group mb-2">
        <input type="text" class="form-control" placeholder="username" name="username"/>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" placeholder="surname" name="surname"/>
    </div>
    <div class="form-group">
        <input type="password" class="form-control" placeholder="password" name="password"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" class="btn btn-primary" name="submit" value="Sign In"/>
</form>
</#macro>