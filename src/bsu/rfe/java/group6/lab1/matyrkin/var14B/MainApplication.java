package bsu.rfe.java.group6.lab1.matyrkin.var14B;
import java. util. Comparator;
import java.util.Arrays;
public class MainApplication {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                // У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                // У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else if (parts[0].equals("Pie")) {
                // У пирога - 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Pie(parts[1]);
            }
            // ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }

        // Употребляем продукты, созданные из аргументов командной строки
        System.out.println("--------------------------------------------");
        System.out.println("Употребляем завтрак:");
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else {
                break;
            }
        }
        System.out.println("--------------------------------------------");

        // Вывод информации о продуктах
        System.out.println("--------------------------------------------");
        for (Food item : breakfast) {
            if (item != null) {
                System.out.println("Продукт: " + item.getName() + ", Калории: " + item.calculateCalories());
            } else {
                break;
            }
        }

        // Подсчет количества пирогов с вишневой начинкой
        int count = 0;
        for (Food item : breakfast) {
            if (item instanceof Pie && item.equals(new Pie("вишневая"))) {
                count++;
            }
        }
        System.out.println("Количество пирогов с вишневой начинкой: " + count);

        // Рассчитываем общую калорийность завтрака, если в аргументах есть "-calories"
        boolean calculateCalories = false;
        for (String arg : args) {
            if (arg.equals("-calories")) {
                calculateCalories = true;
                break;
            }
        }

        Arrays.sort(breakfast, new Comparator() {
            public int compare(Object f1, Object f2) {
                if (f1==null) return 1;
                if (f2==null) return -1;
                return ((Food)f1).getName().compareTo(((Food)f2).getName());
            }
        });


        // Перебор всех элементов массива и "употребление" продуктов
        System.out.println("--------------------------------------------");
        System.out.println("Употребляем завтрак:");
        for (Food item : breakfast)
            if (item != null)
                // Если элемент не null – употребить продукт
                item.consume();
            else
                // Если дошли до элемента null – значит достигли конца
                // списка продуктов, ведь 20 элементов в массиве было
                // выделено с запасом, и они могут быть не
                // использованы все
                break;

        System.out.println("--------------------------------------------");
        System.out.println("Всего хорошего!");
    }


}
