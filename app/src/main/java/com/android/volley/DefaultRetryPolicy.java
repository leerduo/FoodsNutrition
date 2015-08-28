package com.android.volley;

public class DefaultRetryPolicy
  implements RetryPolicy
{
  private int a;
  private int b;
  private final int c;
  private final float d;
  
  public DefaultRetryPolicy()
  {
    this(2500, 1, 1.0F);
  }
  
  public DefaultRetryPolicy(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(VolleyError paramVolleyError)
  {
    this.b = (1 + this.b);
    this.a = ((int)(this.a + this.a * this.d));
    if (!c()) {
      throw paramVolleyError;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected boolean c()
  {
    return this.b <= this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.DefaultRetryPolicy
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */