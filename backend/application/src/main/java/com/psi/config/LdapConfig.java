package com.psi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.search.LdapUserSearch;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;

@Configuration
public class LdapConfig {

    @Value("${spring.ldap.embedded.base-dn}")
    private String ldapBaseDn;

    @Value("${spring.ldap.embedded.port}")
    private String ldapPort;

    @Bean
    public UserDetailsService userDetailsService() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:" + ldapPort);
        contextSource.setBase(ldapBaseDn);
        contextSource.afterPropertiesSet();

        LdapUserSearch ldapUserSearch = new FilterBasedLdapUserSearch("ou=people", "uid={0}", contextSource);
        DefaultLdapAuthoritiesPopulator ldapAuthoritiesPopulator = new DefaultLdapAuthoritiesPopulator(contextSource, "ou=groups");
        ldapAuthoritiesPopulator.setGroupRoleAttribute("ou");

        return new LdapUserDetailsService(ldapUserSearch, ldapAuthoritiesPopulator);
    }

}
