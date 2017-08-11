# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/huangtao/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#fresco 开始
-dontwarn javax.annotation.**
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}
-keepclassmembers class * {
    native <methods>;
}
#fresco 结束

#fastjson混淆 开始
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }
-keepattributes Signature
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
#fastjson混淆 结束

#eventBus 开始
-keepclassmembers class ** {
    public void onEvent*(**);
}
#eventBus 结束

#retrofit 开始
-dontwarn okio.**
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions

-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
#retrofit 结束


#okhttp3 开始
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**
#mqtt3.0 结束

#mqtt3.0 开始
-keep class org.eclipse.paho.client.mqttv3.** { *; }
#mqtt3.0 结束

#小米推送 开始
-keep class com.ht.pushlib.xiaomi.XiaomiPushReceiver {*;}
#小米推送 结束

#bean 开始
-keep class com.haodai.topadvisor.bean.** { *; }
-keep class com.ht.netlib.bean.** { *; }
#bean 结束
