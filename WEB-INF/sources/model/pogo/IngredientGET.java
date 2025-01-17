package model.pogo;

public class IngredientGET {

    private Integer ino;
    private String iname;
    private Float iprice;

    public IngredientGET(Integer ino, String iname, Float iprice) {
        this.ino = ino;
        this.iname = iname;
        this.iprice = iprice;
    }

    public Integer getIno() {
        return this.ino;
    }

    public String getIname() {
        return this.iname;
    }

    public Float getIprice() {
        return this.iprice;
    }

    public void setIno(Integer ino) {
        this.ino = ino;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public void setIprice(Float iprice) {
        this.iprice = iprice;
    }
}
