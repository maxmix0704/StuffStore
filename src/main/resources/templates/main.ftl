<#import "parts/common.ftl" as c>
<@c.page>
    <div>
        <form action="/logout" method="post">
            <input type="submit" value="Sign out"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
Main page
<h3>Add product</h3>
<div>
    <form action="/addProduct" method="post">
        <input type="text" placeholder="name" name="name"/>
        <input type="text" placeholder="discription" name="discription"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" name="submit" value="Add"/>
    </form>
</div>
<div>
    <#list products as product>
        <div>
            ${product.name}
        </div>
        <div>
            ${product.discription}
        </div>
    </#list>
</div>
</@c.page>

