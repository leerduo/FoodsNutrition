package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class BarcodeValue
{
  private final Map<Integer, Integer> a = new HashMap();
  
  void a(int paramInt)
  {
    Integer localInteger1 = (Integer)this.a.get(Integer.valueOf(paramInt));
    if (localInteger1 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    Integer localInteger2 = Integer.valueOf(1 + localInteger1.intValue());
    this.a.put(Integer.valueOf(paramInt), localInteger2);
  }
  
  int[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.entrySet().iterator();
    int i = -1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      int k;
      if (((Integer)localEntry.getValue()).intValue() > i)
      {
        k = ((Integer)localEntry.getValue()).intValue();
        localArrayList.clear();
        localArrayList.add(localEntry.getKey());
      }
      for (int j = k;; j = i)
      {
        i = j;
        break;
        if (((Integer)localEntry.getValue()).intValue() == i) {
          localArrayList.add(localEntry.getKey());
        }
      }
    }
    return PDF417Common.a(localArrayList);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.BarcodeValue
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */