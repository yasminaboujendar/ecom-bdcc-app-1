package net.boujendar.orderservice.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.ws.rs.core.SecurityContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Component;

import javax.security.auth.kerberos.KerberosKey;

@Component

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate){
        SecurityContext context = (SecurityContext) SecurityContextHolder.getContext();
        String authentication=context.getAuthenticationScheme();
        KerberosKey oAuth2AuthenticationToken = null;

        DefaultOidcUser oidcUser = null;
        String jwtTokenValue = oidcUser.getIdToken().getTokenValue();
        requestTemplate.header("Authorization", "Bearer " + jwtTokenValue);
        requestTemplate.header("Authentication", authentication);


    }
}
