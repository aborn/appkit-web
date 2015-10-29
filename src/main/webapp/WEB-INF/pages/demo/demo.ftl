<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>${model["pageTitle"]}</title>
    <!-- Site Properities -->
<#include "/common/semantic.ftl">
</head>

<body>
<#include "/layout/navbar.ftl"/>
<div>
    <div class="ui container ak-main-container">
        <h2>${model["info"]}</h2>
        <h3>${model["class"]}</h3>
    </div>
</div>

<#include "/layout/copyright.ftl"/>
</body>
</html>
