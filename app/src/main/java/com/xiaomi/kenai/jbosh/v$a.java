package com.xiaomi.kenai.jbosh;

import java.net.URI;
import javax.net.ssl.SSLContext;

public final class v$a
{
  private final URI a;
  private final String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private SSLContext h;
  private Boolean i;
  
  private v$a(URI paramURI, String paramString)
  {
    this.a = paramURI;
    this.b = paramString;
  }
  
  public static a a(URI paramURI, String paramString)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException("Connection manager URI must not be null");
    }
    if (paramString == null) {
      throw new IllegalArgumentException("Target domain must not be null");
    }
    String str = paramURI.getScheme();
    if ((!"http".equals(str)) && (!"https".equals(str))) {
      throw new IllegalArgumentException("Only 'http' and 'https' URI are allowed");
    }
    return new a(paramURI, paramString);
  }
  
  public v a()
  {
    String str;
    int j;
    if (this.d == null)
    {
      str = "en";
      if (this.f != null) {
        break label72;
      }
      j = 0;
      label19:
      if (this.i != null) {
        break label80;
      }
    }
    label72:
    label80:
    for (boolean bool = false;; bool = this.i.booleanValue())
    {
      return new v(this.a, this.b, this.c, str, this.e, this.f, j, this.h, bool, null);
      str = this.d;
      break;
      j = this.g;
      break label19;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.v.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */