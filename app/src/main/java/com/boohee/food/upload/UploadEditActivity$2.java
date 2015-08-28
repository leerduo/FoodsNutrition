package com.boohee.food.upload;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.TextView;
import com.boohee.food.model.upload.DraftFood;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import com.umeng.analytics.MobclickAgent;
import org.json.JSONObject;

class UploadEditActivity$2
  extends JsonCallback
{
  UploadEditActivity$2(UploadEditActivity paramUploadEditActivity, Activity paramActivity)
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
    MobclickAgent.onEvent(UploadEditActivity.a(this.a), "success_upload");
    ToastUtils.b(this.a.getString(2131558623));
    UploadEditActivity.b(this.a).delete();
    this.a.b.postDelayed(new UploadEditActivity.2.1(this), this.a.getResources().getInteger(2131492873));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadEditActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */