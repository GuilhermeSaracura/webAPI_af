package afpoo.afpoo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import afpoo.afpoo.model.Food;

@Component
public class FoodsRepository {
    
    private ArrayList<Food> foods ;
    private int code;

    @PostConstruct
    public void criarclientes(){
        foods = new ArrayList<Food>();
        foods.add(new Food(1, "Coxinha de frango saudável assada"
                            , "Dishes"
                            , "https://www.hojetemfrango.com.br/receita/coxinha-de-frango-saudavel-assada/"
                            , "Para matar a vontade do salgadinho mais amado das festas de aniversário, uma ótima sugestão de receita, cozinha feita com batata doce, aveia e frango, alimentos fontes de carboidrato, proteína e fibras, boa ideia para comer algo diferente e mesmo assim mantendo a alimentação saudável da semana."
                            , "Coxinha.png"){});
        
        foods.add(new Food(2, "Bolinho de Frango com Aveia"
                            , "Dishes"
                            , "https://anamariabraga.globo.com/receita/bolinho-fit-de-frango-com-aveia/"
                            , "Nesta opção de salgado assado fitnes, fonte de proteína, feito com frango e aveia, rico em fibras, ótima opção para quem precisa de ganho de massa muscular."
                            , "Bolinhodefrango.png"){});
        
        foods.add(new Food(3, "Puffs de Batata Doce"
                            , "Dishes"
                            , "https://melepimenta.com/puffs-de-batata-doce-saudaveis/"
                            , "Puffs deliciosos feito com ingredientes acessíveis, uma ótima opção saudável para o lanche da tarde."
                            , "Puffbatata.png"){});

        foods.add(new Food(4, "Picolé de melancia com maracujá"
                            , "Candies"
                            ,"https://www.youtube.com/watch?v=6AXi5wgMuAQ"
                            , "Esta receita é para quem deseja criar um picolé com sabor diferente e misturar frutas, no caso, a melancia e o maracujá."
                            , "Picole.png"){});
        
        foods.add(new Food(5, "Sorvete de banana e manteiga de amendoim"
                            , "Candies"
                            , "https://www.youtube.com/watch?v=cpnVnMXPdV8"
                            , "Esta dica é perfeita para quem tem muito desejo por doce e quer incluir uma fruta junto com algo a mais. É aí que entra a manteiga de amendoim."
                            , "Sorvete.png"){});

        foods.add(new Food(6, "Iogurte de framboesa"
                            , "Candies"
                            , "https://blogdamimis.com.br/2012/09/07/frozen-yogurt-de-framboesa/"
                            , "Prefere os iogurtes em vez dos sorvetes? Pois esta receita foi feita para você. É só misturar iogurte desnatado com frutas vermelhas."
                            ,"Iorgute.png"){});

        foods.add(new Food(7, "Suco de limão de siciliano com hortelã"
                            , "Juices"
                            , "http://www.segredosdatiaemilia.com.br/2013/08/24/suco-de-limao-siciliano-com-hortela/"
                            , "Que o tradicional suco de limão é o favorito entre os brasileiros, devido ao seu sabor cítrico e delicioso, isso nós já sabemos. Não é à toa que ele também é utilizado para a fabricação de sorvetes, doces e outras receitas. Aqui, para apreciar esse delicioso suco com o toque refrescante da hortelã, misturando esses dois ingredientes com água e açúcar e batendo tudo no liquidificador."
                            , "Sucolimao.png"){});

        foods.add(new Food(8, "Suco de laranja com morango"
                            , "Juices"
                            , "https://melepimenta.com/suco-de-laranja-com-morango/"
                            , "Essa é uma mistura saborosa dentre todas as receitas de sucos naturais, uma dica perfeita para quem procura algo diferente para beber. Para fazer esse suco, basta misturar o suco de laranja com morangos congelados e açúcar e bater tudo em um liquidificador."
                            , "Sucolaranja.png"){});

        code=8;
    }

    public List<Food> GetListadeFoods() {
        return foods;
    }
    public Optional<Food> GetFoodporcodigo(int codigo) {
        for(int i=0;i<foods.size();i++){
            Food food=foods.get(i);
            if(food.getCodigo()==codigo){
                return Optional.of(food);
            }
        }
        return Optional.empty();
    }

    public Food SalvarFood(Food food) {
        food.setCodigo(code++);
        foods.add(food);
        return food;
    }
    public void RemoverFood(Food food) {
        foods.remove(food);
    }
}