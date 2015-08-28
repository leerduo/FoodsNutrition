package com.boohee.food.adapter;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import java.util.List;

class CollectionAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  CollectionAdapter$1(CollectionAdapter paramCollectionAdapter, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    CollectionAdapter.a(this.b).set(this.a, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.CollectionAdapter.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */