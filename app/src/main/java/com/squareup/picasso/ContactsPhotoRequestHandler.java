package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;
import java.util.List;

class ContactsPhotoRequestHandler
  extends RequestHandler
{
  private static final UriMatcher b = new UriMatcher(-1);
  final Context a;
  
  static
  {
    b.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
    b.addURI("com.android.contacts", "contacts/lookup/*", 1);
    b.addURI("com.android.contacts", "contacts/#/photo", 2);
    b.addURI("com.android.contacts", "contacts/#", 3);
    b.addURI("com.android.contacts", "display_photo/#", 4);
  }
  
  ContactsPhotoRequestHandler(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private Bitmap a(InputStream paramInputStream, Request paramRequest)
  {
    if (paramInputStream == null) {
      return null;
    }
    BitmapFactory.Options localOptions = d(paramRequest);
    InputStream localInputStream;
    if (a(localOptions)) {
      localInputStream = c(paramRequest);
    }
    try
    {
      BitmapFactory.decodeStream(localInputStream, null, localOptions);
      Utils.a(localInputStream);
      a(paramRequest.h, paramRequest.i, localOptions, paramRequest);
      return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    finally
    {
      Utils.a(localInputStream);
    }
  }
  
  private InputStream c(Request paramRequest)
  {
    ContentResolver localContentResolver = this.a.getContentResolver();
    Uri localUri = paramRequest.d;
    switch (b.match(localUri))
    {
    default: 
      throw new IllegalStateException("Invalid uri: " + localUri);
    case 1: 
      localUri = ContactsContract.Contacts.lookupContact(localContentResolver, localUri);
      if (localUri == null) {
        return null;
      }
    case 3: 
      if (Build.VERSION.SDK_INT < 14) {
        return ContactsContract.Contacts.openContactPhotoInputStream(localContentResolver, localUri);
      }
      return ContactsPhotoRequestHandler.ContactPhotoStreamIcs.a(localContentResolver, localUri);
    }
    return localContentResolver.openInputStream(localUri);
  }
  
  public boolean a(Request paramRequest)
  {
    Uri localUri = paramRequest.d;
    return ("content".equals(localUri.getScheme())) && (ContactsContract.Contacts.CONTENT_URI.getHost().equals(localUri.getHost())) && (!localUri.getPathSegments().contains("photo"));
  }
  
  public RequestHandler.Result b(Request paramRequest)
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = c(paramRequest);
      RequestHandler.Result localResult = new RequestHandler.Result(a(localInputStream, paramRequest), Picasso.LoadedFrom.b);
      return localResult;
    }
    finally
    {
      Utils.a(localInputStream);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContactsPhotoRequestHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */