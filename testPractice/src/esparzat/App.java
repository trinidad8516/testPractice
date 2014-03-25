package esparzat;

import esparzat.data.ExtractEmployees;
import esparzat.data.ExtractProductsandInventory;
import esparzat.display.AddRemoveEmployeesDisplay;
import esparzat.display.InitialSalesDisplay;
import esparzat.display.LoginDisplay;
import esparzat.display.ProductAndInventoryDisplay;

/**
 * This class contains only the main method that calls the methods that will
 * fire off the application.
 */
public class App {

	public static void main(String[] args) {
		//AddRemoveEmployeesDisplay.doesFileExist();
	//	ExtractEmployees.readEmployeeFile();
	//	ProductAndInventoryDisplay.doesFileExist();
	//	ExtractProductsandInventory.readProductFile();
		LoginDisplay.username();
		InitialSalesDisplay.initialDisplay();
	}
}