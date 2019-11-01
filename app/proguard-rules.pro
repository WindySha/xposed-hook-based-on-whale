
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

#未混淆的类和成员
-printseeds build/outputs/mapping/seeds.txt
#列出从 apk 中删除的代码
-printusage build/outputs/mapping/unused.txt
#混淆前后的映射
-printmapping build/outputs/mapping/mapping.txt
