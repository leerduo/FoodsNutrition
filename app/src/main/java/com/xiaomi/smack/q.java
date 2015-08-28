package com.xiaomi.smack;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;
import com.xiaomi.smack.util.h;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

class q
{
  private Writer a;
  private t b;
  
  protected q(t paramt)
  {
    this.b = paramt;
    this.a = paramt.j;
  }
  
  private void b(d paramd)
  {
    synchronized (this.a)
    {
      try
      {
        String str1 = paramd.c();
        this.a.write(str1 + "\r\n");
        this.a.flush();
        String str2 = paramd.o();
        if (!TextUtils.isEmpty(str2)) {
          h.a(this.b.n, str2, h.a(str1), false, System.currentTimeMillis());
        }
        return;
      }
      catch (IOException localIOException)
      {
        throw new w(localIOException);
      }
    }
  }
  
  void a()
  {
    this.b.g.clear();
  }
  
  public void a(d paramd)
  {
    b(paramd);
    this.b.c(paramd);
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      this.a.write("</stream:stream>");
      this.a.flush();
      return;
    }
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<stream:stream");
    localStringBuilder.append(" xmlns=\"xm\"");
    localStringBuilder.append(" xmlns:stream=\"xm\"");
    localStringBuilder.append(" to=\"").append(this.b.d()).append("\"");
    localStringBuilder.append(" version=\"105\"");
    localStringBuilder.append(" model=\"").append(g.a(Build.MODEL)).append("\"");
    localStringBuilder.append(" os=\"").append(g.a(Build.VERSION.INCREMENTAL)).append("\"");
    localStringBuilder.append(" connpt=\"").append(g.a(this.b.f())).append("\"");
    localStringBuilder.append(" host=\"").append(this.b.e()).append("\"");
    localStringBuilder.append(">");
    this.a.write(localStringBuilder.toString());
    this.a.flush();
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      try
      {
        this.a.write(this.b.u() + "\r\n");
        this.a.flush();
        this.b.w();
        return;
      }
      catch (IOException localIOException)
      {
        throw new w(localIOException);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.q
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */