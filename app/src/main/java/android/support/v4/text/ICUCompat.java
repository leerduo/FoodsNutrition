package android.support.v4.text;

import android.os.Build.VERSION;

public class ICUCompat
{
  private static final ICUCompat.ICUCompatImpl IMPL = new ICUCompat.ICUCompatImplBase();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new ICUCompat.ICUCompatImplIcs();
      return;
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    return IMPL.addLikelySubtags(paramString);
  }
  
  public static String getScript(String paramString)
  {
    return IMPL.getScript(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */