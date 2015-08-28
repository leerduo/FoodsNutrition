package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.w;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;

public class i
  extends XMPushService.e
{
  private XMPushService a;
  private byte[] b;
  private String c;
  private String e;
  private String f;
  
  public i(XMPushService paramXMPushService, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super(9);
    this.a = paramXMPushService;
    this.c = paramString1;
    this.b = paramArrayOfByte;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  public void a()
  {
    f localf1 = g.a(this.a);
    if (localf1 == null) {}
    v.b localb;
    do
    {
      f localf2;
      for (;;)
      {
        try
        {
          f localf3 = g.a(this.a, this.c, this.e, this.f);
          localf2 = localf3;
          if (localf2 != null) {
            break;
          }
          b.c("no account for mipush");
          j.a(this.a, 70000002, "no account.");
          return;
        }
        catch (IOException localIOException)
        {
          b.a(localIOException);
          localf2 = localf1;
          continue;
        }
        catch (JSONException localJSONException)
        {
          b.a(localJSONException);
        }
        localf2 = localf1;
      }
      Collection localCollection = v.a().c("5");
      if (localCollection.isEmpty())
      {
        localb = localf2.a(this.a);
        this.a.a(localb);
        v.a().a(localb);
      }
      for (;;)
      {
        if (!this.a.f()) {
          break label247;
        }
        try
        {
          if (localb.m != v.c.c) {
            break;
          }
          this.a.a(this.c, this.b);
          return;
        }
        catch (w localw)
        {
          b.a(localw);
          this.a.b(10, localw);
          return;
        }
        localb = (v.b)localCollection.iterator().next();
      }
    } while (localb.m != v.c.a);
    XMPushService localXMPushService1 = this.a;
    XMPushService localXMPushService2 = this.a;
    localXMPushService2.getClass();
    localXMPushService1.a(new XMPushService.a(localXMPushService2, localb));
    return;
    label247:
    this.a.a(true);
  }
  
  public String b()
  {
    return "register app";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.i
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */