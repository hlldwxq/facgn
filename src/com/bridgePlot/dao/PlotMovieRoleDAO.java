package com.bridgePlot.dao;

import java.util.List;
import com.bridgePlot.entity.*;

public interface PlotMovieRoleDAO {
	Plot getPlotById(int plotId);
	Plot getPlotByIdNewest(int plotId);
	MoviePlot getMoviePlotById(int moviePlotId);
	MoviePlot getMoviePlotByIdNewest(int moviePlotId);
	MovieRole getMovieRoleById(int movieRoleId);
	List<MoviePlot> getMoviePlotByPlot(String Plot_name);
	List<MoviePlot> getMoviePlotByOtherPlotAndMovie(String Plot_name,String movie_name);
	List<Plot> getPlotIndex();
	void savePlot(Plot plot);
	void saveMoviePlot(MoviePlot moviePlot);
}
