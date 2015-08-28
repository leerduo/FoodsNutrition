package butterknife;

import android.app.Activity;
import android.content.Context;
import android.view.View;

 enum ButterKnife$Finder$2
{
  ButterKnife$Finder$2()
  {
    super(str, i, null);
  }
  
  protected Context a(Object paramObject)
  {
    return (Activity)paramObject;
  }
  
  public View a(Object paramObject, int paramInt)
  {
    return ((Activity)paramObject).findViewById(paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */