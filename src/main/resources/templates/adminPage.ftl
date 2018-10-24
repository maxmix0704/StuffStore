<#import "parts/common.ftl" as c>

<@c.page>
    Add product
    <div>
        <form action="/addProduct" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" placeholder="name" name="name"/>
            <input type="text" placeholder="discription" name="discription"/>
            <input type="file" name="file"/>
            <input type="submit" name="submit" value="Add"/>
        </form>
    </div>
</@c.page>