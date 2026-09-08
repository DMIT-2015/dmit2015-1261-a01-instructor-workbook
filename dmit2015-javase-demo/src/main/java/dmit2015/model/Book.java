package dmit2015.model;

public class Book {

    private String title;
    private double price;

    public Book(String title, double price) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
