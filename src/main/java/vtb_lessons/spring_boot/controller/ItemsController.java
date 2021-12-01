package vtb_lessons.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vtb_lessons.spring_boot.entity.Item;
import vtb_lessons.spring_boot.repositories.specifications.ItemsSpecs;
import vtb_lessons.spring_boot.services.ItemsService;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    private ItemsService itemsService;

    @Autowired
    public void setItemsService(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping
    public String showItemsPage(Model model) {
        Specification<Item> filter = Specification.where(null);
        filter = filter.and(ItemsSpecs.costGreaterThanOrEq(30));
        List<Item> resultList = itemsService.getItemsWithPagingAndFiltering(filter,
                PageRequest.of(1, 2)).getContent();
        model.addAttribute("items", resultList);
        return "items";
}
}
