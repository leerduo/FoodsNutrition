package android.support.v4.media.routing;

import android.content.Context;
import android.media.MediaRouter.RouteCategory;
import java.util.ArrayList;
import java.util.List;

public final class MediaRouterJellybean$RouteCategory
{
  public static CharSequence getName(Object paramObject, Context paramContext)
  {
    return ((MediaRouter.RouteCategory)paramObject).getName(paramContext);
  }
  
  public static List getRoutes(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    ((MediaRouter.RouteCategory)paramObject).getRoutes(localArrayList);
    return localArrayList;
  }
  
  public static int getSupportedTypes(Object paramObject)
  {
    return ((MediaRouter.RouteCategory)paramObject).getSupportedTypes();
  }
  
  public static boolean isGroupable(Object paramObject)
  {
    return ((MediaRouter.RouteCategory)paramObject).isGroupable();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.RouteCategory
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */