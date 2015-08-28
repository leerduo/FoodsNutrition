package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
  private final byte[] a;
  private final String b;
  private final List<byte[]> c;
  private final String d;
  private Integer e;
  private Integer f;
  private Object g;
  private final int h;
  private final int i;
  
  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2)
  {
    this(paramArrayOfByte, paramString1, paramList, paramString2, -1, -1);
  }
  
  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramString1;
    this.c = paramList;
    this.d = paramString2;
    this.h = paramInt2;
    this.i = paramInt1;
  }
  
  public void a(Integer paramInteger)
  {
    this.e = paramInteger;
  }
  
  public void a(Object paramObject)
  {
    this.g = paramObject;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(Integer paramInteger)
  {
    this.f = paramInteger;
  }
  
  public List<byte[]> c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public Object e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return (this.h >= 0) && (this.i >= 0);
  }
  
  public int g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.common.DecoderResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */