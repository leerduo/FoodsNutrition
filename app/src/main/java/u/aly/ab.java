package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ab
  extends ao
  implements p
{
  public ab(String paramString, Map<String, Object> paramMap, long paramLong, int paramInt)
  {
    a(paramString);
    b(System.currentTimeMillis());
    if (paramMap.size() > 0) {
      a(b(paramMap));
    }
    if (paramInt > 0) {}
    for (;;)
    {
      a(paramInt);
      if (paramLong > 0L) {
        a(paramLong);
      }
      return;
      paramInt = 1;
    }
  }
  
  public static aa a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    aa localaa = new aa();
    localaa.b = paramString1;
    localaa.c = paramString2;
    localaa.d = paramMap;
    return localaa;
  }
  
  public static String b(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    return paramString1 + paramString2;
  }
  
  private HashMap<String, az> b(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    int i = 0;
    label208:
    while ((i < 10) && (localIterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      az localaz = new az();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof String)) {
        localaz.a((String)localObject);
      }
      for (;;)
      {
        if (!localaz.d()) {
          break label208;
        }
        localHashMap.put(localEntry.getKey(), localaz);
        i++;
        break;
        if ((localObject instanceof Long)) {
          localaz.a(((Long)localObject).longValue());
        } else if ((localObject instanceof Integer)) {
          localaz.a(((Integer)localObject).longValue());
        } else if ((localObject instanceof Float)) {
          localaz.a(((Float)localObject).longValue());
        } else if ((localObject instanceof Double)) {
          localaz.a(((Double)localObject).longValue());
        }
      }
    }
    return localHashMap;
  }
  
  public void a(bf parambf, String paramString)
  {
    av localav;
    if (parambf.b() > 0)
    {
      Iterator localIterator = parambf.c().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localav = (av)localIterator.next();
      } while (!paramString.equals(localav.a()));
    }
    for (;;)
    {
      if (localav == null)
      {
        localav = new av();
        localav.a(paramString);
        parambf.a(localav);
      }
      localav.a(this);
      return;
      localav = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ab
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */