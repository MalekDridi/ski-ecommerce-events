package services;

import java.util.List;

import javax.ejb.Local;

import persistence.Trade;
import persistence.User;

@Local
public interface TradeManagementLocal {
	// eli bsh yaamel Request

	void addTradeRequest(Trade trade);

	void deleteTradeRequestById(int id);

	void deleteTradeRequest(Trade trade);

	List<Trade> findAllMyRequests();

	// zouz

	List<Trade> findAllMyAcceptedTrades();

	List<Trade> findAllMyDeclinedTrades();

	Trade findTradeById(int id);

	void updateTradeRequest(Trade trade);

	List<Trade> findAllMyTrades(User user);
	void acceptRequest(Trade trade);


}
