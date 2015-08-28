package cn.sharesdk.framework.authorize;

import cn.sharesdk.framework.Platform;

public abstract interface AuthorizeHelper
{
  public abstract AuthorizeListener getAuthorizeListener();
  
  public abstract String getAuthorizeUrl();
  
  public abstract b getAuthorizeWebviewClient(g paramg);
  
  public abstract Platform getPlatform();
  
  public abstract String getRedirectUri();
  
  public abstract SSOListener getSSOListener();
  
  public abstract f getSSOProcessor(e parame);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.AuthorizeHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */