package android.support.v4.os;

import android.os.AsyncTask;

class AsyncTaskCompatHoneycomb
{
  static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> paramAsyncTask, Params... paramVarArgs)
  {
    paramAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramVarArgs);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.os.AsyncTaskCompatHoneycomb
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */