package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import persistence.Trade;
import persistence.User;

@Remote
@WebService
public interface TradeManagementRemote {
	// eli bsh yaamel Request

	@WebMethod
	@WebResult

	void addTradeRequest(Trade trade);

	@WebMethod(operationName = "delete")
	@WebResult(name = "res")
	void deleteTradeRequestById(int id);

	@WebMethod(operationName = "delete2")
	@WebResult(name = "res")
	void deleteTradeRequest(Trade trade);

	@WebMethod(operationName = "findmyrequests")
	@WebResult(name = "list")
	List<Trade> findAllMyRequests(int user);

	// zouz
	@WebMethod(operationName = "findmyacceptedrequests")
	@WebResult(name = "list")
	List<Trade> findAllMyAcceptedTrades();

	@WebMethod(operationName = "findmydeclinedrequests")
	@WebResult(name = "list")
	List<Trade> findAllMyDeclinedTrades();

	@WebMethod(operationName = "findmytrades")
	@WebResult(name = "list")
	List<Trade> findAllMyTrades(User user);

	@WebMethod(operationName = "findtradebyid")
	@WebResult(name = "dd")
	Trade findTradeById(int id);

	@WebMethod(operationName = "updatetraderequest")
	@WebResult(name = "dd")

	void updateTradeRequest(Trade trade);

	@WebMethod(operationName = "acceptrequest")
	@WebResult(name = "accept")

	void acceptRequest(Trade trade);

}
