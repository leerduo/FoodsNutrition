package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.FakeActivity;
import cn.sharesdk.framework.Platform;

public class a
  extends FakeActivity
{
  protected AuthorizeHelper a;
  
  public AuthorizeHelper a()
  {
    return this.a;
  }
  
  public void a(AuthorizeHelper paramAuthorizeHelper)
  {
    this.a = paramAuthorizeHelper;
    super.show(paramAuthorizeHelper.getPlatform().getContext(), null);
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */