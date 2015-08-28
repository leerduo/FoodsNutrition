package cn.sharesdk.framework.authorize;

import android.content.Intent;

public abstract class f
{
  protected e a;
  protected int b;
  protected SSOListener c;
  
  public f(e parame)
  {
    this.a = parame;
    this.c = parame.a().getSSOListener();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Intent paramIntent) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */