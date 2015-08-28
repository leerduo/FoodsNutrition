package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.e;

class c
  implements View.OnClickListener
{
  c(RegisterView paramRegisterView) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = R.getStringRes(paramView.getContext(), "website");
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramView.getResources().getString(i)));
      paramView.getContext().startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c(localThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */