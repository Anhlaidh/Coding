package Java.Java_Final.Proxy.AOP;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-04 20:37
 */
public class PersonImpl implements Person {

    @Override
    public void eat() {
        System.out.println("eat...");
    }

    @Override
    public void washHand() {
        System.out.println("washHand...");
    }

    @Override
    public void bath() {
        System.out.println("bath...");
    }
}
