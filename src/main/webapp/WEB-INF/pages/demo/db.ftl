<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>appkit</title>
    <!-- Site Properities -->
<#include "/common/semantic.ftl">
</head>
<body>

<#include "/layout/navbar.ftl"/>

<div class="ui container ak-main-container">

    <div class="container">
        <div class="panel panel-info">
            <div class="panel panel-heading">
                <h4>database operating example</h4>
            </div>

            <div class="panel panel-body">
                <h2>MySql Database call example</h2>
                <h3>Table size: ${tabinfo.size}</h3>
                <form method="post" action="/demo/addUser.html">
                    <input class="text-left" placeholder="input name" name="name" required/>
                    <input class="text-left" placeholder="input address" name="address" required/>
                    <button class="btn-primary">submit</button>
                </form>
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

<#include "/layout/copyright.ftl"/>
</body>
</html>
