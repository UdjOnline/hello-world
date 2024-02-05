import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        String[] availableCurrencies = {"EURO", "USD", "TL"}; //создаем массив валют
        double[] currencyRates = {1, 0.92, 0.03}; //явно инициализируеи массив курса валют

        if (args.length == 3) { /*создаем оператор if и указываем аргумент длины)*/
            currencyRates[0] = Double.parseDouble(args[0]);
            currencyRates[1] = Double.parseDouble(args[1]);
            currencyRates[2] = Double.parseDouble(args[2]);
        }

        Scanner scanner = new Scanner(System.in); // создаем сканер
        String currencyFrom, currencyTo, name; //обьявляем переменные типа String

        System.out.print(
                "Приветствуем в Currency Converter!\n" +
                        "Введите Ваше имя: \n"
        );
        name = scanner.nextLine(); // считываем введенное значение имени
        System.out.print(
                "Привет, " + name + "!\n" +
                        "Выберите исхрдную валюту: \n"
        ); // выводим это сообщение пользователю

        printArray(availableCurrencies); //запускаем подметод

        System.out.println("или введите exit, чтобы завершить программу"); //выводим пользователю

        do {
            System.out.print("Выберите исходную валюту: ");
            currencyFrom = scanner.nextLine(); //считываем исходное значение валюты
            double x, y;//обьявляем переменные типа double

            x = getRateValue(currencyFrom, currencyRates);
            if (x == -1){
                System.out.println(
                        currencyFrom.equalsIgnoreCase("exit") ?
                        "Good bye!" : "Некоректное значение, попробуйте еще раз!");
                continue;
            }

            System.out.print("Выберите в какую валюту перевести: ");
            currencyTo = scanner.nextLine(); //запускаем сканер введенной валюты

            y = getRateValue(currencyTo, currencyRates); //запускаем подметод
            if (y == -1) {
                System.out.println("Некоректное значение, попробуйте еще раз!");
                continue;
            }

            System.out.print("Введите сумму перевода в исходной валюте: ");
            double initSum = Double.parseDouble(scanner.nextLine()); //запускаем сканер

            double finalSum = initSum * x / y; //считаем сумму перевода
            //округляем вниз до 2-х знаков
            int roundedTotal = (int) (finalSum * 100);
            finalSum = (double) roundedTotal / 100;

            System.out.println("Вы получите: " + finalSum);
            System.out.println("Спасибо, что выбрали нас, " + name + "!");
        } while (!currencyFrom.equals("exit")); //заново запускаем
    }

    public static void printArray(String[] availableCurrencies) {
        for (String availableCurrency : availableCurrencies) //использование итеративного оператора for
            System.out.println("* " + availableCurrency + " *"); //выводим пользователю
    }
    public static double getRateValue (String currency, double[] rates) {
        double rate;

        switch (currency) {
            case "EURO":
                rate = rates[0];
                break;
            case "USD":
                rate = rates[1];
                break;
            case "TL":
                rate = rates[2];
                break;
            default:
                System.out.println("Вы ввели неверное значение, попробуйте еще раз!");
                rate = -1;
        }
        return rate;
    }
}