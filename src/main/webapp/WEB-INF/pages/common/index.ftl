<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${model["pageTitle"]}</title>
<#include "/common/common-css.ftl" />
</head>
<body>

<div>
<#include "/layout/head.ftl" />
    <div class="container">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4>About appkit-web</h4>
            </div>
            <div class="panel-body">
                <h5>The JavaEE web project uses following frameworks:</h5>
                <ol>
                    <li>Spring 4 MVC (Version: 4.1.1.RELEASE).</li>
                    <li>Freemarker template engine (Version: 2.3.20).</li>
                    <li>Bootstrap (Version: 3.3.2).</li>
                    <li>jQuery (Version: 2.1.3)</li>
                    <li>Mybatis as database connection layer (Version: 3.2.8).</li>
                </ol>
            </div>
        </div>

        <!--
        <div id="header">
            <h2>
                <a href="http://viralpatel.net"><img height="37" width="37" border="0px"
                                                     src="/resources/image/favicon.ico" align="left"></a>
                FreeMarker Spring 4 MVC Hello World
            </h2>
        </div>

        <div id="content">
            <fieldset>
                <legend>Add User</legend>
                <form name="user" action="add.html" method="post"
                      accept-charset="utf-8">
                    Firstname: <input type="text" name="firstname"> <br>
                    Lastname: <input type="text" name="lastname">   <br>
                    <input type="submit" value="   Save   ">
                </form>
            </fieldset>
            <br>
            <table class="datatable">
                <tbody>
                <tr>
                    <th>Firstname</th>  <th>Lastname</th>
                </tr>
                <#list model["userList"] as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
            -->
    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
</body>
</html>
