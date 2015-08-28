package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;

class a
  implements Handler.Callback
{
  a(FakeActivity paramFakeActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    Context localContext = (Context)arrayOfObject[0];
    Intent localIntent = (Intent)arrayOfObject[1];
    if (!(localContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localContext.startActivity(localIntent);
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */