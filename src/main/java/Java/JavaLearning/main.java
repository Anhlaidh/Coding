package Java.JavaLearning;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/11 0011 17:06
 */
public class main {
    static class cat implements Animal{

        @Override
        public void eat() {
            System.out.println("eat");
        }

        @Override
        public void jump() {
            System.out.println("jump");
        }
    }
    public  void have(Animal animal){
        animal.eat();
    }

    public static void main(String[] args) {
        main main = new main();
        main.have(new cat(){
            @Override
            public void eat() {
                super.eat();
            }

            @Override
            public void jump() {
                super.jump();
            }
        });
    }
}
