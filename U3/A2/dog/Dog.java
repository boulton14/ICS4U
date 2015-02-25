package dog;

public class Dog {

    private final String name;

    private final String breed;

    private int age;

    private int hunger;

    private int aggression;

    // a basic dog constructor declaring all variables
    public Dog(final String name, final String breed, final int age,
            final int hunger, final int aggression) {
        this.name = name;
        this.breed = breed;
        this.setAge(age);
        this.setHunger(hunger);
        this.setAggression(aggression);
    }

    // various getters to get information about the dog

    public int getAge() {
        return age;
    }

    public int getAggression() {
        return aggression;
    }

    public String getBreed() {
        return breed;
    }

    public int getHunger() {
        return hunger;
    }

    public String getName() {
        return name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public void setAggression(final int aggression) {
        this.aggression = aggression;
    }

    public void setHunger(final int hunger) {
        this.hunger = hunger;
    }

}
