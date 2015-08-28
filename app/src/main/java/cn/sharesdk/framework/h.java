package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.authorize.g;

public abstract class h
  implements AuthorizeHelper
{
  protected Platform a;
  private AuthorizeListener b;
  private SSOListener c;
  
  public h(Platform paramPlatform)
  {
    this.a = paramPlatform;
  }
  
  protected void a(SSOListener paramSSOListener)
  {
    this.c = paramSSOListener;
    e locale = new e();
    locale.a(paramSSOListener);
    locale.a(this);
  }
  
  protected void b(AuthorizeListener paramAuthorizeListener)
  {
    this.b = paramAuthorizeListener;
    g localg = new g();
    localg.a(this.b);
    localg.a(this);
  }
  
  public int c()
  {
    return this.a.getPlatformId();
  }
  
  public AuthorizeListener getAuthorizeListener()
  {
    return this.b;
  }
  
  public Platform getPlatform()
  {
    return this.a;
  }
  
  public SSOListener getSSOListener()
  {
    return this.c;
  }
  
  public f getSSOProcessor(e parame)
  {
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */