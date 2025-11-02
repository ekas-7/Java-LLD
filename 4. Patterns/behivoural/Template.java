abstract class Beverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    abstract void brew();
    abstract void addCondiments();
}

class CoffeeBeverage extends Beverage {
    @Override
    void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}

class TeaBeverage extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping tea bag...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

abstract class BeverageWithHook {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water...");
    }

    void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    abstract void brew();
    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true; 
    }
}

class CustomCoffee extends BeverageWithHook {
    @Override
    void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }

    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}

public class Template {
    public static void main(String[] args) {
        
        System.out.println("--- Basic Template Demo ---");
        
        Beverage coffee = new CoffeeBeverage();
        Beverage tea = new TeaBeverage();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\n-------------------------------------");

        System.out.println("--- Template with Hook Demo ---");
        
        BeverageWithHook customCoffee = new CustomCoffee();
        
        System.out.println("Making custom coffee (no condiments)...");
        customCoffee.prepareRecipe();
        
        BeverageWithHook defaultHookCoffee = new BeverageWithHook() {
            @Override
            void brew() {
                System.out.println("Brewing default hook coffee...");
            }
            @Override
            void addCondiments() {
                System.out.println("Adding cream...");
            }
        };
        
        System.out.println("\nMaking default hook coffee (with condiments)...");
        defaultHookCoffee.prepareRecipe();
    }
}