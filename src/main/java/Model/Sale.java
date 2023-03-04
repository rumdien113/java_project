package Model;

public class Sale {
    private String idSale;
    private String nameSale;
    private String typeSale;
    private int costSale;
    private String startDaySale;
    private String endDaySale;
    private String statusSale;

    public Sale() {

    }

    public Sale(String idSale, String nameSale, String typeSale,
                int costSale, String startDaySale, String endDaySale, String statusSale) {
        this.idSale = idSale;
        this.nameSale = nameSale;
        this.typeSale = typeSale;
        this.costSale = costSale;
        this.startDaySale = startDaySale;
        this.endDaySale = endDaySale;
        this.statusSale = statusSale;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getNameSale() {
        return nameSale;
    }

    public void setNameSale(String nameSale) {
        this.nameSale = nameSale;
    }

    public String getTypeSale() {
        return typeSale;
    }

    public void setTypeSale(String typeSale) {
        this.typeSale = typeSale;
    }

    public int getCostSale() {
        return costSale;
    }

    public void setCostSale(int costSale) {
        this.costSale = costSale;
    }

    public String getStartDaySale() {
        return startDaySale;
    }

    public void setStartDaySale(String startDaySale) {
        this.startDaySale = startDaySale;
    }

    public String getEndDaySale() {
        return endDaySale;
    }

    public void setEndDaySale(String endDaySale) {
        this.endDaySale = endDaySale;
    }

    public String getStatusSale() {
        return statusSale;
    }

    public void setStatusSale(String statusSale) {
        this.statusSale = statusSale;
    }
}
