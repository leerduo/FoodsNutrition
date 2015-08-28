package m.framework.ui.widget.asyncview;

import android.graphics.Bitmap;

public class SimpleOnImageGotListener
  implements OnImageGotListener
{
  public static final SimpleOnImageGotListener a = new SimpleOnImageGotListener();
  
  public Bitmap a(AsyncView paramAsyncView, Bitmap paramBitmap, String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0) && (paramString.equals(paramAsyncView.getUrl()))) {
      return paramBitmap;
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.SimpleOnImageGotListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */