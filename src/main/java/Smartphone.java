public class Smartphone extends Product {

    private String name;
    private String producer;

    public Smartphone(int id, String name, int price, String name1, String producer) {
        super(id, name, price);
        this.name = name1;
        this.producer = producer;
    }

    @Override
    public String getName() {
        return name;
    }
}
