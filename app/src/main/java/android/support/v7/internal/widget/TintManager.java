package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.util.TypedValue;

public class TintManager
{
  static final PorterDuff.Mode a;
  private static final String b = TintManager.class.getSimpleName();
  private static final TintManager.ColorFilterLruCache c;
  private static final int[] d;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  private static final int[] h = arrayOfInt5;
  private final Context i;
  private final Resources j;
  private final TypedValue k;
  private ColorStateList l;
  private ColorStateList m;
  private ColorStateList n;
  
  static
  {
    a = PorterDuff.Mode.SRC_IN;
    c = new TintManager.ColorFilterLruCache(6);
    int[] arrayOfInt1 = new int[14];
    arrayOfInt1[0] = R.drawable.abc_ic_ab_back_mtrl_am_alpha;
    arrayOfInt1[1] = R.drawable.abc_ic_go_search_api_mtrl_alpha;
    arrayOfInt1[2] = R.drawable.abc_ic_search_api_mtrl_alpha;
    arrayOfInt1[3] = R.drawable.abc_ic_commit_search_api_mtrl_alpha;
    arrayOfInt1[4] = R.drawable.abc_ic_clear_mtrl_alpha;
    arrayOfInt1[5] = R.drawable.abc_ic_menu_share_mtrl_alpha;
    arrayOfInt1[6] = R.drawable.abc_ic_menu_copy_mtrl_am_alpha;
    arrayOfInt1[7] = R.drawable.abc_ic_menu_cut_mtrl_alpha;
    arrayOfInt1[8] = R.drawable.abc_ic_menu_selectall_mtrl_alpha;
    arrayOfInt1[9] = R.drawable.abc_ic_menu_paste_mtrl_am_alpha;
    arrayOfInt1[10] = R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha;
    arrayOfInt1[11] = R.drawable.abc_ic_voice_search_api_mtrl_alpha;
    arrayOfInt1[12] = R.drawable.abc_textfield_search_default_mtrl_alpha;
    arrayOfInt1[13] = R.drawable.abc_textfield_default_mtrl_alpha;
    d = arrayOfInt1;
    int[] arrayOfInt2 = new int[3];
    arrayOfInt2[0] = R.drawable.abc_textfield_activated_mtrl_alpha;
    arrayOfInt2[1] = R.drawable.abc_textfield_search_activated_mtrl_alpha;
    arrayOfInt2[2] = R.drawable.abc_cab_background_top_mtrl_alpha;
    e = arrayOfInt2;
    int[] arrayOfInt3 = new int[3];
    arrayOfInt3[0] = R.drawable.abc_popup_background_mtrl_mult;
    arrayOfInt3[1] = R.drawable.abc_cab_background_internal_bg;
    arrayOfInt3[2] = R.drawable.abc_menu_hardkey_panel_mtrl_mult;
    f = arrayOfInt3;
    int[] arrayOfInt4 = new int[6];
    arrayOfInt4[0] = R.drawable.abc_edit_text_material;
    arrayOfInt4[1] = R.drawable.abc_tab_indicator_material;
    arrayOfInt4[2] = R.drawable.abc_textfield_search_material;
    arrayOfInt4[3] = R.drawable.abc_spinner_mtrl_am_alpha;
    arrayOfInt4[4] = R.drawable.abc_btn_check_material;
    arrayOfInt4[5] = R.drawable.abc_btn_radio_material;
    g = arrayOfInt4;
    int[] arrayOfInt5 = new int[1];
    arrayOfInt5[0] = R.drawable.abc_cab_background_top_material;
  }
  
  public TintManager(Context paramContext)
  {
    this.i = paramContext;
    this.j = new TintResources(paramContext.getResources(), this);
    this.k = new TypedValue();
  }
  
  private ColorStateList a()
  {
    if (this.l == null)
    {
      int i1 = b(R.attr.colorControlNormal);
      int i2 = b(R.attr.colorControlActivated);
      int[][] arrayOfInt = new int[7][];
      int[] arrayOfInt1 = new int[7];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = c(R.attr.colorControlNormal);
      arrayOfInt[1] = { 16842908 };
      arrayOfInt1[1] = i2;
      arrayOfInt[2] = { 16843518 };
      arrayOfInt1[2] = i2;
      arrayOfInt[3] = { 16842919 };
      arrayOfInt1[3] = i2;
      arrayOfInt[4] = { 16842912 };
      arrayOfInt1[4] = i2;
      arrayOfInt[5] = { 16842913 };
      arrayOfInt1[5] = i2;
      arrayOfInt[6] = new int[0];
      arrayOfInt1[6] = i1;
      this.l = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.l;
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    if (d(paramInt)) {
      return new TintManager(paramContext).a(paramInt);
    }
    return ContextCompat.getDrawable(paramContext, paramInt);
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = paramArrayOfInt.length;
    for (int i2 = 0;; i2++)
    {
      boolean bool = false;
      if (i2 < i1)
      {
        if (paramArrayOfInt[i2] == paramInt) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  private ColorStateList b()
  {
    if (this.n == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = a(16842800, 0.1F);
      arrayOfInt[1] = { 16842912 };
      arrayOfInt1[1] = a(R.attr.colorControlActivated, 0.3F);
      arrayOfInt[2] = new int[0];
      arrayOfInt1[2] = a(16842800, 0.3F);
      this.n = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.n;
  }
  
  private ColorStateList c()
  {
    if (this.m == null)
    {
      int[][] arrayOfInt = new int[3][];
      int[] arrayOfInt1 = new int[3];
      arrayOfInt[0] = { -16842910 };
      arrayOfInt1[0] = c(R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = { 16842912 };
      arrayOfInt1[1] = b(R.attr.colorControlActivated);
      arrayOfInt[2] = new int[0];
      arrayOfInt1[2] = b(R.attr.colorSwitchThumbNormal);
      this.m = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.m;
  }
  
  private static boolean d(int paramInt)
  {
    return (a(f, paramInt)) || (a(d, paramInt)) || (a(e, paramInt)) || (a(g, paramInt)) || (a(h, paramInt));
  }
  
  int a(int paramInt, float paramFloat)
  {
    int i1 = b(paramInt);
    int i2 = Color.alpha(i1);
    return i1 & 0xFFFFFF | Math.round(paramFloat * i2) << 24;
  }
  
  public Drawable a(int paramInt)
  {
    Drawable localDrawable = ContextCompat.getDrawable(this.i, paramInt);
    if (localDrawable != null)
    {
      if (a(g, paramInt)) {
        return new TintDrawableWrapper(localDrawable, a());
      }
      if (paramInt == R.drawable.abc_switch_track_mtrl_alpha) {
        return new TintDrawableWrapper(localDrawable, b());
      }
      if (paramInt == R.drawable.abc_switch_thumb_material) {
        return new TintDrawableWrapper(localDrawable, c(), PorterDuff.Mode.MULTIPLY);
      }
      if (a(h, paramInt)) {
        return this.j.getDrawable(paramInt);
      }
      a(paramInt, localDrawable);
    }
    return localDrawable;
  }
  
  void a(int paramInt, Drawable paramDrawable)
  {
    int i2;
    Object localObject;
    int i3;
    int i1;
    if (a(d, paramInt))
    {
      i2 = R.attr.colorControlNormal;
      localObject = null;
      i3 = 1;
      i1 = -1;
    }
    for (;;)
    {
      PorterDuffColorFilter localPorterDuffColorFilter1;
      PorterDuffColorFilter localPorterDuffColorFilter2;
      if (i3 != 0)
      {
        if (localObject == null) {
          localObject = a;
        }
        int i4 = b(i2);
        localPorterDuffColorFilter1 = c.a(i4, (PorterDuff.Mode)localObject);
        if (localPorterDuffColorFilter1 != null) {
          break label199;
        }
        localPorterDuffColorFilter2 = new PorterDuffColorFilter(i4, (PorterDuff.Mode)localObject);
        c.a(i4, (PorterDuff.Mode)localObject, localPorterDuffColorFilter2);
      }
      label199:
      for (PorterDuffColorFilter localPorterDuffColorFilter3 = localPorterDuffColorFilter2;; localPorterDuffColorFilter3 = localPorterDuffColorFilter1)
      {
        paramDrawable.setColorFilter(localPorterDuffColorFilter3);
        if (i1 != -1) {
          paramDrawable.setAlpha(i1);
        }
        return;
        if (a(e, paramInt))
        {
          i2 = R.attr.colorControlActivated;
          i3 = 1;
          i1 = -1;
          localObject = null;
          break;
        }
        if (a(f, paramInt))
        {
          PorterDuff.Mode localMode = PorterDuff.Mode.MULTIPLY;
          i3 = 1;
          i1 = -1;
          localObject = localMode;
          i2 = 16842801;
          break;
        }
        if (paramInt != R.drawable.abc_list_divider_mtrl_alpha) {
          break label206;
        }
        i2 = 16842800;
        int i5 = Math.round(40.799999F);
        i3 = 1;
        i1 = i5;
        localObject = null;
        break;
      }
      label206:
      i1 = -1;
      localObject = null;
      i2 = 0;
      i3 = 0;
    }
  }
  
  int b(int paramInt)
  {
    if (this.i.getTheme().resolveAttribute(paramInt, this.k, true))
    {
      if ((this.k.type >= 16) && (this.k.type <= 31)) {
        return this.k.data;
      }
      if (this.k.type == 3) {
        return this.j.getColor(this.k.resourceId);
      }
    }
    return 0;
  }
  
  int c(int paramInt)
  {
    this.i.getTheme().resolveAttribute(16842803, this.k, true);
    return a(paramInt, this.k.getFloat());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */