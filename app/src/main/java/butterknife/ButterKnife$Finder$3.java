package butterknife;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$3
{
  ButterKnife$Finder$3()
  {
    super(str, i, null);
  }
  
  protected Context a(Object paramObject)
  {
    return ((Dialog)paramObject).getContext();
  }
  
  public View a(Object paramObject, int paramInt)
  {
    return ((Dialog)paramObject).findViewById(paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */