package org.apache.thrift.transport;

public final class b
  extends c
{
  private byte[] a;
  private int b;
  private int c;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = c();
    if (paramInt2 > i) {
      paramInt2 = i;
    }
    if (paramInt2 > 0)
    {
      System.arraycopy(this.a, this.b, paramArrayOfByte, paramInt1, paramInt2);
      a(paramInt2);
    }
    return paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.b = (paramInt + this.b);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    c(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("No writing allowed!");
  }
  
  public int c()
  {
    return this.c - this.b;
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.transport.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */