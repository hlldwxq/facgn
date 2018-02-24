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
		MoviePlotComment moviePlotComment = (MoviePlotComment)this.currentSession().createQuery("from MoviePlotComment where id = ?")
				.setParameter(0, id)
				.uniqueResult();

		return moviePlotComment;
	}

	@Override
	public MovieRoleComment getMovieRoleCommentById(int id) {
		MovieRoleComment movieRoleComment = (MovieRoleComment)this.currentSession().createQuery("from MovieRoleComment where id = ?")
				.setParameter(0, id)
				.uniqueResult();

		return movieRoleComment;
	}

	@Override
	public PlotComment getPlotCommentById(int id) {
		PlotComment plotComment = (PlotComment)this.currentSession().createQuery("from PlotComment where id = ?")
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

	@Override
	public void addLikeMoviePlot(int moviePlotCommentId) {
		this.currentSession().createQuery("update MoviePlotComment as p set p.like = p.like+1 where p.id=?")
		.setParameter(0, moviePlotCommentId)
		.executeUpdate();
		
	}

	@Override
	public void addLikeMovieRole(int movieRoleCommentId) {
		this.currentSession().createQuery("update MovieRoleComment as p set p.like = p.like+1 where p.id=?")
		.setParameter(0, movieRoleCommentId)
		.executeUpdate();
	}

	@Override
	public void addLikePlot(int plotCommentId) {
		this.currentSession().createQuery("update PlotComment as p set p.like_tick = p.like+1 where p.id=?")
		.setParameter(0, plotCommentId)
		.executeUpdate();
	}

	@Override
	public void reduceLikeMoviePlot(int moviePlotCommentId) {
		this.currentSession().createQuery("update MoviePlotComment as p set p.like = p.lik-1 where p.id=?")
		.setParameter(0, moviePlotCommentId)
		.executeUpdate();
	}

	@Override
	public void reduceLikeMovieRole(int movieRoleCommentId) {
		this.currentSession().createQuery("update MovieRoleComment as p set p.like = p.like-1 where p.id=?")
		.setParameter(0, movieRoleCommentId)
		.executeUpdate();
	}

	@Override
	public void reduceLikePlot(int plotCommentId) {
		this.currentSession().createQuery("update PlotComment as p set p.like = p.like-1 where p.id=?")
		.setParameter(0, plotCommentId)
		.executeUpdate();
	}

	@Override
	public List<MoviePlotComment> getMoviePlotCommByPage(int pageNum,int moviePlotId) {
		int commentNum = 4;
		@SuppressWarnings("unchecked")
		List<MoviePlotComment> moviePlotComment = (List<MoviePlotComment>)this.currentSession().createQuery("from MoviePlotComment as c where movie_plot_id=? order by c.like desc")
										.setParameter(0, moviePlotId)
										.setFirstResult(pageNum*commentNum)
						        		.setMaxResults(commentNum)
						        		.list();
		return moviePlotComment;
	}

	@Override
	public List<PlotComment> getPlotCommByPage(int pageNum,int plotId) {
		int commentNum = 4;
		@SuppressWarnings("unchecked")
		List<PlotComment> plotComment = (List<PlotComment>)this.currentSession().createQuery("from PlotComment as c where plot_id=? order by c.like desc")
										.setParameter(0, plotId)
										.setFirstResult(pageNum*commentNum)
						        		.setMaxResults(commentNum)
						        		.list();
		return plotComment;
	}

	@Override
	public List<MovieRoleComment> getMovieRoleCommByPage(int pageNum,int movieRoleId) {
		int commentNum = 4;
		@SuppressWarnings("unchecked")
		List<MovieRoleComment> movieRoleComment = (List<MovieRoleComment>)this.currentSession().createQuery("from MovieRoleComment as c where role_id=? order by c.like desc")
										.setParameter(0, movieRoleId)
										.setFirstResult(pageNum*commentNum)
						        		.setMaxResults(commentNum)
						        		.list();
		return movieRoleComment;
	}

	@Override
	public int getMoviePlotCommentCountById(int id) {
		int count = (int)this.currentSession().createQuery("select count(*) from MoviePlotComment where movie_plot_id = ?")
							.setParameter(0, id)
			                .uniqueResult();
		return count;
	}

	@Override
	public int getPlotCommentCountById(int id) {
		int count = (int)this.currentSession().createQuery("select count(*) from MovieRoleComment where plot_id = ?")
							.setParameter(0, id)
			                .uniqueResult();
		return count;
	}

	@Override
	public int getMovieRoleCommentCountById(int id) {
		int count = (int)this.currentSession().createQuery("select count(*) from MovieRoleComment where movie_role_id = ?")
							.setParameter(0, id)
			                .uniqueResult();
		return count;
	}

}
