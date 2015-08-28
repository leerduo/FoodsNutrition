package com.google.zxing.client.androidlegacy.common.executor;

import android.os.AsyncTask;

public final class DefaultAsyncTaskExecInterface
  implements AsyncTaskExecInterface
{
  public <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs)
  {
    paramAsyncTask.execute(paramVarArgs);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.common.executor.DefaultAsyncTaskExecInterface
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */