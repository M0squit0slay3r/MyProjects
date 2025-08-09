
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        diveBehavior = new DiveFlip();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}