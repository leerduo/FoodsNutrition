package u.aly;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.ReportPolicy.a;
import com.umeng.analytics.ReportPolicy.b;
import com.umeng.analytics.ReportPolicy.c;
import com.umeng.analytics.ReportPolicy.d;
import com.umeng.analytics.ReportPolicy.e;
import com.umeng.analytics.ReportPolicy.f;
import com.umeng.analytics.f;
import java.util.Iterator;
import java.util.List;

public final class j
  implements com.umeng.analytics.onlineconfig.c, o
{
  private q a = null;
  private r b = null;
  private ReportPolicy.e c = null;
  private f d = null;
  private w e = null;
  private d f = null;
  private int g = 10;
  private Context h;
  
  public j(Context paramContext)
  {
    this.h = paramContext;
    this.a = new q(paramContext);
    this.f = h.a(paramContext);
    this.e = new w(paramContext);
    this.b = new r(paramContext);
    this.b.a(this.e);
    this.d = f.a(paramContext);
    int[] arrayOfInt = AnalyticsConfig.getReportPolicy(this.h);
    a(arrayOfInt[0], arrayOfInt[1]);
  }
  
  private bf a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      bf localbf = new bf();
      new cc().a(localbf, paramArrayOfByte);
      return localbf;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      this.c = new ReportPolicy.a();
    }
    for (;;)
    {
      bj.c("MobclickAgent", "report policy:" + paramInt1 + " interval:" + paramInt2);
      return;
      this.c = new ReportPolicy.a();
      continue;
      this.c = new ReportPolicy.b(this.e, paramInt2);
      continue;
      this.c = new ReportPolicy.d(this.e);
      continue;
      this.c = new ReportPolicy.e();
      continue;
      this.c = new ReportPolicy.f(this.h);
      continue;
      this.c = new ReportPolicy.c(this.a, paramInt2);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!bi.g(this.h))
    {
      if (bj.a) {
        bj.c("MobclickAgent", "network is unavailable");
      }
      bool = false;
    }
    while ((this.e.a()) || ((bj.a) && (bi.q(this.h)))) {
      return bool;
    }
    return this.c.a(paramBoolean);
  }
  
  private byte[] a(bf parambf)
  {
    try
    {
      byte[] arrayOfByte = new ci().a(parambf);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private boolean d()
  {
    return this.a.a() > this.g;
  }
  
  private void e()
  {
    try
    {
      if (this.e.a()) {
        this.a.a(new ah(this.e.i()));
      }
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (((localThrowable instanceof OutOfMemoryError)) && (localThrowable == null)) {}
      localThrowable.printStackTrace();
    }
  }
  
  private void f()
  {
    f localf = f.a(this.h);
    boolean bool = localf.f();
    byte[] arrayOfByte2;
    if (bool) {
      arrayOfByte2 = localf.d();
    }
    switch (this.b.a(arrayOfByte2))
    {
    default: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return;
          this.f.a();
          byte[] arrayOfByte1 = c();
          if (arrayOfByte1 == null)
          {
            bj.d("MobclickAgent", "message is null");
            return;
          }
          arrayOfByte2 = c.a(this.h, AnalyticsConfig.getAppkey(this.h), arrayOfByte1).c();
          localf.c();
          break;
          if (this.e.h()) {
            this.e.g();
          }
          this.f.c();
          this.e.f();
        } while (!bool);
        localf.e();
        return;
        this.e.f();
      } while (!bool);
      localf.e();
      return;
    }
    if (!bool) {
      localf.b(arrayOfByte2);
    }
    bj.b("MobclickAgent", "connection error");
  }
  
  public void a()
  {
    if (bi.g(this.h)) {
      e();
    }
    while (!bj.a) {
      return;
    }
    bj.c("MobclickAgent", "network is unavailable");
  }
  
  public void a(int paramInt, long paramLong)
  {
    AnalyticsConfig.setReportPolicy(paramInt, (int)paramLong);
    a(paramInt, (int)paramLong);
  }
  
  public void a(p paramp)
  {
    if (paramp != null) {
      this.a.a(paramp);
    }
    if (a(paramp instanceof bd)) {
      e();
    }
    while (!d()) {
      return;
    }
    b();
  }
  
  public void b()
  {
    if (this.a.a() > 0) {}
    try
    {
      byte[] arrayOfByte = c();
      if (arrayOfByte != null) {
        this.d.a(arrayOfByte);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        if ((localThrowable instanceof OutOfMemoryError)) {
          this.d.c();
        }
      } while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }
  
  public void b(p paramp)
  {
    this.a.a(paramp);
  }
  
  protected byte[] c()
  {
    for (;;)
    {
      bf localbf1;
      int j;
      byte[] arrayOfByte2;
      try
      {
        if (TextUtils.isEmpty(AnalyticsConfig.getAppkey(this.h)))
        {
          bj.b("MobclickAgent", "Appkey is missing ,Please check AndroidManifest.xml");
          return null;
        }
        byte[] arrayOfByte1 = f.a(this.h).b();
        if (arrayOfByte1 == null)
        {
          localbf1 = null;
          if ((localbf1 == null) && (this.a.a() == 0)) {
            return null;
          }
        }
        else
        {
          localbf1 = a(arrayOfByte1);
          continue;
        }
        if (localbf1 != null) {
          break label242;
        }
        localbf2 = new bf();
        this.a.a(localbf2);
        if ((bj.a) && (localbf2.f()))
        {
          i = 0;
          Iterator localIterator = localbf2.e().iterator();
          if (localIterator.hasNext())
          {
            if (((bd)localIterator.next()).d() <= 0) {
              break label235;
            }
            j = 1;
            break label251;
          }
          if (i == 0) {
            bj.d("MobclickAgent", "missing Activities or PageViews");
          }
        }
        byte[] arrayOfByte3;
        j = i;
      }
      catch (Exception localException1)
      {
        try
        {
          arrayOfByte3 = a(localbf2);
          arrayOfByte2 = arrayOfByte3;
          try
          {
            if (!bj.a) {
              break label248;
            }
            bj.c("MobclickAgent", localbf2.toString());
            return arrayOfByte2;
          }
          catch (Exception localException3) {}
          bj.b("MobclickAgent", "Fail to serialize log ...");
          return arrayOfByte2;
        }
        catch (Exception localException2)
        {
          arrayOfByte2 = null;
          continue;
        }
        localException1 = localException1;
        bj.b("MobclickAgent", "Fail to construct message ...", localException1);
        f.a(this.h).c();
        return null;
      }
      label235:
      break label251;
      label242:
      bf localbf2 = localbf1;
      continue;
      label248:
      return arrayOfByte2;
      label251:
      int i = j;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */