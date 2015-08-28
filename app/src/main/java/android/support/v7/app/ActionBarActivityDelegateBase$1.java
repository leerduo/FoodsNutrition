package android.support.v7.app;

class ActionBarActivityDelegateBase$1
  implements Runnable
{
  ActionBarActivityDelegateBase$1(ActionBarActivityDelegateBase paramActionBarActivityDelegateBase) {}
  
  public void run()
  {
    if ((0x1 & ActionBarActivityDelegateBase.a(this.a)) != 0) {
      ActionBarActivityDelegateBase.a(this.a, 0);
    }
    if ((0x100 & ActionBarActivityDelegateBase.a(this.a)) != 0) {
      ActionBarActivityDelegateBase.a(this.a, 8);
    }
    ActionBarActivityDelegateBase.a(this.a, false);
    ActionBarActivityDelegateBase.b(this.a, 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */