package compress;

public class OwnArrayList<E> {
 
    private transient E objects[];
    private int index;
    private int size;
    private static final int SIZE_FACTOR=5;
    
    public OwnArrayList(){
        this.objects = (E[]) new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }
    
    public void add(E o){
        if (this.index == this.size-1){
            addSize();
        }
        this.objects[this.index] = o;
        this.index++;
    }
     
    private void addSize() {
        this.size = this.size + SIZE_FACTOR;
        E newObject[] = (E[]) new Object[this.size];
        for (int i = 0; i < this.objects.length; i++){
            newObject[i] = this.objects[i];
        }
        this.objects = newObject;
    }
     
    public E get(int i) throws Exception{
        return (E) this.objects[i];  
    }
    
    public void set(int i, E e) throws Exception{
        this.objects[i] = e;  
    }
     
    public void remove(int i) throws Exception{
        for (int x = i; x < this.objects.length-1; x++){
            objects[x] = objects[x + 1];
        }
        this.index--;
    }
    
    public int size() throws Exception{
        return this.size;
    }
}