
package com.amdocs.training.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.implementation.FeedbackDAOImpl;
import com.amdocs.training.models.Course;
import com.amdocs.training.models.Feedback;

@Controller
public class FeedbackController {

	FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

	@GetMapping("/feedback-list")
	public String feedbackPage(Model model) {

		List<Feedback> feedbackList = feedbackDAO.findAll();
		model.addAttribute("list", feedbackList);
		return "feedbacks";
	}

	@GetMapping("/addFeedback")
	public String addFeedbackForm(Model model) {
		model.addAttribute("feedback", new Feedback(0, 0, "", "", ""));
		return "add-feedback";
	}

	@PostMapping("/registerFeedback")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback) {
		feedbackDAO.addFeedback(feedback);
		return "redirect:/feedback-list";
	}

	@GetMapping("/delete-feedback/{id}")
	public String deleteFeedback(@PathVariable("id") int id) {
		feedbackDAO.deleteFeedback(id);
		return "redirect:/feedback-list";
	}

	@GetMapping("/update-feedback/{id}")
	public String updateFeedbackForm(@PathVariable("id") int id, Model model) {
		Feedback feedback = feedbackDAO.getFeedbackById(id);
		model.addAttribute("feedback", feedback);
		return "update-feedback";
	}

	@PostMapping("/update-feedback")
	public String updateFeedback(@ModelAttribute("user") Feedback feedback) {
		feedbackDAO.updateFeedback(feedback);
		return "redirect:/feedback-list";
	}

}
