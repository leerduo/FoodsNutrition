package m.framework.ui.widget.asyncview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import java.util.Random;
import m.framework.utils.UIHandler;
import m.framework.utils.Utils;

public class AsyncImageView
  extends ImageView
  implements Handler.Callback, AsyncView, BitmapCallback
{
  private static Bitmap a;
  private static final Random b = new Random();
  private static String c;
  private String d;
  private int e;
  private OnImageGotListener f;
  
  public AsyncImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private Bitmap a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BitmapFactory.decodeResource(getResources(), paramInt);
    }
    if (a == null) {
      a = BitmapFactory.decodeResource(getResources(), 17170445);
    }
    return a;
  }
  
  private void a(Context paramContext)
  {
    
    if (TextUtils.isEmpty(c)) {
      c = Utils.a(getContext(), "images");
    }
    BitmapProcessor.a(c);
    setOnImageGotListener(SimpleOnImageGotListener.a);
  }
  
  public void a(String paramString)
  {
    a(paramString, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
    if (Utils.a(paramString))
    {
      setImageResource(paramInt);
      return;
    }
    Bitmap localBitmap = BitmapProcessor.b(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      setImageBitmap(localBitmap);
      return;
    }
    if (paramInt > 0) {
      setImageBitmap(a(paramInt));
    }
    BitmapProcessor.a(paramString, this);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.f != null) {
      paramBitmap = this.f.a(this, paramBitmap, paramString);
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramString, paramBitmap };
    UIHandler.a(localMessage, b.nextInt(300), this);
  }
  
  public String getUrl()
  {
    return this.d;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      Object localObject1 = ((Object[])paramMessage.obj)[0];
      Object localObject2 = ((Object[])paramMessage.obj)[1];
      if ((localObject2 != null) && (localObject1 != null) && (localObject1.equals(this.d))) {
        setImageBitmap((Bitmap)localObject2);
      }
    }
    else
    {
      return false;
    }
    setImageResource(this.e);
    return false;
  }
  
  public void setOnImageGotListener(OnImageGotListener paramOnImageGotListener)
  {
    this.f = paramOnImageGotListener;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.asyncview.AsyncImageView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */