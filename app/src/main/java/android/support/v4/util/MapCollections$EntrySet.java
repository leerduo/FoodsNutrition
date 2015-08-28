package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MapCollections$EntrySet
  implements Set<Map.Entry<K, V>>
{
  MapCollections$EntrySet(MapCollections paramMapCollections) {}
  
  public boolean add(Map.Entry<K, V> paramEntry)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = this.this$0.colGetSize();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.this$0.colPut(localEntry.getKey(), localEntry.getValue());
    }
    return i != this.this$0.colGetSize();
  }
  
  public void clear()
  {
    this.this$0.colClear();
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    Map.Entry localEntry;
    int i;
    do
    {
      return false;
      localEntry = (Map.Entry)paramObject;
      i = this.this$0.colIndexOfKey(localEntry.getKey());
    } while (i < 0);
    return ContainerHelpers.equal(this.this$0.colGetEntry(i, 1), localEntry.getValue());
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      if (!contains(localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    return MapCollections.equalsSetHelper(this, paramObject);
  }
  
  public int hashCode()
  {
    int i = -1 + this.this$0.colGetSize();
    int j = 0;
    if (i >= 0)
    {
      Object localObject1 = this.this$0.colGetEntry(i, 0);
      Object localObject2 = this.this$0.colGetEntry(i, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label44:
        if (localObject2 != null) {
          break label79;
        }
      }
      label79:
      for (int m = 0;; m = localObject2.hashCode())
      {
        int n = j + (m ^ k);
        i--;
        j = n;
        break;
        k = localObject1.hashCode();
        break label44;
      }
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return this.this$0.colGetSize() == 0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new MapCollections.MapIterator(this.this$0);
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.this$0.colGetSize();
  }
  
  public Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.MapCollections.EntrySet
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */