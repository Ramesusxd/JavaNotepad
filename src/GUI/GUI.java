package GUI;

import javax.swing.*;


public class GUI {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;

    public static void main(String[] args) {

        new GUI();

    }
    public GUI() {

        createWindow();
        createTextArea();

        window.setVisible(true);

    }

    public void createWindow() {

        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea() {

        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }
}