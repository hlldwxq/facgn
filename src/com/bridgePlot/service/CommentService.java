package com.bridgePlot.service;

import java.util.List;

import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PageBean;
import com.bridgePlot.entity.PlotComment;
import com.bridgePlot.entity.SimpleComment;

public interface CommentService {
	MoviePlotComment getMoviePlotCommentById(int id);
	MovieRoleComment getMovieRoleCommentById(int id);
	PlotComment getPlotCommentById(int id);
	
	List<MoviePlotComment> getMoviePlotCommentByUser(int userId);
	List<MovieRoleComment> getMovieRoleCommentByUser(int userId);
	List<PlotComment> getPlotCommentByUser(int userId);
	
	void saveMoviePlotComment(MoviePlotComment moviePlotComment,int userId);
	void saveMovieRoleComment(MovieRoleComment movieRoleComment,int userId);
	void savePlotComment(PlotComment plotComment,int userId);
	
	void addLikeMoviePlot(int moviePlotCommentId);
	void addLikeMovieRole(int movieRoleCommentId);
	void addLikePlot(int plotCommentId);
	
	void reduceLikeMoviePlot(int moviePlotCommentId);
	void reduceLikeMovieRole(int movieRoleCommentId);
	void reduceLikePlot(int plotCommentId);
	
	List<SimpleComment> getMoviePlotCommByPage(int pageNum,int moviePlotId);
	List<SimpleComment> getPlotCommByPage(int pageNum,int plotId);
	List<SimpleComment> getMovieRoleCommByPage(int pageNum,int movieRoleId );
}
