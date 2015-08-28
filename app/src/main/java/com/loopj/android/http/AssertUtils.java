package com.loopj.android.http;

class AssertUtils
{
  public static void asserts(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AssertUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */