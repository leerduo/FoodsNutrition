package m.framework.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class UIHandler
{
  private static Handler a;
  
  private static Message a(Message paramMessage, Handler.Callback paramCallback)
  {
    Message localMessage = new Message();
    localMessage.obj = new Object[] { paramMessage, paramCallback };
    return localMessage;
  }
  
  public static void a()
  {
    if (a == null) {
      a = new Handler(new UIHandler.1());
    }
  }
  
  public static boolean a(Message paramMessage, long paramLong, Handler.Callback paramCallback)
  {
    return a.sendMessageDelayed(a(paramMessage, paramCallback), paramLong);
  }
  
  private static void b(Message paramMessage)
  {
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    Message localMessage = (Message)arrayOfObject[0];
    Handler.Callback localCallback = (Handler.Callback)arrayOfObject[1];
    if (localCallback != null) {
      localCallback.handleMessage(localMessage);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.utils.UIHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */