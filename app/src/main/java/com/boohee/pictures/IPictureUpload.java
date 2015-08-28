package com.boohee.pictures;

public abstract class IPictureUpload
{
  public abstract void onFailed(String paramString);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onStart();
  
  public abstract void onSuccess(String paramString);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.IPictureUpload
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */