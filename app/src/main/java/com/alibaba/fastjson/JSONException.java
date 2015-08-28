package com.alibaba.fastjson;

public class JSONException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public JSONException() {}
  
  public JSONException(String paramString)
  {
    super(paramString);
  }
  
  public JSONException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.JSONException
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */