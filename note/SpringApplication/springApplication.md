springboot 启动类

SpringApplication 构造方法

```java
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
		this.resourceLoader = resourceLoader;
		Assert.notNull(primarySources, "PrimarySources must not be null");
		this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
		this.webApplicationType = WebApplicationType.deduceFromClasspath();
		setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
		setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
		this.mainApplicationClass = deduceMainApplicationClass();
	}
```

设置应用上下文初始化器setInitializers

```java
public void setInitializers(Collection<? extends ApplicationContextInitializer<?>> initializers) {
    this.initializers = new ArrayList<>();
    this.initializers.addAll(initializers);
}
```

ApplicationContextInitializer

作用：ApplicationContextInitializer接口的作用就是在spring prepareContext的时候做一些初始化工作，在spring 初始化的过程中 执行prepareContext方法的时候里面会通过applyInitializers方法回调所有ApplicationContextInitializer接口的实现。所以在SpringApplication的构造方法中执行了setInitializers方法，该方法是把初始化的ApplicationContextInitializer实现类全部加载到SpringApplication内部的集合中。

实现：这些初始化器(initializers)是Spring Boot从本地的META-INF/spring.factories文件和jar文件中的META-INF/spring.factories 文件获取配置的初始化类（注意这边是获取了配置文件的全部配置类），然后通过loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());

番外：SpringFactroiesLoader在执行方法loadSpringFactories，会把spring项目下所有的spring.factories文件中的类加载，例如 spring-boot-starter-xxx 之类的依赖包。
```java
public interface ApplicationContextInitializer<C extends ConfigurableApplicationContext> {

	/**
	 * Initialize the given application context.
	 * @param applicationContext the application to configure
	 */
	void initialize(C applicationContext);

}
```

deduceMainApplicationClass 可以获取当前运行的所有栈方法

```java
private Class<?> deduceMainApplicationClass() {
		try {
			StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
			for (StackTraceElement stackTraceElement : stackTrace) {
				if ("main".equals(stackTraceElement.getMethodName())) {
					return Class.forName(stackTraceElement.getClassName());
				}
			}
		}
		catch (ClassNotFoundException ex) {
			// Swallow and continue
		}
		return null;
	}
```

ConfigurableApplicationContext

![ConfigurableApplicationContext](images/configurableApplicationContext.png)

AnnotationConfigApplicationContext

![AnnotationConfigApplicationContext](images/AnnotationConfigApplicationContext.png)

DefaultListableBeanFactory 函数式编程代码

```java
private void updateManualSingletonNames(Consumer<Set<String>> action, Predicate<Set<String>> condition) {
		if (hasBeanCreationStarted()) {
			// Cannot modify startup-time collection elements anymore (for stable iteration)
			synchronized (this.beanDefinitionMap) {
				if (condition.test(this.manualSingletonNames)) {
					Set<String> updatedSingletons = new LinkedHashSet<>(this.manualSingletonNames);
					action.accept(updatedSingletons);
					this.manualSingletonNames = updatedSingletons;
				}
			}
		}
		else {
			// Still in startup registration phase
			if (condition.test(this.manualSingletonNames)) {
				action.accept(this.manualSingletonNames);
			}
		}
	}

@Override
	public void registerSingleton(String beanName, Object singletonObject) throws IllegalStateException {
		super.registerSingleton(beanName, singletonObject);
		updateManualSingletonNames(set -> set.add(beanName), set -> !this.beanDefinitionMap.containsKey(beanName));
		clearByTypeCache();
	}

	@Override
	public void destroySingletons() {
		super.destroySingletons();
		updateManualSingletonNames(Set::clear, set -> !set.isEmpty());
		clearByTypeCache();
	}
```

DefaultListableBeanFactory

![DefaultListableBeanFactory](images/DefaultListableBeanFactory.png)

BackgroundPreinitializer
