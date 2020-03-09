package pl.tomaszosuch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
