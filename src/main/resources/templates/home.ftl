<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="row">
        <div class="col-2">
            <div class="list-group mt-5">
                <#list categories as category>
                    <a href="filter?filter=${category.category}" class="list-group-item list-group-item-action ">${category.category}</a>
                </#list>
            </div>
        </div>
        <div class="col-10">
            <div class="row m-3 justify-content-md-center">
                <h3>Home page</h3>
            </div>
        <#if message??>
            <div class="row m-3 justify-content-md-center">
                <h3>${message}</h3>
            </div>
        </#if>
            <div class="card-columns">
        <#list products as product>
            <div class="card" style="width: 18rem;">
            <#if product.filename??>
                <img class="card-img-top" src="/img/${product.filename}" alt="Card image cap">
            </#if>
                <div class="card-body">
                    <h5 class="card-title"> ${product.name}</h5>
                    <p class="card-text">${product.discription}</p>
                </div>
                <ul class="list-group list-group-flush">

                    <li class="list-group-item">Category: <#if product.category??>${product.category.category}<#else>none</#if> </li>
                    <li class="list-group-item">Price: <#if product.price??><h3>${product.price}<span> USD</span></h3><#else>none</#if> </li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">Add to cart</a>
                </div>
            </div>
        </#list>
            </div>
        </div>
    </div>

</@c.page>
