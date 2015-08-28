package android.support.v4.text;

class TextDirectionHeuristicsCompat$AnyStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
  public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  private final boolean mLookForRtl;
  
  private TextDirectionHeuristicsCompat$AnyStrong(boolean paramBoolean)
  {
    this.mLookForRtl = paramBoolean;
  }
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = paramInt1 + paramInt2;
    int k = 0;
    for (;;)
    {
      if (paramInt1 < j) {
        switch (TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(paramCharSequence.charAt(paramInt1))))
        {
        default: 
          paramInt1++;
          break;
        case 0: 
          if (this.mLookForRtl) {
            i = 0;
          }
          break;
        }
      }
    }
    do
    {
      do
      {
        return i;
        k = i;
        break;
      } while (!this.mLookForRtl);
      k = i;
      break;
      if (k == 0) {
        break label106;
      }
    } while (this.mLookForRtl);
    return 0;
    label106:
    return 2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */