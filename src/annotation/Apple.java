package annotation;

public class Apple {
	@FruitName("Apple")
	private String appleName;
	
	@FruitColor(fruitColor=FruitColor.Color.RED)
	private String appColor;
	
	@FruitProvider(id=1, name="asdf", address="asdfasdfasdf")
	private String appleProvider;
}
