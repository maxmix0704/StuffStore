<#macro login>
    <form action="/login" method="post">
        <input type="text" placeholder="username" name="username"/>
        <input type="password" placeholder="password" name="password"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" name="submit" value="Sign In"/>
    </form>
</#macro>