package Java.JavaLearning_Advanced.thread.product;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 22:58
 */
 class Storage {
    //仓库容量为10
    private Product[] products = new Product[10];
    private int top = 0;

    //生产者往仓库放入产品
    public synchronized void push(Product product) {
        while (top == products.length) {
            try {
                System.out.println("producer wait");
                wait();//仓库已满，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            //把产品放入仓库
            products[top++] = product;

            System.out.println(Thread.currentThread().getName()+"生产了产品"+product);
            System.out.println("producer notifyAll");
            notifyAll();//唤醒所有线程


    }

    //消费者从仓库中取出产品
    public synchronized Product pop() {
        while (top == 0) {
            try {
                System.out.println("consumer wait");
                wait();//仓库空，请等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //从仓库取出产品
        --top;
        Product p = new Product(products[top].getId(), products[top].getName());
        products[top] = null;
        System.out.println(Thread.currentThread().getName() + "消费了产品" + p);
        System.out.println("consumer notifyAll");
        notifyAll();//唤醒等待线程
        return p;
    }
}
