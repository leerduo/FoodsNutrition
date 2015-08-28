package android.support.v7.app;

import android.annotation.TargetApi;
import android.support.v7.internal.view.SupportActionModeWrapper;
import android.support.v7.internal.view.SupportActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.View;

@TargetApi(11)
class ActionBarActivityDelegateHC
  extends ActionBarActivityDelegateBase
  implements NativeActionModeAwareLayout.OnActionModeForChildListener
{
  private NativeActionModeAwareLayout k;
  
  ActionBarActivityDelegateHC(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public android.view.ActionMode a(View paramView, ActionMode.Callback paramCallback)
  {
    android.support.v7.view.ActionMode localActionMode = b(new SupportActionModeWrapper.CallbackWrapper(paramView.getContext(), paramCallback));
    if (localActionMode != null) {
      return new SupportActionModeWrapper(this.a, localActionMode);
    }
    return null;
  }
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  void q()
  {
    this.k = ((NativeActionModeAwareLayout)this.a.findViewById(16908290));
    if (this.k != null) {
      this.k.setActionModeForChildListener(this);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateHC
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */