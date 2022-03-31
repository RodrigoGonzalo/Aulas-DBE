package br.com.fiap.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.model.Setup;
//CDI
@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	
	public void Save() {
		System.out.println(this.setup);
	}
	

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
	
}
