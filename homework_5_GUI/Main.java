package homework_5_GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI form = new GUI();
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setTitle("面向对象程序设计实践(java)");

        form.pack();
        form.setVisible(true);
    }
}
