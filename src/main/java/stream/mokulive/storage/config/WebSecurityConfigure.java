//package stream.mokulive.storage.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import stream.mokulive.storage.service.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/login").permitAll()
////                .antMatchers("/").permitAll()
////                .antMatchers("/user/add").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .csrf().disable()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .usernameParameter("userName")
////                .passwordParameter("password")
////                .defaultSuccessUrl("/")
////                .and()
////                .logout()
////                .logoutSuccessUrl("/login")
////                .permitAll();
////    }
//
//    /**
//     * 自定义UserDetailsService，从数据库中读取用户信息
//     *
//     * @return
//     */
//    @Bean
//    public CustomUserDetailsService customUserDetailsService() {
//        return new CustomUserDetailsService();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //解决静态资源被拦截的问题
//        web.ignoring().antMatchers("/css/**");
//        web.ignoring().antMatchers("/img/**");
//        web.ignoring().antMatchers("/js/**");
//    }
//}
