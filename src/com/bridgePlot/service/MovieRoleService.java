package com.bridgePlot.service;

import java.util.List;

import com.bridgePlot.entity.*;

public interface MovieRoleService {
	
	MovieRole getMovieRoleById(int movieRoleId);
	MovieRole getMovieRoleByIdNewest(int movieRoleId);
	MovieRole getMovieRoleByIdNewestAndUser(int movieRoleAbsoluteId,int userId);
	MovieRole getNewMovieRoleByUser(int userId);
	
	void saveMovieRole(MovieRole movieRole);
	void saveEditRelative(int movieId,String role1,String role2,String type);
	
	List<SimpleRole> getSimpleRoleByMovieId(int movieId);
	List<MovieRole> getMovieRoleByMovieId(int movieId);
	List<SimpleRelative> getEditRelativeByMovieId(int movieId);
	
	String uploadTrueUrl(String servletRoot);
    String setCoverImg(String servletRoot,String tempFileName,String cutImage) throws Exception;
   
    List<MovieRole> searchByPartial(String search);
    List<MovieRole> getSimilarMovieRole(int roleId);
}
