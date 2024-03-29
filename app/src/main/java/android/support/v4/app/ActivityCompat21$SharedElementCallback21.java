package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

public abstract class ActivityCompat21$SharedElementCallback21
{
  public abstract Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF);
  
  public abstract View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable);
  
  public abstract void onMapSharedElements(List<String> paramList, Map<String, View> paramMap);
  
  public abstract void onRejectSharedElements(List<View> paramList);
  
  public abstract void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2);
  
  public abstract void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat21.SharedElementCallback21
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */