<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>markdown editor demo</title>
    <!-- Site Properities -->
<#include "/common/semantic.ftl">
    <link rel="stylesheet" href="https://lab.lepture.com/editor/editor.css" />
    <script type="text/javascript" src="https://lab.lepture.com/editor/editor.js"></script>
    <script type="text/javascript" src="https://lab.lepture.com/editor/marked.js"></script>
</head>

<body>
<#include "/layout/navbar.ftl"/>

<div class="ui container ak-main-container">
    <div class="container">
        <textarea></textarea>
        <button class="ui primary button" id="save-content-button">保存</button>
    </div>
</div>

<#include "/layout/copyright.ftl"/>
<script>
    var editor = new Editor();
    editor.render();
    $('#save-content-button').on('click', function(){
        var content = editor.codemirror.getValue();
        $.post("/demo/editorsumbitcontent.html",
                {
                    content : content
                },function(data){
                    console.log(data.info);
                },
                dataType="json")
        console.log('content:' + content)
    })
</script>
</body>
</html>
