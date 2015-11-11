<!DOCTYPE html>
<#include "/layout/pageUtilSemantic.ftl" />
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>appkit</title>
    <link rel="stylesheet" type="text/css" href="/thirdpart/gridster.js-0.5.6/dist/jquery.gridster.css">
    <link rel="stylesheet" type="text/css" href="/thirdpart/gridster.js-0.5.6/demo/demo.css">
<#include "/common/semantic.ftl"/>
</head>

<body>
<#include "/layout/navbar.ftl"/>

<div class="ui container ak-main-container">
    <div class="ak-search-box">
        <div style="margin-bottom: 15px;">

            <div class="inline fields">
                <div class="ten wide column">
                    <label class="ak-form-default">这只是一个demo</label>
                    <button class="ui button green" id="addWidget">add+</button>

                    <select name="layoutSelect" class="ui dropdown ak-dropdown" id="layoutSelect">
                    <#if (selectLayouts?? && selectLayouts?size > 0)>
                        <#list selectLayouts as item>
                            <option value="${item.value}">${item.desc}</option>
                        </#list>
                    </#if>
                    </select>

                    <button class="ui button gray" id="showLayout">show</button>
                </div>
            </div>

        </div>
    </div>

    <div class="gridster">
        <ul></ul>
    </div>

    <div style="margin-top: 15px;">
        <div class="ui input">
            <input type="text" placeholder="输入layout名字" name="layoutName" id="layoutName" required>
        </div>
        <button class="ui button teal" id="saveLayout">保存</button>
    </div>
</div>

<script src="/thirdpart/gridster.js-0.5.6/dist/jquery.gridster.js"></script>
<script src="/thirdpart/gridster.js-0.5.6/dist/jquery.gridster.with-extras.js"></script>
<script src="/assets/js/appkit.js"></script>
<script src="/assets/js/semanticbox.js"></script>

<script type="text/javascript">
    var gridster;
    $(function(){
        gridster = $(".gridster > ul").gridster({
            widget_margins: [5, 5],
            widget_base_dimensions: [100, 55],
            resize: {
                enabled: true
            },
        serialize_params:  function($w, wgd) {
            return { col: wgd.col, row: wgd.row, size_x: wgd.size_x, size_y: wgd.size_y, number:wgd.number} }
        }).data('gridster');

        var widgets = [
            /*['<li>0</li>', 1, 2],
            ['<li>1</li>', 3, 2],
            ['<li>2</li>', 3, 2],
            ['<li>3</li>', 2, 1],
            ['<li>4</li>', 4, 1],
            ['<li>5</li>', 1, 2],
            ['<li>6</li>', 2, 1],
            ['<li>7</li>', 3, 2],
            ['<li>8</li>', 1, 1],
            ['<li>9</li>', 2, 2],
            ['<li>10</li>', 1, 3]*/
        ];

        $.each(widgets, function(i, widget){
            gridster.add_widget.apply(gridster, widget)
        });

        var initialSize = 0;

        $('#addWidget').on('click', function() {
            console.log('addWidget clicked!')
            var sizeOfLayoutItem = initialSize + 1;
            var obj = gridster.add_widget('<li class="new layoutitem" data-number="'+sizeOfLayoutItem+'"><span class="ak-number-icon"><a class="ui violet circular label">'+sizeOfLayoutItem+'</a></span> <span class="ak-hidden delete-icon ak-delete-icon-pos"><i class="delete icon"></i></span> <h3>亲子</h3> <h5>送点读机</h5> <img src="http://www.dpfile.com/sc/eleconfig/20151109140555jiaoyu100x100.png"/> </li>', 2, 3);
            oneventAction();
            initialSize = initialSize + 1;
            //console.log(obj);
        })

        $('#saveLayout').on('click', function() {
            var layoutName = $('#layoutName').val();

            if (layoutName == undefined || layoutName == '') {
                semanticbox.info('请输入layout名称!');
            } else {
                console.log('save clicked!')
                var obj = gridster.serialize();

                $.ajax({
                    url: '/demo/ele/elesubmit.html',
                    type: 'POST',
                    data: {
                        layoutName: layoutName,
                        layoutValue: JSON.stringify(obj)
                    },
                    dataType: 'json',
                    success: function (data) {
                        console.log("status:" + data.status + " info:" + data.info)
                        if (data.status == 'success') {
                        } else {
                        }
                    },
                    error: function (jXHR, textStatus, errorThrown) {
                        alert(errorThrown);
                    }
                })

                console.log(JSON.stringify(obj));
            }
        })

        $('#showLayout').on('click', changeView)
        $('#layoutSelect').on('change', changeView)
    });

    // 切换到不同的layout
    var changeView = function () {
        console.log('showLayout clicked!');
        $.ajax({
            url : '/demo/ele/getlayout.gson',
            type : 'GET',
            data : {
                layoutName : $('#layoutSelect').val()
            },
            dataType : 'json',
            success : function(data) {
                console.log("status:" + data.status + " info:" + data.info)

                gridster.remove_all_widgets();
                var serialization = data.data;
                $.each(serialization, function() {
                    gridster.add_widget('<li class="new"><span class="ak-hidden delete-icon ak-delete-icon-pos"><i class="delete icon"></i></span> <h3>亲子</h3> <h5>送点读机</h5> <img src="http://www.dpfile.com/sc/eleconfig/20151109140555jiaoyu100x100.png"/> </li>', this.size_x, this.size_y, this.col, this.row);
                    oneventAction();
                });
            },
            error : function (jXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        })
    }

    var oneventAction = function () {
        $('.ak-delete-icon-pos').on('click', function(){
            gridster.remove_widget(this.parentElement, function(){
                console.log('call back')
                gridster.set_dom_grid_height();
                gridster.set_dom_grid_width();
            })
        })

        $('.new').on('mousemove', function(){
            $(this).find('.ak-delete-icon-pos').removeClass('ak-hidden')
        }).on('mouseout', function(){
            $('.ak-delete-icon-pos').addClass('ak-hidden')
        })
    }

</script>
</body>
</html>
