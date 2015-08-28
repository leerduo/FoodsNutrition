package m.framework.ui.widget.pulltorefresh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;

public class ScrollableListView
  extends ListView
  implements Scrollable
{
  private OnScrollListener a;
  private boolean b;
  
  public ScrollableListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setCacheColorHint(0);
    setSelector(new ColorDrawable());
    this.a = new ScrollableListView.1(this);
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i = super.computeVerticalScrollOffset();
    if (this.a != null) {
      this.a.a(this, 0, i, 0, 0);
    }
    return i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.ScrollableListView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */