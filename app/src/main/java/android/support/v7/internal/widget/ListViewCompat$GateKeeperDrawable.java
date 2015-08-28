package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

class ListViewCompat$GateKeeperDrawable
  extends DrawableWrapper
{
  private boolean a = true;
  
  public ListViewCompat$GateKeeperDrawable(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a) {
      super.draw(paramCanvas);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if (this.a) {
      super.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a) {
      super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean setState(int[] paramArrayOfInt)
  {
    if (this.a) {
      return super.setState(paramArrayOfInt);
    }
    return false;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a) {
      return super.setVisible(paramBoolean1, paramBoolean2);
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListViewCompat.GateKeeperDrawable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */