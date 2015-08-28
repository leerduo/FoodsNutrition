package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ScrollingTabContainerView$TabView
  extends LinearLayoutCompat
  implements View.OnLongClickListener
{
  private final int[] b = { 16842964 };
  private ActionBar.Tab c;
  private TextView d;
  private ImageView e;
  private View f;
  
  public ScrollingTabContainerView$TabView(ScrollingTabContainerView paramScrollingTabContainerView, Context paramContext, ActionBar.Tab paramTab, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.actionBarTabStyle);
    this.c = paramTab;
    TintTypedArray localTintTypedArray = TintTypedArray.a(paramContext, null, this.b, R.attr.actionBarTabStyle, 0);
    if (localTintTypedArray.d(0)) {
      setBackgroundDrawable(localTintTypedArray.a(0));
    }
    localTintTypedArray.b();
    if (paramBoolean) {
      setGravity(8388627);
    }
    a();
  }
  
  public void a()
  {
    ActionBar.Tab localTab = this.c;
    View localView = localTab.c();
    if (localView != null)
    {
      ViewParent localViewParent = localView.getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
        addView(localView);
      }
      this.f = localView;
      if (this.d != null) {
        this.d.setVisibility(8);
      }
      if (this.e != null)
      {
        this.e.setVisibility(8);
        this.e.setImageDrawable(null);
      }
      return;
    }
    if (this.f != null)
    {
      removeView(this.f);
      this.f = null;
    }
    Drawable localDrawable = localTab.a();
    CharSequence localCharSequence = localTab.b();
    int i;
    if (localDrawable != null)
    {
      if (this.e == null)
      {
        ImageView localImageView = new ImageView(getContext());
        LinearLayoutCompat.LayoutParams localLayoutParams2 = new LinearLayoutCompat.LayoutParams(-2, -2);
        localLayoutParams2.h = 16;
        localImageView.setLayoutParams(localLayoutParams2);
        addView(localImageView, 0);
        this.e = localImageView;
      }
      this.e.setImageDrawable(localDrawable);
      this.e.setVisibility(0);
      if (TextUtils.isEmpty(localCharSequence)) {
        break label372;
      }
      i = 1;
      label213:
      if (i == 0) {
        break label378;
      }
      if (this.d == null)
      {
        CompatTextView localCompatTextView = new CompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
        localCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayoutCompat.LayoutParams localLayoutParams1 = new LinearLayoutCompat.LayoutParams(-2, -2);
        localLayoutParams1.h = 16;
        localCompatTextView.setLayoutParams(localLayoutParams1);
        addView(localCompatTextView);
        this.d = localCompatTextView;
      }
      this.d.setText(localCharSequence);
      this.d.setVisibility(0);
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.setContentDescription(localTab.e());
      }
      if ((i != 0) || (TextUtils.isEmpty(localTab.e()))) {
        break label405;
      }
      setOnLongClickListener(this);
      return;
      if (this.e == null) {
        break;
      }
      this.e.setVisibility(8);
      this.e.setImageDrawable(null);
      break;
      label372:
      i = 0;
      break label213;
      label378:
      if (this.d != null)
      {
        this.d.setVisibility(8);
        this.d.setText(null);
      }
    }
    label405:
    setOnLongClickListener(null);
    setLongClickable(false);
  }
  
  public void a(ActionBar.Tab paramTab)
  {
    this.c = paramTab;
    a();
  }
  
  public ActionBar.Tab b()
  {
    return this.c;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 14) {
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    Context localContext = getContext();
    int i = getWidth();
    int j = getHeight();
    int k = localContext.getResources().getDisplayMetrics().widthPixels;
    Toast localToast = Toast.makeText(localContext, this.c.e(), 0);
    localToast.setGravity(49, arrayOfInt[0] + i / 2 - k / 2, j);
    localToast.show();
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.a.b > 0) && (getMeasuredWidth() > this.a.b)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a.b, 1073741824), paramInt2);
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean)) {
        sendAccessibilityEvent(4);
      }
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */