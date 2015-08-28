package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$ActivityChooserViewAdapter
  extends BaseAdapter
{
  private ActivityChooserModel b;
  private int c = 4;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView paramActivityChooserView) {}
  
  public int a()
  {
    int i = 0;
    int j = this.c;
    this.c = 2147483647;
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = getCount();
    View localView = null;
    int i1 = 0;
    while (i < n)
    {
      localView = getView(i, localView, null);
      localView.measure(k, m);
      i1 = Math.max(i1, localView.getMeasuredWidth());
      i++;
    }
    this.c = j;
    return i1;
  }
  
  public void a(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public void a(ActivityChooserModel paramActivityChooserModel)
  {
    ActivityChooserModel localActivityChooserModel = ActivityChooserView.a(this.a).e();
    if ((localActivityChooserModel != null) && (this.a.isShown())) {
      localActivityChooserModel.unregisterObserver(ActivityChooserView.i(this.a));
    }
    this.b = paramActivityChooserModel;
    if ((paramActivityChooserModel != null) && (this.a.isShown())) {
      paramActivityChooserModel.registerObserver(ActivityChooserView.i(this.a));
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.d != paramBoolean1) || (this.e != paramBoolean2))
    {
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public ResolveInfo b()
  {
    return this.b.b();
  }
  
  public int c()
  {
    return this.b.a();
  }
  
  public int d()
  {
    return this.b.c();
  }
  
  public ActivityChooserModel e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public int getCount()
  {
    int i = this.b.a();
    if ((!this.d) && (this.b.b() != null)) {
      i--;
    }
    int j = Math.min(i, this.c);
    if (this.f) {
      j++;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      return null;
    }
    if ((!this.d) && (this.b.b() != null)) {
      paramInt++;
    }
    return this.b.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.f) && (paramInt == -1 + getCount())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if ((paramView == null) || (paramView.getId() != 1))
      {
        paramView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
        paramView.setId(1);
        ((TextView)paramView.findViewById(R.id.title)).setText(this.a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
      }
      break;
    }
    do
    {
      return paramView;
      if ((paramView == null) || (paramView.getId() != R.id.list_item)) {
        paramView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      PackageManager localPackageManager = this.a.getContext().getPackageManager();
      ImageView localImageView = (ImageView)paramView.findViewById(R.id.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      localImageView.setImageDrawable(localResolveInfo.loadIcon(localPackageManager));
      ((TextView)paramView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(localPackageManager));
    } while ((!this.d) || (paramInt != 0) || (!this.e));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.ActivityChooserViewAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */