package Model;

public class Staff extends Person {
    Shift shift = new Shift();
    private String sex;
    private String birth;
    private String mail;
    private String password;
    private String part;
    private String status;
    private int salary;
    public Staff() {
    }

    public Staff(String id, String name, String sex, String birth, String mail,
                 String sdt, String part, String status, int salary) {
        super(id, name, sdt);
        this.sex = sex;
        this.birth = birth;
        this.mail = mail;
        this.part = part;
        this.status = status;
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int Salary) {
        this.salary = salary;//14000 * shift.getNumhour();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "shift=" + shift +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", part='" + part + '\'' +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
}
