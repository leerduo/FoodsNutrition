package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  private int a = 0;
  private int b;
  private WeakReference<View> c;
  private LayoutInflater d;
  private ViewStubCompat.OnInflateListener e;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewStubCompat, paramInt, 0);
    this.b = localTypedArray.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
    this.a = localTypedArray.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
    setId(localTypedArray.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
    localTypedArray.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  public View a()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      if (this.a != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localViewParent;
        LayoutInflater localLayoutInflater;
        View localView;
        int i;
        if (this.d != null)
        {
          localLayoutInflater = this.d;
          localView = localLayoutInflater.inflate(this.a, localViewGroup, false);
          if (this.b != -1) {
            localView.setId(this.b);
          }
          i = localViewGroup.indexOfChild(this);
          localViewGroup.removeViewInLayout(this);
          ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
          if (localLayoutParams == null) {
            break label148;
          }
          localViewGroup.addView(localView, i, localLayoutParams);
        }
        for (;;)
        {
          this.c = new WeakReference(localView);
          if (this.e != null) {
            this.e.a(this, localView);
          }
          return localView;
          localLayoutInflater = LayoutInflater.from(getContext());
          break;
          label148:
          localViewGroup.addView(localView, i);
        }
      }
      throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {}
  
  public void draw(Canvas paramCanvas) {}
  
  public int getInflatedId()
  {
    return this.b;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.d;
  }
  
  public int getLayoutResource()
  {
    return this.a;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public void setInflatedId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.d = paramLayoutInflater;
  }
  
  public void setLayoutResource(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setOnInflateListener(ViewStubCompat.OnInflateListener paramOnInflateListener)
  {
    this.e = paramOnInflateListener;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.c != null)
    {
      View localView = (View)this.c.get();
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
    }
    do
    {
      return;
      throw new IllegalStateException("setVisibility called on un-referenced view");
      super.setVisibility(paramInt);
    } while ((paramInt != 0) && (paramInt != 4));
    a();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ViewStubCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */