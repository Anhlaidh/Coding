package Java.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-11 17:03
 */
public class problem {
    private static ScheduledThreadPoolExecutor executor =
            new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {

        executor.setMaximumPoolSize(50);
        while (true) {
            modelFit();
            Thread.sleep(100);
        }
    }

    private static void modelFit() {
        List<CardInfo> takeList = getAllCardInfo();
        takeList.forEach(cardInfo -> {
            executor.scheduleWithFixedDelay(() -> {
                cardInfo.m();
            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    private static List<CardInfo> getAllCardInfo() {
        List<CardInfo> takeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CardInfo ci = new CardInfo();
            takeList.add(ci);
        }
        return takeList;
    }

    private static class CardInfo {
        BigDecimal price = new BigDecimal(0.0);
        String name = "User";
        int age = 5;
        Date birthday = new Date();

        public CardInfo() {
        }

        public void m() {
        }
    }
}
