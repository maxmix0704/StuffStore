<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/tab.ftl">
     <div>
         <form method="post">
             <input type="hidden" name="_csrf" value="${_csrf.token}"/>
             <input type="hidden" value="${category.id}" name="id"/>
             <div class="form-group col-md-6">
                 <label for="category">Category</label>
                 <input type="text" class="form-control" id = "category" name="category" value="${category.category}"/>
             </div>
             <div class="form-group col-md-4">
                 <input  type="submit" class="btn btn-primary" name="submit" value="Edit"/>
                 <a class="btn btn-secondary" href="/admin/categoriesList" role="button">Back</a>
             </div>
         </form>
     </div>
</@c.page>