<div class="ui main fixed inverted menu" style="background-color: #222">
    <div class="ui container">
        <div href="#" class="item">
            <img class="logo ak-logo" src="/assets/image/favicon.ico">
            <a href="/index.html" class="ak-index-name">appkit-web</a>
        </div>

        <div class="ui simple dropdown item">
            <div>demo<i class="dropdown icon"></i></div>
            <div class="menu" style="background-color: #767676">
                <a class="item" href="/demo/get.html?name=%E4%B8%AD" class="menu-item"><span style="color: white">get requset with paramter</span></a>
                <div class="divider"></div>
                <a class="item" href="/demo/demo.html/name/appkit" class="menu-item"><span style="color: white">dynamic uri with variable</span></a>
                <a class="item" href="/demo/db.html" class="menu-item"><span style="color: white">use mysql database</span></a>
                <a class="item" href="/demo/getJSON.html" class="menu-item"><span style="color: white">get json result</span></a>
                <a class="item" href="/demo/multifile/multiFilesExample.html" class="menu-item"><span style="color: white">multi file update</span></a>
                <a class="item" href="/demo/editor.html" class="menu-item"><span style="color: white">markdown editor</span></a>
                <a class="item" href="/demo/democity.html" class="menu-item"><span style="color: white">demo modal</span></a>
            </div>
        </div>

        <a href="/semantic/index.html" class="item">semantic</a>
        <a href="/semanticbox/index.html" class="item">semanticbox</a>

        <a href="https://github.com/aborn/appkit-web/fork" class="item" target="_blank"><i class="fork icon"> </i>Fork</a>

        <div class="ui right simple dropdown item">
        <#if userInfo?exists && userInfo.userName ??>
            <div class="user-dropdown" style="color:#777"><i class="setting icon"></i>${userInfo.userName}<i class="dropdown icon"></i></div>
            <div class="menu" style="background-color: #767676">
                <a class="item" href="#" class="menu-item"><i class="user icon"></i>个人信息</a>
                <a class="item" href="/logout" class="menu-item"><i class="sign out icon"></i>退出</a>
            </div>
        <#else>
            <div class="user-dropdown"><i class="setting icon"></i>未登录</div>
        </#if>
        </div>


    </div>
</div>