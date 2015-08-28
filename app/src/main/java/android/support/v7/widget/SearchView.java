package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements CollapsibleActionView
{
  static final SearchView.AutoCompleteTextViewReflector a;
  private static final boolean b;
  private boolean A;
  private int B;
  private boolean C;
  private CharSequence D;
  private boolean E;
  private int F;
  private SearchableInfo G;
  private Bundle H;
  private final TintManager I;
  private Runnable J;
  private final Runnable K;
  private Runnable L;
  private final WeakHashMap<String, Drawable.ConstantState> M;
  private final SearchView.SearchAutoComplete c;
  private final View d;
  private final View e;
  private final ImageView f;
  private final ImageView g;
  private final ImageView h;
  private final ImageView i;
  private final ImageView j;
  private final int k;
  private final int l;
  private final int m;
  private final Intent n;
  private final Intent o;
  private SearchView.OnQueryTextListener p;
  private SearchView.OnCloseListener q;
  private View.OnFocusChangeListener r;
  private SearchView.OnSuggestionListener s;
  private View.OnClickListener t;
  private boolean u;
  private boolean v;
  private CursorAdapter w;
  private boolean x;
  private CharSequence y;
  private boolean z;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new SearchView.AutoCompleteTextViewReflector();
      return;
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.addFlags(268435456);
    if (paramUri != null) {
      localIntent.setData(paramUri);
    }
    localIntent.putExtra("user_query", this.D);
    if (paramString3 != null) {
      localIntent.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      localIntent.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.H != null) {
      localIntent.putExtra("app_data", this.H);
    }
    if (paramInt != 0)
    {
      localIntent.putExtra("action_key", paramInt);
      localIntent.putExtra("action_msg", paramString4);
    }
    if (b) {
      localIntent.setComponent(this.G.getSearchActivity());
    }
    return localIntent;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = a("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool1 = true;
    int i1 = 8;
    this.v = paramBoolean;
    int i2;
    boolean bool2;
    label33:
    int i3;
    if (paramBoolean)
    {
      i2 = 0;
      if (TextUtils.isEmpty(this.c.getText())) {
        break label112;
      }
      bool2 = bool1;
      this.f.setVisibility(i2);
      b(bool2);
      View localView = this.d;
      if (!paramBoolean) {
        break label118;
      }
      i3 = i1;
      label61:
      localView.setVisibility(i3);
      ImageView localImageView = this.j;
      if (!this.u) {
        break label124;
      }
      label81:
      localImageView.setVisibility(i1);
      h();
      if (bool2) {
        break label129;
      }
    }
    for (;;)
    {
      c(bool1);
      g();
      return;
      i2 = i1;
      break;
      label112:
      bool2 = false;
      break label33;
      label118:
      i3 = 0;
      break label61;
      label124:
      i1 = 0;
      break label81;
      label129:
      bool1 = false;
    }
  }
  
  static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private CharSequence b(CharSequence paramCharSequence)
  {
    if (!this.u) {
      return paramCharSequence;
    }
    Drawable localDrawable = this.I.a(this.k);
    int i1 = (int)(1.25D * this.c.getTextSize());
    localDrawable.setBounds(0, 0, i1, i1);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable), 1, 2, 33);
    return localSpannableStringBuilder;
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 8;
    if ((this.x) && (f()) && (hasFocus()) && ((paramBoolean) || (!this.C))) {
      i1 = 0;
    }
    this.g.setVisibility(i1);
  }
  
  private void c(boolean paramBoolean)
  {
    int i1;
    if ((this.C) && (!c()) && (paramBoolean))
    {
      i1 = 0;
      this.g.setVisibility(8);
    }
    for (;;)
    {
      this.i.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
  
  @TargetApi(8)
  private boolean e()
  {
    SearchableInfo localSearchableInfo = this.G;
    boolean bool1 = false;
    Intent localIntent;
    if (localSearchableInfo != null)
    {
      boolean bool2 = this.G.getVoiceSearchEnabled();
      bool1 = false;
      if (bool2)
      {
        if (!this.G.getVoiceSearchLaunchWebSearch()) {
          break label76;
        }
        localIntent = this.n;
      }
    }
    for (;;)
    {
      bool1 = false;
      if (localIntent != null)
      {
        ResolveInfo localResolveInfo = getContext().getPackageManager().resolveActivity(localIntent, 65536);
        bool1 = false;
        if (localResolveInfo != null) {
          bool1 = true;
        }
      }
      return bool1;
      label76:
      boolean bool3 = this.G.getVoiceSearchLaunchRecognizer();
      localIntent = null;
      if (bool3) {
        localIntent = this.o;
      }
    }
  }
  
  private boolean f()
  {
    return ((this.x) || (this.C)) && (!c());
  }
  
  private void g()
  {
    int i1 = 8;
    if ((f()) && ((this.g.getVisibility() == 0) || (this.i.getVisibility() == 0))) {
      i1 = 0;
    }
    this.e.setVisibility(i1);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private void h()
  {
    int i1 = 1;
    int i2;
    label35:
    int i3;
    label47:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.c.getText()))
    {
      i2 = i1;
      if ((i2 == 0) && ((!this.u) || (this.E))) {
        break label85;
      }
      ImageView localImageView = this.h;
      i3 = 0;
      if (i1 == 0) {
        break label90;
      }
      localImageView.setVisibility(i3);
      localDrawable = this.h.getDrawable();
      if (i2 == 0) {
        break label97;
      }
    }
    label85:
    label90:
    label97:
    for (int[] arrayOfInt = ENABLED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      localDrawable.setState(arrayOfInt);
      return;
      i2 = 0;
      break;
      i1 = 0;
      break label35;
      i3 = 8;
      break label47;
    }
  }
  
  private void i()
  {
    post(this.K);
  }
  
  private void k()
  {
    if (this.y != null) {
      this.c.setHint(b(this.y));
    }
    String str;
    do
    {
      return;
      if ((!b) || (this.G == null)) {
        break;
      }
      int i1 = this.G.getHintId();
      str = null;
      if (i1 != 0) {
        str = getContext().getString(i1);
      }
    } while (str == null);
    this.c.setHint(b(str));
    return;
    this.c.setHint(b(""));
  }
  
  @TargetApi(8)
  private void l()
  {
    int i1 = 1;
    this.c.setThreshold(this.G.getSuggestThreshold());
    this.c.setImeOptions(this.G.getImeOptions());
    int i2 = this.G.getInputType();
    if ((i2 & 0xF) == i1)
    {
      i2 &= -65537;
      if (this.G.getSuggestAuthority() != null) {
        i2 = 0x80000 | (i2 | 0x10000);
      }
    }
    this.c.setInputType(i2);
    if (this.w != null) {
      this.w.changeCursor(null);
    }
    if (this.G.getSuggestAuthority() != null)
    {
      this.w = new SuggestionsAdapter(getContext(), this, this.G, this.M);
      this.c.setAdapter(this.w);
      SuggestionsAdapter localSuggestionsAdapter = (SuggestionsAdapter)this.w;
      if (this.z) {
        i1 = 2;
      }
      localSuggestionsAdapter.a(i1);
    }
  }
  
  private void m()
  {
    Editable localEditable = this.c.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((this.p == null) || (!this.p.a(localEditable.toString()))))
    {
      if (this.G != null) {
        a(0, null, localEditable.toString());
      }
      setImeVisibility(false);
      n();
    }
  }
  
  private void n()
  {
    this.c.dismissDropDown();
  }
  
  private void o()
  {
    if (TextUtils.isEmpty(this.c.getText()))
    {
      if ((this.u) && ((this.q == null) || (!this.q.a())))
      {
        clearFocus();
        a(true);
      }
      return;
    }
    this.c.setText("");
    this.c.requestFocus();
    setImeVisibility(true);
  }
  
  private void p()
  {
    a(false);
    this.c.requestFocus();
    setImeVisibility(true);
    if (this.t != null) {
      this.t.onClick(this);
    }
  }
  
  private void q()
  {
    a.a(this.c);
    a.b(this.c);
  }
  
  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(this.J);
    }
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(this.J);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.c;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i1 = 0;; i1 = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i1);
      return;
    }
  }
  
  public void a()
  {
    if (this.E) {
      return;
    }
    this.E = true;
    this.F = this.c.getImeOptions();
    this.c.setImeOptions(0x2000000 | this.F);
    this.c.setText("");
    setIconified(false);
  }
  
  void a(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.c.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      this.c.setSelection(this.c.length());
      this.D = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      m();
    }
  }
  
  public void b()
  {
    a("", false);
    clearFocus();
    a(true);
    this.c.setImeOptions(this.F);
    this.E = false;
  }
  
  public boolean c()
  {
    return this.v;
  }
  
  public void clearFocus()
  {
    this.A = true;
    setImeVisibility(false);
    super.clearFocus();
    this.c.clearFocus();
    this.A = false;
  }
  
  void d()
  {
    a(c());
    i();
    if (this.c.hasFocus()) {
      q();
    }
  }
  
  public int getImeOptions()
  {
    return this.c.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.c.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.B;
  }
  
  public CharSequence getQuery()
  {
    return this.c.getText();
  }
  
  public CharSequence getQueryHint()
  {
    CharSequence localCharSequence;
    if (this.y != null) {
      localCharSequence = this.y;
    }
    int i1;
    do
    {
      SearchableInfo localSearchableInfo;
      do
      {
        boolean bool;
        do
        {
          return localCharSequence;
          bool = b;
          localCharSequence = null;
        } while (!bool);
        localSearchableInfo = this.G;
        localCharSequence = null;
      } while (localSearchableInfo == null);
      i1 = this.G.getHintId();
      localCharSequence = null;
    } while (i1 == 0);
    return getContext().getString(i1);
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.m;
  }
  
  int getSuggestionRowLayout()
  {
    return this.l;
  }
  
  public CursorAdapter getSuggestionsAdapter()
  {
    return this.w;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.K);
    post(this.L);
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (c())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    switch (i1)
    {
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), paramInt2);
      return;
      if (this.B > 0)
      {
        i2 = Math.min(this.B, i2);
      }
      else
      {
        i2 = Math.min(getPreferredWidth(), i2);
        continue;
        if (this.B > 0)
        {
          i2 = Math.min(this.B, i2);
          continue;
          if (this.B > 0) {
            i2 = this.B;
          } else {
            i2 = getPreferredWidth();
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    i();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.A) {}
    while (!isFocusable()) {
      return false;
    }
    if (!c())
    {
      boolean bool = this.c.requestFocus(paramInt, paramRect);
      if (bool) {
        a(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.H = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      o();
      return;
    }
    p();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.u == paramBoolean) {
      return;
    }
    this.u = paramBoolean;
    a(paramBoolean);
    k();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.c.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.c.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.B = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(SearchView.OnCloseListener paramOnCloseListener)
  {
    this.q = paramOnCloseListener;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.r = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(SearchView.OnQueryTextListener paramOnQueryTextListener)
  {
    this.p = paramOnQueryTextListener;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.t = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(SearchView.OnSuggestionListener paramOnSuggestionListener)
  {
    this.s = paramOnSuggestionListener;
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.y = paramCharSequence;
    k();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
    SuggestionsAdapter localSuggestionsAdapter;
    if ((this.w instanceof SuggestionsAdapter))
    {
      localSuggestionsAdapter = (SuggestionsAdapter)this.w;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i1 = 2;; i1 = 1)
    {
      localSuggestionsAdapter.a(i1);
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.G = paramSearchableInfo;
    if (this.G != null)
    {
      if (b) {
        l();
      }
      k();
    }
    if ((b) && (e())) {}
    for (boolean bool = true;; bool = false)
    {
      this.C = bool;
      if (this.C) {
        this.c.setPrivateImeOptions("nm");
      }
      a(c());
      return;
    }
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.x = paramBoolean;
    a(c());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    this.w = paramCursorAdapter;
    this.c.setAdapter(this.w);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */