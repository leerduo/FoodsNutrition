package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.g;

public class b
  extends d
{
  private b.a c = b.a.a;
  
  public b() {}
  
  public b(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_iq_type")) {
      this.c = b.a.a(paramBundle.getString("ext_iq_type"));
    }
  }
  
  public b.a a()
  {
    return this.c;
  }
  
  public void a(b.a parama)
  {
    if (parama == null)
    {
      this.c = b.a.a;
      return;
    }
    this.c = parama;
  }
  
  public Bundle b()
  {
    Bundle localBundle = super.b();
    if (this.c != null) {
      localBundle.putString("ext_iq_type", this.c.toString());
    }
    return localBundle;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<iq ");
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
      localStringBuilder.append("chid=\"").append(g.a(l())).append("\" ");
    }
    if (this.c == null) {
      localStringBuilder.append("type=\"get\">");
    }
    for (;;)
    {
      String str = d();
      if (str != null) {
        localStringBuilder.append(str);
      }
      localStringBuilder.append(s());
      h localh = p();
      if (localh != null) {
        localStringBuilder.append(localh.d());
      }
      localStringBuilder.append("</iq>");
      return localStringBuilder.toString();
      localStringBuilder.append("type=\"").append(a()).append("\">");
    }
  }
  
  public String d()
  {
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */