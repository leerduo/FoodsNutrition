package android.support.v7.internal.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord
{
  public final ComponentName a;
  public final long b;
  public final float c;
  
  public ActivityChooserModel$HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    this.a = paramComponentName;
    this.b = paramLong;
    this.c = paramFloat;
  }
  
  public ActivityChooserModel$HistoricalRecord(String paramString, long paramLong, float paramFloat)
  {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    HistoricalRecord localHistoricalRecord;
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      localHistoricalRecord = (HistoricalRecord)paramObject;
      if (this.a == null)
      {
        if (localHistoricalRecord.a != null) {
          return false;
        }
      }
      else if (!this.a.equals(localHistoricalRecord.a)) {
        return false;
      }
      if (this.b != localHistoricalRecord.b) {
        return false;
      }
    } while (Float.floatToIntBits(this.c) == Float.floatToIntBits(localHistoricalRecord.c));
    return false;
  }
  
  public int hashCode()
  {
    if (this.a == null) {}
    for (int i = 0;; i = this.a.hashCode()) {
      return 31 * (31 * (i + 31) + (int)(this.b ^ this.b >>> 32)) + Float.floatToIntBits(this.c);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:").append(this.a);
    localStringBuilder.append("; time:").append(this.b);
    localStringBuilder.append("; weight:").append(new BigDecimal(this.c));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.HistoricalRecord
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */