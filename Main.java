import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //запрос данных у пользователя
        System.out.print("Введите цену товара (в руб.): ");
        int price = scanner.nextInt();

        System.out.print("Введите вес товара (в кг.): ");
        int weight = scanner.nextInt();

        //расчет пошлины
        int customsDuty = calculateCustoms(price, weight);

        //вывод результата
        System.out.println("Размер пошлины (в руб.) составит: " + customsDuty);

        scanner.close();
    }

    //статический метод для расчета пошлины
    public static int calculateCustoms(int price, int weight) {
        //1 копейка за каждый рубль = price * 0.01
        //100 рублей за каждый кг = weight * 100
        double dutyInKopecks = price * 0.01 + weight * 100 * 100; //переводим все в копейки

        //отбрасываем копейки, оставляя только рубли
        int dutyInRubles = (int) dutyInKopecks / 100;

        return dutyInRubles;
    }
}
