package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.Company;
import persistence.Contract;
import persistence.ContractPk;
import services.CompaniesServiceLocal;
import services.ContractServiceLocal;

@ManagedBean
@SessionScoped
public class ContractBean {
	
	private Date sdate;
	private Date edate;
	private int montant;
	private String etat;
	private String des;
	private boolean showDetails = false;
	private Company com = new Company();
	private Contract cn = new Contract();
	private Company cSelected = new Company();
	private int idCompanySelected;
	private List<Company> companies = new ArrayList<>();
	@EJB
	ContractServiceLocal serviceContract ;
	@EJB
	CompaniesServiceLocal serviceInsurance ;
	
	@PostConstruct
	public void init() {
		companies = serviceInsurance.findAllCompanies();
		}
	
	public void doSelect() {
		showDetails = true;
	}

	public void doCancel() {
		showDetails = false;
	}

	public void doSigneContract() {
		int a = 1;
	
		serviceContract.SigneContract(sdate,edate,00,des,a,cSelected.getIdCompany(),"nonValid");
		showDetails = false;
	}

	public Company getcSelected() {
		return cSelected;
	}

	public void setcSelected(Company cSelected) {
		this.cSelected = cSelected;
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

	public int getIdCompanySelected() {
		return idCompanySelected;
	}

	public void setIdCompanySelected(int idCompanySelected) {
		this.idCompanySelected = idCompanySelected;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}


}
