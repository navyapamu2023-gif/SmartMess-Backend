package SmartMess.student;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meals")
@CrossOrigin(origins = "*")
public class MealController {

    private final MealRepository mealRepository;

    public MealController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @PostMapping
    public ResponseEntity<Meal> submitMeal(@Valid @RequestBody Meal meal) {
        Meal savedMeal = mealRepository.save(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMeal);
    }

    @GetMapping
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealRepository.findAll());
    }

    @GetMapping("/demand")
    public ResponseEntity<Map<String, Object>> getMealDemand() {
        List<Meal> meals = mealRepository.findAll();

        int breakfastEat = 0;
        int breakfastSkip = 0;
        int lunchEat = 0;
        int lunchSkip = 0;
        int snacksEat = 0;
        int snacksSkip = 0;
        int dinnerEat = 0;
        int dinnerSkip = 0;

        for (Meal meal : meals) {
            if ("Eat".equalsIgnoreCase(meal.getBreakfast())) {
                breakfastEat++;
            } else if ("Skip".equalsIgnoreCase(meal.getBreakfast())) {
                breakfastSkip++;
            }

            if ("Eat".equalsIgnoreCase(meal.getLunch())) {
                lunchEat++;
            } else if ("Skip".equalsIgnoreCase(meal.getLunch())) {
                lunchSkip++;
            }

            if ("Eat".equalsIgnoreCase(meal.getSnacks())) {
                snacksEat++;
            } else if ("Skip".equalsIgnoreCase(meal.getSnacks())) {
                snacksSkip++;
            }

            if ("Eat".equalsIgnoreCase(meal.getDinner())) {
                dinnerEat++;
            } else if ("Skip".equalsIgnoreCase(meal.getDinner())) {
                dinnerSkip++;
            }
        }

        Map<String, Object> demand = new HashMap<>();
        demand.put("breakfastEat", breakfastEat);
        demand.put("breakfastSkip", breakfastSkip);
        demand.put("lunchEat", lunchEat);
        demand.put("lunchSkip", lunchSkip);
        demand.put("snacksEat", snacksEat);
        demand.put("snacksSkip", snacksSkip);
        demand.put("dinnerEat", dinnerEat);
        demand.put("dinnerSkip", dinnerSkip);

        return ResponseEntity.ok(demand);
    }
}