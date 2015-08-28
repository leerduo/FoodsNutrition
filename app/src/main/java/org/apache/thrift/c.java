package org.apache.thrift;

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

public final class c
{
  private static final Comparator a = new c.a(null);
  
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
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong2 < paramLong1) {
      return 1;
    }
    return 0;
  }
  
  public static int a(Comparable paramComparable1, Comparable paramComparable2)
  {
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    return paramString1.compareTo(paramString2);
  }
  
  public static int a(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramByteBuffer.remaining();
    System.arraycopy(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramArrayOfByte, paramInt, i);
    return i;
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
  
  public static int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return Boolean.valueOf(paramBoolean1).compareTo(Boolean.valueOf(paramBoolean2));
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
    int j = paramByteBuffer.limit();
    if (j - i > 128) {}
    for (int k = i + 128;; k = j) {
      for (int m = i; m < k; m++)
      {
        if (m > i) {
          paramStringBuilder.append(" ");
        }
        paramStringBuilder.append(a(arrayOfByte[m]));
      }
    }
    if (j != k) {
      paramStringBuilder.append("...");
    }
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    if (b(paramByteBuffer)) {
      return paramByteBuffer.array();
    }
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    a(paramByteBuffer, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static boolean b(ByteBuffer paramByteBuffer)
  {
    return (paramByteBuffer.hasArray()) && (paramByteBuffer.position() == 0) && (paramByteBuffer.arrayOffset() == 0) && (paramByteBuffer.remaining() == paramByteBuffer.capacity());
  }
  
  public static ByteBuffer c(ByteBuffer paramByteBuffer)
  {
    if (b(paramByteBuffer)) {
      return paramByteBuffer;
    }
    return ByteBuffer.wrap(a(paramByteBuffer));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */