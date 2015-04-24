<html>
<head>
    <meta charset="UTF-8">
    <title>demo</title>
<#include "/common/common-css.ftl" />
</head>
<body>
<div>
<#include "/layout/head.ftl" />
    <div class="container list-container">
        <div class="panel panel-info">
            <div class="panel panel-heading">
                <h4>database operating example</h4>
            </div>

            <div class="panel panel-body">
                <!--
                <form method="post" action="/demo/addUser.html">
                    <input class="text-left" placeholder="input name" name="name" required/>
                    <input class="text-left" placeholder="input address" name="address" required/>
                    <button class="btn-primary">submit</button>
                </form>
                -->

                <lable class="control-label pull-left">scene:</lable>
                <div class="col-md-2">
                    <select name="eleScene" class="form-control" id="eleScene">
                        <option value="" >notlimit</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="panel panel-default">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="col-md-2 text-center">ID</th>
                    <th class="col-md-3 text-center">Name</th>
                    <th class="col-md-5 text-center">Adress</th>
                    <th class="col-md-2 text-left">Operate</th>
                </tr>
                </thead>

                <tbody>
                <#list data as user>
                <tr>
                    <td class="text-center">${user.id}</td>
                    <td class="text-center">${user.name}</td>
                    <td class="text-center">${user.address}</td>
                    <td class="text-left">
                        <a class="btn btn-xs btn-primary">edit</a>
                        <a class="btn btn-xs btn-danger">delete</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>

    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
</body>
</html>
