package android.support.v4.view;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

class KeyEventCompat$BaseKeyEventVersionImpl
  implements KeyEventCompat.KeyEventVersionImpl
{
  private static final int META_ALL_MASK = 247;
  private static final int META_MODIFIER_MASK = 247;
  
  private static int metaStateFilterDirectionalModifiers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    int j;
    int k;
    if ((paramInt2 & paramInt3) != 0)
    {
      j = i;
      k = paramInt4 | paramInt5;
      if ((paramInt2 & k) == 0) {
        break label52;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        if (i != 0)
        {
          throw new IllegalArgumentException("bad arguments");
          j = 0;
          break;
          label52:
          i = 0;
          continue;
        }
        paramInt1 &= (k ^ 0xFFFFFFFF);
      }
    }
    while (i == 0) {
      return paramInt1;
    }
    return paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
  }
  
  public boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return paramKeyEvent.dispatch(paramCallback);
  }
  
  public Object getKeyDispatcherState(View paramView)
  {
    return null;
  }
  
  public boolean isTracking(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(0xF7 & normalizeMetaState(paramInt1), paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2;
  }
  
  public boolean metaStateHasNoModifiers(int paramInt)
  {
    return (0xF7 & normalizeMetaState(paramInt)) == 0;
  }
  
  public int normalizeMetaState(int paramInt)
  {
    if ((paramInt & 0xC0) != 0) {}
    for (int i = paramInt | 0x1;; i = paramInt)
    {
      if ((i & 0x30) != 0) {
        i |= 2;
      }
      return i & 0xF7;
    }
  }
  
  public void startTracking(KeyEvent paramKeyEvent) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */