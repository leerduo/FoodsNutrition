package android.support.v4.content;

import android.os.Handler;
import android.os.Message;

class ModernAsyncTask$InternalHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ModernAsyncTask.AsyncTaskResult localAsyncTaskResult = (ModernAsyncTask.AsyncTaskResult)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ModernAsyncTask.access$500(localAsyncTaskResult.mTask, localAsyncTaskResult.mData[0]);
      return;
    }
    localAsyncTaskResult.mTask.onProgressUpdate(localAsyncTaskResult.mData);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.InternalHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */