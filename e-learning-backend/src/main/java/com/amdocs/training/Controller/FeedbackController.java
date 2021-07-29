package com.amdocs.training.Controller;

import java.util.List;

import com.amdocs.training.dao.implementation.FeedbackDAOImpl;
import com.amdocs.training.models.Feedback;

public class FeedbackController {
	
	public static void main(String[] args) {
		FeedbackDAOImpl feedbackDAO = new FeedbackDAOImpl();
		
		// find all feedbacks
		List<Feedback> feedbacks = feedbackDAO.findAll();
		feedbackDAO.print(feedbacks);
		
		// add feedback
		//Feedback feedback = new Feedback(13, 100, "jayendra Sthapak", "jayendrasthapak@gmail.com", "Amazing");
		//feedbackDAO.addFeedback(feedback);
		
		// get feedback by id
		//Feedback feedback = feedbackDAO.getFeedbackById(12);
		//System.out.println(feedback.toString());
		
		// delete feedback
		//feedbackDAO.deleteFeedback(12);
		
		// update feedback
		//Feedback feedback = new Feedback(11, 100, "jayendra Sthapak", "jayendrasthapak@gmail.com", "worst");
		//feedbackDAO.updateFeedback(feedback);
	}
	
}
