package org.ministere.annuaire.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueServiceValidator implements ConstraintValidator<UniqueService, String> {
	
	@Autowired
	private IAdminMetier metier;
	@Override
	public void initialize(UniqueService arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String val , ConstraintValidatorContext context) {
		if(metier ==null){
			return true;
		}
		return metier.ServiceParMotCle(val) == null;
	}

}
