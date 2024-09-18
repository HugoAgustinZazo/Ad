package ad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bufer {
    public static void main(String[] args){
       try(BufferedWriter escritor = new BufferedWriter(new FileWriter("fichero.txt"))){

         for(int cont = 0; cont <15; cont++) {
             escritor.write("paco" + cont);
             escritor.newLine();
         }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
