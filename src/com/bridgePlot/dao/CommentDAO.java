package com.bridgePlot.dao;

import java.util.List;

import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PlotComment;

public interface CommentDAO {
	MoviePlotComment getMoviePlotCommentById(int id);
	MovieRoleComment getMovieRoleCommentById(int id);
	PlotComment getPlotCommentById(int id);
	
	List<MoviePlotComment> getMoviePlotCommentByUser(int userId);
	List<MovieRoleComment> getMovieRoleCommentByUser(int userId);
	List<PlotComment> getPlotCommentByUser(int userId);
	
	void saveMoviePlotComment(MoviePlotComment moviePlotComment);
	void saveMovieRoleComment(MovieRoleComment movieRoleComment);
	void savePlotComment(PlotComment plotComment);

	void addLikeMoviePlot(int moviePlotCommentId);
	void addLikeMovieRole(int movieRoleCommentId);
	void addLikePlot(int PlotCommentId);
	
	void reduceLikeMoviePlot(int moviePlotCommentId);
	void reduceLikeMovieRole(int movieRoleCommentId);
	void reduceLikePlot(int plotCommentId);
	
	List<MoviePlotComment> getMoviePlotCommByPage(int pageNum,int moviePlotId);
	List<PlotComment> getPlotCommByPage(int pageNum,int plotId);
	List<MovieRoleComment> getMovieRoleCommByPage(int pageNum,int movieRoleId);
	
	int getMoviePlotCommentCountById(int id);
	int getPlotCommentCountById(int id);
	int getMovieRoleCommentCountById(int id);
}
