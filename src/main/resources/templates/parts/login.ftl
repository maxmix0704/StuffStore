<#macro login>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="username">Login</label>
            <input type="text" class="form-control" placeholder="username" name="username"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" placeholder="password" name="password"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" class="btn btn-primary" name="submit" value="Sign In"/>
    </form>
</#macro>