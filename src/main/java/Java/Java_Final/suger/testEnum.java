package Java.Java_Final.suger;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-07-05 21:31
 */
public class testEnum {
    public static void main(String[] args) {
        Fruit a1 = Fruit.APPLE;
        System.out.println("Price is" + a1.price);

        System.out.println("====================");
        Day d1 = Day.MONDAY;
        Day d2 = Enum.valueOf(Day.class, "MONDAY");
        System.out.println(d1 == d2);
        Day d3 = Enum.valueOf(Day.class, "TUESDAY");
        System.out.println(d1.compareTo(d3));

        //遍历
        for (Day item : Day.values()) {
            //输出索引值
            System.out.println(item.toString() + "," + item.ordinal());
        }

    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    enum Fruit {
        APPLE(10), ORANGE(8);
        private int price;

        Fruit(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }


}
