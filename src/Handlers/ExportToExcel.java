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
	private String tabClassesOutcome = "exported-" + (new Date()).toString();
	private String tabCarrots = "Carrots";
	private String tabSortDet = "Sort_Details";
	private String tabGrowerDet = "Grower_and_plot";
	private Sorts value;


	public ExportToExcel(Sorts toOutput , String fileName){
		this.value = toOutput;
		this.fileName = fileName + ".xls";
	}




	public void exportData() throws FileNotFoundException, IOException
	{
		//Create new workbook and tab
		Workbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream(fileName);
		Sheet growerPlotSheet = wb.createSheet(tabGrowerDet); // grower + plot details + start date + end date + comments
		fillGrowerSheet(growerPlotSheet);
		Sheet sortDetSheet = wb.createSheet(tabSortDet);
		fillSortDetSheet(sortDetSheet);
		//Sheet classSheet = wb.createSheet(tabClassesOutcome);
		//fillClassesSheet(classSheet);
		
		//Sheet carrotsSheet = wb.createSheet(tabCarrots);
		//fillCarrotsSheet(carrotsSheet);


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









	private void fillCarrotsSheet(Sheet carrotsSheet) {
		// TODO Auto-generated method stub

	}




	private void fillClassesSheet(Sheet classSheet) {
		// TODO Auto-generated method stub

	}

	private void fillSortDetSheet(Sheet sheet) {

		//Create 2D Cell Array
		Row[] row = new Row[value.convertClassDetToMat().length];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < row.length; i ++)
		{
			row[i] = sheet.createRow(i);
			cell[i] = new Cell[value.convertClassDetToMat()[i].length];

			for(int j = 0; j < cell[i].length; j ++)
			{
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(value.convertClassDetToMat()[i][j]);
			}
		}
	}
	


	private void fillGrowerSheet(Sheet sheet) {



		//Create 2D Cell Array
		Row[] row = new Row[value.getGrower().convertToMat().length + value.getPlot().convertToMat().length + 3 ];
		Cell[][] cell = new Cell[row.length][];


		//Define and Assign Cell Data from Given
		for(int i = 0; i < value.getGrower().convertToMat().length; i ++){

			row[i] = sheet.createRow(i);
			cell[i] = new Cell[value.getGrower().convertToMat()[i].length];

			for(int j = 0; j < cell[i].length; j ++){
				cell[i][j] = row[i].createCell(j);
				cell[i][j].setCellValue(value.getGrower().convertToMat()[i][j].toString());
			}

		}

		int plot=0;
		for(int i = value.getGrower().convertToMat().length; i < row.length-3  ; i++){

			row[i] = sheet.createRow(i);
			cell[i] = new Cell[value.getPlot().convertToMat()[plot].length];

			for(int k = 0; k < cell[i].length; k++){
				cell[i][k] = row[i].createCell(k);
				cell[i][k].setCellValue(value.getPlot().convertToMat()[plot][k]);
			}
			plot++;
		}


		// start - end - comments 
		int i = value.getGrower().convertToMat().length + value.getPlot().convertToMat().length;
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
