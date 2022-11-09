import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class ButtonManager extends JButton implements ActionListener {
    static boolean isSecondWindowCreated = true;
    FrameManager temp;
    JLabel tempLabel;
    public ButtonManager(BufferedImage img) {
        double height = img.getHeight();
        double width = img.getWidth();
        double ratio = width/height;
        if (width >= height) {
            height = 1080;
            width = 1080*ratio;
        } else {
            width = 1920;
            height =1920*ratio;
        }
        Image dimg = img.getScaledInstance((int) width, (int) height, Image.SCALE_REPLICATE);
        this.tempLabel = new JLabel(new ImageIcon(dimg));
        this.setText("Deschide");
        this.setBounds(0, 300, 100, 100);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            if (isSecondWindowCreated) {
                temp = new FrameManager(tempLabel, new KeyListenerClass(this));
                Main.frames.add(temp);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] gd = ge.getScreenDevices();
                System.out.println(gd.length);
                if( 0 > -1 && 0 < gd.length ) {
                    temp.setLocation(gd[0].getDefaultConfiguration().getBounds().x, temp.getY());
                } else if( gd.length > 0 ) {
                    temp.setLocation(gd[1].getDefaultConfiguration().getBounds().x, temp.getY());
                } else {
                    throw new RuntimeException( "No Screens Found" );
                }
                this.setText("Inchide");
                isSecondWindowCreated = false;
            } else {
                temp.dispose();
                isSecondWindowCreated = true;
                this.setText("Deschide");
            }
        }
    }
}

