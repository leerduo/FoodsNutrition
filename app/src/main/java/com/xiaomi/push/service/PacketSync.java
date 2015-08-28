package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.smack.j;
import com.xiaomi.smack.k;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.b.a;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.s.b;
import com.xiaomi.smack.s.b.a;
import com.xiaomi.smack.t;

public class PacketSync
{
  private XMPushService a;
  
  PacketSync(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }
  
  private void a(a parama)
  {
    String str = parama.c();
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split(";");
      Fallback localFallback = HostManager.a().a(k.d());
      if ((localFallback != null) && (arrayOfString.length > 0))
      {
        localFallback.a(arrayOfString);
        this.a.b(20, null);
        this.a.a(true);
      }
    }
  }
  
  public void a(d paramd)
  {
    s.b localb;
    s.b.a locala;
    String str5;
    String str6;
    if ((paramd instanceof s.b))
    {
      localb = (s.b)paramd;
      locala = localb.a();
      str5 = localb.l();
      str6 = localb.m();
      if (!TextUtils.isEmpty(str5)) {}
    }
    String str1;
    label581:
    a locala1;
    do
    {
      String str2;
      String str3;
      String str4;
      v.b localb1;
      do
      {
        do
        {
          v.b localb2;
          h localh;
          do
          {
            do
            {
              return;
              localb2 = v.a().b(str5, str6);
            } while (localb2 == null);
            if (locala == s.b.a.a)
            {
              localb2.a(v.c.c, 1, 0, null, null);
              com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind succeeded, chid=" + str5);
              return;
            }
            localh = localb.p();
            com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, error=" + localh.d());
          } while (localh == null);
          if ("auth".equals(localh.b()))
          {
            localb2.a(v.c.a, 1, 5, localh.a(), localh.b());
            v.a().a(str5, str6);
          }
          for (;;)
          {
            com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, chid=" + str5 + " reason=" + localh.a());
            return;
            if ("cancel".equals(localh.b()))
            {
              localb2.a(v.c.a, 1, 7, localh.a(), localh.b());
              v.a().a(str5, str6);
            }
            else if ("wait".equals(localh.b()))
            {
              this.a.b(localb2);
              localb2.a(v.c.a, 1, 7, localh.a(), localh.b());
            }
          }
          str1 = paramd.l();
          if (TextUtils.isEmpty(str1))
          {
            str1 = "1";
            paramd.l(str1);
          }
          if (!str1.equals("0")) {
            break;
          }
        } while ((!(paramd instanceof com.xiaomi.smack.packet.b)) || (!"0".equals(paramd.k())) || (!"result".equals(((com.xiaomi.smack.packet.b)paramd).a().toString())));
        j localj = this.a.h();
        if ((localj instanceof t)) {
          ((t)localj).x();
        }
        com.xiaomi.stats.b.b();
        return;
        if (!(paramd instanceof com.xiaomi.smack.packet.b)) {
          break label581;
        }
        a locala2 = paramd.p("kick");
        if (locala2 == null) {
          break label625;
        }
        str2 = paramd.m();
        str3 = locala2.a("type");
        str4 = locala2.a("reason");
        com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + str1 + " userid=" + str2 + " type=" + str3 + " reason=" + str4);
        if (!"wait".equals(str3)) {
          break;
        }
        localb1 = v.a().b(str1, str2);
      } while (localb1 == null);
      this.a.b(localb1);
      localb1.a(v.c.a, 3, 0, str4, str3);
      return;
      this.a.a(str1, str2, 3, str4, str3);
      v.a().a(str1, str2);
      return;
      if (!(paramd instanceof c)) {
        break;
      }
      c localc = (c)paramd;
      if (!"redir".equals(localc.a())) {
        break;
      }
      locala1 = localc.p("hosts");
    } while (locala1 == null);
    a(locala1);
    return;
    label625:
    this.a.e().a(this.a, str1, paramd);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.PacketSync
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */