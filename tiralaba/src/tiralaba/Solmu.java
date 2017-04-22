package tiralaba;

/* Pakollinen osa puu-rakennetta */
public class Solmu {
    private byte key;
    private Solmu left;
    private Solmu right;
    private int maara;
    
    public Solmu(byte key, Solmu left, Solmu right, int maara){
        this.key = key;
        this.left = left;
        this.right = right;
        this.maara = maara;
    }
    
    /* Tarkistetaan onko solmulla lapsia */
    public boolean onkoLehti(){
        if (left == null && right == null){
            return true;
        } else {
            return false;
        }
    }
    
    public byte returnKey(){
        return this.key;
    }
    
    public Solmu returnLeft(){
        return this.left;
    }
    
    public Solmu returnRight(){
        return this.right;
    }
    
    public int returnMaara(){
        return this.maara;
    }
}
