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
    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
</body>
</html>
