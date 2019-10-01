package pl.fiewicz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.fiewicz.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private HttpSession httpSession;


    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        String username = "";

        if(authentication.getPrincipal() instanceof Principal){
            username = ((Principal) authentication.getPrincipal()).getName();
        }else {
             username = ((User) authentication.getPrincipal()).getUsername();
        }

        httpSession.setAttribute("userId",username);
        httpServletResponse.sendRedirect("/user");
    }
}
