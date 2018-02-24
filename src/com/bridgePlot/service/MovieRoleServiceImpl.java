package com.bridgePlot.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.bridgePlot.dao.MovieDAO;
import com.bridgePlot.dao.MoviePlotDAO;
import com.bridgePlot.dao.MovieRoleDAO;
import com.bridgePlot.entity.*;

@Service
public class MovieRoleServiceImpl implements MovieRoleService{

	@Resource private MovieRoleDAO movieRoleDao;
	@Resource private MoviePlotDAO moviePlotDao;
	@Resource private MovieDAO movieDao;
	
	@Override
	public MovieRole getMovieRoleById(int movieRoleId) {
		return movieRoleDao.getMovieRoleById(movieRoleId);
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
	public String setCoverImg(String servletRoot,String tempFileName,String cutImage) throws Exception {
		String dataPrix = "";  
        String data = "";            
        if(cutImage == null || "".equals(cutImage)){  
            throw new Exception("上传失败，上传图片数据为空");  
        }else{  
            String [] d = cutImage.split("base64,");  
            if(d != null && d.length == 2){  
                dataPrix = d[0];  
                data = d[1];  
            }else{  
                throw new Exception("上传失败，数据不合法");  
            }  
        }       
       
        String suffix = "";  
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据  
            suffix = ".jpg";  
        } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据  
            suffix = ".ico";  
        } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据  
            suffix = ".gif";  
        } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据  
            suffix = ".png";  
        }else{  
            throw new Exception("上传图片格式不合法");  
        }  
        tempFileName = tempFileName+UUID.randomUUID().toString() + suffix;    
        
        byte[] bs = Base64Utils.decodeFromString(data); 
        try{  
        	FileUtils.writeByteArrayToFile(new File(servletRoot, tempFileName), bs);    
        }catch(Exception ee){  
            throw new Exception("上传失败，写入文件失败，"+ee.getMessage());  
        }
        return tempFileName;
	}

	@Override
	public void saveMovieRole(MovieRole movieRole) {
		Date nowDate = new Date();
		movieRole.setEdit_time(nowDate);
		int movieId = movieDao.getMovieIdByMovieName(movieRole.getRole_at_movie());
		movieRole.setMovie_id(movieId);
		movieRoleDao.saveMovieRole(movieRole);
	}

	
	@Override
	public List<MovieRole> getMovieRoleByMovieId(int movieId) {
		List<MovieRole> mr = movieRoleDao.getMovieRoleByMovieId(movieId);
		for(int j=0;j<mr.size();){
			int flag = 1;
			for(int z=j+1;z<mr.size();){
				if(mr.get(j).getAbsolute_id() == mr.get(z).getAbsolute_id()){
					if(mr.get(j).getEdit_tick()>mr.get(z).getEdit_tick()){
						mr.remove(z);
						continue;
					}
					else{
						mr.remove(j);
						flag=0;
						break;
					}
				}
				else{z++;}
			}
			if(flag==0){continue;}
			else{j++;}
		}
		
		return mr;
	}

	@Override
	public List<SimpleRelative> getEditRelativeByMovieId(int movieId) {
		
		List<EditRelative> er = movieRoleDao.getEditRelativeByMovieId(movieId);
		List<SimpleRelative> sr = new ArrayList<SimpleRelative>();
		for(int i = 0;i<er.size();i++){
			SimpleRelative s = new SimpleRelative();
			EditRelative e = er.get(i);
			s.setType(e.getType());
			s.setRole1(movieRoleDao.getNameById(e.getRole1()));
			s.setRole2(movieRoleDao.getNameById(e.getRole2()));
			sr.add(s);
		}
		return sr;
	}

	@Override
	public List<SimpleRole> getSimpleRoleByMovieId(int movieId) {
		List<MovieRole> movieRole = movieRoleDao.getMovieRoleByMovieId(movieId);
		movieRole = duplicateRemove(movieRole);
		List<SimpleRole> simpleRole = new ArrayList<SimpleRole>();
		for(int i = 0;i < movieRole.size();i++){
			MovieRole mr = movieRole.get(i);
			SimpleRole sr = new SimpleRole(mr.getId(),mr.getRole_name(),mr.getRole_pic());
			simpleRole.add(sr);
		}
		return simpleRole;
	}

	@Override
	public MovieRole getMovieRoleByIdNewest(int movieRoleId) {
		
		return movieRoleDao.getMovieRoleByIdNewest(movieRoleId);
	}

	@Override
	public MovieRole getMovieRoleByIdNewestAndUser(int movieRoleAbsoluteId, int userId) {
		return movieRoleDao.getMovieRoleByIdNewestAndUser(movieRoleAbsoluteId, userId);
	}

	@Override
	public MovieRole getNewMovieRoleByUser(int userId) {
		return movieRoleDao.getNewMovieRoleByUser(userId);
	}

	@Override
	public List<MovieRole> getSimilarMovieRole(int roleId) {
		MovieRole mr = movieRoleDao.getMovieRoleById(roleId);
		String[] labels = mr.getLabel().split("·");
		List<MovieRole> movieRole = movieRoleDao.getMovieRoleByProfession(mr.getRole_profession(),mr.getAbsolute_id());
		for(int i=0;i<labels.length;i++){
			List<MovieRole> mrl = movieRoleDao.getMovieRoleByLabel(labels[i],mr.getAbsolute_id());
			if(movieRole.isEmpty()){movieRole = mrl;}
			for(int j=0;j<mrl.size();j++){
				int flag = 1;
				for(int z=0;z<movieRole.size();z++){
					if(mrl.get(j).getId() == movieRole.get(z).getId() || mrl.get(j).getAbsolute_id() == movieRole.get(z).getAbsolute_id()){
						flag = 0;
						break;
					}
				}
				if(flag==1){movieRole.add(mrl.get(j));}
			}
		}
		return movieRole;
	}

	private List<MovieRole> duplicateRemove(List<MovieRole> movieRole){
		for(int i=0;i<movieRole.size();){
			MovieRole m1 = movieRole.get(i);
			int flag = 1;
			for(int j=i+1;j<movieRole.size();){
				MovieRole m2 = movieRole.get(j);
				if(m1.getAbsolute_id()==m2.getAbsolute_id()){
					if(m1.getEdit_tick()>m2.getEdit_tick()){
						movieRole.remove(j);
					}else{
						movieRole.remove(m1);
						flag = 0;
						break;
					}
				}
				else if(m1.getId()==m2.getId()){
					movieRole.remove(j);
				}
				else{
					j++;
				}
			}
			if(flag==0){
				continue;
			}else{
				i++;
			}
		}
		return movieRole;
	}

	@Override
	public List<MovieRole> searchByPartial(String search) {
		List<MovieRole> ml = movieRoleDao.getPlotByPartialLabel(search);
		List<MovieRole> ml1 = movieRoleDao.getPlotByPartialMovieName(search);
		List<MovieRole> ml2 = movieRoleDao.getPlotByPartialName(search);
		if(ml1!=null){
			ml.addAll(ml1);
		}
		if(ml2!=null){
			ml.addAll(ml2);
		}
		ml = duplicateRemove(ml);
		return ml;
	}

	@Override
	public void saveEditRelative(int movieId, String role1, String role2, String type) {
		MovieRole myrole1 = movieRoleDao.getNewRoleByName(role1);
		MovieRole myrole2 = movieRoleDao.getNewRoleByName(role2);
		EditRelative r = movieRoleDao.getRelativeByRole(myrole1.getId(), myrole2.getId());
		if(r==null){
			EditRelative er = new EditRelative();
			er.setMovie_id(movieId);
			er.setRole1(myrole1.getId());
			er.setRole2(myrole2.getId());
			er.setFirst_role_pic(myrole1.getRole_pic());
			er.setSecond_role_pic(myrole2.getRole_pic());
			er.setType(type);
			movieRoleDao.saveEditRelative(er);
			
		}else{
			movieRoleDao.updateEditRelative(r.getRole1(), r.getRole2(), type);
		}
	}

}
