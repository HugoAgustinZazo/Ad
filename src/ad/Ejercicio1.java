package ad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

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
    public static void escribirNio(){
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

        }
        System.out.println("Tiempo de ejecución: " + time);
    }
    private static final String[] PALABRAS = {"programación", "java", "código", "algoritmo", "optimización", "rendimiento", "aplicación", "sistema", "memoria", "variable", "función", "clase", "objeto", "método", "compilación", "interfaz", "herencia", "polimorfismo", "encapsulamiento", "sobrecarga"};
}