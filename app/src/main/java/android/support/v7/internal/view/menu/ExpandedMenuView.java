package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class ExpandedMenuView
  extends ListView
  implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener
{
  private static final int[] a = { 16842964, 16843049 };
  private MenuBuilder b;
  private int c;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (localTintTypedArray.d(0)) {
      setBackgroundDrawable(localTintTypedArray.a(0));
    }
    if (localTintTypedArray.d(1)) {
      setDivider(localTintTypedArray.a(1));
    }
    localTintTypedArray.b();
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    this.b = paramMenuBuilder;
  }
  
  public boolean a(MenuItemImpl paramMenuItemImpl)
  {
    return this.b.a(paramMenuItemImpl, 0);
  }
  
  public int getWindowAnimations()
  {
    return this.c;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a((MenuItemImpl)getAdapter().getItem(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ExpandedMenuView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */