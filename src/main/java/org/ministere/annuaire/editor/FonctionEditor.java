package org.ministere.annuaire.editor;

import java.beans.PropertyEditorSupport;

import org.ministere.annuaire.entities.Fonction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;

public class FonctionEditor extends PropertyEditorSupport {
	
	
@Autowired	
private IAdminMetier metier;
	
	

	
	

	public FonctionEditor(IAdminMetier metier) {
	super();
	this.metier = metier;
}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Fonction f = metier.getFonction(Long.parseLong(text));
		this.setValue(f);
	}
	
	@Override
	public String getAsText() {
		Fonction cat = (Fonction) this.getValue();
		return Long.toString(cat.getIdFonction());
	}
	

}
