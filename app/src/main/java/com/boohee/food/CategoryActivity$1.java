package com.boohee.food;

import android.app.Activity;
import com.boohee.food.adapter.CategoryAdapter;
import com.boohee.food.model.Category;
import com.boohee.food.volley.JsonCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CategoryActivity$1
  extends JsonCallback
{
  CategoryActivity$1(CategoryActivity paramCategoryActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      List localList = Category.parse(paramJSONObject.getJSONArray("categories").toString());
      if ((localList != null) && (localList.size() > 0))
      {
        CategoryActivity.a(this.a).addAll(localList);
        CategoryActivity.b(this.a).notifyDataSetChanged();
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CategoryActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */