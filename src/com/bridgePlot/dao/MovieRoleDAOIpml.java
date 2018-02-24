package com.bridgePlot.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bridgePlot.entity.EditRelative;
import com.bridgePlot.entity.MovieRole;
import com.bridgePlot.entity.Plot;

@Repository
public class MovieRoleDAOIpml implements MovieRoleDAO{

	@Resource private SessionFactory sessionFactory;

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MovieRole getMovieRoleById(int movieRoleId) {
		MovieRole movieRole = (MovieRole)this.currentSession().createQuery("from MovieRole where id = ?")
											.setParameter(0, movieRoleId)
											.uniqueResult();
		return movieRole;
	}

    public void setAbsoluteMovieRoleId(){
    	this.currentSession().createQuery("update MovieRole as p set p.absolute_id = p.id where p.absolute_id<0")
		.executeUpdate();
    }

	@Override
	public void saveMovieRole(MovieRole movieRole) {
		this.currentSession().save(movieRole);
		if(movieRole.getAbsolute_id()<0){
			setAbsoluteMovieRoleId();
		}
	}

	@Override
	public void saveEditRelative(EditRelative editRelative) {
		this.currentSession().save(editRelative);
	}

	@Override
	public List<MovieRole> getMovieRoleByMovieId(int movieId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where movie_id = ?")
								.setParameter(0,movieId)
								.list();
		return movieRole;
	}

	@Override
	public List<EditRelative> getEditRelativeByMovieId(int movieId) {
		@SuppressWarnings("unchecked")
		List<EditRelative> editRelative = (List<EditRelative>)this.currentSession().createQuery("from EditRelative where movie_id = ?")
								.setParameter(0,movieId)
								.list();
		return editRelative;
	}

	@Override
	public MovieRole getMovieRoleByIdNewest(int movieRoleAbsoluteId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where edit_tick in (select max(edit_tick) from MovieRole where absolute_id = ?) and absolute_id=?")
								.setParameter(0, movieRoleAbsoluteId)
								.setParameter(1, movieRoleAbsoluteId)
								.list();
		
		return movieRole.get(0);
	}

	@Override
	public MovieRole getMovieRoleByIdNewestAndUser(int movieRoleAbsoluteId, int userId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where edit_tick in (select max(edit_tick) from MovieRole where absolute_id = ? and author_id=?) and absolute_id=? ")
								.setParameter(0, movieRoleAbsoluteId)
								.setParameter(2, movieRoleAbsoluteId)
								.setParameter(1,userId)
								.list();
		
		return movieRole.get(0);
	}

	@Override
	public MovieRole getNewMovieRoleByUser(int userId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where id in (select max(id) from MovieRole where author_id=?)")
								.setParameter(0,userId)
								.list();
		return movieRole.get(0);
	}

	@Override
	public List<MovieRole> getMovieRoleByProfession(String profession,int absoluteId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where role_profession = ? and absolute_id!= ?")
				.setParameter(0,profession)
				.setParameter(1,absoluteId)
				.list();
		for(int i=0;i<movieRole.size();){
			int flag = 0;
			for(int j=i+1;j<movieRole.size();){
				if(movieRole.get(i).getAbsolute_id()==movieRole.get(j).getAbsolute_id()){
					if(movieRole.get(i).getEdit_tick()>movieRole.get(j).getEdit_tick()){
						movieRole.remove(movieRole.get(j));
					}
					else{
						movieRole.remove(movieRole.get(i));
						flag = 1;
					}
				}
				else{j++;}
			}
			if(flag==1){
				continue;
			}else{i++;}
		}
		return movieRole;
	}

	@Override
	public List<MovieRole> getMovieRoleByLabel(String label,int absoluteId) {
		@SuppressWarnings("unchecked")
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where label like '%"+label+"%' and absolute_id!= ?")
				.setParameter(0,absoluteId)
				.list();
		for(int i=0;i<movieRole.size();){
			int flag = 0;
			for(int j=i+1;j<movieRole.size();){
				if(movieRole.get(i).getAbsolute_id()==movieRole.get(j).getAbsolute_id()){
					if(movieRole.get(i).getEdit_tick()>movieRole.get(j).getEdit_tick()){
						movieRole.remove(movieRole.get(j));
					}
					else{
						movieRole.remove(movieRole.get(i));
						flag = 1;
					}
				}
				else{j++;}
			}
			if(flag==1){
				continue;
			}else{i++;}
		}
		return movieRole;
	}

	@Override
	public EditRelative getRelativeByRole(int id1, int id2) {
		EditRelative relative = (EditRelative)this.currentSession().createQuery("from EditRelative where (role1 = ? and role2 = ?) or (role1 = ? and role2 = ?)")
				.setParameter(0, id1)
				.setParameter(1, id2)
				.setParameter(2, id2)
				.setParameter(3, id1)
				.uniqueResult();
		return relative;
	}

	@Override
	public void updateEditRelative(int id1, int id2, String type) {
		this.currentSession().createQuery("update EditRelative as r set r.type = ? where r.role1 = ? and r.role2 = ?")
		.setParameter(0, type)
		.setParameter(1, id1)
		.setParameter(2, id2)
	    .executeUpdate();
	}

	@Override
	public String getNameById(int id) {
		String  name = (String)this.currentSession().createQuery("select role_name from MovieRole where id = ?")
				.setParameter(0, id)
				.uniqueResult();
		return name;
	}

	@Override
	public List<MovieRole> getPlotByPartialName(String search) {
		List<MovieRole> role = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where role_name like '%"+search+"%'")
				.list();
		return role;
	}

	@Override
	public List<MovieRole> getPlotByPartialLabel(String search) {
		List<MovieRole> role = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where label like '%"+search+"%'")
				.list();
		return role;
	}

	@Override
	public List<MovieRole> getPlotByPartialMovieName(String search) {
		List<MovieRole> role = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where role_at_movie like '%"+search+"%'")
				.list();
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MovieRole getNewRoleByName(String name) {
		List<MovieRole> movieRole = (List<MovieRole>)this.currentSession().createQuery("from MovieRole where edit_tick in (select max(edit_tick) from MovieRole where role_name = ?) and role_name = ?")
				.setParameter(0, name)
				.setParameter(1, name)
				.list();

		return movieRole.get(0);
	}


}