package com.bridgePlot.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bridgePlot.entity.MoviePlot;
import com.bridgePlot.entity.MovieRole;
import com.bridgePlot.entity.Plot;

@Repository
public class PlotMovieRoleDAOIpml implements PlotMovieRoleDAO{

	@Resource private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Plot getPlotById(int plotId) {
		Plot plot = (Plot)this.currentSession().createQuery("from Plot where id = ?")
											.setParameter(0, plotId)
											.uniqueResult();
		return plot;
	}

	@Override
	public MoviePlot getMoviePlotById(int moviePlotId) {
		MoviePlot moviePlot = (MoviePlot)this.currentSession().createQuery("from MoviePlot where id = ?")
											.setParameter(0, moviePlotId)
											.uniqueResult();
		return moviePlot;
	}

	@Override
	public MovieRole getMovieRoleById(int movieRoleId) {
		MovieRole movieRole = (MovieRole)this.currentSession().createQuery("from MovieRole where id = ?")
											.setParameter(0, movieRoleId)
											.uniqueResult();
		return movieRole;
	}

	@Override
	public List<Plot> getPlotIndex() {
		@SuppressWarnings("unchecked")
		ArrayList<Plot> plot = (ArrayList<Plot>)this.currentSession().createQuery("from Plot order by edit_tick desc")
											.setFirstResult(0)
							        		.setMaxResults(10)
							        		.list();
		return plot;
	}

	@Override
	public List<MoviePlot> getMoviePlotByPlot(String Plot_name) {
		@SuppressWarnings("unchecked")
		List<MoviePlot> moviePlot = (List<MoviePlot>)this.currentSession().createQuery("from MoviePlot where plot_name = ? order by edit_tick desc")
										.setParameter(0, Plot_name)
										.setFirstResult(0)
						        		.setMaxResults(3)
						        		.list();

		return moviePlot;
	}

	@Override
	public List<MoviePlot> getMoviePlotByOtherPlotAndMovie(String Plot_name, String movie_name) {
		@SuppressWarnings("unchecked")
		List<MoviePlot> moviePlot = (List<MoviePlot>)this.currentSession().createQuery("from MoviePlot where plot_name != ? and plot_at_movie=? order by edit_tick desc")
										.setParameter(0, Plot_name)
										.setParameter(1,movie_name)
										.setFirstResult(0)
						        		.setMaxResults(3)
						        		.list();
		
		return moviePlot;
	}

	@Override
	public void savePlot(Plot plot) {
		this.currentSession().save(plot);
		if(plot.getAbsolute_id()<0){
			setAbsolutePlotId();
		}
	}

	@Override
	public void saveMoviePlot(MoviePlot moviePlot) {
		this.currentSession().save(moviePlot);
		if(moviePlot.getAbsolute_id()<0){
			setAbsoluteMoviePlotId();
		}
	}
    public void setAbsolutePlotId(){
    	this.currentSession().createQuery("update Plot as p set p.absolute_id = p.id where p.absolute_id<0")
		.executeUpdate();
    }
    public void setAbsoluteMoviePlotId(){
    	this.currentSession().createQuery("update MoviePlot as p set p.absolute_id = p.id where p.absolute_id<0")
		.executeUpdate();
    }
	@Override
	public Plot getPlotByIdNewest(int absolutePlotId) {
		
		@SuppressWarnings("unchecked")
		List<Plot> plot = (List<Plot>)this.currentSession().createQuery("from Plot where edit_tick in (select max(edit_tick) from Plot where absolute_id = ?) and absolute_id=?")
								.setParameter(0, absolutePlotId)
								.setParameter(1, absolutePlotId)
								.list();
//		List<Plot> plot = (List<Plot>)this.currentSession().createQuery("from Plot where id=?")
//							.setParameter(0, id)
//							.list();
		return plot.get(0);
	}

	@Override
	public MoviePlot getMoviePlotByIdNewest(int moviePlotAbsoluteId) {
		@SuppressWarnings("unchecked")
		List<MoviePlot> moviePlot = (List<MoviePlot>)this.currentSession().createQuery("from MoviePlot where edit_tick in (select max(edit_tick) from MoviePlot where absolute_id = ?) and absolute_id=?")
								.setParameter(0, moviePlotAbsoluteId)
								.setParameter(1, moviePlotAbsoluteId)
								.list();
		
		return moviePlot.get(0);
	}

}
