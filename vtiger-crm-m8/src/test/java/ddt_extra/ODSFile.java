package ddt_extra;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;

import java.io.File;

public class ODSFile {
    public static void main(String[] args) {
        try {
            // 1. Load the ODS file
            // Make sure the path is correct for your Mac/Windows environment
            File file = new File("C:\\Users\\User\\OneDrive\\Desktop\\one.ods");
            SpreadsheetDocument document = SpreadsheetDocument.loadDocument(file);

            // 2. Get the sheet by name (Look at the tab at the bottom of your LibreOffice)
            // In your screenshot, the name is "Sheet1"
            Table sheet = document.getTableByName("Sheet1");

            if (sheet != null) {
                // 3. Get specific cells
                // Simple ODF uses (ColumnIndex, RowIndex) starting from 0
                Cell cellA1 = sheet.getCellByPosition(0, 0); // A1
                Cell cellA2 = sheet.getCellByPosition(0, 1); // A2

                // 4. Extract and print the text
                String value1 = cellA1.getDisplayText();
                String value2 = cellA2.getDisplayText();

                System.out.println("Data at A1: " + value1); // Should print "hey"
                System.out.println("Data at A2: " + value2); // Should print "there"
            } else {
                System.out.println("Sheet not found!");
            }

            // 5. Always close the document to free up memory
            document.close();

        } catch (Exception e) {
            System.err.println("Error reading ODS file:");
            e.printStackTrace();
        }
    }
}