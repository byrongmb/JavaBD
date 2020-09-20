package SQLConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final String URL;
    private String username;
    private String password;

    public boolean isConneted() {
        boolean band = false;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager.getConnection(URL, username, password);
            band = true;
        } catch (final ClassNotFoundException e) {
            System.out.println("Error!! ClassNotFoundException: " + e.getMessage());
        } catch (final SQLException e) {
            System.out.println("Error!! SQLException: " + e.getMessage());
        }
        return band;
    }

    /* Getters and Setters */
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Connector(final String username, final String password) {
        setUsername(username);
        setPassword(password);
        this.URL = "jdbc:sqlserver://localhost;databaseName=Personas";
    }
}
