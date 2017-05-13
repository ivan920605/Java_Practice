package ivan.java.practice.design.patterns.factory;

/**
 * ShapeFactory used to produce shape object
 * 
 * @author lchen283
 *
 */
public class ShapeFactory
{
	// use getShape method to get object of type shape
	public Shape getShape(String shapeType)
	{
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();

		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();

		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}
}
