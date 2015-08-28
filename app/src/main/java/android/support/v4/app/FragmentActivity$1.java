package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

class FragmentActivity$1
  extends Handler
{
  FragmentActivity$1(FragmentActivity paramFragmentActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 1: 
      do
      {
        return;
      } while (!this.this$0.mStopped);
      this.this$0.doReallyStop(false);
      return;
    }
    this.this$0.onResumeFragments();
    this.this$0.mFragments.execPendingActions();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */