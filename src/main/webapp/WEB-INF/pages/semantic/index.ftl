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
    <form class="ui form" about="">
        <div class="inline fields">
            <div class="ui citysearch">
                <div class="ui icon input">
                    <input class="prompt" type="text" placeholder="请输入城市">
                    <i class="search icon"></i>
                </div>
                <div class="results"></div>
            </div>
        </div>
    </form>
</div>

<#include "/layout/copyright.ftl"/>
<script type="text/javascript">
    $('.ui.citysearch').search({
        apiSettings: {
            url: '/semantic/querycity.api?q={query}'
        },
        fields: {
            results : 'results',
            title    : 'cityName',
            url     : 'cityId'
        },
        minCharacters : 1
    })
    ;
</script>
</body>
</html>
