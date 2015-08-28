package com.umeng.update;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.umeng.update.net.j;
import java.io.File;
import java.io.IOException;
import u.upd.a;
import u.upd.b;
import u.upd.n;

public class UmengUpdateAgent
{
  private static UmengUpdateListener a = null;
  private static UmengDialogButtonListener b = null;
  private static UmengDownloadListener c = null;
  private static Context d;
  private static c e = new c();
  private static Handler f;
  
  static void a(int paramInt, Context paramContext, UpdateResponse paramUpdateResponse, File paramFile)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (b != null) {
        b.onClick(paramInt);
      }
      return;
      a(paramContext, paramUpdateResponse, paramFile);
      continue;
      ignoreUpdate(paramContext, paramUpdateResponse);
    }
  }
  
  private static void a(Context paramContext, UpdateResponse paramUpdateResponse, File paramFile)
  {
    if (paramFile == null)
    {
      startDownload(paramContext, paramUpdateResponse);
      return;
    }
    startInstall(paramContext, paramFile);
  }
  
  private static void b(int paramInt, UpdateResponse paramUpdateResponse)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramUpdateResponse;
    f.sendMessage(localMessage);
  }
  
  private static void b(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      b.b("update", "unexpected null context in update");
      return;
    }
    catch (Exception localException)
    {
      b.b("update", "Exception occurred in Mobclick.update(). ", localException);
      return;
    }
    f = new UmengUpdateAgent.1(paramContext.getMainLooper());
    c(paramContext);
    if (!a.d(paramContext))
    {
      if (UpdateConfig.isSilentDownload())
      {
        b(2, null);
        return;
      }
      if ((UpdateConfig.isUpdateOnlyWifi()) && (!UpdateConfig.isUpdateForce()))
      {
        b(2, null);
        return;
      }
    }
    if (e.a())
    {
      b(4, null);
      b.a("update", "Is updating now.");
      f.post(new UmengUpdateAgent.2(paramContext));
      return;
    }
    d = paramContext;
    new Thread(new UmengUpdateAgent.a(paramContext.getApplicationContext())).start();
  }
  
  private static void b(Context paramContext, UpdateResponse paramUpdateResponse, int paramInt)
  {
    for (;;)
    {
      File localFile;
      try
      {
        if (isIgnore(paramContext, paramUpdateResponse)) {
          return;
        }
        localFile = downloadedFile(paramContext, paramUpdateResponse);
        if (localFile == null) {
          break label61;
        }
        bool = true;
        if (bool) {
          break label102;
        }
        if (UpdateConfig.isSilentDownload()) {
          break;
        }
      }
      catch (Exception localException)
      {
        b.b("update", "Fail to create update dialog box.", localException);
        return;
      }
      e.a(paramContext, paramUpdateResponse, bool, localFile);
      return;
      label61:
      boolean bool = false;
      continue;
      ((NotificationManager)paramContext.getSystemService("notification")).notify(0, e.b(paramContext, paramUpdateResponse, bool, localFile).a());
      return;
    }
    startDownload(paramContext, paramUpdateResponse);
    return;
    label102:
    switch (paramInt)
    {
    }
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 193	com/umeng/update/UpdateConfig:isUpdateCheck	()Z
    //   3: ifne +5 -> 8
    //   6: iconst_1
    //   7: ireturn
    //   8: new 195	java/lang/StringBuilder
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   16: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: ldc 210
    //   24: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 223	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   33: ldc 225
    //   35: invokevirtual 229	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: aconst_null
    //   39: invokevirtual 235	java/lang/reflect/Field:getBoolean	(Ljava/lang/Object;)Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq -38 -> 6
    //   47: aload_0
    //   48: invokestatic 239	com/umeng/update/UpdateConfig:getAppkey	(Landroid/content/Context;)Ljava/lang/String;
    //   51: ifnonnull +20 -> 71
    //   54: getstatic 77	com/umeng/update/UmengUpdateAgent:f	Landroid/os/Handler;
    //   57: new 241	com/umeng/update/UmengUpdateAgent$3
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 242	com/umeng/update/UmengUpdateAgent$3:<init>	(Landroid/content/Context;)V
    //   65: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   68: pop
    //   69: iconst_0
    //   70: ireturn
    //   71: aload_0
    //   72: invokevirtual 246	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   75: aload_0
    //   76: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   79: sipush 4101
    //   82: invokevirtual 252	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   85: astore 5
    //   87: aload 5
    //   89: getfield 258	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   92: astore 6
    //   94: aload 6
    //   96: ifnull +439 -> 535
    //   99: iconst_0
    //   100: istore 23
    //   102: iconst_0
    //   103: istore 4
    //   105: iload 23
    //   107: aload 5
    //   109: getfield 258	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   112: arraylength
    //   113: if_icmplt +25 -> 138
    //   116: iload 4
    //   118: ifne +53 -> 171
    //   121: getstatic 77	com/umeng/update/UmengUpdateAgent:f	Landroid/os/Handler;
    //   124: new 260	com/umeng/update/UmengUpdateAgent$4
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 261	com/umeng/update/UmengUpdateAgent$4:<init>	(Landroid/content/Context;)V
    //   132: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   135: pop
    //   136: iconst_0
    //   137: ireturn
    //   138: ldc_w 263
    //   141: aload 5
    //   143: getfield 258	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   146: iload 23
    //   148: aaload
    //   149: getfield 269	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   152: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: istore 24
    //   157: iload 24
    //   159: ifeq +6 -> 165
    //   162: iconst_1
    //   163: istore 4
    //   165: iinc 23 1
    //   168: goto -63 -> 105
    //   171: aload 5
    //   173: getfield 276	android/content/pm/PackageInfo:services	[Landroid/content/pm/ServiceInfo;
    //   176: astore 9
    //   178: aload 9
    //   180: ifnull +349 -> 529
    //   183: iconst_0
    //   184: istore 21
    //   186: iconst_0
    //   187: istore 4
    //   189: iload 21
    //   191: aload 5
    //   193: getfield 276	android/content/pm/PackageInfo:services	[Landroid/content/pm/ServiceInfo;
    //   196: arraylength
    //   197: if_icmplt +25 -> 222
    //   200: iload 4
    //   202: ifne +53 -> 255
    //   205: getstatic 77	com/umeng/update/UmengUpdateAgent:f	Landroid/os/Handler;
    //   208: new 278	com/umeng/update/UmengUpdateAgent$5
    //   211: dup
    //   212: aload_0
    //   213: invokespecial 279	com/umeng/update/UmengUpdateAgent$5:<init>	(Landroid/content/Context;)V
    //   216: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   219: pop
    //   220: iconst_0
    //   221: ireturn
    //   222: ldc_w 281
    //   225: aload 5
    //   227: getfield 276	android/content/pm/PackageInfo:services	[Landroid/content/pm/ServiceInfo;
    //   230: iload 21
    //   232: aaload
    //   233: getfield 284	android/content/pm/ServiceInfo:name	Ljava/lang/String;
    //   236: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: istore 22
    //   241: iload 22
    //   243: ifeq +6 -> 249
    //   246: iconst_1
    //   247: istore 4
    //   249: iinc 21 1
    //   252: goto -63 -> 189
    //   255: aload 5
    //   257: getfield 288	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   260: ifnull +257 -> 517
    //   263: iconst_0
    //   264: istore 11
    //   266: iconst_0
    //   267: istore 12
    //   269: iconst_0
    //   270: istore 13
    //   272: iconst_0
    //   273: istore 14
    //   275: aload 5
    //   277: getfield 288	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   280: arraylength
    //   281: istore 15
    //   283: iload 11
    //   285: iload 15
    //   287: if_icmplt +43 -> 330
    //   290: iload 14
    //   292: ifeq +111 -> 403
    //   295: iload 13
    //   297: ifeq +106 -> 403
    //   300: iload 12
    //   302: ifeq +101 -> 403
    //   305: iconst_1
    //   306: istore 4
    //   308: iload 4
    //   310: ifne +99 -> 409
    //   313: getstatic 77	com/umeng/update/UmengUpdateAgent:f	Landroid/os/Handler;
    //   316: new 290	com/umeng/update/UmengUpdateAgent$6
    //   319: dup
    //   320: aload_0
    //   321: invokespecial 291	com/umeng/update/UmengUpdateAgent$6:<init>	(Landroid/content/Context;)V
    //   324: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   327: pop
    //   328: iconst_0
    //   329: ireturn
    //   330: ldc_w 293
    //   333: aload 5
    //   335: getfield 288	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   338: iload 11
    //   340: aaload
    //   341: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +9 -> 353
    //   347: iconst_1
    //   348: istore 14
    //   350: goto +191 -> 541
    //   353: ldc_w 295
    //   356: aload 5
    //   358: getfield 288	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   361: iload 11
    //   363: aaload
    //   364: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq +9 -> 376
    //   370: iconst_1
    //   371: istore 13
    //   373: goto +168 -> 541
    //   376: ldc_w 297
    //   379: aload 5
    //   381: getfield 288	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   384: iload 11
    //   386: aaload
    //   387: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: istore 16
    //   392: iload 16
    //   394: ifeq +147 -> 541
    //   397: iconst_1
    //   398: istore 12
    //   400: goto +141 -> 541
    //   403: iconst_0
    //   404: istore 4
    //   406: goto -98 -> 308
    //   409: ldc_w 299
    //   412: aload_0
    //   413: new 195	java/lang/StringBuilder
    //   416: dup
    //   417: aload_0
    //   418: invokevirtual 199	android/content/Context:getPackageName	()Ljava/lang/String;
    //   421: invokestatic 205	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   424: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: ldc_w 301
    //   430: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 223	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   439: ldc_w 303
    //   442: invokevirtual 229	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   445: aconst_null
    //   446: invokevirtual 307	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   449: invokevirtual 311	android/content/Context:getString	(I)Ljava/lang/String;
    //   452: invokevirtual 272	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   455: istore 19
    //   457: iload 19
    //   459: ifeq +52 -> 511
    //   462: iconst_1
    //   463: istore 4
    //   465: iload 4
    //   467: ifne -461 -> 6
    //   470: getstatic 77	com/umeng/update/UmengUpdateAgent:f	Landroid/os/Handler;
    //   473: new 313	com/umeng/update/UmengUpdateAgent$7
    //   476: dup
    //   477: aload_0
    //   478: invokespecial 314	com/umeng/update/UmengUpdateAgent$7:<init>	(Landroid/content/Context;)V
    //   481: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   484: pop
    //   485: iload 4
    //   487: ireturn
    //   488: astore 17
    //   490: iconst_0
    //   491: istore 4
    //   493: goto -23 -> 470
    //   496: astore_3
    //   497: iconst_0
    //   498: istore 4
    //   500: goto -15 -> 485
    //   503: astore 7
    //   505: goto -20 -> 485
    //   508: astore_1
    //   509: iconst_1
    //   510: ireturn
    //   511: iconst_0
    //   512: istore 4
    //   514: goto -49 -> 465
    //   517: iconst_0
    //   518: istore 12
    //   520: iconst_0
    //   521: istore 13
    //   523: iconst_0
    //   524: istore 14
    //   526: goto -236 -> 290
    //   529: iconst_0
    //   530: istore 4
    //   532: goto -332 -> 200
    //   535: iconst_0
    //   536: istore 4
    //   538: goto -422 -> 116
    //   541: iinc 11 1
    //   544: goto -269 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	paramContext	Context
    //   508	1	1	localException1	Exception
    //   42	2	2	bool1	boolean
    //   496	1	3	localException2	Exception
    //   103	434	4	bool2	boolean
    //   85	295	5	localPackageInfo	android.content.pm.PackageInfo
    //   92	3	6	arrayOfActivityInfo	android.content.pm.ActivityInfo[]
    //   503	1	7	localException3	Exception
    //   176	3	9	arrayOfServiceInfo	android.content.pm.ServiceInfo[]
    //   264	278	11	i	int
    //   267	252	12	j	int
    //   270	252	13	k	int
    //   273	252	14	m	int
    //   281	7	15	n	int
    //   390	3	16	bool3	boolean
    //   488	1	17	localException4	Exception
    //   455	3	19	bool4	boolean
    //   184	66	21	i1	int
    //   239	3	22	bool5	boolean
    //   100	66	23	i2	int
    //   155	3	24	bool6	boolean
    // Exception table:
    //   from	to	target	type
    //   409	457	488	java/lang/Exception
    //   47	69	496	java/lang/Exception
    //   71	94	496	java/lang/Exception
    //   171	178	496	java/lang/Exception
    //   255	263	496	java/lang/Exception
    //   275	283	496	java/lang/Exception
    //   330	347	496	java/lang/Exception
    //   353	370	496	java/lang/Exception
    //   376	392	496	java/lang/Exception
    //   105	116	503	java/lang/Exception
    //   121	136	503	java/lang/Exception
    //   138	157	503	java/lang/Exception
    //   189	200	503	java/lang/Exception
    //   205	220	503	java/lang/Exception
    //   222	241	503	java/lang/Exception
    //   313	328	503	java/lang/Exception
    //   470	485	503	java/lang/Exception
    //   8	43	508	java/lang/Exception
  }
  
  public static File downloadedFile(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    String str = paramUpdateResponse.new_md5 + ".apk";
    try
    {
      File localFile = new File(j.a("/apk", paramContext, new boolean[1]), str);
      if (localFile.exists())
      {
        boolean bool = paramUpdateResponse.new_md5.equalsIgnoreCase(n.a(localFile));
        if (bool) {
          return localFile;
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static void forceUpdate(Context paramContext)
  {
    UpdateConfig.setUpdateForce(true);
    UpdateConfig.setSilentDownload(false);
    b(paramContext.getApplicationContext());
  }
  
  public static void ignoreUpdate(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    UpdateConfig.saveIgnoreMd5(paramContext, paramUpdateResponse.new_md5);
  }
  
  public static boolean isIgnore(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    return (paramUpdateResponse.new_md5 != null) && (paramUpdateResponse.new_md5.equalsIgnoreCase(UpdateConfig.getIgnoreMd5(paramContext))) && (!UpdateConfig.isUpdateForce());
  }
  
  public static void setAppkey(String paramString)
  {
    UpdateConfig.setAppkey(paramString);
  }
  
  public static void setChannel(String paramString)
  {
    UpdateConfig.setChannel(paramString);
  }
  
  public static void setDefault()
  {
    setDeltaUpdate(true);
    setUpdateAutoPopup(true);
    setUpdateOnlyWifi(true);
    setRichNotification(true);
    setDialogListener(null);
    setDownloadListener(null);
    setUpdateListener(null);
    setAppkey(null);
    setChannel(null);
    setUpdateUIStyle(0);
  }
  
  public static void setDeltaUpdate(boolean paramBoolean)
  {
    UpdateConfig.setDeltaUpdate(paramBoolean);
  }
  
  public static void setDialogListener(UmengDialogButtonListener paramUmengDialogButtonListener)
  {
    b = paramUmengDialogButtonListener;
  }
  
  public static void setDownloadListener(UmengDownloadListener paramUmengDownloadListener)
  {
    c = paramUmengDownloadListener;
  }
  
  public static void setRichNotification(boolean paramBoolean)
  {
    UpdateConfig.setRichNotification(paramBoolean);
  }
  
  public static void setUpdateAutoPopup(boolean paramBoolean)
  {
    UpdateConfig.setUpdateAutoPopup(paramBoolean);
  }
  
  public static void setUpdateCheckConfig(boolean paramBoolean)
  {
    UpdateConfig.setUpdateCheck(paramBoolean);
  }
  
  public static void setUpdateListener(UmengUpdateListener paramUmengUpdateListener)
  {
    a = paramUmengUpdateListener;
  }
  
  public static void setUpdateOnlyWifi(boolean paramBoolean)
  {
    UpdateConfig.setUpdateOnlyWifi(paramBoolean);
  }
  
  public static void setUpdateUIStyle(int paramInt)
  {
    UpdateConfig.setStyle(paramInt);
  }
  
  public static void showUpdateDialog(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    b(paramContext, paramUpdateResponse, 0);
  }
  
  public static void showUpdateNotification(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    b(paramContext, paramUpdateResponse, 1);
  }
  
  public static void silentUpdate(Context paramContext)
  {
    UpdateConfig.setUpdateForce(false);
    UpdateConfig.setSilentDownload(true);
    b(paramContext.getApplicationContext());
  }
  
  public static void startDownload(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    if ((paramUpdateResponse.delta) && (UpdateConfig.isDeltaUpdate()))
    {
      e.a(paramContext, paramUpdateResponse.origin, paramUpdateResponse.new_md5, paramUpdateResponse.path, paramUpdateResponse.patch_md5, c);
      e.b();
      return;
    }
    e.a(paramContext, paramUpdateResponse.path, paramUpdateResponse.new_md5, null, null, c);
    e.c();
  }
  
  public static void startInstall(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    paramContext.startActivity(localIntent);
  }
  
  public static void update(Context paramContext)
  {
    UpdateConfig.setUpdateForce(false);
    UpdateConfig.setSilentDownload(false);
    b(paramContext.getApplicationContext());
  }
  
  public static void update(Context paramContext, String paramString1, String paramString2)
  {
    UpdateConfig.setAppkey(paramString1);
    UpdateConfig.setChannel(paramString2);
    update(paramContext);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengUpdateAgent
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */