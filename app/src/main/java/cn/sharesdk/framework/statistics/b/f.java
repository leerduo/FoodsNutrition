package cn.sharesdk.framework.statistics.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.a;
import cn.sharesdk.framework.utils.e;

public class f
  extends c
{
  private static int p;
  private static long q;
  public int a;
  public String b;
  public String c;
  public f.a d = new f.a();
  public String n;
  public String[] o;
  
  protected String a()
  {
    return "[SHR]";
  }
  
  protected void a(long paramLong)
  {
    q = paramLong;
  }
  
  protected int b()
  {
    return 5000;
  }
  
  protected int c()
  {
    return 30;
  }
  
  protected long d()
  {
    return p;
  }
  
  protected long e()
  {
    return q;
  }
  
  protected void f()
  {
    p = 1 + p;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(super.toString());
    localStringBuilder1.append('|').append(this.a);
    localStringBuilder1.append('|').append(this.b);
    StringBuilder localStringBuilder2 = localStringBuilder1.append('|');
    String str1;
    if (TextUtils.isEmpty(this.c)) {
      str1 = "";
    }
    for (;;)
    {
      localStringBuilder2.append(str1);
      String str2 = "";
      if ((this.o != null) && (this.o.length > 0)) {
        str2 = "[\"" + TextUtils.join("\",\"", this.o) + "\"]";
      }
      localStringBuilder1.append('|').append(str2);
      localStringBuilder1.append('|');
      String str4;
      if (this.d != null) {
        str4 = this.d.toString();
      }
      try
      {
        String str5 = Base64.encodeToString(a.a(this.f.substring(0, 16), str4), 0);
        if (str5.contains("\n")) {
          str5 = str5.replace("\n", "");
        }
        localStringBuilder1.append(str5);
        localStringBuilder1.append('|');
        if (!TextUtils.isEmpty(this.m)) {
          localStringBuilder1.append(this.m);
        }
        localStringBuilder1.append('|');
        if (!TextUtils.isEmpty(this.n)) {}
        try
        {
          String str3 = Base64.encodeToString(a.a(this.f.substring(0, 16), this.n), 0);
          if (str3.contains("\n")) {
            str3 = str3.replace("\n", "");
          }
          localStringBuilder1.append(str3);
          return localStringBuilder1.toString();
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            e.c(localThrowable1);
          }
        }
        str1 = this.c;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          e.c(localThrowable2);
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.b.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */