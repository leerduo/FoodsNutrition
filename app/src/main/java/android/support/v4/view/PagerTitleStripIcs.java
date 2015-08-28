package android.support.v4.view;

import android.widget.TextView;

class PagerTitleStripIcs
{
  public static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new PagerTitleStripIcs.SingleLineAllCapsTransform(paramTextView.getContext()));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStripIcs
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */