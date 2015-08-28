package android.support.v4.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

class FragmentTabHost$DummyTabFactory
  implements TabHost.TabContentFactory
{
  private final Context mContext;
  
  public FragmentTabHost$DummyTabFactory(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public View createTabContent(String paramString)
  {
    View localView = new View(this.mContext);
    localView.setMinimumWidth(0);
    localView.setMinimumHeight(0);
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost.DummyTabFactory
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */