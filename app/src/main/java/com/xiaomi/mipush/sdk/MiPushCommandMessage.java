package com.xiaomi.mipush.sdk;

import java.util.List;

public class MiPushCommandMessage
  implements PushMessageHandler.a
{
  private String a;
  private long b;
  private String c;
  private List<String> d;
  private String e;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<String> paramList)
  {
    this.d = paramList;
  }
  
  public List<String> b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "command={" + this.a + "}, resultCode={" + this.b + "}, reason={" + this.c + "}, category={" + this.e + "}, commandArguments={" + this.d + "}";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MiPushCommandMessage
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */