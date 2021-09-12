package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.InfrastructureDepartment;

public class Main {
	public int EXIT_OPTION = 5;
	private InfrastructureDepartment iD;
	private Scanner sc;
	
	public Main() throws ClassNotFoundException, IOException{
		sc = new Scanner(System.in);
		iD = new InfrastructureDepartment();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Main objMain = new Main();
		objMain.menu();
	}
	
	public void menu() throws IOException {
		boolean menu = true;
		importBds();
		
		while(menu){
			System.out.println("\nSelect an option:"+
								"\n1. Add Billboard"+
								"\n2. Show Billboards"+
								"\n3. Dangerous report"+
								"\n4. Exit\n"
								);
			int option = sc.nextInt();
			sc.nextLine();
			
			switch(option){
				case 1: option1();
				break;

				case 2: showBillboards();
				break;
				
				case 3: dangerousReport();
				break;
				
				case 4: System.out.println("\n¡Bye!");
						menu=false;
				break;
				
				default:
					System.out.println("\nInvalid option\n");
					break;
			}
		}
	}
	
	public  void importBds() throws IOException {
		iD.importData("data/BillboardDataExported.csv");
	}
	
	public void option1() throws FileNotFoundException, IOException {
		System.out.println("\nPlease type the parameters separated by '++'. Example: width++height++inUse++brand");
		String typed = sc.nextLine();
		String typedSplit[] = typed.split("\\++");
		double w = Double.parseDouble(typedSplit[0]);
		double h = Double.parseDouble(typedSplit[1]);
		boolean iU = Boolean.parseBoolean(typedSplit[2]);
		
		iD.addBillboard(w,h,iU,typedSplit[3]);
	}

	public void showBillboards() {
		System.out.println(iD.toString());
	}
	
	public void dangerousReport() throws IOException {
		System.out.println(iD.exportDangerousBillboardReport("data/report.txt"));
	}
	
}
