package it602003;

import java.util.ArrayList;
import java.util.Scanner;

import it602003.objects.ProductGroupObject;
import it602003.process.processImpl.ProductGroupImpl;

public class Main {
//	static ArrayList<ProductGroupObject> pro;
//	static ProductGroupImpl process;
//
//	public static void main(String[] args) {
//		process = new ProductGroupImpl();
//		pro = process.getProductGroupObjects();
//
//		for (ProductGroupObject a : pro) {
//			System.out.println(a);
//		}
//		System.out.println("-----------");
//	}
	public static void main(String[] args) {
		Main menu = new Main();

		// Display the menu options.
		menu.displayMenu();

		// Get the user's selection.
		Scanner scanner = new Scanner(System.in);
		int selection = scanner.nextInt();

		// Handle the user's selection.
		menu.handleSelection(selection);
	}

	private void displayMenu() {
		System.out.println("Product Group Data Table");
		System.out.println("1. Hiển thị toàn bộ bảng");
		System.out.println("Product Group Data Table");
		System.out.println("Product Group Data Table");
		System.out.println("Product Group Data Table");
	}

	private void handleSelection(int selection) {
		switch (selection) {
		case 1:
			// Handle option 1.
			break;
		case 2:
			// Handle option 2.
			break;
		case 3:
			// Handle option 3.
			break;
		case 4:
			// Exit the program.
			System.exit(0);
			break;
		default:
			// Invalid selection.
			System.out.println("Invalid selection.");
			break;
		}
	}
}

