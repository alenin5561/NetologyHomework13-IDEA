public class ProductRepository {

    //создаем перемнную массив для хранения продуктов
    private Product[] products = new Product[0];

    //метод для сохранения
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    //метод для удаления
    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copy = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copy] = product;
                copy++;
            }
        }
        products = tmp;
    }

    //методо для просмотра всех сохранненых
    public Product[] getProducts() {
        return products;
    }

    public Product[] findAll() {
        return products;
    }
}
