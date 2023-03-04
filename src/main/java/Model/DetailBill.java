package Model;
//chi tiết hóa đơn
public class DetailBill {
    private int idBill;
    private String idProduct;
    private String nameProduct;
    private int quantity; //số lượng
    private int cost;
    private int money;


    public DetailBill(String idProduct, int idBill) {
        this.idProduct = idProduct;
        this.idBill = idBill;
    }
    public DetailBill(String idProduct, String nameProduct, int quantity, int money) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.money = money;
    }
    public DetailBill(String idProduct, String nameProduct, int quantity, int cost, int money) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.cost = cost;
        this.money = money;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int amount) {
        this.quantity = amount;
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
