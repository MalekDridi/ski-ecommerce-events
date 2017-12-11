package ctr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import bean.Identity;
import persistence.ReviewUserExperience;
import persistence.SkiTrip;
import persistence.UserExperience;
import services.SkiTripServiceLocal;
import services.UserExperienceServiveLocal;
import utilities.DirecoryInitializer;

@ManagedBean
@ViewScoped
public class UserExprience {
	private UserExperience userExperienceSelected = new UserExperience();;
	private List<UserExperience> userExpriences;
	private List<SkiTrip> skiTrips;
	private SkiTrip skiTripSelected = new SkiTrip();
	private boolean showExerienceForm = false;
	private boolean likeRender = false;
	private boolean disLikeRender = false;
	private String description;
	private int rate;
	private String imgPath;
	private String img;

	private UploadedFile uploadedfile;
	private StreamedContent file;

	private Integer rating3;

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
			userExperienceServiveLocal.reviewUserExperience(identity.getUser(), userExperienceSelected,
					ReviewUserExperience.LIKE);
			likeRender = true;
			disLikeRender = true;
		} else {
			userExperienceServiveLocal.reviewUserExperience(identity.getUser(), userExperienceSelected,
					ReviewUserExperience.DISLIKE);
			disLikeRender = true;
			likeRender = true;
		}

	}

	public String doShareExpeience() {
		userExperienceServiveLocal.saveUserExperience(identity.getUser(), skiTripSelected, description, rate, imgPath);
		return "experiencesWall?face-redirect=true";
	}

	public void doRemoveExperience() {
		userExperienceServiveLocal.delete(userExperienceSelected);
		init();
	}

	public void upload(FileUploadEvent event) {

		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		// try {
		// //copyFile(event.getFile().getFileName(),
		// event.getFile().getInputstream());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}

	public void copyFile(FileUploadEvent event) {
		uploadedfile = event.getFile();
		String shortImagePath = UUID.randomUUID().toString() + ".jpg";
		if (uploadedfile != null && uploadedfile.getContents() != null) {

			try {
				byte[] contents = uploadedfile.getContents();

				// write the inputStream to a FileOutputStream
				FileOutputStream fos = new FileOutputStream(DirecoryInitializer.IMAGE_DIR + "/" + shortImagePath);
				fos.write(contents);
				fos.close();
				imgPath = shortImagePath;
				setImg(imgPath);

			} catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
	}

	public void onrate(RateEvent rateEvent) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ISki Experience Rate",
				"You rated:" + ((Integer) rateEvent.getRating()).intValue());
		FacesContext.getCurrentInstance().addMessage(null, message);
		rating3 = ((Integer) rateEvent.getRating()).intValue();
		rate = rating3;
		setRate(rate);
	}

	public void oncancel() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public Integer getRating3() {
		return rating3;
	}

	public void setRating3(Integer rating3) {
		this.rating3 = rating3;
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

	public boolean isLikeRender() {
		return likeRender;
	}

	public void setLikeRender(boolean likeRender) {
		this.likeRender = likeRender;
	}

	public boolean isDisLikeRender() {
		return disLikeRender;
	}

	public void setDisLikeRender(boolean disLikeRender) {
		this.disLikeRender = disLikeRender;
	}

	public UploadedFile getUploadedfile() {
		return uploadedfile;
	}

	public void setUploadedfile(UploadedFile uploadedfile) {
		this.uploadedfile = uploadedfile;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
