package SQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectDB {
    
    private InitialContext ctx;
    private DataSource ds;
    private Connection con;

    public ConnectDB() {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/MSSQLDS");
            con = ds.getConnection();
            System.out.println("Conectado!!");
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
