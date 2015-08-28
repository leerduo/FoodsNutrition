package android.support.v4.text;

class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal
  extends TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
{
  private final boolean mDefaultIsRtl;
  
  private TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(TextDirectionHeuristicsCompat.TextDirectionAlgorithm paramTextDirectionAlgorithm, boolean paramBoolean)
  {
    super(paramTextDirectionAlgorithm);
    this.mDefaultIsRtl = paramBoolean;
  }
  
  protected boolean defaultIsRtl()
  {
    return this.mDefaultIsRtl;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */