import java.util.Scanner;
import SQLConnector.Connector;
/*username: admin, password: p@ss1234*/
public class App {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        System.out.println("Ingrese las credenciales");

        System.out.print("Username: ");
        String username = teclado.nextLine();

        System.out.print("Password: ");
        String password = teclado.nextLine();

        Connector com = new Connector(username, password);
        System.out.println("Estado de la Conexion: " + com.isConneted());
    }
}
