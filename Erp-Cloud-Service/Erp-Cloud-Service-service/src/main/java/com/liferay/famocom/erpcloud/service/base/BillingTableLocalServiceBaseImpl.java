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

import com.liferay.famocom.erpcloud.model.BillingTable;
import com.liferay.famocom.erpcloud.service.BillingTableLocalService;
import com.liferay.famocom.erpcloud.service.persistence.AddTeamMemberPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalGoalMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalPerformancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalProjectMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AppraisalSetupPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AttendanceBioPersistence;
import com.liferay.famocom.erpcloud.service.persistence.AttendancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.BillingTablePersistence;
import com.liferay.famocom.erpcloud.service.persistence.BookingRoomPersistence;
import com.liferay.famocom.erpcloud.service.persistence.BranchPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ClientMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ConferenceRoomPersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmailTemplatePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmployeePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EmployeeTypePersistence;
import com.liferay.famocom.erpcloud.service.persistence.EvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpCategoryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpenseEntryHistoryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ExpensePersistence;
import com.liferay.famocom.erpcloud.service.persistence.GeoAttendancePersistence;
import com.liferay.famocom.erpcloud.service.persistence.HolidayCalenderManagementPersistence;
import com.liferay.famocom.erpcloud.service.persistence.InterviewEvaluationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyDtlPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveApplyPersistence;
import com.liferay.famocom.erpcloud.service.persistence.LeaveManagementPersistence;
import com.liferay.famocom.erpcloud.service.persistence.NotificationMasterManagePersistence;
import com.liferay.famocom.erpcloud.service.persistence.NotificationSendManagePersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectRolePersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectStatusPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ProjectTaskPersistence;
import com.liferay.famocom.erpcloud.service.persistence.RecruitProcessPersistence;
import com.liferay.famocom.erpcloud.service.persistence.ResignationPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SchedulesMasterPersistence;
import com.liferay.famocom.erpcloud.service.persistence.SkillSetPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TimeSheetEntryPersistence;
import com.liferay.famocom.erpcloud.service.persistence.TravelDeskDetailsPersistence;
import com.liferay.famocom.erpcloud.service.persistence.WorkFromHomePersistence;
import com.liferay.famocom.erpcloud.service.persistence.WorksSchedulesPersistence;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the billing table local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.famocom.erpcloud.service.impl.BillingTableLocalServiceImpl}.
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.impl.BillingTableLocalServiceImpl
 * @see com.liferay.famocom.erpcloud.service.BillingTableLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class BillingTableLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements BillingTableLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.BillingTableLocalServiceUtil} to access the billing table local service.
	 */

	/**
	 * Adds the billing table to the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingTable the billing table
	 * @return the billing table that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BillingTable addBillingTable(BillingTable billingTable) {
		billingTable.setNew(true);

		return billingTablePersistence.update(billingTable);
	}

	/**
	 * Creates a new billing table with the primary key. Does not add the billing table to the database.
	 *
	 * @param billingId the primary key for the new billing table
	 * @return the new billing table
	 */
	@Override
	public BillingTable createBillingTable(long billingId) {
		return billingTablePersistence.create(billingId);
	}

	/**
	 * Deletes the billing table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingId the primary key of the billing table
	 * @return the billing table that was removed
	 * @throws PortalException if a billing table with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BillingTable deleteBillingTable(long billingId)
		throws PortalException {
		return billingTablePersistence.remove(billingId);
	}

	/**
	 * Deletes the billing table from the database. Also notifies the appropriate model listeners.
	 *
	 * @param billingTable the billing table
	 * @return the billing table that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BillingTable deleteBillingTable(BillingTable billingTable) {
		return billingTablePersistence.remove(billingTable);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(BillingTable.class,
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
		return billingTablePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return billingTablePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return billingTablePersistence.findWithDynamicQuery(dynamicQuery,
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
		return billingTablePersistence.countWithDynamicQuery(dynamicQuery);
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
		return billingTablePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public BillingTable fetchBillingTable(long billingId) {
		return billingTablePersistence.fetchByPrimaryKey(billingId);
	}

	/**
	 * Returns the billing table with the primary key.
	 *
	 * @param billingId the primary key of the billing table
	 * @return the billing table
	 * @throws PortalException if a billing table with the primary key could not be found
	 */
	@Override
	public BillingTable getBillingTable(long billingId)
		throws PortalException {
		return billingTablePersistence.findByPrimaryKey(billingId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(billingTableLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BillingTable.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("billingId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(billingTableLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(BillingTable.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("billingId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(billingTableLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BillingTable.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("billingId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return billingTableLocalService.deleteBillingTable((BillingTable)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return billingTablePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the billing tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.famocom.erpcloud.model.impl.BillingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of billing tables
	 * @param end the upper bound of the range of billing tables (not inclusive)
	 * @return the range of billing tables
	 */
	@Override
	public List<BillingTable> getBillingTables(int start, int end) {
		return billingTablePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of billing tables.
	 *
	 * @return the number of billing tables
	 */
	@Override
	public int getBillingTablesCount() {
		return billingTablePersistence.countAll();
	}

	/**
	 * Updates the billing table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param billingTable the billing table
	 * @return the billing table that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BillingTable updateBillingTable(BillingTable billingTable) {
		return billingTablePersistence.update(billingTable);
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
	public com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService getAppraisalPerformanceLocalService() {
		return appraisalPerformanceLocalService;
	}

	/**
	 * Sets the appraisal performance local service.
	 *
	 * @param appraisalPerformanceLocalService the appraisal performance local service
	 */
	public void setAppraisalPerformanceLocalService(
		com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService appraisalPerformanceLocalService) {
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
	 * Returns the billing table local service.
	 *
	 * @return the billing table local service
	 */
	public BillingTableLocalService getBillingTableLocalService() {
		return billingTableLocalService;
	}

	/**
	 * Sets the billing table local service.
	 *
	 * @param billingTableLocalService the billing table local service
	 */
	public void setBillingTableLocalService(
		BillingTableLocalService billingTableLocalService) {
		this.billingTableLocalService = billingTableLocalService;
	}

	/**
	 * Returns the billing table persistence.
	 *
	 * @return the billing table persistence
	 */
	public BillingTablePersistence getBillingTablePersistence() {
		return billingTablePersistence;
	}

	/**
	 * Sets the billing table persistence.
	 *
	 * @param billingTablePersistence the billing table persistence
	 */
	public void setBillingTablePersistence(
		BillingTablePersistence billingTablePersistence) {
		this.billingTablePersistence = billingTablePersistence;
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
		persistedModelLocalServiceRegistry.register("com.liferay.famocom.erpcloud.model.BillingTable",
			billingTableLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.famocom.erpcloud.model.BillingTable");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BillingTableLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BillingTable.class;
	}

	protected String getModelClassName() {
		return BillingTable.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = billingTablePersistence.getDataSource();

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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService appraisalPerformanceLocalService;
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
	@BeanReference(type = BillingTableLocalService.class)
	protected BillingTableLocalService billingTableLocalService;
	@BeanReference(type = BillingTablePersistence.class)
	protected BillingTablePersistence billingTablePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BookingRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BookingRoomLocalService bookingRoomLocalService;
	@BeanReference(type = BookingRoomPersistence.class)
	protected BookingRoomPersistence bookingRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BranchLocalService branchLocalService;
	@BeanReference(type = BranchPersistence.class)
	protected BranchPersistence branchPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterLocalService clientMasterLocalService;
	@BeanReference(type = ClientMasterPersistence.class)
	protected ClientMasterPersistence clientMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService conferenceRoomLocalService;
	@BeanReference(type = ConferenceRoomPersistence.class)
	protected ConferenceRoomPersistence conferenceRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmailTemplateLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmailTemplateLocalService emailTemplateLocalService;
	@BeanReference(type = EmailTemplatePersistence.class)
	protected EmailTemplatePersistence emailTemplatePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeLocalService employeeLocalService;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService employeeTypeLocalService;
	@BeanReference(type = EmployeeTypePersistence.class)
	protected EmployeeTypePersistence employeeTypePersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService;
	@BeanReference(type = ExpenseEntryHistoryPersistence.class)
	protected ExpenseEntryHistoryPersistence expenseEntryHistoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService geoAttendanceLocalService;
	@BeanReference(type = GeoAttendancePersistence.class)
	protected GeoAttendancePersistence geoAttendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService holidayCalenderManagementLocalService;
	@BeanReference(type = HolidayCalenderManagementPersistence.class)
	protected HolidayCalenderManagementPersistence holidayCalenderManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService interviewEvaluationLocalService;
	@BeanReference(type = InterviewEvaluationPersistence.class)
	protected InterviewEvaluationPersistence interviewEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyLocalService leaveApplyLocalService;
	@BeanReference(type = LeaveApplyPersistence.class)
	protected LeaveApplyPersistence leaveApplyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService leaveApplyDtlLocalService;
	@BeanReference(type = LeaveApplyDtlPersistence.class)
	protected LeaveApplyDtlPersistence leaveApplyDtlPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementLocalService leaveManagementLocalService;
	@BeanReference(type = LeaveManagementPersistence.class)
	protected LeaveManagementPersistence leaveManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService notificationMasterManageLocalService;
	@BeanReference(type = NotificationMasterManagePersistence.class)
	protected NotificationMasterManagePersistence notificationMasterManagePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService notificationSendManageLocalService;
	@BeanReference(type = NotificationSendManagePersistence.class)
	protected NotificationSendManagePersistence notificationSendManagePersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitProcessLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitProcessLocalService recruitProcessLocalService;
	@BeanReference(type = RecruitProcessPersistence.class)
	protected RecruitProcessPersistence recruitProcessPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ResignationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ResignationLocalService resignationLocalService;
	@BeanReference(type = ResignationPersistence.class)
	protected ResignationPersistence resignationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService schedulesDetailsLocalService;
	@BeanReference(type = SchedulesDetailsPersistence.class)
	protected SchedulesDetailsPersistence schedulesDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService schedulesMasterLocalService;
	@BeanReference(type = SchedulesMasterPersistence.class)
	protected SchedulesMasterPersistence schedulesMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetLocalService skillSetLocalService;
	@BeanReference(type = SkillSetPersistence.class)
	protected SkillSetPersistence skillSetPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService timeSheetEntryLocalService;
	@BeanReference(type = TimeSheetEntryPersistence.class)
	protected TimeSheetEntryPersistence timeSheetEntryPersistence;
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