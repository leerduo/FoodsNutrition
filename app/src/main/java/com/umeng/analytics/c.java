package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.onlineconfig.a;
import java.util.HashMap;
import java.util.Map;
import u.aly.ac;
import u.aly.bj;
import u.aly.k;
import u.aly.m;
import u.aly.n;
import u.aly.t;
import u.aly.u;
import u.aly.v;
import u.aly.z;

public class c
  implements t
{
  private final a a = new a();
  private Context b = null;
  private b c;
  private m d = new m();
  private z e = new z();
  private v f = new v();
  private n g;
  private k h;
  private boolean i = false;
  
  c()
  {
    this.d.a(this);
  }
  
  private void f(Context paramContext)
  {
    if (!this.i)
    {
      this.b = paramContext.getApplicationContext();
      this.g = new n(this.b);
      this.h = k.a(this.b);
      this.i = true;
    }
  }
  
  private void g(Context paramContext)
  {
    this.f.c(paramContext);
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private void h(Context paramContext)
  {
    this.f.d(paramContext);
    this.e.a(paramContext);
    if (this.c != null) {
      this.c.b();
    }
    this.h.b();
  }
  
  public void a(int paramInt)
  {
    AnalyticsConfig.mVerticalType = paramInt;
  }
  
  void a(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    this.a.a(paramContext);
    try
    {
      k.a(paramContext).a(this.a);
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in reportError");
      return;
    }
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.h.a(new ac(paramString).a(false));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      d.a(new c.3(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.g.a(paramString1, paramString2, paramLong, paramInt);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  public void a(Context paramContext, String paramString, HashMap<String, Object> paramHashMap)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.g.a(paramString, paramHashMap);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void a(Context paramContext, String paramString1, HashMap<String, Object> paramHashMap, String paramString2)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      d.a(new c.5(this, paramString1, paramHashMap, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void a(Context paramContext, String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.g.a(paramString, paramMap, paramLong);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void a(Context paramContext, Throwable paramThrowable)
  {
    if ((paramContext == null) || (paramThrowable == null)) {
      return;
    }
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.h.a(new ac(paramThrowable).a(false));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  void a(UmengOnlineConfigureListener paramUmengOnlineConfigureListener)
  {
    this.a.a(paramUmengOnlineConfigureListener);
  }
  
  void a(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {}
    try
    {
      this.e.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    AnalyticsConfig.mWrapperType = paramString1;
    AnalyticsConfig.mWrapperVersion = paramString2;
  }
  
  public void a(Throwable paramThrowable)
  {
    try
    {
      this.e.a();
      if (this.b != null)
      {
        if ((paramThrowable != null) && (this.h != null)) {
          this.h.b(new ac(paramThrowable));
        }
        h(this.b);
        u.a(this.b).edit().commit();
      }
      d.a();
      return;
    }
    catch (Exception localException)
    {
      bj.a("MobclickAgent", "Exception in onAppCrash", localException);
    }
  }
  
  void b(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
      this.e.a(paramContext.getClass().getName());
    }
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      d.a(new c.1(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", localException);
    }
  }
  
  void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      d.a(new c.4(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void b(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {}
    try
    {
      this.e.b(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void c(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onPause");
      return;
    }
    if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
      this.e.b(paramContext.getClass().getName());
    }
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      d.a(new c.2(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", localException);
    }
  }
  
  void c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      d.a(new c.6(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void d(Context paramContext)
  {
    try
    {
      if (!this.i) {
        f(paramContext);
      }
      this.h.a();
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }
  
  void e(Context paramContext)
  {
    try
    {
      this.e.a();
      h(paramContext);
      u.a(paramContext).edit().commit();
      d.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */