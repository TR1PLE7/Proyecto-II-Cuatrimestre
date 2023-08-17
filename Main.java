import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int cantidadPotreros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de potreros:"));
        SwingUtilities.invokeLater(() -> new MapaPotrero(cantidadPotreros));

    }
}
