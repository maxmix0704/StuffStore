<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/tab.ftl">

    <div>
        <form method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-6">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <input type="hidden" value="${product.id}" name="id"/>
                    <div class="form-group col">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id = "name" placeholder="name" name="name" value="${product.name}"/>
                    </div>
                    <div class="form-group col">
                        <label for="discription">Discription</label>
                        <input type="text" class="form-control" id = "discription" placeholder="discription" name="discription" value="${product.discription}"/>
                    </div>
                    <div class="form-group col">
                        <label for="inputState">Category</label>
                        <select name="category_id" id="inputState" class="form-control">
                    <#list categories as category>
                        <option value="${category.id}" <#if category.category==product.category.category>selected</#if>>${category.category}</option>
                    </#list>
                        </select>
                    </div>
                    <div class="form-group col">
                        <label for="price">Price</label>
                        <input type="text" class="form-control" id = "price" placeholder="price" name="price" value="${product.price}"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="exampleFormControlFile1">Example file input</label>
                        <input type="file" class="form-control-file" name="file">
                    </div>
                    <div class="form-group col-md-4">
                        <input  type="submit" class="btn btn-primary" name="submit" value="Add"/>
                    </div>
                </div>

                <div class="col">
                    <div>
                        <img src="/img/${product.filename}" class="img-thumbnail" alt="Card image cap">
                    </div>
                </div>
            </div>



        </form>
    </div>

</@c.page>