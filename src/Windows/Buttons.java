package Windows;
import java.awt.Color;

import javax.swing.JButton;

public class Buttons extends JButton {
    private int color;

    public Buttons(String title, int color) {
        this.setText(title);
        this.color = color;
        this.setSize(80, 30);
        colorSelector();
    }

    public Buttons(String title) {
        this.setText(title);
        setColor(1);
        this.setSize(80, 30);
        colorSelector();
    }

    public Buttons() {
        setColor(2);
        this.setSize(80, 30);
        colorSelector();
    }

    public void colorSelector(){
        this.setForeground(Color.WHITE);
        switch (color) {
            case 1:
            this.setBackground(new java.awt.Color(93,188,210));
            //celeste
                break;
            case 2:
            this.setBackground(new java.awt.Color(100,96,95));
            //plomo
                break;
            case 3:
            this.setBackground(new java.awt.Color(48,29,113));
            //morado
                break;
            case 4:
            this.setBackground(new java.awt.Color(128,9,38));
            //rojo
                break;
            default:
            this.setBackground(new java.awt.Color(100,96,95));
                break;
        }
    }

    /*Getters and Setters*/
    public String getTitle() {
        return this.getText();
    }

    public void setTitle(String title) {
        this.setText(title);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private static final long serialVersionUID = 1L;
}
