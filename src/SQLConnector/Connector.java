package SQLConnector;
import java.sql.*;

public class Connector {
    private final String URL;
    private String username;
    private String password;
    private Connection con = null;

    public void isConneted() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        setCon((Connection) DriverManager.getConnection(URL, username, password));
    }

    /* Getters and Setters */
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setCredentials(final String username, final String password) {
        setUsername(username);
        setPassword(password);
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

    /*Constructors*/
    public Connector(final String username, final String password) {
        setUsername(username);
        setPassword(password);
        this.URL = "jdbc:sqlserver://localhost;databaseName=Personas";
    }

    public Connector() {
        this.URL = "jdbc:sqlserver://localhost;databaseName=Personas";
    }
}
