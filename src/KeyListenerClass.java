import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListenerClass extends JFrame implements java.awt.event.KeyListener {
    ButtonManager button;
    public KeyListenerClass(ButtonManager button) {
        this.button = button;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            for (FrameManager x : Main.frames)
                x.dispose();
            ButtonManager.isSecondWindowCreated = true;
                button.setText("Deschide");

        }
    }
}
