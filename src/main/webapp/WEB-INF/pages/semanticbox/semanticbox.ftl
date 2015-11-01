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
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.9.1/styles/default.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/8.9.1/highlight.min.js"></script>

    <script src="https://cdn.rawgit.com/doukit/semanticbox/master/semanticbox.js"></script>
</head>
<body>

<#include "/layout/navbar.ftl"/>

<div class="ui container ak-main-container">
    <label class="ak-form-box">semanticbox.js 类似bootbox.js，只不过bootbox.js是针对bootstrap的框架,
        而semanticbox.js是针对semnatic-ui的框架.使用步骤如下：</label>
    <h4>1. 引入semanticbox.js到项目</h4>
    <pre>
        <code class="html">
            <html>
            &lt;script src="https://cdn.rawgit.com/doukit/semanticbox/master/semanticbox.js"&gt;&lt;/script&gt;
            </html>
        </code>
    </pre>

    <h4>2. 分为以下几种box</h4>
    <label>消息弹框</label>
    <button class="ui button" id="semanticboxinfo">消息</button>
</div>

<#include "/layout/copyright.ftl"/>
<script type="text/javascript">
    $(function(){
        hljs.initHighlightingOnLoad();

        $('#semanticboxinfo').on('click', function(){
            semanticbox.info("消息弹框!", function() {
                console.log("我是回调")
            });
        })
    })
</script>
</body>
</html>
