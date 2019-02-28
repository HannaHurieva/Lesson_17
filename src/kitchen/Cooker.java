package kitchen;

public class Cooker {
    private final String name;
    private final String surname;

    private final String specialization;

    public Cooker(String name, String surname, String specialization) {
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public String getName() {
        return name + " " + surname;
    }

// public String addDish(String dish) {
//        return name + " add " + dish;
//    }

    public String getSpecialization() {
        return specialization;
    }
}
