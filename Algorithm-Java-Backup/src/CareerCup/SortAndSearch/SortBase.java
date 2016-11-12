/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package CareerCup.SortAndSearch;
public abstract class SortBase<T> {
    
    public T[] array ;
    public SortBase(T[] _array){
        this.array = _array;
    }
    
    abstract void sort();
    
    protected void swap(int a, int b)
    {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
}
