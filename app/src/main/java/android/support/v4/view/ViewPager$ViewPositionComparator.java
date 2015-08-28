package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class ViewPager$ViewPositionComparator
  implements Comparator<View>
{
  public int compare(View paramView1, View paramView2)
  {
    ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)paramView1.getLayoutParams();
    ViewPager.LayoutParams localLayoutParams2 = (ViewPager.LayoutParams)paramView2.getLayoutParams();
    if (localLayoutParams1.isDecor != localLayoutParams2.isDecor)
    {
      if (localLayoutParams1.isDecor) {
        return 1;
      }
      return -1;
    }
    return localLayoutParams1.position - localLayoutParams2.position;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager.ViewPositionComparator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */