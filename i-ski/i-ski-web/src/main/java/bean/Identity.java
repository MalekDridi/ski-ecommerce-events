package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.User;
import services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class Identity {
	private User user = new User();
	private boolean loggedIn = false;

	@EJB
	private UserServiceLocal userServiceLocal;

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServiceLocal.login(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			loggedIn = true;
			navigateTo = "/UserExperienceView?faces-redirect=true";

			// navigateTo = "/Feedback/ListTrades?faces-redirect=true";
			// navigateTo = "/NewFile?faces-redirect=true";

		} else {
			navigateTo = "/Accueil?faces-redirect=true";
			
			if (userLoggedIn.getUserType().equals("Admin")) {
				navigateTo = "/ListEventA?faces-redirect=true";
			} else if (userLoggedIn.getUserType().equals("User"))
				navigateTo = "/Accueil?faces-redirect=true";
			
			 else if (userLoggedIn.getUserType().equals("Organizer"))
					navigateTo = "/AccueilO?faces-redirect=true";
		} 
		

		return navigateTo;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
