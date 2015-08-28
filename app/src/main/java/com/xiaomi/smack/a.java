package com.xiaomi.smack;

import android.text.TextUtils;
import com.xiaomi.network.Fallback;
import java.net.URI;
import java.util.ArrayList;

public class a
  extends k
{
  private boolean a;
  private String b;
  private Fallback c = null;
  private String d = "mibind.chat.gslb.mi-idc.com";
  
  public a(boolean paramBoolean, Fallback paramFallback, int paramInt, String paramString1, String paramString2, m paramm)
  {
    super(null, paramInt, paramString2, paramm);
    this.c = paramFallback;
    this.a = paramBoolean;
    if (paramString1 != null) {}
    for (;;)
    {
      this.b = paramString1;
      return;
      paramString1 = "/";
    }
  }
  
  public Fallback a()
  {
    return this.c;
  }
  
  public void a(Fallback paramFallback)
  {
    if (paramFallback != null)
    {
      this.c = paramFallback;
      this.d = "mibind.chat.gslb.mi-idc.com";
      if (!this.c.c().isEmpty())
      {
        String str = (String)this.c.c().get(0);
        if (!TextUtils.isEmpty(str)) {
          this.d = str;
        }
      }
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  public URI c()
  {
    if (this.b.charAt(0) != '/') {
      this.b = ('/' + this.b);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a) {}
    for (String str = "https://";; str = "http://") {
      return new URI(str + this.d + ":" + g() + this.b);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */