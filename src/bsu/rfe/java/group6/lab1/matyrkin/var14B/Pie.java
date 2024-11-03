package bsu.rfe.java.group6.lab1.matyrkin.var14B;

class Pie extends Food implements Nutritious {
    private String filling;

    public Pie(String filling) {
        super("Пирог");
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Pie)) return false; // Шаг 2
            return filling.equals(((Pie) arg0).filling); // Шаг 3
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " с " + filling + " начинкой";
    }

    @Override
    public int calculateCalories() {
        if (filling.equalsIgnoreCase("вишневая")) {
            return 200;
        } else if (filling.equalsIgnoreCase("клубничная")) {
            return 180;
        } else if (filling.equalsIgnoreCase("яблочная")) {
            return 150;
        } else {
            return 0; // Default value if filling is unknown
        }
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }
}
