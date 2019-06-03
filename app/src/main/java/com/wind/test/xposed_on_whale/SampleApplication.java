package com.wind.test.xposed_on_whale;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * Created by Wind on 2019/1/18
 */
public class SampleApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        // hookActivityThread(base.getClassLoader());
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {

        hookTextView(getClassLoader());
        super.onCreate();
    }

    private void hookTextView(ClassLoader classLoader) {
        XposedHelpers.findAndHookMethod(TextView.class, "setText", CharSequence.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.e("wind", "wind -- beforeHookedMethod setText   !!!! para = " + param.args[0]);
                        param.args[0] = "hahahahhahaa";
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                    }
                });

        XposedHelpers.findAndHookMethod(Activity.class, "onResume",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.e("wind", "wind -- beforeHookedMethod onResume   !!!! para = ", new Exception("onResume"));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {

                    }
                });
    }

    public static void hookActivityThread(ClassLoader classLoader) {
        try {
            XposedHelpers.findAndHookMethod("android.app.LoadedApk", classLoader, "makeApplication", boolean.class, Instrumentation.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("wind", "wind -- beforeHookedMethod LoadedApk makeApplication  ", new Exception("makeApplication"));
                            super.beforeHookedMethod(param);
                        }
                    });

            XposedHelpers.findAndHookMethod("android.app.ActivityThread", classLoader, "main", String[].class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("wind", "wind -- beforeHookedMethod ActivityThread main object ");
                            super.beforeHookedMethod(param);
                        }
                    });


            XposedHelpers.findAndHookMethod("android.app.Instrumentation", classLoader, "newApplication", ClassLoader.class, String.class, Context.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("xia", "wind -- beforeHookedMethod ActivityThread main object = ${param?.thisObject} ");
                            super.beforeHookedMethod(param);
                        }
                    });

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
