class Purchase {
    private String name;
    private double price;
    private int satisfaction = 5;

    public Purchase(String theName, double thePrice) {
        name = theName;
        price = thePrice;
        satisfaction = (int) (Math.random() * ((10 - 1) + 1)) + 1;
    }

    public String toString() {
        return name + " which costs $" + price + " and has " + satisfaction + "/10 satisfaction stars";
    }

    public double getPrice() {
        return price;
    }

    public int getSatisfaction() {
        return satisfaction;
    }
}
