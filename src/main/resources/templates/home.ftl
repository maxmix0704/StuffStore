<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Home page
<div class="card-columns">
    <#list products as product>
        <div class="card" style="width: 18rem;">
            <#--<#if product.filename??>-->
                <img class="card-img-top" src="/img/${product.filename}" alt="Card image cap">
            <#--</#if>-->
            <div class="card-body">
                <h5 class="card-title"> ${product.name}</h5>
                <p class="card-text">${product.discription}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Category: </li>
                <li class="list-group-item">Type: </li>
                <li class="list-group-item">Price: </li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    </#list>
</div>
</@c.page>
