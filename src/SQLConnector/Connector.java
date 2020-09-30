package SQLConnector;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connector {
    private InitialContext ctx;
    private DataSource ds;
    private Connection con;

    public boolean isConneted() {
        boolean band = false;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/MSSQLDS");
            con = ds.getConnection();
            band = true;
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return band;
    }

}
