package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class HighLevelEncoder
{
  static final String[] a = { "UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT" };
  static final int[][] b = { { 0, 327708, 327710, 327709, 656318 }, { 590318, 0, 327710, 327709, 656318 }, { 262158, 590300, 0, 590301, 932798 }, { 327709, 327708, 656318, 0, 327710 }, { 327711, 656380, 656382, 656381, 0 } };
  static final int[][] c;
  private static final int[][] d;
  private final byte[] e;
  
  static
  {
    int[] arrayOfInt1 = { 5, 256 };
    d = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt1);
    d[0][32] = 1;
    for (int i = 65; i <= 90; i++) {
      d[0][i] = (2 + (i - 65));
    }
    d[1][32] = 1;
    for (int j = 97; j <= 122; j++) {
      d[1][j] = (2 + (j - 97));
    }
    d[2][32] = 1;
    for (int k = 48; k <= 57; k++) {
      d[2][k] = (2 + (k - 48));
    }
    d[2][44] = 12;
    d[2][46] = 13;
    int[] arrayOfInt2 = { 0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127 };
    for (int m = 0; m < arrayOfInt2.length; m++) {
      d[3][arrayOfInt2[m]] = m;
    }
    int[] arrayOfInt3 = { 0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125 };
    for (int n = 0; n < arrayOfInt3.length; n++) {
      if (arrayOfInt3[n] > 0) {
        d[4][arrayOfInt3[n]] = n;
      }
    }
    int[] arrayOfInt4 = { 6, 6 };
    c = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt4);
    int[][] arrayOfInt = c;
    int i1 = arrayOfInt.length;
    for (int i2 = 0; i2 < i1; i2++) {
      Arrays.fill(arrayOfInt[i2], -1);
    }
    c[0][4] = 0;
    c[1][4] = 0;
    c[1][0] = 28;
    c[3][4] = 0;
    c[2][4] = 0;
    c[2][0] = 15;
  }
  
  public HighLevelEncoder(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
  }
  
  private static Collection<State> a(Iterable<State> paramIterable)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = paramIterable.iterator();
    label42:
    label113:
    label117:
    for (;;)
    {
      State localState1;
      Iterator localIterator2;
      State localState2;
      if (localIterator1.hasNext())
      {
        localState1 = (State)localIterator1.next();
        localIterator2 = localLinkedList.iterator();
        if (!localIterator2.hasNext()) {
          break label113;
        }
        localState2 = (State)localIterator2.next();
        if (!localState2.a(localState1)) {}
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label117;
        }
        localLinkedList.add(localState1);
        break;
        if (!localState1.a(localState2)) {
          break label42;
        }
        localIterator2.remove();
        break label42;
        return localLinkedList;
      }
    }
  }
  
  private Collection<State> a(Iterable<State> paramIterable, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      a((State)localIterator.next(), paramInt, localLinkedList);
    }
    return a(localLinkedList);
  }
  
  private static Collection<State> a(Iterable<State> paramIterable, int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      a((State)localIterator.next(), paramInt1, paramInt2, localLinkedList);
    }
    return a(localLinkedList);
  }
  
  private static void a(State paramState, int paramInt1, int paramInt2, Collection<State> paramCollection)
  {
    State localState = paramState.b(paramInt1);
    paramCollection.add(localState.a(4, paramInt2));
    if (paramState.a() != 4) {
      paramCollection.add(localState.b(4, paramInt2));
    }
    if ((paramInt2 == 3) || (paramInt2 == 4)) {
      paramCollection.add(localState.a(2, 16 - paramInt2).a(2, 1));
    }
    if (paramState.b() > 0) {
      paramCollection.add(paramState.a(paramInt1).a(paramInt1 + 1));
    }
  }
  
  private void a(State paramState, int paramInt, Collection<State> paramCollection)
  {
    int i = (char)(0xFF & this.e[paramInt]);
    if (d[paramState.a()][i] > 0) {}
    for (int j = 1;; j = 0)
    {
      State localState = null;
      for (int k = 0; k <= 4; k++)
      {
        int m = d[k][i];
        if (m > 0)
        {
          if (localState == null) {
            localState = paramState.b(paramInt);
          }
          if ((j == 0) || (k == paramState.a()) || (k == 2)) {
            paramCollection.add(localState.a(k, m));
          }
          if ((j == 0) && (c[paramState.a()][k] >= 0)) {
            paramCollection.add(localState.b(k, m));
          }
        }
      }
    }
    if ((paramState.b() > 0) || (d[paramState.a()][i] == 0)) {
      paramCollection.add(paramState.a(paramInt));
    }
  }
  
  public BitArray a()
  {
    Object localObject = Collections.singletonList(State.a);
    int i = 0;
    if (i < this.e.length)
    {
      int j;
      label38:
      int k;
      if (i + 1 < this.e.length)
      {
        j = this.e[(i + 1)];
        switch (this.e[i])
        {
        default: 
          k = 0;
          label91:
          if (k > 0)
          {
            localObject = a((Iterable)localObject, i, k);
            i++;
          }
          break;
        }
      }
      for (;;)
      {
        i++;
        break;
        j = 0;
        break label38;
        if (j == 10)
        {
          k = 2;
          break label91;
        }
        k = 0;
        break label91;
        if (j == 32)
        {
          k = 3;
          break label91;
        }
        k = 0;
        break label91;
        if (j == 32)
        {
          k = 4;
          break label91;
        }
        k = 0;
        break label91;
        if (j == 32)
        {
          k = 5;
          break label91;
        }
        k = 0;
        break label91;
        localObject = a((Iterable)localObject, i);
      }
    }
    return ((State)Collections.min((Collection)localObject, new HighLevelEncoder.1(this))).a(this.e);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.HighLevelEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */