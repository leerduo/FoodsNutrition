package de.keyboardsurfer.android.widget.crouton;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

final class Manager
  extends Handler
{
  private static Manager a;
  private final Queue<Crouton> b = new LinkedBlockingQueue();
  
  static Manager a()
  {
    try
    {
      if (a == null) {
        a = new Manager();
      }
      Manager localManager = a;
      return localManager;
    }
    finally {}
  }
  
  public static void a(Context paramContext, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 4) {
      if (paramContext == null) {
        break label95;
      }
    }
    label95:
    for (AccessibilityManager localAccessibilityManager = (AccessibilityManager)paramContext.getSystemService("accessibility");; localAccessibilityManager = null)
    {
      if ((localAccessibilityManager == null) || (!localAccessibilityManager.isEnabled())) {
        return;
      }
      if (Build.VERSION.SDK_INT < 16) {}
      for (int i = 8;; i = 16384)
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(i);
        localAccessibilityEvent.getText().add(paramCharSequence);
        localAccessibilityEvent.setClassName(Manager.class.getName());
        localAccessibilityEvent.setPackageName(paramContext.getPackageName());
        localAccessibilityManager.sendAccessibilityEvent(localAccessibilityEvent);
        return;
      }
    }
  }
  
  @TargetApi(19)
  private void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((0x4000000 & paramActivity.getWindow().getAttributes().flags) == 67108864)) {
      c(paramMarginLayoutParams, paramActivity);
    }
  }
  
  private void a(Crouton paramCrouton, int paramInt)
  {
    Message localMessage = obtainMessage(paramInt);
    localMessage.obj = paramCrouton;
    sendMessage(localMessage);
  }
  
  private void a(Crouton paramCrouton, int paramInt, long paramLong)
  {
    Message localMessage = obtainMessage(paramInt);
    localMessage.obj = paramCrouton;
    sendMessageDelayed(localMessage, paramLong);
  }
  
  private boolean a(ViewGroup paramViewGroup)
  {
    return ((paramViewGroup instanceof FrameLayout)) || ((paramViewGroup instanceof AdapterView)) || ((paramViewGroup instanceof RelativeLayout));
  }
  
  @TargetApi(11)
  private void b(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramActivity.getWindow().hasFeature(9))) {
      c(paramMarginLayoutParams, paramActivity);
    }
  }
  
  private long c(Crouton paramCrouton)
  {
    return paramCrouton.k().b + paramCrouton.c().getDuration() + paramCrouton.d().getDuration();
  }
  
  private void c()
  {
    if (this.b.isEmpty()) {}
    Crouton localCrouton;
    do
    {
      return;
      localCrouton = (Crouton)this.b.peek();
      if (localCrouton.l() == null) {
        this.b.poll();
      }
      if (localCrouton.e()) {
        break;
      }
      a(localCrouton, -1040157475);
    } while (localCrouton.i() == null);
    localCrouton.i().a();
    return;
    a(localCrouton, 794631, c(localCrouton));
  }
  
  private void c(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Activity paramActivity)
  {
    View localView = paramActivity.findViewById(Resources.getSystem().getIdentifier("action_bar_container", "id", "android"));
    if (localView != null) {
      paramMarginLayoutParams.topMargin = localView.getBottom();
    }
  }
  
  private void d()
  {
    removeMessages(-1040157475);
    removeMessages(794631);
    removeMessages(-1040155167);
  }
  
  private void d(Crouton paramCrouton)
  {
    if (paramCrouton.e()) {
      return;
    }
    View localView = paramCrouton.o();
    Object localObject;
    ViewGroup localViewGroup;
    if (localView.getParent() == null)
    {
      localObject = localView.getLayoutParams();
      if (localObject == null) {
        localObject = new ViewGroup.MarginLayoutParams(-1, -2);
      }
      if (paramCrouton.m() == null) {
        break label113;
      }
      localViewGroup = paramCrouton.m();
      if (!a(localViewGroup)) {
        break label101;
      }
      localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      localView.requestLayout();
      ViewTreeObserver localViewTreeObserver = localView.getViewTreeObserver();
      if (localViewTreeObserver == null) {
        break;
      }
      localViewTreeObserver.addOnGlobalLayoutListener(new Manager.1(this, localView, paramCrouton));
      return;
      label101:
      localViewGroup.addView(localView, 0, (ViewGroup.LayoutParams)localObject);
      continue;
      label113:
      Activity localActivity = paramCrouton.l();
      if ((localActivity == null) || (localActivity.isFinishing())) {
        break;
      }
      a((ViewGroup.MarginLayoutParams)localObject, localActivity);
      b((ViewGroup.MarginLayoutParams)localObject, localActivity);
      localActivity.addContentView(localView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void e(Crouton paramCrouton)
  {
    if (paramCrouton.e())
    {
      ViewGroup localViewGroup = (ViewGroup)paramCrouton.o().getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramCrouton.o());
      }
    }
  }
  
  void a(Crouton paramCrouton)
  {
    this.b.add(paramCrouton);
    c();
  }
  
  void b()
  {
    d();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      e((Crouton)localIterator.next());
    }
    this.b.clear();
  }
  
  protected void b(Crouton paramCrouton)
  {
    View localView = paramCrouton.o();
    ViewGroup localViewGroup = (ViewGroup)localView.getParent();
    if (localViewGroup != null)
    {
      localView.startAnimation(paramCrouton.d());
      Crouton localCrouton = (Crouton)this.b.poll();
      localViewGroup.removeView(localView);
      if (localCrouton != null)
      {
        localCrouton.f();
        localCrouton.g();
        if (localCrouton.i() != null) {
          localCrouton.i().b();
        }
        localCrouton.h();
      }
      a(paramCrouton, 794631, paramCrouton.d().getDuration());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    Crouton localCrouton = (Crouton)paramMessage.obj;
    if (localCrouton == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
        return;
      case 794631: 
        c();
        return;
      case -1040157475: 
        d(localCrouton);
        return;
      }
      b(localCrouton);
    } while (localCrouton.i() == null);
    localCrouton.i().b();
  }
  
  public String toString()
  {
    return "Manager{croutonQueue=" + this.b + '}';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.keyboardsurfer.android.widget.crouton.Manager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */