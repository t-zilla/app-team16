package com.psi.resource;

import org.springframework.security.core.context.SecurityContextHolder;

public interface RestResource {

    default String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
