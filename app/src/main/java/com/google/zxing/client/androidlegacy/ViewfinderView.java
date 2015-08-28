package com.google.zxing.client.androidlegacy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.androidlegacy.camera.CameraManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ViewfinderView
  extends View
{
  private static final int[] a = { 0, 64, 128, 192, 255, 192, 128, 64 };
  private CameraManager b;
  private final Paint c = new Paint(1);
  private Bitmap d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private int i;
  private List<ResultPoint> j;
  private List<ResultPoint> k;
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.e = localResources.getColor(R.color.zxinglegacy_viewfinder_mask);
    this.f = localResources.getColor(R.color.zxinglegacy_result_view);
    this.g = localResources.getColor(R.color.zxinglegacy_viewfinder_laser);
    this.h = localResources.getColor(R.color.zxinglegacy_possible_result_points);
    this.i = 0;
    this.j = new ArrayList(5);
    this.k = null;
  }
  
  public void a()
  {
    Bitmap localBitmap = this.d;
    this.d = null;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    invalidate();
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    invalidate();
  }
  
  public void a(ResultPoint paramResultPoint)
  {
    synchronized (this.j)
    {
      ???.add(paramResultPoint);
      int m = ???.size();
      if (m > 20) {
        ???.subList(0, m - 10).clear();
      }
      return;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.b == null) {}
    Rect localRect1;
    Rect localRect2;
    do
    {
      return;
      localRect1 = this.b.e();
      localRect2 = this.b.f();
    } while ((localRect1 == null) || (localRect2 == null));
    int m = paramCanvas.getWidth();
    int n = paramCanvas.getHeight();
    Paint localPaint = this.c;
    if (this.d != null) {}
    for (int i1 = this.f;; i1 = this.e)
    {
      localPaint.setColor(i1);
      paramCanvas.drawRect(0.0F, 0.0F, m, localRect1.top, this.c);
      paramCanvas.drawRect(0.0F, localRect1.top, localRect1.left, 1 + localRect1.bottom, this.c);
      paramCanvas.drawRect(1 + localRect1.right, localRect1.top, m, 1 + localRect1.bottom, this.c);
      paramCanvas.drawRect(0.0F, 1 + localRect1.bottom, m, n, this.c);
      if (this.d == null) {
        break;
      }
      this.c.setAlpha(160);
      paramCanvas.drawBitmap(this.d, null, localRect1, this.c);
      return;
    }
    this.c.setColor(this.g);
    this.c.setAlpha(a[this.i]);
    this.i = ((1 + this.i) % a.length);
    int i2 = localRect1.height() / 2 + localRect1.top;
    paramCanvas.drawRect(2 + localRect1.left, i2 - 1, -1 + localRect1.right, i2 + 2, this.c);
    float f1 = localRect1.width() / localRect2.width();
    float f2 = localRect1.height() / localRect2.height();
    List localList1 = this.j;
    List localList2 = this.k;
    int i3 = localRect1.left;
    int i4 = localRect1.top;
    if (localList1.isEmpty()) {
      this.k = null;
    }
    while (localList2 != null)
    {
      this.c.setAlpha(80);
      this.c.setColor(this.h);
      try
      {
        Iterator localIterator2 = localList2.iterator();
        while (localIterator2.hasNext())
        {
          ResultPoint localResultPoint1 = (ResultPoint)localIterator2.next();
          paramCanvas.drawCircle(i3 + (int)(f1 * localResultPoint1.a()), i4 + (int)(f2 * localResultPoint1.b()), 3.0F, this.c);
        }
        this.j = new ArrayList(5);
      }
      finally {}
      this.k = localList1;
      this.c.setAlpha(160);
      this.c.setColor(this.h);
      try
      {
        Iterator localIterator1 = localList1.iterator();
        while (localIterator1.hasNext())
        {
          ResultPoint localResultPoint2 = (ResultPoint)localIterator1.next();
          paramCanvas.drawCircle(i3 + (int)(f1 * localResultPoint2.a()), i4 + (int)(f2 * localResultPoint2.b()), 6.0F, this.c);
        }
      }
      finally {}
    }
    postInvalidateDelayed(80L, -6 + localRect1.left, -6 + localRect1.top, 6 + localRect1.right, 6 + localRect1.bottom);
  }
  
  public void setCameraManager(CameraManager paramCameraManager)
  {
    this.b = paramCameraManager;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.ViewfinderView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */