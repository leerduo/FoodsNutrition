package com.xiaomi.push.service;

import android.content.Context;
import java.util.Locale;

public class f
{
  public final String a;
  protected final String b;
  protected final String c;
  protected final String d;
  protected final String e;
  protected final String f;
  protected final int g;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramInt;
  }
  
  private static boolean a(Context paramContext)
  {
    return paramContext.getPackageName().equals("com.xiaomi.xmsf");
  }
  
  public v.b a(XMPushService paramXMPushService)
  {
    v.b localb = new v.b(paramXMPushService);
    localb.a = paramXMPushService.getPackageName();
    localb.b = this.a;
    localb.i = this.c;
    localb.c = this.b;
    localb.h = "5";
    localb.d = "XMPUSH-PASS";
    localb.e = false;
    localb.f = "sdk_ver:2";
    if (a(paramXMPushService)) {}
    for (String str = "1000271";; str = this.d)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = "appid";
      arrayOfObject[1] = str;
      arrayOfObject[2] = "locale";
      arrayOfObject[3] = Locale.getDefault().toString();
      localb.g = String.format("%1$s:%2$s,%3$s:%4$s", arrayOfObject);
      localb.k = paramXMPushService.e();
      return localb;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */