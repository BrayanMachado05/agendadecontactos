
package modelo;


public class contacto {

    String nombre;
    private long telefono;
    private String idContacto;
    

    public contacto() {
        this.nombre = "";
        this.telefono = 0;
        this.idContacto="";
    }

    public contacto(String nombre) {
        
    }

    public contacto(String nombre, String telefono) {
        
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    
public String datos(){
    return nombre + ";" + telefono;
}    
    
    
    

    
 public boolean equals(contacto contacto){
        if(nombre.trim().equalsIgnoreCase(contacto.getNombre().trim())){
              return true;
        }
        return false;
    }

    int size() {
       
        return 0;
       
    }

  

    
    
}
