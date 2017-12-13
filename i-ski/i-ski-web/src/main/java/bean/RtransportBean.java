package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import services.RTransportLocal;
import persistence.*;

@ManagedBean
@ViewScoped
public class RtransportBean {
	 private String placeRech ;
	 private String MoyenRech ;
	 private List<Transport>transportsFound = new ArrayList<>();

	
	static Transport TranspReservSelected = new Transport();
	private List<Transport> MyRtransports = new ArrayList<>();
	private List<Transport>transportsByUser = new ArrayList<>();
	private List<String> check = new ArrayList<>();

	static Transport selectedTransport = new Transport();
	
	static boolean view_update = false ;

	private boolean showMyReservationTransportList = false;
	private PieChartModel pieModel1;
	

	@EJB
	RTransportLocal rtl;

	
	@ManagedProperty(value="#{identity}")
	private Identity identity;
	
	
	
	
	public void doDeleteMyTransportReservation(Transport t){
		rtl.deleteRtransport(t);
		transportsByUser= rtl.findRTransportByUser(identity.getUser());
	
	}
	


	public void doShowMyTransportReservation () {
		//System.out.println("list  :::::::::::::::"+rtl .findAll().size());
		setMyRtransports(transportsByUser);
	}
	
	
	
	@PostConstruct
	public void init(){
		
		MyRtransports = rtl.findAll();
		transportsByUser= rtl.findRTransportByUser(identity.getUser());
		TranspReservSelected.setUser(identity.getUser());
		
		if(MyRtransports != null){
			pieModel1 = new PieChartModel();
			traceStat();
		}
	}
	
	
	
	public String doAddReservationTransport(){
		
		rtl.add(TranspReservSelected);
		return "/ShowRTransport?faces-redirect=true";
		
		
	}
	
	
	
	public String goToUpdate(Transport t){
		view_update = true;
		TranspReservSelected = t;
		return "/AddReservation?faces-redirect=true";
	}
	
	
	public String doUpdateMyTransportReservation(){
		 
		 rtl.update(TranspReservSelected);
		 view_update = false;
		 return "/ShowRTransport?faces-redirect=true";
	}
	
	
	public List<Transport> getMyRtransports() {
		return MyRtransports;
	}
	public void setMyRtransports(List<Transport> myRtransports) {
		MyRtransports = myRtransports;
	}
	public boolean isShowMyReservationTransportList() {
		return showMyReservationTransportList;
	}
	public void setShowMyReservationTransportList(boolean showMyReservationTransportList) {
		this.showMyReservationTransportList = showMyReservationTransportList;
	}
	public Transport getTranspReservSelected() {
		return TranspReservSelected;
	}
	public void setTranspReservSelected(Transport transpReservSelected) {
		TranspReservSelected = transpReservSelected;
	}
	public RTransportLocal getRtl() {
		return rtl;
	}
	public void setRtl(RTransportLocal rtl) {
		this.rtl = rtl;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public List<Transport> getTransportsByUser() {
		return transportsByUser;
	}
	public void setTransportsByUser(List<Transport> transportsByUser) {
		this.transportsByUser = transportsByUser;
	}

	public static Transport getSelectedTransport() {
		return selectedTransport;
	}

	public static void setSelectedTransport(Transport selectedTransport) {
		RtransportBean.selectedTransport = selectedTransport;
	}

	public boolean isView_update() {
		return view_update;
	}

	public void setView_update(boolean view_update) {
		this.view_update = view_update;
	}



	public PieChartModel getPieModel1() {
		return pieModel1;
	}



	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}



	public List<String> getCheck() {
		return check;
	}



	public void setCheck(List<String> check) {
		this.check = check;
	}



	public int calculTransport (String s){
		
		int nbr=0 ;
		boolean b = true;
		
		for (String tmp : check) {
			if(tmp.compareTo(s) == 0)
				b=false;
		}
		if(b){
			
			for (Transport t : MyRtransports) {
				if(t.getMoyenTransport().compareTo(s) == 0)
					nbr++;
			}
		}
		return nbr;
	}
	
	
	public void traceStat(){
		for (Transport t : MyRtransports) {
			
			if(calculTransport(t.getMoyenTransport()) > 0){			
				
				pieModel1.set(t.getMoyenTransport(), calculTransport(t.getMoyenTransport()));
				check.add(t.getMoyenTransport());
			}	
		}
		pieModel1.setTitle("Most used means of transport");
        pieModel1.setLegendPosition("e");
        pieModel1.setFill(false);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(600);        
	}


       public String doSearch(){
    	  
    	   transportsFound =rtl.findTransByParams(MoyenRech, placeRech);
		System.out.println(transportsFound);
		System.out.println(transportsFound.size());
		return "/searchResult?faces-redirect=true";
		
		
	}
	

	public String getPlaceRech() {
		return placeRech;
	}



	public void setPlaceRech(String placeRech) {
		this.placeRech = placeRech;
	}



	public String getMoyenRech() {
		return MoyenRech;
	}



	public void setMoyenRech(String moyenRech) {
		MoyenRech = moyenRech;
	}



	public List<Transport> getTransportsFound() {
		return transportsFound;
	}



	public void setTransportsFound(List<Transport> transportsFound) {
		this.transportsFound = transportsFound;
	}

}
