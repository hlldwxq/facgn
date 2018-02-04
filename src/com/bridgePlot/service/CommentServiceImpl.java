package com.bridgePlot.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bridgePlot.dao.CommentDAO;
import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PlotComment;

@Service
public class CommentServiceImpl implements CommentService{

	@Resource private CommentDAO commentDao;
	
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
	public void saveMoviePlotComment(MoviePlotComment moviePlotComment) {
		Date edit_time = new Date();
		moviePlotComment.setEdit_time(edit_time);
		commentDao.saveMoviePlotComment(moviePlotComment);
	}

	@Override
	public void saveMovieRoleComment(MovieRoleComment movieRoleComment) {
		Date edit_time = new Date();
		movieRoleComment.setEdit_time(edit_time);
		commentDao.saveMovieRoleComment(movieRoleComment);
	}

	@Override
	public void savePlotComment(PlotComment plotComment) {
		Date edit_time = new Date();
		plotComment.setEdit_time(edit_time);
		commentDao.savePlotComment(plotComment);
	}

}
