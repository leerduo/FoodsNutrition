package com.umeng.update;

public abstract interface UmengDownloadListener
{
  public abstract void OnDownloadEnd(int paramInt, String paramString);
  
  public abstract void OnDownloadStart();
  
  public abstract void OnDownloadUpdate(int paramInt);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengDownloadListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */