package cn.sharesdk.onekeyshare.theme.classic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.R.drawable;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.onekeyshare.CustomerLogo;

class PlatformGridView$GridView
  extends LinearLayout
{
  private Object[] beans;
  private View.OnClickListener callback;
  private int lines;
  private PlatformGridView.PlatformAdapter platformAdapter;
  
  public PlatformGridView$GridView(PlatformGridView.PlatformAdapter paramPlatformAdapter)
  {
    super(PlatformGridView.PlatformAdapter.access$800(paramPlatformAdapter).getContext());
    this.platformAdapter = paramPlatformAdapter;
    this.callback = PlatformGridView.PlatformAdapter.access$900(paramPlatformAdapter);
  }
  
  private Bitmap getIcon(Platform paramPlatform)
  {
    if (paramPlatform == null) {}
    while (paramPlatform.getName() == null) {
      return null;
    }
    String str = "logo_" + paramPlatform.getName();
    int i = R.getBitmapRes(getContext(), str);
    return BitmapFactory.decodeResource(getResources(), i);
  }
  
  private String getName(Platform paramPlatform)
  {
    if (paramPlatform == null) {
      return "";
    }
    if (paramPlatform.getName() == null) {
      return "";
    }
    int i = R.getStringRes(getContext(), paramPlatform.getName());
    if (i > 0) {
      return getContext().getString(i);
    }
    return null;
  }
  
  private LinearLayout getView(int paramInt, View.OnClickListener paramOnClickListener, Context paramContext)
  {
    Object localObject2;
    Object localObject1;
    if ((this.beans[paramInt] instanceof Platform))
    {
      localObject2 = getIcon((Platform)this.beans[paramInt]);
      localObject1 = getName((Platform)this.beans[paramInt]);
    }
    for (;;)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundResource(R.drawable.bg_button_selector);
      ImageView localImageView = new ImageView(paramContext);
      int i = R.dipToPx(paramContext, 5);
      localImageView.setPadding(i, i, i, i);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams1.setMargins(i, i, i, i);
      localLayoutParams1.gravity = 1;
      localImageView.setLayoutParams(localLayoutParams1);
      localImageView.setImageBitmap((Bitmap)localObject2);
      localLinearLayout.addView(localImageView);
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(1, 14.0F);
      localTextView.setSingleLine();
      localTextView.setIncludeFontPadding(false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams2.gravity = 1;
      localLayoutParams2.weight = 1.0F;
      localLayoutParams2.setMargins(i, 0, i, i);
      localTextView.setLayoutParams(localLayoutParams2);
      localTextView.setText((CharSequence)localObject1);
      localLinearLayout.addView(localTextView);
      localLinearLayout.setOnClickListener(paramOnClickListener);
      return localLinearLayout;
      Bitmap localBitmap = ((CustomerLogo)this.beans[paramInt]).logo;
      String str = ((CustomerLogo)this.beans[paramInt]).label;
      paramOnClickListener = ((CustomerLogo)this.beans[paramInt]).listener;
      localObject1 = str;
      localObject2 = localBitmap;
    }
  }
  
  private void init()
  {
    int i = R.dipToPx(getContext(), 5);
    setPadding(0, i, 0, i);
    setOrientation(1);
    if (this.beans == null) {}
    int k;
    LinearLayout.LayoutParams localLayoutParams;
    int n;
    LinearLayout localLinearLayout1;
    for (int j = 0;; j = this.beans.length)
    {
      k = PlatformGridView.access$400(PlatformGridView.PlatformAdapter.access$800(this.platformAdapter));
      int m = j / k;
      if (j % k > 0) {
        m++;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams.weight = 1.0F;
      for (n = 0;; n++)
      {
        if (n >= this.lines) {
          return;
        }
        localLinearLayout1 = new LinearLayout(getContext());
        localLinearLayout1.setLayoutParams(localLayoutParams);
        localLinearLayout1.setPadding(i, 0, i, 0);
        addView(localLinearLayout1);
        if (n < m) {
          break;
        }
      }
    }
    int i1 = 0;
    label145:
    int i2;
    if (i1 < k)
    {
      i2 = i1 + n * k;
      if (i2 < j) {
        break label199;
      }
      LinearLayout localLinearLayout2 = new LinearLayout(getContext());
      localLinearLayout2.setLayoutParams(localLayoutParams);
      localLinearLayout1.addView(localLinearLayout2);
    }
    for (;;)
    {
      i1++;
      break label145;
      break;
      label199:
      LinearLayout localLinearLayout3 = getView(i2, this.callback, getContext());
      localLinearLayout3.setTag(this.beans[i2]);
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLinearLayout1.addView(localLinearLayout3);
    }
  }
  
  public void setData(int paramInt, Object[] paramArrayOfObject)
  {
    this.lines = paramInt;
    this.beans = paramArrayOfObject;
    init();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.PlatformGridView.GridView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */