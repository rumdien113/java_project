package Controller;

import Model.Bill;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class OutExcel {

    private BillController bC = new BillController();

    public final int COLUMN_INDEX_ID         = 0;
    public final int COLUMN_INDEX_NAME      = 1;
    public final int COLUMN_INDEX_DATE      = 2;
//    public final int COLUMN_INDEX_QUANTITY   = 3;
//    public final int COLUMN_INDEX_TOTAL      = 3;
    public final int COLUMN_INDEX_MONEY      = 3;
    private CellStyle cellStyleFormatNumber = null;

    public OutExcel() throws Exception {
        List<Bill> bills = bC.select();
        String excelFilePath = "D:\\CafeDev\\CafeDev.xlsx";
        writeExcel(bills, excelFilePath);
    }

    private void writeExcel(List<Bill> bills, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("Books"); // Create sheet with sheet name

        int rowIndex = 0;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (Bill bill : bills) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(bill, row);
            rowIndex++;
        }

        // Write footer
        writeFooter(sheet, rowIndex);

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    private void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }

    private void autosizeColumn(Sheet sheet, int numberOfColumn) {
        for (int columnIndex = 0; columnIndex < numberOfColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    private void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(COLUMN_INDEX_MONEY, CellType.FORMULA);
        cell.setCellFormula("SUM(D:D)");
    }

    private void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã HD");

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nhân viên");

        cell = row.createCell(COLUMN_INDEX_DATE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Thời gian xuất HD");

        cell = row.createCell(COLUMN_INDEX_MONEY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tổng tiền");
    }

    private CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    private Workbook getWorkbook(String excelFilePath) {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    private void writeBook(Bill bill, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(bill.getIdBill());

        cell = row.createCell(COLUMN_INDEX_NAME);
        cell.setCellValue(bill.getNamestaff());

        cell = row.createCell(COLUMN_INDEX_DATE);
        cell.setCellValue(bill.getDateBill());

        // Create cell formula
        // totalMoney = price * quantity
        cell = row.createCell(COLUMN_INDEX_MONEY);
        cell.setCellValue(bill.getTotalMoney());

//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_PRICE);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_QUANTITY);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }
}
