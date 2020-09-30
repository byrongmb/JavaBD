/**
 * <h1>Clase Conector<h1>
 * Clase de ejemplo para realizar conexiones con SQL Server a traves de JDBC
 * <p>
 * La clase cuenta metodos para verificar conexion, guardar datas y obtener, 
 * datos de una Base de datos en SQL Server
 * 
 * @author byrongamboa
 * @version 3.2
 * @since 20-09-2020
 */
package SQLConnector;
import java.sql.*;

public class Connector {
    private final String URL;
    private String username;
    private String password;
    private String table;
    private String database;

    private Connection con = null;

    /**
    * Este metodo, realiza la conexion a la Base de datos
    * @exception ClassNotFoundException cuando hay problemas en el driver
    * @exception SQLException cuando hay problemas a iniciar sesion
    * 
    * @see ClassNotFoundException
    * @see SQLException
    */
    public void isConneted() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        setCon((Connection) DriverManager.getConnection(URL, username, password));
    }

    /**
    * Este metodo, guarada los datos a la base de datos
    * @exception SQLException cuando hay problemas en la sesion
    * @param data Recibe un arreglo de String con los datos colocados
    * @return Retorna 0 cuando hubo problemas a guardar y 1 cuando se guardo correctamente
    * 
    * @see SQLException
    */
    public int saveData(String[] data) throws SQLException {
        int band = 0;
        String query = "insert into "+ table +"(Nombre, Apellido, Edad, Telefono) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, data[0]);
        ps.setString(2, data[1]);
        ps.setString(3, data[2]);
        ps.setString(4, data[3]);
        band = ps.executeUpdate();
        return band;
    }

    /**
    * Este metodo, devuelve los datos guardados en una base de datos
    * @exception SQLException cuando hay problemas en la sesion
    * @return Retorna un tipo de dato {@code ResultSet}
    * 
    * @see SQLException
    * @see ResultSet
    */
    public ResultSet getData() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM datos");
        return rs;
    }

    public void setCredentials(final String username, final String password) {
        setUsername(username);
        setPassword(password);
    }

    /* Getters and Setters */
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    /*Constructors*/
    public Connector(final String username, final String password) {
        setUsername(username);
        setPassword(password);
        setDatabase("Personas");
        setTable("datos");
        this.URL = "jdbc:sqlserver://localhost;databaseName=" + database;
    }

    public Connector() {
        this.URL = "jdbc:sqlserver://localhost;databaseName=" + database;
        setDatabase("Personas");
        setTable("datos");
    }

    public Connector(String username, String password, String table, String database) {
        this.username = username;
        this.password = password;
        this.table = table;
        this.database = database;
        this.URL = "jdbc:sqlserver://localhost;databaseName=" + database;
    }
}
