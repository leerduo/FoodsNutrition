package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.misc.a;
import java.util.Map;

public class k
  implements Cloneable
{
  private String a;
  private String b;
  private int c;
  private boolean d = j.c;
  private boolean e = true;
  private String f;
  private m g;
  
  public k(Map<String, Integer> paramMap, int paramInt, String paramString, m paramm)
  {
    a(paramMap, paramInt, paramString, paramm);
  }
  
  private void a(Map<String, Integer> paramMap, int paramInt, String paramString, m paramm)
  {
    this.b = d();
    this.c = paramInt;
    this.a = paramString;
    this.g = paramm;
  }
  
  public static final String d()
  {
    if (a.e) {
      return "10.237.12.2";
    }
    if (a.a()) {
      return "sandbox.xmpush.xiaomi.com";
    }
    if (a.b()) {
      return "10.237.12.17";
    }
    if (a.b) {
      return "58.68.235.106";
    }
    return "app.chat.xiaomi.net";
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.c;
  }
  
  public String h()
  {
    return this.b;
  }
  
  public boolean i()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */