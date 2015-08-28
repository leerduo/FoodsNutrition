package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.utils.b;

public abstract class Service
{
  private Context a;
  private String b;
  
  void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String getAppKey()
  {
    return this.b;
  }
  
  public Context getContext()
  {
    return this.a;
  }
  
  public String getDeviceKey()
  {
    return b.a(this.a).p();
  }
  
  protected abstract int getServiceVersionInt();
  
  public abstract String getServiceVersionName();
  
  public void onBind() {}
  
  public void onUnbind() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.Service
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */