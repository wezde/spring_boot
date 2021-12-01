package vtb_lessons.spring_boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vtb_lessons.spring_boot.entity.Item;
import vtb_lessons.spring_boot.repositories.ItemRepository;


@Service
public class ItemsService {
    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> getItemsWithPagingAndFiltering(Specification<Item> specifications, Pageable pageable) {
        return itemRepository.findAll(specifications, pageable);
    }


}
