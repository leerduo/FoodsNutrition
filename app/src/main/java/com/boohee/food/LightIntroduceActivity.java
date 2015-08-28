package com.boohee.food;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import butterknife.ButterKnife;

public class LightIntroduceActivity
  extends BaseActivity
{
  TextView b;
  TextView c;
  TextView d;
  
  private void a(int paramInt1, String paramString, int paramInt2, TextView paramTextView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<font color='" + paramString + "'>");
    localStringBuilder.append("<big><big>");
    localStringBuilder.append(getResources().getString(paramInt1));
    localStringBuilder.append("</big></big>");
    localStringBuilder.append("</font>");
    localStringBuilder.append("<big>");
    localStringBuilder.append(getResources().getString(paramInt2));
    localStringBuilder.append("</big>");
    paramTextView.setText(Html.fromHtml(localStringBuilder.toString()));
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, LightIntroduceActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903076);
    ButterKnife.a(this);
    a(2131558492, "#59B700", 2131558491, this.b);
    a(2131558497, "#FFB700", 2131558496, this.c);
    a(2131558494, "#FF3300", 2131558493, this.d);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.LightIntroduceActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */