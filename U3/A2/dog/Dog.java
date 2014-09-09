package dog;

public class Dog {

    private final String name;

    private final String breed;

    private int age;

    private int hunger;

    private int aggression;

    // a basic dog constructor declaring all variables
    public Dog(String name, String breed, int age, int hunger, int aggression) {
        this.name = name;
        this.breed = breed;
        this.setAge(age);
        this.setHunger(hunger);
        this.setAggression(aggression);
    }

    // various getters to get information about the dog

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

}
