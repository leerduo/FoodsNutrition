package com.xiaomi.network;

import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import org.apache.thrift.e;

class c
  extends TimerTask
{
  c(UploadHostStatHelper paramUploadHostStatHelper) {}
  
  public void run()
  {
    Iterator localIterator = UploadHostStatHelper.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      UploadHostStatHelper.HttpRecordCallback localHttpRecordCallback = (UploadHostStatHelper.HttpRecordCallback)localIterator.next();
      List localList = localHttpRecordCallback.a();
      double d = localHttpRecordCallback.b();
      if (localList != null) {
        try
        {
          if (localList.size() > 0) {
            UploadHostStatHelper.a(this.a, localList, d);
          }
        }
        catch (e locale)
        {
          locale.printStackTrace();
        }
      }
    }
    UploadHostStatHelper.a(this.a, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */