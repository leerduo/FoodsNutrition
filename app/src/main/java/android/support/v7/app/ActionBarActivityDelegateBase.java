package android.support.v7.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.color;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.app.WindowDecorActionBar;
import android.support.v7.internal.view.StandaloneActionMode;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.DecorContentParent;
import android.support.v7.internal.widget.FitWindowsViewGroup;
import android.support.v7.internal.widget.TintCheckBox;
import android.support.v7.internal.widget.TintCheckedTextView;
import android.support.v7.internal.widget.TintEditText;
import android.support.v7.internal.widget.TintRadioButton;
import android.support.v7.internal.widget.TintSpinner;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

class ActionBarActivityDelegateBase
  extends ActionBarActivityDelegate
  implements MenuBuilder.Callback
{
  private boolean A;
  private ListMenuPresenter B;
  private Rect C;
  private Rect D;
  ActionMode g;
  ActionBarContextView h;
  PopupWindow i;
  Runnable j;
  private DecorContentParent k;
  private ActionBarActivityDelegateBase.ActionMenuPresenterCallback l;
  private ActionBarActivityDelegateBase.PanelMenuPresenterCallback m;
  private boolean n;
  private ViewGroup o;
  private ViewGroup p;
  private View q;
  private CharSequence r;
  private boolean s;
  private boolean t;
  private boolean u;
  private ActionBarActivityDelegateBase.PanelFeatureState[] v;
  private ActionBarActivityDelegateBase.PanelFeatureState w;
  private boolean x;
  private int y;
  private final Runnable z = new ActionBarActivityDelegateBase.1(this);
  
  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  private ActionBarActivityDelegateBase.PanelFeatureState a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.v;
    if ((localObject == null) || (localObject.length <= paramInt))
    {
      ActionBarActivityDelegateBase.PanelFeatureState[] arrayOfPanelFeatureState = new ActionBarActivityDelegateBase.PanelFeatureState[paramInt + 1];
      if (localObject != null) {
        System.arraycopy(localObject, 0, arrayOfPanelFeatureState, 0, localObject.length);
      }
      this.v = arrayOfPanelFeatureState;
      localObject = arrayOfPanelFeatureState;
    }
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = localObject[paramInt];
    if (localPanelFeatureState1 == null)
    {
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2 = new ActionBarActivityDelegateBase.PanelFeatureState(paramInt);
      localObject[paramInt] = localPanelFeatureState2;
      return localPanelFeatureState2;
    }
    return localPanelFeatureState1;
  }
  
  private ActionBarActivityDelegateBase.PanelFeatureState a(Menu paramMenu)
  {
    ActionBarActivityDelegateBase.PanelFeatureState[] arrayOfPanelFeatureState = this.v;
    int i1;
    if (arrayOfPanelFeatureState != null) {
      i1 = arrayOfPanelFeatureState.length;
    }
    for (int i2 = 0;; i2++)
    {
      if (i2 >= i1) {
        break label55;
      }
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[i2];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.d == paramMenu))
      {
        return localPanelFeatureState;
        i1 = 0;
        break;
      }
    }
    label55:
    return null;
  }
  
  private void a(int paramInt, ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    if (paramMenu == null)
    {
      if ((paramPanelFeatureState == null) && (paramInt >= 0) && (paramInt < this.v.length)) {
        paramPanelFeatureState = this.v[paramInt];
      }
      if (paramPanelFeatureState != null) {
        paramMenu = paramPanelFeatureState.d;
      }
    }
    if ((paramPanelFeatureState != null) && (!paramPanelFeatureState.i)) {
      return;
    }
    m().b(paramInt, paramMenu);
  }
  
  private void a(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.b = this.o;
    paramPanelFeatureState.a(l());
  }
  
  private void a(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if ((paramPanelFeatureState.i) || (o())) {}
    label108:
    label114:
    label118:
    label120:
    do
    {
      do
      {
        for (;;)
        {
          return;
          int i1;
          if (paramPanelFeatureState.a == 0)
          {
            ActionBarActivity localActionBarActivity = this.a;
            if ((0xF & localActionBarActivity.getResources().getConfiguration().screenLayout) != 4) {
              break label108;
            }
            i1 = 1;
            if (localActionBarActivity.getApplicationInfo().targetSdkVersion < 11) {
              break label114;
            }
          }
          for (int i2 = 1;; i2 = 0)
          {
            if ((i1 != 0) && (i2 != 0)) {
              break label118;
            }
            WindowCallback localWindowCallback = m();
            if ((localWindowCallback == null) || (localWindowCallback.c(paramPanelFeatureState.a, paramPanelFeatureState.d))) {
              break label120;
            }
            a(paramPanelFeatureState, true);
            return;
            i1 = 0;
            break;
          }
        }
      } while (!b(paramPanelFeatureState, paramKeyEvent));
      if ((paramPanelFeatureState.b == null) || (paramPanelFeatureState.k)) {
        a(paramPanelFeatureState);
      }
    } while ((!c(paramPanelFeatureState)) || (!paramPanelFeatureState.a()));
    paramPanelFeatureState.h = false;
    paramPanelFeatureState.i = true;
  }
  
  private void a(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramPanelFeatureState.a == 0) && (this.k != null) && (this.k.e())) {
      b(paramPanelFeatureState.d);
    }
    do
    {
      return;
      if ((paramPanelFeatureState.i) && (paramBoolean)) {
        a(paramPanelFeatureState.a, paramPanelFeatureState, null);
      }
      paramPanelFeatureState.g = false;
      paramPanelFeatureState.h = false;
      paramPanelFeatureState.i = false;
      paramPanelFeatureState.c = null;
      paramPanelFeatureState.k = true;
    } while (this.w != paramPanelFeatureState);
    this.w = null;
  }
  
  private void a(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.k != null) && (this.k.d()) && ((!ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.a))) || (this.k.f())))
    {
      WindowCallback localWindowCallback = m();
      if ((!this.k.e()) || (!paramBoolean)) {
        if ((localWindowCallback != null) && (!o()))
        {
          if ((this.x) && ((0x1 & this.y) != 0))
          {
            this.o.removeCallbacks(this.z);
            this.z.run();
          }
          ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2 = a(0, true);
          if ((localPanelFeatureState2.d != null) && (!localPanelFeatureState2.l) && (localWindowCallback.a(0, null, localPanelFeatureState2.d)))
          {
            localWindowCallback.c(8, localPanelFeatureState2.d);
            this.k.g();
          }
        }
      }
      do
      {
        return;
        this.k.h();
      } while (o());
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState3 = a(0, true);
      this.a.onPanelClosed(8, localPanelFeatureState3.d);
      return;
    }
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = a(0, true);
    localPanelFeatureState1.k = true;
    a(localPanelFeatureState1, false);
    a(localPanelFeatureState1, null);
  }
  
  private void b(MenuBuilder paramMenuBuilder)
  {
    if (this.u) {
      return;
    }
    this.u = true;
    this.k.j();
    WindowCallback localWindowCallback = m();
    if ((localWindowCallback != null) && (!o())) {
      localWindowCallback.b(8, paramMenuBuilder);
    }
    this.u = false;
  }
  
  private boolean b(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    ActionBarActivity localActionBarActivity = this.a;
    TypedValue localTypedValue;
    Resources.Theme localTheme1;
    Resources.Theme localTheme2;
    Object localObject;
    if (((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 8)) && (this.k != null))
    {
      localTypedValue = new TypedValue();
      localTheme1 = localActionBarActivity.getTheme();
      localTheme1.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId != 0)
      {
        localTheme2 = localActionBarActivity.getResources().newTheme();
        localTheme2.setTo(localTheme1);
        localTheme2.applyStyle(localTypedValue.resourceId, true);
        localTheme2.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        if (localTypedValue.resourceId != 0)
        {
          if (localTheme2 == null)
          {
            localTheme2 = localActionBarActivity.getResources().newTheme();
            localTheme2.setTo(localTheme1);
          }
          localTheme2.applyStyle(localTypedValue.resourceId, true);
        }
        Resources.Theme localTheme3 = localTheme2;
        if (localTheme3 == null) {
          break label207;
        }
        localObject = new ContextThemeWrapper(localActionBarActivity, 0);
        ((Context)localObject).getTheme().setTo(localTheme3);
      }
    }
    for (;;)
    {
      MenuBuilder localMenuBuilder = new MenuBuilder((Context)localObject);
      localMenuBuilder.a(this);
      paramPanelFeatureState.a(localMenuBuilder);
      return true;
      localTheme1.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      localTheme2 = null;
      break;
      label207:
      localObject = localActionBarActivity;
    }
  }
  
  private boolean b(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (o()) {
      return false;
    }
    if (paramPanelFeatureState.g) {
      return true;
    }
    if ((this.w != null) && (this.w != paramPanelFeatureState)) {
      a(this.w, false);
    }
    if ((paramPanelFeatureState.a == 0) || (paramPanelFeatureState.a == 8)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (this.k != null)) {
        this.k.i();
      }
      if ((paramPanelFeatureState.d != null) && (!paramPanelFeatureState.l)) {
        break label233;
      }
      if ((paramPanelFeatureState.d == null) && ((!b(paramPanelFeatureState)) || (paramPanelFeatureState.d == null))) {
        break;
      }
      if ((i1 != 0) && (this.k != null))
      {
        if (this.l == null) {
          this.l = new ActionBarActivityDelegateBase.ActionMenuPresenterCallback(this, null);
        }
        this.k.a(paramPanelFeatureState.d, this.l);
      }
      paramPanelFeatureState.d.g();
      if (m().a(paramPanelFeatureState.a, paramPanelFeatureState.d)) {
        break label228;
      }
      paramPanelFeatureState.a(null);
      if ((i1 == 0) || (this.k == null)) {
        break;
      }
      this.k.a(null, this.l);
      return false;
    }
    label228:
    paramPanelFeatureState.l = false;
    label233:
    paramPanelFeatureState.d.g();
    if (paramPanelFeatureState.m != null)
    {
      paramPanelFeatureState.d.b(paramPanelFeatureState.m);
      paramPanelFeatureState.m = null;
    }
    if (!m().a(0, null, paramPanelFeatureState.d))
    {
      if ((i1 != 0) && (this.k != null)) {
        this.k.a(null, this.l);
      }
      paramPanelFeatureState.d.h();
      return false;
    }
    int i2;
    if (paramKeyEvent != null)
    {
      i2 = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i2).getKeyboardType() == 1) {
        break label387;
      }
    }
    label387:
    for (boolean bool = true;; bool = false)
    {
      paramPanelFeatureState.j = bool;
      paramPanelFeatureState.d.setQwertyMode(paramPanelFeatureState.j);
      paramPanelFeatureState.d.h();
      paramPanelFeatureState.g = true;
      paramPanelFeatureState.h = false;
      this.w = paramPanelFeatureState;
      return true;
      i2 = -1;
      break;
    }
  }
  
  private void c(int paramInt)
  {
    this.y |= 1 << paramInt;
    if ((!this.x) && (this.o != null))
    {
      ViewCompat.postOnAnimation(this.o, this.z);
      this.x = true;
    }
  }
  
  private boolean c(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState)
  {
    if (paramPanelFeatureState.d == null) {
      return false;
    }
    if (this.m == null) {
      this.m = new ActionBarActivityDelegateBase.PanelMenuPresenterCallback(this, null);
    }
    paramPanelFeatureState.c = ((View)paramPanelFeatureState.a(this.m));
    if (paramPanelFeatureState.c != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d(int paramInt)
  {
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState1 = a(paramInt, true);
    if (localPanelFeatureState1.d != null)
    {
      Bundle localBundle = new Bundle();
      localPanelFeatureState1.d.a(localBundle);
      if (localBundle.size() > 0) {
        localPanelFeatureState1.m = localBundle;
      }
      localPanelFeatureState1.d.g();
      localPanelFeatureState1.d.clear();
    }
    localPanelFeatureState1.l = true;
    localPanelFeatureState1.k = true;
    if (((paramInt == 8) || (paramInt == 0)) && (this.k != null))
    {
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState2 = a(0, false);
      if (localPanelFeatureState2 != null)
      {
        localPanelFeatureState2.g = false;
        b(localPanelFeatureState2, null);
      }
    }
  }
  
  private int e(int paramInt)
  {
    int i1 = 1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i5;
    int i6;
    label198:
    label205:
    int i4;
    if ((this.h != null) && ((this.h.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      if (this.h.isShown())
      {
        if (this.C == null)
        {
          this.C = new Rect();
          this.D = new Rect();
        }
        Rect localRect1 = this.C;
        Rect localRect2 = this.D;
        localRect1.set(0, paramInt, 0, 0);
        ViewUtils.a(this.p, localRect1, localRect2);
        if (localRect2.top == 0)
        {
          i5 = paramInt;
          if (localMarginLayoutParams.topMargin == i5) {
            break label358;
          }
          localMarginLayoutParams.topMargin = paramInt;
          if (this.q != null) {
            break label279;
          }
          this.q = new View(this.a);
          this.q.setBackgroundColor(this.a.getResources().getColor(R.color.abc_input_method_navigation_guard));
          this.p.addView(this.q, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i6 = i1;
          if (this.q == null) {
            break label318;
          }
          if ((!this.d) && (i1 != 0)) {
            paramInt = 0;
          }
          int i7 = i6;
          i4 = i1;
          i1 = i7;
          label228:
          if (i1 != 0) {
            this.h.setLayoutParams(localMarginLayoutParams);
          }
        }
      }
    }
    for (int i2 = i4;; i2 = 0)
    {
      View localView;
      int i3;
      if (this.q != null)
      {
        localView = this.q;
        i3 = 0;
        if (i2 == 0) {
          break label343;
        }
      }
      for (;;)
      {
        localView.setVisibility(i3);
        return paramInt;
        i5 = 0;
        break;
        label279:
        ViewGroup.LayoutParams localLayoutParams = this.q.getLayoutParams();
        if (localLayoutParams.height != paramInt)
        {
          localLayoutParams.height = paramInt;
          this.q.setLayoutParams(localLayoutParams);
        }
        i6 = i1;
        break label198;
        label318:
        i1 = 0;
        break label205;
        if (localMarginLayoutParams.topMargin == 0) {
          break label350;
        }
        localMarginLayoutParams.topMargin = 0;
        i4 = 0;
        break label228;
        label343:
        i3 = 8;
      }
      label350:
      i4 = 0;
      i1 = 0;
      break label228;
      label358:
      i6 = 0;
      break label198;
    }
  }
  
  private void r()
  {
    TypedArray localTypedArray = this.a.obtainStyledAttributes(R.styleable.Theme);
    TypedValue localTypedValue1;
    if (localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMajor)) {
      if (0 == 0)
      {
        localTypedValue1 = new TypedValue();
        localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMajor, localTypedValue1);
      }
    }
    for (;;)
    {
      TypedValue localTypedValue2;
      if (localTypedArray.hasValue(R.styleable.Theme_windowFixedWidthMinor)) {
        if (0 == 0)
        {
          localTypedValue2 = new TypedValue();
          localTypedArray.getValue(R.styleable.Theme_windowFixedWidthMinor, localTypedValue2);
        }
      }
      for (;;)
      {
        Object localObject;
        if (localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMajor)) {
          if (0 == 0)
          {
            localObject = new TypedValue();
            localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMajor, (TypedValue)localObject);
          }
        }
        for (;;)
        {
          boolean bool = localTypedArray.hasValue(R.styleable.Theme_windowFixedHeightMinor);
          TypedValue localTypedValue3 = null;
          if (bool)
          {
            localTypedValue3 = null;
            if (0 == 0) {
              localTypedValue3 = new TypedValue();
            }
            localTypedArray.getValue(R.styleable.Theme_windowFixedHeightMinor, localTypedValue3);
          }
          DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
          int i1;
          label182:
          int i2;
          if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
          {
            i1 = 1;
            if (i1 == 0) {
              break label284;
            }
            if ((localTypedValue2 == null) || (localTypedValue2.type == 0)) {
              break label366;
            }
            if (localTypedValue2.type != 5) {
              break label289;
            }
            i2 = (int)localTypedValue2.getDimension(localDisplayMetrics);
          }
          for (;;)
          {
            label210:
            label215:
            int i3;
            if (i1 != 0)
            {
              if ((localObject == null) || (((TypedValue)localObject).type == 0)) {
                break label360;
              }
              if (((TypedValue)localObject).type != 5) {
                break label327;
              }
              i3 = (int)((TypedValue)localObject).getDimension(localDisplayMetrics);
            }
            for (;;)
            {
              if ((i2 != -1) || (i3 != -1)) {
                this.a.getWindow().setLayout(i2, i3);
              }
              localTypedArray.recycle();
              return;
              i1 = 0;
              break;
              label284:
              localTypedValue2 = localTypedValue1;
              break label182;
              label289:
              if (localTypedValue2.type != 6) {
                break label366;
              }
              i2 = (int)localTypedValue2.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
              break label210;
              localObject = localTypedValue3;
              break label215;
              label327:
              if (((TypedValue)localObject).type == 6) {
                i3 = (int)((TypedValue)localObject).getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
              } else {
                label360:
                i3 = -1;
              }
            }
            label366:
            i2 = -1;
          }
          localObject = null;
          break;
          localObject = null;
        }
        localTypedValue2 = null;
        break;
        localTypedValue2 = null;
      }
      localTypedValue1 = null;
      break;
      localTypedValue1 = null;
    }
  }
  
  public ActionBar a()
  {
    p();
    WindowDecorActionBar localWindowDecorActionBar = new WindowDecorActionBar(this.a, this.c);
    localWindowDecorActionBar.c(this.A);
    return localWindowDecorActionBar;
  }
  
  ActionMode a(ActionMode.Callback paramCallback)
  {
    if (this.g != null) {
      this.g.c();
    }
    ActionBarActivityDelegateBase.ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(this, paramCallback);
    Context localContext = l();
    boolean bool;
    if (this.h == null)
    {
      if (this.e)
      {
        this.h = new ActionBarContextView(localContext);
        this.i = new PopupWindow(localContext, null, R.attr.actionModePopupWindowStyle);
        this.i.setContentView(this.h);
        this.i.setWidth(-1);
        TypedValue localTypedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(R.attr.actionBarSize, localTypedValue, true);
        int i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, this.a.getResources().getDisplayMetrics());
        this.h.setContentHeight(i1);
        this.i.setHeight(-2);
        this.j = new ActionBarActivityDelegateBase.4(this);
      }
    }
    else if (this.h != null)
    {
      this.h.c();
      ActionBarContextView localActionBarContextView = this.h;
      if (this.i != null) {
        break label386;
      }
      bool = true;
      label196:
      StandaloneActionMode localStandaloneActionMode = new StandaloneActionMode(localContext, localActionBarContextView, localActionModeCallbackWrapper, bool);
      if (!paramCallback.a(localStandaloneActionMode, localStandaloneActionMode.b())) {
        break label392;
      }
      localStandaloneActionMode.d();
      this.h.a(localStandaloneActionMode);
      this.h.setVisibility(0);
      this.g = localStandaloneActionMode;
      if (this.i != null) {
        this.a.getWindow().getDecorView().post(this.j);
      }
      this.h.sendAccessibilityEvent(32);
      if (this.h.getParent() != null) {
        ViewCompat.requestApplyInsets((View)this.h.getParent());
      }
    }
    for (;;)
    {
      if ((this.g != null) && (this.a != null)) {
        this.a.a(this.g);
      }
      return this.g;
      ViewStubCompat localViewStubCompat = (ViewStubCompat)this.a.findViewById(R.id.action_mode_bar_stub);
      if (localViewStubCompat == null) {
        break;
      }
      localViewStubCompat.setLayoutInflater(LayoutInflater.from(localContext));
      this.h = ((ActionBarContextView)localViewStubCompat.a());
      break;
      label386:
      bool = false;
      break label196;
      label392:
      this.g = null;
    }
  }
  
  View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int i1;
    if (Build.VERSION.SDK_INT < 21)
    {
      i1 = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return null;
        if (paramString.equals("EditText"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("Spinner"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("CheckBox"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("RadioButton"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("CheckedTextView")) {
                  i1 = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    return new TintEditText(paramContext, paramAttributeSet);
    return new TintSpinner(paramContext, paramAttributeSet);
    return new TintCheckBox(paramContext, paramAttributeSet);
    return new TintRadioButton(paramContext, paramAttributeSet);
    return new TintCheckedTextView(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    p();
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
    localViewGroup.removeAllViews();
    this.a.getLayoutInflater().inflate(paramInt, localViewGroup);
    this.a.c();
  }
  
  public void a(int paramInt, Menu paramMenu)
  {
    ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = a(paramInt, false);
    if (localPanelFeatureState != null) {
      a(localPanelFeatureState, false);
    }
    if (paramInt == 8)
    {
      localActionBar = b();
      if (localActionBar != null) {
        localActionBar.e(false);
      }
    }
    while (o())
    {
      ActionBar localActionBar;
      return;
    }
    this.a.b(paramInt, paramMenu);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.b) && (this.n))
    {
      ActionBar localActionBar = b();
      if (localActionBar != null) {
        localActionBar.a(paramConfiguration);
      }
    }
  }
  
  void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.o = ((ViewGroup)this.a.getWindow().getDecorView());
    ActionBar localActionBar;
    if (NavUtils.getParentActivityName(this.a) != null)
    {
      localActionBar = c();
      if (localActionBar == null) {
        this.A = true;
      }
    }
    else
    {
      return;
    }
    localActionBar.c(true);
  }
  
  public void a(MenuBuilder paramMenuBuilder)
  {
    a(paramMenuBuilder, true);
  }
  
  public void a(View paramView)
  {
    p();
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.a.c();
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    p();
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.a.c();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.k != null)
    {
      this.k.setWindowTitle(paramCharSequence);
      return;
    }
    if (b() != null)
    {
      b().a(paramCharSequence);
      return;
    }
    this.r = paramCharSequence;
  }
  
  boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return b(paramInt, paramKeyEvent);
  }
  
  public boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {
      return m().a(paramInt, paramView, paramMenu);
    }
    return false;
  }
  
  final boolean a(ActionBarActivityDelegateBase.PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {}
    do
    {
      return bool2;
      if (!paramPanelFeatureState.g)
      {
        boolean bool3 = b(paramPanelFeatureState, paramKeyEvent);
        bool2 = false;
        if (!bool3) {}
      }
      else
      {
        MenuBuilder localMenuBuilder = paramPanelFeatureState.d;
        bool2 = false;
        if (localMenuBuilder != null) {
          bool2 = paramPanelFeatureState.d.performShortcut(paramInt1, paramKeyEvent, paramInt2);
        }
      }
    } while ((!bool2) || ((paramInt2 & 0x1) != 0) || (this.k != null));
    a(paramPanelFeatureState, true);
    return bool2;
  }
  
  public boolean a(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    WindowCallback localWindowCallback = m();
    if ((localWindowCallback != null) && (!o()))
    {
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = a(paramMenuBuilder.p());
      if (localPanelFeatureState != null) {
        return localWindowCallback.a(localPanelFeatureState.a, paramMenuItem);
      }
    }
    return false;
  }
  
  public ActionMode b(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.g != null) {
      this.g.c();
    }
    ActionBarActivityDelegateBase.ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionBarActivityDelegateBase.ActionModeCallbackWrapper(this, paramCallback);
    ActionBar localActionBar = b();
    if (localActionBar != null)
    {
      this.g = localActionBar.a(localActionModeCallbackWrapper);
      if (this.g != null) {
        this.a.a(this.g);
      }
    }
    if (this.g == null) {
      this.g = a(localActionModeCallbackWrapper);
    }
    return this.g;
  }
  
  public View b(int paramInt)
  {
    if (this.g == null)
    {
      WindowCallback localWindowCallback = m();
      if (localWindowCallback != null) {}
      for (View localView = localWindowCallback.a(paramInt);; localView = null)
      {
        if ((localView == null) && (this.B == null))
        {
          ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = a(paramInt, true);
          a(localPanelFeatureState, null);
          if (localPanelFeatureState.i) {
            localView = localPanelFeatureState.c;
          }
        }
        return localView;
      }
    }
    return null;
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    p();
    ((ViewGroup)this.a.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.a.c();
  }
  
  boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.w != null) && (a(this.w, paramKeyEvent.getKeyCode(), paramKeyEvent, 1))) {
      if (this.w != null) {
        this.w.h = true;
      }
    }
    boolean bool;
    do
    {
      return true;
      if (this.w != null) {
        break;
      }
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = a(0, true);
      b(localPanelFeatureState, paramKeyEvent);
      bool = a(localPanelFeatureState, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      localPanelFeatureState.g = false;
    } while (bool);
    return false;
  }
  
  boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == 8)
    {
      ActionBar localActionBar = b();
      if (localActionBar != null) {
        localActionBar.e(true);
      }
      return true;
    }
    return this.a.c(paramInt, paramMenu);
  }
  
  public boolean c(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {
      return m().a(paramInt, paramMenu);
    }
    return false;
  }
  
  public void e()
  {
    ActionBar localActionBar = b();
    if (localActionBar != null) {
      localActionBar.d(false);
    }
  }
  
  public void f()
  {
    ActionBar localActionBar = b();
    if (localActionBar != null) {
      localActionBar.d(true);
    }
  }
  
  public void g()
  {
    ActionBar localActionBar = b();
    if ((localActionBar != null) && (localActionBar.c())) {
      return;
    }
    c(0);
  }
  
  public boolean h()
  {
    if (this.g != null) {
      this.g.c();
    }
    ActionBar localActionBar;
    do
    {
      return true;
      localActionBar = b();
    } while ((localActionBar != null) && (localActionBar.d()));
    return false;
  }
  
  int j()
  {
    return R.attr.homeAsUpIndicator;
  }
  
  public void k() {}
  
  final void p()
  {
    Object localObject;
    if (!this.n)
    {
      if (!this.b) {
        break label318;
      }
      TypedValue localTypedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break label310;
      }
      localObject = new ContextThemeWrapper(this.a, localTypedValue.resourceId);
      this.p = ((ViewGroup)LayoutInflater.from((Context)localObject).inflate(R.layout.abc_screen_toolbar, null));
      this.k = ((DecorContentParent)this.p.findViewById(R.id.decor_content_parent));
      this.k.setWindowCallback(m());
      if (this.c) {
        this.k.a(9);
      }
      if (this.s) {
        this.k.a(2);
      }
      if (this.t) {
        this.k.a(5);
      }
    }
    for (;;)
    {
      ViewUtils.b(this.p);
      this.a.a(this.p);
      View localView = this.a.findViewById(16908290);
      localView.setId(-1);
      this.a.findViewById(R.id.action_bar_activity_content).setId(16908290);
      if ((localView instanceof FrameLayout)) {
        ((FrameLayout)localView).setForeground(null);
      }
      if ((this.r != null) && (this.k != null))
      {
        this.k.setWindowTitle(this.r);
        this.r = null;
      }
      r();
      q();
      this.n = true;
      ActionBarActivityDelegateBase.PanelFeatureState localPanelFeatureState = a(0, false);
      if ((!o()) && ((localPanelFeatureState == null) || (localPanelFeatureState.d == null))) {
        c(8);
      }
      return;
      label310:
      localObject = this.a;
      break;
      label318:
      if (this.d) {}
      for (this.p = ((ViewGroup)LayoutInflater.from(this.a).inflate(R.layout.abc_screen_simple_overlay_action_mode, null));; this.p = ((ViewGroup)LayoutInflater.from(this.a).inflate(R.layout.abc_screen_simple, null)))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label396;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this.p, new ActionBarActivityDelegateBase.2(this));
        break;
      }
      label396:
      ((FitWindowsViewGroup)this.p).setOnFitSystemWindowsListener(new ActionBarActivityDelegateBase.3(this));
    }
  }
  
  void q() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */