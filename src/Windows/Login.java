package Windows;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel[] label = new JLabel[3];
    private JTextField[] textfield = new JTextField[2];
    private Buttons[] button = new Buttons[2];

    public Login() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        components();
    }

    private void components() {
        initializePanel();
        labels();
        textfields();
        buttons();
    }


    /*Components*/
    private void initializePanel(){
        this.getContentPane().add(panel);
        this.panel.setLayout(null);
    }

    private void labels(){
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            panel.add(label[i]);
        }

        label[0].setText("Iniciar Sesión");
        label[0].setBounds(150, 10, 200, 50);

        label[1].setText("Username:");
        label[1].setBounds(50, 70, 200, 50);

        label[2].setText("Password:");
        label[2].setBounds(50, 100, 200, 50);
    }

    private void textfields(){
        for (int i = 0; i < textfield.length; i++) {
            textfield[i] = new JTextField();
            panel.add(textfield[i]);            
        }

        textfield[0].setBounds(120, 85, 200, 20);
        textfield[1].setBounds(120, 115, 200, 20);
    }

    private void buttons(){
        for (int i = 0; i < button.length; i++) {
            button[i] = new Buttons();
            panel.add(button[i]);            
        }
        
        button[0].setTitle("cancel");
        button[0].setLocation(180, 200);

        button[1].setTitle("login");
        button[1].setLocation(300, 200);
    }

    private static final long serialVersionUID = 1L;
}
