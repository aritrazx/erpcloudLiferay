/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.famocom.erpcloud.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EvaluationLocalService}.
 *
 * @author Samaresh
 * @see EvaluationLocalService
 * @generated
 */
@ProviderType
public class EvaluationLocalServiceWrapper implements EvaluationLocalService,
	ServiceWrapper<EvaluationLocalService> {
	public EvaluationLocalServiceWrapper(
		EvaluationLocalService evaluationLocalService) {
		_evaluationLocalService = evaluationLocalService;
	}

	/**
	* Adds the evaluation to the database. Also notifies the appropriate model listeners.
	*
	* @param evaluation the evaluation
	* @return the evaluation that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation addEvaluation(
		com.liferay.famocom.erpcloud.model.Evaluation evaluation) {
		return _evaluationLocalService.addEvaluation(evaluation);
	}

	/**
	* Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	*
	* @param evaluationId the primary key for the new evaluation
	* @return the new evaluation
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation createEvaluation(
		long evaluationId) {
		return _evaluationLocalService.createEvaluation(evaluationId);
	}

	/**
	* Deletes the evaluation from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluation the evaluation
	* @return the evaluation that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation deleteEvaluation(
		com.liferay.famocom.erpcloud.model.Evaluation evaluation) {
		return _evaluationLocalService.deleteEvaluation(evaluation);
	}

	/**
	* Deletes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation that was removed
	* @throws PortalException if a evaluation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation deleteEvaluation(
		long evaluationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _evaluationLocalService.deleteEvaluation(evaluationId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _evaluationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _evaluationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _evaluationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _evaluationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _evaluationLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _evaluationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _evaluationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation fetchEvaluation(
		long evaluationId) {
		return _evaluationLocalService.fetchEvaluation(evaluationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _evaluationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the evaluation with the primary key.
	*
	* @param evaluationId the primary key of the evaluation
	* @return the evaluation
	* @throws PortalException if a evaluation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation getEvaluation(
		long evaluationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _evaluationLocalService.getEvaluation(evaluationId);
	}

	/**
	* Returns a range of all the evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.EvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluations
	* @param end the upper bound of the range of evaluations (not inclusive)
	* @return the range of evaluations
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.Evaluation> getEvaluations(
		int start, int end) {
		return _evaluationLocalService.getEvaluations(start, end);
	}

	/**
	* Returns the number of evaluations.
	*
	* @return the number of evaluations
	*/
	@Override
	public int getEvaluationsCount() {
		return _evaluationLocalService.getEvaluationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _evaluationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _evaluationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _evaluationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the evaluation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param evaluation the evaluation
	* @return the evaluation that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.Evaluation updateEvaluation(
		com.liferay.famocom.erpcloud.model.Evaluation evaluation) {
		return _evaluationLocalService.updateEvaluation(evaluation);
	}

	@Override
	public EvaluationLocalService getWrappedService() {
		return _evaluationLocalService;
	}

	@Override
	public void setWrappedService(EvaluationLocalService evaluationLocalService) {
		_evaluationLocalService = evaluationLocalService;
	}

	private EvaluationLocalService _evaluationLocalService;
}