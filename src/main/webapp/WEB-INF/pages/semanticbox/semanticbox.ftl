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
    <label class="ak-form-box">semanticbox.js 类似<a href="http://bootboxjs.com/" target="_blank"> bootbox.js</a>，只不过bootbox.js是针对bootstrap的框架,
        而semanticbox.js是针对<a href="http://semantic-ui.com/" target="_blank"> semnatic-ui</a>的框架.<br/>使用步骤如下：</label>
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
    <label>代码如下：</label>
    <pre>
        <code class="javascript">
            $('#semanticboxinfo').on('click', function() {
                semanticbox.info("消息弹框!", function() {
                console.log("我是回调")
                });
            })
        </code>
    </pre>

    <label>confirm确认弹框</label>
    <button class="ui button" id="semanticboxconfirm">确认</button>
    <label>代码如下：</label>
    <pre>
        <code class="javascript">
            $('#semanticboxconfirm').on('click', function() {
                semanticbox.confirm("确定要提交注册？", function(result) {
                    if (result) {
                        console.log("用户点击了确定")
                    } else {
                        console.log("用户点击了取消")
                    }
                })
            })
        </code>
    </pre>
</div>

<#include "/layout/copyright.ftl"/>
<script type="text/javascript">
    $(function(){
        hljs.initHighlightingOnLoad();

        $('#semanticboxinfo').on('click', function() {
            semanticbox.info("消息弹框!", function() {
                console.log("我是回调")
            });
        })

        $('#semanticboxconfirm').on('click', function() {
            semanticbox.confirm("确定要提交注册？", function(result) {
                if (result) {
                    console.log("用户点击了确定")
                } else {
                    console.log("用户点击了取消")
                }
            })
        })
    })
</script>
</body>
</html>
