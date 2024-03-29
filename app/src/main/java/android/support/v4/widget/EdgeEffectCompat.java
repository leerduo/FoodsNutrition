package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat
{
  private static final EdgeEffectCompat.EdgeEffectImpl IMPL = new EdgeEffectCompat.BaseEdgeEffectImpl();
  private Object mEdgeEffect;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new EdgeEffectCompat.EdgeEffectIcsImpl();
      return;
    }
  }
  
  public EdgeEffectCompat(Context paramContext)
  {
    this.mEdgeEffect = IMPL.newEdgeEffect(paramContext);
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    return IMPL.draw(this.mEdgeEffect, paramCanvas);
  }
  
  public void finish()
  {
    IMPL.finish(this.mEdgeEffect);
  }
  
  public boolean isFinished()
  {
    return IMPL.isFinished(this.mEdgeEffect);
  }
  
  public boolean onAbsorb(int paramInt)
  {
    return IMPL.onAbsorb(this.mEdgeEffect, paramInt);
  }
  
  public boolean onPull(float paramFloat)
  {
    return IMPL.onPull(this.mEdgeEffect, paramFloat);
  }
  
  public boolean onRelease()
  {
    return IMPL.onRelease(this.mEdgeEffect);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    IMPL.setSize(this.mEdgeEffect, paramInt1, paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.EdgeEffectCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */