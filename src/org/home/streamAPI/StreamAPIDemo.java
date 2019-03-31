package org.home.streamAPI;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: LiuChong
 * @Date: 2019-03-31 16:43
 * @Description:
 */
public class StreamAPIDemo {

    public class Trader {
        private final String name;
        private final String city;

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

        public String getCity() {
            return city;
        }

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }
    }

    public class Transaction{
        private final Trader trader;
        private final int year;
        private final int value;
        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }
        public Trader getTrader(){
            return this.trader;
        }
        public int getYear(){
            return this.year;
        }
        public int getValue(){
            return this.value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }


    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    /**
     * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
     * (2) 交易员都在哪些不同的城市工作过？
     * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
     * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
     * (5) 有没有交易员是在米兰工作的？
     * (6) 打印生活在剑桥的交易员的所有交易额。
     * (7) 所有交易中，最高的交易额是多少？
     * (8) 找到交易额最小的交易。
     */


    //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
    @Test
    public void ex1(){
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
    }

    //(2) 交易员都在哪些不同的城市工作过？
    @Test
    public void ex2(){
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
    @Test
    public void ex3(){
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(),"Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
    @Test
    public void ex4(){
        String s = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .collect(Collectors.joining());
        System.out.println(s);
    }

    //(5) 有没有交易员是在米兰工作的？
    @Test
    public void ex5(){
        boolean milan = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(c -> Objects.equals(c, "Milan"));
        System.out.println(milan);
    }
    //(6) 打印生活在剑桥的交易员的所有交易额。
    @Test
    public void ex6(){
        Optional<Integer> cambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(cambridge.orElse(0));
    }

    //(7) 所有交易中，最高的交易额是多少？
    @Test
    public void ex7(){
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max.orElse(0));
    }

    //(8) 找到交易额最小的交易。
    @Test
    public void ex8(){
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
