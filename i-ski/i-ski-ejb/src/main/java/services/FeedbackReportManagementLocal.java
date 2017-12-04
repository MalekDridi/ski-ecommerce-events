package services;

import javax.ejb.Local;

import persistence.Feedback;

@Local
public interface FeedbackReportManagementLocal {

	void addFeedback(Feedback feedback);

}
