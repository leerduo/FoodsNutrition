package com.boohee.food.upload;

import android.app.Activity;
import android.content.res.Resources;
import com.boohee.food.adapter.UploadAdapter;
import com.boohee.food.model.upload.UploadFood;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.view.BooheeListView;
import com.boohee.food.volley.JsonCallback;
import java.util.List;

class ListUploadActivity$2
  extends JsonCallback
{
  ListUploadActivity$2(ListUploadActivity paramListUploadActivity, Activity paramActivity)
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
  
  public void a(org.json.JSONObject paramJSONObject)
  {
    try
    {
      ListUploadActivity.a(this.a, paramJSONObject.optInt("page"));
      ListUploadActivity.b(this.a, paramJSONObject.optInt("total_pages"));
      List localList = com.alibaba.fastjson.JSONObject.parseArray(paramJSONObject.optString("food_drafts"), UploadFood.class);
      if ((localList != null) && (localList.size() > 0))
      {
        ListUploadActivity.b(this.a).addAll(localList);
        ListUploadActivity.c(this.a).notifyDataSetChanged();
        return;
      }
      ToastUtils.b(this.a.getString(2131558637));
      this.a.b.postDelayed(new ListUploadActivity.2.1(this), this.a.getResources().getInteger(2131492873));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.ListUploadActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */