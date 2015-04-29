/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.phenotips.similarity;

import org.phenotips.data.Patient;
import org.phenotips.data.similarity.PatientSimilarityView;

import org.xwiki.component.annotation.Role;
import org.xwiki.stability.Unstable;

import java.util.List;

/**
 * Allows searching for patients similar to a reference patient in the current PhenoTips instance.
 *
 * @version $Id$
 * @since 1.0M8
 */
@Unstable
@Role
public interface SimilarPatientsFinder
{
    /**
     * Returns a list of patients similar to a reference patient. The reference patient must be owned by the current
     * user (or one of their groups). Only accessible patients are returned.
     *
     * @param referencePatient the reference patient, must not be {@code null}
     * @return the similar patients found in the database, an empty list if no patients are found or if the reference
     *         patient is invalid
     */
    List<PatientSimilarityView> findSimilarPatients(Patient referencePatient);

    /**
     * Returns a list of template patients similar to a reference patient. The reference patient must be owned by the
     * current user (or one of their groups).
     *
     * @param referencePatient the reference patient, must not be {@code null}
     * @return the similar patient templates found in the database, an empty list if no templates are found or if the
     *         reference patient is invalid
     */
    List<PatientSimilarityView> findSimilarPrototypes(Patient referencePatient);

    /**
     * Checks how many patients similar to a reference patient exist, and returns their count. The reference patient
     * must be owned by the current user (or one of their groups). Only accessible patients are counted.
     *
     * @param referencePatient the reference patient, must not be {@code null}
     * @return the number of similar patients found in the database, or {@code 0} if the reference patient is invalid
     */
    long countSimilarPatients(Patient referencePatient);
}
