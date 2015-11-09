
// semanticbox like bootbox
// semanticbox是为semantic ui定制的，类似bootbox
// by guobao.jiang

(function (root, factory) {

    "use strict";
    if (typeof define === "function" && define.amd) {
        // AMD. Register as an anonymous module.
        define(["jquery"], factory);
    } else if (typeof exports === "object") {
        // Node. Does not work with strict CommonJS, but
        // only CommonJS-like environments that support module.exports,
        // like Node.
        module.exports = factory(require("jquery"));
    } else {
        // Browser globals (root is window)
        root.semanticbox = factory(root.jQuery);
    }

}(this, function init($, undefined) {
    var exports = {};

    var templates = {
        confirm: "<div class='ui small modal ak-confirm'>" +
        "<div class='header'></div>" +
        "<div class='content'>" +
        "<p></p>" +
        "</div>" +
        "<div class='actions'>" +
        "<button class='ui approve green button'>确定</button>" +
        "<button class='ui cancel button'>取消</button>" +
        "</div> " +
        "</div> ",
        info: "<div class='ui small modal ak-confirm'>" +
        "<div class='content'>" +
        "<p></p>" +
        "</div>" +
        "<div class='actions'>" +
        "<button class='ui ok green button'>确定</button>" +
        "</div> " +
        "</div> "
    };

    function processCallback(e, dialog, callback) {
        e.stopPropagation();
        e.preventDefault();

        // by default we assume a callback will get rid of the dialog,
        // although it is given the opportunity to override this

        // so, if the callback can be invoked and it *explicitly returns false*
        // then we'll set a flag to keep the dialog active...
        var preserveDialog = $.isFunction(callback) && callback.call(dialog, e) === false;

        // ... otherwise we'll bin it
        if (!preserveDialog) {
            dialog.modal("hide");
        }
    }

    exports.debug = function () {
        console.log('only for debug');
    }

    // 第一个参数为 options, 第二个参数为 callback
    function buildoptions (args) {
        var argn = args.length;
        var first = args[0];

        var options = {};
        // 如果传的是字符串
        if ((first instanceof  String) || (typeof first).toLowerCase() === 'string') {
            options.content = first;
            options.header = "消息";
        } else if (typeof first === 'object' && first.content != undefined) {
            options.content = first.content;
            if (first.header != undefined && first.header != null) {
                options.header = first.header;
            } else {
                options.header = "消息";
            }
            options.debug = first.debug;

            if (first.callback != undefined && first.callback != null && $.isFunction(first.callback) ) {
                options.callback = first.callback;
            }
        } else {
            throw new Error("Please supply an object of options or string.");
        }

        // 看下是否有两个参数
        if ((options.callback == undefined || options.callback == null) && argn >= 2) {
            options.callback = args[1];
        }

        return options;
    }

    exports.info = function () {
        var options = buildoptions(arguments)
        var info = options.content;
        var infoDialog = $(templates.info);
        infoDialog.find(".content p").html(info);
        infoDialog.modal("show");

        infoDialog.on("click", ".actions .ok", function(e){
            if (options.debug) {
                console.log("确定 被选中!");
            }
            processCallback(e, infoDialog, options.callback);
        })
    }

    exports.confirm = function () {
        var options = buildoptions(arguments);
        var header = options.header;
        var content = options.content;
        var callback = options.callback;
        var debug = options.debug;

        var confirmDialog = $(templates.confirm);
        confirmDialog.find(".header").html("<i class='warning sign icon'></i>" + header);
        confirmDialog.find(".content p").html(content);
        confirmDialog.modal('show');

        confirmDialog.on("click", ".actions .approve", function(e){
            if (debug) {
                console.log("确定 被选中!");
            }
            processCallback(e, confirmDialog, callback);
        })


        confirmDialog.on("click", ".actions .cancel", function(e){
            if (debug) {
                console.log("取消 被选中!");
            }
            processCallback(e, confirmDialog, function(){})
            callback.call(this, false);
        })
    }

    exports.init = function(_$) {
        return init(_$ || $);
    };

    return exports;
}))