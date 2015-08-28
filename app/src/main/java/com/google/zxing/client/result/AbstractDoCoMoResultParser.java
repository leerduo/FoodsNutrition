package com.google.zxing.client.result;

abstract class AbstractDoCoMoResultParser
  extends ResultParser
{
  static String[] a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1, paramString2, ';', paramBoolean);
  }
  
  static String b(String paramString1, String paramString2, boolean paramBoolean)
  {
    return b(paramString1, paramString2, ';', paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AbstractDoCoMoResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */