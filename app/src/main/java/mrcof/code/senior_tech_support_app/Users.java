package mrcof.code.senior_tech_support_app;

public class Users {

    public String brand, image;

    public Users(){

    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public Users(String brand, String image) {
        this.brand = brand;
        this.image = image;
    }
}

