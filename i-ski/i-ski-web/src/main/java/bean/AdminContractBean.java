package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.Company;
import persistence.Contract;
import services.CompaniesServiceLocal;
import services.ContractServiceLocal;

@ManagedBean
@ViewScoped
public class AdminContractBean {
	
	private Date sdate;
	private Date edate;
	private int montant=0;
	private String etat;
	private String des;
	private boolean showDetails = false;
	private boolean showAmount = false;
	private Company com = new Company();
	private Contract cn = new Contract();
	private Contract cSelected = new Contract();
	private List<Contract> contracts = new ArrayList<>();
	@EJB
	ContractServiceLocal serviceContract ;
	@EJB
	CompaniesServiceLocal serviceInsurance ;
	
	@PostConstruct
	public void init() {
		contracts = serviceContract.findContractNonAvailble();
		}

	public void doSaveOrUpdate() {
		cSelected.setEtat("Valid");
		cSelected.setMontant(montant);
		serviceContract.updateC(cSelected);
		showDetails = false;
		init();
	}
	
	public boolean isShow() {
		return showDetails;
	}
	
	public void doCancel() {
		showDetails = false;
		showAmount = false;
	}
	
	public void doSelect() {
		showAmount = true;
		showDetails = true;
	}
	
	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public boolean isShowDetails() {
		return showDetails;
	}

	public void setShowDetails(boolean showDetails) {
		this.showDetails = showDetails;
	}

	public Company getCom() {
		return com;
	}

	public void setCom(Company com) {
		this.com = com;
	}

	public Contract getCn() {
		return cn;
	}

	public void setCn(Contract cn) {
		this.cn = cn;
	}

	public Contract getcSelected() {
		return cSelected;
	}

	public void setcSelected(Contract cSelected) {
		this.cSelected = cSelected;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public boolean isShowAmount() {
		return showAmount;
	}

	public void setShowAmount(boolean showAmount) {
		this.showAmount = showAmount;
	}
	
	
	
}
