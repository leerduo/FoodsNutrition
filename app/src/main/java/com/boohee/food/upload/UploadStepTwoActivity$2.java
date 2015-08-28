package com.boohee.food.upload;

import android.app.Activity;
import com.boohee.food.MyActivity;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONObject;

class UploadStepTwoActivity$2
  extends JsonCallback
{
  UploadStepTwoActivity$2(UploadStepTwoActivity paramUploadStepTwoActivity, Activity paramActivity)
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
    MobclickAgent.onEvent(UploadStepTwoActivity.a(this.a), "success_upload");
    ToastUtils.b(this.a.getString(2131558623));
    this.a.finish();
    MyActivity.a(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepTwoActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */