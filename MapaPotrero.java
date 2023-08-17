
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import CrearTXT.GuardarInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapaPotrero extends JFrame {
    private Object[][] matrizPotrerosDisponibles;
    private Object[][] matrizPotrerosOcupados;

    public MapaPotrero(int cantidadPotreros) {
        
        // Crear matrices para almacenar la información de los potreros disponibles y ocupados
        matrizPotrerosDisponibles = new Object[cantidadPotreros + 1][7];
        matrizPotrerosOcupados = new Object[cantidadPotreros + 1][7];

        Potrero potrero = new Potrero();
        Ganado ganado = new Ganado();
        Finca finca = new Finca();


        // Pedir la información de cada potrero al usuario y almacenarla en las matrices
        finca.setTamaño_Finca();
        int ESPACIOS = finca.getTamaño_Finca() / cantidadPotreros;
        
        for (int i = 0; i < cantidadPotreros; i++) {
            potrero.setEstado_potrero();

            if (potrero.getEstado_potrero().equals("OCUPADO")) {
                potrero.setNombre_potrero();
                potrero.setEntrada_ganado();
                potrero.setAgua();
                potrero.setTipo_terreno();
                potrero.setCantidad_animales();
                potrero.setgenerarCodigoPotrero();
                ganado.setRaza();
                finca.setCedula();

                matrizPotrerosOcupados[i + 1][0] = potrero.getNombre_potrero();
                matrizPotrerosOcupados[i + 1][1] = "OCUPADO";
                matrizPotrerosOcupados[i + 1][2] = potrero.getTipo_terreno();
                matrizPotrerosOcupados[i + 1][3] = ganado.getRaza();
                matrizPotrerosOcupados[i + 1][4] = potrero.getCantidad_animales();
                matrizPotrerosOcupados[i + 1][5] = potrero.getSalida_ganado();
                matrizPotrerosOcupados[i + 1][6] = finca.getCedula();

            } else if (potrero.getEstado_potrero().equals("LIBRE")) {
                potrero.setNombre_potrero();
                potrero.setTipo_terreno();
                potrero.setgenerarCodigoPotrero();
                finca.setTotal_Animales();

                matrizPotrerosDisponibles[i + 1][0] = potrero.getNombre_potrero();
                matrizPotrerosDisponibles[i + 1][1] = "LIBRE";
                matrizPotrerosDisponibles[i + 1][2] = ganado.getRaza();
                matrizPotrerosDisponibles[i + 1][3] = potrero.getTipo_terreno();
                matrizPotrerosDisponibles[i + 1][4] = ESPACIOS;
                matrizPotrerosDisponibles[i + 1][5] = potrero.getCodigoPotrero();
                matrizPotrerosDisponibles[i + 1][6] = potrero.getSalida_ganado();
            }
        }
        // Se agregan los títulos aquí
        matrizPotrerosDisponibles[0][0] = "NOMBRE";
        matrizPotrerosDisponibles[0][1] = "ESTADO";
        matrizPotrerosDisponibles[0][2] = "RAZA";
        matrizPotrerosDisponibles[0][3] = "TIPO";
        matrizPotrerosDisponibles[0][4] = "ESPACIOS";
        matrizPotrerosDisponibles[0][5] = "ID";
        matrizPotrerosDisponibles[0][6] = "ENTRADA";

        matrizPotrerosOcupados[0][0] = "NOMBRE";
        matrizPotrerosOcupados[0][1] = "ESTADO";
        matrizPotrerosOcupados[0][2] = "TERRENO";
        matrizPotrerosOcupados[0][3] = "TIPO";
        matrizPotrerosOcupados[0][4] = "ANIMALES";
        matrizPotrerosOcupados[0][5] = "SALIDA";
        matrizPotrerosOcupados[0][6] = "ID FINCA";

        // Crear las tablas y establecer las matrices como modelos de datos
        JTable tableDisponibles = new JTable();
        JTable tableOcupados = new JTable();

// Crear los modelos de tabla y establecerlos en las tablas
        DefaultTableModel modelDisponibles = new DefaultTableModel(matrizPotrerosDisponibles, new Object[]{"NOMBRE", "ESTADO", "TERRENO", "TIPO", "ANIMALES", "SALIDA", "ID FINCA"});
        tableDisponibles.setModel(modelDisponibles);
        tableDisponibles.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        DefaultTableModel modelOcupados = new DefaultTableModel(matrizPotrerosOcupados, new Object[]{"NOMBRE", "ESTADO", "TERRENO", "TIPO", "ANIMALES", "SALIDA", "ID FINCA"});
        tableOcupados.setModel(modelOcupados);
        tableOcupados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableOcupados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        JButton guardarDisponiblesBtn = new JButton("GUARDAR POTREROS LIBRES");
        guardarDisponiblesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPotrerosDisponibles();
            }
            private void guardarPotrerosDisponibles() {
                GuardarInfo.GuardarDisponibles(matrizPotrerosDisponibles);
            }
        });
        JButton guardarOcupadosBtn = new JButton("GUARDAR POTREROS OCUPADOS");
        guardarOcupadosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPotrerosOcupados();
            }
            private void guardarPotrerosOcupados() {
                GuardarInfo.GuardarOcupados(matrizPotrerosOcupados);
            }
        });
        // Crear el JScrollPane para cada tabla
        JScrollPane scrollPaneDisponibles = new JScrollPane(tableDisponibles);
        JScrollPane scrollPaneOcupados = new JScrollPane(tableOcupados);

        // Crear las ventanas para mostrar las tablas
        JFrame ventanaDisponibles = new JFrame("POTREROS LIBRES");
        ventanaDisponibles.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaDisponibles.getContentPane().add(scrollPaneDisponibles);
        ventanaDisponibles.pack();
        ventanaDisponibles.setLocationRelativeTo(null);

        JFrame ventanaOcupados = new JFrame("POTREROS OCUPADOS");
        ventanaOcupados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaOcupados.getContentPane().add(scrollPaneOcupados);
        ventanaOcupados.pack();
        ventanaOcupados.setLocationRelativeTo(null);

        // Mostrar las ventanas cuando se haga clic en el botón correspondiente
        JButton botonMostrarDisponibles = new JButton("MOSTRAR POTREROS LIBRES");
        botonMostrarDisponibles.addActionListener(e -> ventanaDisponibles.setVisible(true));

        JButton botonMostrarOcupados = new JButton("MOSTRAR POTREROS OCUPADOS");
        botonMostrarOcupados.addActionListener(e -> {ventanaOcupados.setVisible(true); 
        });
         
        JButton botonRealizarRotacion = new JButton("REALIZAR ROTACIÓN");
        botonRealizarRotacion.addActionListener(e -> realizarRotacion());

        // Crear el panel y agregar los botones al mismo
        JPanel panel = new JPanel();
        panel.add(botonMostrarDisponibles);panel.add(guardarOcupadosBtn);
        panel.add(botonMostrarOcupados);panel.add(guardarDisponiblesBtn);
        panel.add(botonRealizarRotacion);
        // Agregar el panel al JFrame 
        getContentPane().add(panel, BorderLayout.CENTER);

        // Definir tamaño inicial del JFrame
        setTitle("Información de Potreros");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
   
    public void realizarRotacion() {
    String nombrePotreroOcupado = JOptionPane.showInputDialog(null, "NOMBRE POTRERO OCUPADO", "ROTATION", 0);
    String nombreLibre = JOptionPane.showInputDialog(null, "NOMBRE POTRERO LIBRE", "ID", 0);
    
    int filas = matrizPotrerosOcupados.length;
    int columnas = matrizPotrerosOcupados[0].length;
    boolean encontradoOcupado = false;
    boolean encontradoLibre = false;
    
    String rotaciones = "";
    
    for (int fila = 1; fila < filas; fila++) { 
        if (nombrePotreroOcupado.equals(matrizPotrerosOcupados[fila][0])) {
            encontradoOcupado = true;
        }
        if (nombreLibre.equals(matrizPotrerosDisponibles[fila][0])) {
            encontradoLibre = true;
        }
        
        if (encontradoOcupado && encontradoLibre) {
            for (int i = 0; i < columnas; i++) {
                matrizPotrerosDisponibles[fila][i] = matrizPotrerosOcupados[fila][i];
                matrizPotrerosOcupados[fila][i] = null;
            }
            JOptionPane.showMessageDialog(null,"POTRERO ROTADO DE \n" +  nombrePotreroOcupado  + "A POTRERO DISPONIBLE"  +  nombreLibre +"\n", rotaciones, 0);
            
            break; 
        }
    }

}
}
