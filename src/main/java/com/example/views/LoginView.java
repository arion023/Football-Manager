package com.example.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import static com.example.model.utils.CssValues.CSS_FONT_SIZE;

@Route("/login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginView extends VerticalLayout {

    public LoginView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 heading = new H1("You have to log in to access this page");
        heading.getStyle()
                .set(CSS_FONT_SIZE, "var(--lumo-font-size-l)")
                .set("margin", "100");

        Anchor googleLoginLink = new Anchor("/oauth2/authorization/google", "Login with google");
        googleLoginLink.getElement().setAttribute("router-ignore", true);
        googleLoginLink.getStyle()
                .set(CSS_FONT_SIZE, "var(--lumo-font-size-l)");
        add(heading, googleLoginLink);
    }
}
