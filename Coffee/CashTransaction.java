class CashTransaction extends Transaction {
    private double amountTendered;
    private double changeGiven;

    public CashTransaction(MenuItem item, double amountTendered) {
        super(item);
        this.amountTendered = amountTendered;
        this.changeGiven = amountTendered - item.getItemPrice();
    }

    public double getAmountTendered() {
        return amountTendered;
    }
    
    public double getChangeGiven() {
        return changeGiven;
    }
    
    @Override
    public String getTransactionDetails() {
        return super.getTransactionDetails() + ", Amount Tendered: " + "€" + amountTendered
                + ", Change Given: " + "€" + changeGiven;
    }
}