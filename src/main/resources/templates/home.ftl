<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="row m-3 justify-content-md-center">
        <h3>Home page</h3>
    </div>
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

                    <li class="list-group-item">Category: <#if product.category??>${product.category.category}<#else>none</#if> </li>
                    <li class="list-group-item">Price: <#if product.price??><h3>${product.price}</h3><#else>none</#if> </li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Add to cart</a>
                </div>
            </div>
        </#list>
    </div>
</@c.page>
