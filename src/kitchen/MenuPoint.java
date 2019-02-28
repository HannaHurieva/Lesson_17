package kitchen;

public class MenuPoint {

    private final String title;
    private final double price;

    private final String specialization; // поле специализация для блюда будет ключом для повара

    public MenuPoint(String title, double price, String specialization) {
        this.title = title;
        this.price = price;
        this.specialization = specialization;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getSpecialization() {
        return specialization;
    }
}
