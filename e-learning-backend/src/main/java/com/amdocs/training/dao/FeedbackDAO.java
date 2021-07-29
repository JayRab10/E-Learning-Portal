package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.models.Feedback;

public interface FeedbackDAO {
	
	List<Feedback> findAll();

	boolean addFeedback(Feedback feedback);

	Feedback getFeedbackById(Integer id);

	boolean deleteFeedback(Integer id);
	
	boolean updateFeedback(Feedback feedback);
	
}
