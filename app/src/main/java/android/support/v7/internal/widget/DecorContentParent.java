package android.support.v7.internal.widget;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.view.Menu;

public abstract interface DecorContentParent
{
  public abstract void a(int paramInt);
  
  public abstract void a(Menu paramMenu, MenuPresenter.Callback paramCallback);
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract boolean h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void setWindowCallback(WindowCallback paramWindowCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.DecorContentParent
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */