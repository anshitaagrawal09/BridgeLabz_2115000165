import java.util.ArrayList;
import java.util.List;
// Step 1: Define the MealPlan interface
interface MealPlan {
    String getMealType();
    void displayMeals();
}
// Step 2: Implement specific meal plans
class VegetarianMeal implements MealPlan {
    private List<String> meals = List.of("Grilled Veggie Wrap", "Lentil Soup", "Tofu Stir-fry");
    @Override
    public String getMealType() {
        return "Vegetarian";
    }
    @Override
    public void displayMeals() {
        System.out.println("Vegetarian Meals: " + meals);
    }
}
class VeganMeal implements MealPlan {
    private List<String> meals = List.of("Vegan Buddha Bowl", "Chickpea Salad", "Quinoa & Avocado");
    @Override
    public String getMealType() {
        return "Vegan";
    }
    @Override
    public void displayMeals() {
        System.out.println("Vegan Meals: " + meals);
    }
}
class KetoMeal implements MealPlan {
    private List<String> meals = List.of("Grilled Salmon", "Cheese Omelette", "Avocado & Eggs");
    @Override
    public String getMealType() {
        return "Keto";
    }
    @Override
    public void displayMeals() {
        System.out.println("Keto Meals: " + meals);
    }
}
class HighProteinMeal implements MealPlan {
    private List<String> meals = List.of("Chicken Breast", "Greek Yogurt", "Egg White Scramble");
    @Override
    public String getMealType() {
        return "High-Protein";
    }
    @Override
    public void displayMeals() {
        System.out.println("High-Protein Meals: " + meals);
    }
}
// Step 3: Create a Generic Meal Class
class Meal<T extends MealPlan> {
    private T mealPlan;
    private int calories;

    public Meal(T mealPlan, int calories) {
        this.mealPlan = mealPlan;
        this.calories = calories;
    }
    public T getMealPlan() {
        return mealPlan;
    }
    public int getCalories() {
        return calories;
    }
    public void displayMealDetails() {
        System.out.println("Meal Plan Type: " + mealPlan.getMealType() + " | Calories: " + calories);
        mealPlan.displayMeals();
    }
}
// Step 4: MealPlanManager with a Generic Method for Validation
class MealPlanManager {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();
    public <T extends MealPlan> void addMealPlan(Meal<T> meal) {
        if (validateMeal(meal)) {
            mealPlans.add(meal);
            System.out.println(meal.getMealPlan().getMealType() + " meal plan added successfully.");
        } else {
            System.out.println("Invalid meal plan.");
        }
    }
    private boolean validateMeal(Meal<? extends MealPlan> meal) {
        return meal.getCalories() > 0;  // Simple validation: calories must be positive
    }
    public void displayAllMealPlans() {
        System.out.println("\n=== Personalized Meal Plans ===");
        for (Meal<? extends MealPlan> meal : mealPlans) {
            meal.displayMealDetails();
            System.out.println("--------------------------------");
        }
    }
}
// Step 5: Main Class to Test the System
public class MealPlanGenerator {
    public static void main(String[] args) {
        // Create meal plans
        VegetarianMeal vegetarian = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();
        // Create meals
        Meal<VegetarianMeal> vegMeal = new Meal<>(vegetarian, 1500);
        Meal<VeganMeal> veganMeal = new Meal<>(vegan, 1400);
        Meal<KetoMeal> ketoMeal = new Meal<>(keto, 1800);
        Meal<HighProteinMeal> proteinMeal = new Meal<>(highProtein, 2000);
        // Create MealPlanManager
        MealPlanManager manager = new MealPlanManager();
        manager.addMealPlan(vegMeal);
        manager.addMealPlan(veganMeal);
        manager.addMealPlan(ketoMeal);
        manager.addMealPlan(proteinMeal);
        // Display all meal plans
        manager.displayAllMealPlans();
    }
}
