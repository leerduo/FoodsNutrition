package com.google.zxing.client.androidlegacy;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

final class DecodeFormatManager
{
  static final Collection<BarcodeFormat> a;
  static final Collection<BarcodeFormat> b;
  static final Collection<BarcodeFormat> c;
  static final Collection<BarcodeFormat> d;
  private static final Pattern e = Pattern.compile(",");
  
  static
  {
    c = EnumSet.of(BarcodeFormat.l);
    d = EnumSet.of(BarcodeFormat.f);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.o;
    BarcodeFormat[] arrayOfBarcodeFormat = new BarcodeFormat[5];
    arrayOfBarcodeFormat[0] = BarcodeFormat.p;
    arrayOfBarcodeFormat[1] = BarcodeFormat.h;
    arrayOfBarcodeFormat[2] = BarcodeFormat.g;
    arrayOfBarcodeFormat[3] = BarcodeFormat.m;
    arrayOfBarcodeFormat[4] = BarcodeFormat.n;
    a = EnumSet.of(localBarcodeFormat, arrayOfBarcodeFormat);
    b = EnumSet.of(BarcodeFormat.c, BarcodeFormat.d, BarcodeFormat.e, BarcodeFormat.i, BarcodeFormat.b);
    b.addAll(a);
  }
  
  static Collection<BarcodeFormat> a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("SCAN_FORMATS");
    List localList = null;
    if (str != null) {
      localList = Arrays.asList(e.split(str));
    }
    return a(localList, paramIntent.getStringExtra("SCAN_MODE"));
  }
  
  static Collection<BarcodeFormat> a(Uri paramUri)
  {
    List localList = paramUri.getQueryParameters("SCAN_FORMATS");
    if ((localList != null) && (localList.size() == 1) && (localList.get(0) != null)) {
      localList = Arrays.asList(e.split((CharSequence)localList.get(0)));
    }
    return a(localList, paramUri.getQueryParameter("SCAN_MODE"));
  }
  
  private static Collection<BarcodeFormat> a(Iterable<String> paramIterable, String paramString)
  {
    EnumSet localEnumSet;
    if (paramIterable != null)
    {
      localEnumSet = EnumSet.noneOf(BarcodeFormat.class);
      try
      {
        Iterator localIterator = paramIterable.iterator();
        while (localIterator.hasNext()) {
          localEnumSet.add(BarcodeFormat.valueOf((String)localIterator.next()));
        }
        if (paramString == null) {
          break label110;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    }
    else
    {
      if (!"PRODUCT_MODE".equals(paramString)) {
        break label71;
      }
      return a;
    }
    return localEnumSet;
    label71:
    if ("QR_CODE_MODE".equals(paramString)) {
      return c;
    }
    if ("DATA_MATRIX_MODE".equals(paramString)) {
      return d;
    }
    if ("ONE_D_MODE".equals(paramString)) {
      return b;
    }
    label110:
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.DecodeFormatManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */