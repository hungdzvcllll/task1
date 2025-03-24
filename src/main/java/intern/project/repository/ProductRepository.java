package intern.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import intern.project.entity.Product;
import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findById(int id);

    public ArrayList<Product> findByName(String name);

    public ArrayList<Product> findByCategoryId(int category_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update product set price=?1 where id=?2")
    public void updatePrice(float price, int id);

    public ArrayList<Product> findAll();
}
