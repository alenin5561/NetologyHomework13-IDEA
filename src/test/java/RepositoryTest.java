import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product prod1 = new Book(1, "Книга", 650, "Зеленая миля", "Стивен Кинг");
    Product prod2 = new Book(2, "Книга", 770, "Оно", "Стивен Кинг");
    Product prod3 = new Book(3, "Книга", 1120, "Оно.Коллекционное издание", "Стивен Кинг");

    Product prod4 = new Book(4, "Книга", 450, "Эскалибур", "Бернард Корнуэл");
    Product prod5 = new Smartphone(5, "Смартфон", 56690, "Iphone11", "Apple");
    Product prod6 = new Smartphone(6, "Смартфон", 57590, "Galaxy S22", "Samsung");
    Product prod7 = new Smartphone(7, "Смартфон", 13690, "Redmi 10", "Xiaomi");


    @Test
    public void saveProductTest() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        repository.save(prod5);
        repository.save(prod6);

        Product[] expected = {prod1, prod2, prod3, prod4, prod5, prod6};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductTest() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        repository.save(prod5);
        repository.save(prod6);
        repository.remove(2);
        repository.remove(4);

        Product[] expected = {prod1, prod3, prod5, prod6};
        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookName() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);
        manager.add(prod5);
        manager.add(prod6);


        Product[] expected = {prod1};
        Product[] actual = manager.searchBy("Зеленая миля");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByBookName1() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);
        manager.add(prod5);
        manager.add(prod6);
        manager.add(prod7);


        Product[] expected = {prod2, prod3};
        Product[] actual = manager.searchBy("Оно");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPhoneName() {

        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);
        manager.add(prod5);
        manager.add(prod6);
        manager.add(prod7);


        Product[] expected = {prod5};
        Product[] actual = manager.searchBy("Iphone11");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProductName() {

        Product product = new Product(1, "DVD", 80);

        String search = "DVD";
        assertTrue(product.matches(search));
    }

    @Test
    void ssearchByFalseProductName() {

        Product product = new Product(1, "DVD", 80);

        String search = "Video";
        assertFalse(product.matches(search));

    }
}
