package jwplayer;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.PluginManager;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.app.Activity;

import com.pixeldog.jwplayer.JWPlayerActivity;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.os.Bundle;
import android.content.res.Resources;

@SuppressWarnings("deprecation")
public class JWPlayer extends CordovaPlugin {

    // Name of the plugin
    private final String TAG = "JWPlayer";

    private Activity activity;
    private Intent intent;
    private Context context;

    // Runs on initializing the plugin
    @Override
    public void initialize(final CordovaInterface cordova, final CordovaWebView webView) {
        super.initialize(cordova, webView);

        this.context = cordova.getActivity().getApplicationContext();
        this.intent = new Intent(this.context, JWPlayerActivity.class);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("open")) {
            this.openJWPlayer(callbackContext);
            return true;
        }

        if (action.equals("close")) {
            this.closeJWPlayer(callbackContext);
            return true;
        }

        return false;
    }

    // Opens JWPlayer
    private void openJWPlayer(CallbackContext callbackContext) {
        try {
            this.cordova.getActivity().startActivity(this.intent);
        } catch (Exception e) {
            this.showAlert("Error", "Error opening JWPlayer: " + e.getMessage());
        }
    }

    // Closes JWPlayer
    private void closeJWPlayer(CallbackContext callbackContext) {
        try {
            this.activity.finish();
        } catch (Exception e) {
            this.showAlert("Error", "Error closing JWPlayer: " + e.getMessage());
        }
    }

    // Shows an alert with an OK button
    private void showAlert(String title, String message) {
        Context context = cordova.getActivity();

        new AlertDialog.Builder(context).setTitle(title).setMessage(message)
                .setNeutralButton("OK", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    // Plugin test function
    private void echo(String message, CallbackContext callbackContext) {
        callbackContext.success("Android plugin is functional!");
    }
}
