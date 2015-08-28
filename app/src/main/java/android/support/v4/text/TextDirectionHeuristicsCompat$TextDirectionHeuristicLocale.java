package android.support.v4.text;

import java.util.Locale;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  public static final TextDirectionHeuristicLocale INSTANCE = new TextDirectionHeuristicLocale();
  
  public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale()
  {
    super(null);
  }
  
  protected boolean defaultIsRtl()
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */