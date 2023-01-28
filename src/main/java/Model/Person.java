package Model;

public class Person {
    private String id;
    private String name;
    private String sdt;

    Person () {
    }

    Person (String id, String name, String sdt) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
