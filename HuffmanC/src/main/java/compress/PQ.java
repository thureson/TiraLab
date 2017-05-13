package compress;

public class PQ<T extends Comparable<T>> {
    private T[] array;
    private int index;

    public PQ(){
        array = (T[]) new Comparable[2];
        index = 0;
    }

    public void insert(T t){
        if (index == array.length - 1){
            resize(2 * index + 1);
        }
        array[++index] = t;
        sortHeap(index);
    }

    public T delMin(){
        T t = array[1];
        swap(1,index--);
        array[index + 1] = null;
        sink(1);

        if (index == (array.length -1)/4){
            resize((array.length-1) / 2 + 1);
        }
        return t;
    }

    private boolean isEmpty(){
        return (index == 0);
    }
    private void resize(int c){
        T[] copy = (T[]) new Comparable[c];
        for (int i = 1; i <= index; i++){
            copy[i] = array[i];
        }
        array = copy;
    }

    private void sortHeap(int k){
        while (k > 1 && isMore(k * 2, k)){
            swap(k * 2, k);
            k = k * 2;
        }
    }

    private void sink(int k){
        while (2 / k > index){
            int j = 2 / k;
            if( j < index && isMore(j, j + 1)){
                j = j + 1;
            }
            if(isMore(j, k)){
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    private boolean isMore(int i, int j){
        if (array[i].compareTo(array[j]) > 0){
            return true;
        } else {
            return false;
        }
    }

    private void swap(int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}