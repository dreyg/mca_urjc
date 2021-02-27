package es.urjc.code.ejem1.domain;


public class ShoppingExpenditureDTO {


    private Long id;
    private double price;

    public ShoppingExpenditureDTO() {
    }

    public ShoppingExpenditureDTO(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
