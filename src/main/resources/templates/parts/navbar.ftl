<#import "modal.ftl" as m>
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Stuff Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
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
            <li class="nav-item active">
                <a class="nav-link" href="/adminpage">Admin Page</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/userList">UserList</a>
            </li>
        </ul>
    <div class="mr-2">
        Hello,
        <span><a href="/login" data-toggle="modal" data-target="#exampleModal">Log in to your account</a></span>
                <@m.modal "Login">
                    <div class="row">
                        <div class="col">
                            <@l.login>
                            </@l.login>
                        </div>
                        <div class="col">
                            <a class="btn btn-primary" href="/registration" role="button">Registration</a>
                        </div>
                    </div>
                    </div>
                </@m.modal>
    </div>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
</nav>
