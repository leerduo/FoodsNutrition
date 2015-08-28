package com.xiaomi.push.service;

import android.text.TextUtils;

class XMPushService$b
  extends XMPushService.e
{
  private final v.b a;
  
  public XMPushService$b(v.b paramb)
  {
    super(12);
    this.a = paramb;
  }
  
  public void a()
  {
    this.a.a(v.c.a, 1, 21, null, null);
  }
  
  public String b()
  {
    return "bind time out. chid=" + this.a.h;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return TextUtils.equals(((b)paramObject).a.h, this.a.h);
  }
  
  public int hashCode()
  {
    return this.a.h.hashCode();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */