package com.bridgePlot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgePlot.dao.CommentDAO;
import com.bridgePlot.dao.UserDAO;
import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PageBean;
import com.bridgePlot.entity.PlotComment;
import com.bridgePlot.entity.SimpleComment;
import com.bridgePlot.entity.User;

@Service
public class CommentServiceImpl implements CommentService{

	@Resource private CommentDAO commentDao;
	@Resource private UserDAO userDao;
	
	@Override
	public MoviePlotComment getMoviePlotCommentById(int id) {
		return commentDao.getMoviePlotCommentById(id);
	}

	@Override
	public MovieRoleComment getMovieRoleCommentById(int id) {
		return commentDao.getMovieRoleCommentById(id);
	}

	@Override
	public PlotComment getPlotCommentById(int id) {
		return commentDao.getPlotCommentById(id);
	}

	@Override
	public List<MoviePlotComment> getMoviePlotCommentByUser(int userId) {
		return commentDao.getMoviePlotCommentByUser(userId);
	}

	@Override
	public List<MovieRoleComment> getMovieRoleCommentByUser(int userId) {
		return commentDao.getMovieRoleCommentByUser(userId);
	}

	@Override
	public List<PlotComment> getPlotCommentByUser(int userId) {
		return commentDao.getPlotCommentByUser(userId);
	}

	@Override
	public void saveMoviePlotComment(MoviePlotComment moviePlotComment,int userId) {
		Date edit_time = new Date();
		moviePlotComment.setDate(edit_time);
		moviePlotComment.setUser_id(userId);
		moviePlotComment.setLike(0);
		commentDao.saveMoviePlotComment(moviePlotComment);
	}

	@Override
	public void saveMovieRoleComment(MovieRoleComment movieRoleComment,int userId) {
		Date edit_time = new Date();
		movieRoleComment.setDate(edit_time);
		movieRoleComment.setUser_id(userId);
		movieRoleComment.setLike(0);
		commentDao.saveMovieRoleComment(movieRoleComment);
	}

	@Override
	public void savePlotComment(PlotComment plotComment,int userId) {
		Date edit_time = new Date();
		plotComment.setDate(edit_time);
		plotComment.setUser_id(userId);
		plotComment.setLike(0);
		commentDao.savePlotComment(plotComment);
	}

	@Override
	public void addLikeMoviePlot(int moviePlotCommentId) {
		commentDao.addLikeMoviePlot(moviePlotCommentId);
	}

	@Override
	public void addLikeMovieRole(int movieRoleCommentId) {
		commentDao.addLikeMovieRole(movieRoleCommentId);		
	}

	@Override
	public void addLikePlot(int plotCommentId) {
		commentDao.addLikePlot(plotCommentId);
	}

	@Override
	public void reduceLikeMoviePlot(int moviePlotCommentId) {
		commentDao.reduceLikeMoviePlot(moviePlotCommentId);
	}

	@Override
	public void reduceLikeMovieRole(int movieRoleCommentId) {
		commentDao.reduceLikeMovieRole(movieRoleCommentId);
	}

	@Override
	public void reduceLikePlot(int plotCommentId) {
		commentDao.reduceLikePlot(plotCommentId);
	}

	@Override
	public List<SimpleComment> getMoviePlotCommByPage(int pageNum,int moviePlotId) {
		List<MoviePlotComment> moviePlotComment = commentDao.getMoviePlotCommByPage(pageNum, moviePlotId);
		List<SimpleComment> sc = new ArrayList<SimpleComment>();
		for(int i=0;i<moviePlotComment.size();i++){
			SimpleComment s = new SimpleComment();
			MoviePlotComment m = moviePlotComment.get(i);
			s.setComment(m.getContent());
			User u = userDao.getId(m.getUser_id());
			s.setName(u.getUsername());
			s.setImg("");
			sc.add(s);
		}
		return sc;
	}

	@Override
	public List<SimpleComment> getPlotCommByPage(int pageNum,int plotId) {
		List<PlotComment> plotComment = commentDao.getPlotCommByPage(pageNum, plotId);
		List<SimpleComment> sc = new ArrayList<SimpleComment>();
		for(int i=0;i<plotComment.size();i++){
			SimpleComment s = new SimpleComment();
			PlotComment m = plotComment.get(i);
			s.setComment(m.getContent());
			User u = userDao.getId(m.getUser_id());
			s.setName(u.getUsername());
			s.setImg("");
			sc.add(s);
		}
		return sc;
	}

	@Override
	public List<SimpleComment> getMovieRoleCommByPage(int pageNum,int movieRoleId) {
		List<MovieRoleComment> movieRoleComment = commentDao.getMovieRoleCommByPage(pageNum, movieRoleId);
		List<SimpleComment> sc = new ArrayList<SimpleComment>();
		for(int i=0;i<movieRoleComment.size();i++){
			SimpleComment s = new SimpleComment();
			MovieRoleComment m = movieRoleComment.get(i);
			s.setComment(m.getContent());
			User u = userDao.getId(m.getUser_id());
			s.setName(u.getUsername());
			s.setImg("");
			sc.add(s);
		}
		return sc;
	}

}
