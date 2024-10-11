import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Menu {
    private ArrayList<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        File myFile = new File("C:/Users/nikia/OneDrive - Technological University Dublin/FOP2/Coffee/Inventory/CoffeeInventory.txt");
        loadMenuItemsFromFile(myFile);
    }

    public void display() {
        System.out.println("=============================================");
        for (int i = 0; i < menuItems.size(); i++) {
            if (i == menuItems.size() - 1) {
                // If it's the last element, append "Exit" to the end
                System.out.printf((i + 1) + ". %s - %.2f \n", menuItems.get(i).getItemName(), menuItems.get(i).getItemPrice());
                System.out.println("---------------------------------------------");
                System.out.println((i + 2) + ". Exit");
            } else {
                System.out.printf((i + 1) + ". %s - %.2f \n", menuItems.get(i).getItemName(), menuItems.get(i).getItemPrice());
            }
            System.out.println("---------------------------------------------");
        }
    }

    public MenuItem selectMenuItem() {
        int choice = KeyboardValid.getIntInput("Enter the item number: ", 1, menuItems.size() + 1);
        if (choice == menuItems.size() + 1) {
            //System.out.println("Thank you for visiting our Cafe.");
            return new MenuItem("Exit", 0.0);
        } else {
            return menuItems.get(choice - 1);
        }
    }

    private void loadMenuItemsFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String itemName = parts[0].trim();
                double itemPrice = Double.parseDouble(parts[1].trim());
                MenuItem item = new MenuItem(itemName, itemPrice);
                menuItems.add(item);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading menu items from file: " + e.getMessage());
        }
    }
}