/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.allergyapi;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Concept;
import org.openmrs.util.OpenmrsUtil;

/**
 * Represent allergy reactions
 */
public class AllergyReaction extends BaseOpenmrsObject implements java.io.Serializable{
	
	public static final long serialVersionUID = 1;


	private Integer allergyReactionId;
	
	private Allergy allergy;
	
	private Concept reaction;
	
	private String reactionNonCoded;
	
	/**
	 * Default constructor
	 */
	public AllergyReaction(){
		
	}
	
	/**
	 * @param allergy the allergy to set
	 * @param reaction the reaction to set
	 * @param reactionNonCoded the reactionNonCoded to set
	 */
	public AllergyReaction(Allergy allergy, Concept reaction, String reactionNonCoded) {
		this.allergy = allergy;
		this.reaction = reaction;
		this.reactionNonCoded = reactionNonCoded;
	}
	
	public Integer getAllergyReactionId() {
		return allergyReactionId;
	}

	public void setAllergyReactionId(Integer allergyReactionId) {
		this.allergyReactionId = allergyReactionId;
	}

	/**
	 * @see org.openmrs.OpenmrsObject#getId()
	 */
	@Override
	public Integer getId() {
		return allergyReactionId;
	}

	/**
	 * @see org.openmrs.OpenmrsObject#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer allergyReactionId) {
		this.allergyReactionId = allergyReactionId;
	}
	
	/**
	 * @return Returns the allergy
	 */
	public Allergy getAllergy() {
		return allergy;
	}
	
	/**
	 * @param allergy the allergy to set
	 */
	public void setAllergy(Allergy allergy) {
		this.allergy = allergy;
	}
	
	/**
	 * @return Returns the reaction
	 */
	public Concept getReaction() {
		return reaction;
	}
	
	/**
	 * @param reaction the reaction to set
	 */
	public void setReaction(Concept reaction) {
		this.reaction = reaction;
	}
	
	/**
	 * @return Returns the reactionNonCoded
	 */
	public String getReactionNonCoded() {
		return reactionNonCoded;
	}
	
	/**
	 * @param reactionNonCoded the reactionNonCoded to set
	 */
	public void setReactionNonCoded(String reactionNonCoded) {
		this.reactionNonCoded = reactionNonCoded;
	}
	
	@Override
    public String toString() {
	    if (StringUtils.isNotBlank(reactionNonCoded)) {
	    	return reactionNonCoded;
	    }
	    return reaction.getName().getName();
    }
	
	/**
	 * Checks if this reaction has the same values as the given one
	 * 
	 * @param reaction the reaction whose values to compare with
	 * @return true if the values match, else false
	 */
	public boolean hasSameValues(AllergyReaction reaction) {
		if (!OpenmrsUtil.nullSafeEquals(getAllergyReactionId(), reaction.getAllergyReactionId())) {
			return false;
		}
		if (!OpenmrsUtil.nullSafeEquals(getReaction(), reaction.getReaction())) {
			//if object instances are different but with the same concept id, then not changed
			if (getReaction() != null && reaction.getReaction() != null) {
				if (!OpenmrsUtil.nullSafeEquals(getReaction().getConceptId(), reaction.getReaction().getConceptId())) {
					return false;
				}
			}
			else {
				return false;
			}
		}
		if (!OpenmrsUtil.nullSafeEquals(getReactionNonCoded(), reaction.getReactionNonCoded())) {
			return false;
		}
		
		return true;
	}
}
