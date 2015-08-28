package android.support.v4.widget;

class SearchViewCompat$SearchViewCompatHoneycombImpl$1
  implements SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
{
  SearchViewCompat$SearchViewCompatHoneycombImpl$1(SearchViewCompat.SearchViewCompatHoneycombImpl paramSearchViewCompatHoneycombImpl, SearchViewCompat.OnQueryTextListenerCompat paramOnQueryTextListenerCompat) {}
  
  public boolean onQueryTextChange(String paramString)
  {
    return this.val$listener.onQueryTextChange(paramString);
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    return this.val$listener.onQueryTextSubmit(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */