package cn.sharesdk.framework.network;

import java.io.InputStream;
import org.apache.http.entity.InputStreamEntity;

public abstract class e
{
  private long a;
  private OnReadListener b;
  
  protected abstract InputStream a();
  
  protected abstract long b();
  
  public InputStreamEntity c()
  {
    c localc = new c(a());
    localc.a(this.b);
    if (this.a > 0L) {
      localc.skip(this.a);
    }
    return new InputStreamEntity(localc, b() - this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */