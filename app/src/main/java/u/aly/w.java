package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class w
{
  public int a;
  public int b;
  public long c;
  private final int d = 3600000;
  private int e;
  private long f = 0L;
  private long g = 0L;
  private Context h;
  
  public w(Context paramContext)
  {
    b(paramContext);
  }
  
  public static aj a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = u.a(paramContext);
    aj localaj = new aj();
    localaj.b(localSharedPreferences.getInt("failed_requests ", 0));
    localaj.c(localSharedPreferences.getInt("last_request_spent_ms", 0));
    localaj.a(localSharedPreferences.getInt("successful_request", 0));
    return localaj;
  }
  
  private void b(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    SharedPreferences localSharedPreferences = u.a(paramContext);
    this.a = localSharedPreferences.getInt("successful_request", 0);
    this.b = localSharedPreferences.getInt("failed_requests ", 0);
    this.e = localSharedPreferences.getInt("last_request_spent_ms", 0);
    this.c = localSharedPreferences.getLong("last_request_time", 0L);
  }
  
  public boolean a()
  {
    return this.c == 0L;
  }
  
  public void b()
  {
    this.a = (1 + this.a);
    this.c = this.f;
  }
  
  public void c()
  {
    this.b = (1 + this.b);
  }
  
  public void d()
  {
    this.f = System.currentTimeMillis();
  }
  
  public void e()
  {
    this.e = ((int)(System.currentTimeMillis() - this.f));
  }
  
  public void f()
  {
    u.a(this.h).edit().putInt("successful_request", this.a).putInt("failed_requests ", this.b).putInt("last_request_spent_ms", this.e).putLong("last_request_time", this.c).commit();
  }
  
  public void g()
  {
    u.a(this.h).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
  }
  
  public boolean h()
  {
    if (this.g == 0L) {
      this.g = u.a(this.h).getLong("first_activate_time", 0L);
    }
    return this.g == 0L;
  }
  
  public long i()
  {
    if (h()) {
      return System.currentTimeMillis();
    }
    return this.g;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.w
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */