package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.e;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;

public class i
{
  private Platform a;
  private Context b;
  private PlatformDb c;
  private d d;
  private int e;
  private int f;
  private boolean g;
  private boolean h = true;
  private boolean i;
  
  public i(Platform paramPlatform, Context paramContext)
  {
    this.a = paramPlatform;
    this.b = paramContext;
    String str = paramPlatform.getName();
    this.c = new PlatformDb(paramContext, str, paramPlatform.getVersion());
    a(str);
    this.d = new d();
  }
  
  private boolean j()
  {
    if (!ShareSDK.a()) {
      return true;
    }
    if (ShareSDK.b())
    {
      String str3 = a(this.a.getPlatformId(), "covert_url", null);
      if (str3 != null) {
        str3.trim();
      }
      boolean bool2 = "false".equals(str3);
      boolean bool3 = false;
      if (!bool2) {
        bool3 = true;
      }
      this.h = bool3;
      this.a.setNetworkDevinfo();
      return true;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        if (!ShareSDK.a(localHashMap)) {
          return false;
        }
        if (!ShareSDK.b(localHashMap))
        {
          String str2 = new cn.sharesdk.framework.utils.d().a(localHashMap);
          if (!ShareSDK.isDebug()) {
            break;
          }
          System.err.println("Failed to parse network dev-info: " + str2);
          break;
        }
        String str1 = a(this.a.getPlatformId(), "covert_url", null);
        if (str1 != null) {
          str1.trim();
        }
        if (!"false".equals(str1))
        {
          bool1 = true;
          this.h = bool1;
          this.a.setNetworkDevinfo();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        e.c(localThrowable);
        return false;
      }
      boolean bool1 = false;
    }
    return false;
  }
  
  /* Error */
  private String k()
  {
    // Byte code:
    //   0: new 116	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: ldc 139
    //   10: aload_0
    //   11: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   14: invokevirtual 36	cn/sharesdk/framework/Platform:getName	()Ljava/lang/String;
    //   17: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +170 -> 190
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: astore 10
    //   29: aload 10
    //   31: iconst_0
    //   32: aload_0
    //   33: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   36: invokevirtual 145	cn/sharesdk/framework/PlatformDb:getUserName	()Ljava/lang/String;
    //   39: aastore
    //   40: ldc 147
    //   42: aload 10
    //   44: invokestatic 150	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   47: pop
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   53: invokevirtual 145	cn/sharesdk/framework/PlatformDb:getUserName	()Ljava/lang/String;
    //   56: ldc 152
    //   58: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: ldc 159
    //   68: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_0
    //   72: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   75: ldc 161
    //   77: invokevirtual 165	cn/sharesdk/framework/PlatformDb:get	(Ljava/lang/String;)Ljava/lang/String;
    //   80: ldc 152
    //   82: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: ldc 159
    //   92: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   99: ldc 167
    //   101: invokevirtual 165	cn/sharesdk/framework/PlatformDb:get	(Ljava/lang/String;)Ljava/lang/String;
    //   104: ldc 152
    //   106: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_1
    //   114: ldc 159
    //   116: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   123: ldc 169
    //   125: invokevirtual 165	cn/sharesdk/framework/PlatformDb:get	(Ljava/lang/String;)Ljava/lang/String;
    //   128: ldc 152
    //   130: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: ldc 159
    //   140: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   147: ldc 171
    //   149: invokevirtual 165	cn/sharesdk/framework/PlatformDb:get	(Ljava/lang/String;)Ljava/lang/String;
    //   152: ldc 152
    //   154: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: ldc 159
    //   164: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   171: ldc 173
    //   173: invokevirtual 165	cn/sharesdk/framework/PlatformDb:get	(Ljava/lang/String;)Ljava/lang/String;
    //   176: ldc 152
    //   178: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   181: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: areturn
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 142	cn/sharesdk/framework/i:g	()Lcn/sharesdk/framework/PlatformDb;
    //   195: invokevirtual 176	cn/sharesdk/framework/PlatformDb:getUserId	()Ljava/lang/String;
    //   198: ldc 152
    //   200: invokestatic 157	cn/sharesdk/framework/utils/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: goto -142 -> 65
    //   210: astore_2
    //   211: aload_2
    //   212: invokestatic 136	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   215: pop
    //   216: goto -31 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	i
    //   7	184	1	localStringBuilder	java.lang.StringBuilder
    //   210	2	2	localThrowable	Throwable
    //   27	16	10	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   8	65	210	java/lang/Throwable
    //   65	185	210	java/lang/Throwable
    //   190	207	210	java/lang/Throwable
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str = ShareSDK.a(paramInt, paramString1);
    if ((TextUtils.isEmpty(str)) || ("null".equals(str))) {
      str = this.a.getDevinfo(this.a.getName(), paramString2);
    }
    return str;
  }
  
  public String a(Bitmap paramBitmap)
  {
    return ShareSDK.a(paramBitmap);
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (!this.h)
    {
      e.c("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      e.c("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    String str = ShareSDK.a(paramString, paramBoolean, this.a.getPlatformId(), k());
    e.c("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return str;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = paramString;
    c(2, arrayOfObject);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.d.a(this.a, paramInt, paramObject);
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    if (paramShareParams == null)
    {
      if (this.d != null) {
        this.d.onError(this.a, 9, new NullPointerException());
      }
      return;
    }
    c(9, paramShareParams);
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    this.d.a(paramPlatformActionListener);
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 236
    //   3: invokestatic 238	cn/sharesdk/framework/ShareSDK:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_2
    //   9: invokevirtual 82	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   15: putfield 178	cn/sharesdk/framework/i:e	I
    //   18: aload_1
    //   19: ldc 244
    //   21: invokestatic 238	cn/sharesdk/framework/ShareSDK:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_0
    //   27: aload 4
    //   29: invokevirtual 82	java/lang/String:trim	()Ljava/lang/String;
    //   32: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   35: putfield 246	cn/sharesdk/framework/i:f	I
    //   38: aload_1
    //   39: ldc 248
    //   41: invokestatic 238	cn/sharesdk/framework/ShareSDK:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +169 -> 217
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 250	cn/sharesdk/framework/i:i	Z
    //   56: aload_0
    //   57: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   60: instanceof 252
    //   63: ifne +40 -> 103
    //   66: invokestatic 108	cn/sharesdk/framework/ShareSDK:isDebug	()Z
    //   69: ifeq +34 -> 103
    //   72: getstatic 114	java/lang/System:err	Ljava/io/PrintStream;
    //   75: new 116	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   86: invokevirtual 36	cn/sharesdk/framework/Platform:getName	()Ljava/lang/String;
    //   89: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 254
    //   94: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 131	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   107: aload_1
    //   108: invokevirtual 257	cn/sharesdk/framework/Platform:initDevInfo	(Ljava/lang/String;)V
    //   111: return
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   117: instanceof 252
    //   120: ifne -102 -> 18
    //   123: invokestatic 108	cn/sharesdk/framework/ShareSDK:isDebug	()Z
    //   126: ifeq -108 -> 18
    //   129: getstatic 114	java/lang/System:err	Ljava/io/PrintStream;
    //   132: new 116	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   139: aload_0
    //   140: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   143: invokevirtual 36	cn/sharesdk/framework/Platform:getName	()Ljava/lang/String;
    //   146: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 259
    //   152: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokevirtual 131	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   161: goto -143 -> 18
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   170: instanceof 252
    //   173: ifne -135 -> 38
    //   176: invokestatic 108	cn/sharesdk/framework/ShareSDK:isDebug	()Z
    //   179: ifeq -141 -> 38
    //   182: getstatic 114	java/lang/System:err	Ljava/io/PrintStream;
    //   185: new 116	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   192: aload_0
    //   193: getfield 28	cn/sharesdk/framework/i:a	Lcn/sharesdk/framework/Platform;
    //   196: invokevirtual 36	cn/sharesdk/framework/Platform:getName	()Ljava/lang/String;
    //   199: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 261
    //   205: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokevirtual 131	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   214: goto -176 -> 38
    //   217: aload_0
    //   218: ldc_w 263
    //   221: aload 6
    //   223: invokevirtual 82	java/lang/String:trim	()Ljava/lang/String;
    //   226: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: putfield 250	cn/sharesdk/framework/i:i	Z
    //   232: goto -129 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	i
    //   0	235	1	paramString	String
    //   6	3	2	str1	String
    //   112	1	3	localThrowable1	Throwable
    //   24	4	4	str2	String
    //   164	1	5	localThrowable2	Throwable
    //   44	178	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   7	18	112	java/lang/Throwable
    //   26	38	164	java/lang/Throwable
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = paramString;
    c(7, arrayOfObject);
  }
  
  public void a(String paramString1, String paramString2, short paramShort, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    c(0xA0000 | paramShort, new Object[] { paramString1, paramString2, paramHashMap, paramHashMap1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    new k(this, paramArrayOfString).start();
  }
  
  public int b()
  {
    return this.f;
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      Object[] arrayOfObject3 = (Object[])paramObject;
      String str2 = String.valueOf(arrayOfObject3[0]);
      String str3 = String.valueOf(arrayOfObject3[1]);
      HashMap localHashMap2 = (HashMap)arrayOfObject3[2];
      HashMap localHashMap3 = (HashMap)arrayOfObject3[3];
      this.a.doCustomerProtocol(str2, str3, paramInt, localHashMap2, localHashMap3);
    case 1: 
      do
      {
        return;
      } while (this.d == null);
      this.d.onComplete(this.a, 1, null);
      return;
    case 6: 
      this.a.follow((String)paramObject);
      return;
    case 7: 
      Object[] arrayOfObject2 = (Object[])paramObject;
      this.a.timeline(((Integer)arrayOfObject2[0]).intValue(), ((Integer)arrayOfObject2[1]).intValue(), (String)arrayOfObject2[2]);
      return;
    case 8: 
      Platform localPlatform = this.a;
      if (paramObject == null) {}
      for (String str1 = null;; str1 = (String)paramObject)
      {
        localPlatform.userInfor(str1);
        return;
      }
    case 9: 
      Platform.ShareParams localShareParams = (Platform.ShareParams)paramObject;
      HashMap localHashMap1 = localShareParams.toMap();
      Field[] arrayOfField = localShareParams.getClass().getFields();
      int j = arrayOfField.length;
      int k = 0;
      for (;;)
      {
        if (k < j)
        {
          Field localField = arrayOfField[k];
          if (localHashMap1.get(localField.getName()) == null) {
            localField.setAccessible(true);
          }
          try
          {
            Object localObject2 = localField.get(localShareParams);
            localObject1 = localObject2;
            if (localObject1 != null) {
              localHashMap1.put(localField.getName(), localObject1);
            }
            k++;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              e.c(localThrowable);
              Object localObject1 = null;
            }
          }
        }
      }
      this.a.doShare(localShareParams);
      return;
    }
    Object[] arrayOfObject1 = (Object[])paramObject;
    this.a.getFriendList(((Integer)arrayOfObject1[0]).intValue(), ((Integer)arrayOfObject1[1]).intValue(), (String)arrayOfObject1[2]);
  }
  
  public void b(String paramString)
  {
    c(6, paramString);
  }
  
  public PlatformActionListener c()
  {
    return this.d.a();
  }
  
  protected void c(int paramInt, Object paramObject)
  {
    new j(this, paramInt, paramObject).start();
  }
  
  public void c(String paramString)
  {
    c(8, paramString);
  }
  
  public String d(String paramString)
  {
    return ShareSDK.a(paramString);
  }
  
  public boolean d()
  {
    return this.c.isValid();
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public PlatformDb g()
  {
    return this.c;
  }
  
  public void h()
  {
    this.c.removeAccount();
  }
  
  protected PlatformActionListener i()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */