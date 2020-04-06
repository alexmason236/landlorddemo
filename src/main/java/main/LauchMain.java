package main;

import model.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LauchMain {
    public static void main(String[] args) {
        List<Poker> pokers = PokerUtils.create();
        List<Poker> sendPokers = PokerUtils.sendPoker(pokers);
        PokerUtils.sort(sendPokers);
        for (Poker p : sendPokers) {
            System.out.println(p);
        }
    }

    static class PokerUtils {

        static Poker dawang = new Poker(0, "大王", 15);
        static Poker xiaowang = new Poker(1, "小王", 14);
        static String[] names = new String[]{"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        static String[] colors = new String[]{"黑桃", "红桃", "梅花", "双块"};

        static List<Poker> create() {
            List<Poker> allPokers = new ArrayList<Poker>();
            int id = 2;
            int num = names.length;
            for (String name : names) {
                for (String color : colors) {
                    Poker poker = new Poker(id++, color + name, num);
                    allPokers.add(poker);
                }
                num--;
            }
            allPokers.add(dawang);
            allPokers.add(xiaowang);
            Collections.shuffle(allPokers);
            return allPokers;
        }

        static List<Poker> sendPoker(List<Poker> list) {
            return list.subList(0, 16);
        }

        static void sort(List<Poker> list) {
            Collections.sort(list, (p1, p2) -> {
                if (p1.getNum() > p2.getNum() || p1.getNum() == p2.getNum() && p1.getId() > p2.getId()) return 1;
                return -1;
            });
        }



//        private boolean check(Poker poker) {
//        }


    }
}
