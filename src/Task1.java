public class FeedCats {
    private static int TIME = 0;
    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Барсик", 200, 3);
        cat[1] = new Cat("Мурзик", 100, 4);
        cat[2] = new Cat("Зевс", 50, 5);
        Plate plate = new Plate(500);

        System.out.println("У нас в наличии: ");
        for (Cat value : cat) {
            System.out.println(value.getName() + " и он будет хотеть хавать каждые " + value.getSatietyTime() + " часа(-ов)");
        }

        System.out.println("Сейчас в миске: " + plate.getFood() + " граммчиков");

        do{
            for (Cat i : cat){
                if (i.getSatiety() == 0){
                    if (!plate.checkFood(i.getAppetite())){
                        plate.increaseFood();
                    }

                    i.eat(plate);
                    System.out.println("Кошарыч " + i.getName() + " сожрал " + i.getAppetite() + " граммчиков,проголодается " +
                            "через " + (i.getSatiety()) + " часов, ну или минут. ");
                }
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента кормешки прошло " + TIME + " В миске осталось " + plate.getFood() + "\n");
            TIME++;
        }while (TIME <= 24);
    }
}

class Cat{
    private String name;
    private int appetite;
    private int satiety;
    private int satietyTime;

    String getName(){
        return name;
    }

    int getAppetite(){
        return appetite;
    }

    int getSatiety(){
        return satiety;
    }

    void setSatiety(int satiety){
        this.satiety = satiety;
    }

    int getSatietyTime(){
        return satietyTime;
    }

    Cat (String name, int appetite, int satietyTime){
        this.name = name;
        this.appetite = appetite;
        this.satiety = 0;
        this.satietyTime = satietyTime;
    }

    void eat(Plate p){
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}

class Plate{
    private int food;

    int getFood(){
        return food;
    }

    Plate(int food){
        this.food = food;
    }

    void decreaseFood(int a){
        food -= a;
    }

    void increaseFood(){
        this.food += 100;
        System.out.println("В миску было добавлено 100 граммчиков");
    }

    boolean checkFood(int n){
        return (food - n) >= 0;
    }
}
