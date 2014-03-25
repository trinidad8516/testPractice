package esparzat.data;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractProductsandInventory
{
	public static List<Product> prod = new ArrayList<>();

	public static List<Product> readProductFile()
	{

		File f = new File("ProductsAndInventory.txt");

		Scanner sc;

		try
		{
			sc = new Scanner(f);

			while (sc.hasNextLine())
			{
				Product p = new Product();
				String in = sc.nextLine();
				String[] fields = in.split("\t", -1);
				p.setUpc(fields[0]);
				p.setDescription(fields[1]);
				p.setPrice(new BigDecimal(fields[2]));
				p.setQuantity(Integer.valueOf(fields[3]));
				//System.out.println("Description " + fields[1]);
				//System.out.println("Price per unit: " + fields[2]);
				//System.out.println("UPC: " + fields[0]);
				//System.out.println("Quantity: " + fields[3]);
				prod.add(p);

			}

		} catch (FileNotFoundException e)
		{
			System.out.println("Could not open file.");
		}
		return prod;
	}
}