package entities.withDataBase;

public class DBUser {
    private int id;
    private String name;
    private String pass;

    public DBUser(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
    public DBUser(int id, String name){
        this.name = name;
        this.id = id;
    }

    public DBUser(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
