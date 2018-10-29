<#include "security.ftl">
<#import "modal.ftl" as m>
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <a class="navbar-brand" href="/">Stuff Store</a>
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/">Delivery</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/">Warranry</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/">Contacts</a>
                </li>
            <#if isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/admin">Admin Page</a>
                </li>
            </#if>
            </ul>
        <div class="col-md-5">
            <form class="form-inline my-2 my-lg-0" action="/filter">
                <input class="form-control mr-sm-2" type="text" name="filter" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
            <div>
                Hello,
            </div>
            <div class="navbar-text mr-1 ml-1">${name}</div>
            <div class="mr-2">
            <#if name='guest'>
                <span><a href="/login" data-toggle="modal" data-target="#exampleModal">Log in to your account</a></span>
            <#else>
                <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-sm btn-outline-secondary">Sign out</button>
                </form>
            </#if>
                <@m.modal "Login">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <@l.login>
                            </@l.login>
                        </div>
                        <div class="col align-self-center">
                            <div class="row justify-content-center">
                                <a class="btn btn-primary" href="/registration" role="button">Registration</a>
                            </div>
                        </div>
                    </div>
                </div>
                </@m.modal>
            </div>
            <div>
                <button type="button" class="btn btn-outline-danger">Cart</button>
            </div>
        </div>
    </div>


    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
