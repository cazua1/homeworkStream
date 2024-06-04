import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /* 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
        к большей).*/

        List<Transaction >result1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();

        System.out.println(result1);

        /* 2. Вывести список неповторяющихся городов, в которых работают трейдеры. */

        List<String >result2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        System.out.println(result2);

        /* 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам. */

        List<String >result3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .map(Trader::getName)
                .distinct()
                .sorted()
                .toList();

        System.out.println(result3);

        /* 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        порядке. */

        String result4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(result4);

        /* 5. Выяснить, существует ли хоть один трейдер из Милана. */

        boolean result5 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .anyMatch(c -> c.equals("Milan"));

        System.out.println(result5);

        /* 6. Вывести суммы всех транзакций трейдеров из Кембриджа. */

        int result6 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println(result6);

        /* 7. Какова максимальная сумма среди всех транзакций? */

        int result7 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max().getAsInt();

        System.out.println(result7);

        /* 8. Найти транзакцию с минимальной суммой. */

        int result8 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min().getAsInt();

        System.out.println(result8);
    }
}