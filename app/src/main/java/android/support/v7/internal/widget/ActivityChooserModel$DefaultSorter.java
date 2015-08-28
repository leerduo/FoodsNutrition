package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ActivityChooserModel$DefaultSorter
  implements ActivityChooserModel.ActivitySorter
{
  private final Map<String, ActivityChooserModel.ActivityResolveInfo> b = new HashMap();
  
  private ActivityChooserModel$DefaultSorter(ActivityChooserModel paramActivityChooserModel) {}
  
  public void a(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
  {
    Map localMap = this.b;
    localMap.clear();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)paramList.get(j);
      localActivityResolveInfo2.b = 0.0F;
      localMap.put(localActivityResolveInfo2.a.activityInfo.packageName, localActivityResolveInfo2);
    }
    int k = -1 + paramList1.size();
    float f1 = 1.0F;
    int m = k;
    if (m >= 0)
    {
      ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)paramList1.get(m);
      ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)localMap.get(localHistoricalRecord.a.getPackageName());
      if (localActivityResolveInfo1 == null) {
        break label178;
      }
      localActivityResolveInfo1.b += f1 * localHistoricalRecord.c;
    }
    label178:
    for (float f2 = 0.95F * f1;; f2 = f1)
    {
      m--;
      f1 = f2;
      break;
      Collections.sort(paramList);
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel.DefaultSorter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */