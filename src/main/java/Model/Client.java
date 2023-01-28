package Model;

public class Client extends Person {

    private String address;
    private int score;

    Client () {
    }

    Client (String id, String name, String sdt, String address, int score) {
        super(id, name, sdt);
        this.address = address;
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
