# Spring 注解驱动

## 容器

### 给容器中注册组件的方式：

- 包扫描+组件标记注解(@Controller/@Service/@Repository/@Component)

- ==@Bean==[导入第三方包里的组件]

- ==@Impor==t 快速给容器中导入组件

  - **导入的组件bean的 id 默认为组件的全类名**

  - ImportSelector : 返回需要导入的组件的全类名数组，相当于直接在 Import 中直接写。

  - ImportBeanDefinitionRegistrar ： 手动将 bean 注册到容器中：

    所有需要添加到容器中的 bean，使用 BeanDefinitionRegistry.registerBeanDefinition 这个方法.

    ```java
       /**
         * AnnotationMetadata : 当前类的注解相关的信息
         * BeanDefinitionRegistry ： 所有需要添加到容器中的 bean，使用BeanDefinitionRegistry.registerBeanDefinition 这个方法
         * 手动将 bean 注册到容器中
         */
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            boolean existRed = registry.containsBeanDefinition("com.atguigu.bean.Red");
            boolean existGreen = registry.containsBeanDefinition("com.atguigu.bean.Green");
            if (existGreen && existRed) {
                RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
                registry.registerBeanDefinition("rainBow", beanDefinition);
            }
        }
    ```

  - 使用 Spring 提供的 FactoryBean(工厂 Bean)

    - 默认获取到的是工厂Bean调用 getObject 返回的对象

    - 若要返回工厂Bean本身，则需要在Id前加上 `&`

       例如：`Object beanSelf = context.getBean("&colorFactoryBean");`

### Bean 的生命周期

#### 单实例与多实例：

`@Scope（"prototype")` 多实例注解

-  单实例：在容器启动时，就创建对象，在容器关闭时销毁
-  多实例：在每次获取的时候创建对象，容器不会管理这个Bean，容器关闭时，不会调用Bean的销毁方法。

#### 容器管理Bean的生命周期：

	我们可以自定义初始化和销毁方法：容器在Bean进行到当前生命周期的时候，来调用我们自定		义的初始化与销毁的方法。

-  指定初始化和销毁方法；

  	通过 `@Bean`注解指定 init-method 与 destroy-method

  `@Bean(initMethod = "init", destroyMethod = "destroy")`

- 通过让Bean实现`InitializingBean`接口（定义初始化逻辑）, `DisposableBean`接口（定义销毁逻辑）

- 可以使用`JSR250`Java规范中定义的注解：

  - `@PostConstruct`：在Bean创建完成，并且属性赋值完成，来执行初始化方法
  - `@PreDestroy`：在容器销毁Bean之前，执行的方法。

- `@BeanPostProcessor`：Bean的后置处理器接口

  - `postProcessBeforeInitialization`方法：初始化之前执行的方法；

  - `postProcessAfterInitialization`方法：Bean **在实例初始化之后，在任何初始化方法执行之前**的方法

    `populateBean(beanName, mbd, instanceWrapper);`：给Bean属性赋值

    `applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);`：遍历得到容器中所有的 BeanPostProcessor，并调用其 BeforeInitialization 方法，一旦其中一个返回 null，则跳出循环，不会执行后续的 BeanPostProcessor 的 BeforeInitialization 方法。

    `invokeInitMethods(beanName, wrappedBean, mbd);`执行自定义初始化

    `applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);`

  - 









