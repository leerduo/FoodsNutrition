package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

class CursorAdapter$ChangeObserver
  extends ContentObserver
{
  public CursorAdapter$ChangeObserver(CursorAdapter paramCursorAdapter)
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
 * Qualified Name:     android.support.v4.widget.CursorAdapter.ChangeObserver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */