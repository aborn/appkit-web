<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>test</title>
<#include "/common/semantic.ftl">
</head>

<body>
<#include "/layout/navbar.ftl"/>
<div class="ui container ak-main-container">
    <canvas id="myChart" width="400" height="400"></canvas>
</div>

<#include "/layout/copyright.ftl"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.0/Chart.min.js"></script>
<script type="text/javascript">

    var ctx = document.getElementById("myChart");
    $.get("/monitor/ajaxss.json", {}, function(dataRes) {
        console.log("good ajax");
        var data = {
            labels: dataRes.labels,  //["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "hit",
                    fill: false,
                    lineTension: 0.1,
                    backgroundColor: "rgba(75,192,192,0.4)",
                    borderColor: "rgba(75,192,192,1)",
                    borderCapStyle: 'butt',
                    borderDash: [],
                    borderDashOffset: 0.0,
                    borderJoinStyle: 'miter',
                    pointBorderColor: "rgba(75,192,192,1)",
                    pointBackgroundColor: "#fff",
                    pointBorderWidth: 1,
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: "rgba(75,192,192,1)",
                    pointHoverBorderColor: "rgba(220,220,220,1)",
                    pointHoverBorderWidth: 2,
                    pointRadius: 1,
                    pointHitRadius: 10,
                    data: dataRes.data
                }
            ]
        };

        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: data
        });
    })
</script>
</body>
</html>
