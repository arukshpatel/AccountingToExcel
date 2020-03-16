
import java.io.File;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFManager
{
    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc;
    private COSDocument cosDoc;

    private String Text;
    private String filePath;
    private File file;

    public String toText()
    {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        file = new File(filePath);
        try
        {

            parser = new PDFParser(new RandomAccessFile(file, "r"));

            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdDoc.getNumberOfPages();
            pdfStripper.setStartPage(0);
            pdfStripper.setEndPage(pdDoc.getNumberOfPages());
            Text = pdfStripper.getText(pdDoc);
            pdDoc.close();
            cosDoc.close();
        } catch (Exception e)
        {
            System.out.println("ERROR IN PDFManager.java try and catch block");

        }
        return Text;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public PDDocument getPdDoc()
    {
        return pdDoc;
    }
}
