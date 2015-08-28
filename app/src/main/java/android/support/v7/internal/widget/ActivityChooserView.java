package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class ActivityChooserView
  extends ViewGroup
{
  ActionProvider a;
  private final ActivityChooserView.ActivityChooserViewAdapter b;
  private final ActivityChooserView.Callbacks c;
  private final LinearLayoutCompat d;
  private final Drawable e;
  private final FrameLayout f;
  private final ImageView g;
  private final FrameLayout h;
  private final ImageView i;
  private final int j;
  private final DataSetObserver k = new ActivityChooserView.1(this);
  private final ViewTreeObserver.OnGlobalLayoutListener l = new ActivityChooserView.2(this);
  private ListPopupWindow m;
  private PopupWindow.OnDismissListener n;
  private boolean o;
  private int p = 4;
  private boolean q;
  private int r;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActivityChooserView, paramInt, 0);
    this.p = localTypedArray.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    localTypedArray.recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    this.c = new ActivityChooserView.Callbacks(this, null);
    this.d = ((LinearLayoutCompat)findViewById(R.id.activity_chooser_view_content));
    this.e = this.d.getBackground();
    this.h = ((FrameLayout)findViewById(R.id.default_activity_button));
    this.h.setOnClickListener(this.c);
    this.h.setOnLongClickListener(this.c);
    this.i = ((ImageView)this.h.findViewById(R.id.image));
    this.f = ((FrameLayout)findViewById(R.id.expand_activities_button));
    this.f.setOnClickListener(this.c);
    this.g = ((ImageView)this.f.findViewById(R.id.image));
    this.g.setImageDrawable(localDrawable);
    this.b = new ActivityChooserView.ActivityChooserViewAdapter(this, null);
    this.b.registerDataSetObserver(new ActivityChooserView.3(this));
    Resources localResources = paramContext.getResources();
    this.j = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  private void a(int paramInt)
  {
    if (this.b.e() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.l);
    boolean bool;
    int i2;
    label58:
    label90:
    ListPopupWindow localListPopupWindow;
    if (this.h.getVisibility() == 0)
    {
      bool = true;
      int i1 = this.b.c();
      if (!bool) {
        break label187;
      }
      i2 = 1;
      if ((paramInt == 2147483647) || (i1 <= i2 + paramInt)) {
        break label193;
      }
      this.b.a(true);
      this.b.a(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.b())
      {
        if ((!this.o) && (bool)) {
          break label212;
        }
        this.b.a(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.d(Math.min(this.b.a(), this.j));
      localListPopupWindow.c();
      if (this.a != null) {
        this.a.subUiVisibilityChanged(true);
      }
      localListPopupWindow.g().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label187:
      i2 = 0;
      break label58;
      label193:
      this.b.a(false);
      this.b.a(paramInt);
      break label90;
      label212:
      this.b.a(false, false);
    }
  }
  
  private void d()
  {
    if (this.b.getCount() > 0)
    {
      this.f.setEnabled(true);
      int i1 = this.b.c();
      int i2 = this.b.d();
      if ((i1 != 1) && ((i1 <= 1) || (i2 <= 0))) {
        break label165;
      }
      this.h.setVisibility(0);
      ResolveInfo localResolveInfo = this.b.b();
      PackageManager localPackageManager = getContext().getPackageManager();
      this.i.setImageDrawable(localResolveInfo.loadIcon(localPackageManager));
      if (this.r != 0)
      {
        CharSequence localCharSequence = localResolveInfo.loadLabel(localPackageManager);
        String str = getContext().getString(this.r, new Object[] { localCharSequence });
        this.h.setContentDescription(str);
      }
    }
    for (;;)
    {
      if (this.h.getVisibility() != 0) {
        break label177;
      }
      this.d.setBackgroundDrawable(this.e);
      return;
      this.f.setEnabled(false);
      break;
      label165:
      this.h.setVisibility(8);
    }
    label177:
    this.d.setBackgroundDrawable(null);
  }
  
  private ListPopupWindow getListPopupWindow()
  {
    if (this.m == null)
    {
      this.m = new ListPopupWindow(getContext());
      this.m.a(this.b);
      this.m.a(this);
      this.m.a(true);
      this.m.a(this.c);
      this.m.a(this.c);
    }
    return this.m;
  }
  
  public boolean a()
  {
    if ((c()) || (!this.q)) {
      return false;
    }
    this.o = false;
    a(this.p);
    return true;
  }
  
  public boolean b()
  {
    if (c())
    {
      getListPopupWindow().a();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.l);
      }
    }
    return true;
  }
  
  public boolean c()
  {
    return getListPopupWindow().b();
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.b.e();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = this.b.e();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(this.k);
    }
    this.q = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ActivityChooserModel localActivityChooserModel = this.b.e();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.unregisterObserver(this.k);
    }
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.l);
    }
    if (c()) {
      b();
    }
    this.q = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.d.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayoutCompat localLinearLayoutCompat = this.d;
    if (this.h.getVisibility() != 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayoutCompat, paramInt1, paramInt2);
    setMeasuredDimension(localLinearLayoutCompat.getMeasuredWidth(), localLinearLayoutCompat.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    this.b.a(paramActivityChooserModel);
    if (c())
    {
      b();
      a();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.g.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.g.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.n = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.a = paramActionProvider;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */