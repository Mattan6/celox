package Handlers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Classes.Sorts;

public class ExportToExcel {


	private String fileName ="";
	private String tabCarrots = "Carrots";
	private String tabSortDet = "Sort_Details";
	private String tabGrowerDet = "Grower_and_plot";
	private Sorts value;
	private String tabClassesOutcome = "exported-" + (new Date()).toString().replace(":", "-");
	private Workbook wb;


	public ExportToExcel(Sorts toOutput , String fileName){
		this.value = toOutput;
		this.fileName = fileName + ".xls";
	}




	public void exportData() throws FileNotFoundException, IOException
	{
		//Create new workbook and tab
		wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream(fileName);
		Sheet growerPlotSheet = wb.createSheet(tabGrowerDet); // grower + plot details + start date + end date + comments
		fillGrowerSheet(growerPlotSheet);
		Sheet sortDetSheet = wb.createSheet(tabSortDet); // user sort details 
		fillSortDetSheet(sortDetSheet);
		Sheet carrotsSheet = wb.createSheet(tabCarrots); // carrots details 
		fillCarrotsSheet(carrotsSheet);
		Sheet classSheet = wb.createSheet(tabClassesOutcome); 
		fillClassesSheet(classSheet);


		/*
		//Create 2D Cell Array
		Row[] row = new Row[data.length];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < row.length; i ++)
		{
			row[i] = sortDetSheet.createRow(i);
			cell[i] = new Cell[data[i].length];

			for(int j = 0; j < cell[i].length; j ++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(data[i][j]);
			}

		}*/

		//Export Data
		wb.write(fileOut);
		fileOut.close();

	}









	private void fillCarrotsSheet(Sheet sheet) {
		
		String[][] arrCar = value.convertCarrotsToMat();
		//Create 2D Cell Array
		Row[] row = new Row[arrCar.length];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < row.length; i ++)
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[arrCar[i].length];

			for(int j = 0; j < cell[i].length; j ++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(arrCar[i][j]);
			}
		}

	}




	private void fillClassesSheet(Sheet sheet) {
		
		String[][] arrOut = value.convertClassOutToMat();
		//Create 2D Cell Array
		Row[] row = new Row[arrOut.length];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < row.length; i ++)
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[arrOut[i].length];

			for(int j = 0; j < cell[i].length; j ++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(arrOut[i][j]);
			}
		}

	}

	private void fillSortDetSheet(Sheet sheet) {

		String[][] arrSort = value.convertClassDetToMat();
		//Create 2D Cell Array
		Row[] row = new Row[arrSort.length];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < row.length; i ++)
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[arrSort[i].length];

			for(int j = 0; j < cell[i].length; j ++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(arrSort[i][j]);
			}
		}
	}
	


	private void fillGrowerSheet(Sheet sheet) {

		String[][] arrGrower = value.getGrower().convertToMat();
		String[][] arrPlot = value.getPlot().convertToMat();

		//Create 2D Cell Array
		Row[] row = new Row[value.getGrower().convertToMat().length + arrPlot.length + 3 ];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < arrGrower.length; i ++){

			row[i] = sheet.createRow(i);
			cell[i] = new Cell[arrGrower[i].length];

			for(int j = 0; j < cell[i].length; j ++){
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(arrGrower[i][j].toString());
			}

		}

		int plot=0;
		for(int i = arrGrower.length; i < row.length-3  ; i++){

			row[i] = sheet.createRow(i);
			cell[i] = new Cell[arrPlot[plot].length];

			for(int k = 0; k < cell[i].length; k++){
				cell[i][k] = row[i].createCell(k);
				cell[i][k].setCellValue(arrPlot[plot][k]);
			}
			plot++;
		}


		// start - end - comments 
		int i = arrGrower.length + arrPlot.length;
		row[i] = sheet.createRow(i);

		cell[i] = new Cell[2];
		cell[i][0] = row[i].createCell(0);
		cell[i][0].setCellValue("Date - Start sort");
		cell[i][1] = row[i].createCell(1);
		cell[i++][1].setCellValue(value.getStartData());

		row[i] = sheet.createRow(i);
		cell[i] = new Cell[2];
		cell[i][0] = row[i].createCell(0);
		cell[i][0].setCellValue("Date - End sort");
		cell[i][1] = row[i].createCell(1);
		cell[i++][1].setCellValue(value.getEndDate());

		row[i] = sheet.createRow(i);
		cell[i] = new Cell[2];
		cell[i][0] = row[i].createCell(0);
		cell[i][0].setCellValue("Comments");
		cell[i][1] = row[i].createCell(1);
		cell[i++][1].setCellValue(value.getComments());
	}
}
