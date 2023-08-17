
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Ganado {
    private String Tipo_Ganado = "";
    private String Nombre = "";
    private String Sexo = "";
    private String Raza= "";
    private String Fecha_Nacimiento = "";

    private int ID_Ganado = 0;
    private int Peso = 0;
     
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String fechaActual = dateFormat.format(new Date());

    public void setTipo_Ganado(){
        Tipo_Ganado = JOptionPane.showInputDialog(null, "-VACUNO \n -BOVINO \n -OVINO", "TIPO GANADO",0);
        
    }
    public String getTipo_Ganado(){
        return this.Tipo_Ganado; 
    }
    public void setID_Ganado(){
        Random random = new Random();
        ID_Ganado = random.nextInt(100000);
        JOptionPane.showMessageDialog(null, "EL CODIGO DEL POTRERO ES:" + ID_Ganado,"CODIGO",0);
        
    }
    public int getID_Ganado(){
        return this.ID_Ganado;
    }
    public void setNombre(){
        Nombre=JOptionPane.showInputDialog(null, "NOMBRE DEL ANIMAL \n-","NOMBRE",0);
        
    }
    public String getNombre(){
        return this.Nombre;
    }
    public void setFecha_Nacimiento(){
        String Fecha_Nacimiento = JOptionPane.showInputDialog(null, "FECHA DE NACIMIENTO DEL GANADO " + "LA FECHA ACTUAL ES: " + fechaActual, 0);
        String[] componentes = Fecha_Nacimiento.split("/");

        if (componentes.length == 3) {
            try {
                int dia = Integer.parseInt(componentes[0]);
                int mes = Integer.parseInt(componentes[1]);
                int año = Integer.parseInt(componentes[2]);

                dia += 5;
                while (dia > 31) {
                    dia -= 31;
                    mes += 1;
                    if (mes > 12) {
                        mes = 1;
                        año += 1;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: La fecha ingresada no es valida.", "Error", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "LA FECHA SE DIGITO EN MAL FORMATO", "ERROR", 0);
        }
    }
    public String getFecha_Nacimiento(){
        return this.Fecha_Nacimiento;
    }
    public void setPeso(){
        Peso=Integer.parseInt(JOptionPane.showInputDialog(null, "PESO REGISTRADO","PESO",0));
       
    }
    public int Peso(){
        return this.Peso;
    }
    public void setSexo(){
        Sexo=JOptionPane.showInputDialog(null, "SEXO DEL EJEMPLAR:","SEXO",0);
       
    }
    public String getSexo(){
        return this.Sexo;
    }
    public void setRaza(){
        Raza=JOptionPane.showInputDialog(null, "RAZA DEL EJEMPLAR","RAZA",0);
        
    }
    public String getRaza(){
        return this.Raza;
    }
}
    
    
    

