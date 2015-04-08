<html>
<head>
    <meta charset="UTF-8">
    <title>${model["pageTitle"]}</title>
<#include "/common/common-css.ftl" />
</head>
<body>
<div>
<#include "/layout/head.ftl" />
    <div class="container">
        <h2>${model["info"]}</h2>
        <h3>${model["class"]}</h3>
    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
</body>
</html>
