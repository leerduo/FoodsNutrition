package com.android.volley;

import java.util.Map;

public class NetworkResponse
{
  public final int a;
  public final byte[] b;
  public final Map<String, String> c;
  public final boolean d;
  public final long e;
  
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.a = paramInt;
    this.b = paramArrayOfByte;
    this.c = paramMap;
    this.d = paramBoolean;
    this.e = paramLong;
  }
  
  public NetworkResponse(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.NetworkResponse
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */