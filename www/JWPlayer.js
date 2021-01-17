var exec = require('cordova/exec');

const PLUGIN_NAME = 'JWPlayer';

exports.echo = function (arg0, success, error) {
    exec(
        success,                //  success callback, passed by the app
        error,                  //  error callback, passed by the app
        PLUGIN_NAME,            //  name of the plugin
        'echo',                 //  native method to call
        [arg0]                  //  parameters passed to the native method
    );
};

//  Open the video player
exports.open = function (arg0, success, error) { exec(success, error, PLUGIN_NAME, 'open', [arg0]) };

//  Close the video player
exports.close = function (arg0, success, error) { exec(success, error, PLUGIN_NAME, 'close', [arg0]) };


