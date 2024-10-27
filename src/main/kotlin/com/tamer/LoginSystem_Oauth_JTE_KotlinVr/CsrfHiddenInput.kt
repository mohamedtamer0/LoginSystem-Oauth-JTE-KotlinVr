package com.tamer.LoginSystem_Oauth_JTE_KotlinVr

import gg.jte.Content
import gg.jte.TemplateOutput
import org.springframework.security.web.csrf.CsrfToken

class CsrfHiddenInput(private val csrfToken: CsrfToken?) : Content {
    override fun writeTo(templateOutput: TemplateOutput) {
        if (this.csrfToken != null) {
            templateOutput.writeContent(
                "<input type=\"hidden\" name=\"%s\" value=\"%s\">"
                    .formatted(csrfToken.parameterName, csrfToken.token)
            )
        }
    }
}