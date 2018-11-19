package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wangsen
 * @createtime 2018-11-08 17:09
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 1. 定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                                .antMatchers("/level1/**").hasRole("VIP1")
                                .antMatchers("/level2/**").hasRole("VIP2")
                                .antMatchers("/level3/**").hasRole("VIP3");

        // 2. 开启自动配置的登录的功能
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        // 1. /login 到登录页面
        // 2. 登录失败，重定向到/login?error 表示登录失败
        // 默认 POST 形式的 /login 代表处理登录
        // 一旦定制 loginPage， 那么 loginpage 的 post 请求就是登录

        // 表示访问 /logout 请求，清空 session
        // 注销成功后返回 /login?logout 页面
        http.logout().logoutSuccessUrl("/"); //注销成功后来到首页

        // 开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
        // 登录成功后，将 Cookie 发送给浏览器保存，以后访问时带上这个 Cookie 只要通过检查就可以免登录
        // 点击注销就会删除 Cookie
    }

    // 定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                                    .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
                                    .and()
                                    .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
                                    .and()
                                    .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP3");
    }
}
