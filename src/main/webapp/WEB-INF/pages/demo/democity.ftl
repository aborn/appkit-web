
<!DOCTYPE html>
<#include "/layout/pageUtilSemantic.ftl" />
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>demo modal</title>
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
</div>

<#include "/layout/copyright.ftl"/>
<script src="/assets/js/city.js"></script>

<script>
    $('#citySelectBtn').on("click", function(e){
        e.preventDefault();
        console.log("clicked!");
        $('.cityModal').modal({
            observeChanges : false,
            closable  : false,
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
    })


</script>
</body>
</html>

