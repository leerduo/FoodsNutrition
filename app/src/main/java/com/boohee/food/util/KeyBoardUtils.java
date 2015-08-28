package com.boohee.food.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyBoardUtils
{
  public static void a(Context paramContext, EditText paramEditText)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.KeyBoardUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */