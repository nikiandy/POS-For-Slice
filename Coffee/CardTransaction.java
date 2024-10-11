class CardTransaction extends Transaction {
    private String cardType;

    public CardTransaction(MenuItem item, String cardType) {
        super(item);
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String getTransactionDetails() {
        return super.getTransactionDetails() + ", Card type: " + cardType;
    }
}