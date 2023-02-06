package foo.bar.springsecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthentication implements Authentication {
    private final String key;
    private final boolean authenticated;

    private CustomAuthentication(String key, boolean authenticated) {
        this.key = key;
        this.authenticated = authenticated;
    }

    public static CustomAuthentication unauthenticated(String key) {
        return new CustomAuthentication(key, false);
    }

    public static CustomAuthentication authenticated() {
        return new CustomAuthentication(null, true);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }

    public String getKey() {
        return key;
    }
}
