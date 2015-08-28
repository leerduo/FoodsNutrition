package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.Theme;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.string;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.support.v7.internal.widget.ActivityChooserView;
import android.support.v7.internal.widget.TintManager;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class ShareActionProvider
  extends ActionProvider
{
  private int a;
  private final ShareActionProvider.ShareMenuItemOnMenuItemClickListener b;
  private final Context c;
  private String d;
  
  public boolean hasSubMenu()
  {
    return true;
  }
  
  public View onCreateActionView()
  {
    ActivityChooserModel localActivityChooserModel = ActivityChooserModel.a(this.c, this.d);
    ActivityChooserView localActivityChooserView = new ActivityChooserView(this.c);
    localActivityChooserView.setActivityChooserModel(localActivityChooserModel);
    TypedValue localTypedValue = new TypedValue();
    this.c.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, localTypedValue, true);
    localActivityChooserView.setExpandActivityOverflowButtonDrawable(TintManager.a(this.c, localTypedValue.resourceId));
    localActivityChooserView.setProvider(this);
    localActivityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
    localActivityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
    return localActivityChooserView;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    paramSubMenu.clear();
    ActivityChooserModel localActivityChooserModel = ActivityChooserModel.a(this.c, this.d);
    PackageManager localPackageManager = this.c.getPackageManager();
    int i = localActivityChooserModel.a();
    int j = Math.min(i, this.a);
    for (int k = 0; k < j; k++)
    {
      ResolveInfo localResolveInfo2 = localActivityChooserModel.a(k);
      paramSubMenu.add(0, k, k, localResolveInfo2.loadLabel(localPackageManager)).setIcon(localResolveInfo2.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.b);
    }
    if (j < i)
    {
      SubMenu localSubMenu = paramSubMenu.addSubMenu(0, j, j, this.c.getString(R.string.abc_activity_chooser_view_see_all));
      for (int m = 0; m < i; m++)
      {
        ResolveInfo localResolveInfo1 = localActivityChooserModel.a(m);
        localSubMenu.add(0, m, m, localResolveInfo1.loadLabel(localPackageManager)).setIcon(localResolveInfo1.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.b);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ShareActionProvider
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */