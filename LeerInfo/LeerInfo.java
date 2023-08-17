package LeerInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class LeerInfo {
    String archivoOcupados = "potreros_ocupados.txt";
    String archivoLibres = "potreros_libres.txt";

    public Object[][] LeerTXTOcupados(String ArchivoOcupados) {
        
        try {
            BufferedReader leer = new BufferedReader(new FileReader(ArchivoOcupados));
            String linea;
            StringBuilder texto = new StringBuilder();

            while ((linea = leer.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            leer.close();

            String[] lineas = texto.toString().split("\n");
            Object[][] matriz = new Object[lineas.length][];

            for (int i = 0; i < lineas.length; i++) {
                String[] valores = lineas[i].split(" ");
                matriz[i] = new Object[valores.length];

                for (int j = 0; j < valores.length; j++) {
                    matriz[i][j] = valores[j];
                }
            }

            return matriz;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LEER EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Object[][] LeerTXTLibres(String ArchivoLibres) {
        try {
            BufferedReader leer = new BufferedReader(new FileReader(ArchivoLibres));
            String linea;
            StringBuilder texto = new StringBuilder();

            while ((linea = leer.readLine()) != null) {
                texto.append(linea).append("\n");
            }
            leer.close();

            String[] lineas = texto.toString().split("\n");
            Object[][] matriz = new Object[lineas.length][];

            for (int i = 0; i < lineas.length; i++) {
                String[] valores = lineas[i].split(" ");
                matriz[i] = new Object[valores.length];

                for (int j = 0; j < valores.length; j++) {
                    matriz[i][j] = valores[j];
                }
            }
            return matriz;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL LEER EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}