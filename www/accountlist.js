cordova.define("cordova/plugin/accountlist",
    function(require, exports, module) {
        var exec = require("cordova/exec");

        var AccountList = function() {};

        AccountList.prototype.get = function(params, success, fail) {

            return Cordova.exec(
                function(args) {
                    success(args);
                },
                function(args) {
                    fail(args);
                },
                'AccountList', '', [params]);
        };

        var accountList = new AccountList();
        module.exports = accountList;
    });

/*
 * register plugin with Phonegap \ Cordova
 */
if (cordova.addPlugin) {
    cordova.addConstructor(function() {
        //Register the javascript plugin with Cordova
        cordova.addPlugin('AccountList', new AccountList());
    });
} else {
    if (!window.plugins) {
        window.plugins = {};
    }
    if (!window.plugins.AccountList) {
        window.plugins.AccountList = cordova.require("cordova/plugin/accountlist");
    }

}
