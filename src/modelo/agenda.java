
package modelo;




import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
   
    public void agregarArchivo(String arreglo) throws IOException {
        byte[] byteArr = arreglo.getBytes();
        Files.write(Paths.get(getName()), byteArr, StandardOpenOption.APPEND);
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
    
//    public void AñadirArchivo(int pos) throws IOException {
//    String msj= "";
//    try{
//        fileW= new FileWriter(Archivo,true);
//        for(int a = 0;a < get_lengt(); a++){
//            if(getContacto(a)!=null){
//                fileW.write(String.valueOf(getContacto(a).getNombre()));
//                fileW.write(",");
//                fileW.write(String.valueOf(getContacto(a).getTelefono()));
//                fileW.write("\n");
//                
//            }else{
//                fileW.close();
//            }
//    }
//    }catch(IOException e){
//        
//    }
//}

    



    //ioe.printStackTrace();
    public void eliminarregistroarchivo(String filepath , int deleteLine){
       
       String tempFile ="temp.doc";
       File oldFile = new File(filepath);
       File newFile = new File(tempFile);
       
       String currentLine;
       int line=0;
       
       try{
           
           FileWriter fw = new FileWriter(tempFile,true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           
           FileReader fr = new FileReader(filepath);
           BufferedReader br = new BufferedReader(fr);
           
           while((currentLine = br.readLine())!=null){
              line++;
              if(deleteLine !=line){
                  pw.println(currentLine);
              }
           }
           
           pw.flush();
           pw.close();
           fr.close();
           br.close();
           bw.close();
           fw.close();
           
           oldFile.delete();
           File dump =new File(filepath);
           newFile.renameTo(dump);
           
       }catch(Exception ex){
           System.out.println(ex);
       }
    }
 

    




    
  
        
    public String elimi(String arrego){
        String msj = "";
        
        return msj;
    }

    
    
    
    
    
    
    
    
    private Object contacto(int a) {
        
        return null;
        
    }

    

    

   

    

    
    

    

    
}
