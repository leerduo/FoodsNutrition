package com.loopj.android.http;

abstract class Base64$Coder
{
  public int op;
  public byte[] output;
  
  public abstract int maxOutputSize(int paramInt);
  
  public abstract boolean process(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.Base64.Coder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */