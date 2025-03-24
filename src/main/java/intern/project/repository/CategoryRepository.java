package intern.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import intern.project.entity.Category;
import jakarta.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public ArrayList<Category> findByName(String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update category set name=?1 where id=?2")
    public void upDateCategoryName(String name, int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from category where name=?1")
    public void deleteByName(String name);
    public ArrayList<Category> findAll();
}