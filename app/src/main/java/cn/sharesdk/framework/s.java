package cn.sharesdk.framework;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

class s
  extends TextView
{
  s(TitleLayout paramTitleLayout, Context paramContext, ImageView paramImageView)
  {
    super(paramContext);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    this.a.setVisibility(paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.s
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */