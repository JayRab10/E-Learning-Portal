package com.amdocs.training.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.db.DatabaseConnection;
import com.amdocs.training.models.Feedback;
import com.amdocs.training.models.User;

public class FeedbackDAOImpl implements FeedbackDAO {

	private Statement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;

	@Override
	public List<Feedback> findAll() {
		List<Feedback> feedbacks = new ArrayList<>();
		String sql = "select * from feedback";

		try {
			conn = DatabaseConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		int feedbackId = 0;
		int userId = 0;
		String userName = null;
		String email = null;
		String feedbackMessage = null;

		try {
			while (rs.next()) {

				feedbackId = rs.getInt("feedback_id");
				userId = rs.getInt("user_id");
				userName = rs.getString("user_name");
				email = rs.getString("email");
				feedbackMessage = rs.getString("feedback_message");

				Feedback feedback = new Feedback(feedbackId, userId, userName, email, feedbackMessage);
				feedbacks.add(feedback);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		return feedbacks;
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		String sql = "insert into feedback values (?,?,?,?,?)";

		int executeUpdate = 0;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, feedback.getFeedbackID());
			ps.setInt(2, feedback.getUserID());
			ps.setString(3, feedback.getUserName());
			ps.setString(4, feedback.getEmail());
			ps.setString(5, feedback.getFeedbackMessage());
			executeUpdate = ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (executeUpdate > 0) {
			System.out.println("Feedback Inserted Successfully!");
			return true;
		} else
			System.out.println("Opps , please try again!");

		return false;
	}

	@Override
	public Feedback getFeedbackById(Integer id) {
		String sql = "select * from feedback where feedback_id = ? ";
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		int feedbackId = 0;
		int userId = 0;
		String userName = null;
		String email = null;
		String feedbackMessage = null;

		try {
			if (rs.next()) {

				feedbackId = rs.getInt("feedback_id");
				userId = rs.getInt("user_id");
				userName = rs.getString("user_name");
				email = rs.getString("email");
				feedbackMessage = rs.getString("feedback_message");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Feedback(feedbackId, userId, userName, email, feedbackMessage);

	}

	@Override
	public boolean deleteFeedback(Integer id) {
		String sql = "delete from feedback where feedback_id = ? ";
		int executeUpdate = 0;
		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (executeUpdate > 0) {
			System.out.println(" Feedback Deleted Succesfully!");
		} else
			System.out.println("try Again!");

		return false;
	}

	@Override
	public boolean updateFeedback(Feedback feedback) {
		String sql = "update feedback set user_id = ?, user_name = ? , email = ? , feedback_message = ?  where feedback_id = ?";
		int executeUpdate = 0;

		try {
			conn = DatabaseConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, feedback.getUserID());
			ps.setString(2, feedback.getUserName());
			ps.setString(3, feedback.getEmail());
			ps.setString(4, feedback.getFeedbackMessage());
			ps.setInt(5, feedback.getFeedbackID());
			executeUpdate = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (executeUpdate > 0) {
			System.out.println("Feedback Updated Succesfully!!");
		} else
			System.out.println("try Again!");

		return false;
	}

	public void print(List<Feedback> feedbacks) {
		for (Feedback feedback : feedbacks) {
			System.out.println(feedback.toString());
		}
	}

}
