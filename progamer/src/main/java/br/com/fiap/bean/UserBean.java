package br.com.fiap.bean;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	private List<User> list;
	
	private UserDao userDao = new UserDao();
	
	public UserBean() {
		list = this.list();
	}
	
	public void save() {
		System.out.println(this.user);
		userDao.create(user);
	}
	
	public List<User> list() {
		return userDao.listAll();
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String login() {
		// Verificar se existe um usuario
		if (userDao.exist(user)) {
			
			// salvar na secao
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
			return "setups";
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Invalido"));
		
		return "login?faces-redirect=true";
	}
	
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");

		return "login";
	}


}
