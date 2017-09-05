package com.handl.springboot.common.spring;

/**
 * Created by handl on 2017/8/26.
 */
//@Configuration
/*public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置spring security对/和/login不拦截
                .antMatchers("/","/login","/jpa").permitAll()
                .anyRequest().authenticated().and()
                .formLogin()
                //设置登入页面访问的路径是/login
                .loginPage("/login")
                //登入成功后转向/chat路径
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    *//**
     * 在内存中分配两个用户，用户名、密码、角色
     * @param auth
     * @throws Exception
     *//*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("usera").password("usera").roles("USER")
                .and()
                .withUser("userb").password("userb").roles("USER");
    }

    *//**
     * 设置对/resource/static/目录下的静态资源不拦截
     * @param web
     * @throws Exception
     *//*
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static*//**");
    }

}*/
