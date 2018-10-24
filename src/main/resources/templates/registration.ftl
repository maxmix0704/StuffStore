<html>
<head>
    <title>Home</title>
</head>
<body>
Registration
<#if message??>
    ${message}
</#if>
<form action="/registration" method="post">
    <input type="text" placeholder="username" name="username"/>
    <input type="text" placeholder="surname" name="surname"/>
    <input type="password" placeholder="password" name="password"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <input type="submit" name="submit" value="Sign In"/>
</form>
</body>
</html>
