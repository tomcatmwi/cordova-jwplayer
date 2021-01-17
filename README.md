# Cordova JWPlayer plugin for Android #

It doesn't seem to work though. This is more a bug report than a readme.

## Installation ##

```
cordova plugin add https://github.com/tomcatmwi/cordova-jwplayer
```

After installation add this line to your Cordova project's `config.xml`:

```
<preference name="AndroidXEnabled" value="true" />
```

Open a player with a demo video:

```
function onDeviceReady() {
    window.plugins.JWPlayer.open(
        callback => {
            console.log('Open result: ', callback);
        });
}
```

As a result, your app will crash. Hooray!

## What isn't working ##

The plugin seems to import the native Android SDK of JWPlayer correctly. It can load a playlist.

The plugin opens a native Android view. If this view contains a `com.longtailvideo.jwplayer.JWPlayerView` element, the app will crash. Without the element there's no crash, but also no video.

## Logcat error dump ##

```
2021-01-16 01:31:12.133 26962-26962/com.pixeldog.jwplayer E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.pixeldog.jwplayer, PID: 26962
    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.pixeldog.jwplayer/com.pixeldog.jwplayer.JWPlayerActivity}: android.view.InflateException: Binary XML file line #13 in com.pixeldog.jwplayer:layout/main: Binary XML file line #13 in com.pixeldog.jwplayer:layout/main: Error inflating class com.longtailvideo.jwplayer.JWPlayerView
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3449)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3601)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:85)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2066)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:223)
        at android.app.ActivityThread.main(ActivityThread.java:7656)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
     Caused by: android.view.InflateException: Binary XML file line #13 in com.pixeldog.jwplayer:layout/main: Binary XML file line #13 in com.pixeldog.jwplayer:layout/main: Error inflating class com.longtailvideo.jwplayer.JWPlayerView
     Caused by: android.view.InflateException: Binary XML file line #13 in com.pixeldog.jwplayer:layout/main: Error inflating class com.longtailvideo.jwplayer.JWPlayerView
     Caused by: java.lang.reflect.InvocationTargetException
        at java.lang.reflect.Constructor.newInstance0(Native Method)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:343)
        at android.view.LayoutInflater.createView(LayoutInflater.java:852)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:1004)
        at android.view.LayoutInflater.createViewFromTag(LayoutInflater.java:959)
        at android.view.LayoutInflater.rInflate(LayoutInflater.java:1121)
        at android.view.LayoutInflater.rInflateChildren(LayoutInflater.java:1082)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:680)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:532)
        at android.view.LayoutInflater.inflate(LayoutInflater.java:479)
        at com.android.internal.policy.PhoneWindow.setContentView(PhoneWindow.java:455)
        at android.app.Activity.setContentView(Activity.java:3468)
        at com.pixeldog.jwplayer.JWPlayerActivity.onCreate(JWPlayerActivity.java:21)
        at android.app.Activity.performCreate(Activity.java:8000)
        at android.app.Activity.performCreate(Activity.java:7984)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1309)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3422)
        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3601)
        at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:85)
        at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:135)
        at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:95)
        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2066)
        at android.os.Handler.dispatchMessage(Handler.java:106)
        at android.os.Looper.loop(Looper.java:223)
        at android.app.ActivityThread.main(ActivityThread.java:7656)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)
     Caused by: java.lang.NoClassDefFoundError: Failed resolution of: Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
        at com.longtailvideo.jwplayer.cast.e.a(SourceFile:16)
        at com.longtailvideo.jwplayer.core.u.a(SourceFile:173)
        at com.longtailvideo.jwplayer.JWPlayerView.a(SourceFile:360)
2021-01-16 01:31:12.133 26962-26962/com.pixeldog.jwplayer E/AndroidRuntime:     at com.longtailvideo.jwplayer.JWPlayerView.<init>(SourceFile:253)
        	... 28 more
     Caused by: java.lang.ClassNotFoundException: Didn't find class "com.google.android.gms.common.GoogleApiAvailabilityLight" on path: DexPathList[[zip file "/data/app/~~f07u-lJgkXR6nQaBq4TM3w==/com.pixeldog.jwplayer-C-Y_726nY9YvAYMRR-9h-g==/base.apk"],nativeLibraryDirectories=[/data/app/~~f07u-lJgkXR6nQaBq4TM3w==/com.pixeldog.jwplayer-C-Y_726nY9YvAYMRR-9h-g==/lib/arm64, /system/lib64, /system/product/lib64]]
        at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:207)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
        	... 32 more
```
