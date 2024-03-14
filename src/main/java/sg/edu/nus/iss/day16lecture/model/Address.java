package sg.edu.nus.iss.day16lecture.model;

public class Address {
    // put in your own validation

    private String line1;
    private String line2;
    private String postal;
    
    public String getLine1() {
        return line1;
    }
    public void setLine1(String line1) {
        this.line1 = line1;
    }
    public String getLine2() {
        return line2;
    }
    public void setLine2(String line2) {
        this.line2 = line2;
    }
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
    @Override
    public String toString() {
        return "Address [line1=" + line1 + ", line2=" + line2 + ", postal=" + postal + "]";
    }

    
}
