package CrearTXT;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarInfo {
    public static void GuardarOcupados(Object[][] matrizPotrerosOcupados) {
    String ArchivoOcupados = "potreros_ocupados.txt";
    try {
        BufferedWriter salida = new BufferedWriter(new FileWriter(ArchivoOcupados, true)); // Usar 'true' para permitir la adición al archivo

        salida.write("########################\n");
        for (int i = 0; i < matrizPotrerosOcupados.length; i++) {
            for (int j = 0; j < matrizPotrerosOcupados[i].length; j++) {
                salida.write(matrizPotrerosOcupados[i][j] + " ");
            }
            salida.write("\n");
        }
        salida.write("#######################\n");
        salida.close();

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

public static void GuardarDisponibles(Object[][] matrizPotrerosDisponibles) {
    String ArchivoLibres = "potreros_libres.txt";
    try {
        BufferedWriter salida = new BufferedWriter(new FileWriter(ArchivoLibres, true)); // Usar 'true' para permitir la adición al archivo

        salida.write("#########################\n");
        for (int i = 0; i < matrizPotrerosDisponibles.length; i++) {
            for (int j = 0; j < matrizPotrerosDisponibles[i].length; j++) {
                salida.write(matrizPotrerosDisponibles[i][j] + " ");
            }
            salida.write("\n");
        }
        salida.write("###########################\n");
        salida.close();
        
    } catch (IOException ex) {
        ex.printStackTrace();
    
        }
    }     
}
   