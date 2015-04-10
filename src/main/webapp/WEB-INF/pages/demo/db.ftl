<html>
<head>
    <meta charset="UTF-8">
    <title>demo</title>
<#include "/common/common-css.ftl" />
</head>
<body>
<div>
<#include "/layout/head.ftl" />
    <div class="container">
        <div class="panel panel-info">
            <div class="panel panel-heading">
                <h4>database operating example</h4>
            </div>

            <div class="panel panel-body">
                <h2>MySql Database call example</h2>
                <h3>Table size: ${tabinfo.size}</h3>
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
