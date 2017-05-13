package ivan.java.practice.design.patterns.abstractfactory;

/**
 * AbstractFactory 
 * 1.一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有形态的工厂模式都是重要的。
 * 
 * 2.这个系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 * 
 * 3.同属于同一个产品族的产品是在一起使用的，这一约束必须在系统的设计中体现出来。（比如：Intel主板必须使用Intel CPU、Intel芯片组）
 * 
 * 4.系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于实现。
 * 
 * @author http://www.cnblogs.com/java-my-life/archive/2012/03/28/2418836.html
 *
 */
public interface AbstractFactory
{
	/**
	 * 创建CPU对象
	 * 
	 * @return CPU对象
	 */
	public Cpu createCpu();

	/**
	 * 创建主板对象
	 * 
	 * @return 主板对象
	 */
	public Mainboard createMainboard();
}
