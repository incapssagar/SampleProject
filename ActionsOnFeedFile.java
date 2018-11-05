package Actions;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;

public class ActionsOnFeedFile {
	
/*Name: Finding required column location in Feed File
 *Parameters:
 *Arguments: driver, FeedFilesheet, KPIMappingSheet,colRef, currentHeader, firstValue, MappingKPISeq
 *@Author: Sagar Kumar 
 */
	
public static int FindingColInFeedFile(WebDriver driver, XSSFSheet FeedFilesheet, XSSFSheet KPIMappingSheet, String colRef, String currentHeader, int firstValue, int MappingKPISeq)
	{
		//Matching_Col for matching KPI in feed file
		int Matching_Col=2,Matching_Col_Period=4;

		Boolean Col_Flag=true;
		while(Col_Flag)
		{
			colRef=FeedFilesheet.getRow(0).getCell(Matching_Col).toString().trim();

			if((colRef.contains(KPIMappingSheet.getRow(firstValue+MappingKPISeq).getCell(1).getStringCellValue())) && (colRef.contains(currentHeader))) 
			{
				Col_Flag=false;
			}
			else
			{
				Matching_Col++;
			}
		}
		return Matching_Col;
	}

}
