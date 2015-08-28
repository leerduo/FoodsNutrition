package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.Gender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q
{
  private List<p> a = new ArrayList();
  private ah b = null;
  private ai c = null;
  private ak d = null;
  private ax e = null;
  private Context f = null;
  
  public q(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.c.a(AnalyticsConfig.getAppkey(paramContext));
      this.c.e(AnalyticsConfig.getChannel(paramContext));
      if ((AnalyticsConfig.mWrapperType != null) && (AnalyticsConfig.mWrapperVersion != null))
      {
        this.c.f(AnalyticsConfig.mWrapperType);
        this.c.g(AnalyticsConfig.mWrapperVersion);
      }
      this.c.c(bi.o(paramContext));
      this.c.a(bc.a);
      this.c.d("5.2.4");
      this.c.b(bi.b(paramContext));
      this.c.a(Integer.parseInt(bi.a(paramContext)));
      if (AnalyticsConfig.mVerticalType == 1)
      {
        this.c.b(AnalyticsConfig.mVerticalType);
        this.c.d("5.2.4.1");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(Context paramContext)
  {
    try
    {
      this.d.e(bi.a());
      this.d.a(bi.c(paramContext));
      this.d.b(bi.d(paramContext));
      this.d.c(bi.k(paramContext));
      this.d.d(Build.MODEL);
      this.d.f("Android");
      this.d.g(Build.VERSION.RELEASE);
      int[] arrayOfInt = bi.l(paramContext);
      if (arrayOfInt != null) {
        this.d.a(new ba(arrayOfInt[1], arrayOfInt[0]));
      }
      if ((AnalyticsConfig.GPU_RENDERER != null) && (AnalyticsConfig.GPU_VENDER != null)) {}
      this.d.h(Build.BOARD);
      this.d.i(Build.BRAND);
      this.d.a(Build.TIME);
      this.d.j(Build.MANUFACTURER);
      this.d.k(Build.ID);
      this.d.l(Build.DEVICE);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        String[] arrayOfString1 = bi.e(paramContext);
        if ("Wi-Fi".equals(arrayOfString1[0]))
        {
          this.e.a(ag.c);
          if (!"".equals(arrayOfString1[1])) {
            this.e.d(arrayOfString1[1]);
          }
          this.e.c(bi.m(paramContext));
          String[] arrayOfString2 = bi.i(paramContext);
          this.e.b(arrayOfString2[0]);
          this.e.a(arrayOfString2[1]);
          this.e.a(bi.h(paramContext));
          if ((AnalyticsConfig.sAge == 0) && (AnalyticsConfig.sGender == null) && (AnalyticsConfig.sId == null) && (AnalyticsConfig.sSource == null)) {
            break;
          }
          bg localbg = new bg();
          localbg.a(AnalyticsConfig.sAge);
          localbg.a(Gender.transGender(AnalyticsConfig.sGender));
          localbg.a(AnalyticsConfig.sId);
          localbg.b(AnalyticsConfig.sSource);
          this.e.a(localbg);
          return;
        }
        if ("2G/3G".equals(arrayOfString1[0])) {
          this.e.a(ag.b);
        } else {
          this.e.a(ag.a);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
  
  private String h()
  {
    return u.a(this.f).getString("session_id", null);
  }
  
  public int a()
  {
    try
    {
      int i = this.a.size();
      ah localah = this.b;
      if (localah != null) {
        i++;
      }
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ah paramah)
  {
    try
    {
      this.b = paramah;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(bf parambf)
  {
    String str = h();
    if (str == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((p)localIterator.next()).a(parambf, str);
      }
      this.a.clear();
    }
    finally {}
    if (this.b != null)
    {
      parambf.a(this.b);
      this.b = null;
    }
    parambf.a(b());
    parambf.a(c());
    parambf.a(d());
    parambf.a(g());
    parambf.a(e());
    parambf.a(f());
  }
  
  public void a(p paramp)
  {
    try
    {
      this.a.add(paramp);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ai b()
  {
    try
    {
      if (this.c == null)
      {
        this.c = new ai();
        a(this.f);
      }
      ai localai = this.c;
      return localai;
    }
    finally {}
  }
  
  public ak c()
  {
    try
    {
      if (this.d == null)
      {
        this.d = new ak();
        b(this.f);
      }
      ak localak = this.d;
      return localak;
    }
    finally {}
  }
  
  public ax d()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new ax();
        c(this.f);
      }
      ax localax = this.e;
      return localax;
    }
    finally {}
  }
  
  public at e()
  {
    try
    {
      at localat = h.b(this.f).a();
      return localat;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public as f()
  {
    try
    {
      as localas = h.a(this.f).b();
      return localas;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public aj g()
  {
    try
    {
      aj localaj = w.a(this.f);
      return localaj;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new aj();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.q
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */