package Model;

public class DetailSalary {
    private String idStaff;
    private  String idShift;
    private int numShift;
    private int salary;
    private String nameSalary;

    DetailSalary() {
    }

    DetailSalary(String idStaff, String idShift, int numShift, int salary, String nameSalary) {
        this.idStaff = idStaff;
        this.idShift = idShift;
        this.numShift = numShift;
        this.salary = salary;
        this.nameSalary = nameSalary;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }

    public int getNumShift() {
        return numShift;
    }

    public void setNumShift(int numShift) {
        this.numShift = numShift;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getNameSalary() {
        return nameSalary;
    }

    public void setNameSalary(String nameSalary) {
        this.nameSalary = nameSalary;
    }
}
