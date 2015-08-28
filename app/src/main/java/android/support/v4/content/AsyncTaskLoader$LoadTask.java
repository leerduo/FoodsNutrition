package android.support.v4.content;

import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask
  extends ModernAsyncTask<Void, Void, D>
  implements Runnable
{
  private CountDownLatch done = new CountDownLatch(1);
  D result;
  boolean waiting;
  
  AsyncTaskLoader$LoadTask(AsyncTaskLoader paramAsyncTaskLoader) {}
  
  protected D doInBackground(Void... paramVarArgs)
  {
    this.result = this.this$0.onLoadInBackground();
    return this.result;
  }
  
  protected void onCancelled()
  {
    try
    {
      this.this$0.dispatchOnCancelled(this, this.result);
      return;
    }
    finally
    {
      this.done.countDown();
    }
  }
  
  protected void onPostExecute(D paramD)
  {
    try
    {
      this.this$0.dispatchOnLoadComplete(this, paramD);
      return;
    }
    finally
    {
      this.done.countDown();
    }
  }
  
  public void run()
  {
    this.waiting = false;
    this.this$0.executePendingTask();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.AsyncTaskLoader.LoadTask
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */