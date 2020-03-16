

import java.util.ArrayList;

public class pdfParser
{
    private String[] lines;
    private ArrayList<String> merchants;
    private ArrayList<String> depositMerchantAmount;
    private final String[] MONTHS = new String[] { "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" };

    private void parseDate()
    {
        int counter = 0;

        for (int i = 0; i < lines.length; i++)
        {

            for (int i2 = 0; i2 < MONTHS.length; i2++)
            {

                if (lines[i].contains(MONTHS[i2]))
                {
                    counter++;
                    for (int i1 = 2000; i1 < 3000; i1++)
                    {
                        if (lines[i].contains("" + i1))
                        {
                            break;
                        }
                    }

                    break;
                }
            }

            if (counter == 1)
            {
                break;
            }
        }

        parseDepositBalance();
    }

    protected void parseDepositBalance()
    {
        depositMerchantAmount = new ArrayList<>();
        merchants = new ArrayList<>();

        for (int i = 0; i < lines.length; i++)
        {
            if (lines[i].contains("DES:"))
            {
                String[] parsedLine = lines[i].split("\\s++");

                for (int j = 0; j < parsedLine.length; j++)
                {
                    if (j == 1)
                    {
                        merchants.add((parsedLine[j = 1] + " " + parsedLine[j = 2]));
                    }

                }
            }
        }

        for (int i = 0; i < lines.length; i++)
        {
            for (int j = 0; j < merchants.size(); i++)
            {
                if (lines[i].contains(merchants.get(j)))
                {
                    String temp = lines[i + 3];
                    depositMerchantAmount.add(temp);
                    System.out.println(temp);
                }
            }
        }

    }

    public pdfParser(String extractedText)
    {

        lines = extractedText.split("\n");

        parseDate();

    }
}
