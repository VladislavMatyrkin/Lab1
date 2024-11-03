package bsu.rfe.java.group6.lab1.matyrkin.var14B;

class Cheese extends Food {
    public Cheese() {
        super("Сыр");
    }

    public void consume() {
        System.out.println(this + " съеден");
    }

    @Override
    public int calculateCalories() {
        return 100; // Пример, вы можете использовать другие значения
    }
}
