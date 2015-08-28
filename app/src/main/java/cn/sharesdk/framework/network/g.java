package cn.sharesdk.framework.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class g
  extends e
{
  private ArrayList<e> a = new ArrayList();
  
  public g a(e parame)
  {
    this.a.add(parame);
    return this;
  }
  
  protected InputStream a()
  {
    h localh = new h();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localh.a(((e)localIterator.next()).a());
    }
    return localh;
  }
  
  protected long b()
  {
    Iterator localIterator = this.a.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((e)localIterator.next()).b()) {}
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((e)localIterator.next()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */