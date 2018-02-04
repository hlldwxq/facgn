package com.bridgePlot.service;

import java.util.List;

import com.bridgePlot.entity.MoviePlotComment;
import com.bridgePlot.entity.MovieRoleComment;
import com.bridgePlot.entity.PlotComment;

public interface CommentService {
	MoviePlotComment getMoviePlotCommentById(int id);
	MovieRoleComment getMovieRoleCommentById(int id);
	PlotComment getPlotCommentById(int id);
	
	List<MoviePlotComment> getMoviePlotCommentByUser(int userId);
	List<MovieRoleComment> getMovieRoleCommentByUser(int userId);
	List<PlotComment> getPlotCommentByUser(int userId);
	
	void saveMoviePlotComment(MoviePlotComment moviePlotComment);
	void saveMovieRoleComment(MovieRoleComment movieRoleComment);
	void savePlotComment(PlotComment plotComment);
}
