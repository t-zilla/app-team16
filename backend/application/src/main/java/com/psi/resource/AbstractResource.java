package com.psi.resource;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractResource {

    protected String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
