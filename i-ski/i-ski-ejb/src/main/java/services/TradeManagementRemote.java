package services;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import persistence.Trade;
import persistence.User;

@Remote
@WebService
public interface TradeManagementRemote {
	// eli bsh yaamel Request

	void addTradeRequest(Trade trade);

	void deleteTradeRequestById(int id);

	void deleteTradeRequest(Trade trade);

	List<Trade> findAllMyRequests(int user);

	// zouz
	List<Trade> findAllMyAcceptedTrades();

	List<Trade> findAllMyDeclinedTrades();

	List<Trade> findAllMyTrades(User user);

	Trade findTradeById(int id);

	void updateTradeRequest(Trade trade);

	void acceptRequest(Trade trade);

}
