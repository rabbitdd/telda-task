package main.data;

/**
 * @author rabbit
 * @create 2021-08-05 20:38
 */
public class Region {

    private Long id;
    private String name;
    private String shortname;

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + ", " + "Shortname: " + getShortname() + ";";
    }
}
