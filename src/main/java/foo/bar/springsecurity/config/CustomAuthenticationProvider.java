package foo.bar.springsecurity.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    public static final String NEVER_EVER_DO_THIS_IN_PROD = "top-secret";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var customAuthentication = (CustomAuthentication) authentication;

        if(NEVER_EVER_DO_THIS_IN_PROD.equals(customAuthentication.getKey())) {
            return CustomAuthentication.authenticated();
        }

        throw new BadCredentialsException("Nope, wrong credentials!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
