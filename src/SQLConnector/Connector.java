package SQLConnector;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connector {
    private Connection con;
    private DataSource ds = null;
    private Context ctx = null;

    public boolean isConneted() {
        
        boolean band = false;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/MSSQLDS");
            con = ds.getConnection();
            con.commit();
            band = true;
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return band;
    }

}
