<!DOCTYPE html>
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel='shortcut icon' type='image/x-icon' href='/assets/image/favicon.ico' />
    <title>appkit</title>
    <!-- Site Properities -->

    <style>
        #filelist {
            margin-top: 15px;
        }

        #uploadFilesButtonContainer, #selectFilesButtonContainer, #overallProgress {
            display: inline-block;
        }

        #overallProgress {
            float: right;
        }
    </style>

    <!-- Generic page styles -->
    <link rel="stylesheet" href="/bootstrap/jQuery-File-Upload-9.10.4/css/style.css">
    <!-- blueimp Gallery styles -->
    <link rel="stylesheet" href="//blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
    <!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
    <link rel="stylesheet" href="/bootstrap/jQuery-File-Upload-9.10.4/css/jquery.fileupload.css">
    <link rel="stylesheet" href="/bootstrap/jQuery-File-Upload-9.10.4/css/jquery.fileupload-ui.css">
<#include "/common/semantic.ftl">
</head>

<body>
<#include "/layout/navbar.ftl"/>
<div class="ui container ak-main-container">
    <div class="container list-container">
        <!--api config列表显示-->
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4>多文件上传举例</h4>
            </div>

            <div class="panel panel-body">

            </div>
        </div>

        <label style="color: red">
        ${searchMapVo.info}
        </label>
        <div class="row">
            <div id="uploaderContainer">
                <div id="selectFilesButtonContainer">
                </div>
                <div id="uploadFilesButtonContainer">
                    <button type="button" id="uploadFilesButton"
                            class="ui primary button" style="width:250px; height:35px;">上传</button>
                </div>
                <div id="overallProgress">
                </div>
            </div>
        </div>
        <div>
            <div id="filelist">
                <table id="filenames" class="table table-hover table-bordered table-center">
                    <thead>
                    <tr><th>File name</th><th>File size</th><th>Percent uploaded</th></tr>
                    <tr id="nofiles">
                        <td colspan="3">
                            No files have been selected.
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>

        <form id="fileupload" action="/demo/multifile/ajaxFilesUpload.html" method="POST" enctype="multipart/form-data">
            <div class="row fileupload-buttonbar">
                <div class="col-lg-7">
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
                    <input type="file" name="files[]" multiple>
                </span>
                    <button type="submit" class="btn btn-primary start">
                        <i class="glyphicon glyphicon-upload"></i>
                        <span>Start upload</span>
                    </button>
                    <button type="reset" class="btn btn-warning cancel">
                        <i class="glyphicon glyphicon-ban-circle"></i>
                        <span>Cancel upload</span>
                    </button>
                    <button type="button" class="btn btn-danger delete">
                        <i class="glyphicon glyphicon-trash"></i>
                        <span>Delete</span>
                    </button>
                    <span class="fileupload-process"></span>
                </div>

                <div class="col-lg-5 fileupload-progress fade">
                    <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                        <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                    </div>
                    <div class="progress-extended">&nbsp;</div>
                </div>
            </div>
            <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
        </form>
    </div>
</div>

<#include "/layout/copyright.ftl"/>
<#include "/common/appkit-file-upload.ftl" />
<script src="http://yui.yahooapis.com/3.18.1/build/yui/yui-min.js"></script>
<!-- The template to display files available for upload -->

<script type="text/javascript">

    YUI({filter:"raw"}).use("uploader", function(Y) {
        Y.one("#overallProgress").set("text", "Uploader type: " + Y.Uploader.TYPE);
        if (Y.Uploader.TYPE != "none" && !Y.UA.ios) {
            var uploader = new Y.Uploader({width: "250px",
                height: "35px",
                multipleFiles: true,
                swfURL: "flashuploader.swf?t=" + Math.random(),
                uploadURL: "/eleconfig/appskin/ajaxFilesUpload.html",
                simLimit: 2,
                withCredentials: false
            });
            var uploadDone = false;

            uploader.render("#selectFilesButtonContainer");

            uploader.after("fileselect", function (event) {

                var fileList = event.fileList;
                var fileTable = Y.one("#filenames tbody");
                if (fileList.length > 0 && Y.one("#nofiles")) {
                    Y.one("#nofiles").remove();
                }

                if (uploadDone) {
                    uploadDone = false;
                    fileTable.setHTML("");
                }

                Y.each(fileList, function (fileInstance) {
                    fileTable.append("<tr id='" + fileInstance.get("id") + "_row" + "'>" +
                            "<td class='filename'>" + fileInstance.get("name") + "</td>" +
                            "<td class='filesize'>" + fileInstance.get("size") + "</td>" +
                            "<td class='percentdone'>Hasn't started yet</td>");
                });
            });

            uploader.on("uploadprogress", function (event) {
                var fileRow = Y.one("#" + event.file.get("id") + "_row");
                fileRow.one(".percentdone").set("text", event.percentLoaded + "%");
            });

            uploader.on("uploadstart", function (event) {
                uploader.set("enabled", false);
                Y.one("#uploadFilesButton").addClass("yui3-button-disabled");
                Y.one("#uploadFilesButton").detach("click");
            });

            uploader.on("uploadcomplete", function (event) {
                var fileRow = Y.one("#" + event.file.get("id") + "_row");
                fileRow.one(".percentdone").set("text", "Finished!");
            });

            uploader.on("totaluploadprogress", function (event) {
                Y.one("#overallProgress").setHTML("Total uploaded: <strong>" + event.percentLoaded + "%" + "</strong>");
            });

            uploader.on("alluploadscomplete", function (event) {
                uploader.set("enabled", true);
                uploader.set("fileList", []);
                Y.one("#uploadFilesButton").removeClass("yui3-button-disabled");
                Y.one("#uploadFilesButton").on("click", function () {
                    if (!uploadDone && uploader.get("fileList").length > 0) {
                        uploader.uploadAll();
                    }
                });
                Y.one("#overallProgress").set("text", "Uploads complete!");
                uploadDone = true;
            });

            Y.one("#uploadFilesButton").on("click", function () {
                if (!uploadDone && uploader.get("fileList").length > 0) {
                    uploader.uploadAll();
                }
            });
        } else {
            Y.one("#uploaderContainer").set("text", "We are sorry, but to use the uploader, you either need a browser that support HTML5 or have the Flash player installed on your computer.");
        }


    });
</script>
</body>
</html>
