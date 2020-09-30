package SQLConnector;
import java.sql.*;

public class Connector {
    private final String URL;
    private String username;
    private String password;
    private String table;
    private String database;

    private Connection con = null;

    public void isConneted() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        setCon((Connection) DriverManager.getConnection(URL, username, password));
    }

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
