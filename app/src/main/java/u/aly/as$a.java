package u.aly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class as$a
  extends di<as>
{
  public void a(cy paramcy, as paramas)
  {
    paramcy.f();
    ct localct = paramcy.h();
    if (localct.b == 0)
    {
      paramcy.g();
      paramas.e();
      return;
    }
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
        paramas.a = new HashMap(2 * localcv.c);
        for (int j = 0; j < localcv.c; j++)
        {
          String str = paramcy.v();
          ar localar = new ar();
          localar.a(paramcy);
          paramas.a.put(str, localar);
        }
        paramcy.k();
        paramas.a(true);
      }
      else
      {
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 15)
        {
          cu localcu = paramcy.l();
          paramas.b = new ArrayList(localcu.b);
          for (int i = 0; i < localcu.b; i++)
          {
            aq localaq = new aq();
            localaq.a(paramcy);
            paramas.b.add(localaq);
          }
          paramcy.m();
          paramas.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramas.c = paramcy.v();
            paramas.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
  }
  
  public void b(cy paramcy, as paramas)
  {
    paramas.e();
    paramcy.a(as.f());
    if (paramas.a != null)
    {
      paramcy.a(as.g());
      paramcy.a(new cv((byte)11, (byte)12, paramas.a.size()));
      Iterator localIterator2 = paramas.a.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        paramcy.a((String)localEntry.getKey());
        ((ar)localEntry.getValue()).b(paramcy);
      }
      paramcy.d();
      paramcy.b();
    }
    if ((paramas.b != null) && (paramas.c()))
    {
      paramcy.a(as.h());
      paramcy.a(new cu((byte)12, paramas.b.size()));
      Iterator localIterator1 = paramas.b.iterator();
      while (localIterator1.hasNext()) {
        ((aq)localIterator1.next()).b(paramcy);
      }
      paramcy.e();
      paramcy.b();
    }
    if ((paramas.c != null) && (paramas.d()))
    {
      paramcy.a(as.i());
      paramcy.a(paramas.c);
      paramcy.b();
    }
    paramcy.c();
    paramcy.a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.as.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */