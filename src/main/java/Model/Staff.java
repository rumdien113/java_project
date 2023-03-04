package Model;

public class Staff extends Person {
    private String sex;
    private String birth;
    private String mail;
    private String password;
    private String part;
    private String status;
    public Staff() {
    }
    public Staff(String id, String name, String sdt, String part, String status) {
        super(id, name, sdt);
        this.part = part;
        this.status = status;
    }
    public Staff(String id, String name, String sex, String birth, String mail,
                 String sdt, String part, String status) {
        super(id, name, sdt);
        this.sex = sex;
        this.birth = birth;
        this.mail = mail;
        this.part = part;
        this.status = status;
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
}
