package vtb_lessons.spring_boot.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import vtb_lessons.spring_boot.entity.Item;

public class ItemsSpecs {
    public static Specification<Item> titleContains(String word) {
        return (Specification<Item>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Item> costGreaterThanOrEq(int value) {
        return (Specification<Item>) (root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), value);
        };
    }
}
