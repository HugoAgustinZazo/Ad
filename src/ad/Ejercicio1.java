package ad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
    int opcion = 999;
    Scanner teclado = new Scanner(System.in);
    while (opcion != 0) {
        System.out.println("Dime que opción prefieres:\n-Escribir con Buffer\n-Escribir con Files");

        opcion= teclado.nextInt();

        switch(opcion){
            case 1:
                escribirBuffer();
            break;
            case 2:
                escribirNio();
            break;

            case 0:
                break;
        }


    }





    }
    public static void escribirBuffer(){
        Random longlinea = new Random();
        Random sacarpalabras = new Random();
        long time = System.currentTimeMillis();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime cuantas lineas quieres en el fichero");
        int lineas = teclado.nextInt();

        System.out.println("Ahora dime el nombre del fichero:");
        String ficheroname = teclado.next();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroname + ".txt"))) {
            for (int z = 0; z < lineas; z++) {
                int longlin = longlinea.nextInt(5, 9);
                String[] fichero = new String[longlin];
                for (int i = 0; i < longlin; i++) {
                    int pos = sacarpalabras.nextInt(PALABRAS.length);

                    fichero[i] = PALABRAS[pos];
                }
                String linea = "";

                for (int j = 0; j < fichero.length; j++) {

                    linea = linea + fichero[j] + " ";
                }
                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Tiempo de ejecución: " + time);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void escribirNio() throws IOException {
        Random longlinea = new Random();
        Random sacarpalabras = new Random();
        long time = System.currentTimeMillis();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Dime cuantas lineas quieres en el fichero");
        int lineas = teclado.nextInt();

        System.out.println("Ahora dime el nombre del fichero:");
        String ficheroname = teclado.next();

        for (int z = 0; z < lineas; z++) {
            int longlin = longlinea.nextInt(5, 9);
            String[] fichero = new String[longlin];
            for (int i = 0; i < longlin; i++) {
                int pos = sacarpalabras.nextInt(PALABRAS.length);

                fichero[i] = PALABRAS[pos];
            }
            String linea = "";

            for (int j = 0; j < fichero.length; j++) {

                linea = linea + fichero[j] + " ";
            }
            Path ruta = Paths.get("src/ad/"+ficheroname+".txt");
            try {
                Files.write(ruta, linea.getBytes(), StandardOpenOption.APPEND);
                Files.write(ruta, "\n".getBytes(), StandardOpenOption.APPEND);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Tiempo de ejecución: " + time);
    }
    private static final String[] PALABRAS = {"programación", "java", "código", "algoritmo", "optimización", "rendimiento", "aplicación", "sistema", "memoria", "variable", "función", "clase", "objeto", "método", "compilación", "interfaz", "herencia", "polimorfismo", "encapsulamiento", "sobrecarga"};
}