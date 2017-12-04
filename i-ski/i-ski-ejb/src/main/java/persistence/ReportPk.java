package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: ReportPk
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ReportPk implements Serializable {

	private int idTrade;
	private int idUser;
	@Temporal(TemporalType.DATE)
	private Date reportDate;
	private static final long serialVersionUID = 1L;

	public ReportPk() {
		super();
	}

	public int getIdTrade() {
		return this.idTrade;
	}

	public void setIdTrade(int idTrade) {
		this.idTrade = idTrade;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTrade;
		result = prime * result + idUser;
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportPk other = (ReportPk) obj;
		if (idTrade != other.idTrade)
			return false;
		if (idUser != other.idUser)
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		return true;
	}

}
