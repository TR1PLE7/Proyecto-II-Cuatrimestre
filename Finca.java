
import javax.swing.JOptionPane;

public class Finca {
    private int CLave_Admin = 010101;

    private String Nombre_Finca = "";
    private String Ubicacion = "";
    private String Nombre_Encargado= "";

    private int Cedula = 0;
    private int Telefono = 0;
    private int Tamaño_Finca = 0;
    private int Total_Animales = 0;
    
    public void getMostrarRegistros() {
        int intentosRestantes = 5;

        while (intentosRestantes > 0) {
            String Admin = JOptionPane.showInputDialog(null, "DIGITE SU USUARIO PARA VER LOS REGISTROS:", "DATA CONFIDENCIAL", JOptionPane.INFORMATION_MESSAGE);
            int CLave = Integer.parseInt(JOptionPane.showInputDialog("DIGITE SU CLAVE: "));

            if (Admin.equals("ELRICHMC") && CLave== CLave_Admin) { 
                JOptionPane.showMessageDialog(null, "ACCESO CONFIRMADO");
                break; 
            } else {
                intentosRestantes = intentosRestantes-1;
                JOptionPane.showMessageDialog(null, "TRY AGAIN: " + intentosRestantes);

                if (intentosRestantes == 0) {
                    JOptionPane.showMessageDialog(null, "INTENTOS PERMITIDOS AGOTADOS");
                }
            }
        }
    }    
    public void setCedula(){
        Cedula= Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE SU CEDULA:", "CEDULA",0));
        
    }
    public int getCedula(){
        return this.Cedula;
    }
    public void setNombre_Finca(){
        Nombre_Finca=JOptionPane.showInputDialog(null, "NOMBRE DE LA FINCA:","FINCA",0);
    }
    public String getNombre_Finca(){
        return this.Nombre_Finca;
    }
    public void setNombre_Encargado(){
        Nombre_Encargado=JOptionPane.showInputDialog(null, "NOMBRE ENCARGADO:","ENCARGADO",0);
       
    }
    public String getNombre_Encargado(){
        return this.Nombre_Encargado;
    }
    public void setTelefono(){
        Telefono=Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE SU TELEFONO:","TELEFONO",0));
        
    }
    public int Telefono(){
        return this.Telefono;
    }
    
    public void setUbucacion(){
        Ubicacion=JOptionPane.showInputDialog(null, "UBICACION DEL LUGAR:","UBICACION",0);
       
    }
    public String getUbicacion(){
        return this.Ubicacion;
    }
    public void setTamaño_Finca(){
        Tamaño_Finca = Integer.parseInt(JOptionPane.showInputDialog(null, "TAMAÑO DE LA FINCA:", "TAMAÑO", 0));
        
    }
    public int getTamaño_Finca(){
        return this.Tamaño_Finca;
    }
    public void setTotal_Animales(){
        Total_Animales = Integer.parseInt(JOptionPane.showInputDialog(null, "TOTAL ANIMALES QUE SE PUEDEN TENER:", "TAMAÑO", 0));
        
    }
    public int getTotal_Animales(){
        return this.Total_Animales;
    }

}