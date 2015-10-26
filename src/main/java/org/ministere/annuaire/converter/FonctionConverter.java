package org.ministere.annuaire.converter;

import org.ministere.annuaire.entities.Fonction;
import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class FonctionConverter implements Converter<Object, Fonction> {
	
	@Autowired
	IAdminMetier metier;

	@Override
	public Fonction convert(Object element) {
		
		Long id = Long.parseLong((String)element);
        Fonction fonction = metier.getFonction(id);
       
        return fonction;
	}

}
