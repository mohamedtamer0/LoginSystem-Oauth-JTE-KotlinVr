package com.tamer.LoginSystem_Oauth_JTE_KotlinVr

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DashboardController {
    @GetMapping("/dashboard")
    fun dashboard(authentication: Authentication, request: HttpServletRequest, model: Model): String {
        if (authentication.principal is UserDetails) {
            val userDetails = authentication.principal as UserDetails
            model.addAttribute("username", userDetails.getUsername())
            model.addAttribute("authorities", userDetails.getAuthorities())
        } else if (authentication.principal is OAuth2User) {
            val oauth2User = authentication.principal as OAuth2User
            model.addAttribute("username", oauth2User.getAttribute<Any>("name"))
            model.addAttribute("email", oauth2User.getAttribute<Any>("email"))
            model.addAttribute("authorities", oauth2User.getAuthorities())
        }

        // Add CSRF token
        val csrf = request.getAttribute(CsrfToken::class.java.name) as CsrfToken
        if (csrf != null) {
            model.addAttribute("csrf", csrf)
        }

        return "pages/dashboard"
    }
}