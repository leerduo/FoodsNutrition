package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareActionProvider$ShareMenuItemOnMenuItemClickListener
  implements MenuItem.OnMenuItemClickListener
{
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    Intent localIntent = ActivityChooserModel.a(ShareActionProvider.a(this.a), ShareActionProvider.b(this.a)).b(paramMenuItem.getItemId());
    if (localIntent != null)
    {
      localIntent.addFlags(524288);
      ShareActionProvider.a(this.a).startActivity(localIntent);
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */