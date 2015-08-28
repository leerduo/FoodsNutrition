package com.xiaomi.mipush.sdk;

import android.content.Context;

final class b
  implements Runnable
{
  b(Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/xiaomi/mipush/sdk/b:a	Landroid/content/Context;
    //   4: invokestatic 25	com/xiaomi/mipush/sdk/MiPushClient:a	(Landroid/content/Context;)Z
    //   7: ifne +210 -> 217
    //   10: iconst_1
    //   11: aload_0
    //   12: getfield 12	com/xiaomi/mipush/sdk/b:a	Landroid/content/Context;
    //   15: invokestatic 30	com/xiaomi/mipush/sdk/a:a	(Landroid/content/Context;)Lcom/xiaomi/mipush/sdk/a;
    //   18: invokevirtual 34	com/xiaomi/mipush/sdk/a:m	()I
    //   21: if_icmpne +196 -> 217
    //   24: aload_0
    //   25: getfield 12	com/xiaomi/mipush/sdk/b:a	Landroid/content/Context;
    //   28: invokevirtual 40	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   31: iconst_4
    //   32: invokevirtual 46	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +180 -> 217
    //   40: aload_2
    //   41: invokeinterface 52 1 0
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 58 1 0
    //   53: ifeq +164 -> 217
    //   56: aload_3
    //   57: invokeinterface 62 1 0
    //   62: checkcast 64	android/content/pm/PackageInfo
    //   65: getfield 68	android/content/pm/PackageInfo:services	[Landroid/content/pm/ServiceInfo;
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull -25 -> 47
    //   75: aload 4
    //   77: arraylength
    //   78: istore 5
    //   80: iconst_0
    //   81: istore 6
    //   83: iload 6
    //   85: iload 5
    //   87: if_icmpge -40 -> 47
    //   90: aload 4
    //   92: iload 6
    //   94: aaload
    //   95: astore 7
    //   97: aload 7
    //   99: getfield 74	android/content/pm/ServiceInfo:exported	Z
    //   102: ifeq +108 -> 210
    //   105: aload 7
    //   107: getfield 77	android/content/pm/ServiceInfo:enabled	Z
    //   110: ifeq +100 -> 210
    //   113: ldc 79
    //   115: aload 7
    //   117: getfield 83	android/content/pm/ServiceInfo:name	Ljava/lang/String;
    //   120: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifeq +87 -> 210
    //   126: aload_0
    //   127: getfield 12	com/xiaomi/mipush/sdk/b:a	Landroid/content/Context;
    //   130: invokevirtual 93	android/content/Context:getPackageName	()Ljava/lang/String;
    //   133: aload 7
    //   135: getfield 96	android/content/pm/ServiceInfo:packageName	Ljava/lang/String;
    //   138: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: istore 8
    //   143: iload 8
    //   145: ifne +65 -> 210
    //   148: ldc2_w 97
    //   151: ldc2_w 99
    //   154: ldc2_w 101
    //   157: invokestatic 108	java/lang/Math:random	()D
    //   160: dmul
    //   161: dadd
    //   162: d2l
    //   163: lmul
    //   164: invokestatic 114	java/lang/Thread:sleep	(J)V
    //   167: new 116	android/content/Intent
    //   170: dup
    //   171: invokespecial 117	android/content/Intent:<init>	()V
    //   174: astore 10
    //   176: aload 10
    //   178: aload 7
    //   180: getfield 96	android/content/pm/ServiceInfo:packageName	Ljava/lang/String;
    //   183: aload 7
    //   185: getfield 83	android/content/pm/ServiceInfo:name	Ljava/lang/String;
    //   188: invokevirtual 121	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   191: pop
    //   192: aload 10
    //   194: ldc 123
    //   196: invokevirtual 127	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   199: pop
    //   200: aload_0
    //   201: getfield 12	com/xiaomi/mipush/sdk/b:a	Landroid/content/Context;
    //   204: aload 10
    //   206: invokevirtual 131	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   209: pop
    //   210: iinc 6 1
    //   213: goto -130 -> 83
    //   216: astore_1
    //   217: return
    //   218: astore 9
    //   220: goto -53 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	b
    //   216	1	1	localThrowable	java.lang.Throwable
    //   35	6	2	localList	java.util.List
    //   46	11	3	localIterator	java.util.Iterator
    //   68	23	4	arrayOfServiceInfo	android.content.pm.ServiceInfo[]
    //   78	10	5	i	int
    //   81	130	6	j	int
    //   95	89	7	localServiceInfo	android.content.pm.ServiceInfo
    //   141	3	8	bool	boolean
    //   218	1	9	localInterruptedException	java.lang.InterruptedException
    //   174	31	10	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   24	36	216	java/lang/Throwable
    //   40	47	216	java/lang/Throwable
    //   47	70	216	java/lang/Throwable
    //   75	80	216	java/lang/Throwable
    //   90	143	216	java/lang/Throwable
    //   148	167	216	java/lang/Throwable
    //   167	210	216	java/lang/Throwable
    //   148	167	218	java/lang/InterruptedException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */