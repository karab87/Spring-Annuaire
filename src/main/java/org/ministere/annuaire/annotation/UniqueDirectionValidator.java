package org.ministere.annuaire.annotation;

import javax.validation.ConstraintValidator;


import javax.validation.ConstraintValidatorContext;

import org.ministere.annuaire.metier.IAdminMetier;
import org.springframework.beans.factory.annotation.Autowired;


public class UniqueDirectionValidator implements ConstraintValidator<UniqueDirection, String> {
	
	@Autowired
	private IAdminMetier metier;

	@Override
	public void initialize(UniqueDirection constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(metier == null) {
			return true;
		}
		return metier.DirectionUniqueParMotCle(value) == null;
		
	}

	 
}
