package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ToDoListApp {
    private static final Logger logger = LogManager.getLogger(ToDoListApp.class);

    private static ToDoListWork todoList = new ToDoListWork();

    public static void main(String[] args) {
        logger.info("Application started.");

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        printMenu();
        while (running) {

            try {

                String command = sc.nextLine();

                switch (command) {
                    case "1":
                        addItem(sc);
                        break;

                    case "2":
                        deleteItem(sc);
                        break;

                    case "3":
                        viewItems();
                        break;

                    case "4":
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid command.  Please try again. ");
                }printMenu();

            }catch (Exception e) {

            }
        }
        sc.close();
        logger.info("Application stopped.");
    }

// uglyyy yea dog yea
    private static void printMenu() {

        System.out.println("To-Do List Application  ");
        System.out.println("1. Add a to-do item ");
        System.out.println("2. Delete a to-do item ");
        System.out.println("3. View to-do items ");
        System.out.println("4. Exit  ");
        System.out.print("Enter your choice: ");
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the description of the to-do item: ");
        String description = scanner.nextLine();
        todoList.addItem(description);
        System.out.println("Item added successfully. ");
    }

    private static void deleteItem(Scanner scanner) {
        System.out.print("Enter the index of the item to delete:  ");
        int index = Integer.parseInt(scanner.nextLine());
        todoList.deleteItem(index);
        System.out.println("Item deleted successfully. ");
    }

    private static void viewItems() {
        System.out.println("To Do org.example.Items: ");
        int index = 0;
        for (Items item : todoList.getItems()) {
            System.out.println(index + ": " + item);
            index++;
        }
    }
}