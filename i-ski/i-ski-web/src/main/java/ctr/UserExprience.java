package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bean.Identity;
import persistence.ReviewUserExperience;
import persistence.SkiTrip;
import persistence.UserExperience;
import services.SkiTripServiceLocal;
import services.UserExperienceServiveLocal;

@ManagedBean
@ViewScoped
public class UserExprience {
	private UserExperience userExperienceSelected = new UserExperience();;
	private List<UserExperience> userExpriences;
	private List<SkiTrip> skiTrips;
	private SkiTrip skiTripSelected = new SkiTrip();
	private boolean showExerienceForm = false;
	private String description;
	private int rate;
	@EJB
	private UserExperienceServiveLocal userExperienceServiveLocal;
	@EJB
	private SkiTripServiceLocal skiTripServiceLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public void doShowExerienceForm() {
		showExerienceForm = true;
	}

	public void doReview(String reviewUserExperience) {
		if (reviewUserExperience.equals("LIKE")) {
			userExperienceServiveLocal.reviewUserExperience(userExperienceSelected, ReviewUserExperience.LIKE);
		} else {
			userExperienceServiveLocal.reviewUserExperience(userExperienceSelected, ReviewUserExperience.DISLIKE);
		}

	}

	public String doShareExpeience() {
		userExperienceServiveLocal.saveUserExperience(identity.getUser(), skiTripSelected, description, rate);
		return "experiencesWall?face-redirect=true";
	}

	@PostConstruct
	private void init() {
		skiTrips = new ArrayList<SkiTrip>();
		skiTrips = skiTripServiceLocal.ifndSkiTripsByUser(identity.getUser());
		userExpriences = userExperienceServiveLocal.findAll();
	}

	public List<SkiTrip> getSkiTrips() {
		return skiTrips;
	}

	public void setSkiTrips(List<SkiTrip> skiTrips) {
		this.skiTrips = skiTrips;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public SkiTrip getSkiTripSelected() {
		return skiTripSelected;
	}

	public void setSkiTripSelected(SkiTrip skiTripSelected) {
		this.skiTripSelected = skiTripSelected;
	}

	public boolean isShowExerienceForm() {
		return showExerienceForm;
	}

	public void setShowExerienceForm(boolean showExerienceForm) {
		this.showExerienceForm = showExerienceForm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public List<UserExperience> getUserExpriences() {
		return userExpriences;
	}

	public void setUserExpriences(List<UserExperience> userExpriences) {
		this.userExpriences = userExpriences;
	}

	public UserExperience getUserExperienceSelected() {
		return userExperienceSelected;
	}

	public void setUserExperienceSelected(UserExperience userExperienceSelected) {
		this.userExperienceSelected = userExperienceSelected;
	}

}
