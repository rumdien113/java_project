package Model;

public class Item extends Product {
    private int MaHD;
    private int quantity;
    private int amount;

    public Item() {
        super();
    }

    public Item(int MaHD, String id, String name, int cost, int quantity, int amount) {
        super(id, name, cost);
        this.MaHD = MaHD;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
