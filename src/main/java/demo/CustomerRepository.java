package demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

//    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

    Page<Customer> findByFirstName(String firstName, Pageable pageable);
}
