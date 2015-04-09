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
        </div>

    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
</body>
</html>
