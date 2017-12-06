package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bean.Identity;
import persistence.SkiTrip;
import services.SkiTripServiceLocal;

@ManagedBean
@ViewScoped
public class UserExprience {
	private List<SkiTrip> skiTrips;
	private SkiTrip skiTripSelected = new SkiTrip();
	private boolean showExerienceForm = false;

	@EJB
	private SkiTripServiceLocal skiTripServiceLocal;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	public void doShowExerienceForm() {
		showExerienceForm = true;
	}

	@PostConstruct
	private void init() {
		skiTrips = new ArrayList<SkiTrip>();
		skiTrips = skiTripServiceLocal.ifndSkiTripsByUser(identity.getUser());
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

}
