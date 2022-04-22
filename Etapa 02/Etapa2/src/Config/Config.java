
package Config;

//Cremaos la claso que nos permitirá hacer la conexión a la base de datos
public class Config {
    public static String getConnectionString() throws ClassNotFoundException{
        Class.forName("com.micorsoft.sqlserver.jdbc.SQLServerDriver");
        return "jdbc:sqlserver://localhost; databaseName=SUPERMERCADODB;user=sa;password=sa";
    }
    
}
