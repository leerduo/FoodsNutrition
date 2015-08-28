package butterknife;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;

public enum ButterKnife$Finder
{
  static
  {
    Finder[] arrayOfFinder = new Finder[3];
    arrayOfFinder[0] = a;
    arrayOfFinder[1] = b;
    arrayOfFinder[2] = c;
  }
  
  private ButterKnife$Finder() {}
  
  protected abstract Context a(Object paramObject);
  
  public abstract View a(Object paramObject, int paramInt);
  
  public View a(Object paramObject, int paramInt, String paramString)
  {
    View localView = a(paramObject, paramInt);
    if (localView == null)
    {
      String str = a(paramObject).getResources().getResourceEntryName(paramInt);
      throw new IllegalStateException("Required view '" + str + "' with ID " + paramInt + " for " + paramString + " was not found. If this view is optional add '@Optional' annotation.");
    }
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */