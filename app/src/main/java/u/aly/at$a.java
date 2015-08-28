package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class at$a
  extends di<at>
{
  public void a(cy paramcy, at paramat)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      if (!paramat.c()) {
        throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
    }
    else
    {
      switch (localct.c)
      {
      default: 
        db.a(paramcy, localct.b);
      }
      for (;;)
      {
        paramcy.i();
        break;
        if (localct.b == 13)
        {
          cv localcv = paramcy.j();
          paramat.a = new HashMap(2 * localcv.c);
          for (int i = 0; i < localcv.c; i++)
          {
            String str = paramcy.v();
            au localau = new au();
            localau.a(paramcy);
            paramat.a.put(str, localau);
          }
          paramcy.k();
          paramat.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 8)
          {
            paramat.b = paramcy.s();
            paramat.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 11)
            {
              paramat.c = paramcy.v();
              paramat.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
            }
          }
        }
      }
    }
    paramat.e();
  }
  
  public void b(cy paramcy, at paramat)
  {
    paramat.e();
    paramcy.a(at.f());
    if (paramat.a != null)
    {
      paramcy.a(at.g());
      paramcy.a(new cv((byte)11, (byte)12, paramat.a.size()));
      Iterator localIterator = paramat.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramcy.a((String)localEntry.getKey());
        ((au)localEntry.getValue()).b(paramcy);
      }
      paramcy.d();
      paramcy.b();
    }
    paramcy.a(at.h());
    paramcy.a(paramat.b);
    paramcy.b();
    if (paramat.c != null)
    {
      paramcy.a(at.i());
      paramcy.a(paramat.c);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.at.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */