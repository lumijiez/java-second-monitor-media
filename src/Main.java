import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<FrameManager> frames = new ArrayList<>();
    public static Path filePath = Paths.get(System.getProperty("user.home") + "/Desktop/");
    public static void main(String[] args) {
        int xSize = 1280;
        int ySize = 720;

      new FileManager();
        List<JLabel> labels = new ArrayList<>();
        List<JPanel> panels = new ArrayList<>();
        List<JButton> buttons = new ArrayList<>();


      for (int x = 0; x < FileManager.BufferedImageList.size();x++){
          Image dimg = FileManager.BufferedImageList.get(x).getScaledInstance(100, 70, Image.SCALE_SMOOTH);
          ImageIcon imageIcon = new ImageIcon(dimg);
          JLabel temp = new JLabel(imageIcon);
          labels.add(temp);
        }

      for (int x = 0; x < FileManager.BufferedImageList.size();x++){
          ButtonManager button = new ButtonManager(FileManager.BufferedImageList.get(x));
          button.setPreferredSize(new Dimension(100,25));
          buttons.add(button);
      }

      for (int x =0; x < FileManager.BufferedImageList.size(); x++){
          JPanel panel = new JPanel();
          panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
          panel.add(labels.get(x));
          panel.setBounds(x*100,100,100,70);
          panel.add(buttons.get(x));
          panel.setBorder(BorderFactory.createEtchedBorder(1, Color.blue, Color.GREEN));
          panels.add(panel);
      }
        FrameManager frame = new FrameManager(xSize, ySize, panels);
    }
}