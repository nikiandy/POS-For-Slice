class MenuItem {
    private String itemName;
    private double itemPrice;

    public MenuItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getMenuItemDetails() {
        return itemName + " - " + itemPrice;
    }
}