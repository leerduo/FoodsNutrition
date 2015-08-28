package u.aly;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ca
{
  private static final Comparator a = new ca.a(null);
  
  public static int a(byte paramByte1, byte paramByte2)
  {
    if (paramByte1 < paramByte2) {
      return -1;
    }
    if (paramByte2 < paramByte1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt2 < paramInt1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static int a(List paramList1, List paramList2)
  {
    int i = a(paramList1.size(), paramList2.size());
    int m;
    if (i != 0)
    {
      m = i;
      return m;
    }
    for (int j = 0;; j++)
    {
      int k = paramList1.size();
      m = 0;
      if (j >= k) {
        break;
      }
      int n = a.compare(paramList1.get(j), paramList2.get(j));
      if (n != 0) {
        return n;
      }
    }
  }
  
  public static int a(Map paramMap1, Map paramMap2)
  {
    int i = a(paramMap1.size(), paramMap2.size());
    if (i != 0) {
      return i;
    }
    TreeMap localTreeMap1 = new TreeMap(a);
    localTreeMap1.putAll(paramMap1);
    Iterator localIterator1 = localTreeMap1.entrySet().iterator();
    TreeMap localTreeMap2 = new TreeMap(a);
    localTreeMap2.putAll(paramMap2);
    Iterator localIterator2 = localTreeMap2.entrySet().iterator();
    while ((localIterator1.hasNext()) && (localIterator2.hasNext()))
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      int j = a.compare(localEntry1.getKey(), localEntry2.getKey());
      if (j != 0) {
        return j;
      }
      int k = a.compare(localEntry1.getValue(), localEntry2.getValue());
      if (k != 0) {
        return k;
      }
    }
    return 0;
  }
  
  public static int a(Set paramSet1, Set paramSet2)
  {
    int i = a(paramSet1.size(), paramSet2.size());
    if (i != 0) {
      return i;
    }
    TreeSet localTreeSet1 = new TreeSet(a);
    localTreeSet1.addAll(paramSet1);
    TreeSet localTreeSet2 = new TreeSet(a);
    localTreeSet2.addAll(paramSet2);
    Iterator localIterator1 = localTreeSet1.iterator();
    Iterator localIterator2 = localTreeSet2.iterator();
    while ((localIterator1.hasNext()) && (localIterator2.hasNext()))
    {
      int j = a.compare(localIterator1.next(), localIterator2.next());
      if (j != 0) {
        return j;
      }
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = a(paramArrayOfByte1.length, paramArrayOfByte2.length);
    int m;
    if (i != 0)
    {
      m = i;
      return m;
    }
    for (int j = 0;; j++)
    {
      int k = paramArrayOfByte1.length;
      m = 0;
      if (j >= k) {
        break;
      }
      int n = a(paramArrayOfByte1[j], paramArrayOfByte2[j]);
      if (n != 0) {
        return n;
      }
    }
  }
  
  public static String a(byte paramByte)
  {
    return Integer.toHexString(0x1FF & (paramByte | 0x100)).toUpperCase().substring(1);
  }
  
  public static void a(ByteBuffer paramByteBuffer, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset();
    int j = i + paramByteBuffer.position();
    int k = i + paramByteBuffer.limit();
    if (k - j > 128) {}
    for (int m = j + 128;; m = k) {
      for (int n = j; n < m; n++)
      {
        if (n > j) {
          paramStringBuilder.append(" ");
        }
        paramStringBuilder.append(a(arrayOfByte[n]));
      }
    }
    if (k != m) {
      paramStringBuilder.append("...");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ca
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */