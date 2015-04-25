<html>
<head>
    <meta charset="UTF-8">
    <title>demo</title>
<#include "/common/common-css.ftl" />
</head>
<body>
<div>
<#include "/layout/head.ftl" />
    <div class="container list-container">
        <div class="panel panel-info">
            <div class="panel panel-heading">
                <h4>chosen</h4>
            </div>

            <div class="panel panel-body">

                <form method="post" action="/demo/chosen.html" id="chosenForm">
                    <lable class="control-label pull-left">scene:</lable>
                    <div class="col-md-3">
                        <em>城市选择</em>
                        <select name="cityChosen" data-placeholder="请选择城市" style="width:120px;" class="chosen-select" id="eleScene" multiple tabindex="5">
                            <option value="" ></option>
                            <option value="北京">北京</option>
                            <option value="1">上海</option>
                            <option value="广州">广州</option>
                            <option value="上123">上123</option>
                            <option value="苏州">苏州</option>
                        </select>
                    </div>
                </form>

                <div class="side-by-side clearfix">
                    <div>
                        <em>Single Select with Groups</em>
                        <select data-placeholder="Your Favorite Football Team" style="width:350px;" class="chosen-select" tabindex="5">
                            <option value=""></option>
                            <optgroup label="NFC EAST">
                                <option>Dallas Cowboys</option>
                                <option>New York Giants</option>
                                <option>Philadelphia Eagles</option>
                                <option>Washington Redskins</option>
                            </optgroup>
                            <optgroup label="NFC NORTH">
                                <option>Chicago Bears</option>
                                <option>Detroit Lions</option>
                                <option>Green Bay Packers</option>
                                <option>Minnesota Vikings</option>
                            </optgroup>
                            <optgroup label="NFC SOUTH">
                                <option>Atlanta Falcons</option>
                                <option>Carolina Panthers</option>
                                <option>New Orleans Saints</option>
                                <option>Tampa Bay Buccaneers</option>
                            </optgroup>
                            <optgroup label="NFC WEST">
                                <option>Arizona Cardinals</option>
                                <option>St. Louis Rams</option>
                                <option>San Francisco 49ers</option>
                                <option>Seattle Seahawks</option>
                            </optgroup>
                            <optgroup label="AFC EAST">
                                <option>Buffalo Bills</option>
                                <option>Miami Dolphins</option>
                                <option>New England Patriots</option>
                                <option>New York Jets</option>
                            </optgroup>
                            <optgroup label="AFC NORTH">
                                <option>Baltimore Ravens</option>
                                <option>Cincinnati Bengals</option>
                                <option>Cleveland Browns</option>
                                <option>Pittsburgh Steelers</option>
                            </optgroup>
                            <optgroup label="AFC SOUTH">
                                <option>Houston Texans</option>
                                <option>Indianapolis Colts</option>
                                <option>Jacksonville Jaguars</option>
                                <option>Tennessee Titans</option>
                            </optgroup>
                            <optgroup label="AFC WEST">
                                <option>Denver Broncos</option>
                                <option>Kansas City Chiefs</option>
                                <option>Oakland Raiders</option>
                                <option>San Diego Chargers</option>
                            </optgroup>
                        </select>
                    </div>
                    <div>
                        <em>Multiple Select with Groups</em>
                        <select data-placeholder="Your Favorite Football Team" style="width:350px;" class="chosen-select" multiple tabindex="6">
                            <option value=""></option>
                            <optgroup label="NFC EAST">
                                <option>Dallas Cowboys</option>
                                <option>New York Giants</option>
                                <option>Philadelphia Eagles</option>
                                <option>Washington Redskins</option>
                            </optgroup>
                            <optgroup label="NFC NORTH">
                                <option>Chicago Bears</option>
                                <option>Detroit Lions</option>
                                <option>Green Bay Packers</option>
                                <option>Minnesota Vikings</option>
                            </optgroup>
                            <optgroup label="NFC SOUTH">
                                <option>Atlanta Falcons</option>
                                <option>Carolina Panthers</option>
                                <option>New Orleans Saints</option>
                                <option>Tampa Bay Buccaneers</option>
                            </optgroup>
                            <optgroup label="NFC WEST">
                                <option>Arizona Cardinals</option>
                                <option>St. Louis Rams</option>
                                <option>San Francisco 49ers</option>
                                <option>Seattle Seahawks</option>
                            </optgroup>
                            <optgroup label="AFC EAST">
                                <option>Buffalo Bills</option>
                                <option>Miami Dolphins</option>
                                <option>New England Patriots</option>
                                <option>New York Jets</option>
                            </optgroup>
                            <optgroup label="AFC NORTH">
                                <option>Baltimore Ravens</option>
                                <option>Cincinnati Bengals</option>
                                <option>Cleveland Browns</option>
                                <option>Pittsburgh Steelers</option>
                            </optgroup>
                            <optgroup label="AFC SOUTH">
                                <option>Houston Texans</option>
                                <option>Indianapolis Colts</option>
                                <option>Jacksonville Jaguars</option>
                                <option>Tennessee Titans</option>
                            </optgroup>
                            <optgroup label="AFC WEST">
                                <option>Denver Broncos</option>
                                <option>Kansas City Chiefs</option>
                                <option>Oakland Raiders</option>
                                <option>San Diego Chargers</option>
                            </optgroup>
                        </select>
                    </div>
                </div>
            </div>
        </div>


        <div class="panel panel-default">
        </div>
    </div>
</div>

<#include "/layout/foot.ftl" />
<#include "/common/common-js.ftl" />
<script src="/resources/chosen/chosen.jquery.js" type="text/javascript"></script>
<script src="/resources/js/pinyin.js" type="text/javascript"></script>
<script type="text/javascript">
    //$('.chosen-select').chosen();
    $(".chosen-select").chosen({no_results_text: "没找到啦",
        max_selected_options: 5,
    disable_search_threshold: 5,      // 少于这个数则不显示搜索框
        search_contains: true
    });

    /*
    $(function () {
        $('#chosenForm').change(function(data) {
            $('#chosenForm').submit();
        });
    });
    */
</script>

</body>
</html>
