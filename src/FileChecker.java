
import java.io.File;

public class FileChecker
{
    private String exactFilePath;
    private String extractedText = "";
    Graphics failure = new Graphics();

    public boolean PDFdoesExists()
    {
        File fd = new File(exactFilePath);
        if ((fd).exists() && exactFilePath.contains(".pdf"))
        {
            return true;
        }

        return false;
    }

    public void check()
    {
        PDFManager parsePDF = new PDFManager();

        if (PDFdoesExists() == true)
        {
            parsePDF.setFilePath(exactFilePath);
            try
            {
                extractedText = parsePDF.toText();
                new pdfParser(extractedText);
                
            } catch (Exception e)
            {

                failure.txtrPathFailure.setText("Can't retrieve text from PDF");

            }

        }
    }

    public void setFilePath(String exactFilePath)
    {
        this.exactFilePath = exactFilePath;
    }

    public String parsedText()
    {
        return extractedText;
    }

}
