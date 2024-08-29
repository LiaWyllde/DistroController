package view;

import controller.DistroController;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		DistroController infos = new DistroController();
		Scanner scan = new Scanner(System.in);
		
		int option = 0;
		
		String menu = """
				
						Choose an option
						
						1 - Show Linux Distro version
						9 - Exit
						
				""";
		
		while (option != 9) {
			
			System.out.println(menu);
			option = scan.nextInt();
			
			switch (option) {
			
			case 1:
				infos.showDistro();
				break;

			case 9:
				System.out.println("Exiting...");
				break;
			} 
		}
		scan.close();
	}
}
