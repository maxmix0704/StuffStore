<#import "parts/common.ftl" as c>
<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="submit" value="Sign out"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
Main page
<div>

</div>

<h3>Add product</h3>
</@c.page>

