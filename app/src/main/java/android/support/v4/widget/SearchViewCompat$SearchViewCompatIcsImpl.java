package android.support.v4.widget;

import android.content.Context;
import android.view.View;

class SearchViewCompat$SearchViewCompatIcsImpl
  extends SearchViewCompat.SearchViewCompatHoneycombImpl
{
  public View newSearchView(Context paramContext)
  {
    return SearchViewCompatIcs.newSearchView(paramContext);
  }
  
  public void setImeOptions(View paramView, int paramInt)
  {
    SearchViewCompatIcs.setImeOptions(paramView, paramInt);
  }
  
  public void setInputType(View paramView, int paramInt)
  {
    SearchViewCompatIcs.setInputType(paramView, paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompat.SearchViewCompatIcsImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */