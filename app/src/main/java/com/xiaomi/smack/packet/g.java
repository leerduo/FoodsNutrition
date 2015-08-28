package com.xiaomi.smack.packet;

public class g
{
  private String a;
  
  public g(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stream:error (").append(this.a).append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.g
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */