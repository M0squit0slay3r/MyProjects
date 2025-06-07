
public class HandsomeDuck extends Duck {
    public HandsomeDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
        diveBehavior = new DiveTwist();
    }

    public void display() {
        System.out.println("I'm a Handsome duck!");
    }
}