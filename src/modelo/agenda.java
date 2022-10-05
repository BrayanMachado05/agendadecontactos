
package modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class agenda extends contacto{
   
    private contacto  contactos [];
    File Archivo;
    private String name;
    FileWriter fileW;
   
    
    public agenda(int tam) {
        this.contactos = new contacto[tam];
        this.name = "";
        
       
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public contacto getContacto(int pos ) {
        return contactos[pos] ;
    }

    public void setContacto(contacto contacto,int pos) {
        this.contactos[pos] = contacto;
    }

    public contacto [] getContacto() {
        return this.contactos;
    }
   
    

    public String agregarContactos(){
        String msj = "";
       
        for(int a = 0;a < get_lengt(); a++){
               if(getContacto(a) != null){
                   msj +="Nombre : "+ getContacto(a).getNombre()+ "\n";
                   msj += "Telefono : "+ getContacto(a).getTelefono()+ "\n"+ "\n";
                  
               } 
               
        }
        return msj;
        
    }
    
    public String creararchivo(String name) {
        setName(name);
        String msj = "";
        this.Archivo = new File(getName());
        if (!this.Archivo.exists()) {
            try {
                this.Archivo.createNewFile();
               System.out.println("archivo creado");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("el archivo ya existe");
        }
        return msj;

    }
   
    
     public int get_lengt(){
        return this.contactos.length;
    }
    
    public int HuecosLibres(){
         int contador = 0;
         for(int a = 0;a < get_lengt(); a++){
             if(getContacto(a) == null){
                 contador ++;
             }
         }
         return contador;
    }
    
    public boolean AgendaLlena(){
        for(int a = 0;a < get_lengt(); a++){
            if(getContacto(a) == null){
                return false;
            }
        }
        return true;
    }
    
   public void buscarContacto(String nombre){
        boolean encontrarcontacto = false;
        for(int a = 0;a < get_lengt() && !encontrarcontacto; a++){
            if(getContacto(a) != null && getContacto(a).getNombre().trim().equalsIgnoreCase(nombre.trim())){
                  JOptionPane.showMessageDialog(null,"SE ENCONTRO EL CONTACTO SU TELEFONO ES : " + getContacto(a).getTelefono());
                  encontrarcontacto = true;
            }
        }
        
        if(!encontrarcontacto){
            JOptionPane.showMessageDialog(null,"NO SE HA ENCONTRADO EL TELEFONO");
        }
    }
   
    public boolean ExisteContacto(String nombre){
        boolean existecontacto = false;
        for(int a = 0;a < get_lengt() && !existecontacto; a++){
            if(getContacto(a) != null && getContacto(a).getNombre().trim().equalsIgnoreCase(nombre.trim())){
                 JOptionPane.showMessageDialog(null,"EL CONTACTO EXISTE , POS FAVOR DIJITE OTRO");
                 existecontacto = true;
            }
        }
        if(!existecontacto){
            JOptionPane.showMessageDialog(null,"EL CONTACTO NO EXISTE");
        }
        return false;
    
    }
    
    public String EliminarContacto(String nombre){
        String msj="";
        for(int a = 0;a < get_lengt(); a++){
            if(getContacto(a)!=null){
                if(this.contactos[a].getNombre().equals(nombre)){
                setContacto(null,a);
                msj="contacto eliminado";
                break;
                }
            }
                
       }return msj;
    }
    
    public void buscarRegistro(String nombre){
    String contacto=nombre;
        try
        {
            BufferedReader leer=new BufferedReader(new FileReader ("AgendaContactos.txt"));
            
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf(contacto)!=-1)
                {
                    System.out.println("se encontro el registro: "+linea);
                    
                   
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
 
    
 public String  estraer(String Archivo) throws IOException { 
        String otra="";
	String cadena;
	FileReader f = new FileReader(Archivo); 
	BufferedReader b = new BufferedReader(f); 
        
	while((cadena = b.readLine())!=null) { 
           
            otra += cadena+"\n";
		
	} 

	b.close(); 
        return otra;
        
    }
    
    
    public void AñadirArchivo() throws IOException {
    String msj= "";
    try{
        fileW= new FileWriter("AgendaContactos.txt",true);
        for(int a = 0;a < get_lengt(); a++){
            if(getContacto(a)!=null){
                fileW.write("");
                fileW.write(String.valueOf(getContacto(a).getNombre()));
                fileW.write(",");
                fileW.write(String.valueOf(getContacto(a).getTelefono()));
                fileW.write("\n");
                
            }else{
                fileW.close();
            }
    }
    }catch(IOException e){
        
    }
        
}
    
    

    
    
    private Object contacto(int a) {
        
        return null;
        
    }

    

    

   

    

    
    

    

    
}
