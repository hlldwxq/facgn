package com.bridgePlot.service;

import java.util.List;

import com.bridgePlot.entity.*;

public interface PlotMovieRoleService {
	Plot getPlotById(int plotId);
	Plot getPlotByIdNewest(int plotId);
	MoviePlot getMoviePlotById(int moviePlotId);
	MoviePlot getMoviePlotByIdNewest(int moviePlotId);
	MovieRole getMovieRoleById(int movieRoleId);
	List<MoviePlot> getMoviePlotByPlot(String Plot_name);
	List<MoviePlot> getMoviePlotByOtherPlotAndMovie(String Plot_name,String movie_name);
	List<PlotIndex> getPlotIndex();
	void save(String name,String content,String label,String time,String picName,String author,int authorId,int edittick,int absoluteid);
    String uploadTrueUrl(String servletRoot);
}
