package android.support.v4.print;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import java.io.FileNotFoundException;

class PrintHelperKitkat$2$1
  extends AsyncTask<Uri, Boolean, Bitmap>
{
  PrintHelperKitkat$2$1(PrintHelperKitkat.2 param2, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback) {}
  
  protected Bitmap doInBackground(Uri... paramVarArgs)
  {
    try
    {
      Bitmap localBitmap = PrintHelperKitkat.access$200(this.this$1.this$0, this.this$1.val$imageFile, 3500);
      return localBitmap;
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
  
  protected void onCancelled(Bitmap paramBitmap)
  {
    this.val$layoutResultCallback.onLayoutCancelled();
  }
  
  protected void onPostExecute(Bitmap paramBitmap)
  {
    int i = 1;
    super.onPostExecute(paramBitmap);
    this.this$1.mBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(this.this$1.val$jobName).setContentType(i).setPageCount(i).build();
      if (!this.val$newPrintAttributes.equals(this.val$oldPrintAttributes)) {}
      for (;;)
      {
        this.val$layoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
        return;
        int j = 0;
      }
    }
    this.val$layoutResultCallback.onLayoutFailed(null);
  }
  
  protected void onPreExecute()
  {
    this.val$cancellationSignal.setOnCancelListener(new PrintHelperKitkat.2.1.1(this));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat.2.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */