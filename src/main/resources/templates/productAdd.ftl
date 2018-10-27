<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/tab.ftl">

    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group col-md-6">
                <label for="name">Name</label>
                <input type="text" class="form-control" id = "name" placeholder="name" name="name" />
            </div>
            <div class="form-group col-md-6">
                <label for="discription">Discription</label>
                <input type="text" class="form-control" id = "discription" placeholder="discription" name="discription" />
            </div>
            <div class="form-group col-md-6">
                <label for="inputState">Category</label>
                <select name="category_id" id="inputState" class="form-control">
                    <option selected>Select..</option>
                    <#list categories as category>
                        <option value="${category.id}">${category.category}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="price">Price</label>
                <input type="text" class="form-control" id = "price" placeholder="price" name="price" />
            </div>
            <div class="form-group col-md-4">
                <label for="exampleFormControlFile1">Example file input</label>
                <input type="file" class="form-control-file" name="file">
            </div>
            <div class="form-group col-md-4">
                <input  type="submit" class="btn btn-primary" name="submit" value="Add"/>
            </div>
        </form>
    </div>

</@c.page>