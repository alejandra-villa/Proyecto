
package vitaseguros;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VitaSeguros {

    
    public static void main(String[] args) {
        
        String usuario = "root";
        String contraseña = "adso00";
        String url = "jdbc:mysql://localhost:3306/vitaseguros";
        Connection conexion;
        Statement statement;
        ResultSet resultado;
        
                          
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VitaSeguros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            statement = conexion.createStatement();
            //statement.executeUpdate("insert into Afiliado (Id_Afiliado, identificación, nombre, edad, direccion, telefono, correo, beneficiarios) values (11, '09-9364764', 'Cosette Dullingham', 49, 'Apt 1008', '(184) 3627481', 'cboord0@webmd.com', 4)");
            //statement.executeUpdate("delete from Afiliado where Id_Afiliado = 11");
            statement.executeUpdate("update Afiliado set telefono ='(456) 6621422' WHERE Id_Afiliado= 8;");
            resultado = statement.executeQuery("select * from Afiliado");
            resultado.next();
           
            
            do {
                System.out.println(resultado.getInt("Id_Afiliado")+" : "+resultado.getString("telefono"));
            }
            while(resultado.next());
            
                              
        } catch (SQLException ex) {
            Logger.getLogger(VitaSeguros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
