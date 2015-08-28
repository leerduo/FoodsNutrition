package com.boohee.food;

import android.app.Activity;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONObject;

class CollectionActivity$4
  extends JsonCallback
{
  CollectionActivity$4(CollectionActivity paramCollectionActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    CollectionActivity.b(this.a, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.CollectionActivity.4
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */