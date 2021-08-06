package UI;

import Backend.Analizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private final int WIDTH = 550;
    private final int HEIGHT = 350;
    public MainFrame(){
       initComponents();
    }

    private void initComponents(){
        Dimension dim = new Dimension(this.WIDTH, this.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ingrese una cadena");
        setSize(dim);
        setPreferredSize(dim);
        setLocationRelativeTo(null);
        //ContentPane
        JPanel panel = new JPanel();
        //TextArea
        JTextArea textSpace = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textSpace);
        //Button
        JButton button = new JButton("Analizar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textSpace.getText();
                Analizer analizer = new Analizer();
                String response = analizer.analize(text);
                textSpace.setText(response);
                //Analizar texto
            }
        });


        panel.add(scrollPane);
        panel.add(button);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainF = new MainFrame();
    }
}
