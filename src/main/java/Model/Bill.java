package Model;

import org.apache.poi.ss.usermodel.CellStyle;

public class Bill {
    private int idBill;
    private String idStaff;
    private String namestaff;
    private String dateBill;
    private String typePay;
    private int totalMoney;
    private String status;
    public Bill () {
    }
    public Bill(int idBill) {
        this.idBill = idBill;
    }
    public Bill (int idBill, String idStaff, String namestaff, String dateBill, String typePay, int totalMoney) {
        this.idBill = idBill;
        this.idStaff = idStaff;
        this.namestaff = namestaff;
        this.dateBill = dateBill;
        this.typePay = typePay;
        this.totalMoney = totalMoney;
    }
    public Bill (int idBill, String namestaff, String dateBill, String typePay, int totalMoney, String status) {
        this.idBill = idBill;
        this.namestaff = namestaff;
        this.dateBill = dateBill;
        this.typePay = typePay;
        this.totalMoney = totalMoney;
        this.status = status;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }
    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }
    public String getNamestaff() {
        return namestaff;
    }

    public void setNamestaff(String namestaff) {
        this.namestaff = namestaff;
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

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
