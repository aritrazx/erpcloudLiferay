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
 * Provides a wrapper for {@link InterviewEvaluationLocalService}.
 *
 * @author Samaresh
 * @see InterviewEvaluationLocalService
 * @generated
 */
@ProviderType
public class InterviewEvaluationLocalServiceWrapper
	implements InterviewEvaluationLocalService,
		ServiceWrapper<InterviewEvaluationLocalService> {
	public InterviewEvaluationLocalServiceWrapper(
		InterviewEvaluationLocalService interviewEvaluationLocalService) {
		_interviewEvaluationLocalService = interviewEvaluationLocalService;
	}

	/**
	* Adds the interview evaluation to the database. Also notifies the appropriate model listeners.
	*
	* @param interviewEvaluation the interview evaluation
	* @return the interview evaluation that was added
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation addInterviewEvaluation(
		com.liferay.famocom.erpcloud.model.InterviewEvaluation interviewEvaluation) {
		return _interviewEvaluationLocalService.addInterviewEvaluation(interviewEvaluation);
	}

	/**
	* Creates a new interview evaluation with the primary key. Does not add the interview evaluation to the database.
	*
	* @param evaluationId the primary key for the new interview evaluation
	* @return the new interview evaluation
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation createInterviewEvaluation(
		long evaluationId) {
		return _interviewEvaluationLocalService.createInterviewEvaluation(evaluationId);
	}

	/**
	* Deletes the interview evaluation from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewEvaluation the interview evaluation
	* @return the interview evaluation that was removed
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation deleteInterviewEvaluation(
		com.liferay.famocom.erpcloud.model.InterviewEvaluation interviewEvaluation) {
		return _interviewEvaluationLocalService.deleteInterviewEvaluation(interviewEvaluation);
	}

	/**
	* Deletes the interview evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation that was removed
	* @throws PortalException if a interview evaluation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation deleteInterviewEvaluation(
		long evaluationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _interviewEvaluationLocalService.deleteInterviewEvaluation(evaluationId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _interviewEvaluationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interviewEvaluationLocalService.dynamicQuery();
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
		return _interviewEvaluationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _interviewEvaluationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _interviewEvaluationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _interviewEvaluationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _interviewEvaluationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation fetchInterviewEvaluation(
		long evaluationId) {
		return _interviewEvaluationLocalService.fetchInterviewEvaluation(evaluationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _interviewEvaluationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _interviewEvaluationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the interview evaluation with the primary key.
	*
	* @param evaluationId the primary key of the interview evaluation
	* @return the interview evaluation
	* @throws PortalException if a interview evaluation with the primary key could not be found
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation getInterviewEvaluation(
		long evaluationId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _interviewEvaluationLocalService.getInterviewEvaluation(evaluationId);
	}

	/**
	* Returns a range of all the interview evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.InterviewEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview evaluations
	* @param end the upper bound of the range of interview evaluations (not inclusive)
	* @return the range of interview evaluations
	*/
	@Override
	public java.util.List<com.liferay.famocom.erpcloud.model.InterviewEvaluation> getInterviewEvaluations(
		int start, int end) {
		return _interviewEvaluationLocalService.getInterviewEvaluations(start,
			end);
	}

	/**
	* Returns the number of interview evaluations.
	*
	* @return the number of interview evaluations
	*/
	@Override
	public int getInterviewEvaluationsCount() {
		return _interviewEvaluationLocalService.getInterviewEvaluationsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _interviewEvaluationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _interviewEvaluationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the interview evaluation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interviewEvaluation the interview evaluation
	* @return the interview evaluation that was updated
	*/
	@Override
	public com.liferay.famocom.erpcloud.model.InterviewEvaluation updateInterviewEvaluation(
		com.liferay.famocom.erpcloud.model.InterviewEvaluation interviewEvaluation) {
		return _interviewEvaluationLocalService.updateInterviewEvaluation(interviewEvaluation);
	}

	@Override
	public InterviewEvaluationLocalService getWrappedService() {
		return _interviewEvaluationLocalService;
	}

	@Override
	public void setWrappedService(
		InterviewEvaluationLocalService interviewEvaluationLocalService) {
		_interviewEvaluationLocalService = interviewEvaluationLocalService;
	}

	private InterviewEvaluationLocalService _interviewEvaluationLocalService;
}