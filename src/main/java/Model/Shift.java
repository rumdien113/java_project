package Model;

public class Shift { //shift: ca làm việc
    private String idShift;
    private String idStaff;
    private int startHour;
    private int endHour;
    private int money;
    private int numhour;
    Shift () {
    }

    Shift (String idShift, String idStaff, int startHour, int endHour, int money) {
        this.idShift = idShift;
        this.idStaff = idStaff;
        this.startHour = startHour;
        this.endHour = endHour;
        this.money = money;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumhour() {
        return numhour;
    }

    public void setNumhour(int numhour) {
        this.numhour = getEndHour() - getStartHour();
    }
}
