package butterknife.internal;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class DebouncingOnClickListener
  implements View.OnClickListener
{
  private static boolean a = true;
  private static final Runnable b = new DebouncingOnClickListener.1();
  
  public abstract void a(View paramView);
  
  public final void onClick(View paramView)
  {
    if (a)
    {
      a = false;
      paramView.post(b);
      a(paramView);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     butterknife.internal.DebouncingOnClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */