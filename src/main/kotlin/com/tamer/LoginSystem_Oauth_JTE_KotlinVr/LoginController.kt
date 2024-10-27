package com.tamer.LoginSystem_Oauth_JTE_KotlinVr

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class LoginController {

    @GetMapping("/login")
    fun login(request: HttpServletRequest?, model: Model, error: String?, logout: String?): String {
        if (error != null) {
            model.addAttribute("error", true)
            model.addAttribute("errorMessage", "Invalid username or password")
        }

        return "pages/login"
    }

    @GetMapping("/")
    fun home(): String {
        return "pages/home"
    }
}