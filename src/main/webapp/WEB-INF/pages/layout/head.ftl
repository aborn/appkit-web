<!-- 导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand index" name="index" style="color: #ffffff; background-color: #4E464D; margin-left:0px;font-family: sans-serif;font-weight: bold" href="/"><i class="icon-home"> </i>appkit平台</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown announcement">
                    <a href="/index.html">about</a>
                </li>

                <li class="dropdown appconfig apitools indextab android scoreconfig">
                    <a class="dropdown-toggle" href="#" id="AppConfig" data-toggle="dropdown">demo
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="AppConfig">
                        <li><a href="/demo/get.html?name=%E4%B8%AD">get requset with paramter</a></li>
                        <li class="divider"></li>
                        <li><a href="/demo/demo.html/name/appkit">dynamic uri with variable</a></li>
                        <li><a href="/demo/db.html">use mysql database</a></li>
                        <li><a href="/demo/getJSON.html">get json result</a></li>
                        <li><a href="/demo/multifile/multiFilesExample.html">multi file update</a></li>
                        <li><a href="/demo/editor.html">markdown editor</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-right pull-right">
            <#if userInfo?exists && userInfo.userName ??>
                <li class="dropdown">
                    <a class="dropdown-toggle" href="#" id="userInfo" data-toggle="dropdown"><i class="icon-cog"> </i>${userInfo.userName}
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="userInfo">
                        <li><a href="#"><i class="icon-user-md"> </i>about me</a></li>
                        <li><a href="${userInfo.logout}"><i class="icon-signout"> </i>sign out</a></li>
                    </ul>
                </li>
            <#else>
                <li class="dropdown">
                    <a href="#" class="siginup">Log in</a>
                </li>
            </#if>
            </ul>

            <ul class="nav navbar-right">
                <li class="navbar-right">
                    <a href="https://github.com/aborn/appkit-web/fork"" class="brand"><i class="fa fa-code-fork"> </i> Fork</a>
                </li>
            </ul>
        </div>
    </div>
</nav>