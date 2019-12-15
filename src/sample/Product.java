package sample;

import javafx.scene.image.Image;

public class Product {
    private String name;
    private String quantity;
    private String description;
    private double oldPrice;
    private double newPrice;
    private String imgPath;

    public Product(String name, String quantity, String description, double oldPrice, double newPrice, String imgPath ) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.imgPath = imgPath;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", oldPrice=" + oldPrice +
                ", newPrice=" + newPrice +
                '}';
    }
}
