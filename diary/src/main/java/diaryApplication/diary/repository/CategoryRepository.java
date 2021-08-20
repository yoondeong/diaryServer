package diaryApplication.diary.repository;

import diaryApplication.diary.domain.category.Category;
import diaryApplication.diary.domain.category.CategoryDto;
import diaryApplication.diary.domain.emoticon.Emoticon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private final EntityManager em;

    public void save(Category category){
        em.persist(category);
    }

    public Category findById(int id){
        return em.find(Category.class,id);
    }

    public void remove(int id){
        em.remove(findById(id));
    }

    public List<CategoryDto> findAll(){
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = em.createQuery("select c from Category c").getResultList();
        for(Category category : categories){
            CategoryDto categoryDto = new CategoryDto(category.getId(),category.getName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}