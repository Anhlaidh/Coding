package Java.JavaLearning_Advanced.thread.product;

import lombok.Data;

/**
 * @Description:
 * 经典生产者与消费者问题
 * 生产者不断向仓库中存放产品，消费者从仓库中消费产品
 * 其中生产者和消费者都可以有若干个
 * 仓库规则：容量有限，库慢时不可存放，库空时不可取产品
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 21:33
 */
@Data
public class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
