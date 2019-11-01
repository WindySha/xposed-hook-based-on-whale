[ ![Download](https://api.bintray.com/packages/windysha/maven/xposed-on-whale/images/download.svg?version=0.1.1) ](https://bintray.com/windysha/maven/xposed-on-whale/0.1.1/link)

# Introduction
This is a lib to used for hook any android java codes by  xposed api. It is based on the [*whale*](https://github.com/asLody/whale
) art hooking framwork. This is supported on android 5.0 to android 9.0 android system.

# Usage
**gradle**
```
implementation 'com.wind.xposed:xposed-on-whale:0.1.2'
```  
**maven**
```
<dependency>
	<groupId>com.wind.xposed</groupId>
	<artifactId>xposed-on-whale</artifactId>
	<version>0.1.2</version>
	<type>pom</type>
</dependency>
```
# Api
All the api are the same as the xposed framewortk api.
eg: 
```
XposedHelpers.findAndHookMethod(Class<?> clazz, String methodName, Object... parameterTypesAndCallback)  

XposedHelpers.findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback)  

XposedBridge.hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback)  

XposedBridge.hookAllConstructors(Class<?> hookClass, XC_MethodHook callback)

```

# Proguard
```
-keep class de.robv.android.xposed.**{*;}
-keep class com.lody.whale.**{*;}
-keep class com.lody.whale.WhaleRuntime{
  *;
  private *;
  public *;
  native <methods>;
}

-keepclasseswithmembers class * {
    native <methods>;
}
```

# Thanks
[XposedBridge](https://github.com/rovo89/XposedBridge)  
[whale](https://github.com/asLody/whale)  
[bintray-release](https://github.com/novoda/bintray-release)  

