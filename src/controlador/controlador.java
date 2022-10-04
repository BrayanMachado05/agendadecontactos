
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.agenda;
import modelo.contacto;
import vista.Vista;


public class controlador implements ActionListener{
public Vista vi;
private agenda ag;
private int pos;





public controlador(Vista vi, agenda ag) {
        this.vi = vi;
        this.ag = ag;
        this.pos = 0;
       

        this.vi.btn_GuardarContacto.addActionListener(this);
        this.vi.btn_VisualizarContactos.addActionListener(this);
        this.vi.btn_HuecosLibres.addActionListener(this);
        this.vi.btn_VerificarAgenda.addActionListener(this);
        this.vi.btn_ExisteContacto.addActionListener(this);
        this.vi.btn_BuscarContacto.addActionListener(this);
        this.vi.btn_EliminarContacto.addActionListener(this);
        this.vi.btn_GuardarArchivo.addActionListener(this);
        this.vi.btn_LeerArchivo.addActionListener(this);
        this.vi.btn_EliminarReArchivo.addActionListener(this);
        
    }

    public void Iniciar() {
        vi.setTitle("AGENDA DE CONTACTOS");
        vi.setLocationRelativeTo(null);
    }
    
    
    
    
    public String GuardarContactos(){
         contacto tem = new contacto();
         tem.setNombre(vi.txt_Nombre.getText());
         tem.setTelefono(Long.parseLong(vi.txt_telefono.getText()));
         System.out.println(ag.creararchivo("AgendaContactos.txt"));
         if (ag.get_lengt()> this.pos){
              JOptionPane.showMessageDialog(null, "CONTACTO SE INGRESO CORRECTAMENTE");
              ag.setContacto(tem, pos);
              pos++;    
         }else{
             JOptionPane.showMessageDialog(null, "LA AGENDA ESTA LLENA, NO SE PUEDEN AGREGAR MAS CONTACTOS");
         }
    return null;
   
    }
     
    
    
    
    public void verContactos(){       
             vi.txt_Visualizar.setText(ag.agregarContactos());   
    }
       
    public void HuecosLibres(){
          JOptionPane.showMessageDialog(null,"HAY   " + ag.HuecosLibres() + "   CONTACTOS DISPONIBLES PARA INGRESAR");
    }
    
    public void AgendaEstaLlena(){
        if(ag.AgendaLlena()){
        JOptionPane.showMessageDialog(null,"LA AGENDA ESTA LLENA");
        }else{
        JOptionPane.showMessageDialog(null,"AUN PUEDES REGISTRAR CONTACTOS");
        }
                
                      
    }
    
    
    public void BuscarContacto(String nombre){        
        
        nombre = vi.txt_Nombre.getText();
                      
        ag.buscarContacto(nombre);
       
    
    }
    
  public void ExisteContacto(String nombre){
      
      nombre = vi.txt_Nombre.getText();
                      
      ag.ExisteContacto(nombre);
     
  }
    
  public void EliminarContacto(){
  
      JOptionPane.showMessageDialog(null,ag.EliminarContacto(vi.txt_Nombre.getText()));
      
  }
    
 public void mostrar() throws IOException{
    ag.agregarArchivo(ag.agregarContactos());
   
  }
 
 

     
    
// public void buscarregistro() throws IOException{
//        vi.txt_Nombre.getText();
//        ag.eliminarregistroarchivo();
//    }
//     
     
     
public void leerArchivo(){     
String codigo = new String(), path = "AgendaContactos.txt";
File archivo = new File(path);
FileReader fr = null;
BufferedReader entrada = null;
try {
fr = new FileReader(path);
entrada = new BufferedReader(fr);
while(entrada.ready()){
codigo += entrada.readLine()+"\n";
}
}catch(IOException e) {
e.printStackTrace();
}finally{
try{                    
if(null != fr){   
fr.close();     
}                  
}catch (Exception e2){ 
e2.printStackTrace();
}
}
vi.txt_Visualizar.setText(codigo);
}
        
 
public void eliminarregistroarchivo(String filepath , int deleteLine){
   vi.txt_Nombre.getText();
   ag.eliminarregistroarchivo(filepath , deleteLine);
}

 
   

            

      
  
@Override    
public void actionPerformed(ActionEvent e) {
    try {
        if (e.getSource()== vi.btn_GuardarContacto){
         GuardarContactos();
        }
        else if(e.getSource()== vi.btn_VerificarAgenda){
          AgendaEstaLlena();
        }
        else if (e.getSource()== vi.btn_VisualizarContactos){
        verContactos();
        }
        else if (e.getSource()== vi.btn_HuecosLibres){
        HuecosLibres();    
        }
        else if (e.getSource()== vi.btn_BuscarContacto){
        String nombre = null;
        BuscarContacto(nombre);     
        }
        else if (e.getSource()== vi.btn_EliminarContacto){
        
        EliminarContacto();    
        }
        else if(e.getSource()== vi.btn_ExisteContacto){
        String nombre = null;
        ExisteContacto(nombre);     
        }
        else if(e.getSource()== vi.btn_GuardarArchivo){
            
            mostrar();
            
        }else if(e.getSource()== vi.btn_LeerArchivo){
          leerArchivo();  
        }
        else if(e.getSource()== vi.btn_EliminarReArchivo){
         String filepath=null;
         int deleteLine = 0;
         eliminarregistroarchivo(filepath , deleteLine);
         
        }
        
        
        
        
}   catch (IOException ex) {
            ex.printStackTrace();
    }

}
}