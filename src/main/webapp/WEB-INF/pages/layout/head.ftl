<!-- 导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand index" name="index"  href="/index.html"><i class="icon-home"> </i>appkit</a>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="dropdown announcement">
                <a href="/index.html">homepage</a>
            </li>

            <li class="dropdown appconfig apitools indextab android scoreconfig">
                <a class="dropdown-toggle" href="#" id="AppConfig" data-toggle="dropdown">demo
                    <span class="caret"></span>
                </a>

                <ul class="dropdown-menu" aria-labelledby="AppConfig">
                    <li><a href="/demo/get.html?name=%E4%B8%AD">demo paramter</a></li>
                    <li class="divider"></li>
                    <li><a href="/demo/demo.html/cityid/1/name/appkit">dynamic uri</a></li>
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
            <a href="#" calss="brand">NULL</a>
        </#if>
        </ul>

        <ul class="nav pull-right navbar-right">
            <li class="navbar-right">
                <a href="#"" class="brand">others</a>
            </li>
        </ul>

    </div>
</nav>