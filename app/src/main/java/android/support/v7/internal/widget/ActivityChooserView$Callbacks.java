package android.support.v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;

class ActivityChooserView$Callbacks
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private ActivityChooserView$Callbacks(ActivityChooserView paramActivityChooserView) {}
  
  private void a()
  {
    if (ActivityChooserView.h(this.a) != null) {
      ActivityChooserView.h(this.a).onDismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == ActivityChooserView.e(this.a))
    {
      this.a.b();
      ResolveInfo localResolveInfo = ActivityChooserView.a(this.a).b();
      int i = ActivityChooserView.a(this.a).e().a(localResolveInfo);
      Intent localIntent = ActivityChooserView.a(this.a).e().b(i);
      if (localIntent != null)
      {
        localIntent.addFlags(524288);
        this.a.getContext().startActivity(localIntent);
      }
      return;
    }
    if (paramView == ActivityChooserView.f(this.a))
    {
      ActivityChooserView.a(this.a, false);
      ActivityChooserView.a(this.a, ActivityChooserView.g(this.a));
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void onDismiss()
  {
    a();
    if (this.a.a != null) {
      this.a.a.subUiVisibilityChanged(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (((ActivityChooserView.ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      ActivityChooserView.a(this.a, 2147483647);
    }
    do
    {
      return;
      this.a.b();
      if (!ActivityChooserView.d(this.a)) {
        break;
      }
    } while (paramInt <= 0);
    ActivityChooserView.a(this.a).e().c(paramInt);
    return;
    if (ActivityChooserView.a(this.a).f()) {}
    for (;;)
    {
      Intent localIntent = ActivityChooserView.a(this.a).e().b(paramInt);
      if (localIntent == null) {
        break;
      }
      localIntent.addFlags(524288);
      this.a.getContext().startActivity(localIntent);
      return;
      paramInt++;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == ActivityChooserView.e(this.a))
    {
      if (ActivityChooserView.a(this.a).getCount() > 0)
      {
        ActivityChooserView.a(this.a, true);
        ActivityChooserView.a(this.a, ActivityChooserView.g(this.a));
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.Callbacks
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */