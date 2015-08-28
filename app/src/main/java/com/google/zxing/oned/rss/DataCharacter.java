package com.google.zxing.oned.rss;

public class DataCharacter
{
  private final int a;
  private final int b;
  
  public DataCharacter(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DataCharacter)) {}
    DataCharacter localDataCharacter;
    do
    {
      return false;
      localDataCharacter = (DataCharacter)paramObject;
    } while ((this.a != localDataCharacter.a) || (this.b != localDataCharacter.b));
    return true;
  }
  
  public final int hashCode()
  {
    return this.a ^ this.b;
  }
  
  public final String toString()
  {
    return this.a + "(" + this.b + ')';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.DataCharacter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */