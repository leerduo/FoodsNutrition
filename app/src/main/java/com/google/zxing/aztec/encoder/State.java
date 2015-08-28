package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class State
{
  static final State a = new State(Token.a, 0, 0, 0);
  private final int b;
  private final Token c;
  private final int d;
  private final int e;
  
  private State(Token paramToken, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramToken;
    this.b = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  int a()
  {
    return this.b;
  }
  
  State a(int paramInt)
  {
    Token localToken1 = this.c;
    int i = this.b;
    int j = this.e;
    Token localToken3;
    if ((this.b == 4) || (this.b == 2))
    {
      int k = HighLevelEncoder.b[i][0];
      Token localToken2 = localToken1.a(0xFFFF & k, k >> 16);
      j += (k >> 16);
      localToken3 = localToken2;
      i = 0;
    }
    for (;;)
    {
      int m;
      if ((this.d == 0) || (this.d == 31)) {
        m = 18;
      }
      State localState;
      for (;;)
      {
        localState = new State(localToken3, i, 1 + this.d, j + m);
        if (localState.d != 2078) {
          break;
        }
        return localState.b(paramInt + 1);
        if (this.d == 62) {
          m = 9;
        } else {
          m = 8;
        }
      }
      return localState;
      localToken3 = localToken1;
    }
  }
  
  State a(int paramInt1, int paramInt2)
  {
    int i = this.e;
    Token localToken1 = this.c;
    Token localToken3;
    int j;
    if (paramInt1 != this.b)
    {
      int m = HighLevelEncoder.b[this.b][paramInt1];
      localToken3 = localToken1.a(0xFFFF & m, m >> 16);
      j = i + (m >> 16);
    }
    for (Token localToken2 = localToken3;; localToken2 = localToken1)
    {
      if (paramInt1 == 2) {}
      for (int k = 4;; k = 5) {
        return new State(localToken2.a(paramInt2, k), paramInt1, 0, k + j);
      }
      j = i;
    }
  }
  
  BitArray a(byte[] paramArrayOfByte)
  {
    LinkedList localLinkedList = new LinkedList();
    for (Token localToken = b(paramArrayOfByte.length).c; localToken != null; localToken = localToken.a()) {
      localLinkedList.addFirst(localToken);
    }
    BitArray localBitArray = new BitArray();
    Iterator localIterator = localLinkedList.iterator();
    while (localIterator.hasNext()) {
      ((Token)localIterator.next()).a(localBitArray, paramArrayOfByte);
    }
    return localBitArray;
  }
  
  boolean a(State paramState)
  {
    int i = this.e + (HighLevelEncoder.b[this.b][paramState.b] >> 16);
    if ((paramState.d > 0) && ((this.d == 0) || (this.d > paramState.d))) {
      i += 10;
    }
    return i <= paramState.e;
  }
  
  int b()
  {
    return this.d;
  }
  
  State b(int paramInt)
  {
    if (this.d == 0) {
      return this;
    }
    return new State(this.c.b(paramInt - this.d, this.d), this.b, 0, this.e);
  }
  
  State b(int paramInt1, int paramInt2)
  {
    Token localToken = this.c;
    if (this.b == 2) {}
    for (int i = 4;; i = 5) {
      return new State(localToken.a(HighLevelEncoder.c[this.b][paramInt1], i).a(paramInt2, 5), this.b, 0, 5 + (i + this.e));
    }
  }
  
  int c()
  {
    return this.e;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = HighLevelEncoder.a[this.b];
    arrayOfObject[1] = Integer.valueOf(this.e);
    arrayOfObject[2] = Integer.valueOf(this.d);
    return String.format("%s bits=%d bytes=%d", arrayOfObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.encoder.State
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */