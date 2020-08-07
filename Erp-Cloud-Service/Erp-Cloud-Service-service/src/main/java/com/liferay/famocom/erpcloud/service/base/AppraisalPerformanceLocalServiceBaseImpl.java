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

package com.liferay.famocom.erpcloud.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.famocom.erpcloud.model.AppraisalPerformance;
import com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService;
import com.liferay.famocom.erpcloud.service.persistence.AddTeamMemberPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalPerformancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalProjectMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalSetupPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AttendanceBioPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AttendanceCheckListPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AttendancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.BankMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.BillDocumentUploadFilePersistence;
import com.liferay.famocom.erpcloud.service.persistence.BillingPersistence;
import com.liferay.famocom.erpcloud.service.persistence.BookingRoomPersistence;
import com.liferay.famocom.erpcloud.service.persistence.BranchPersistence;
import com.liferay.famocom.erpcloud.service.persistence.CandidateApplyPersistence;
import com.liferay.famocom.erpcloud.service.persistence.CandidateEvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.CandidatePayStructureMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.CandidateReviewPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ClientMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.CompanyPolicyPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ConferenceRoomPersistence;
import com.liferay.famocom.erpcloud.service.persistence.DocumentUploadFilePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmailTemplatePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmpPayStructureFinder;
import com.liferay.famocom.erpcloud.service.persistence.EmpPayStructurePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeDocumentUploadPersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeFinder;
import com.liferay.famocom.erpcloud.service.persistence.EmployeePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeTypePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpCategoryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpProofFilesPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryHistoryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpensePersistence;
import com.liferay.famocom.erpcloud.service.persistence.FinSalaryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.FormSixteenErrorFilePersistence;
import com.liferay.famocom.erpcloud.service.persistence.FormSixteenPersistence;
import com.liferay.famocom.erpcloud.service.persistence.GeoAttendancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.GoalDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.GoalMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.HolidayCalenderManagementPersistence;
import com.liferay.famocom.erpcloud.service.persistence.IncomeTaxSlabPersistence;
import com.liferay.famocom.erpcloud.service.persistence.InterviewEvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.JobEvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.JobOpeningPersistence;
import com.liferay.famocom.erpcloud.service.persistence.JobPostPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyDtlPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveDocPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveManagementPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveObPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveTypePersistence;
import com.liferay.famocom.erpcloud.service.persistence.MilestonePersistence;
import com.liferay.famocom.erpcloud.service.persistence.MonthlyAdjustmentPersistence;
import com.liferay.famocom.erpcloud.service.persistence.NotificationMasterManagePersistence;
import com.liferay.famocom.erpcloud.service.persistence.NotificationSendManagePersistence;
import com.liferay.famocom.erpcloud.service.persistence.PayComponentPersistence;
import com.liferay.famocom.erpcloud.service.persistence.PayrollIncrementPersistence;
import com.liferay.famocom.erpcloud.service.persistence.PayrollSlabsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.PerformanceMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.PerformancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectRolePersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectStatusPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectTaskPersistence;
import com.liferay.famocom.erpcloud.service.persistence.PushNotificationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.RatingMasterFinder;
import com.liferay.famocom.erpcloud.service.persistence.RatingMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.RecruitProcessPersistence;
import com.liferay.famocom.erpcloud.service.persistence.RecruitmentProcessPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ResignationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SalDetailsFinder;
import com.liferay.famocom.erpcloud.service.persistence.SalDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SelectedCandidatePayStructurePersistence;
import com.liferay.famocom.erpcloud.service.persistence.SkillSetPersistence;
import com.liferay.famocom.erpcloud.service.persistence.StopPayPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaskMasterMappingPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaskMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationMonthlyPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaxDeclarationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaxProofFilesPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TaxSettingPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TimeSheetEntryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TimeSheetMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TravelDeskDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.WorkFromHomePersistence;
import com.liferay.famocom.erpcloud.service.persistence.WorksSchedulesPersistence;
import com.liferay.famocom.erpcloud.service.persistence.YearSettingPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the appraisal performance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.famocom.erpcloud.service.impl.AppraisalPerformanceLocalServiceImpl}.
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.impl.AppraisalPerformanceLocalServiceImpl
 * @see com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AppraisalPerformanceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AppraisalPerformanceLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalServiceUtil} to access the appraisal performance local service.
	 */

	/**
	 * Adds the appraisal performance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalPerformance the appraisal performance
	 * @return the appraisal performance that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppraisalPerformance addAppraisalPerformance(
		AppraisalPerformance appraisalPerformance) {
		appraisalPerformance.setNew(true);

		return appraisalPerformancePersistence.update(appraisalPerformance);
	}

	/**
	 * Creates a new appraisal performance with the primary key. Does not add the appraisal performance to the database.
	 *
	 * @param appraisalPerformanceId the primary key for the new appraisal performance
	 * @return the new appraisal performance
	 */
	@Override
	@Transactional(enabled = false)
	public AppraisalPerformance createAppraisalPerformance(
		long appraisalPerformanceId) {
		return appraisalPerformancePersistence.create(appraisalPerformanceId);
	}

	/**
	 * Deletes the appraisal performance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalPerformanceId the primary key of the appraisal performance
	 * @return the appraisal performance that was removed
	 * @throws PortalException if a appraisal performance with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AppraisalPerformance deleteAppraisalPerformance(
		long appraisalPerformanceId) throws PortalException {
		return appraisalPerformancePersistence.remove(appraisalPerformanceId);
	}

	/**
	 * Deletes the appraisal performance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalPerformance the appraisal performance
	 * @return the appraisal performance that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AppraisalPerformance deleteAppraisalPerformance(
		AppraisalPerformance appraisalPerformance) {
		return appraisalPerformancePersistence.remove(appraisalPerformance);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AppraisalPerformance.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return appraisalPerformancePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return appraisalPerformancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return appraisalPerformancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return appraisalPerformancePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return appraisalPerformancePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AppraisalPerformance fetchAppraisalPerformance(
		long appraisalPerformanceId) {
		return appraisalPerformancePersistence.fetchByPrimaryKey(appraisalPerformanceId);
	}

	/**
	 * Returns the appraisal performance with the primary key.
	 *
	 * @param appraisalPerformanceId the primary key of the appraisal performance
	 * @return the appraisal performance
	 * @throws PortalException if a appraisal performance with the primary key could not be found
	 */
	@Override
	public AppraisalPerformance getAppraisalPerformance(
		long appraisalPerformanceId) throws PortalException {
		return appraisalPerformancePersistence.findByPrimaryKey(appraisalPerformanceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(appraisalPerformanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AppraisalPerformance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"appraisalPerformanceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(appraisalPerformanceLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AppraisalPerformance.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"appraisalPerformanceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(appraisalPerformanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AppraisalPerformance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"appraisalPerformanceId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return appraisalPerformanceLocalService.deleteAppraisalPerformance((AppraisalPerformance)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return appraisalPerformancePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the appraisal performances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.AppraisalPerformanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of appraisal performances
	 * @param end the upper bound of the range of appraisal performances (not inclusive)
	 * @return the range of appraisal performances
	 */
	@Override
	public List<AppraisalPerformance> getAppraisalPerformances(int start,
		int end) {
		return appraisalPerformancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of appraisal performances.
	 *
	 * @return the number of appraisal performances
	 */
	@Override
	public int getAppraisalPerformancesCount() {
		return appraisalPerformancePersistence.countAll();
	}

	/**
	 * Updates the appraisal performance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param appraisalPerformance the appraisal performance
	 * @return the appraisal performance that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppraisalPerformance updateAppraisalPerformance(
		AppraisalPerformance appraisalPerformance) {
		return appraisalPerformancePersistence.update(appraisalPerformance);
	}

	/**
	 * Returns the add team member local service.
	 *
	 * @return the add team member local service
	 */
	public com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService getAddTeamMemberLocalService() {
		return addTeamMemberLocalService;
	}

	/**
	 * Sets the add team member local service.
	 *
	 * @param addTeamMemberLocalService the add team member local service
	 */
	public void setAddTeamMemberLocalService(
		com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService addTeamMemberLocalService) {
		this.addTeamMemberLocalService = addTeamMemberLocalService;
	}

	/**
	 * Returns the add team member persistence.
	 *
	 * @return the add team member persistence
	 */
	public AddTeamMemberPersistence getAddTeamMemberPersistence() {
		return addTeamMemberPersistence;
	}

	/**
	 * Sets the add team member persistence.
	 *
	 * @param addTeamMemberPersistence the add team member persistence
	 */
	public void setAddTeamMemberPersistence(
		AddTeamMemberPersistence addTeamMemberPersistence) {
		this.addTeamMemberPersistence = addTeamMemberPersistence;
	}

	/**
	 * Returns the appraisal goal details local service.
	 *
	 * @return the appraisal goal details local service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService getAppraisalGoalDetailsLocalService() {
		return appraisalGoalDetailsLocalService;
	}

	/**
	 * Sets the appraisal goal details local service.
	 *
	 * @param appraisalGoalDetailsLocalService the appraisal goal details local service
	 */
	public void setAppraisalGoalDetailsLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService appraisalGoalDetailsLocalService) {
		this.appraisalGoalDetailsLocalService = appraisalGoalDetailsLocalService;
	}

	/**
	 * Returns the appraisal goal details persistence.
	 *
	 * @return the appraisal goal details persistence
	 */
	public AppraisalGoalDetailsPersistence getAppraisalGoalDetailsPersistence() {
		return appraisalGoalDetailsPersistence;
	}

	/**
	 * Sets the appraisal goal details persistence.
	 *
	 * @param appraisalGoalDetailsPersistence the appraisal goal details persistence
	 */
	public void setAppraisalGoalDetailsPersistence(
		AppraisalGoalDetailsPersistence appraisalGoalDetailsPersistence) {
		this.appraisalGoalDetailsPersistence = appraisalGoalDetailsPersistence;
	}

	/**
	 * Returns the appraisal goal master local service.
	 *
	 * @return the appraisal goal master local service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService getAppraisalGoalMasterLocalService() {
		return appraisalGoalMasterLocalService;
	}

	/**
	 * Sets the appraisal goal master local service.
	 *
	 * @param appraisalGoalMasterLocalService the appraisal goal master local service
	 */
	public void setAppraisalGoalMasterLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService appraisalGoalMasterLocalService) {
		this.appraisalGoalMasterLocalService = appraisalGoalMasterLocalService;
	}

	/**
	 * Returns the appraisal goal master persistence.
	 *
	 * @return the appraisal goal master persistence
	 */
	public AppraisalGoalMasterPersistence getAppraisalGoalMasterPersistence() {
		return appraisalGoalMasterPersistence;
	}

	/**
	 * Sets the appraisal goal master persistence.
	 *
	 * @param appraisalGoalMasterPersistence the appraisal goal master persistence
	 */
	public void setAppraisalGoalMasterPersistence(
		AppraisalGoalMasterPersistence appraisalGoalMasterPersistence) {
		this.appraisalGoalMasterPersistence = appraisalGoalMasterPersistence;
	}

	/**
	 * Returns the appraisal master local service.
	 *
	 * @return the appraisal master local service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService getAppraisalMasterLocalService() {
		return appraisalMasterLocalService;
	}

	/**
	 * Sets the appraisal master local service.
	 *
	 * @param appraisalMasterLocalService the appraisal master local service
	 */
	public void setAppraisalMasterLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService appraisalMasterLocalService) {
		this.appraisalMasterLocalService = appraisalMasterLocalService;
	}

	/**
	 * Returns the appraisal master persistence.
	 *
	 * @return the appraisal master persistence
	 */
	public AppraisalMasterPersistence getAppraisalMasterPersistence() {
		return appraisalMasterPersistence;
	}

	/**
	 * Sets the appraisal master persistence.
	 *
	 * @param appraisalMasterPersistence the appraisal master persistence
	 */
	public void setAppraisalMasterPersistence(
		AppraisalMasterPersistence appraisalMasterPersistence) {
		this.appraisalMasterPersistence = appraisalMasterPersistence;
	}

	/**
	 * Returns the appraisal performance local service.
	 *
	 * @return the appraisal performance local service
	 */
	public AppraisalPerformanceLocalService getAppraisalPerformanceLocalService() {
		return appraisalPerformanceLocalService;
	}

	/**
	 * Sets the appraisal performance local service.
	 *
	 * @param appraisalPerformanceLocalService the appraisal performance local service
	 */
	public void setAppraisalPerformanceLocalService(
		AppraisalPerformanceLocalService appraisalPerformanceLocalService) {
		this.appraisalPerformanceLocalService = appraisalPerformanceLocalService;
	}

	/**
	 * Returns the appraisal performance persistence.
	 *
	 * @return the appraisal performance persistence
	 */
	public AppraisalPerformancePersistence getAppraisalPerformancePersistence() {
		return appraisalPerformancePersistence;
	}

	/**
	 * Sets the appraisal performance persistence.
	 *
	 * @param appraisalPerformancePersistence the appraisal performance persistence
	 */
	public void setAppraisalPerformancePersistence(
		AppraisalPerformancePersistence appraisalPerformancePersistence) {
		this.appraisalPerformancePersistence = appraisalPerformancePersistence;
	}

	/**
	 * Returns the appraisal project master local service.
	 *
	 * @return the appraisal project master local service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService getAppraisalProjectMasterLocalService() {
		return appraisalProjectMasterLocalService;
	}

	/**
	 * Sets the appraisal project master local service.
	 *
	 * @param appraisalProjectMasterLocalService the appraisal project master local service
	 */
	public void setAppraisalProjectMasterLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService appraisalProjectMasterLocalService) {
		this.appraisalProjectMasterLocalService = appraisalProjectMasterLocalService;
	}

	/**
	 * Returns the appraisal project master persistence.
	 *
	 * @return the appraisal project master persistence
	 */
	public AppraisalProjectMasterPersistence getAppraisalProjectMasterPersistence() {
		return appraisalProjectMasterPersistence;
	}

	/**
	 * Sets the appraisal project master persistence.
	 *
	 * @param appraisalProjectMasterPersistence the appraisal project master persistence
	 */
	public void setAppraisalProjectMasterPersistence(
		AppraisalProjectMasterPersistence appraisalProjectMasterPersistence) {
		this.appraisalProjectMasterPersistence = appraisalProjectMasterPersistence;
	}

	/**
	 * Returns the appraisal setup local service.
	 *
	 * @return the appraisal setup local service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService getAppraisalSetupLocalService() {
		return appraisalSetupLocalService;
	}

	/**
	 * Sets the appraisal setup local service.
	 *
	 * @param appraisalSetupLocalService the appraisal setup local service
	 */
	public void setAppraisalSetupLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService appraisalSetupLocalService) {
		this.appraisalSetupLocalService = appraisalSetupLocalService;
	}

	/**
	 * Returns the appraisal setup persistence.
	 *
	 * @return the appraisal setup persistence
	 */
	public AppraisalSetupPersistence getAppraisalSetupPersistence() {
		return appraisalSetupPersistence;
	}

	/**
	 * Sets the appraisal setup persistence.
	 *
	 * @param appraisalSetupPersistence the appraisal setup persistence
	 */
	public void setAppraisalSetupPersistence(
		AppraisalSetupPersistence appraisalSetupPersistence) {
		this.appraisalSetupPersistence = appraisalSetupPersistence;
	}

	/**
	 * Returns the attendance local service.
	 *
	 * @return the attendance local service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceLocalService getAttendanceLocalService() {
		return attendanceLocalService;
	}

	/**
	 * Sets the attendance local service.
	 *
	 * @param attendanceLocalService the attendance local service
	 */
	public void setAttendanceLocalService(
		com.liferay.famocom.erpcloud.service.AttendanceLocalService attendanceLocalService) {
		this.attendanceLocalService = attendanceLocalService;
	}

	/**
	 * Returns the attendance persistence.
	 *
	 * @return the attendance persistence
	 */
	public AttendancePersistence getAttendancePersistence() {
		return attendancePersistence;
	}

	/**
	 * Sets the attendance persistence.
	 *
	 * @param attendancePersistence the attendance persistence
	 */
	public void setAttendancePersistence(
		AttendancePersistence attendancePersistence) {
		this.attendancePersistence = attendancePersistence;
	}

	/**
	 * Returns the attendance bio local service.
	 *
	 * @return the attendance bio local service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceBioLocalService getAttendanceBioLocalService() {
		return attendanceBioLocalService;
	}

	/**
	 * Sets the attendance bio local service.
	 *
	 * @param attendanceBioLocalService the attendance bio local service
	 */
	public void setAttendanceBioLocalService(
		com.liferay.famocom.erpcloud.service.AttendanceBioLocalService attendanceBioLocalService) {
		this.attendanceBioLocalService = attendanceBioLocalService;
	}

	/**
	 * Returns the attendance bio persistence.
	 *
	 * @return the attendance bio persistence
	 */
	public AttendanceBioPersistence getAttendanceBioPersistence() {
		return attendanceBioPersistence;
	}

	/**
	 * Sets the attendance bio persistence.
	 *
	 * @param attendanceBioPersistence the attendance bio persistence
	 */
	public void setAttendanceBioPersistence(
		AttendanceBioPersistence attendanceBioPersistence) {
		this.attendanceBioPersistence = attendanceBioPersistence;
	}

	/**
	 * Returns the attendance check list local service.
	 *
	 * @return the attendance check list local service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService getAttendanceCheckListLocalService() {
		return attendanceCheckListLocalService;
	}

	/**
	 * Sets the attendance check list local service.
	 *
	 * @param attendanceCheckListLocalService the attendance check list local service
	 */
	public void setAttendanceCheckListLocalService(
		com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService attendanceCheckListLocalService) {
		this.attendanceCheckListLocalService = attendanceCheckListLocalService;
	}

	/**
	 * Returns the attendance check list persistence.
	 *
	 * @return the attendance check list persistence
	 */
	public AttendanceCheckListPersistence getAttendanceCheckListPersistence() {
		return attendanceCheckListPersistence;
	}

	/**
	 * Sets the attendance check list persistence.
	 *
	 * @param attendanceCheckListPersistence the attendance check list persistence
	 */
	public void setAttendanceCheckListPersistence(
		AttendanceCheckListPersistence attendanceCheckListPersistence) {
		this.attendanceCheckListPersistence = attendanceCheckListPersistence;
	}

	/**
	 * Returns the bank master local service.
	 *
	 * @return the bank master local service
	 */
	public com.liferay.famocom.erpcloud.service.BankMasterLocalService getBankMasterLocalService() {
		return bankMasterLocalService;
	}

	/**
	 * Sets the bank master local service.
	 *
	 * @param bankMasterLocalService the bank master local service
	 */
	public void setBankMasterLocalService(
		com.liferay.famocom.erpcloud.service.BankMasterLocalService bankMasterLocalService) {
		this.bankMasterLocalService = bankMasterLocalService;
	}

	/**
	 * Returns the bank master persistence.
	 *
	 * @return the bank master persistence
	 */
	public BankMasterPersistence getBankMasterPersistence() {
		return bankMasterPersistence;
	}

	/**
	 * Sets the bank master persistence.
	 *
	 * @param bankMasterPersistence the bank master persistence
	 */
	public void setBankMasterPersistence(
		BankMasterPersistence bankMasterPersistence) {
		this.bankMasterPersistence = bankMasterPersistence;
	}

	/**
	 * Returns the bill document upload file local service.
	 *
	 * @return the bill document upload file local service
	 */
	public com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService getBillDocumentUploadFileLocalService() {
		return billDocumentUploadFileLocalService;
	}

	/**
	 * Sets the bill document upload file local service.
	 *
	 * @param billDocumentUploadFileLocalService the bill document upload file local service
	 */
	public void setBillDocumentUploadFileLocalService(
		com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService billDocumentUploadFileLocalService) {
		this.billDocumentUploadFileLocalService = billDocumentUploadFileLocalService;
	}

	/**
	 * Returns the bill document upload file persistence.
	 *
	 * @return the bill document upload file persistence
	 */
	public BillDocumentUploadFilePersistence getBillDocumentUploadFilePersistence() {
		return billDocumentUploadFilePersistence;
	}

	/**
	 * Sets the bill document upload file persistence.
	 *
	 * @param billDocumentUploadFilePersistence the bill document upload file persistence
	 */
	public void setBillDocumentUploadFilePersistence(
		BillDocumentUploadFilePersistence billDocumentUploadFilePersistence) {
		this.billDocumentUploadFilePersistence = billDocumentUploadFilePersistence;
	}

	/**
	 * Returns the billing local service.
	 *
	 * @return the billing local service
	 */
	public com.liferay.famocom.erpcloud.service.BillingLocalService getBillingLocalService() {
		return billingLocalService;
	}

	/**
	 * Sets the billing local service.
	 *
	 * @param billingLocalService the billing local service
	 */
	public void setBillingLocalService(
		com.liferay.famocom.erpcloud.service.BillingLocalService billingLocalService) {
		this.billingLocalService = billingLocalService;
	}

	/**
	 * Returns the billing persistence.
	 *
	 * @return the billing persistence
	 */
	public BillingPersistence getBillingPersistence() {
		return billingPersistence;
	}

	/**
	 * Sets the billing persistence.
	 *
	 * @param billingPersistence the billing persistence
	 */
	public void setBillingPersistence(BillingPersistence billingPersistence) {
		this.billingPersistence = billingPersistence;
	}

	/**
	 * Returns the booking room local service.
	 *
	 * @return the booking room local service
	 */
	public com.liferay.famocom.erpcloud.service.BookingRoomLocalService getBookingRoomLocalService() {
		return bookingRoomLocalService;
	}

	/**
	 * Sets the booking room local service.
	 *
	 * @param bookingRoomLocalService the booking room local service
	 */
	public void setBookingRoomLocalService(
		com.liferay.famocom.erpcloud.service.BookingRoomLocalService bookingRoomLocalService) {
		this.bookingRoomLocalService = bookingRoomLocalService;
	}

	/**
	 * Returns the booking room persistence.
	 *
	 * @return the booking room persistence
	 */
	public BookingRoomPersistence getBookingRoomPersistence() {
		return bookingRoomPersistence;
	}

	/**
	 * Sets the booking room persistence.
	 *
	 * @param bookingRoomPersistence the booking room persistence
	 */
	public void setBookingRoomPersistence(
		BookingRoomPersistence bookingRoomPersistence) {
		this.bookingRoomPersistence = bookingRoomPersistence;
	}

	/**
	 * Returns the branch local service.
	 *
	 * @return the branch local service
	 */
	public com.liferay.famocom.erpcloud.service.BranchLocalService getBranchLocalService() {
		return branchLocalService;
	}

	/**
	 * Sets the branch local service.
	 *
	 * @param branchLocalService the branch local service
	 */
	public void setBranchLocalService(
		com.liferay.famocom.erpcloud.service.BranchLocalService branchLocalService) {
		this.branchLocalService = branchLocalService;
	}

	/**
	 * Returns the branch persistence.
	 *
	 * @return the branch persistence
	 */
	public BranchPersistence getBranchPersistence() {
		return branchPersistence;
	}

	/**
	 * Sets the branch persistence.
	 *
	 * @param branchPersistence the branch persistence
	 */
	public void setBranchPersistence(BranchPersistence branchPersistence) {
		this.branchPersistence = branchPersistence;
	}

	/**
	 * Returns the candidate apply local service.
	 *
	 * @return the candidate apply local service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateApplyLocalService getCandidateApplyLocalService() {
		return candidateApplyLocalService;
	}

	/**
	 * Sets the candidate apply local service.
	 *
	 * @param candidateApplyLocalService the candidate apply local service
	 */
	public void setCandidateApplyLocalService(
		com.liferay.famocom.erpcloud.service.CandidateApplyLocalService candidateApplyLocalService) {
		this.candidateApplyLocalService = candidateApplyLocalService;
	}

	/**
	 * Returns the candidate apply persistence.
	 *
	 * @return the candidate apply persistence
	 */
	public CandidateApplyPersistence getCandidateApplyPersistence() {
		return candidateApplyPersistence;
	}

	/**
	 * Sets the candidate apply persistence.
	 *
	 * @param candidateApplyPersistence the candidate apply persistence
	 */
	public void setCandidateApplyPersistence(
		CandidateApplyPersistence candidateApplyPersistence) {
		this.candidateApplyPersistence = candidateApplyPersistence;
	}

	/**
	 * Returns the candidate evaluation local service.
	 *
	 * @return the candidate evaluation local service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService getCandidateEvaluationLocalService() {
		return candidateEvaluationLocalService;
	}

	/**
	 * Sets the candidate evaluation local service.
	 *
	 * @param candidateEvaluationLocalService the candidate evaluation local service
	 */
	public void setCandidateEvaluationLocalService(
		com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService candidateEvaluationLocalService) {
		this.candidateEvaluationLocalService = candidateEvaluationLocalService;
	}

	/**
	 * Returns the candidate evaluation persistence.
	 *
	 * @return the candidate evaluation persistence
	 */
	public CandidateEvaluationPersistence getCandidateEvaluationPersistence() {
		return candidateEvaluationPersistence;
	}

	/**
	 * Sets the candidate evaluation persistence.
	 *
	 * @param candidateEvaluationPersistence the candidate evaluation persistence
	 */
	public void setCandidateEvaluationPersistence(
		CandidateEvaluationPersistence candidateEvaluationPersistence) {
		this.candidateEvaluationPersistence = candidateEvaluationPersistence;
	}

	/**
	 * Returns the candidate pay structure master local service.
	 *
	 * @return the candidate pay structure master local service
	 */
	public com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService getCandidatePayStructureMasterLocalService() {
		return candidatePayStructureMasterLocalService;
	}

	/**
	 * Sets the candidate pay structure master local service.
	 *
	 * @param candidatePayStructureMasterLocalService the candidate pay structure master local service
	 */
	public void setCandidatePayStructureMasterLocalService(
		com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService candidatePayStructureMasterLocalService) {
		this.candidatePayStructureMasterLocalService = candidatePayStructureMasterLocalService;
	}

	/**
	 * Returns the candidate pay structure master persistence.
	 *
	 * @return the candidate pay structure master persistence
	 */
	public CandidatePayStructureMasterPersistence getCandidatePayStructureMasterPersistence() {
		return candidatePayStructureMasterPersistence;
	}

	/**
	 * Sets the candidate pay structure master persistence.
	 *
	 * @param candidatePayStructureMasterPersistence the candidate pay structure master persistence
	 */
	public void setCandidatePayStructureMasterPersistence(
		CandidatePayStructureMasterPersistence candidatePayStructureMasterPersistence) {
		this.candidatePayStructureMasterPersistence = candidatePayStructureMasterPersistence;
	}

	/**
	 * Returns the candidate review local service.
	 *
	 * @return the candidate review local service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateReviewLocalService getCandidateReviewLocalService() {
		return candidateReviewLocalService;
	}

	/**
	 * Sets the candidate review local service.
	 *
	 * @param candidateReviewLocalService the candidate review local service
	 */
	public void setCandidateReviewLocalService(
		com.liferay.famocom.erpcloud.service.CandidateReviewLocalService candidateReviewLocalService) {
		this.candidateReviewLocalService = candidateReviewLocalService;
	}

	/**
	 * Returns the candidate review persistence.
	 *
	 * @return the candidate review persistence
	 */
	public CandidateReviewPersistence getCandidateReviewPersistence() {
		return candidateReviewPersistence;
	}

	/**
	 * Sets the candidate review persistence.
	 *
	 * @param candidateReviewPersistence the candidate review persistence
	 */
	public void setCandidateReviewPersistence(
		CandidateReviewPersistence candidateReviewPersistence) {
		this.candidateReviewPersistence = candidateReviewPersistence;
	}

	/**
	 * Returns the client master local service.
	 *
	 * @return the client master local service
	 */
	public com.liferay.famocom.erpcloud.service.ClientMasterLocalService getClientMasterLocalService() {
		return clientMasterLocalService;
	}

	/**
	 * Sets the client master local service.
	 *
	 * @param clientMasterLocalService the client master local service
	 */
	public void setClientMasterLocalService(
		com.liferay.famocom.erpcloud.service.ClientMasterLocalService clientMasterLocalService) {
		this.clientMasterLocalService = clientMasterLocalService;
	}

	/**
	 * Returns the client master persistence.
	 *
	 * @return the client master persistence
	 */
	public ClientMasterPersistence getClientMasterPersistence() {
		return clientMasterPersistence;
	}

	/**
	 * Sets the client master persistence.
	 *
	 * @param clientMasterPersistence the client master persistence
	 */
	public void setClientMasterPersistence(
		ClientMasterPersistence clientMasterPersistence) {
		this.clientMasterPersistence = clientMasterPersistence;
	}

	/**
	 * Returns the company policy local service.
	 *
	 * @return the company policy local service
	 */
	public com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService getCompanyPolicyLocalService() {
		return companyPolicyLocalService;
	}

	/**
	 * Sets the company policy local service.
	 *
	 * @param companyPolicyLocalService the company policy local service
	 */
	public void setCompanyPolicyLocalService(
		com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService companyPolicyLocalService) {
		this.companyPolicyLocalService = companyPolicyLocalService;
	}

	/**
	 * Returns the company policy persistence.
	 *
	 * @return the company policy persistence
	 */
	public CompanyPolicyPersistence getCompanyPolicyPersistence() {
		return companyPolicyPersistence;
	}

	/**
	 * Sets the company policy persistence.
	 *
	 * @param companyPolicyPersistence the company policy persistence
	 */
	public void setCompanyPolicyPersistence(
		CompanyPolicyPersistence companyPolicyPersistence) {
		this.companyPolicyPersistence = companyPolicyPersistence;
	}

	/**
	 * Returns the conference room local service.
	 *
	 * @return the conference room local service
	 */
	public com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService getConferenceRoomLocalService() {
		return conferenceRoomLocalService;
	}

	/**
	 * Sets the conference room local service.
	 *
	 * @param conferenceRoomLocalService the conference room local service
	 */
	public void setConferenceRoomLocalService(
		com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService conferenceRoomLocalService) {
		this.conferenceRoomLocalService = conferenceRoomLocalService;
	}

	/**
	 * Returns the conference room persistence.
	 *
	 * @return the conference room persistence
	 */
	public ConferenceRoomPersistence getConferenceRoomPersistence() {
		return conferenceRoomPersistence;
	}

	/**
	 * Sets the conference room persistence.
	 *
	 * @param conferenceRoomPersistence the conference room persistence
	 */
	public void setConferenceRoomPersistence(
		ConferenceRoomPersistence conferenceRoomPersistence) {
		this.conferenceRoomPersistence = conferenceRoomPersistence;
	}

	/**
	 * Returns the document upload file local service.
	 *
	 * @return the document upload file local service
	 */
	public com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService getDocumentUploadFileLocalService() {
		return documentUploadFileLocalService;
	}

	/**
	 * Sets the document upload file local service.
	 *
	 * @param documentUploadFileLocalService the document upload file local service
	 */
	public void setDocumentUploadFileLocalService(
		com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService documentUploadFileLocalService) {
		this.documentUploadFileLocalService = documentUploadFileLocalService;
	}

	/**
	 * Returns the document upload file persistence.
	 *
	 * @return the document upload file persistence
	 */
	public DocumentUploadFilePersistence getDocumentUploadFilePersistence() {
		return documentUploadFilePersistence;
	}

	/**
	 * Sets the document upload file persistence.
	 *
	 * @param documentUploadFilePersistence the document upload file persistence
	 */
	public void setDocumentUploadFilePersistence(
		DocumentUploadFilePersistence documentUploadFilePersistence) {
		this.documentUploadFilePersistence = documentUploadFilePersistence;
	}

	/**
	 * Returns the email template local service.
	 *
	 * @return the email template local service
	 */
	public com.liferay.famocom.erpcloud.service.EmailTemplateLocalService getEmailTemplateLocalService() {
		return emailTemplateLocalService;
	}

	/**
	 * Sets the email template local service.
	 *
	 * @param emailTemplateLocalService the email template local service
	 */
	public void setEmailTemplateLocalService(
		com.liferay.famocom.erpcloud.service.EmailTemplateLocalService emailTemplateLocalService) {
		this.emailTemplateLocalService = emailTemplateLocalService;
	}

	/**
	 * Returns the email template persistence.
	 *
	 * @return the email template persistence
	 */
	public EmailTemplatePersistence getEmailTemplatePersistence() {
		return emailTemplatePersistence;
	}

	/**
	 * Sets the email template persistence.
	 *
	 * @param emailTemplatePersistence the email template persistence
	 */
	public void setEmailTemplatePersistence(
		EmailTemplatePersistence emailTemplatePersistence) {
		this.emailTemplatePersistence = emailTemplatePersistence;
	}

	/**
	 * Returns the employee local service.
	 *
	 * @return the employee local service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeLocalService getEmployeeLocalService() {
		return employeeLocalService;
	}

	/**
	 * Sets the employee local service.
	 *
	 * @param employeeLocalService the employee local service
	 */
	public void setEmployeeLocalService(
		com.liferay.famocom.erpcloud.service.EmployeeLocalService employeeLocalService) {
		this.employeeLocalService = employeeLocalService;
	}

	/**
	 * Returns the employee persistence.
	 *
	 * @return the employee persistence
	 */
	public EmployeePersistence getEmployeePersistence() {
		return employeePersistence;
	}

	/**
	 * Sets the employee persistence.
	 *
	 * @param employeePersistence the employee persistence
	 */
	public void setEmployeePersistence(EmployeePersistence employeePersistence) {
		this.employeePersistence = employeePersistence;
	}

	/**
	 * Returns the employee finder.
	 *
	 * @return the employee finder
	 */
	public EmployeeFinder getEmployeeFinder() {
		return employeeFinder;
	}

	/**
	 * Sets the employee finder.
	 *
	 * @param employeeFinder the employee finder
	 */
	public void setEmployeeFinder(EmployeeFinder employeeFinder) {
		this.employeeFinder = employeeFinder;
	}

	/**
	 * Returns the employee document upload local service.
	 *
	 * @return the employee document upload local service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService getEmployeeDocumentUploadLocalService() {
		return employeeDocumentUploadLocalService;
	}

	/**
	 * Sets the employee document upload local service.
	 *
	 * @param employeeDocumentUploadLocalService the employee document upload local service
	 */
	public void setEmployeeDocumentUploadLocalService(
		com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService employeeDocumentUploadLocalService) {
		this.employeeDocumentUploadLocalService = employeeDocumentUploadLocalService;
	}

	/**
	 * Returns the employee document upload persistence.
	 *
	 * @return the employee document upload persistence
	 */
	public EmployeeDocumentUploadPersistence getEmployeeDocumentUploadPersistence() {
		return employeeDocumentUploadPersistence;
	}

	/**
	 * Sets the employee document upload persistence.
	 *
	 * @param employeeDocumentUploadPersistence the employee document upload persistence
	 */
	public void setEmployeeDocumentUploadPersistence(
		EmployeeDocumentUploadPersistence employeeDocumentUploadPersistence) {
		this.employeeDocumentUploadPersistence = employeeDocumentUploadPersistence;
	}

	/**
	 * Returns the employee type local service.
	 *
	 * @return the employee type local service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService getEmployeeTypeLocalService() {
		return employeeTypeLocalService;
	}

	/**
	 * Sets the employee type local service.
	 *
	 * @param employeeTypeLocalService the employee type local service
	 */
	public void setEmployeeTypeLocalService(
		com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService employeeTypeLocalService) {
		this.employeeTypeLocalService = employeeTypeLocalService;
	}

	/**
	 * Returns the employee type persistence.
	 *
	 * @return the employee type persistence
	 */
	public EmployeeTypePersistence getEmployeeTypePersistence() {
		return employeeTypePersistence;
	}

	/**
	 * Sets the employee type persistence.
	 *
	 * @param employeeTypePersistence the employee type persistence
	 */
	public void setEmployeeTypePersistence(
		EmployeeTypePersistence employeeTypePersistence) {
		this.employeeTypePersistence = employeeTypePersistence;
	}

	/**
	 * Returns the emp pay structure local service.
	 *
	 * @return the emp pay structure local service
	 */
	public com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService getEmpPayStructureLocalService() {
		return empPayStructureLocalService;
	}

	/**
	 * Sets the emp pay structure local service.
	 *
	 * @param empPayStructureLocalService the emp pay structure local service
	 */
	public void setEmpPayStructureLocalService(
		com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService empPayStructureLocalService) {
		this.empPayStructureLocalService = empPayStructureLocalService;
	}

	/**
	 * Returns the emp pay structure persistence.
	 *
	 * @return the emp pay structure persistence
	 */
	public EmpPayStructurePersistence getEmpPayStructurePersistence() {
		return empPayStructurePersistence;
	}

	/**
	 * Sets the emp pay structure persistence.
	 *
	 * @param empPayStructurePersistence the emp pay structure persistence
	 */
	public void setEmpPayStructurePersistence(
		EmpPayStructurePersistence empPayStructurePersistence) {
		this.empPayStructurePersistence = empPayStructurePersistence;
	}

	/**
	 * Returns the emp pay structure finder.
	 *
	 * @return the emp pay structure finder
	 */
	public EmpPayStructureFinder getEmpPayStructureFinder() {
		return empPayStructureFinder;
	}

	/**
	 * Sets the emp pay structure finder.
	 *
	 * @param empPayStructureFinder the emp pay structure finder
	 */
	public void setEmpPayStructureFinder(
		EmpPayStructureFinder empPayStructureFinder) {
		this.empPayStructureFinder = empPayStructureFinder;
	}

	/**
	 * Returns the evaluation local service.
	 *
	 * @return the evaluation local service
	 */
	public com.liferay.famocom.erpcloud.service.EvaluationLocalService getEvaluationLocalService() {
		return evaluationLocalService;
	}

	/**
	 * Sets the evaluation local service.
	 *
	 * @param evaluationLocalService the evaluation local service
	 */
	public void setEvaluationLocalService(
		com.liferay.famocom.erpcloud.service.EvaluationLocalService evaluationLocalService) {
		this.evaluationLocalService = evaluationLocalService;
	}

	/**
	 * Returns the evaluation persistence.
	 *
	 * @return the evaluation persistence
	 */
	public EvaluationPersistence getEvaluationPersistence() {
		return evaluationPersistence;
	}

	/**
	 * Sets the evaluation persistence.
	 *
	 * @param evaluationPersistence the evaluation persistence
	 */
	public void setEvaluationPersistence(
		EvaluationPersistence evaluationPersistence) {
		this.evaluationPersistence = evaluationPersistence;
	}

	/**
	 * Returns the exp category local service.
	 *
	 * @return the exp category local service
	 */
	public com.liferay.famocom.erpcloud.service.ExpCategoryLocalService getExpCategoryLocalService() {
		return expCategoryLocalService;
	}

	/**
	 * Sets the exp category local service.
	 *
	 * @param expCategoryLocalService the exp category local service
	 */
	public void setExpCategoryLocalService(
		com.liferay.famocom.erpcloud.service.ExpCategoryLocalService expCategoryLocalService) {
		this.expCategoryLocalService = expCategoryLocalService;
	}

	/**
	 * Returns the exp category persistence.
	 *
	 * @return the exp category persistence
	 */
	public ExpCategoryPersistence getExpCategoryPersistence() {
		return expCategoryPersistence;
	}

	/**
	 * Sets the exp category persistence.
	 *
	 * @param expCategoryPersistence the exp category persistence
	 */
	public void setExpCategoryPersistence(
		ExpCategoryPersistence expCategoryPersistence) {
		this.expCategoryPersistence = expCategoryPersistence;
	}

	/**
	 * Returns the expense local service.
	 *
	 * @return the expense local service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseLocalService getExpenseLocalService() {
		return expenseLocalService;
	}

	/**
	 * Sets the expense local service.
	 *
	 * @param expenseLocalService the expense local service
	 */
	public void setExpenseLocalService(
		com.liferay.famocom.erpcloud.service.ExpenseLocalService expenseLocalService) {
		this.expenseLocalService = expenseLocalService;
	}

	/**
	 * Returns the expense persistence.
	 *
	 * @return the expense persistence
	 */
	public ExpensePersistence getExpensePersistence() {
		return expensePersistence;
	}

	/**
	 * Sets the expense persistence.
	 *
	 * @param expensePersistence the expense persistence
	 */
	public void setExpensePersistence(ExpensePersistence expensePersistence) {
		this.expensePersistence = expensePersistence;
	}

	/**
	 * Returns the expense entry local service.
	 *
	 * @return the expense entry local service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService getExpenseEntryLocalService() {
		return expenseEntryLocalService;
	}

	/**
	 * Sets the expense entry local service.
	 *
	 * @param expenseEntryLocalService the expense entry local service
	 */
	public void setExpenseEntryLocalService(
		com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService expenseEntryLocalService) {
		this.expenseEntryLocalService = expenseEntryLocalService;
	}

	/**
	 * Returns the expense entry persistence.
	 *
	 * @return the expense entry persistence
	 */
	public ExpenseEntryPersistence getExpenseEntryPersistence() {
		return expenseEntryPersistence;
	}

	/**
	 * Sets the expense entry persistence.
	 *
	 * @param expenseEntryPersistence the expense entry persistence
	 */
	public void setExpenseEntryPersistence(
		ExpenseEntryPersistence expenseEntryPersistence) {
		this.expenseEntryPersistence = expenseEntryPersistence;
	}

	/**
	 * Returns the expense entry history local service.
	 *
	 * @return the expense entry history local service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService getExpenseEntryHistoryLocalService() {
		return expenseEntryHistoryLocalService;
	}

	/**
	 * Sets the expense entry history local service.
	 *
	 * @param expenseEntryHistoryLocalService the expense entry history local service
	 */
	public void setExpenseEntryHistoryLocalService(
		com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService) {
		this.expenseEntryHistoryLocalService = expenseEntryHistoryLocalService;
	}

	/**
	 * Returns the expense entry history persistence.
	 *
	 * @return the expense entry history persistence
	 */
	public ExpenseEntryHistoryPersistence getExpenseEntryHistoryPersistence() {
		return expenseEntryHistoryPersistence;
	}

	/**
	 * Sets the expense entry history persistence.
	 *
	 * @param expenseEntryHistoryPersistence the expense entry history persistence
	 */
	public void setExpenseEntryHistoryPersistence(
		ExpenseEntryHistoryPersistence expenseEntryHistoryPersistence) {
		this.expenseEntryHistoryPersistence = expenseEntryHistoryPersistence;
	}

	/**
	 * Returns the exp proof files local service.
	 *
	 * @return the exp proof files local service
	 */
	public com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService getExpProofFilesLocalService() {
		return expProofFilesLocalService;
	}

	/**
	 * Sets the exp proof files local service.
	 *
	 * @param expProofFilesLocalService the exp proof files local service
	 */
	public void setExpProofFilesLocalService(
		com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService expProofFilesLocalService) {
		this.expProofFilesLocalService = expProofFilesLocalService;
	}

	/**
	 * Returns the exp proof files persistence.
	 *
	 * @return the exp proof files persistence
	 */
	public ExpProofFilesPersistence getExpProofFilesPersistence() {
		return expProofFilesPersistence;
	}

	/**
	 * Sets the exp proof files persistence.
	 *
	 * @param expProofFilesPersistence the exp proof files persistence
	 */
	public void setExpProofFilesPersistence(
		ExpProofFilesPersistence expProofFilesPersistence) {
		this.expProofFilesPersistence = expProofFilesPersistence;
	}

	/**
	 * Returns the fin salary local service.
	 *
	 * @return the fin salary local service
	 */
	public com.liferay.famocom.erpcloud.service.FinSalaryLocalService getFinSalaryLocalService() {
		return finSalaryLocalService;
	}

	/**
	 * Sets the fin salary local service.
	 *
	 * @param finSalaryLocalService the fin salary local service
	 */
	public void setFinSalaryLocalService(
		com.liferay.famocom.erpcloud.service.FinSalaryLocalService finSalaryLocalService) {
		this.finSalaryLocalService = finSalaryLocalService;
	}

	/**
	 * Returns the fin salary persistence.
	 *
	 * @return the fin salary persistence
	 */
	public FinSalaryPersistence getFinSalaryPersistence() {
		return finSalaryPersistence;
	}

	/**
	 * Sets the fin salary persistence.
	 *
	 * @param finSalaryPersistence the fin salary persistence
	 */
	public void setFinSalaryPersistence(
		FinSalaryPersistence finSalaryPersistence) {
		this.finSalaryPersistence = finSalaryPersistence;
	}

	/**
	 * Returns the form sixteen local service.
	 *
	 * @return the form sixteen local service
	 */
	public com.liferay.famocom.erpcloud.service.FormSixteenLocalService getFormSixteenLocalService() {
		return formSixteenLocalService;
	}

	/**
	 * Sets the form sixteen local service.
	 *
	 * @param formSixteenLocalService the form sixteen local service
	 */
	public void setFormSixteenLocalService(
		com.liferay.famocom.erpcloud.service.FormSixteenLocalService formSixteenLocalService) {
		this.formSixteenLocalService = formSixteenLocalService;
	}

	/**
	 * Returns the form sixteen persistence.
	 *
	 * @return the form sixteen persistence
	 */
	public FormSixteenPersistence getFormSixteenPersistence() {
		return formSixteenPersistence;
	}

	/**
	 * Sets the form sixteen persistence.
	 *
	 * @param formSixteenPersistence the form sixteen persistence
	 */
	public void setFormSixteenPersistence(
		FormSixteenPersistence formSixteenPersistence) {
		this.formSixteenPersistence = formSixteenPersistence;
	}

	/**
	 * Returns the form sixteen error file local service.
	 *
	 * @return the form sixteen error file local service
	 */
	public com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService getFormSixteenErrorFileLocalService() {
		return formSixteenErrorFileLocalService;
	}

	/**
	 * Sets the form sixteen error file local service.
	 *
	 * @param formSixteenErrorFileLocalService the form sixteen error file local service
	 */
	public void setFormSixteenErrorFileLocalService(
		com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService formSixteenErrorFileLocalService) {
		this.formSixteenErrorFileLocalService = formSixteenErrorFileLocalService;
	}

	/**
	 * Returns the form sixteen error file persistence.
	 *
	 * @return the form sixteen error file persistence
	 */
	public FormSixteenErrorFilePersistence getFormSixteenErrorFilePersistence() {
		return formSixteenErrorFilePersistence;
	}

	/**
	 * Sets the form sixteen error file persistence.
	 *
	 * @param formSixteenErrorFilePersistence the form sixteen error file persistence
	 */
	public void setFormSixteenErrorFilePersistence(
		FormSixteenErrorFilePersistence formSixteenErrorFilePersistence) {
		this.formSixteenErrorFilePersistence = formSixteenErrorFilePersistence;
	}

	/**
	 * Returns the geo attendance local service.
	 *
	 * @return the geo attendance local service
	 */
	public com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService getGeoAttendanceLocalService() {
		return geoAttendanceLocalService;
	}

	/**
	 * Sets the geo attendance local service.
	 *
	 * @param geoAttendanceLocalService the geo attendance local service
	 */
	public void setGeoAttendanceLocalService(
		com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService geoAttendanceLocalService) {
		this.geoAttendanceLocalService = geoAttendanceLocalService;
	}

	/**
	 * Returns the geo attendance persistence.
	 *
	 * @return the geo attendance persistence
	 */
	public GeoAttendancePersistence getGeoAttendancePersistence() {
		return geoAttendancePersistence;
	}

	/**
	 * Sets the geo attendance persistence.
	 *
	 * @param geoAttendancePersistence the geo attendance persistence
	 */
	public void setGeoAttendancePersistence(
		GeoAttendancePersistence geoAttendancePersistence) {
		this.geoAttendancePersistence = geoAttendancePersistence;
	}

	/**
	 * Returns the goal details local service.
	 *
	 * @return the goal details local service
	 */
	public com.liferay.famocom.erpcloud.service.GoalDetailsLocalService getGoalDetailsLocalService() {
		return goalDetailsLocalService;
	}

	/**
	 * Sets the goal details local service.
	 *
	 * @param goalDetailsLocalService the goal details local service
	 */
	public void setGoalDetailsLocalService(
		com.liferay.famocom.erpcloud.service.GoalDetailsLocalService goalDetailsLocalService) {
		this.goalDetailsLocalService = goalDetailsLocalService;
	}

	/**
	 * Returns the goal details persistence.
	 *
	 * @return the goal details persistence
	 */
	public GoalDetailsPersistence getGoalDetailsPersistence() {
		return goalDetailsPersistence;
	}

	/**
	 * Sets the goal details persistence.
	 *
	 * @param goalDetailsPersistence the goal details persistence
	 */
	public void setGoalDetailsPersistence(
		GoalDetailsPersistence goalDetailsPersistence) {
		this.goalDetailsPersistence = goalDetailsPersistence;
	}

	/**
	 * Returns the goal master local service.
	 *
	 * @return the goal master local service
	 */
	public com.liferay.famocom.erpcloud.service.GoalMasterLocalService getGoalMasterLocalService() {
		return goalMasterLocalService;
	}

	/**
	 * Sets the goal master local service.
	 *
	 * @param goalMasterLocalService the goal master local service
	 */
	public void setGoalMasterLocalService(
		com.liferay.famocom.erpcloud.service.GoalMasterLocalService goalMasterLocalService) {
		this.goalMasterLocalService = goalMasterLocalService;
	}

	/**
	 * Returns the goal master persistence.
	 *
	 * @return the goal master persistence
	 */
	public GoalMasterPersistence getGoalMasterPersistence() {
		return goalMasterPersistence;
	}

	/**
	 * Sets the goal master persistence.
	 *
	 * @param goalMasterPersistence the goal master persistence
	 */
	public void setGoalMasterPersistence(
		GoalMasterPersistence goalMasterPersistence) {
		this.goalMasterPersistence = goalMasterPersistence;
	}

	/**
	 * Returns the holiday calender management local service.
	 *
	 * @return the holiday calender management local service
	 */
	public com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService getHolidayCalenderManagementLocalService() {
		return holidayCalenderManagementLocalService;
	}

	/**
	 * Sets the holiday calender management local service.
	 *
	 * @param holidayCalenderManagementLocalService the holiday calender management local service
	 */
	public void setHolidayCalenderManagementLocalService(
		com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService holidayCalenderManagementLocalService) {
		this.holidayCalenderManagementLocalService = holidayCalenderManagementLocalService;
	}

	/**
	 * Returns the holiday calender management persistence.
	 *
	 * @return the holiday calender management persistence
	 */
	public HolidayCalenderManagementPersistence getHolidayCalenderManagementPersistence() {
		return holidayCalenderManagementPersistence;
	}

	/**
	 * Sets the holiday calender management persistence.
	 *
	 * @param holidayCalenderManagementPersistence the holiday calender management persistence
	 */
	public void setHolidayCalenderManagementPersistence(
		HolidayCalenderManagementPersistence holidayCalenderManagementPersistence) {
		this.holidayCalenderManagementPersistence = holidayCalenderManagementPersistence;
	}

	/**
	 * Returns the income tax slab local service.
	 *
	 * @return the income tax slab local service
	 */
	public com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService getIncomeTaxSlabLocalService() {
		return incomeTaxSlabLocalService;
	}

	/**
	 * Sets the income tax slab local service.
	 *
	 * @param incomeTaxSlabLocalService the income tax slab local service
	 */
	public void setIncomeTaxSlabLocalService(
		com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService incomeTaxSlabLocalService) {
		this.incomeTaxSlabLocalService = incomeTaxSlabLocalService;
	}

	/**
	 * Returns the income tax slab persistence.
	 *
	 * @return the income tax slab persistence
	 */
	public IncomeTaxSlabPersistence getIncomeTaxSlabPersistence() {
		return incomeTaxSlabPersistence;
	}

	/**
	 * Sets the income tax slab persistence.
	 *
	 * @param incomeTaxSlabPersistence the income tax slab persistence
	 */
	public void setIncomeTaxSlabPersistence(
		IncomeTaxSlabPersistence incomeTaxSlabPersistence) {
		this.incomeTaxSlabPersistence = incomeTaxSlabPersistence;
	}

	/**
	 * Returns the interview evaluation local service.
	 *
	 * @return the interview evaluation local service
	 */
	public com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService getInterviewEvaluationLocalService() {
		return interviewEvaluationLocalService;
	}

	/**
	 * Sets the interview evaluation local service.
	 *
	 * @param interviewEvaluationLocalService the interview evaluation local service
	 */
	public void setInterviewEvaluationLocalService(
		com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService interviewEvaluationLocalService) {
		this.interviewEvaluationLocalService = interviewEvaluationLocalService;
	}

	/**
	 * Returns the interview evaluation persistence.
	 *
	 * @return the interview evaluation persistence
	 */
	public InterviewEvaluationPersistence getInterviewEvaluationPersistence() {
		return interviewEvaluationPersistence;
	}

	/**
	 * Sets the interview evaluation persistence.
	 *
	 * @param interviewEvaluationPersistence the interview evaluation persistence
	 */
	public void setInterviewEvaluationPersistence(
		InterviewEvaluationPersistence interviewEvaluationPersistence) {
		this.interviewEvaluationPersistence = interviewEvaluationPersistence;
	}

	/**
	 * Returns the job evaluation local service.
	 *
	 * @return the job evaluation local service
	 */
	public com.liferay.famocom.erpcloud.service.JobEvaluationLocalService getJobEvaluationLocalService() {
		return jobEvaluationLocalService;
	}

	/**
	 * Sets the job evaluation local service.
	 *
	 * @param jobEvaluationLocalService the job evaluation local service
	 */
	public void setJobEvaluationLocalService(
		com.liferay.famocom.erpcloud.service.JobEvaluationLocalService jobEvaluationLocalService) {
		this.jobEvaluationLocalService = jobEvaluationLocalService;
	}

	/**
	 * Returns the job evaluation persistence.
	 *
	 * @return the job evaluation persistence
	 */
	public JobEvaluationPersistence getJobEvaluationPersistence() {
		return jobEvaluationPersistence;
	}

	/**
	 * Sets the job evaluation persistence.
	 *
	 * @param jobEvaluationPersistence the job evaluation persistence
	 */
	public void setJobEvaluationPersistence(
		JobEvaluationPersistence jobEvaluationPersistence) {
		this.jobEvaluationPersistence = jobEvaluationPersistence;
	}

	/**
	 * Returns the job opening local service.
	 *
	 * @return the job opening local service
	 */
	public com.liferay.famocom.erpcloud.service.JobOpeningLocalService getJobOpeningLocalService() {
		return jobOpeningLocalService;
	}

	/**
	 * Sets the job opening local service.
	 *
	 * @param jobOpeningLocalService the job opening local service
	 */
	public void setJobOpeningLocalService(
		com.liferay.famocom.erpcloud.service.JobOpeningLocalService jobOpeningLocalService) {
		this.jobOpeningLocalService = jobOpeningLocalService;
	}

	/**
	 * Returns the job opening persistence.
	 *
	 * @return the job opening persistence
	 */
	public JobOpeningPersistence getJobOpeningPersistence() {
		return jobOpeningPersistence;
	}

	/**
	 * Sets the job opening persistence.
	 *
	 * @param jobOpeningPersistence the job opening persistence
	 */
	public void setJobOpeningPersistence(
		JobOpeningPersistence jobOpeningPersistence) {
		this.jobOpeningPersistence = jobOpeningPersistence;
	}

	/**
	 * Returns the job post local service.
	 *
	 * @return the job post local service
	 */
	public com.liferay.famocom.erpcloud.service.JobPostLocalService getJobPostLocalService() {
		return jobPostLocalService;
	}

	/**
	 * Sets the job post local service.
	 *
	 * @param jobPostLocalService the job post local service
	 */
	public void setJobPostLocalService(
		com.liferay.famocom.erpcloud.service.JobPostLocalService jobPostLocalService) {
		this.jobPostLocalService = jobPostLocalService;
	}

	/**
	 * Returns the job post persistence.
	 *
	 * @return the job post persistence
	 */
	public JobPostPersistence getJobPostPersistence() {
		return jobPostPersistence;
	}

	/**
	 * Sets the job post persistence.
	 *
	 * @param jobPostPersistence the job post persistence
	 */
	public void setJobPostPersistence(JobPostPersistence jobPostPersistence) {
		this.jobPostPersistence = jobPostPersistence;
	}

	/**
	 * Returns the leave apply local service.
	 *
	 * @return the leave apply local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveApplyLocalService getLeaveApplyLocalService() {
		return leaveApplyLocalService;
	}

	/**
	 * Sets the leave apply local service.
	 *
	 * @param leaveApplyLocalService the leave apply local service
	 */
	public void setLeaveApplyLocalService(
		com.liferay.famocom.erpcloud.service.LeaveApplyLocalService leaveApplyLocalService) {
		this.leaveApplyLocalService = leaveApplyLocalService;
	}

	/**
	 * Returns the leave apply persistence.
	 *
	 * @return the leave apply persistence
	 */
	public LeaveApplyPersistence getLeaveApplyPersistence() {
		return leaveApplyPersistence;
	}

	/**
	 * Sets the leave apply persistence.
	 *
	 * @param leaveApplyPersistence the leave apply persistence
	 */
	public void setLeaveApplyPersistence(
		LeaveApplyPersistence leaveApplyPersistence) {
		this.leaveApplyPersistence = leaveApplyPersistence;
	}

	/**
	 * Returns the leave apply dtl local service.
	 *
	 * @return the leave apply dtl local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService getLeaveApplyDtlLocalService() {
		return leaveApplyDtlLocalService;
	}

	/**
	 * Sets the leave apply dtl local service.
	 *
	 * @param leaveApplyDtlLocalService the leave apply dtl local service
	 */
	public void setLeaveApplyDtlLocalService(
		com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService leaveApplyDtlLocalService) {
		this.leaveApplyDtlLocalService = leaveApplyDtlLocalService;
	}

	/**
	 * Returns the leave apply dtl persistence.
	 *
	 * @return the leave apply dtl persistence
	 */
	public LeaveApplyDtlPersistence getLeaveApplyDtlPersistence() {
		return leaveApplyDtlPersistence;
	}

	/**
	 * Sets the leave apply dtl persistence.
	 *
	 * @param leaveApplyDtlPersistence the leave apply dtl persistence
	 */
	public void setLeaveApplyDtlPersistence(
		LeaveApplyDtlPersistence leaveApplyDtlPersistence) {
		this.leaveApplyDtlPersistence = leaveApplyDtlPersistence;
	}

	/**
	 * Returns the leave doc local service.
	 *
	 * @return the leave doc local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveDocLocalService getLeaveDocLocalService() {
		return leaveDocLocalService;
	}

	/**
	 * Sets the leave doc local service.
	 *
	 * @param leaveDocLocalService the leave doc local service
	 */
	public void setLeaveDocLocalService(
		com.liferay.famocom.erpcloud.service.LeaveDocLocalService leaveDocLocalService) {
		this.leaveDocLocalService = leaveDocLocalService;
	}

	/**
	 * Returns the leave doc persistence.
	 *
	 * @return the leave doc persistence
	 */
	public LeaveDocPersistence getLeaveDocPersistence() {
		return leaveDocPersistence;
	}

	/**
	 * Sets the leave doc persistence.
	 *
	 * @param leaveDocPersistence the leave doc persistence
	 */
	public void setLeaveDocPersistence(LeaveDocPersistence leaveDocPersistence) {
		this.leaveDocPersistence = leaveDocPersistence;
	}

	/**
	 * Returns the leave management local service.
	 *
	 * @return the leave management local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveManagementLocalService getLeaveManagementLocalService() {
		return leaveManagementLocalService;
	}

	/**
	 * Sets the leave management local service.
	 *
	 * @param leaveManagementLocalService the leave management local service
	 */
	public void setLeaveManagementLocalService(
		com.liferay.famocom.erpcloud.service.LeaveManagementLocalService leaveManagementLocalService) {
		this.leaveManagementLocalService = leaveManagementLocalService;
	}

	/**
	 * Returns the leave management persistence.
	 *
	 * @return the leave management persistence
	 */
	public LeaveManagementPersistence getLeaveManagementPersistence() {
		return leaveManagementPersistence;
	}

	/**
	 * Sets the leave management persistence.
	 *
	 * @param leaveManagementPersistence the leave management persistence
	 */
	public void setLeaveManagementPersistence(
		LeaveManagementPersistence leaveManagementPersistence) {
		this.leaveManagementPersistence = leaveManagementPersistence;
	}

	/**
	 * Returns the leave ob local service.
	 *
	 * @return the leave ob local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveObLocalService getLeaveObLocalService() {
		return leaveObLocalService;
	}

	/**
	 * Sets the leave ob local service.
	 *
	 * @param leaveObLocalService the leave ob local service
	 */
	public void setLeaveObLocalService(
		com.liferay.famocom.erpcloud.service.LeaveObLocalService leaveObLocalService) {
		this.leaveObLocalService = leaveObLocalService;
	}

	/**
	 * Returns the leave ob persistence.
	 *
	 * @return the leave ob persistence
	 */
	public LeaveObPersistence getLeaveObPersistence() {
		return leaveObPersistence;
	}

	/**
	 * Sets the leave ob persistence.
	 *
	 * @param leaveObPersistence the leave ob persistence
	 */
	public void setLeaveObPersistence(LeaveObPersistence leaveObPersistence) {
		this.leaveObPersistence = leaveObPersistence;
	}

	/**
	 * Returns the leave type local service.
	 *
	 * @return the leave type local service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveTypeLocalService getLeaveTypeLocalService() {
		return leaveTypeLocalService;
	}

	/**
	 * Sets the leave type local service.
	 *
	 * @param leaveTypeLocalService the leave type local service
	 */
	public void setLeaveTypeLocalService(
		com.liferay.famocom.erpcloud.service.LeaveTypeLocalService leaveTypeLocalService) {
		this.leaveTypeLocalService = leaveTypeLocalService;
	}

	/**
	 * Returns the leave type persistence.
	 *
	 * @return the leave type persistence
	 */
	public LeaveTypePersistence getLeaveTypePersistence() {
		return leaveTypePersistence;
	}

	/**
	 * Sets the leave type persistence.
	 *
	 * @param leaveTypePersistence the leave type persistence
	 */
	public void setLeaveTypePersistence(
		LeaveTypePersistence leaveTypePersistence) {
		this.leaveTypePersistence = leaveTypePersistence;
	}

	/**
	 * Returns the milestone local service.
	 *
	 * @return the milestone local service
	 */
	public com.liferay.famocom.erpcloud.service.MilestoneLocalService getMilestoneLocalService() {
		return milestoneLocalService;
	}

	/**
	 * Sets the milestone local service.
	 *
	 * @param milestoneLocalService the milestone local service
	 */
	public void setMilestoneLocalService(
		com.liferay.famocom.erpcloud.service.MilestoneLocalService milestoneLocalService) {
		this.milestoneLocalService = milestoneLocalService;
	}

	/**
	 * Returns the milestone persistence.
	 *
	 * @return the milestone persistence
	 */
	public MilestonePersistence getMilestonePersistence() {
		return milestonePersistence;
	}

	/**
	 * Sets the milestone persistence.
	 *
	 * @param milestonePersistence the milestone persistence
	 */
	public void setMilestonePersistence(
		MilestonePersistence milestonePersistence) {
		this.milestonePersistence = milestonePersistence;
	}

	/**
	 * Returns the monthly adjustment local service.
	 *
	 * @return the monthly adjustment local service
	 */
	public com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService getMonthlyAdjustmentLocalService() {
		return monthlyAdjustmentLocalService;
	}

	/**
	 * Sets the monthly adjustment local service.
	 *
	 * @param monthlyAdjustmentLocalService the monthly adjustment local service
	 */
	public void setMonthlyAdjustmentLocalService(
		com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService monthlyAdjustmentLocalService) {
		this.monthlyAdjustmentLocalService = monthlyAdjustmentLocalService;
	}

	/**
	 * Returns the monthly adjustment persistence.
	 *
	 * @return the monthly adjustment persistence
	 */
	public MonthlyAdjustmentPersistence getMonthlyAdjustmentPersistence() {
		return monthlyAdjustmentPersistence;
	}

	/**
	 * Sets the monthly adjustment persistence.
	 *
	 * @param monthlyAdjustmentPersistence the monthly adjustment persistence
	 */
	public void setMonthlyAdjustmentPersistence(
		MonthlyAdjustmentPersistence monthlyAdjustmentPersistence) {
		this.monthlyAdjustmentPersistence = monthlyAdjustmentPersistence;
	}

	/**
	 * Returns the notification master manage local service.
	 *
	 * @return the notification master manage local service
	 */
	public com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService getNotificationMasterManageLocalService() {
		return notificationMasterManageLocalService;
	}

	/**
	 * Sets the notification master manage local service.
	 *
	 * @param notificationMasterManageLocalService the notification master manage local service
	 */
	public void setNotificationMasterManageLocalService(
		com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService notificationMasterManageLocalService) {
		this.notificationMasterManageLocalService = notificationMasterManageLocalService;
	}

	/**
	 * Returns the notification master manage persistence.
	 *
	 * @return the notification master manage persistence
	 */
	public NotificationMasterManagePersistence getNotificationMasterManagePersistence() {
		return notificationMasterManagePersistence;
	}

	/**
	 * Sets the notification master manage persistence.
	 *
	 * @param notificationMasterManagePersistence the notification master manage persistence
	 */
	public void setNotificationMasterManagePersistence(
		NotificationMasterManagePersistence notificationMasterManagePersistence) {
		this.notificationMasterManagePersistence = notificationMasterManagePersistence;
	}

	/**
	 * Returns the notification send manage local service.
	 *
	 * @return the notification send manage local service
	 */
	public com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService getNotificationSendManageLocalService() {
		return notificationSendManageLocalService;
	}

	/**
	 * Sets the notification send manage local service.
	 *
	 * @param notificationSendManageLocalService the notification send manage local service
	 */
	public void setNotificationSendManageLocalService(
		com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService notificationSendManageLocalService) {
		this.notificationSendManageLocalService = notificationSendManageLocalService;
	}

	/**
	 * Returns the notification send manage persistence.
	 *
	 * @return the notification send manage persistence
	 */
	public NotificationSendManagePersistence getNotificationSendManagePersistence() {
		return notificationSendManagePersistence;
	}

	/**
	 * Sets the notification send manage persistence.
	 *
	 * @param notificationSendManagePersistence the notification send manage persistence
	 */
	public void setNotificationSendManagePersistence(
		NotificationSendManagePersistence notificationSendManagePersistence) {
		this.notificationSendManagePersistence = notificationSendManagePersistence;
	}

	/**
	 * Returns the pay component local service.
	 *
	 * @return the pay component local service
	 */
	public com.liferay.famocom.erpcloud.service.PayComponentLocalService getPayComponentLocalService() {
		return payComponentLocalService;
	}

	/**
	 * Sets the pay component local service.
	 *
	 * @param payComponentLocalService the pay component local service
	 */
	public void setPayComponentLocalService(
		com.liferay.famocom.erpcloud.service.PayComponentLocalService payComponentLocalService) {
		this.payComponentLocalService = payComponentLocalService;
	}

	/**
	 * Returns the pay component persistence.
	 *
	 * @return the pay component persistence
	 */
	public PayComponentPersistence getPayComponentPersistence() {
		return payComponentPersistence;
	}

	/**
	 * Sets the pay component persistence.
	 *
	 * @param payComponentPersistence the pay component persistence
	 */
	public void setPayComponentPersistence(
		PayComponentPersistence payComponentPersistence) {
		this.payComponentPersistence = payComponentPersistence;
	}

	/**
	 * Returns the payroll increment local service.
	 *
	 * @return the payroll increment local service
	 */
	public com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService getPayrollIncrementLocalService() {
		return payrollIncrementLocalService;
	}

	/**
	 * Sets the payroll increment local service.
	 *
	 * @param payrollIncrementLocalService the payroll increment local service
	 */
	public void setPayrollIncrementLocalService(
		com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService payrollIncrementLocalService) {
		this.payrollIncrementLocalService = payrollIncrementLocalService;
	}

	/**
	 * Returns the payroll increment persistence.
	 *
	 * @return the payroll increment persistence
	 */
	public PayrollIncrementPersistence getPayrollIncrementPersistence() {
		return payrollIncrementPersistence;
	}

	/**
	 * Sets the payroll increment persistence.
	 *
	 * @param payrollIncrementPersistence the payroll increment persistence
	 */
	public void setPayrollIncrementPersistence(
		PayrollIncrementPersistence payrollIncrementPersistence) {
		this.payrollIncrementPersistence = payrollIncrementPersistence;
	}

	/**
	 * Returns the payroll slabs local service.
	 *
	 * @return the payroll slabs local service
	 */
	public com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService getPayrollSlabsLocalService() {
		return payrollSlabsLocalService;
	}

	/**
	 * Sets the payroll slabs local service.
	 *
	 * @param payrollSlabsLocalService the payroll slabs local service
	 */
	public void setPayrollSlabsLocalService(
		com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService payrollSlabsLocalService) {
		this.payrollSlabsLocalService = payrollSlabsLocalService;
	}

	/**
	 * Returns the payroll slabs persistence.
	 *
	 * @return the payroll slabs persistence
	 */
	public PayrollSlabsPersistence getPayrollSlabsPersistence() {
		return payrollSlabsPersistence;
	}

	/**
	 * Sets the payroll slabs persistence.
	 *
	 * @param payrollSlabsPersistence the payroll slabs persistence
	 */
	public void setPayrollSlabsPersistence(
		PayrollSlabsPersistence payrollSlabsPersistence) {
		this.payrollSlabsPersistence = payrollSlabsPersistence;
	}

	/**
	 * Returns the performance local service.
	 *
	 * @return the performance local service
	 */
	public com.liferay.famocom.erpcloud.service.PerformanceLocalService getPerformanceLocalService() {
		return performanceLocalService;
	}

	/**
	 * Sets the performance local service.
	 *
	 * @param performanceLocalService the performance local service
	 */
	public void setPerformanceLocalService(
		com.liferay.famocom.erpcloud.service.PerformanceLocalService performanceLocalService) {
		this.performanceLocalService = performanceLocalService;
	}

	/**
	 * Returns the performance persistence.
	 *
	 * @return the performance persistence
	 */
	public PerformancePersistence getPerformancePersistence() {
		return performancePersistence;
	}

	/**
	 * Sets the performance persistence.
	 *
	 * @param performancePersistence the performance persistence
	 */
	public void setPerformancePersistence(
		PerformancePersistence performancePersistence) {
		this.performancePersistence = performancePersistence;
	}

	/**
	 * Returns the performance master local service.
	 *
	 * @return the performance master local service
	 */
	public com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService getPerformanceMasterLocalService() {
		return performanceMasterLocalService;
	}

	/**
	 * Sets the performance master local service.
	 *
	 * @param performanceMasterLocalService the performance master local service
	 */
	public void setPerformanceMasterLocalService(
		com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService performanceMasterLocalService) {
		this.performanceMasterLocalService = performanceMasterLocalService;
	}

	/**
	 * Returns the performance master persistence.
	 *
	 * @return the performance master persistence
	 */
	public PerformanceMasterPersistence getPerformanceMasterPersistence() {
		return performanceMasterPersistence;
	}

	/**
	 * Sets the performance master persistence.
	 *
	 * @param performanceMasterPersistence the performance master persistence
	 */
	public void setPerformanceMasterPersistence(
		PerformanceMasterPersistence performanceMasterPersistence) {
		this.performanceMasterPersistence = performanceMasterPersistence;
	}

	/**
	 * Returns the project master local service.
	 *
	 * @return the project master local service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectMasterLocalService getProjectMasterLocalService() {
		return projectMasterLocalService;
	}

	/**
	 * Sets the project master local service.
	 *
	 * @param projectMasterLocalService the project master local service
	 */
	public void setProjectMasterLocalService(
		com.liferay.famocom.erpcloud.service.ProjectMasterLocalService projectMasterLocalService) {
		this.projectMasterLocalService = projectMasterLocalService;
	}

	/**
	 * Returns the project master persistence.
	 *
	 * @return the project master persistence
	 */
	public ProjectMasterPersistence getProjectMasterPersistence() {
		return projectMasterPersistence;
	}

	/**
	 * Sets the project master persistence.
	 *
	 * @param projectMasterPersistence the project master persistence
	 */
	public void setProjectMasterPersistence(
		ProjectMasterPersistence projectMasterPersistence) {
		this.projectMasterPersistence = projectMasterPersistence;
	}

	/**
	 * Returns the project role local service.
	 *
	 * @return the project role local service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectRoleLocalService getProjectRoleLocalService() {
		return projectRoleLocalService;
	}

	/**
	 * Sets the project role local service.
	 *
	 * @param projectRoleLocalService the project role local service
	 */
	public void setProjectRoleLocalService(
		com.liferay.famocom.erpcloud.service.ProjectRoleLocalService projectRoleLocalService) {
		this.projectRoleLocalService = projectRoleLocalService;
	}

	/**
	 * Returns the project role persistence.
	 *
	 * @return the project role persistence
	 */
	public ProjectRolePersistence getProjectRolePersistence() {
		return projectRolePersistence;
	}

	/**
	 * Sets the project role persistence.
	 *
	 * @param projectRolePersistence the project role persistence
	 */
	public void setProjectRolePersistence(
		ProjectRolePersistence projectRolePersistence) {
		this.projectRolePersistence = projectRolePersistence;
	}

	/**
	 * Returns the project status local service.
	 *
	 * @return the project status local service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectStatusLocalService getProjectStatusLocalService() {
		return projectStatusLocalService;
	}

	/**
	 * Sets the project status local service.
	 *
	 * @param projectStatusLocalService the project status local service
	 */
	public void setProjectStatusLocalService(
		com.liferay.famocom.erpcloud.service.ProjectStatusLocalService projectStatusLocalService) {
		this.projectStatusLocalService = projectStatusLocalService;
	}

	/**
	 * Returns the project status persistence.
	 *
	 * @return the project status persistence
	 */
	public ProjectStatusPersistence getProjectStatusPersistence() {
		return projectStatusPersistence;
	}

	/**
	 * Sets the project status persistence.
	 *
	 * @param projectStatusPersistence the project status persistence
	 */
	public void setProjectStatusPersistence(
		ProjectStatusPersistence projectStatusPersistence) {
		this.projectStatusPersistence = projectStatusPersistence;
	}

	/**
	 * Returns the project task local service.
	 *
	 * @return the project task local service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectTaskLocalService getProjectTaskLocalService() {
		return projectTaskLocalService;
	}

	/**
	 * Sets the project task local service.
	 *
	 * @param projectTaskLocalService the project task local service
	 */
	public void setProjectTaskLocalService(
		com.liferay.famocom.erpcloud.service.ProjectTaskLocalService projectTaskLocalService) {
		this.projectTaskLocalService = projectTaskLocalService;
	}

	/**
	 * Returns the project task persistence.
	 *
	 * @return the project task persistence
	 */
	public ProjectTaskPersistence getProjectTaskPersistence() {
		return projectTaskPersistence;
	}

	/**
	 * Sets the project task persistence.
	 *
	 * @param projectTaskPersistence the project task persistence
	 */
	public void setProjectTaskPersistence(
		ProjectTaskPersistence projectTaskPersistence) {
		this.projectTaskPersistence = projectTaskPersistence;
	}

	/**
	 * Returns the push notification local service.
	 *
	 * @return the push notification local service
	 */
	public com.liferay.famocom.erpcloud.service.PushNotificationLocalService getPushNotificationLocalService() {
		return pushNotificationLocalService;
	}

	/**
	 * Sets the push notification local service.
	 *
	 * @param pushNotificationLocalService the push notification local service
	 */
	public void setPushNotificationLocalService(
		com.liferay.famocom.erpcloud.service.PushNotificationLocalService pushNotificationLocalService) {
		this.pushNotificationLocalService = pushNotificationLocalService;
	}

	/**
	 * Returns the push notification persistence.
	 *
	 * @return the push notification persistence
	 */
	public PushNotificationPersistence getPushNotificationPersistence() {
		return pushNotificationPersistence;
	}

	/**
	 * Sets the push notification persistence.
	 *
	 * @param pushNotificationPersistence the push notification persistence
	 */
	public void setPushNotificationPersistence(
		PushNotificationPersistence pushNotificationPersistence) {
		this.pushNotificationPersistence = pushNotificationPersistence;
	}

	/**
	 * Returns the rating master local service.
	 *
	 * @return the rating master local service
	 */
	public com.liferay.famocom.erpcloud.service.RatingMasterLocalService getRatingMasterLocalService() {
		return ratingMasterLocalService;
	}

	/**
	 * Sets the rating master local service.
	 *
	 * @param ratingMasterLocalService the rating master local service
	 */
	public void setRatingMasterLocalService(
		com.liferay.famocom.erpcloud.service.RatingMasterLocalService ratingMasterLocalService) {
		this.ratingMasterLocalService = ratingMasterLocalService;
	}

	/**
	 * Returns the rating master persistence.
	 *
	 * @return the rating master persistence
	 */
	public RatingMasterPersistence getRatingMasterPersistence() {
		return ratingMasterPersistence;
	}

	/**
	 * Sets the rating master persistence.
	 *
	 * @param ratingMasterPersistence the rating master persistence
	 */
	public void setRatingMasterPersistence(
		RatingMasterPersistence ratingMasterPersistence) {
		this.ratingMasterPersistence = ratingMasterPersistence;
	}

	/**
	 * Returns the rating master finder.
	 *
	 * @return the rating master finder
	 */
	public RatingMasterFinder getRatingMasterFinder() {
		return ratingMasterFinder;
	}

	/**
	 * Sets the rating master finder.
	 *
	 * @param ratingMasterFinder the rating master finder
	 */
	public void setRatingMasterFinder(RatingMasterFinder ratingMasterFinder) {
		this.ratingMasterFinder = ratingMasterFinder;
	}

	/**
	 * Returns the recruitment process local service.
	 *
	 * @return the recruitment process local service
	 */
	public com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService getRecruitmentProcessLocalService() {
		return recruitmentProcessLocalService;
	}

	/**
	 * Sets the recruitment process local service.
	 *
	 * @param recruitmentProcessLocalService the recruitment process local service
	 */
	public void setRecruitmentProcessLocalService(
		com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService recruitmentProcessLocalService) {
		this.recruitmentProcessLocalService = recruitmentProcessLocalService;
	}

	/**
	 * Returns the recruitment process persistence.
	 *
	 * @return the recruitment process persistence
	 */
	public RecruitmentProcessPersistence getRecruitmentProcessPersistence() {
		return recruitmentProcessPersistence;
	}

	/**
	 * Sets the recruitment process persistence.
	 *
	 * @param recruitmentProcessPersistence the recruitment process persistence
	 */
	public void setRecruitmentProcessPersistence(
		RecruitmentProcessPersistence recruitmentProcessPersistence) {
		this.recruitmentProcessPersistence = recruitmentProcessPersistence;
	}

	/**
	 * Returns the recruit process local service.
	 *
	 * @return the recruit process local service
	 */
	public com.liferay.famocom.erpcloud.service.RecruitProcessLocalService getRecruitProcessLocalService() {
		return recruitProcessLocalService;
	}

	/**
	 * Sets the recruit process local service.
	 *
	 * @param recruitProcessLocalService the recruit process local service
	 */
	public void setRecruitProcessLocalService(
		com.liferay.famocom.erpcloud.service.RecruitProcessLocalService recruitProcessLocalService) {
		this.recruitProcessLocalService = recruitProcessLocalService;
	}

	/**
	 * Returns the recruit process persistence.
	 *
	 * @return the recruit process persistence
	 */
	public RecruitProcessPersistence getRecruitProcessPersistence() {
		return recruitProcessPersistence;
	}

	/**
	 * Sets the recruit process persistence.
	 *
	 * @param recruitProcessPersistence the recruit process persistence
	 */
	public void setRecruitProcessPersistence(
		RecruitProcessPersistence recruitProcessPersistence) {
		this.recruitProcessPersistence = recruitProcessPersistence;
	}

	/**
	 * Returns the resignation local service.
	 *
	 * @return the resignation local service
	 */
	public com.liferay.famocom.erpcloud.service.ResignationLocalService getResignationLocalService() {
		return resignationLocalService;
	}

	/**
	 * Sets the resignation local service.
	 *
	 * @param resignationLocalService the resignation local service
	 */
	public void setResignationLocalService(
		com.liferay.famocom.erpcloud.service.ResignationLocalService resignationLocalService) {
		this.resignationLocalService = resignationLocalService;
	}

	/**
	 * Returns the resignation persistence.
	 *
	 * @return the resignation persistence
	 */
	public ResignationPersistence getResignationPersistence() {
		return resignationPersistence;
	}

	/**
	 * Sets the resignation persistence.
	 *
	 * @param resignationPersistence the resignation persistence
	 */
	public void setResignationPersistence(
		ResignationPersistence resignationPersistence) {
		this.resignationPersistence = resignationPersistence;
	}

	/**
	 * Returns the sal details local service.
	 *
	 * @return the sal details local service
	 */
	public com.liferay.famocom.erpcloud.service.SalDetailsLocalService getSalDetailsLocalService() {
		return salDetailsLocalService;
	}

	/**
	 * Sets the sal details local service.
	 *
	 * @param salDetailsLocalService the sal details local service
	 */
	public void setSalDetailsLocalService(
		com.liferay.famocom.erpcloud.service.SalDetailsLocalService salDetailsLocalService) {
		this.salDetailsLocalService = salDetailsLocalService;
	}

	/**
	 * Returns the sal details persistence.
	 *
	 * @return the sal details persistence
	 */
	public SalDetailsPersistence getSalDetailsPersistence() {
		return salDetailsPersistence;
	}

	/**
	 * Sets the sal details persistence.
	 *
	 * @param salDetailsPersistence the sal details persistence
	 */
	public void setSalDetailsPersistence(
		SalDetailsPersistence salDetailsPersistence) {
		this.salDetailsPersistence = salDetailsPersistence;
	}

	/**
	 * Returns the sal details finder.
	 *
	 * @return the sal details finder
	 */
	public SalDetailsFinder getSalDetailsFinder() {
		return salDetailsFinder;
	}

	/**
	 * Sets the sal details finder.
	 *
	 * @param salDetailsFinder the sal details finder
	 */
	public void setSalDetailsFinder(SalDetailsFinder salDetailsFinder) {
		this.salDetailsFinder = salDetailsFinder;
	}

	/**
	 * Returns the schedules details local service.
	 *
	 * @return the schedules details local service
	 */
	public com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService getSchedulesDetailsLocalService() {
		return schedulesDetailsLocalService;
	}

	/**
	 * Sets the schedules details local service.
	 *
	 * @param schedulesDetailsLocalService the schedules details local service
	 */
	public void setSchedulesDetailsLocalService(
		com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService schedulesDetailsLocalService) {
		this.schedulesDetailsLocalService = schedulesDetailsLocalService;
	}

	/**
	 * Returns the schedules details persistence.
	 *
	 * @return the schedules details persistence
	 */
	public SchedulesDetailsPersistence getSchedulesDetailsPersistence() {
		return schedulesDetailsPersistence;
	}

	/**
	 * Sets the schedules details persistence.
	 *
	 * @param schedulesDetailsPersistence the schedules details persistence
	 */
	public void setSchedulesDetailsPersistence(
		SchedulesDetailsPersistence schedulesDetailsPersistence) {
		this.schedulesDetailsPersistence = schedulesDetailsPersistence;
	}

	/**
	 * Returns the schedules master local service.
	 *
	 * @return the schedules master local service
	 */
	public com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService getSchedulesMasterLocalService() {
		return schedulesMasterLocalService;
	}

	/**
	 * Sets the schedules master local service.
	 *
	 * @param schedulesMasterLocalService the schedules master local service
	 */
	public void setSchedulesMasterLocalService(
		com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService schedulesMasterLocalService) {
		this.schedulesMasterLocalService = schedulesMasterLocalService;
	}

	/**
	 * Returns the schedules master persistence.
	 *
	 * @return the schedules master persistence
	 */
	public SchedulesMasterPersistence getSchedulesMasterPersistence() {
		return schedulesMasterPersistence;
	}

	/**
	 * Sets the schedules master persistence.
	 *
	 * @param schedulesMasterPersistence the schedules master persistence
	 */
	public void setSchedulesMasterPersistence(
		SchedulesMasterPersistence schedulesMasterPersistence) {
		this.schedulesMasterPersistence = schedulesMasterPersistence;
	}

	/**
	 * Returns the selected candidate pay structure local service.
	 *
	 * @return the selected candidate pay structure local service
	 */
	public com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService getSelectedCandidatePayStructureLocalService() {
		return selectedCandidatePayStructureLocalService;
	}

	/**
	 * Sets the selected candidate pay structure local service.
	 *
	 * @param selectedCandidatePayStructureLocalService the selected candidate pay structure local service
	 */
	public void setSelectedCandidatePayStructureLocalService(
		com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService selectedCandidatePayStructureLocalService) {
		this.selectedCandidatePayStructureLocalService = selectedCandidatePayStructureLocalService;
	}

	/**
	 * Returns the selected candidate pay structure persistence.
	 *
	 * @return the selected candidate pay structure persistence
	 */
	public SelectedCandidatePayStructurePersistence getSelectedCandidatePayStructurePersistence() {
		return selectedCandidatePayStructurePersistence;
	}

	/**
	 * Sets the selected candidate pay structure persistence.
	 *
	 * @param selectedCandidatePayStructurePersistence the selected candidate pay structure persistence
	 */
	public void setSelectedCandidatePayStructurePersistence(
		SelectedCandidatePayStructurePersistence selectedCandidatePayStructurePersistence) {
		this.selectedCandidatePayStructurePersistence = selectedCandidatePayStructurePersistence;
	}

	/**
	 * Returns the skill set local service.
	 *
	 * @return the skill set local service
	 */
	public com.liferay.famocom.erpcloud.service.SkillSetLocalService getSkillSetLocalService() {
		return skillSetLocalService;
	}

	/**
	 * Sets the skill set local service.
	 *
	 * @param skillSetLocalService the skill set local service
	 */
	public void setSkillSetLocalService(
		com.liferay.famocom.erpcloud.service.SkillSetLocalService skillSetLocalService) {
		this.skillSetLocalService = skillSetLocalService;
	}

	/**
	 * Returns the skill set persistence.
	 *
	 * @return the skill set persistence
	 */
	public SkillSetPersistence getSkillSetPersistence() {
		return skillSetPersistence;
	}

	/**
	 * Sets the skill set persistence.
	 *
	 * @param skillSetPersistence the skill set persistence
	 */
	public void setSkillSetPersistence(SkillSetPersistence skillSetPersistence) {
		this.skillSetPersistence = skillSetPersistence;
	}

	/**
	 * Returns the stop pay local service.
	 *
	 * @return the stop pay local service
	 */
	public com.liferay.famocom.erpcloud.service.StopPayLocalService getStopPayLocalService() {
		return stopPayLocalService;
	}

	/**
	 * Sets the stop pay local service.
	 *
	 * @param stopPayLocalService the stop pay local service
	 */
	public void setStopPayLocalService(
		com.liferay.famocom.erpcloud.service.StopPayLocalService stopPayLocalService) {
		this.stopPayLocalService = stopPayLocalService;
	}

	/**
	 * Returns the stop pay persistence.
	 *
	 * @return the stop pay persistence
	 */
	public StopPayPersistence getStopPayPersistence() {
		return stopPayPersistence;
	}

	/**
	 * Sets the stop pay persistence.
	 *
	 * @param stopPayPersistence the stop pay persistence
	 */
	public void setStopPayPersistence(StopPayPersistence stopPayPersistence) {
		this.stopPayPersistence = stopPayPersistence;
	}

	/**
	 * Returns the task master local service.
	 *
	 * @return the task master local service
	 */
	public com.liferay.famocom.erpcloud.service.TaskMasterLocalService getTaskMasterLocalService() {
		return taskMasterLocalService;
	}

	/**
	 * Sets the task master local service.
	 *
	 * @param taskMasterLocalService the task master local service
	 */
	public void setTaskMasterLocalService(
		com.liferay.famocom.erpcloud.service.TaskMasterLocalService taskMasterLocalService) {
		this.taskMasterLocalService = taskMasterLocalService;
	}

	/**
	 * Returns the task master persistence.
	 *
	 * @return the task master persistence
	 */
	public TaskMasterPersistence getTaskMasterPersistence() {
		return taskMasterPersistence;
	}

	/**
	 * Sets the task master persistence.
	 *
	 * @param taskMasterPersistence the task master persistence
	 */
	public void setTaskMasterPersistence(
		TaskMasterPersistence taskMasterPersistence) {
		this.taskMasterPersistence = taskMasterPersistence;
	}

	/**
	 * Returns the task master mapping local service.
	 *
	 * @return the task master mapping local service
	 */
	public com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService getTaskMasterMappingLocalService() {
		return taskMasterMappingLocalService;
	}

	/**
	 * Sets the task master mapping local service.
	 *
	 * @param taskMasterMappingLocalService the task master mapping local service
	 */
	public void setTaskMasterMappingLocalService(
		com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService taskMasterMappingLocalService) {
		this.taskMasterMappingLocalService = taskMasterMappingLocalService;
	}

	/**
	 * Returns the task master mapping persistence.
	 *
	 * @return the task master mapping persistence
	 */
	public TaskMasterMappingPersistence getTaskMasterMappingPersistence() {
		return taskMasterMappingPersistence;
	}

	/**
	 * Sets the task master mapping persistence.
	 *
	 * @param taskMasterMappingPersistence the task master mapping persistence
	 */
	public void setTaskMasterMappingPersistence(
		TaskMasterMappingPersistence taskMasterMappingPersistence) {
		this.taskMasterMappingPersistence = taskMasterMappingPersistence;
	}

	/**
	 * Returns the tax declaration local service.
	 *
	 * @return the tax declaration local service
	 */
	public com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService getTaxDeclarationLocalService() {
		return taxDeclarationLocalService;
	}

	/**
	 * Sets the tax declaration local service.
	 *
	 * @param taxDeclarationLocalService the tax declaration local service
	 */
	public void setTaxDeclarationLocalService(
		com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService taxDeclarationLocalService) {
		this.taxDeclarationLocalService = taxDeclarationLocalService;
	}

	/**
	 * Returns the tax declaration persistence.
	 *
	 * @return the tax declaration persistence
	 */
	public TaxDeclarationPersistence getTaxDeclarationPersistence() {
		return taxDeclarationPersistence;
	}

	/**
	 * Sets the tax declaration persistence.
	 *
	 * @param taxDeclarationPersistence the tax declaration persistence
	 */
	public void setTaxDeclarationPersistence(
		TaxDeclarationPersistence taxDeclarationPersistence) {
		this.taxDeclarationPersistence = taxDeclarationPersistence;
	}

	/**
	 * Returns the tax declaration monthly local service.
	 *
	 * @return the tax declaration monthly local service
	 */
	public com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService getTaxDeclarationMonthlyLocalService() {
		return taxDeclarationMonthlyLocalService;
	}

	/**
	 * Sets the tax declaration monthly local service.
	 *
	 * @param taxDeclarationMonthlyLocalService the tax declaration monthly local service
	 */
	public void setTaxDeclarationMonthlyLocalService(
		com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService taxDeclarationMonthlyLocalService) {
		this.taxDeclarationMonthlyLocalService = taxDeclarationMonthlyLocalService;
	}

	/**
	 * Returns the tax declaration monthly persistence.
	 *
	 * @return the tax declaration monthly persistence
	 */
	public TaxDeclarationMonthlyPersistence getTaxDeclarationMonthlyPersistence() {
		return taxDeclarationMonthlyPersistence;
	}

	/**
	 * Sets the tax declaration monthly persistence.
	 *
	 * @param taxDeclarationMonthlyPersistence the tax declaration monthly persistence
	 */
	public void setTaxDeclarationMonthlyPersistence(
		TaxDeclarationMonthlyPersistence taxDeclarationMonthlyPersistence) {
		this.taxDeclarationMonthlyPersistence = taxDeclarationMonthlyPersistence;
	}

	/**
	 * Returns the tax proof files local service.
	 *
	 * @return the tax proof files local service
	 */
	public com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService getTaxProofFilesLocalService() {
		return taxProofFilesLocalService;
	}

	/**
	 * Sets the tax proof files local service.
	 *
	 * @param taxProofFilesLocalService the tax proof files local service
	 */
	public void setTaxProofFilesLocalService(
		com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService taxProofFilesLocalService) {
		this.taxProofFilesLocalService = taxProofFilesLocalService;
	}

	/**
	 * Returns the tax proof files persistence.
	 *
	 * @return the tax proof files persistence
	 */
	public TaxProofFilesPersistence getTaxProofFilesPersistence() {
		return taxProofFilesPersistence;
	}

	/**
	 * Sets the tax proof files persistence.
	 *
	 * @param taxProofFilesPersistence the tax proof files persistence
	 */
	public void setTaxProofFilesPersistence(
		TaxProofFilesPersistence taxProofFilesPersistence) {
		this.taxProofFilesPersistence = taxProofFilesPersistence;
	}

	/**
	 * Returns the tax setting local service.
	 *
	 * @return the tax setting local service
	 */
	public com.liferay.famocom.erpcloud.service.TaxSettingLocalService getTaxSettingLocalService() {
		return taxSettingLocalService;
	}

	/**
	 * Sets the tax setting local service.
	 *
	 * @param taxSettingLocalService the tax setting local service
	 */
	public void setTaxSettingLocalService(
		com.liferay.famocom.erpcloud.service.TaxSettingLocalService taxSettingLocalService) {
		this.taxSettingLocalService = taxSettingLocalService;
	}

	/**
	 * Returns the tax setting persistence.
	 *
	 * @return the tax setting persistence
	 */
	public TaxSettingPersistence getTaxSettingPersistence() {
		return taxSettingPersistence;
	}

	/**
	 * Sets the tax setting persistence.
	 *
	 * @param taxSettingPersistence the tax setting persistence
	 */
	public void setTaxSettingPersistence(
		TaxSettingPersistence taxSettingPersistence) {
		this.taxSettingPersistence = taxSettingPersistence;
	}

	/**
	 * Returns the time sheet entry local service.
	 *
	 * @return the time sheet entry local service
	 */
	public com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService getTimeSheetEntryLocalService() {
		return timeSheetEntryLocalService;
	}

	/**
	 * Sets the time sheet entry local service.
	 *
	 * @param timeSheetEntryLocalService the time sheet entry local service
	 */
	public void setTimeSheetEntryLocalService(
		com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService timeSheetEntryLocalService) {
		this.timeSheetEntryLocalService = timeSheetEntryLocalService;
	}

	/**
	 * Returns the time sheet entry persistence.
	 *
	 * @return the time sheet entry persistence
	 */
	public TimeSheetEntryPersistence getTimeSheetEntryPersistence() {
		return timeSheetEntryPersistence;
	}

	/**
	 * Sets the time sheet entry persistence.
	 *
	 * @param timeSheetEntryPersistence the time sheet entry persistence
	 */
	public void setTimeSheetEntryPersistence(
		TimeSheetEntryPersistence timeSheetEntryPersistence) {
		this.timeSheetEntryPersistence = timeSheetEntryPersistence;
	}

	/**
	 * Returns the time sheet master local service.
	 *
	 * @return the time sheet master local service
	 */
	public com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService getTimeSheetMasterLocalService() {
		return timeSheetMasterLocalService;
	}

	/**
	 * Sets the time sheet master local service.
	 *
	 * @param timeSheetMasterLocalService the time sheet master local service
	 */
	public void setTimeSheetMasterLocalService(
		com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService timeSheetMasterLocalService) {
		this.timeSheetMasterLocalService = timeSheetMasterLocalService;
	}

	/**
	 * Returns the time sheet master persistence.
	 *
	 * @return the time sheet master persistence
	 */
	public TimeSheetMasterPersistence getTimeSheetMasterPersistence() {
		return timeSheetMasterPersistence;
	}

	/**
	 * Sets the time sheet master persistence.
	 *
	 * @param timeSheetMasterPersistence the time sheet master persistence
	 */
	public void setTimeSheetMasterPersistence(
		TimeSheetMasterPersistence timeSheetMasterPersistence) {
		this.timeSheetMasterPersistence = timeSheetMasterPersistence;
	}

	/**
	 * Returns the travel desk details local service.
	 *
	 * @return the travel desk details local service
	 */
	public com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService getTravelDeskDetailsLocalService() {
		return travelDeskDetailsLocalService;
	}

	/**
	 * Sets the travel desk details local service.
	 *
	 * @param travelDeskDetailsLocalService the travel desk details local service
	 */
	public void setTravelDeskDetailsLocalService(
		com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService travelDeskDetailsLocalService) {
		this.travelDeskDetailsLocalService = travelDeskDetailsLocalService;
	}

	/**
	 * Returns the travel desk details persistence.
	 *
	 * @return the travel desk details persistence
	 */
	public TravelDeskDetailsPersistence getTravelDeskDetailsPersistence() {
		return travelDeskDetailsPersistence;
	}

	/**
	 * Sets the travel desk details persistence.
	 *
	 * @param travelDeskDetailsPersistence the travel desk details persistence
	 */
	public void setTravelDeskDetailsPersistence(
		TravelDeskDetailsPersistence travelDeskDetailsPersistence) {
		this.travelDeskDetailsPersistence = travelDeskDetailsPersistence;
	}

	/**
	 * Returns the work from home local service.
	 *
	 * @return the work from home local service
	 */
	public com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService getWorkFromHomeLocalService() {
		return workFromHomeLocalService;
	}

	/**
	 * Sets the work from home local service.
	 *
	 * @param workFromHomeLocalService the work from home local service
	 */
	public void setWorkFromHomeLocalService(
		com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService workFromHomeLocalService) {
		this.workFromHomeLocalService = workFromHomeLocalService;
	}

	/**
	 * Returns the work from home persistence.
	 *
	 * @return the work from home persistence
	 */
	public WorkFromHomePersistence getWorkFromHomePersistence() {
		return workFromHomePersistence;
	}

	/**
	 * Sets the work from home persistence.
	 *
	 * @param workFromHomePersistence the work from home persistence
	 */
	public void setWorkFromHomePersistence(
		WorkFromHomePersistence workFromHomePersistence) {
		this.workFromHomePersistence = workFromHomePersistence;
	}

	/**
	 * Returns the works schedules local service.
	 *
	 * @return the works schedules local service
	 */
	public com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService getWorksSchedulesLocalService() {
		return worksSchedulesLocalService;
	}

	/**
	 * Sets the works schedules local service.
	 *
	 * @param worksSchedulesLocalService the works schedules local service
	 */
	public void setWorksSchedulesLocalService(
		com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService worksSchedulesLocalService) {
		this.worksSchedulesLocalService = worksSchedulesLocalService;
	}

	/**
	 * Returns the works schedules persistence.
	 *
	 * @return the works schedules persistence
	 */
	public WorksSchedulesPersistence getWorksSchedulesPersistence() {
		return worksSchedulesPersistence;
	}

	/**
	 * Sets the works schedules persistence.
	 *
	 * @param worksSchedulesPersistence the works schedules persistence
	 */
	public void setWorksSchedulesPersistence(
		WorksSchedulesPersistence worksSchedulesPersistence) {
		this.worksSchedulesPersistence = worksSchedulesPersistence;
	}

	/**
	 * Returns the year setting local service.
	 *
	 * @return the year setting local service
	 */
	public com.liferay.famocom.erpcloud.service.YearSettingLocalService getYearSettingLocalService() {
		return yearSettingLocalService;
	}

	/**
	 * Sets the year setting local service.
	 *
	 * @param yearSettingLocalService the year setting local service
	 */
	public void setYearSettingLocalService(
		com.liferay.famocom.erpcloud.service.YearSettingLocalService yearSettingLocalService) {
		this.yearSettingLocalService = yearSettingLocalService;
	}

	/**
	 * Returns the year setting persistence.
	 *
	 * @return the year setting persistence
	 */
	public YearSettingPersistence getYearSettingPersistence() {
		return yearSettingPersistence;
	}

	/**
	 * Sets the year setting persistence.
	 *
	 * @param yearSettingPersistence the year setting persistence
	 */
	public void setYearSettingPersistence(
		YearSettingPersistence yearSettingPersistence) {
		this.yearSettingPersistence = yearSettingPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.famocom.erpcloud.model.AppraisalPerformance",
			appraisalPerformanceLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.famocom.erpcloud.model.AppraisalPerformance");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AppraisalPerformanceLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AppraisalPerformance.class;
	}

	protected String getModelClassName() {
		return AppraisalPerformance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = appraisalPerformancePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AddTeamMemberLocalService addTeamMemberLocalService;
	@BeanReference(type = AddTeamMemberPersistence.class)
	protected AddTeamMemberPersistence addTeamMemberPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService appraisalGoalDetailsLocalService;
	@BeanReference(type = AppraisalGoalDetailsPersistence.class)
	protected AppraisalGoalDetailsPersistence appraisalGoalDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService appraisalGoalMasterLocalService;
	@BeanReference(type = AppraisalGoalMasterPersistence.class)
	protected AppraisalGoalMasterPersistence appraisalGoalMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService appraisalMasterLocalService;
	@BeanReference(type = AppraisalMasterPersistence.class)
	protected AppraisalMasterPersistence appraisalMasterPersistence;
	@BeanReference(type = AppraisalPerformanceLocalService.class)
	protected AppraisalPerformanceLocalService appraisalPerformanceLocalService;
	@BeanReference(type = AppraisalPerformancePersistence.class)
	protected AppraisalPerformancePersistence appraisalPerformancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService appraisalProjectMasterLocalService;
	@BeanReference(type = AppraisalProjectMasterPersistence.class)
	protected AppraisalProjectMasterPersistence appraisalProjectMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService appraisalSetupLocalService;
	@BeanReference(type = AppraisalSetupPersistence.class)
	protected AppraisalSetupPersistence appraisalSetupPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceLocalService attendanceLocalService;
	@BeanReference(type = AttendancePersistence.class)
	protected AttendancePersistence attendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceBioLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceBioLocalService attendanceBioLocalService;
	@BeanReference(type = AttendanceBioPersistence.class)
	protected AttendanceBioPersistence attendanceBioPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService attendanceCheckListLocalService;
	@BeanReference(type = AttendanceCheckListPersistence.class)
	protected AttendanceCheckListPersistence attendanceCheckListPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BankMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BankMasterLocalService bankMasterLocalService;
	@BeanReference(type = BankMasterPersistence.class)
	protected BankMasterPersistence bankMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService billDocumentUploadFileLocalService;
	@BeanReference(type = BillDocumentUploadFilePersistence.class)
	protected BillDocumentUploadFilePersistence billDocumentUploadFilePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BillingLocalService billingLocalService;
	@BeanReference(type = BillingPersistence.class)
	protected BillingPersistence billingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BookingRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BookingRoomLocalService bookingRoomLocalService;
	@BeanReference(type = BookingRoomPersistence.class)
	protected BookingRoomPersistence bookingRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BranchLocalService branchLocalService;
	@BeanReference(type = BranchPersistence.class)
	protected BranchPersistence branchPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateApplyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateApplyLocalService candidateApplyLocalService;
	@BeanReference(type = CandidateApplyPersistence.class)
	protected CandidateApplyPersistence candidateApplyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService candidateEvaluationLocalService;
	@BeanReference(type = CandidateEvaluationPersistence.class)
	protected CandidateEvaluationPersistence candidateEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService candidatePayStructureMasterLocalService;
	@BeanReference(type = CandidatePayStructureMasterPersistence.class)
	protected CandidatePayStructureMasterPersistence candidatePayStructureMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateReviewLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateReviewLocalService candidateReviewLocalService;
	@BeanReference(type = CandidateReviewPersistence.class)
	protected CandidateReviewPersistence candidateReviewPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterLocalService clientMasterLocalService;
	@BeanReference(type = ClientMasterPersistence.class)
	protected ClientMasterPersistence clientMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService companyPolicyLocalService;
	@BeanReference(type = CompanyPolicyPersistence.class)
	protected CompanyPolicyPersistence companyPolicyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService conferenceRoomLocalService;
	@BeanReference(type = ConferenceRoomPersistence.class)
	protected ConferenceRoomPersistence conferenceRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService documentUploadFileLocalService;
	@BeanReference(type = DocumentUploadFilePersistence.class)
	protected DocumentUploadFilePersistence documentUploadFilePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmailTemplateLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmailTemplateLocalService emailTemplateLocalService;
	@BeanReference(type = EmailTemplatePersistence.class)
	protected EmailTemplatePersistence emailTemplatePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeLocalService employeeLocalService;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = EmployeeFinder.class)
	protected EmployeeFinder employeeFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService employeeDocumentUploadLocalService;
	@BeanReference(type = EmployeeDocumentUploadPersistence.class)
	protected EmployeeDocumentUploadPersistence employeeDocumentUploadPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService employeeTypeLocalService;
	@BeanReference(type = EmployeeTypePersistence.class)
	protected EmployeeTypePersistence employeeTypePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService empPayStructureLocalService;
	@BeanReference(type = EmpPayStructurePersistence.class)
	protected EmpPayStructurePersistence empPayStructurePersistence;
	@BeanReference(type = EmpPayStructureFinder.class)
	protected EmpPayStructureFinder empPayStructureFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EvaluationLocalService evaluationLocalService;
	@BeanReference(type = EvaluationPersistence.class)
	protected EvaluationPersistence evaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpCategoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpCategoryLocalService expCategoryLocalService;
	@BeanReference(type = ExpCategoryPersistence.class)
	protected ExpCategoryPersistence expCategoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseLocalService expenseLocalService;
	@BeanReference(type = ExpensePersistence.class)
	protected ExpensePersistence expensePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService expenseEntryLocalService;
	@BeanReference(type = ExpenseEntryPersistence.class)
	protected ExpenseEntryPersistence expenseEntryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService;
	@BeanReference(type = ExpenseEntryHistoryPersistence.class)
	protected ExpenseEntryHistoryPersistence expenseEntryHistoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService expProofFilesLocalService;
	@BeanReference(type = ExpProofFilesPersistence.class)
	protected ExpProofFilesPersistence expProofFilesPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FinSalaryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FinSalaryLocalService finSalaryLocalService;
	@BeanReference(type = FinSalaryPersistence.class)
	protected FinSalaryPersistence finSalaryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenLocalService formSixteenLocalService;
	@BeanReference(type = FormSixteenPersistence.class)
	protected FormSixteenPersistence formSixteenPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService formSixteenErrorFileLocalService;
	@BeanReference(type = FormSixteenErrorFilePersistence.class)
	protected FormSixteenErrorFilePersistence formSixteenErrorFilePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService geoAttendanceLocalService;
	@BeanReference(type = GeoAttendancePersistence.class)
	protected GeoAttendancePersistence geoAttendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GoalDetailsLocalService goalDetailsLocalService;
	@BeanReference(type = GoalDetailsPersistence.class)
	protected GoalDetailsPersistence goalDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GoalMasterLocalService goalMasterLocalService;
	@BeanReference(type = GoalMasterPersistence.class)
	protected GoalMasterPersistence goalMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService holidayCalenderManagementLocalService;
	@BeanReference(type = HolidayCalenderManagementPersistence.class)
	protected HolidayCalenderManagementPersistence holidayCalenderManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService.class)
	protected com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService incomeTaxSlabLocalService;
	@BeanReference(type = IncomeTaxSlabPersistence.class)
	protected IncomeTaxSlabPersistence incomeTaxSlabPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService interviewEvaluationLocalService;
	@BeanReference(type = InterviewEvaluationPersistence.class)
	protected InterviewEvaluationPersistence interviewEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobEvaluationLocalService jobEvaluationLocalService;
	@BeanReference(type = JobEvaluationPersistence.class)
	protected JobEvaluationPersistence jobEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobOpeningLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobOpeningLocalService jobOpeningLocalService;
	@BeanReference(type = JobOpeningPersistence.class)
	protected JobOpeningPersistence jobOpeningPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobPostLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobPostLocalService jobPostLocalService;
	@BeanReference(type = JobPostPersistence.class)
	protected JobPostPersistence jobPostPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyLocalService leaveApplyLocalService;
	@BeanReference(type = LeaveApplyPersistence.class)
	protected LeaveApplyPersistence leaveApplyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService leaveApplyDtlLocalService;
	@BeanReference(type = LeaveApplyDtlPersistence.class)
	protected LeaveApplyDtlPersistence leaveApplyDtlPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveDocLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveDocLocalService leaveDocLocalService;
	@BeanReference(type = LeaveDocPersistence.class)
	protected LeaveDocPersistence leaveDocPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementLocalService leaveManagementLocalService;
	@BeanReference(type = LeaveManagementPersistence.class)
	protected LeaveManagementPersistence leaveManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveObLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveObLocalService leaveObLocalService;
	@BeanReference(type = LeaveObPersistence.class)
	protected LeaveObPersistence leaveObPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveTypeLocalService leaveTypeLocalService;
	@BeanReference(type = LeaveTypePersistence.class)
	protected LeaveTypePersistence leaveTypePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MilestoneLocalService.class)
	protected com.liferay.famocom.erpcloud.service.MilestoneLocalService milestoneLocalService;
	@BeanReference(type = MilestonePersistence.class)
	protected MilestonePersistence milestonePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService.class)
	protected com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService monthlyAdjustmentLocalService;
	@BeanReference(type = MonthlyAdjustmentPersistence.class)
	protected MonthlyAdjustmentPersistence monthlyAdjustmentPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService notificationMasterManageLocalService;
	@BeanReference(type = NotificationMasterManagePersistence.class)
	protected NotificationMasterManagePersistence notificationMasterManagePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService notificationSendManageLocalService;
	@BeanReference(type = NotificationSendManagePersistence.class)
	protected NotificationSendManagePersistence notificationSendManagePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayComponentLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayComponentLocalService payComponentLocalService;
	@BeanReference(type = PayComponentPersistence.class)
	protected PayComponentPersistence payComponentPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService payrollIncrementLocalService;
	@BeanReference(type = PayrollIncrementPersistence.class)
	protected PayrollIncrementPersistence payrollIncrementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService payrollSlabsLocalService;
	@BeanReference(type = PayrollSlabsPersistence.class)
	protected PayrollSlabsPersistence payrollSlabsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceLocalService performanceLocalService;
	@BeanReference(type = PerformancePersistence.class)
	protected PerformancePersistence performancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService performanceMasterLocalService;
	@BeanReference(type = PerformanceMasterPersistence.class)
	protected PerformanceMasterPersistence performanceMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectMasterLocalService projectMasterLocalService;
	@BeanReference(type = ProjectMasterPersistence.class)
	protected ProjectMasterPersistence projectMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectRoleLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectRoleLocalService projectRoleLocalService;
	@BeanReference(type = ProjectRolePersistence.class)
	protected ProjectRolePersistence projectRolePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectStatusLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectStatusLocalService projectStatusLocalService;
	@BeanReference(type = ProjectStatusPersistence.class)
	protected ProjectStatusPersistence projectStatusPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectTaskLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectTaskLocalService projectTaskLocalService;
	@BeanReference(type = ProjectTaskPersistence.class)
	protected ProjectTaskPersistence projectTaskPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PushNotificationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PushNotificationLocalService pushNotificationLocalService;
	@BeanReference(type = PushNotificationPersistence.class)
	protected PushNotificationPersistence pushNotificationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RatingMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RatingMasterLocalService ratingMasterLocalService;
	@BeanReference(type = RatingMasterPersistence.class)
	protected RatingMasterPersistence ratingMasterPersistence;
	@BeanReference(type = RatingMasterFinder.class)
	protected RatingMasterFinder ratingMasterFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService recruitmentProcessLocalService;
	@BeanReference(type = RecruitmentProcessPersistence.class)
	protected RecruitmentProcessPersistence recruitmentProcessPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitProcessLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitProcessLocalService recruitProcessLocalService;
	@BeanReference(type = RecruitProcessPersistence.class)
	protected RecruitProcessPersistence recruitProcessPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ResignationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ResignationLocalService resignationLocalService;
	@BeanReference(type = ResignationPersistence.class)
	protected ResignationPersistence resignationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SalDetailsLocalService salDetailsLocalService;
	@BeanReference(type = SalDetailsPersistence.class)
	protected SalDetailsPersistence salDetailsPersistence;
	@BeanReference(type = SalDetailsFinder.class)
	protected SalDetailsFinder salDetailsFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService schedulesDetailsLocalService;
	@BeanReference(type = SchedulesDetailsPersistence.class)
	protected SchedulesDetailsPersistence schedulesDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService schedulesMasterLocalService;
	@BeanReference(type = SchedulesMasterPersistence.class)
	protected SchedulesMasterPersistence schedulesMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService selectedCandidatePayStructureLocalService;
	@BeanReference(type = SelectedCandidatePayStructurePersistence.class)
	protected SelectedCandidatePayStructurePersistence selectedCandidatePayStructurePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetLocalService skillSetLocalService;
	@BeanReference(type = SkillSetPersistence.class)
	protected SkillSetPersistence skillSetPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.StopPayLocalService.class)
	protected com.liferay.famocom.erpcloud.service.StopPayLocalService stopPayLocalService;
	@BeanReference(type = StopPayPersistence.class)
	protected StopPayPersistence stopPayPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterLocalService taskMasterLocalService;
	@BeanReference(type = TaskMasterPersistence.class)
	protected TaskMasterPersistence taskMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService taskMasterMappingLocalService;
	@BeanReference(type = TaskMasterMappingPersistence.class)
	protected TaskMasterMappingPersistence taskMasterMappingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService taxDeclarationLocalService;
	@BeanReference(type = TaxDeclarationPersistence.class)
	protected TaxDeclarationPersistence taxDeclarationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService taxDeclarationMonthlyLocalService;
	@BeanReference(type = TaxDeclarationMonthlyPersistence.class)
	protected TaxDeclarationMonthlyPersistence taxDeclarationMonthlyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService taxProofFilesLocalService;
	@BeanReference(type = TaxProofFilesPersistence.class)
	protected TaxProofFilesPersistence taxProofFilesPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxSettingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxSettingLocalService taxSettingLocalService;
	@BeanReference(type = TaxSettingPersistence.class)
	protected TaxSettingPersistence taxSettingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService timeSheetEntryLocalService;
	@BeanReference(type = TimeSheetEntryPersistence.class)
	protected TimeSheetEntryPersistence timeSheetEntryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService timeSheetMasterLocalService;
	@BeanReference(type = TimeSheetMasterPersistence.class)
	protected TimeSheetMasterPersistence timeSheetMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService travelDeskDetailsLocalService;
	@BeanReference(type = TravelDeskDetailsPersistence.class)
	protected TravelDeskDetailsPersistence travelDeskDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService workFromHomeLocalService;
	@BeanReference(type = WorkFromHomePersistence.class)
	protected WorkFromHomePersistence workFromHomePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService worksSchedulesLocalService;
	@BeanReference(type = WorksSchedulesPersistence.class)
	protected WorksSchedulesPersistence worksSchedulesPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.YearSettingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.YearSettingLocalService yearSettingLocalService;
	@BeanReference(type = YearSettingPersistence.class)
	protected YearSettingPersistence yearSettingPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}