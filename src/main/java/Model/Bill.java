package Model;

public class Bill {
    private String idBill;
    private String idStaff;
    private String idClient;
    private String sdt;
    private String dateBill;
    private String typePay;
    private int money;
    private int sale;
    private int totalMoney;

    Bill () {

    }

    Bill (String idbill, String idStaff, String idClient, String sdt,
          String dateBill, String typePay, int money, int sale, int totalMoney) {
        this.idBill = idbill;
        this.idStaff = idStaff;
        this.idClient = idClient;
        this.sdt = sdt;
        this.dateBill = dateBill;
        this.typePay = typePay;
        this.money = money;
        this.sale = sale;
        this.totalMoney = totalMoney;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
