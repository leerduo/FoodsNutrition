package com.boohee.food.upload;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.food.volley.JsonCallback;
import org.json.JSONArray;
import org.json.JSONObject;

class UploadStepOneActivity$1
  extends JsonCallback
{
  UploadStepOneActivity$1(UploadStepOneActivity paramUploadStepOneActivity, Activity paramActivity, String paramString)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    this.b.d();
  }
  
  public void a(String paramString)
  {
    ToastUtils.b(paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      LogUtils.a(paramJSONObject.toString());
      JSONArray localJSONArray = paramJSONObject.optJSONArray("foods");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        this.b.b.setText(this.a);
        this.b.d.setEnabled(true);
        return;
      }
      this.b.b.setText("");
      this.b.d.setEnabled(false);
      ToastUtils.b(this.b.getString(2131558632));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepOneActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */