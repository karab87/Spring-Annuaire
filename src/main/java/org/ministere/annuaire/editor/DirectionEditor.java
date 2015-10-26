package org.ministere.annuaire.editor;

import java.beans.PropertyEditorSupport;

import org.ministere.annuaire.entities.Direction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;

public class DirectionEditor extends PropertyEditorSupport {
	
	
@Autowired	
private IAdminMetier metier;
	
	

	
	

	public DirectionEditor(IAdminMetier metier) {
	super();
	this.metier = metier;
}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Direction f = metier.getDirection(Long.parseLong(text));
		this.setValue(f);
	}
	
	@Override
	public String getAsText() {
		Direction cat = (Direction) this.getValue();
		return Long.toString(cat.getIdDirection());
	}
	

}
