package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Feedback;

/**
 * Session Bean implementation class FeedbackReportManagement
 */
@Stateless
public class FeedbackReportManagement implements FeedbackReportManagementRemote, FeedbackReportManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public FeedbackReportManagement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFeedback(Feedback feedback) {
		entityManager.persist(feedback);
	}

}
