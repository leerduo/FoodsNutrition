package com.android.volley;

public class Response<T>
{
  public final T a;
  public final Cache.Entry b;
  public final VolleyError c;
  public boolean d = false;
  
  private Response(VolleyError paramVolleyError)
  {
    this.a = null;
    this.b = null;
    this.c = paramVolleyError;
  }
  
  private Response(T paramT, Cache.Entry paramEntry)
  {
    this.a = paramT;
    this.b = paramEntry;
    this.c = null;
  }
  
  public static <T> Response<T> a(VolleyError paramVolleyError)
  {
    return new Response(paramVolleyError);
  }
  
  public static <T> Response<T> a(T paramT, Cache.Entry paramEntry)
  {
    return new Response(paramT, paramEntry);
  }
  
  public boolean a()
  {
    return this.c == null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.Response
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */