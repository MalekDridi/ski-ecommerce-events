package persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Report
 *
 */
@Entity

public class Report implements Serializable {

	@EmbeddedId
	private ReportPk reportPk;
	private String reason;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idTrade", referencedColumnName = "idTrade", insertable = false, updatable = false)
	private Trade trade;
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
	}   
	
	 
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ReportPk getReportPk() {
		return reportPk;
	}

	public void setReportPk(ReportPk reportPk) {
		this.reportPk = reportPk;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
   
}
