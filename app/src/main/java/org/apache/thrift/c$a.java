package org.apache.thrift;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class c$a
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return 0;
    }
    if (paramObject1 == null) {
      return -1;
    }
    if (paramObject2 == null) {
      return 1;
    }
    if ((paramObject1 instanceof List)) {
      return c.a((List)paramObject1, (List)paramObject2);
    }
    if ((paramObject1 instanceof Set)) {
      return c.a((Set)paramObject1, (Set)paramObject2);
    }
    if ((paramObject1 instanceof Map)) {
      return c.a((Map)paramObject1, (Map)paramObject2);
    }
    if ((paramObject1 instanceof byte[])) {
      return c.a((byte[])paramObject1, (byte[])paramObject2);
    }
    return c.a((Comparable)paramObject1, (Comparable)paramObject2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.c.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */