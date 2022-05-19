package br.com.fiap.auth;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fiap.model.User;

public class AuthorizationListener implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		String Page = FacesContext.getCurrentInstance().getViewRoot().getViewId();

		if(Page.equals("/login.xhtml") || Page.equals("register.html")) {
			return;
		}
		// Se o usuario nao esta logado, vai pra login
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		
		if(user != null) return;
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "login.xhtml");
		
		// Se nao deixa quieto
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}
	
	
}
