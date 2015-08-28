package u.aly;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public abstract class cj<T extends cj<?, ?>, F extends cg>
  implements bz<T, F>
{
  private static final Map<Class<? extends dg>, dh> a = new HashMap();
  protected Object b = null;
  protected F c = null;
  
  static
  {
    a.put(di.class, new cj.b(null));
    a.put(dj.class, new cj.d(null));
  }
  
  protected abstract Object a(cy paramcy, ct paramct);
  
  protected abstract Object a(cy paramcy, short paramShort);
  
  protected abstract ct a(F paramF);
  
  protected abstract dd a();
  
  public void a(cy paramcy)
  {
    ((dh)a.get(paramcy.y())).b().b(paramcy, this);
  }
  
  public F b()
  {
    return this.c;
  }
  
  protected abstract F b(short paramShort);
  
  public void b(cy paramcy)
  {
    ((dh)a.get(paramcy.y())).b().a(paramcy, this);
  }
  
  public Object c()
  {
    return this.b;
  }
  
  protected abstract void c(cy paramcy);
  
  protected abstract void d(cy paramcy);
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" ");
    Object localObject;
    if (b() != null)
    {
      localObject = c();
      localStringBuilder.append(a(b()).a);
      localStringBuilder.append(":");
      if (!(localObject instanceof ByteBuffer)) {
        break label99;
      }
      ca.a((ByteBuffer)localObject, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append(">");
      return localStringBuilder.toString();
      label99:
      localStringBuilder.append(localObject.toString());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cj
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */