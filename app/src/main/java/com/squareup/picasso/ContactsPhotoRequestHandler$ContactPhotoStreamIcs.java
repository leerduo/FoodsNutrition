package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;

@TargetApi(14)
class ContactsPhotoRequestHandler$ContactPhotoStreamIcs
{
  static InputStream a(ContentResolver paramContentResolver, Uri paramUri)
  {
    return ContactsContract.Contacts.openContactPhotoInputStream(paramContentResolver, paramUri, true);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContactsPhotoRequestHandler.ContactPhotoStreamIcs
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */