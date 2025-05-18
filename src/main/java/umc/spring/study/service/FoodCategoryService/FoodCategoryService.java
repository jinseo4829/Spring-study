package umc.spring.study.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.repository.FoodCategoryRepository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean isExistAll(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
