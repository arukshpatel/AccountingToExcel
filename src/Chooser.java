

import java.io.File;

import javax.swing.JFileChooser;

public class Chooser
{
    private String[] filesInFolder;
    JFileChooser chooser = new JFileChooser();

    public String FileExplorer()
    {
        String folderPath = "";
        try
        {
        	System.out.println("Opening Chooser");
        	
            chooser.setCurrentDirectory(new java.io.File("Documents"));
            chooser.setDialogTitle("Please choose a folder containing bank statements");
//            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.showOpenDialog(null);

            chooser.setCurrentDirectory(chooser.getSelectedFile());

            folderPath = chooser.getSelectedFile().toString();
            
            System.out.println(folderPath);
            
            filesInFolder(folderPath);

        } catch (Exception e)
        {
            System.out.println("ERRORS IN CHOOSER.JAVA LINE 30");
        }

        return folderPath;

    }

    private void filesInFolder(String folderPath)
    {
        try
        {
            File directory = new File(folderPath);

            filesInFolder = directory.list();

        } catch (Exception e)
        {
            System.out.println("ERRORS IN CHOOSER.JAVA LINE 50");
        }

    }

    public String[] getFilesInFolderString()
    {
        return filesInFolder;
    }

}
