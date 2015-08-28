package com.boohee.food.upload;

import android.widget.Button;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.ToastUtils;
import com.boohee.pictures.IPictureUpload;

class UploadEditActivity$1
  extends IPictureUpload
{
  UploadEditActivity$1(UploadEditActivity paramUploadEditActivity) {}
  
  public void onFailed(String paramString)
  {
    this.a.f.setEnabled(true);
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
    this.a.d();
    UploadEditActivity.a(this.a, paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.upload.UploadEditActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */