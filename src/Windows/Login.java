package Windows;

import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import SQLConnector.Connector;

public class Login extends JFrame {
    public Login() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        components();
    }

    private void components() {
        panels();
        labels();
        textfields();
        buttons();
    }

    /* Metodos*/
    private String[] getData(){
        String[] data = new String[textfield.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = textfield[i].getText();
        }
        return data;
    }

    private boolean validateData(){
        boolean valid = false;
        try {
            conector.isConneted();
            JOptionPane.showMessageDialog(null, "Bienvenido \n" +conector.getUsername());
            this.setVisible(false);
            valid = true;
		} catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: Probelmas al cargar Driver\n");
            System.out.println(e.getMessage());
            System.exit(0);
		} catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Usuario y Contrasena Invalidos\n");
            System.out.println(e.getMessage());
        }
        return valid;
    }

    /* Componentes */
    private void panels() {
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
            this.panel[i].setLayout(null);
        }

        /* Agregando al Panel a la ventana */
        this.getContentPane().add(panel[0]);
        this.panel[0].add(panel[1]);

        /* Personalizando Panel 2 */
        this.panel[1].setBackground(new java.awt.Color(245, 241, 241));
        this.panel[1].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.panel[1].setBounds(30, 55, 320, 130);
    }

    private void labels() {
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setFont(new java.awt.Font("Yu Gothic UI", 0, 18));
        }

        panel[0].add(label[0]);
        label[0].setText("Iniciar Sesión");
        label[0].setFont(new java.awt.Font("Yu Gothic UI", 1, 22));
        label[0].setBounds(135, 10, 200, 50);

        panel[1].add(label[1]);
        label[1].setText("Username:");
        label[1].setBounds(10, 10, 200, 50);

        panel[1].add(label[2]);
        label[2].setText("Password:");
        label[2].setBounds(10, 40, 200, 50);
    }

    private void textfields() {
        for (int i = 0; i < textfield.length; i++) {
            textfield[i] = new JTextField();
            panel[1].add(textfield[i]);
        }

        textfield[0].setBounds(98, 27, 150, 20);
        textfield[1].setBounds(98, 57, 150, 20);
    }

    private void buttons() {
        for (int i = 0; i < button.length; i++) {
            button[i] = new Button();
            panel[0].add(button[i]);
        }

        button[0].setTitle("cancel");
        button[0].setLocation(180, 200);

        button[1].setTitle("login");
        button[1].setLocation(290, 200);

        ActionListener pressCancel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        };
        button[0].addActionListener(pressCancel);

        ActionListener pressLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = getData();
                conector.setCredentials(data[0], data[1]);
                if(validateData()){
                    form.setVisible(true);
                    form.setUsername(data[0]);
                    form.setPassword(data[1]);
                }
            }
        };
        button[1].addActionListener(pressLogin);
    }

    private JPanel[] panel = new JPanel[2];
    private JLabel[] label = new JLabel[3];
    private JTextField[] textfield = new JTextField[2];
    private Button[] button = new Button[2];

    private Form form = new Form();
    private Connector conector = new Connector();
    private static final long serialVersionUID = 1L;
}
