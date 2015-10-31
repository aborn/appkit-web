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

    <div class="html ui top attached segment">
        <form class="ui form" about="" action="/semantic/citysubmit.html" id="citySearchForm">
            <div class="inline fields">
                <label class="ak-form-label">城市:</label>
                <div class="ui search citysearch ak-form-label">
                    <div class="ui icon input">
                        <input class="prompt" type="text" name="cityName" id="cityName"
                               placeholder="请输入城市名,如:上海" value=<#if cityName??>"${cityName}"</#if>>
                        <i class="search icon"></i>
                    </div>
                    <div class="results"></div>
                </div>
                <input class="ak-hidden" value=<#if cityName??>"${cityName}"</#if> name="cityId" id="cityId">
                <button class="ui teal button" type="submit">提交</button>
            </div>
        </form>
    </div>

    <div class="ak-form-label"><#if info??>${info}</#if></div>
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
            url     : 'cityId',
            description : 'desc'
        },
        minCharacters : 1,
        error : {
            noResults   : '没有找到任何城市！'
        },
        onSelect : function(result, response) {
            console.log("用户选择了：" + result.cityName);
            $('#cityName').val(result.cityName);
            $('#cityId').val(result.cityId)
            $('#citySearchForm').submit();
        },
        onResultsAdd : function() {   // 返回结果之后
            console.log("after ajax result return" + $('#cityName').val());
        },
        onResultsClose : function() {
            console.log("selected after" + $('#cityName').val());
        }
    })
    ;
</script>
</body>
</html>
