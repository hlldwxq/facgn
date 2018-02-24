package com.bridgePlot.dao;

import java.util.List;
import com.bridgePlot.entity.*;

public interface MovieRoleDAO {

	MovieRole getMovieRoleById(int movieRoleId);
	MovieRole getMovieRoleByIdNewest(int movieRoleId);
	MovieRole getMovieRoleByIdNewestAndUser(int movieRoleAbsoluteId,int userId);
	MovieRole getNewMovieRoleByUser(int userId);
	MovieRole getNewRoleByName(String name);
	void saveMovieRole(MovieRole movieRole);
	void saveEditRelative(EditRelative editRelative);
	void updateEditRelative(int id1,int id2,String type);
	EditRelative getRelativeByRole(int id1,int id2);
	
	List<MovieRole> getMovieRoleByMovieId(int movieId);
	List<EditRelative> getEditRelativeByMovieId(int movieId);
	
	List<MovieRole> getMovieRoleByProfession(String profession,int absoluteId);
	List<MovieRole> getMovieRoleByLabel(String label,int absoluteId);
	
	String getNameById(int id);
	
	List<MovieRole> getPlotByPartialName(String search);
	List<MovieRole> getPlotByPartialMovieName(String search);
	List<MovieRole> getPlotByPartialLabel(String search);
}
