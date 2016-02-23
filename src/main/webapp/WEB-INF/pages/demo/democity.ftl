
<!DOCTYPE html>
<#include "/layout/pageUtilSemantic.ftl" />
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>demo modal</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/city.css">
<#include "/common/semantic.ftl"/>

</head>

<body>
<#include "/layout/navbar.ftl"/>
<#include "/common/city.ftl"/>
<div class="ui container ak-main-container">
    <form class="ui form">
        <div class="inline fields">
            <div class="ten wide field">
                <input class="ui input" type="text" placeholder="输入或者选择城市" id="cityDemoInput">
            </div>
            <button class="ui button" id="citySelectBtn">城市选择</button>
        </div>
    </form>

    <div style="max-height: 40vh; overflow-y:scroll;">
        <div class="ui demo segment" id="scroll-demo-area">
        <#list 1..2 as x>
            <div class="item">
                <div class="content">
                    <label>城市组</label>
                    <div class="description">
                        <div class="inline fileds">
                            <input type="checkbox" name="example">
                            <label class="city-item-label">国内全部</label>
                            <input type="checkbox" name="example">
                            <input type="checkbox" name="example">
                            <label class="city-item-label">海外全部</label>
                        </div>
                    </div>
                    <div class="extra">
                        <i class="green check icon"></i>
                        121 Votes
                    </div>
                </div>
            </div>
        </#list>
        </div>
    </div>

    <div class="myfeed">
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
        <li>stuff</li>
    </div>

    <form class="ui form">
        <div class="inline fields">

            <button class="ui button" id="mithrilDemoABtn">示例A</button>
            <button class="ui button" id="mithrilDemoBBtn">示例B</button>
        </div>
    </form>

    <div>
        <label>显示区A</label>
        <div id="mithrilDemoAContentArea">
        </div>
    </div>

    <div>
        <label>显示区A</label>
        <div id="mithrilDemoBContentArea">
        </div>
    </div>
</div>

<#include "/layout/copyright.ftl"/>
<script src="/assets/js/mithril.js"></script>
<script src="/assets/js/city.js"></script>

<script>
    var mithril = {};
    mithril.demoA = {};
    mithril.demoA.view = function() {
        return m("form", {class:'ui form'},
        m("div", {class:'inline fields'},
                m("input", {id:'demoAinput'})))
    }
    m.mount(document.getElementById("mithrilDemoAContentArea"), mithril.demoA);

    $('#citySelectBtn').on("click", function(e){
        e.preventDefault();
        console.log("clicked!");
        $('.cityModal').modal({
            observeChanges : false,
            closable  : true,
            onDeny    : function(){
                //window.alert('Wait not yet!');
                //return false;
            },
            onApprove : function() {
                var checkedValues = $('input[name=eachCity]:checked').map(function() {
                    return this.value;
                }).get();
                $('#cityDemoInput').val(checkedValues.join(','));
                //window.alert('Approved!');
            }
        }).modal('show');

        if ($('.cityTab.active').attr('data-tab') == 'china-city') {
            //var obj = m.mount(document.getElementById('cityTabSegment-china-city'), chinaCity)
            //console.log('initialed');
        }
    });

    $('#scroll-demo-area').visibility({
        once: false,
        // update size when new content loads
        onBottomPassed : function() {
            console.log('onBottomPassed');
        },
        onPassing : function() {
            console.log("onPassing");
        },
        onBottomVisible: function() {
            // loads a max of 5 times
            //window.loadFakeContent();
            console.log('ddd onBottomVisible')
        },
        debug : true
    });

    $('.myfeed').visibility({
        once: false,

        // update size when new content loads
        observeChanges: true,

        // load content on bottom edge visible
        onBottomVisible: function() {
            console.log("infiniateScroll ... called.");
            //alert("infiniateScroll ... called.");
        }
    });
</script>
</body>
</html>

