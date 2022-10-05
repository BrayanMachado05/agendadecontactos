
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    ag.AñadirArchivo();
   
  }
 

        
 
public void mostrarArchivo() throws IOException{
   vi.txt_Visualizar.setText(ag.estraer("AgendaContactos.txt"));
}

public  void borrarLinea() throws IOException {
      
        File inputFile = new File("AgendaContactos.txt");
        File tempFile = new File("AgendaContactostemp.txt");
        BufferedReader leer = new BufferedReader(new FileReader(inputFile));
        BufferedWriter escribir = new BufferedWriter(new FileWriter(tempFile));
        int lineaeliminar;
        lineaeliminar = Integer.parseInt(vi.txt_EliminarLinea.getText());
        String listaactual;
        int contar = 0; 
        while ((listaactual = leer.readLine()) != null) {
            contar++;
            if (contar == lineaeliminar) {
                continue;
            }
            escribir.write(listaactual + System.getProperty("line.separator"));
        }
        escribir.close();
        leer.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
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
            
          mostrarArchivo();  
        }
        else if(e.getSource()== vi.btn_EliminarReArchivo){
         borrarLinea();
        }
        
        
        
        
}   catch (IOException ex) {
            ex.printStackTrace();
    }

}
}