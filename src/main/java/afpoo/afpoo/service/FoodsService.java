package afpoo.afpoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import afpoo.afpoo.dto.FoodDTO;
import afpoo.afpoo.model.Food;
import afpoo.afpoo.repository.FoodsRepository;

@Service
public class FoodsService {
    
    @Autowired
    private FoodsRepository repositorio;

    public List<Food> GetListadeFoods() {
        return repositorio.GetListadeFoods();
    }

    public Food GetFoodporcodigo(int codigo) {
        Optional<Food> food = repositorio.GetFoodporcodigo(codigo);
        return food.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Food not found"));
    }

    public Food CriarfromDTOFood(FoodDTO dto) {
        Food food = new Food();
        food.setName(dto.getName());
        food.setType(dto.getType());
        food.setLink(dto.getLink());
        food.setImg(dto.getImg());
        food.setDescrição(dto.getDescrição());

        return food;
    }

    public Food SalvarFood(Food food) {
        return repositorio.SalvarFood(food);
    }

    public void RemoverFood(int codigo) {
        repositorio.RemoverFood(GetFoodporcodigo(codigo));
    }


}