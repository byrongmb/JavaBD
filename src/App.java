import java.util.Scanner;
import SQLConnector.Connector;
/*username: admin, password: p@ss1234*/
public class App {
    public static void main(String[] args) throws Exception {
        Connector com = new Connector();
        System.out.println("Estado de la Conexion: " + com.isConneted());
    }
}
