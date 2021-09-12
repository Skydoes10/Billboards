package ui;

import java.io.IOException;
import java.util.Scanner;
import model.InfrastructureDepartment;

public class Main {
	public int EXIT_OPTION = 5;
	public static InfrastructureDepartment iD;
	static Scanner sn = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		boolean menu = true;
		iD.importData("data/BillboardDataExported.csv");
		
		while(menu){
			System.out.println("\nSelect an option:"+
								"\n1. Add Billboard"+
								"\n2. Show Billboards"+
								"\n3. Export dangerous report"+
								"\n4. Exit\n"
								);
			int option = sn.nextInt();
			sn.nextLine();
			
			switch(option){
				case 1: option1();
				break;

				case 2: System.out.println("");
				break;
				
				case 3: System.out.println("");
				break;
				
				case 4: System.out.println("¡Bye!");
						menu=false;
				break;
				
				default:
					System.out.println("\nInvalid option\n");
					break;
			}
		}
	}
	
	public static void option1() {
		System.out.println("\nPlease type the parameters separated by '++'. Example: width++height++inUse++brand");
		String typed = sn.nextLine();
		String typedSplit[] = typed.split("\\++");
		double w = Double.parseDouble(typedSplit[0]);
		double h = Double.parseDouble(typedSplit[1]);
		boolean iU = Boolean.parseBoolean(typedSplit[2]);
		
		iD.addBillboard(w,h,iU,typedSplit[3]);
	}

}
