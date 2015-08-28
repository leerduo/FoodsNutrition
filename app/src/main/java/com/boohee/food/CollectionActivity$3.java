package com.boohee.food;

import android.app.Activity;
import android.content.res.Resources;
import com.boohee.food.adapter.CollectionAdapter;
import com.boohee.food.model.Food;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.BooheeListView;
import com.boohee.food.volley.JsonCallback;
import java.util.List;

class CollectionActivity$3
  extends JsonCallback
{
  CollectionActivity$3(CollectionActivity paramCollectionActivity, Activity paramActivity, boolean paramBoolean)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    if (this.a) {
      this.b.d();
    }
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
  }
  
  public void a(org.json.JSONObject paramJSONObject)
  {
    int i = 0;
    try
    {
      CollectionActivity.a(this.b, paramJSONObject.optInt("page"));
      CollectionActivity.b(this.b, paramJSONObject.optInt("total_pages"));
      List localList = com.alibaba.fastjson.JSONObject.parseArray(paramJSONObject.optString("foods"), Food.class);
      if ((localList != null) && (localList.size() > 0))
      {
        CollectionActivity.a(this.b).addAll(localList);
        while (i < localList.size())
        {
          CollectionActivity.b(this.b).add(Boolean.valueOf(false));
          i++;
        }
        CollectionActivity.c(this.b).notifyDataSetChanged();
        return;
      }
      ToastUtils.b(this.b.getString(2131558443));
      this.b.b.postDelayed(new CollectionActivity.3.1(this), this.b.getResources().getInteger(2131492873));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CollectionActivity.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */