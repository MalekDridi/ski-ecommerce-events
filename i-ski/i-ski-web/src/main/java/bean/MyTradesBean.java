package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import persistence.Feedback;
import persistence.Trade;
import services.FeedbackReportManagementLocal;
import services.TradeManagementLocal;

@ManagedBean
@ViewScoped
public class MyTradesBean {
	private Trade tradeSelected = new Trade();
	private List<Trade> MyTrades = new ArrayList<>();
	private List<Trade> MyTrades2 = new ArrayList<>();

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
		Feedback feedback = new Feedback();
		feedbackReportManagementLocal.addFeedback(feedback);

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

}
