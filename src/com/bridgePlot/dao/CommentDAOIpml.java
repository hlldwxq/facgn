package com.bridgePlot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PlotComment;
@Repository
public class CommentDAOIpml implements CommentDAO{
	
	@Resource private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MoviePlotComment getMoviePlotCommentById(int id) {
		MoviePlotComment moviePlotComment = (MoviePlotComment)this.currentSession().createQuery("from MoviePlotComment where comment_id = ?")
				.setParameter(0, id)
				.uniqueResult();

		return moviePlotComment;
	}

	@Override
	public MovieRoleComment getMovieRoleCommentById(int id) {
		MovieRoleComment movieRoleComment = (MovieRoleComment)this.currentSession().createQuery("from MovieRoleComment where comment_id = ?")
				.setParameter(0, id)
				.uniqueResult();

		return movieRoleComment;
	}

	@Override
	public PlotComment getPlotCommentById(int id) {
		PlotComment plotComment = (PlotComment)this.currentSession().createQuery("from PlotComment where comment_id = ?")
				.setParameter(0, id)
				.uniqueResult();

		return plotComment;
	}

	@Override
	public List<MoviePlotComment> getMoviePlotCommentByUser(int userId) {
		@SuppressWarnings("unchecked")
		ArrayList<MoviePlotComment> moviePlotComment = (ArrayList<MoviePlotComment>)this.currentSession().createQuery("from MoviePlotComment where user_id = ?")
				.setParameter(0, userId);

		return moviePlotComment;
	}

	@Override
	public List<MovieRoleComment> getMovieRoleCommentByUser(int userId) {
		@SuppressWarnings("unchecked")
		ArrayList<MovieRoleComment> movieRoleComment = (ArrayList<MovieRoleComment>)this.currentSession().createQuery("from MovieRoleComment where user_id = ?")
				.setParameter(0, userId);

		return movieRoleComment;
	}

	@Override
	public List<PlotComment> getPlotCommentByUser(int userId) {
		@SuppressWarnings("unchecked")
		ArrayList<PlotComment> plotComment = (ArrayList<PlotComment>)this.currentSession().createQuery("from PlotComment where user_id = ?")
				.setParameter(0, userId);

		return plotComment;
	}

	@Override
	public void saveMoviePlotComment(MoviePlotComment moviePlotComment) {
		this.currentSession().save(moviePlotComment);
	}

	@Override
	public void saveMovieRoleComment(MovieRoleComment movieRoleComment) {
		this.currentSession().save(movieRoleComment);
	}

	@Override
	public void savePlotComment(PlotComment plotComment) {
		this.currentSession().save(plotComment);
	}
	
}
