<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${model["pageTitle"]}</title>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="/resources/css/appkit-theme.css" rel="stylesheet" media="screen" />
</head>
<body>

<div>
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
</div>
</body>
</html>
