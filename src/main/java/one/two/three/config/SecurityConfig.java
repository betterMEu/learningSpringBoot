package one.two.three.config;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.rememberme.*;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

import static org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive.COOKIES;

/**
 * @Author: 余龙声
 * @Description: TODO
 * @Date: 2023/10/11 16:18
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String REMEMBER_ME_KEY = "DS5F-D5F5-D5F5-G5HG-D5FS";

    @Resource
    private DataSource dataSource;

    /**
     * 定义多个认证用户（可以定义一个用户，如下一个例子）
     * @return 内存型用户密码校验
     */
//    @Bean
//    @ConditionalOnMissingBean(UserDetailsService.class)
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(BCryptPasswordEncoder passwordEncoder) {
//        String defaultPassword = "yls";
//        return new InMemoryUserDetailsManager(
//                User.withUsername("user")
//                        .password(passwordEncoder.encode(defaultPassword))
//                        .roles("ROLES_USER").build(),
//                User.withUsername("admin")
//                        .password(passwordEncoder.encode(defaultPassword))
//                        .roles("ROLES_ADMIN").build()
//        );
//    }

    @Bean
    UserDetailsManager users(DataSource dataSource,BCryptPasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("yls"))
                .roles("USER")
//                .disabled(Boolean.FALSE)
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("yls"))
                .roles("USER", "ADMIN")
                .disabled(Boolean.TRUE)
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.updateUser(user);
        users.updateUser(admin);
        return users;
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()  // 默认密码编码：一定要有
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }


    /**
     * 重写认证时需要提供PasswordEncoder(否则报错)，在认证中对密码进行编码
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    //--------------------------------------------------------REMEMBER_ME-------------------------------------------------------------------------
    @Bean
    public RememberMeServices rememberMeServices(UserDetailsService userDetailsService, PersistentTokenRepository persistentTokenRepository) {
        return new PersistentTokenBasedRememberMeServices(REMEMBER_ME_KEY, userDetailsService, persistentTokenRepository);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(Boolean.TRUE);
        return jdbcTokenRepository;
    }

    @Bean
    public RememberMeAuthenticationFilter rememberMeFilter(RememberMeServices rememberMeServices, AuthenticationManager authenticationManager) throws Exception {
        return new RememberMeAuthenticationFilter(authenticationManager, rememberMeServices);
    }

    /**
     * DaoAuthenticationProvider 是一个 AuthenticationProvider 的实现，它使用 UserDetailsService 和 PasswordEncoder 来验证一个用户名和密码
     */
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(daoAuthenticationProvider);
    }
//---------------------------------------------------------------------------------------------------------------------------------

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:org/springframework/security/messages_zh_CN");
        return messageSource;
    }

    /**
     * Customizer.withDefaults()是注入默认的安全配置
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   RememberMeServices rememberMeServices) throws Exception {
        http
                .csrf(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
//                .loginPage("/login").permitAll().and()
                .authorizeHttpRequests(author -> author.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .securityContext(securityContext -> securityContext
                                // security-securityContext默认配置
                                .securityContextRepository(new DelegatingSecurityContextRepository(
                                        new RequestAttributeSecurityContextRepository(),
                                        new HttpSessionSecurityContextRepository())
                                )
                        //.requireExplicitSave(true) // 设置手动保存securityContext，需要额外编写代码保存
                )
                .sessionManagement(session -> session
                                .sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::newSession) // 避免会话固定攻击，新用户登录时携带老用户的session时，要为新用户创建一个session
                                .invalidSessionUrl("/login") //检测到无效session时的策略： 跳转页面（可以自定义行为，不一定是跳转页面）
                                .maximumSessions(1) // 每个用户最多存在一个session，当用户试图在第二个浏览器登录时第一个浏览器的session将失效
                        //.maxSessionsPreventsLogin(true) // 慎用，无法控制session何时消失，若退出后session尚未消失将无法登录
                )
                .rememberMe(remember -> remember
                        .rememberMeServices(rememberMeServices)
                )
                .logout(logout -> logout
                        .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(COOKIES))) //注销时，清除用户网站的cookies（目的是删除session）
                );



        return http.build();
    }
}
