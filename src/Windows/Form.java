package Windows;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Form extends JFrame{
    private JPanel[] panel = new JPanel[2];
    private JLabel[] label = new JLabel[6];
    private JTextField[] textField = new JTextField[4];
    private Button[] button = new Button[4];

    public Form(){
        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        components();
    }

    private void components(){
        panels();
        labels();
        textfields();
        buttons();
    }

     /*Components*/
    private void panels(){
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            this.panel[i].setLayout(null);
        }

        /*Agregando al Panel a la ventana*/
        this.getContentPane().add(panel[0]);
        this.panel[0].add(panel[1]);

        /*Personalizando Panel 2*/
        this.panel[1].setBackground(new java.awt.Color(245,241,241));
        this.panel[1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.panel[1].setBounds(30, 80, 400, 300);
    }

    private void labels(){
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setFont(new java.awt.Font("Yu Gothic UI", 0, 18));
        }

        label[0].setText("Ingreso de Datos");
        label[0].setBounds(150, 10, 200, 50);
        label[0].setFont(new java.awt.Font("Yu Gothic UI", 0, 22));
        panel[0].add(label[0]);

        label[1].setText("Nombre: ");
        label[1].setBounds(10, 10, 200, 50);
        panel[1].add(label[1]);

        label[2].setText("Apellido: ");
        label[2].setBounds(10, 50, 200, 50);
        panel[1].add(label[2]);

        label[3].setText("Edad: ");
        label[3].setBounds(10, 90, 200, 50);
        panel[1].add(label[3]);

        label[4].setText("Telefono: ");
        label[4].setBounds(10, 130, 200, 50);
        panel[1].add(label[4]);

        label[5].setText("Grupo 7");
        label[5].setBounds(480, 400, 200, 50);
        panel[0].add(label[5]);
    }

    private void textfields(){
        for (int i = 0; i < textField.length; i++) {
            textField[i] = new JTextField();
            panel[1].add(textField[i]);            
        }

        textField[0].setBounds(90, 30, 250, 20);
        textField[1].setBounds(90, 67, 250, 20);
        textField[2].setBounds(90, 104, 250, 20);
        textField[3].setBounds(90, 150, 150, 20);

    }

    private void buttons(){
        for (int i = 0; i < button.length; i++) {
            button[i] = new Button();
            panel[0].add(button[i]);
        }

        button[0].setTitle("Nuevo");
        button[0].setColor(2);
        button[0].setLocation(480, 80);

        button[1].setTitle("Guardar");
        button[1].setColor(1);
        button[1].setLocation(480, 130);

        button[2].setTitle("Cancelar");
        button[2].setColor(3);
        button[2].setLocation(480, 180);

        button[3].setTitle("Salir");
        button[3].setColor(4);
        button[3].setLocation(480, 300);
    }

    private static final long serialVersionUID = 8270121826700971578L;    
}
