package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class Loader$ForceLoadContentObserver
  extends ContentObserver
{
  public Loader$ForceLoadContentObserver(Loader paramLoader)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    this.this$0.onContentChanged();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.Loader.ForceLoadContentObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */