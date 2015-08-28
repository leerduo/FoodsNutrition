package com.boohee.food;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;

class SearchActivity$SearchTextWatcher
  implements TextWatcher
{
  private SearchActivity$SearchTextWatcher(SearchActivity paramSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable.toString()))
    {
      this.a.d.setVisibility(8);
      return;
    }
    this.a.d.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */