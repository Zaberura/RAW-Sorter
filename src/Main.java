import java.io.File;
import java.io.IOException;
import java.sql.DataTruncation;

public class Main {

    final static String JPG_EXTENSION = ".jpg";
    final static String ARW_EXTENSION = ".arw";

    public static void main(String[] args) {

        String rawFolderPath = "/Users/yulliy/Desktop/RAW Folder";
        String jpgFolderPath = "/Users/yulliy/Desktop/JPG Folder";
        //String selectedFolderPath = "/Users/yulliy/Desktop/Selected Folder";
        File rawFolder = new File(rawFolderPath);
        File jpgFolder = new File(jpgFolderPath);
        //File selectedFolder = new File(selectedFolderPath);
        jpgFolder.mkdir();
        rawFolder.mkdir();
        //selectedFolder.mkdir();


        for (File i : rawFolder.listFiles()){

            if (!hasJpgEquivalent(i, jpgFolder)){

                i.delete();
            }
        }



    }

    public static boolean hasJpgEquivalent (File fileRaw, File folder){
        String fileName = fileRaw.getName();
        File[] jpgs = folder.listFiles();
        for (File i : jpgs){
            if(i.getName()
                    .substring(0, i.getName().length() - JPG_EXTENSION.length())
                    .equals(fileName.substring(0, fileName.length() - ARW_EXTENSION.length()))){
                return true;
            }
        }
        return false;
    }


}