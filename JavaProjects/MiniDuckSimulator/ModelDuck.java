
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
        diveBehavior = new DiveTwist();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}