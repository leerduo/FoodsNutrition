package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.xiaomi.smack.util.g;

public class f
  extends d
{
  private f.b c = f.b.a;
  private String d = null;
  private int e = -2147483648;
  private f.a f = null;
  
  public f(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_pres_type")) {
      this.c = f.b.valueOf(paramBundle.getString("ext_pres_type"));
    }
    if (paramBundle.containsKey("ext_pres_status")) {
      this.d = paramBundle.getString("ext_pres_status");
    }
    if (paramBundle.containsKey("ext_pres_prio")) {
      this.e = paramBundle.getInt("ext_pres_prio");
    }
    if (paramBundle.containsKey("ext_pres_mode")) {
      this.f = f.a.valueOf(paramBundle.getString("ext_pres_mode"));
    }
  }
  
  public f(f.b paramb)
  {
    a(paramb);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < -128) || (paramInt > 128)) {
      throw new IllegalArgumentException("Priority value " + paramInt + " is not valid. Valid range is -128 through 128.");
    }
    this.e = paramInt;
  }
  
  public void a(f.a parama)
  {
    this.f = parama;
  }
  
  public void a(f.b paramb)
  {
    if (paramb == null) {
      throw new NullPointerException("Type cannot be null");
    }
    this.c = paramb;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public Bundle b()
  {
    Bundle localBundle = super.b();
    if (this.c != null) {
      localBundle.putString("ext_pres_type", this.c.toString());
    }
    if (this.d != null) {
      localBundle.putString("ext_pres_status", this.d);
    }
    if (this.e != -2147483648) {
      localBundle.putInt("ext_pres_prio", this.e);
    }
    if ((this.f != null) && (this.f != f.a.b)) {
      localBundle.putString("ext_pres_mode", this.f.toString());
    }
    return localBundle;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<presence");
    if (t() != null) {
      localStringBuilder.append(" xmlns=\"").append(t()).append("\"");
    }
    if (k() != null) {
      localStringBuilder.append(" id=\"").append(k()).append("\"");
    }
    if (m() != null) {
      localStringBuilder.append(" to=\"").append(g.a(m())).append("\"");
    }
    if (n() != null) {
      localStringBuilder.append(" from=\"").append(g.a(n())).append("\"");
    }
    if (l() != null) {
      localStringBuilder.append(" chid=\"").append(g.a(l())).append("\"");
    }
    if (this.c != null) {
      localStringBuilder.append(" type=\"").append(this.c).append("\"");
    }
    localStringBuilder.append(">");
    if (this.d != null) {
      localStringBuilder.append("<status>").append(g.a(this.d)).append("</status>");
    }
    if (this.e != -2147483648) {
      localStringBuilder.append("<priority>").append(this.e).append("</priority>");
    }
    if ((this.f != null) && (this.f != f.a.b)) {
      localStringBuilder.append("<show>").append(this.f).append("</show>");
    }
    localStringBuilder.append(s());
    h localh = p();
    if (localh != null) {
      localStringBuilder.append(localh.d());
    }
    localStringBuilder.append("</presence>");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */