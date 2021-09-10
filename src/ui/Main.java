package ui;

public class Main {
	public int EXIT_OPTION = 5;

	public static void main(String[] args) {
		boolean menu = true;

		while(menu){
			System.out.println("Select an option:"+
								"\n1. Add Billboard"+
								"\n2. Show Billboards"+
								"\n3. Export dangerous report"+
								"\n4. Exit"
								);
			int option = lector.nextInt();
			lector.nextLine();

			switch(option){
				case 1: 
				break;				

				case 2: 
				break;
				
				case 3: 
				break;
				
				case 4: System.out.println("¡Bye!");
						menu=false;
				break;
				
				default:
					System.out.println("Invalid option");
					break;
			}
		}
	}

}
