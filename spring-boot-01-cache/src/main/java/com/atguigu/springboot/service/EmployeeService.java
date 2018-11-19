package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author wangsen
 * @createtime 2018-11-01 14:33
 */
@CacheConfig(cacheNames = {"emp"})
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 打开缓存注解
     *
     *
     * @Cacheable
     * 原理:
     *  1. 自动配置类: CacheAutoConfiguration
     *  2. 缓存的配置类：
     *      1. org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *      2. org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *      3. org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *      4. org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *      5. org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *      6. org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *      7. org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *      8. org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *      9. org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *      10. org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *  3. 默认生效的配置类
     *      SimpleCacheConfiguration
     *  4. 作用：
     *          给容器中注册了一个 CacheManager : ConcurrentCacheManager
     *  5. 获取和创建 ConcurrentMapCache 类型的缓存组件, ConcurrentMapCache 的作用是将数据保存在 ConcurrentMap 中
     *
     *  运行的流程：
     *      以@Cacheable为例
     *      1. 方法运行之前，先去查询 Cache(缓存组件)，按照 cacheNames 指定的名字来查询
     *          (CacheManager 先获取响应的缓存), 如果没有 Cache 组件，回先自动创建出来
     *      2. 去 Cache 中查找缓存的内容，使用一个 key, 默认就是方法的参数
     *          key 是按照某种策略生成的; 默认是使用 keyGenerator 生成的， 默认使用 SimpleKeyGenerator 生成 key
     *              SimpleKeyGenerator 生成 key 的默认策略，
     *                  如果没有参数，key = new SimpleKey()
     *                  如果有一个参数, key = 参数的值
     *                  如果有多个参数 key = new SimpleKey(params)
     *      3. 没有查询到缓存，就调用目标方法；
     *      4. 将目标方法返回的结果放进缓存中。
     *
     *      @Cacheable 标注的方法，执行之前先去检查缓存中是否有这个数据，默认使用参数的值去查询，如果没有
     *                  就运行方法，并将结果放入缓存中;以后再来调用该方法，就使用缓存中的数据
     *
     * CacheManager 管理多个缓存组件，每一缓存组件都有自己的名字，
     *      cacheNames/value: 指定缓存组件的名字,是数组的方式，可以指定多个缓存
     *      key: 缓存数据使用的 key
     *          可以使用 SpEL #id  参数 id 的值， #a0 #p0 #root.args[0]
     *
     *      keyGenerator: key 的生成器，可以指定 key 的生成器
     *      condition: 判断
     *          : condition = "#a0>1" 第一个参数的值 > 1 才会进行缓存
     *      unless: 否定缓存，
     *          unless=true，方法的返回值就不会缓存
     *          #a0==2 如果第一个参数的值为 2 就不会缓存
     *      sync: 缓存是否使用异步
     * @param id
     * @return
     */
    @Cacheable(value = {"emp"}/*, keyGenerator = "myKeyGenerator", condition = "#a0>1", unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * @CachePut 即调用方法，又更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存数据
     * 运行时机：
     *      先调用目标方法，再将目标方法的结果缓存起来
     *
     * 测试步骤：
     *      1. 先查询 1 号员工，查到的结果放入缓存中
     *          key = 1 value: emp
     *      2. 更新 1 号员工的数据
     *          将方法的返回值也放入缓存中，此时没有指定 key
     *          key : 传入的 employee 对象 value: 返回的 employee 对象
     *      3. 查询 1 号员工
     *          此时查到是没更新前的数据：
     *              原因：key 不同
     *              解决办法：
     *                  key="#employee.id"
     *                  key="#result.id"
     *                  @Cacheable 的 key 是不能用 #result 的, 原因是在目标方法运行之前去缓存找数据，用到key时，此时还没执行方法.
     */
    @CachePut(value = {"emp"}, key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp : " +employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict: 缓存清除
     * 通过 key 来指定清除的数据
     *
     * allEntries=true 删除当前缓存中所有的数据, 默认为 false
     * beforeInvocation = true 缓存清除是否在方法执行之前执行，默认为 false
     *      默认在方法执行之后执行，在该方法执行过程中出现异常，则不会清空缓存
     */
    @CacheEvict(value="emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp: " + id);
//        employeeMapper.delEmpById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(/*value="emp",*/ key = "#lastName")
            },
            put = {
                    @CachePut(/*value="emp",*/ key = "#result.id"),
                    @CachePut(/*value="emp", */key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }


}
