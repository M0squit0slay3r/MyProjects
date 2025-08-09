
public class BabyDuck extends Duck {
    public BabyDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        diveBehavior = new DiveFlip();
    }

    public void display() {
        System.out.println("I'm a Baby duck");
    }
}