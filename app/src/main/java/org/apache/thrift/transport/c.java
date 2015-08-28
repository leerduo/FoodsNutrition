package org.apache.thrift.transport;

public abstract class c
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void a(int paramInt) {}
  
  public byte[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public int c()
  {
    return -1;
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0) {
        throw new d("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes.");
      }
      i += j;
    }
    return i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     org.apache.thrift.transport.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */