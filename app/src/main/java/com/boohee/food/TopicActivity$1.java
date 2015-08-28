package com.boohee.food;

import android.app.Activity;
import com.boohee.food.adapter.TopicAdapter;
import com.boohee.food.model.TopicDetail;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

class TopicActivity$1
  extends JsonCallback
{
  TopicActivity$1(TopicActivity paramTopicActivity, Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(org.json.JSONObject paramJSONObject)
  {
    try
    {
      org.json.JSONObject localJSONObject = paramJSONObject.getJSONObject("topic");
      TopicActivity.a(this.a, localJSONObject.getString("title"));
      TopicActivity.b(this.a, localJSONObject.getString("sub_title"));
      List localList = com.alibaba.fastjson.JSONObject.parseArray(localJSONObject.getJSONArray("pages").toString(), TopicDetail.class);
      if ((localList != null) && (localList.size() > 0))
      {
        TopicActivity.a(this.a).clear();
        TopicActivity.a(this.a).addAll(localList);
        TopicActivity.b(this.a).notifyDataSetChanged();
        TopicActivity.c(this.a);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      ToastUtils.b(localJSONException.getMessage());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.TopicActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */