package pl.coderslab.charity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{


}


