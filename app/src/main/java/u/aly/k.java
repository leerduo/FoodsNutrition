package u.aly;

import android.content.Context;
import com.umeng.analytics.d;
import com.umeng.analytics.onlineconfig.a;
import com.umeng.analytics.onlineconfig.c;

public final class k
  implements o
{
  private static k c;
  private o a;
  private Context b;
  
  private k(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new j(this.b);
  }
  
  public static k a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null)) {
        c = new k(paramContext);
      }
      k localk = c;
      return localk;
    }
    finally {}
  }
  
  public void a()
  {
    d.b(new k.2(this));
  }
  
  public void a(a parama)
  {
    if ((parama != null) && (this.a != null)) {
      parama.a((c)this.a);
    }
  }
  
  public void a(p paramp)
  {
    d.b(new k.1(this, paramp));
  }
  
  public void b()
  {
    d.b(new k.3(this));
  }
  
  public void b(p paramp)
  {
    this.a.b(paramp);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */