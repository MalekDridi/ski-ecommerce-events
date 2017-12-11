package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Feedback;
import persistence.FeedbackPk;
import persistence.Trade;
import persistence.User;
import services.FeedbackReportManagementLocal;
import services.TradeManagementLocal;

@ManagedBean
@ViewScoped
public class MyTradesBean {
	private Trade tradeSelected = new Trade();
	private List<Trade> MyTrades = new ArrayList<>();
	private List<Trade> MyTrades2 = new ArrayList<>();
	private Date dateOfFeedback;
	private String description;

	private boolean showMyTradesList = false;
	@ManagedProperty(value = "#{identity}")
	private Identity identity;

	@EJB
	TradeManagementLocal tradeManagementLocal;
	@EJB
	FeedbackReportManagementLocal feedbackReportManagementLocal;

	@PostConstruct
	public void doShowMyTrades() {
		MyTrades = tradeManagementLocal.findAllMyTrades(identity.getUser());
		// setMyTrades(tradeManagementLocal.findAllMyTrades(identity.getUser()));
	}

	public void doShowMyTrades2() {
		MyTrades = tradeManagementLocal.findAllMyRequests();
	}

	public void doSelect() {
		showMyTradesList = true;
	}

	public void doAddFeedback() {
		
		//User user = identity.getUser();
		FeedbackPk feedbackPk = new FeedbackPk(tradeSelected, identity.getUser());
		dateOfFeedback = new Date();
		// Feedback feedback = new Feedback(description, dateOfFeedback, user, trade);
		Feedback feedback = new Feedback(feedbackPk, description, dateOfFeedback, identity.getUser(), tradeSelected);
		feedbackReportManagementLocal.addFeedback(feedback);
		showMyTradesList = false;
	}

	public Trade getTradeSelected() {
		return tradeSelected;
	}

	public void setTradeSelected(Trade tradeSelected) {
		this.tradeSelected = tradeSelected;
	}

	public List<Trade> getMyTrades() {
		return MyTrades;
	}

	public void setMyTrades(List<Trade> myTrades) {
		MyTrades = myTrades;
	}

	public boolean isShowMyTradesList() {
		return showMyTradesList;
	}

	public void setShowMyTradesList(boolean showMyTradesList) {
		this.showMyTradesList = showMyTradesList;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public FeedbackReportManagementLocal getFeedbackReportManagementLocal() {
		return feedbackReportManagementLocal;
	}

	public void setFeedbackReportManagementLocal(FeedbackReportManagementLocal feedbackReportManagementLocal) {
		this.feedbackReportManagementLocal = feedbackReportManagementLocal;
	}

	public List<Trade> getMyTrades2() {
		return MyTrades2;
	}

	public void setMyTrades2(List<Trade> myTrades2) {
		MyTrades2 = myTrades2;
	}

	public Date getDateOfFeedback() {
		return dateOfFeedback;
	}

	public void setDateOfFeedback(Date dateOfFeedback) {
		this.dateOfFeedback = dateOfFeedback;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
