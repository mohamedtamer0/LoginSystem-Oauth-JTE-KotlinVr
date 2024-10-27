package com.tamer.LoginSystem_Oauth_JTE_KotlinVr

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class CsrfTokenAdvice {
    @ModelAttribute("csrf")
    fun csrf(request: HttpServletRequest): CsrfToken {
        return request.getAttribute(CsrfToken::class.java.name) as CsrfToken
    }

    @ModelAttribute("csrfHiddenInput")
    fun csrfHiddenInput(request: HttpServletRequest): CsrfHiddenInput {
        return CsrfHiddenInput(csrf(request))
    }
}