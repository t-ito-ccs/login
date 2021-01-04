package ccs.education.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ccs.education.login.service.LoginService;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //(1) Spring Securityを使うための設定
    @Override
    public void configure(WebSecurity web) throws Exception {
        //  (2) 全体に対するセキュリティ設定を行う
        //  web.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // (3) URL毎へのセキュリティ設定を行う
        http
            .formLogin() // フォームログインの設定
            .loginProcessingUrl("/login") //ログインの処理をするURL
            .usernameParameter("username") //idのparameter名
            .passwordParameter("password") //passwordのparameter名
            .permitAll() //ログインページには認証なしでアクセスできる
              .defaultSuccessUrl("/success") //ログイン成功URL
              .failureUrl("/login?error"); //ログイン失敗URL

        http
            .authorizeRequests() // 認証が必要な領域の設定
            //.antMatchers("/hello").authenticated() // Helloページに認証が必要
            .antMatchers("/success").authenticated(); // 認証成功時のURLは認証が必要
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // (4) 主に認証方法の実装の設定を行う
        // AuthenticationManager
        // (4)-a.デフォルトで呼ばれるjdbcAuthenticationから呼ばれるUsserDetailsServiceから認証を行う場合
        // パスワードの検証時に使用するEncoderも設定する
        auth.userDetailsService(getUserDetailService()).passwordEncoder(getPasswordEncoder());
        // (4)-b.独自のAuthenticationProviderを設定し認証を行う場合
        //auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider() {
        // AuthenticationProvider
        // (5) 認証処理の呼び出しを行う
        return new LoginAuthenticationProvider();
    }

    @Bean
    UserDetailsService getUserDetailService() {
      //パスワードの検証時に使用するハッシュ関数
      return new LoginService();
    }

    @Bean
    BCryptPasswordEncoder getPasswordEncoder() {
      //パスワードの検証時に使用するハッシュ関数
      return new BCryptPasswordEncoder();
    }
}
