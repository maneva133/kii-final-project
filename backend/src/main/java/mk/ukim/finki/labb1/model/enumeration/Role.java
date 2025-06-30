package mk.ukim.finki.labb1.model.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_HOST;

    @Override
    public String getAuthority() {
        return name();
    }

}
