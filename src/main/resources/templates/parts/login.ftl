<#macro login>
    <form action="/login" method="post">
        <span>Login</span>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="username" name="username"/>
        </div>
        <span>Password</span>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="password" name="password"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" class="btn btn-primary" name="submit" value="Sign In"/>
    </form>
</#macro>