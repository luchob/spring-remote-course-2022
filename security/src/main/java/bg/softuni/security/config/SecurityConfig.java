package bg.softuni.security.config;

import bg.softuni.security.model.enums.UserRoleEnum;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http exposes api that allows us configure the web security
    http.
        // which pages will be authorized?
        authorizeRequests().
        // allow CSS at "common" static location (static/css)
        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
        // permit home page, login and registration pages for anyone
        antMatchers("/", "/users/login", "/users/register").permitAll().
        // allow for moderators
        antMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name()).
        // allow for admins
        antMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name()).
        // any remaining reqests should be authenticated
        anyRequest().
        authenticated();
  }
}
