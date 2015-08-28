package com.xiaomi.smack;

import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.e;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.util.g;
import java.util.Collection;
import java.util.Iterator;

public class s$b
  extends d
{
  private s.b.a c;
  private boolean d;
  private int e;
  
  public s.b.a a()
  {
    return this.c;
  }
  
  public void a(s.b.a parama)
  {
    if (parama == null)
    {
      this.c = s.b.a.a;
      return;
    }
    this.c = parama;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.d = paramBoolean;
    this.e = paramInt;
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
      localStringBuilder.append(" chid=\"").append(g.a(l())).append("\" ");
    }
    if (this.c == null) {
      localStringBuilder.append("type=\"result\">");
    }
    for (;;)
    {
      if (this.d)
      {
        localStringBuilder.append("<p peroid = ");
        localStringBuilder.append(this.e);
        localStringBuilder.append("/>");
      }
      if (q() == null) {
        break;
      }
      Iterator localIterator = q().iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((a)localIterator.next()).d());
      }
      localStringBuilder.append("type=\"").append(a()).append("\">");
    }
    h localh = p();
    if (localh != null) {
      localStringBuilder.append(localh.d());
    }
    localStringBuilder.append("</bind>");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.s.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */