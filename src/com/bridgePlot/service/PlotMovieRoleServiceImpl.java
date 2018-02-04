package com.bridgePlot.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.bridgePlot.dao.PlotMovieRoleDAO;
import com.bridgePlot.entity.*;

@Service
public class PlotMovieRoleServiceImpl implements PlotMovieRoleService{

	@Resource private PlotMovieRoleDAO pmrDao;
	
	@Override
	public Plot getPlotById(int plotId) {
		return pmrDao.getPlotById(plotId);
	}

	@Override
	public MoviePlot getMoviePlotById(int moviePlotId) {
		return pmrDao.getMoviePlotById(moviePlotId);
	}

	@Override
	public MovieRole getMovieRoleById(int movieRoleId) {
		return pmrDao.getMovieRoleById(movieRoleId);
	}

	@Override
	public List<PlotIndex> getPlotIndex() {
		List<Plot> plot = pmrDao.getPlotIndex();
		List<PlotIndex> plotIndex = new ArrayList<PlotIndex>();
		for(int i=0;i<plot.size();i++){
			Plot p = plot.get(i);
			String name = p.getPlot_name();
			String type = p.getPlot_label_1()+"\\"+p.getPlot_label_2()+"\\"+p.getPlot_label_3(); 
			int id = p.getId();
			String url = "plot/"+id;
			String image = p.getPlot_pic();
			plotIndex.add(new PlotIndex(image,type,name,url));
		}
		return plotIndex;
	}

	@Override
	public List<MoviePlot> getMoviePlotByPlot(String Plot_name) {
		return pmrDao.getMoviePlotByPlot(Plot_name);
	}

	@Override
	public List<MoviePlot> getMoviePlotByOtherPlotAndMovie(String Plot_name, String movie_name) {
		return pmrDao.getMoviePlotByOtherPlotAndMovie(Plot_name, movie_name);
	}

	@Override
	public void save(String name, String content,String label, String time,String picName,String author,int authorId,int edittick,int absoluteid) {
	
		String labels[]=label.split("·");
		if(!time.equals("")){
			String names[] = name.split("·");
			String times[] = time.split("-");
			MoviePlot moviePlot = new MoviePlot();
			moviePlot.setPlot_name(names[0]);
			moviePlot.setPlot_at_movie(names[1]);
			SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
		    java.util.Date d1 = null;  
		    java.util.Date d2 = null;  
		    try {  
		         d1 = sf.parse(times[0]);  
		         d2 = sf.parse(times[1]); 
		         java.sql.Time beginTime = new java.sql.Time(d1.getTime()); 
			     java.sql.Time endTime = new java.sql.Time(d2.getTime()); 
				 moviePlot.setBegin_time(beginTime);
				 moviePlot.setEnd_time(endTime);	
		    } catch (Exception e) {  
		         e.printStackTrace();  
		    }  
		    
			if(labels.length==1){
				moviePlot.setPlot_label_1(labels[0]);
			}else if(labels.length==2){
				moviePlot.setPlot_label_1(labels[0]);
				moviePlot.setPlot_label_2(labels[1]);
			}else if(labels.length>=3){
				moviePlot.setPlot_label_1(labels[0]);
				moviePlot.setPlot_label_2(labels[1]);
				moviePlot.setPlot_label_3(labels[2]);
			}
			moviePlot.setPlot_content(content);
			moviePlot.setEdit_tick(edittick);
			moviePlot.setAuthor(author);
			moviePlot.setAuthor_id(authorId);
			moviePlot.setPlot_pic(picName);
			Date nowDate = new Date();
			moviePlot.setEdit_time(nowDate);
			moviePlot.setAbsolute_id(absoluteid);
			
			pmrDao.saveMoviePlot(moviePlot);
			
		}else{
			Plot plot = new Plot();
			plot.setPlot_name(name);
			if(labels.length==1){
				plot.setPlot_label_1(labels[0]);
			}else if(labels.length==2){
				plot.setPlot_label_1(labels[0]);
				plot.setPlot_label_2(labels[1]);
			}else if(labels.length>=3){
				plot.setPlot_label_1(labels[0]);
				plot.setPlot_label_2(labels[1]);
				plot.setPlot_label_3(labels[2]);
			}
			plot.setPlot_content(content);
			plot.setEdit_tick(edittick);
			plot.setAuthor(author);
			plot.setAuthor_id(authorId);
			plot.setPlot_pic(picName);
			Date nowDate = new Date();
			plot.setEdit_time(nowDate);
			plot.setAbsolute_id(absoluteid);
			
			pmrDao.savePlot(plot);
			
		}
	}

	@Override
	public String uploadTrueUrl(String servletRoot) {
		String cut[]=servletRoot.split("\\\\");
		String tomcatWeb=new String();
		for(int i=0;i<cut.length-1;i++)
		{
			tomcatWeb+=cut[i]+"\\";
		}
		return tomcatWeb;
	}

	@Override
	public Plot getPlotByIdNewest(int plotId) {
		return pmrDao.getPlotByIdNewest(plotId);
	}

	@Override
	public MoviePlot getMoviePlotByIdNewest(int moviePlotId) {
		return pmrDao.getMoviePlotByIdNewest(moviePlotId);
	}
	
}
