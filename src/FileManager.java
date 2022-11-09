import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileManager {
    public static List<BufferedImage> BufferedImageList = new ArrayList<>();
    List<String> fileNames = new ArrayList<>();

    public boolean checkExtension(String name) {
        if (name.endsWith("png") || name.endsWith("jpg")) {
            return true;
        } else {
            return false;
        }
    }
    public List<String> getListOfFiles(Path path) {
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path pathx : directoryStream) {
                if (checkExtension(pathx.toString()))
                fileNames.add(pathx.toString());
            }
        } catch (IOException ex) {
        }
        System.out.println(fileNames.size());
        return fileNames;
    }

    public void createFile(Path path) {
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileManager() {
        boolean doesExist = Files.exists(Main.filePath);
        if (!doesExist) {
                createFile(Main.filePath);
                getListOfFiles(Main.filePath);
            }
        else {
            if (Files.isDirectory(Main.filePath)) getListOfFiles(Main.filePath);
        }
        BufferedImage img = null;
         for(int x = 0; x != fileNames.size(); x++) {
             try {
                 img = ImageIO.read(new File(fileNames.get(x)));
             } catch (IOException e) {
                 e.printStackTrace();
             }
             BufferedImageList.add(img);
        }
    }
}
