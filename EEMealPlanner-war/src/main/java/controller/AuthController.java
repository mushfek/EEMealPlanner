package controller;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/16/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@SessionScoped
public class AuthController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private User user;
    private HttpSession session;
    private FacesContext facesContext;
    private ExternalContext externalContext;

    @EJB
    private UserService userService;

    @PostConstruct
    public void startUp() {
        logger.debug("User before construction: " + user);
        if (user == null) {
            user = new User();
        }
        logger.debug("User after construction: " + user);
    }

    public String home() {
        if (user != null) {
            user = userService.loginService(user);
            logger.debug("User Details: " + user);

            if (user != null) {
                facesContext = facesContext.getCurrentInstance();
                externalContext = facesContext.getExternalContext();
                session = (HttpSession) externalContext.getSession(true);
                session.setAttribute("user", user);
                return "home.xhtml?faces-redirect=true";
            } else {
                return "index.xhtml?faces-redirect=true";
            }
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String logout() {
        if (user != null) {
            session.removeAttribute("user");
            session.invalidate();
            return "index.xhtml?faces-redirect=true";
        }
        return "index.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
