package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

final class DecodeFormatManager
{
  static final Set<BarcodeFormat> a;
  static final Set<BarcodeFormat> b;
  static final Set<BarcodeFormat> c;
  static final Set<BarcodeFormat> d;
  static final Set<BarcodeFormat> e;
  static final Set<BarcodeFormat> f;
  private static final Pattern g = Pattern.compile(",");
  private static final Set<BarcodeFormat> h;
  private static final Map<String, Set<BarcodeFormat>> i;
  
  static
  {
    c = EnumSet.of(BarcodeFormat.l);
    d = EnumSet.of(BarcodeFormat.f);
    e = EnumSet.of(BarcodeFormat.a);
    f = EnumSet.of(BarcodeFormat.k);
    BarcodeFormat localBarcodeFormat = BarcodeFormat.o;
    BarcodeFormat[] arrayOfBarcodeFormat = new BarcodeFormat[5];
    arrayOfBarcodeFormat[0] = BarcodeFormat.p;
    arrayOfBarcodeFormat[1] = BarcodeFormat.h;
    arrayOfBarcodeFormat[2] = BarcodeFormat.g;
    arrayOfBarcodeFormat[3] = BarcodeFormat.m;
    arrayOfBarcodeFormat[4] = BarcodeFormat.n;
    a = EnumSet.of(localBarcodeFormat, arrayOfBarcodeFormat);
    b = EnumSet.of(BarcodeFormat.c, BarcodeFormat.d, BarcodeFormat.e, BarcodeFormat.i, BarcodeFormat.b);
    h = EnumSet.copyOf(a);
    h.addAll(b);
    i = new HashMap();
    i.put("ONE_D_MODE", h);
    i.put("PRODUCT_MODE", a);
    i.put("QR_CODE_MODE", c);
    i.put("DATA_MATRIX_MODE", d);
    i.put("AZTEC_MODE", e);
    i.put("PDF417_MODE", f);
  }
  
  static Set<BarcodeFormat> a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("SCAN_FORMATS");
    List localList = null;
    if (str != null) {
      localList = Arrays.asList(g.split(str));
    }
    return a(localList, paramIntent.getStringExtra("SCAN_MODE"));
  }
  
  static Set<BarcodeFormat> a(Uri paramUri)
  {
    List localList = paramUri.getQueryParameters("SCAN_FORMATS");
    if ((localList != null) && (localList.size() == 1) && (localList.get(0) != null)) {
      localList = Arrays.asList(g.split((CharSequence)localList.get(0)));
    }
    return a(localList, paramUri.getQueryParameter("SCAN_MODE"));
  }
  
  private static Set<BarcodeFormat> a(Iterable<String> paramIterable, String paramString)
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
          break label71;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
    }
    else
    {
      return (Set)i.get(paramString);
    }
    return localEnumSet;
    label71:
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.DecodeFormatManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */