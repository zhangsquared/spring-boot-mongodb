package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class HelloMongoDBApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HelloMongoDBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));
        repository.save(new Customer("Alice", "Brown"));
        repository.save(new Customer("Alice", "Davis"));
        repository.save(new Customer("Alice", "Moore"));
        repository.save(new Customer("Alice", "Clark"));

        System.out.println();
        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice') with page size 2:");
        System.out.println("--------------------------------");
        final int size = 2;

        for(int page = 0; page < 3; page++)
        {
            System.out.println("page "+ page + ":");
            for (Customer customer : repository.findByFirstName("Alice", new PageRequest(page, size))) {
                System.out.println(customer);
            }
        }
        System.out.println();

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

}