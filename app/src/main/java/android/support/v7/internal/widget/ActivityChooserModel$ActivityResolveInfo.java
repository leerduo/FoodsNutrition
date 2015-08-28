package android.support.v7.internal.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo
  implements Comparable<ActivityResolveInfo>
{
  public final ResolveInfo a;
  public float b;
  
  public ActivityChooserModel$ActivityResolveInfo(ActivityChooserModel paramActivityChooserModel, ResolveInfo paramResolveInfo)
  {
    this.a = paramResolveInfo;
  }
  
  public int a(ActivityResolveInfo paramActivityResolveInfo)
  {
    return Float.floatToIntBits(paramActivityResolveInfo.b) - Float.floatToIntBits(this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    ActivityResolveInfo localActivityResolveInfo;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      localActivityResolveInfo = (ActivityResolveInfo)paramObject;
    } while (Float.floatToIntBits(this.b) == Float.floatToIntBits(localActivityResolveInfo.b));
    return false;
  }
  
  public int hashCode()
  {
    return 31 + Float.floatToIntBits(this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(this.a.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(this.b));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.ActivityResolveInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */