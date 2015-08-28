package android.support.v4.app;

class FragmentManagerImpl$3
  implements Runnable
{
  FragmentManagerImpl$3(FragmentManagerImpl paramFragmentManagerImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    this.this$0.popBackStackState(this.this$0.mActivity.mHandler, this.val$name, -1, this.val$flags);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */