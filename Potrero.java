
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;



public class Potrero {
    private String Agua = "";
    private String Tipo_terreno = "";
    private String Nombre_potrero = "";
    private String Estado_potrero = "";
    
    private int Codigo_potrero = 0;
    private String Salida_ganado = "";
    private int Cantidad_animales = 0;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String fechaActual = dateFormat.format(new Date());

    // Método para generar el código de potrero automáticamente
    void setgenerarCodigoPotrero() {
        Random random = new Random();
        Codigo_potrero = random.nextInt(100000);
        JOptionPane.showMessageDialog(null, "EL CODIGO DEL POTRERO ES:" + Codigo_potrero, "CODIGO", 0);
    }
    
    public int getCodigoPotrero(){
        return this.Codigo_potrero;
    }
    
    public void setEntrada_ganado() {
        String entrada_ganado = JOptionPane.showInputDialog(null, "DIGITE CUANDO ENTRARO EL GANADO: " + "LA FECHA ACTUAL ES: " + fechaActual, 0);
        String[] componentes = entrada_ganado.split("/");

        if (componentes.length == 3) {
            try {
                int dia = Integer.parseInt(componentes[0]);
                int mes = Integer.parseInt(componentes[1]);
                int ano = Integer.parseInt(componentes[2]);

                dia += 5;
                while (dia > 31) {
                    dia -= 31;
                    mes += 1;
                    if (mes > 12) {
                        mes = 1;ano += 1;
                    }
                }

                Salida_ganado = dia + "/" + mes + "/" + ano;
                ActivarAlarma(); // Llamamos a la función que activa la alarma después de 5 días
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: La fecha ingresada no es valida.", "Error", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA FECHA SE DIGITO EN MAL FORMATO", "ERROR", 0);
        }
    }
    
    public void ActivarAlarma() {
        
        int tiempo = 432000; // 5 dias a milisegundos
    
        // Crear un Timer que muestra la alerta después del tiempo especificado
        Timer alertTimer = new Timer(tiempo * 1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAlerta();
            }
        });
    
        alertTimer.setRepeats(false);
        alertTimer.start();
    }

    public void mostrarAlerta() {
        Object[] options = {"DETENER", "ROTAR GANADO"};
        JOptionPane.showOptionDialog(null,"!TIEMPO ESTIMADO ACABADO!","ALERTA",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[0]);
    }
    
    public void setNombre_potrero(){
        Nombre_potrero= JOptionPane.showInputDialog(null, "NOMBRE POTRERO: ", "NOMBRE DEL LUGAR", 0);
        
    }
    public String getNombre_potrero(){
        return this.Nombre_potrero;
    }
    public void setEstado_potrero(){
        Estado_potrero= JOptionPane.showInputDialog(null, "OCUPADO \nLIBRE \nDESCANSO ", "ESTADO", 0);
        Estado_potrero = Estado_potrero.toUpperCase();
        
    }
    public String getEstado_potrero(){
        return this.Estado_potrero;
    }
    public void setAgua(){
        Agua=JOptionPane.showInputDialog(null, "POSEE AGUA?: ", "AGUA DISPONIBLE?", 0);
        
    }
    public String getAgua(){
        return this.Agua;
    }
    public String getSalida_ganado(){
        return this.Salida_ganado;
    }
    public void setCantidad_animales(){
        Cantidad_animales= Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE CUANTOS ANIMALES TIENE: ", "CANTIDAD ANIMALES", 0));
        
    }
    public int getCantidad_animales(){
        return this.Cantidad_animales;
    }
    public void setTipo_terreno(){
        Tipo_terreno = JOptionPane.showInputDialog(null, "EL TIPO DE TERRENO: ", "TERRENO", 0);
        
    }
    public String getTipo_terreno(){
        return this.Tipo_terreno;
    }
}   

