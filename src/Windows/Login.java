package Windows;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame {
    private JPanel[] panel = new JPanel[2];
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
        
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            this.panel[i].setLayout(null);
        }

        /*Agregando al Panel a la ventana*/
        this.getContentPane().add(panel[0]);
        this.panel[0].add(panel[1]);

        this.panel[1].setBackground(new java.awt.Color(245,241,241));
        this.panel[1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.panel[1].setBounds(30, 55, 320, 130);
    }

    private void labels(){
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
        }

        panel[0].add(label[0]);
        label[0].setText("Iniciar Sesión");
        label[0].setBounds(150, 10, 200, 50);

        panel[1].add(label[1]);
        label[1].setText("Username:");
        label[1].setBounds(10, 10, 200, 50);

        panel[1].add(label[2]);
        label[2].setText("Password:");
        label[2].setBounds(10, 40, 200, 50);
    }

    private void textfields(){
        for (int i = 0; i < textfield.length; i++) {
            textfield[i] = new JTextField();
            panel[1].add(textfield[i]);            
        }

        textfield[0].setBounds(75, 25, 200, 20);
        textfield[1].setBounds(75, 55, 200, 20);
    }

    private void buttons(){
        for (int i = 0; i < button.length; i++) {
            button[i] = new Buttons();
            panel[0].add(button[i]);            
        }
        
        button[0].setTitle("cancel");
        button[0].setLocation(180, 200);

        button[1].setTitle("login");
        button[1].setLocation(300, 200);
    }

    private static final long serialVersionUID = 1L;
}
