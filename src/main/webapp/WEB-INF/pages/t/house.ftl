<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Timer</title>

    <link rel="icon" type="image/png" href="/resources/image/favicon.ico">
    <link rel="icon" sizes="192x192" href="/resources/image/favicon.ico">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.6.2/css/amazeui.min.css">
</head>

<body>

<!-- 页面内容 开发时删除 -->
<div class="am-g am-g-fixed am-margin-top">
    <div class="am-u-sm-12">
        <h1 class="am-kai">交房倒计时：</h1>
        <p id="timer" class="am-kai" style="font-size: larger;"></p>
    </div>
</div>

<div class="am-g am-g-fixed am-margin-top">
    <div class="am-u-sm-12">
        <div class="am-slider am-slider-default" >
        <#--<div><div class="image"><img data-lazy="http://lorempixel.com/1600/600/city"/></div></div>
        <div><div class="image"><img data-lazy="http://lorempixel.com/1600/600/food"/></div></div>-->

<#--
        <div><div class="image"><img width="640px" data-lazy="http://lorempixel.com/640/800/nature"/></div></div>
        <div><div class="image"><img width="640px" data-lazy="http://lorempixel.com/640/800/people"/></div></div>
        <div><div class="image"><img width="640px" data-lazy="http://lorempixel.com/640/800/animals"/></div></div>
-->


        <#--
        <ul class="am-slides">
            <li data-thumb="/resources/image/house/img_1.png">
                <img src="/resources/image/house/img_1.png">
            </li>

            <li data-thumb="/resources/image/house/img_2.png">
                <img src="/resources/image/house/img_2.png">

            </li>

        </ul>-->
        </div>
    </div>
</div>

<footer class="am-margin-top am-topbar-fixed-bottom">
    <hr/>
    <p class="am-text-center">
        <small>by Aborn Jiang.</small>
    </p>
</footer>

<script src="https://cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.6.2/js/amazeui.min.js"></script>

<script type="text/javascript">
    function timer() {
        var ts = (new Date(2016, 11, 31, 0, 0, 0)) - (new Date()); //计算剩余的毫秒数，注意月分是从0开始的(11表示12月份)
        var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);//计算剩余的天数
        var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);//计算剩余的小时数
        var mm = parseInt(ts / 1000 / 60 % 60, 10);//计算剩余的分钟数
        var ss = parseInt(ts / 1000 % 60, 10);//计算剩余的秒数
        dd = checkTime(dd);
        hh = checkTime(hh);
        mm = checkTime(mm);
        ss = checkTime(ss);
        document.getElementById("timer").innerHTML = dd + "天" + hh + "时" + mm + "分" + ss + "秒";
        //setInterval("timer()",1000);
        setTimeout("timer()",1000);
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

    $(function(){
        timer()
    })
</script>
</body>
</html>
