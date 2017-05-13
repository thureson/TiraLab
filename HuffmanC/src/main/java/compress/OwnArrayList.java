package compress;

public class OwnArrayList<E> {
 
    private transient Object objects[];
    private int index;
    private int size;
    private static final int SIZE_FACTOR=5;
    
    public OwnArrayList(){
        this(0);
    }
    
    public OwnArrayList(Object o){
        if (o.equals(0)){
            this.objects = new Object[SIZE_FACTOR];
            this.size = SIZE_FACTOR;
        } else {
            this.objects = new Object[SIZE_FACTOR];
            this.size = SIZE_FACTOR;
            add(o);
        }
    }
    
    public void add(Object o){
        if (this.index == this.size-1){
            addSize();
        }
        this.objects[this.index] = o;
        this.index++;
    }
     
    private void addSize() {
        this.size = this.size + SIZE_FACTOR;
        Object newObject[] = new Object[this.size];
        for (int i = 0; i < this.objects.length; i++){
            newObject[i] = this.objects[i];
        }
        this.objects = newObject;
    }
     
    public Object get(int i) throws Exception{
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