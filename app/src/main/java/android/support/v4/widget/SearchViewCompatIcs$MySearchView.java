package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class SearchViewCompatIcs$MySearchView
  extends SearchView
{
  public SearchViewCompatIcs$MySearchView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    super.onActionViewCollapsed();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompatIcs.MySearchView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */