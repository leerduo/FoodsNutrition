package com.qiniu.android.storage;

public abstract interface Recorder
{
  public abstract void del(String paramString);
  
  public abstract byte[] get(String paramString);
  
  public abstract void set(String paramString, byte[] paramArrayOfByte);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.Recorder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */