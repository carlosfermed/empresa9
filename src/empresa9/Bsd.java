
package empresa9;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bsd {
    
    protected int codigo;
    protected String nombre;
    protected int localizacion;
    protected int manager;

    public Bsd() {
    }

    public Bsd(int codigo, String nombre, int localizacion, int manager) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.manager = manager;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(int localizacion) {
        this.localizacion = localizacion;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }   
    
    public int modificacion(int codigo, String nombre, int localizacion, int manager){
        int n=0;
        try {            
            Class.forName("com.mysql.jdbc.Driver"); // Cargar Driver
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
            Statement sentencia=conexion.createStatement();
            String sql = "update departamentos set NOMBRE='" + nombre + "', IDLOCALIZACION='" + localizacion + "', IDMANAGER='" +manager+ "' where CODIGO=" + codigo + ";";        
            n = sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close ();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;        
    }    
    
    public int altas (){
        int n=0;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
            Statement sentencia=conexion.createStatement();
            
            String sql = "insert into departamentos values ('" +this.codigo + "', '"+nombre +"', '"+this.localizacion+"', '"+manager+"');";
            
            n = sentencia.executeUpdate(sql);
            
            sentencia.close();
            conexion.close ();            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;        
    }
    
    public int bajas (int codigo){
        int n=0;
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
            Statement sentencia=conexion.createStatement();
            
            String sql = "delete from departamentos where CODIGO=" +codigo + ";";
            
            n = sentencia.executeUpdate(sql);
            
            sentencia.close();
            conexion.close ();            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;        
    }    
    
    public String listado (){
        String linea="";
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/43540246g","root","");
            Statement sentencia=conexion.createStatement();            
            
            ResultSet resultado = sentencia.executeQuery("select * from departamentos");
            
            while (resultado.next()){
                linea = linea + resultado.getInt(1) + " *** " + resultado.getString(2) + " *** " + resultado.getString(3) + " *** " + resultado.getString(4) +"\n";
            }
            
            sentencia.close();
            conexion.close ();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bsd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;    
    }    
}
