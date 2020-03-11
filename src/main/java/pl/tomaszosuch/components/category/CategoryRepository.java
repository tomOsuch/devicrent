package pl.tomaszosuch.components.category;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.components.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
