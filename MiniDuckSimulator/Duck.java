public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    DiveBehavior diveBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public void performDive() {
        diveBehavior.dive();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void setDiveBehavior(DiveBehavior db) {
        diveBehavior = db;
    }
}