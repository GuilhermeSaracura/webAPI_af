package afpoo.afpoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import afpoo.afpoo.dto.FoodDTO;
import afpoo.afpoo.model.Food;
import afpoo.afpoo.service.FoodsService;

@RestController
@RequestMapping("Foods")
public class FoodsController {
    
    @Autowired
    private FoodsService service;

    @GetMapping()
    public List<Food> GetFoods(){
        return service.GetListadeFoods();
    }
    
    @GetMapping("/{codigo}")
    public ResponseEntity<Food> GetFood(@PathVariable int codigo){
        Food food = service.GetFoodporcodigo(codigo);
        if(food!=null){
            return ResponseEntity.ok(food);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping()
    public ResponseEntity<Void> PostFood(@Valid @RequestBody FoodDTO fooddto, HttpServletRequest request,UriComponentsBuilder builder){
        Food food = service.CriarfromDTOFood(fooddto);
        food = service.SalvarFood(food);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+food.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        service.RemoverFood(codigo);
        return ResponseEntity.noContent().build();
    }


}