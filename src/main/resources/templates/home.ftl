<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Home page
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
