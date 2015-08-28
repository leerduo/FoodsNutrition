package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.l;
import cn.sharesdk.framework.statistics.b.g;
import java.io.PrintStream;
import java.util.Calendar;

public class b
  extends l
{
  private static b b;
  private Context c;
  private cn.sharesdk.framework.utils.b d;
  private a e;
  private String f;
  private Handler g;
  private boolean h;
  private int i;
  private boolean j;
  private long k;
  private boolean l;
  
  private b(Context paramContext)
  {
    super("Thread-" + Math.abs(-14904));
    this.c = paramContext;
    this.d = cn.sharesdk.framework.utils.b.a(paramContext);
    this.e = a.a(paramContext);
  }
  
  /* Error */
  public static b a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 73	cn/sharesdk/framework/statistics/b:b	Lcn/sharesdk/framework/statistics/b;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +28 -> 36
    //   11: aload_0
    //   12: ifnonnull +10 -> 22
    //   15: aconst_null
    //   16: astore_3
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_3
    //   21: areturn
    //   22: new 2	cn/sharesdk/framework/statistics/b
    //   25: dup
    //   26: aload_0
    //   27: invokevirtual 79	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   30: invokespecial 81	cn/sharesdk/framework/statistics/b:<init>	(Landroid/content/Context;)V
    //   33: putstatic 73	cn/sharesdk/framework/statistics/b:b	Lcn/sharesdk/framework/statistics/b;
    //   36: getstatic 73	cn/sharesdk/framework/statistics/b:b	Lcn/sharesdk/framework/statistics/b;
    //   39: astore_3
    //   40: goto -23 -> 17
    //   43: astore_1
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	paramContext	Context
    //   43	5	1	localObject	Object
    //   6	2	2	localb1	b
    //   16	24	3	localb2	b
    // Exception table:
    //   from	to	target	type
    //   3	7	43	finally
    //   22	36	43	finally
    //   36	40	43	finally
  }
  
  private void b(cn.sharesdk.framework.statistics.b.c paramc)
  {
    paramc.f = this.d.p();
    paramc.g = this.f;
    paramc.h = this.d.q();
    paramc.i = this.d.s();
    paramc.j = String.valueOf(30000 + this.i);
    paramc.k = this.d.o();
    paramc.l = this.d.n();
    if ((!"cn.sharesdk.demo".equals(paramc.h)) && ("api20".equals(this.f)) && (ShareSDK.isDebug())) {
      System.err.println("Your application is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
    }
    paramc.m = this.d.g();
  }
  
  private void c()
  {
    boolean bool = d();
    if (bool) {
      if (!this.l)
      {
        this.l = bool;
        this.k = System.currentTimeMillis();
        a(new g());
      }
    }
    while (!this.l) {
      return;
    }
    this.l = bool;
    long l1 = System.currentTimeMillis() - this.k;
    cn.sharesdk.framework.statistics.b.e locale = new cn.sharesdk.framework.statistics.b.e();
    locale.a = l1;
    a(locale);
  }
  
  private void c(cn.sharesdk.framework.statistics.b.c paramc)
  {
    try
    {
      this.e.a(paramc);
      paramc.b(this.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
      cn.sharesdk.framework.utils.e.c(paramc.toString(), new Object[0]);
    }
  }
  
  private boolean d()
  {
    cn.sharesdk.framework.utils.b localb = cn.sharesdk.framework.utils.b.a(this.c);
    String str1 = localb.v();
    String str2 = localb.q();
    return (str2 != null) && (str2.equals(str1));
  }
  
  private void e()
  {
    try
    {
      a.a(this.c).a();
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.e.c(localThrowable);
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(Handler paramHandler)
  {
    this.g = paramHandler;
  }
  
  protected void a(Message paramMessage)
  {
    if (!this.j)
    {
      this.j = true;
      this.e.a(this.f);
      this.e.b(this.f);
      this.a.sendEmptyMessageDelayed(4, 3600000L);
      this.e.a(this.h);
      this.a.sendEmptyMessage(1);
      this.a.sendEmptyMessage(2);
      NewAppReceiver.a(this.c);
    }
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    Message localMessage;
    if (this.j)
    {
      b(paramc);
      if (paramc.a(this.c))
      {
        localMessage = new Message();
        localMessage.what = 3;
        localMessage.obj = paramc;
      }
    }
    else
    {
      try
      {
        this.a.sendMessage(localMessage);
        return;
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
        return;
      }
    }
    cn.sharesdk.framework.utils.e.a("Drop event: " + paramc.toString(), new Object[0]);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected void b(Message paramMessage)
  {
    if (this.j)
    {
      long l1 = System.currentTimeMillis() - this.k;
      cn.sharesdk.framework.statistics.b.e locale = new cn.sharesdk.framework.statistics.b.e();
      locale.a = l1;
      a(locale);
      this.j = false;
    }
    try
    {
      this.g.sendEmptyMessage(1);
      b = null;
      this.a.getLooper().quit();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable);
      }
    }
  }
  
  protected void c(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
      do
      {
        return;
      } while (paramMessage.obj == null);
      c((cn.sharesdk.framework.statistics.b.c)paramMessage.obj);
      return;
    case 1: 
      c();
      try
      {
        this.a.sendEmptyMessageDelayed(1, 100L);
        return;
      }
      catch (Throwable localThrowable2)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable2);
        return;
      }
    case 2: 
      e();
      try
      {
        this.a.sendEmptyMessageDelayed(2, 10000L);
        return;
      }
      catch (Throwable localThrowable1)
      {
        cn.sharesdk.framework.utils.e.c(localThrowable1);
        return;
      }
    }
    long l1 = cn.sharesdk.framework.statistics.a.c.a(this.c).f().longValue();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l1);
    int m = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(5);
    if ((m != i2) || (n != i3) || (i1 != i4)) {
      this.e.b(this.f);
    }
    for (;;)
    {
      this.a.sendEmptyMessageDelayed(4, 3600000L);
      return;
      this.e.c(this.f);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */