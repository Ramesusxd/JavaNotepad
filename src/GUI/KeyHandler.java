package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GUI gui;

    public KeyHandler(GUI gui) {

        this.gui = gui;


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Control + s key at the same time will do a quick overwrite save
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
            gui.file.save();
        }
        // Shift + s key will do a Save As
        if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
            gui.file.save();
        }
        // Alt + F key will open the file menu
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
            gui.menuFile.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
