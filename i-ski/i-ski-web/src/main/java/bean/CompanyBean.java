package bean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import persistence.Company;
import services.CompaniesServiceLocal;

@ManagedBean
@SessionScoped
@ViewScoped
public class CompanyBean {
	
	private Company com = new Company();
	private List<Company> companies = new ArrayList<>();
	private boolean showCompanies = true ;
	
	@EJB
	CompaniesServiceLocal serviceInsurance ;
	
	@PostConstruct
	public void init() {
		companies = serviceInsurance.findAllCompanies();
		}
	
	public void doShowCompaniesList (){
		showCompanies= true;
	}

	public Company getCom() {
		return com;
	}

	public void setCom(Company com) {
		this.com = com;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public boolean isShowCompanies() {
		return showCompanies;
	}

	public void setShowCompanies(boolean showCompanies) {
		this.showCompanies = showCompanies;
	}
	
	
	
	

}
