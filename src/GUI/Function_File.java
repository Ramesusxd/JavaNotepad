package GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName;
    String fileAddress;

    public Function_File(GUI gui) {
//  code makes reference to the GUI.java for functions
        this.gui = gui;
    }

    public void newFile() {
//  code clears whats in the textArea for a new page
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
    }
    public void open() {

        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
//  code allows you to open files
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress =fd.getDirectory();
            gui.window.setTitle(fileName);

        }
        System.out.println("File address and file name " + fileAddress + fileName);

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+ fileName));
            // address is needed to read or load a file
            gui.textArea.setText("");

            String line = null;

            while((line = br.readLine())!=null) {
                gui.textArea.append(line + "\n");
            }
            br.close();

        } catch(Exception e) {
            System.out.println("FILE NOT OPENED");
// warning if there was a error with opening the file
        }
    }
    public void save() {
// code is the method to save files in a overwrite fashion
        if(fileName==null) {
            saveAs();
        }
        else {
            try { // address is needed to save file
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();

            } catch (Exception e) {
                System.out.println("SOMETHING IS WRONG FILE DID NOT SAVE");
            }
        }

    }
    public void saveAs() {

        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
// code to hard save file
        if(fd.getFile()!=null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch(Exception e) {

            System.out.println("SOMETHING WENT WRONG FILE DID NOT SAVE");
        }
    }

    public void exit() {
//  closes the program
        System.exit(0);
    }

}