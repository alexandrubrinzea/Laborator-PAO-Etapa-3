public class Receipt extends Client {
    private int confirmationNumber, quantity, price, coupon;

    public Receipt() {
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int ageDiscount (Client c){
        if (c.getAge() < 18) return price/2;
        return 0;
    }

    public void coupon () {
        setPrice(price - coupon*price/100);
    }
}
