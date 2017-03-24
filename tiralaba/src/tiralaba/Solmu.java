package tiralaba;

public class Solmu {
    private char key;
    private Solmu left;
    private Solmu right;
    private Solmu parent;
    
    public Solmu(char key, Solmu left, Solmu right, Solmu parent){
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    
    public boolean onLehti(){
        if (left == null && right == null){
            return true;
        } else {
            return false;
        }
    }
    
    public char returnKey(){
        return this.key;
    }
    
    public Solmu returnLeft(){
        return this.left;
    }
    
    public Solmu returnRight(){
        return this.right;
    }
    
    public Solmu returnParent(){
        return this.parent;
    }
}
