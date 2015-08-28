package com.boohee.food;

import android.app.Activity;
import com.alibaba.fastjson.JSON;
import com.boohee.food.adapter.HotListAdapter;
import com.boohee.food.view.NoScrollGridView;
import com.boohee.food.volley.JsonCallback;
import java.util.List;
import org.json.JSONObject;

class SearchActivity$2
  extends JsonCallback
{
  SearchActivity$2(SearchActivity paramSearchActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    try
    {
      List localList = JSON.parseArray(paramJSONObject.optString("keywords"), String.class);
      if ((localList != null) && (localList.size() > 0))
      {
        SearchActivity.a(this.a).addAll(localList);
        this.a.b.setAdapter(new HotListAdapter(this.a.a, SearchActivity.a(this.a)));
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SearchActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */