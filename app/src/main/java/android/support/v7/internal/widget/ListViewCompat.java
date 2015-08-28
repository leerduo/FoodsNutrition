package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat
  extends ListView
{
  private static final int[] f = { 0 };
  final Rect a = new Rect();
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  private Field g;
  private ListViewCompat.GateKeeperDrawable h;
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      this.g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.g.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int k = getDividerHeight();
    Drawable localDrawable = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      paramInt4 = i + j;
      return paramInt4;
    }
    int m = j + i;
    label72:
    int n;
    View localView1;
    int i3;
    label93:
    View localView2;
    label125:
    int i5;
    if ((k > 0) && (localDrawable != null))
    {
      n = 0;
      localView1 = null;
      int i1 = 0;
      int i2 = localListAdapter.getCount();
      i3 = 0;
      if (i3 >= i2) {
        break label277;
      }
      int i4 = localListAdapter.getItemViewType(i3);
      if (i4 == i1) {
        break label280;
      }
      localView2 = null;
      i1 = i4;
      localView1 = localListAdapter.getView(i3, localView2, this);
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
        break label241;
      }
      i5 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
      label171:
      localView1.measure(paramInt1, i5);
      if (i3 <= 0) {
        break label287;
      }
    }
    label277:
    label280:
    label287:
    for (int i6 = m + k;; i6 = m)
    {
      int i7 = i6 + localView1.getMeasuredHeight();
      if (i7 >= paramInt4)
      {
        if ((paramInt5 < 0) || (i3 <= paramInt5) || (n <= 0) || (i7 == paramInt4)) {
          break;
        }
        return n;
        k = 0;
        break label72;
        label241:
        i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label171;
      }
      if ((paramInt5 >= 0) && (i3 >= paramInt5)) {
        n = i7;
      }
      i3++;
      m = i7;
      break label93;
      return m;
      localView2 = localView1;
      break label125;
    }
  }
  
  protected void a()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (b())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected void a(int paramInt, View paramView)
  {
    boolean bool1 = true;
    Drawable localDrawable = getSelector();
    boolean bool2;
    float f1;
    float f2;
    if ((localDrawable != null) && (paramInt != -1))
    {
      bool2 = bool1;
      if (bool2) {
        localDrawable.setVisible(false, false);
      }
      b(paramInt, paramView);
      if (bool2)
      {
        Rect localRect = this.a;
        f1 = localRect.exactCenterX();
        f2 = localRect.exactCenterY();
        if (getVisibility() != 0) {
          break label96;
        }
      }
    }
    for (;;)
    {
      localDrawable.setVisible(bool1, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
      return;
      bool2 = false;
      break;
      label96:
      bool1 = false;
    }
  }
  
  protected void a(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    a(paramInt, paramView);
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (paramInt != -1)) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.a.isEmpty())
    {
      Drawable localDrawable = getSelector();
      localDrawable.setBounds(this.a);
      localDrawable.draw(paramCanvas);
    }
  }
  
  protected void b(int paramInt, View paramView)
  {
    Rect localRect = this.a;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.b;
    localRect.top -= this.c;
    localRect.right += this.d;
    localRect.bottom += this.e;
    try
    {
      boolean bool1 = this.g.getBoolean(this);
      Field localField;
      if (paramView.isEnabled() != bool1)
      {
        localField = this.g;
        if (bool1) {
          break label131;
        }
      }
      label131:
      for (boolean bool2 = true;; bool2 = false)
      {
        localField.set(this, Boolean.valueOf(bool2));
        if (paramInt != -1) {
          refreshDrawableState();
        }
        return;
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  protected boolean b()
  {
    return (c()) && (isPressed());
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.h.a(true);
    a();
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    this.h = new ListViewCompat.GateKeeperDrawable(paramDrawable);
    super.setSelector(this.h);
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    this.b = localRect.left;
    this.c = localRect.top;
    this.d = localRect.right;
    this.e = localRect.bottom;
  }
  
  protected void setSelectorEnabled(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListViewCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */