package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.security.MessageDigest;

public class j
{
  private Context a;
  private String b;
  
  private String a(String paramString)
  {
    Uri localUri = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    String[] arrayOfString = { "_id", "key", "type", "value" };
    for (;;)
    {
      try
      {
        Cursor localCursor = this.a.getContentResolver().query(localUri, arrayOfString, "key = ?", new String[] { paramString }, null);
        if (localCursor == null) {
          return null;
        }
        if (localCursor.moveToFirst())
        {
          str = localCursor.getString(localCursor.getColumnIndex("value"));
          localCursor.close();
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        return null;
      }
      String str = null;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0))
    {
      cn.sharesdk.framework.utils.e.c("checkSumConsistent fail, invalid arguments, \"_mmessage_checksum\" is empty", new Object[0]);
      return false;
    }
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      cn.sharesdk.framework.utils.e.c("checkSumConsistent fail, invalid arguments, checksum is empty", new Object[0]);
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      cn.sharesdk.framework.utils.e.c("checkSumConsistent fail, length is different", new Object[0]);
      return false;
    }
    for (int i = 0; i < paramArrayOfByte1.length; i++) {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        cn.sharesdk.framework.utils.e.c("checkSumConsistent fail, not match", new Object[0]);
        return false;
      }
    }
    return true;
  }
  
  private byte[] a(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    localStringBuffer.append(paramInt);
    localStringBuffer.append(paramString2);
    localStringBuffer.append("mMcShCsTr");
    byte[] arrayOfByte1 = localStringBuffer.toString().substring(1, 9).getBytes();
    char[] arrayOfChar1 = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte3 = localMessageDigest.digest();
      char[] arrayOfChar2 = new char[2 * arrayOfByte3.length];
      int j = 0;
      while (i < arrayOfByte3.length)
      {
        int k = arrayOfByte3[i];
        int m = j + 1;
        arrayOfChar2[j] = arrayOfChar1[(0xF & k >>> 4)];
        j = m + 1;
        arrayOfChar2[m] = arrayOfChar1[(k & 0xF)];
        i++;
      }
      str = new String(arrayOfChar2);
      byte[] arrayOfByte2 = null;
      if (str != null) {
        arrayOfByte2 = str.getBytes();
      }
      return arrayOfByte2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        String str = null;
      }
    }
  }
  
  private boolean d()
  {
    cn.sharesdk.framework.utils.e.a("checking signature of wechat client...", new Object[0]);
    for (;;)
    {
      int j;
      try
      {
        PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo("com.tencent.mm", 64);
        int i = localPackageInfo.signatures.length;
        j = 0;
        boolean bool = false;
        if (j < i)
        {
          if ("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499".equals(localPackageInfo.signatures[j].toCharsString()))
          {
            cn.sharesdk.framework.utils.e.a("pass!", new Object[0]);
            bool = true;
          }
        }
        else {
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        return false;
      }
      j++;
    }
  }
  
  public void a(l paraml)
  {
    if (!b()) {
      throw new WechatClientNotExistException();
    }
    if (!paraml.b()) {
      throw new Throwable("sendReq checkArgs fail");
    }
    String str1 = this.a.getPackageName();
    String str2 = "weixin://sendreq?appid=" + this.b;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
    Bundle localBundle = new Bundle();
    paraml.a(localBundle);
    if (localBundle != null) {
      localIntent.putExtras(localBundle);
    }
    localIntent.putExtra("_mmessage_sdkVersion", 553844737);
    localIntent.putExtra("_mmessage_appPackage", str1);
    localIntent.putExtra("_mmessage_content", str2);
    localIntent.putExtra("_mmessage_checksum", a(str2, str1, 553844737));
    localIntent.addFlags(268435456);
    localIntent.addFlags(134217728);
    this.a.startActivity(localIntent);
    cn.sharesdk.framework.utils.e.a("starting activity, packageName=com.tencent.mm, className=com.tencent.mm.plugin.base.stub.WXEntryActivity", new Object[0]);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	cn/sharesdk/wechat/utils/j:a	Landroid/content/Context;
    //   4: invokevirtual 152	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   7: ldc 154
    //   9: iconst_0
    //   10: invokevirtual 160	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   13: getfield 261	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   16: astore_3
    //   17: new 198	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 263
    //   27: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_3
    //   31: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 265	cn/sharesdk/framework/utils/e:b	(Ljava/lang/Object;[Ljava/lang/Object;)I
    //   44: pop
    //   45: aload_3
    //   46: ldc_w 267
    //   49: invokevirtual 271	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: iconst_0
    //   53: aaload
    //   54: ldc_w 273
    //   57: invokevirtual 271	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: arraylength
    //   65: newarray int
    //   67: astore 5
    //   69: iconst_0
    //   70: istore 6
    //   72: iload 6
    //   74: aload 5
    //   76: arraylength
    //   77: if_icmpge +52 -> 129
    //   80: aload 5
    //   82: iload 6
    //   84: aload 4
    //   86: iload 6
    //   88: aaload
    //   89: invokestatic 278	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: iastore
    //   93: iinc 6 1
    //   96: goto -24 -> 72
    //   99: astore_1
    //   100: aload_1
    //   101: invokestatic 72	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   104: pop
    //   105: ldc_w 280
    //   108: astore_3
    //   109: goto -64 -> 45
    //   112: astore 13
    //   114: aload 13
    //   116: invokestatic 72	cn/sharesdk/framework/utils/e:c	(Ljava/lang/Throwable;)I
    //   119: pop
    //   120: aload 5
    //   122: iload 6
    //   124: iconst_0
    //   125: iastore
    //   126: goto -33 -> 93
    //   129: aload 5
    //   131: arraylength
    //   132: istore 7
    //   134: iconst_0
    //   135: istore 8
    //   137: iload 7
    //   139: iconst_4
    //   140: if_icmplt +67 -> 207
    //   143: aload 5
    //   145: iconst_0
    //   146: iaload
    //   147: istore 9
    //   149: iconst_0
    //   150: istore 8
    //   152: iload 9
    //   154: bipush 6
    //   156: if_icmpne +51 -> 207
    //   159: aload 5
    //   161: iconst_1
    //   162: iaload
    //   163: istore 10
    //   165: iconst_0
    //   166: istore 8
    //   168: iload 10
    //   170: ifne +37 -> 207
    //   173: aload 5
    //   175: iconst_2
    //   176: iaload
    //   177: istore 11
    //   179: iconst_0
    //   180: istore 8
    //   182: iload 11
    //   184: iconst_2
    //   185: if_icmpne +22 -> 207
    //   188: aload 5
    //   190: iconst_3
    //   191: iaload
    //   192: istore 12
    //   194: iconst_0
    //   195: istore 8
    //   197: iload 12
    //   199: bipush 56
    //   201: if_icmpgt +6 -> 207
    //   204: iconst_1
    //   205: istore 8
    //   207: iload 8
    //   209: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	j
    //   99	2	1	localThrowable1	Throwable
    //   16	93	3	str	String
    //   60	25	4	arrayOfString	String[]
    //   67	122	5	arrayOfInt	int[]
    //   70	53	6	i	int
    //   132	9	7	j	int
    //   135	73	8	bool	boolean
    //   147	10	9	k	int
    //   163	6	10	m	int
    //   177	9	11	n	int
    //   192	10	12	i1	int
    //   112	3	13	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	45	99	java/lang/Throwable
    //   80	93	112	java/lang/Throwable
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    if (!d())
    {
      cn.sharesdk.framework.utils.e.c("register app failed for wechat app signature check failed", new Object[0]);
      return false;
    }
    String str1 = "weixin://registerapp?appid=" + paramString;
    String str2 = paramContext.getPackageName();
    Intent localIntent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER");
    localIntent.putExtra("_mmessage_sdkVersion", 553910273);
    localIntent.putExtra("_mmessage_appPackage", str2);
    localIntent.putExtra("_mmessage_content", str1);
    localIntent.putExtra("_mmessage_checksum", a(str1, str2, 553910273));
    paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    cn.sharesdk.framework.utils.e.a("sending broadcast, intent=" + "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER" + ", perm=" + "com.tencent.mm.permission.MM_MESSAGE", new Object[0]);
    return true;
  }
  
  public boolean a(WechatHandlerActivity paramWechatHandlerActivity, k paramk)
  {
    Intent localIntent = paramWechatHandlerActivity.getIntent();
    if (localIntent == null) {
      return false;
    }
    String str1 = localIntent.getStringExtra("wx_token_key");
    if ((str1 == null) || (!str1.equals("com.tencent.mm.openapi.token")))
    {
      cn.sharesdk.framework.utils.e.c("invalid argument, \"wx_token_key\" is empty or does not equals \"com.tencent.mm.openapi.token\"", new Object[0]);
      return false;
    }
    String str2 = localIntent.getStringExtra("_mmessage_appPackage");
    if (TextUtils.isEmpty(str2))
    {
      cn.sharesdk.framework.utils.e.c("invalid argument, \"_mmessage_appPackage\" is empty", new Object[0]);
      return false;
    }
    String str3 = localIntent.getStringExtra("_mmessage_content");
    int i = localIntent.getIntExtra("_mmessage_sdkVersion", 0);
    if (!a(localIntent.getByteArrayExtra("_mmessage_checksum"), a(str3, str2, i)))
    {
      cn.sharesdk.framework.utils.e.c("checksum fail", new Object[0]);
      return false;
    }
    Bundle localBundle = localIntent.getExtras();
    switch (localBundle.getInt("_wxapi_command_type", 0))
    {
    default: 
      return false;
    case 1: 
      paramk.a(new b(localBundle));
    }
    for (;;)
    {
      return true;
      paramk.a(new e(localBundle));
      continue;
      paramWechatHandlerActivity.onGetMessageFromWXReq(new c(localBundle).a);
      continue;
      paramWechatHandlerActivity.onShowMessageFromWXReq(new f(localBundle).a);
    }
  }
  
  public boolean b()
  {
    if (!d()) {}
    for (;;)
    {
      return false;
      String str = a("_build_info_sdk_int_");
      try
      {
        int j = Integer.parseInt(str);
        i = j;
        if (i < 553844737) {
          continue;
        }
        return true;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          cn.sharesdk.framework.utils.e.c(localThrowable);
          int i = -1;
        }
      }
    }
  }
  
  public boolean c()
  {
    String str = a("_build_info_sdk_int_");
    try
    {
      int j = Integer.parseInt(str);
      i = j;
      if (i >= 553779201) {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        int i = -1;
      }
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */