
public class MiniDuckSimulator
{
	public static void main(String[] args)
	{
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.display();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		
		
		// my examples
		Duck baby = new BabyDuck();
		baby.display();
		baby.performFly();
		baby.setQuackBehavior(new Sqeak());
		baby.performQuack();
		baby.performDive();
		
		Duck handsome= new HandsomeDuck();
		handsome.display();
		handsome.setFlyBehavior(new FlyNoWay());
		handsome.performFly();
		handsome.setQuackBehavior(new MuteQuack());
		handsome.performQuack();
		handsome.setDiveBehavior(new DiveFlip());
		handsome.performDive();
		
		
		
	}
}