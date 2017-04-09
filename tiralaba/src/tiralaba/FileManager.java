
package tiralaba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.scene.shape.Path;

public class FileManager {
    public byte[] lueTiedosto(String lTiedosto) throws IOException{
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
    
    public void kirjoitaTiedostoIntegers(int bytes, String kTiedosto) throws IOException{
//        Path path = (Path) Paths.get(kTiedosto);
//        Files.write(path, bytes);
        FileOutputStream fos = new FileOutputStream(kTiedosto);
        fos.write(bytes);
        fos.close();
    }
}

