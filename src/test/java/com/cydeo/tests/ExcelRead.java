package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

        //to read from excel file, we need to load it to FileInput stream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook>sheet>row>cell

        //1 Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2 We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3 Select row and cell
        //print out Mary's cell
        //indexes start from 0

        System.out.println(sheet.getRow(1).getCell(0));

        //print out Developer
        System.out.println(sheet.getRow(3).getCell(2));

        //Return the count of used cells only
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Return the number from top cell to bottom cell
        //it does not care if the cell is empty or not
        //it starts counting from 0

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        System.out.println("-------------------------------------------------------------");

        //TODO: Create a logic to print Vinod's name

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){

                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }
        
        //TODO Create a logic to print Linda's Job_ID
        // If name is Linda ---> print Job_ID

        for (int rowNum = 0; rowNum < usedRows ; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){

                System.out.println("Linda's Job_ID: "+ sheet.getRow(rowNum).getCell(2));
            }
            
        }
        //TODO Create a logic to print Mary's LastName

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")){

                System.out.println(sheet.getRow(rowNum).getCell(1));
            }

        }
        System.out.println("-------------------------------------------------------------");

        



    }
}
