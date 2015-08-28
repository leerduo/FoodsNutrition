package com.xiaomi.mipush.sdk;

import java.util.HashMap;
import java.util.Map;

public class MiPushMessage
  implements PushMessageHandler.a
{
  private String a;
  private int b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private int h;
  private boolean i;
  private String j;
  private String k;
  private String l;
  private HashMap<String, String> m = new HashMap();
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.m.clear();
    if (paramMap != null) {
      this.m.putAll(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public String f()
  {
    return this.l;
  }
  
  public void f(String paramString)
  {
    this.k = paramString;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public void g(String paramString)
  {
    this.l = paramString;
  }
  
  public Map<String, String> h()
  {
    return this.m;
  }
  
  public String toString()
  {
    return "messageId={" + this.a + "},passThrough={" + this.f + "},alias={" + this.d + "},topic={" + this.e + "},content={" + this.c + "},description={" + this.j + "},title={" + this.k + "},isNotified={" + this.i + "},notifyId={" + this.h + "},notifyType={" + this.g + "}, category={" + this.l + "}, extra={" + this.m + "}";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MiPushMessage
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */