package com.example.demotesting;

import com.example.demotesting.domain.Book;
import com.example.demotesting.domain.Price;
import com.example.demotesting.service.BookService;
import com.example.demotesting.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SpringBootApplication
public class DemoTestingApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PriceService priceService;

    public static void main(String[] args) {
        SpringApplication.run(DemoTestingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Price
//        savePrice();
//        getAllPrice();
//        getPriceById();
        priceService.updatePriceDescription(2l, "This is new description for price id  = 2 ");
    }

    // Default Mapping Entity
    public void getAll() {
        Query nativeQuery = entityManager.createNativeQuery(" Select * from books ", Book.class);
        List<Book> resultList = nativeQuery.getResultList();
        System.out.println(resultList);

    }

    // Custom Mapping
    public void getAllCustomMapping() {
        entityManager.createNativeQuery(" select  b.id as bookId,  from books b; ");
    }

    @Transactional
    public void saveBook() {
        Book book = Book.builder()
                .name("vi")
                .category("nguyen")
                .price(10)
                .build();
        bookService.saveBook(book);

    }

    public void getAllPrice() {
        Query nativeQuery = entityManager.createNativeQuery(" Select * from price ", Price.class);
        List<Book> resultList = nativeQuery.getResultList();
        System.out.println(resultList);
    }

    public void getPriceById() {
        Query nativeQuery = entityManager.createNativeQuery(" select p.price_description as priceDescription, p.price  from price p where p.price_id = :priceId ");
        nativeQuery.setParameter("priceId", 2l);
        List<Object[]> rows = nativeQuery.getResultList();
        for (Object[] row : rows) {
            System.out.println((String) row[0]);
            System.out.println(row[1]);
        }

    }

    @Transactional
    public void savePrice() {
        Price price = Price.builder()
                .name("price 1")
                .price(200.0)
                .description("This is price type 1")
                .build();
        priceService.savePrice(price);

    }
}
