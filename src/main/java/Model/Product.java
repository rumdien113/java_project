package Model;

public class Product {
    private String id;
    private String name;
    private String type;
    private int cost; //giá cả
    private String status;

    public Product() {
    }

    public Product(String id, String name, String type, int cost, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
