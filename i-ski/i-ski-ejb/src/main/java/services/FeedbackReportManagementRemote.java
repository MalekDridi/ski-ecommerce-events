package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.Equipment;
import persistence.Feedback;

@Remote
public interface FeedbackReportManagementRemote {

	void addFeedback(Feedback feedback);

}
