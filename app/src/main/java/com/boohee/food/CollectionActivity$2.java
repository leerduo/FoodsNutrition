package com.boohee.food;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.boohee.food.model.Food;
import java.util.List;

class CollectionActivity$2
  implements AdapterView.OnItemClickListener
{
  CollectionActivity$2(CollectionActivity paramCollectionActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DetailInfoActivity.a(this.a, ((Food)CollectionActivity.a(this.a).get(paramInt)).code);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CollectionActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */