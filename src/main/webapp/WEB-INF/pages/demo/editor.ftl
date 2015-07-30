<html>
<head>
    <meta charset="UTF-8">
    <title>markdown editor</title>
<#include "/common/common-css.ftl" />
    <link rel="stylesheet" href="http://lab.lepture.com/editor/editor.css" />
    <script type="text/javascript" src="http://lab.lepture.com/editor/editor.js"></script>
    <script type="text/javascript" src="http://lab.lepture.com/editor/marked.js"></script>
</head>
<body>
<div>
<#include "/layout/head.ftl" />
    <div class="container">
        <textarea></textarea>
    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
<script>
    var editor = new Editor();
    editor.render();
</script>
</body>
</html>
