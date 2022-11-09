import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FrameManager extends JFrame {
    public FrameManager(int x, int y, List<JPanel> panels)  {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.ipady = 100;
        c.weightx = 0;
        c.gridwidth = panels.size()-1;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.PAGE_START;
        JLabel text = new JLabel();
        text.setText("Deschideti una din imaginile de mai jos");
        text.setFont(new Font("SansSerif", Font.BOLD, 30));
        this.add(text, c);
        c.ipady = 0;
        c.weightx = 0.5;
        c.weighty = 0.0;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0,0,0,0);
        c.gridx = 0;
        c.gridy = 1;
        for (int nr = 0; nr < panels.size(); nr++) {
            c.gridx = nr;
            this.add(panels.get(nr), c);
        }
        this.setResizable(false);
        this.setSize(x,y);
        this.setVisible(true);
        this.setTitle("SecondScreenDisplay - Author: Daniel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public FrameManager(JLabel label, KeyListenerClass key) {
        this.addKeyListener(key);
        label.setSize(JFrame.MAXIMIZED_BOTH,JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());
        this.add(label);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setVisible(true);
        this.setTitle("SecondScreenDisplay - Author: Daniel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
