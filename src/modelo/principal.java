
package modelo;

import controlador.controlador;
import java.io.IOException;
import vista.Vista;



public class principal {
    public static void main (String[]args) throws IOException{
        agenda  ag = new agenda(10);
        Vista vi = new Vista();
        controlador co = new controlador(vi,ag);
        co.Iniciar();
        vi.setVisible(true);
        
       
        
        
    }
    
   
    
    
          
     
}
