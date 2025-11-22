import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        do {
            try {
                //запрашиваем данные у пользователя
                System.out.println("Введите цену товара (в руб.): ");
                int price = scanner.nextInt();

                System.out.println("Введите вес товара (в кг.): ");
                int weight = scanner.nextInt();

                //расчет пошлины
                int customsDuty = calculateCustoms(price, weight);

                //вывод результата
                System.out.println("Размер пошлины (в руб.) составит: " + customsDuty);
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целые числа");
                scanner.nextLine(); //очистка буфера
            }

            //спрашиваем у пользователя хочет ли он еще посчитать
            System.out.println("Хотите еще посчитать? (да/нет): ");
            answer = scanner.next();

        } while (answer.equalsIgnoreCase("да") || answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("д"));

        System.out.println("Программа завершена! До скорого! :)");
        scanner.close();
    }

    //статичый метод для расчета пошлины
    public static int calculateCustoms(int price, int weight) {
        // 1 копейка за каждый рубль = price * 0,01
        // 100 рублей за каждый кг = weight * 100
        double dutyInKopecks = price * 0.01 + weight * 100 * 100; //все в копейки

        //убираем копейки и оставляем только рубли
        int dutyInRubles = (int) dutyInKopecks / 100;

        return dutyInRubles;
    }
}
