package com.boohee.food;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class SearchActivity$SearchOnEditorActionListener
  implements TextView.OnEditorActionListener
{
  private SearchActivity$SearchOnEditorActionListener(SearchActivity paramSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    SearchActivity.c(this.a);
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity.SearchOnEditorActionListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */