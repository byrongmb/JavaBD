package SQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectDB {
    private Connection con;

    public ConnectDB() {
        try {
            javax.naming.Context ctx = new javax.naming.InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/MSSQLDS");
            con = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
