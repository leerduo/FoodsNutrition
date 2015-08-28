package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.RequestQueue;

public class Volley
{
  public static RequestQueue a(Context paramContext)
  {
    return a(paramContext, null);
  }
  
  /* Error */
  public static RequestQueue a(Context paramContext, HttpStack paramHttpStack)
  {
    // Byte code:
    //   0: new 13	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 19	android/content/Context:getCacheDir	()Ljava/io/File;
    //   8: ldc 21
    //   10: invokespecial 25	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore_2
    //   14: ldc 27
    //   16: astore_3
    //   17: aload_0
    //   18: invokevirtual 31	android/content/Context:getPackageName	()Ljava/lang/String;
    //   21: astore 7
    //   23: aload_0
    //   24: invokevirtual 35	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   27: aload 7
    //   29: iconst_0
    //   30: invokevirtual 41	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: astore 8
    //   35: new 43	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   42: aload 7
    //   44: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 52
    //   49: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 8
    //   54: getfield 58	android/content/pm/PackageInfo:versionCode	I
    //   57: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 9
    //   65: aload 9
    //   67: astore_3
    //   68: aload_1
    //   69: ifnonnull +19 -> 88
    //   72: getstatic 69	android/os/Build$VERSION:SDK_INT	I
    //   75: bipush 9
    //   77: if_icmplt +48 -> 125
    //   80: new 71	com/android/volley/toolbox/HurlStack
    //   83: dup
    //   84: invokespecial 72	com/android/volley/toolbox/HurlStack:<init>	()V
    //   87: astore_1
    //   88: new 74	com/android/volley/toolbox/BasicNetwork
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 77	com/android/volley/toolbox/BasicNetwork:<init>	(Lcom/android/volley/toolbox/HttpStack;)V
    //   96: astore 5
    //   98: new 79	com/android/volley/RequestQueue
    //   101: dup
    //   102: new 81	com/android/volley/toolbox/DiskBasedCache
    //   105: dup
    //   106: aload_2
    //   107: invokespecial 84	com/android/volley/toolbox/DiskBasedCache:<init>	(Ljava/io/File;)V
    //   110: aload 5
    //   112: invokespecial 87	com/android/volley/RequestQueue:<init>	(Lcom/android/volley/Cache;Lcom/android/volley/Network;)V
    //   115: astore 6
    //   117: aload 6
    //   119: invokevirtual 89	com/android/volley/RequestQueue:a	()V
    //   122: aload 6
    //   124: areturn
    //   125: new 91	com/android/volley/toolbox/HttpClientStack
    //   128: dup
    //   129: aload_3
    //   130: invokestatic 97	android/net/http/AndroidHttpClient:newInstance	(Ljava/lang/String;)Landroid/net/http/AndroidHttpClient;
    //   133: invokespecial 100	com/android/volley/toolbox/HttpClientStack:<init>	(Lorg/apache/http/client/HttpClient;)V
    //   136: astore_1
    //   137: goto -49 -> 88
    //   140: astore 4
    //   142: goto -74 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContext	Context
    //   0	145	1	paramHttpStack	HttpStack
    //   13	94	2	localFile	java.io.File
    //   16	114	3	localObject	Object
    //   140	1	4	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   96	15	5	localBasicNetwork	BasicNetwork
    //   115	8	6	localRequestQueue	RequestQueue
    //   21	22	7	str1	java.lang.String
    //   33	20	8	localPackageInfo	android.content.pm.PackageInfo
    //   63	3	9	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   17	65	140	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.Volley
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */