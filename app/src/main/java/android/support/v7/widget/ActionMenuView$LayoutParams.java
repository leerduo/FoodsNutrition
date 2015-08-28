package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;

public class ActionMenuView$LayoutParams
  extends LinearLayoutCompat.LayoutParams
{
  @ViewDebug.ExportedProperty
  public boolean a;
  @ViewDebug.ExportedProperty
  public int b;
  @ViewDebug.ExportedProperty
  public int c;
  @ViewDebug.ExportedProperty
  public boolean d;
  @ViewDebug.ExportedProperty
  public boolean e;
  boolean f;
  
  public ActionMenuView$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.a = false;
  }
  
  public ActionMenuView$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ActionMenuView$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.a = paramLayoutParams.a;
  }
  
  public ActionMenuView$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView.LayoutParams
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */