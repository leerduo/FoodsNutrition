package com.boohee.food.upload;

import android.widget.Button;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.pictures.IPictureUpload;

class UploadStepTwoActivity$1
  extends IPictureUpload
{
  UploadStepTwoActivity$1(UploadStepTwoActivity paramUploadStepTwoActivity) {}
  
  public void onFailed(String paramString)
  {
    this.a.c.setEnabled(true);
    this.a.d();
    ToastUtils.b(this.a.getString(2131558631));
  }
  
  public void onProgress(int paramInt)
  {
    LogUtils.a("progress" + paramInt);
  }
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    LogUtils.a(paramString);
    UploadStepTwoActivity.a(this.a, paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadStepTwoActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */