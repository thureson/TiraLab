
package tiralaba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    public byte[] readFile(String lTiedosto) throws IOException{
        File file = new File(lTiedosto);
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
//            for (int i = 0; i < bFile.length; i++) {
//                System.out.print((char) bFile[i]);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
//        Path path = (Path) Paths.get(lTiedosto);
//        return Files.readAllBytes((java.nio.file.Path) path);
    }
    
    
    public void kirjoitaTiedosto(byte[] bytes, String kTiedosto) throws IOException{
//        Path path = (Path) Paths.get(kTiedosto);
//        Files.write(path, bytes);
        FileOutputStream fos = new FileOutputStream(kTiedosto);
        fos.write(bytes);
        fos.close();
    }
    
    public void kirjoitaTiedostoString(String bytees, String kTiedosto) throws IOException{
//        Path path = (Path) Paths.get(kTiedosto);
//        Files.write(path, bytes);
          byte[] bytes = bytees.getBytes();
          int[] newBytes = new int[bytees.getBytes().length];
          for(int i = 0; i < bytes.length; i++){
              String binaryStringRep = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
              System.out.println(binaryStringRep);
//              byte newByte = Byte.parseByte(binaryStringRep, 2);
              int newByte = Integer.parseInt(binaryStringRep, 2);
              newBytes[i] = newByte;
          }
        FileOutputStream fos = new FileOutputStream(kTiedosto);
        for (int a : newBytes){
            fos.write(a);
        }
        
        fos.close();
    }
    
    public void kirjoitaTiedostoIntegers(int bytes, String kTiedosto) throws IOException{
//        Path path = (Path) Paths.get(kTiedosto);
//        Files.write(path, bytes);
        FileOutputStream fos = new FileOutputStream(kTiedosto);
        fos.write(bytes);
        fos.close();
    }
    
    public void kirjoitaTiedostoArrayList(ArrayList<Byte> bytes, String kTiedosto) throws IOException{
//        Path path = (Path) Paths.get(kTiedosto);
//        Files.write(path, bytes);
        FileOutputStream fos = new FileOutputStream(kTiedosto);
        for (byte o : bytes){
            fos.write(o);
        }
        fos.close();
    }
}

