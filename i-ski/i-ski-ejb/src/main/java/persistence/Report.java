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

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReport;
	private Date dateReport;
	private String reason;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "report")
	private List<Trade> trades;
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
	}   
	public int getIdReport() {
		return this.idReport;
	}

	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}   
	public Date getDateReport() {
		return this.dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}   
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
   
}
