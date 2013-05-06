package sirp.Entidades;
public interface Persona {
    // devuelve el identificador de la persona
    public int getId();  
    // inserta la persona en la base de datos
    public void insert();
    // devuelve el nombre de la persona
    public String getNombre();
    // devuelve el apellido de la persona
    public String getApellido();
    // devuelve el C.I. de la persona
    public String getCI();
    // devuelve la direccion de la persona
    public String getDireccion();
    // devuelve el numero telefonico de la persona
    public String getTelf();    
    // Convierte el objeto en cadena
    public String toString();
    
}
