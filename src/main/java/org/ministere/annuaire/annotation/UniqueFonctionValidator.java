package org.ministere.annuaire.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueFonctionValidator implements ConstraintValidator<UniqueFonction, String> {
	
	@Autowired
	private IAdminMetier metier;
	
	@Override
	public void initialize(UniqueFonction arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String fonc, ConstraintValidatorContext context) {
		if(metier==null){
			return true;
		}
		
		return metier.FonctionParMotCle(fonc) == null;
	}

}
