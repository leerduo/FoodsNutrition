package de.keyboardsurfer.android.widget.crouton;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public final class Crouton
{
  private final CharSequence a;
  private final Style b;
  private Configuration c = null;
  private final View d;
  private View.OnClickListener e;
  private Activity f;
  private ViewGroup g;
  private FrameLayout h;
  private Animation i;
  private Animation j;
  private LifecycleCallback k = null;
  
  private Crouton(Activity paramActivity, CharSequence paramCharSequence, Style paramStyle)
  {
    if ((paramActivity == null) || (paramCharSequence == null) || (paramStyle == null)) {
      throw new IllegalArgumentException("Null parameters are not accepted");
    }
    this.f = paramActivity;
    this.g = null;
    this.a = paramCharSequence;
    this.b = paramStyle;
    this.d = null;
  }
  
  private FrameLayout a(Resources paramResources)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.f);
    if (this.e != null) {
      localFrameLayout.setOnClickListener(this.e);
    }
    int m;
    int n;
    if (this.b.l > 0)
    {
      m = paramResources.getDimensionPixelSize(this.b.l);
      if (this.b.n <= 0) {
        break label184;
      }
      n = paramResources.getDimensionPixelSize(this.b.n);
      label72:
      if (n == 0) {
        break label196;
      }
      label77:
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(n, m));
      if (this.b.g == -1) {
        break label202;
      }
      localFrameLayout.setBackgroundColor(this.b.g);
    }
    for (;;)
    {
      if (this.b.f != 0)
      {
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramResources, BitmapFactory.decodeResource(paramResources, this.b.f));
        if (this.b.h) {
          localBitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        }
        localFrameLayout.setBackgroundDrawable(localBitmapDrawable);
      }
      return localFrameLayout;
      m = this.b.k;
      break;
      label184:
      n = this.b.m;
      break label72;
      label196:
      n = -1;
      break label77;
      label202:
      localFrameLayout.setBackgroundColor(paramResources.getColor(this.b.e));
    }
  }
  
  public static Crouton a(Activity paramActivity, CharSequence paramCharSequence, Style paramStyle)
  {
    return new Crouton(paramActivity, paramCharSequence, paramStyle);
  }
  
  public static void a()
  {
    Manager.a().b();
  }
  
  private void a(Resources paramResources, TextView paramTextView)
  {
    int m = paramResources.getColor(this.b.t);
    paramTextView.setShadowLayer(this.b.u, this.b.w, this.b.v, m);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (this.a != null)
    {
      SpannableString localSpannableString = new SpannableString(this.a);
      localSpannableString.setSpan(new TypefaceSpan(paramTextView.getContext(), paramString), 0, localSpannableString.length(), 33);
      paramTextView.setText(localSpannableString);
    }
  }
  
  private RelativeLayout b(Resources paramResources)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.f);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    int m = this.b.y;
    if (this.b.z > 0) {
      m = paramResources.getDimensionPixelSize(this.b.z);
    }
    localRelativeLayout.setPadding(m, m, m, m);
    ImageView localImageView;
    if (this.b.p == null)
    {
      int n = this.b.q;
      localImageView = null;
      if (n == 0) {}
    }
    else
    {
      localImageView = t();
      localRelativeLayout.addView(localImageView, localImageView.getLayoutParams());
    }
    TextView localTextView = c(paramResources);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    if (localImageView != null) {
      localLayoutParams.addRule(1, localImageView.getId());
    }
    if ((0x11 & this.b.o) != 0) {
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      localRelativeLayout.addView(localTextView, localLayoutParams);
      return localRelativeLayout;
      if ((0x10 & this.b.o) != 0) {
        localLayoutParams.addRule(15);
      } else if ((0x1 & this.b.o) != 0) {
        localLayoutParams.addRule(14);
      }
    }
  }
  
  private TextView c(Resources paramResources)
  {
    TextView localTextView = new TextView(this.f);
    localTextView.setId(257);
    if (this.b.A != null)
    {
      a(localTextView, this.b.A);
      localTextView.setTypeface(Typeface.DEFAULT_BOLD);
      localTextView.setGravity(this.b.o);
      if (this.b.j == -1) {
        break label187;
      }
      localTextView.setTextColor(this.b.j);
    }
    for (;;)
    {
      if (this.b.s != 0) {
        localTextView.setTextSize(2, this.b.s);
      }
      if (this.b.t != 0) {
        a(paramResources, localTextView);
      }
      if (this.b.x != 0) {
        localTextView.setTextAppearance(this.f, this.b.x);
      }
      return localTextView;
      if (this.b.B != 0)
      {
        a(localTextView, paramResources.getString(this.b.B));
        break;
      }
      localTextView.setText(this.a);
      break;
      label187:
      if (this.b.i != 0) {
        localTextView.setTextColor(paramResources.getColor(this.b.i));
      }
    }
  }
  
  private boolean p()
  {
    return (this.h != null) && (this.h.getParent() != null);
  }
  
  private boolean q()
  {
    return (this.d != null) && (this.d.getParent() != null);
  }
  
  private void r()
  {
    View localView = o();
    if (this.g != null) {}
    for (int m = View.MeasureSpec.makeMeasureSpec(this.g.getMeasuredWidth(), -2147483648);; m = View.MeasureSpec.makeMeasureSpec(this.f.getWindow().getDecorView().getMeasuredWidth(), -2147483648))
    {
      localView.measure(m, View.MeasureSpec.makeMeasureSpec(0, 0));
      return;
    }
  }
  
  private void s()
  {
    Resources localResources = this.f.getResources();
    this.h = a(localResources);
    RelativeLayout localRelativeLayout = b(localResources);
    this.h.addView(localRelativeLayout);
  }
  
  private ImageView t()
  {
    ImageView localImageView = new ImageView(this.f);
    localImageView.setId(256);
    localImageView.setAdjustViewBounds(true);
    localImageView.setScaleType(this.b.r);
    if (this.b.p != null) {
      localImageView.setImageDrawable(this.b.p);
    }
    if (this.b.q != 0) {
      localImageView.setImageResource(this.b.q);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localImageView.setLayoutParams(localLayoutParams);
    return localImageView;
  }
  
  public void b()
  {
    Manager.a().a(this);
  }
  
  public Animation c()
  {
    if ((this.i == null) && (this.f != null)) {
      if (k().c <= 0) {
        break label47;
      }
    }
    for (this.i = AnimationUtils.loadAnimation(l(), k().c);; this.i = DefaultAnimationsBuilder.a(o()))
    {
      return this.i;
      label47:
      r();
    }
  }
  
  public Animation d()
  {
    if ((this.j == null) && (this.f != null)) {
      if (k().d <= 0) {
        break label47;
      }
    }
    label47:
    for (this.j = AnimationUtils.loadAnimation(l(), k().d);; this.j = DefaultAnimationsBuilder.b(o())) {
      return this.j;
    }
  }
  
  boolean e()
  {
    return (this.f != null) && ((p()) || (q()));
  }
  
  void f()
  {
    this.f = null;
  }
  
  void g()
  {
    this.g = null;
  }
  
  void h()
  {
    this.k = null;
  }
  
  LifecycleCallback i()
  {
    return this.k;
  }
  
  Style j()
  {
    return this.b;
  }
  
  Configuration k()
  {
    if (this.c == null) {
      this.c = j().d;
    }
    return this.c;
  }
  
  Activity l()
  {
    return this.f;
  }
  
  ViewGroup m()
  {
    return this.g;
  }
  
  CharSequence n()
  {
    return this.a;
  }
  
  View o()
  {
    if (this.d != null) {
      return this.d;
    }
    if (this.h == null) {
      s();
    }
    return this.h;
  }
  
  public String toString()
  {
    return "Crouton{text=" + this.a + ", style=" + this.b + ", configuration=" + this.c + ", customView=" + this.d + ", onClickListener=" + this.e + ", activity=" + this.f + ", viewGroup=" + this.g + ", croutonView=" + this.h + ", inAnimation=" + this.i + ", outAnimation=" + this.j + ", lifecycleCallback=" + this.k + '}';
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     de.keyboardsurfer.android.widget.crouton.Crouton
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */