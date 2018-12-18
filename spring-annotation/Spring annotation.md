# Spring 注解驱动

## 容器

##### 给容器中注册组件的方式：

* 包扫描+组件标记注解(@Controller/@Service/@Repository/@Component)

* ==@Bean==[导入第三方包里的组件]

* ==@Impor==t 快速给容器中导入组件

  * **导入的组件bean的 id 默认为组件的全类名**

  * ImportSelector : 返回需要导入的组件的全类名数组，相当于直接在 Import 中直接写。

  * ImportBeanDefinitionRegistrar ： 手动将 bean 注册到容器中：

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

  * 使用 Spring 提供的 FactoryBean(工厂 Bean)











