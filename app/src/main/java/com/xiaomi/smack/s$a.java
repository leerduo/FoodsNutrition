package com.xiaomi.smack;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.b;
import com.xiaomi.push.service.v.b;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.e;
import com.xiaomi.smack.util.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class s$a
  extends d
{
  public s$a(s params, v.b paramb, String paramString, j paramj)
  {
    HashMap localHashMap = new HashMap();
    int i = paramj.k();
    localHashMap.put("challenge", paramString);
    localHashMap.put("token", paramb.c);
    localHashMap.put("chid", paramb.h);
    localHashMap.put("from", paramb.b);
    localHashMap.put("id", k());
    localHashMap.put("to", "xiaomi.com");
    String str6;
    if (paramb.e)
    {
      localHashMap.put("kick", "1");
      if (paramj.m() <= 0L) {
        break label696;
      }
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Long.valueOf(paramj.m());
      str6 = String.format("conn:%1$d,t:%2$d", arrayOfObject);
      localHashMap.put("pf", str6);
      paramj.l();
      paramj.n();
    }
    label283:
    label672:
    label684:
    label696:
    for (String str1 = str6;; str1 = null)
    {
      label219:
      label243:
      String str2;
      String str3;
      label371:
      a locala4;
      label456:
      String str4;
      label493:
      a locala6;
      if (!TextUtils.isEmpty(paramb.f))
      {
        localHashMap.put("client_attrs", paramb.f);
        if (TextUtils.isEmpty(paramb.g)) {
          break label622;
        }
        localHashMap.put("cloud_attrs", paramb.g);
        if ((!paramb.d.equals("XIAOMI-PASS")) && (!paramb.d.equals("XMPUSH-PASS"))) {
          break label637;
        }
        str2 = b.a(paramb.d, null, localHashMap, paramb.i);
        l(paramb.h);
        n(paramb.b);
        m("xiaomi.com");
        a locala1 = new a("token", null, (String[])null, (String[])null);
        locala1.b(paramb.c);
        a(locala1);
        a locala2 = new a("kick", null, (String[])null, (String[])null);
        if (!paramb.e) {
          break label655;
        }
        str3 = "1";
        locala2.b(str3);
        a(locala2);
        a locala3 = new a("sig", null, (String[])null, (String[])null);
        locala3.b(str2);
        a(locala3);
        locala4 = new a("method", null, (String[])null, (String[])null);
        if (TextUtils.isEmpty(paramb.d)) {
          break label662;
        }
        locala4.b(paramb.d);
        a(locala4);
        a locala5 = new a("client_attrs", null, (String[])null, (String[])null);
        if (paramb.f != null) {
          break label672;
        }
        str4 = "";
        locala5.b(str4);
        a(locala5);
        locala6 = new a("cloud_attrs", null, (String[])null, (String[])null);
        if (paramb.g != null) {
          break label684;
        }
      }
      for (String str5 = "";; str5 = g.a(paramb.g))
      {
        locala6.b(str5);
        a(locala6);
        if (!TextUtils.isEmpty(str1))
        {
          a locala7 = new a("pf", null, (String[])null, (String[])null);
          locala7.b(str1);
          a(locala7);
        }
        return;
        localHashMap.put("kick", "0");
        break;
        localHashMap.put("client_attrs", "");
        break label219;
        label622:
        localHashMap.put("cloud_attrs", "");
        break label243;
        label637:
        if (paramb.d.equals("XIAOMI-SASL")) {}
        str2 = null;
        break label283;
        str3 = "0";
        break label371;
        locala4.b("XIAOMI-SASL");
        break label456;
        str4 = g.a(paramb.f);
        break label493;
      }
    }
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<bind ");
    if (k() != null) {
      localStringBuilder.append("id=\"" + k() + "\" ");
    }
    if (m() != null) {
      localStringBuilder.append("to=\"").append(g.a(m())).append("\" ");
    }
    if (n() != null) {
      localStringBuilder.append("from=\"").append(g.a(n())).append("\" ");
    }
    if (l() != null) {
      localStringBuilder.append("chid=\"").append(g.a(l())).append("\">");
    }
    if (q() != null)
    {
      Iterator localIterator = q().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((a)localIterator.next()).d());
      }
    }
    localStringBuilder.append("</bind>");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.s.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */