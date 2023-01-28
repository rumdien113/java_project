package Model;

public class DetailBill {
    private String idBill;
    private String idProduct;
    private String nameProduct;
    private int amount; //số lượng
    private int money;
    private int cost;

    DetailBill() {
    }

    DetailBill(String idBill, String idProduct, String nameProduct, int amount, int money, int cost) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.money = money;
        this.cost = cost;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
