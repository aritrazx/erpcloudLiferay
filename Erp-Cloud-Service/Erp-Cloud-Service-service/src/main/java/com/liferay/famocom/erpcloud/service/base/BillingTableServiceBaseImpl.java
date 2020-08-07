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

import com.liferay.famocom.erpcloud.model.BillingTable;
import com.liferay.famocom.erpcloud.service.BillingTableService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the billing table remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.famocom.erpcloud.service.impl.BillingTableServiceImpl}.
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.impl.BillingTableServiceImpl
 * @see com.liferay.famocom.erpcloud.service.BillingTableServiceUtil
 * @generated
 */
public abstract class BillingTableServiceBaseImpl extends BaseServiceImpl
	implements BillingTableService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.BillingTableServiceUtil} to access the billing table remote service.
	 */

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
	 * Returns the add team member remote service.
	 *
	 * @return the add team member remote service
	 */
	public com.liferay.famocom.erpcloud.service.AddTeamMemberService getAddTeamMemberService() {
		return addTeamMemberService;
	}

	/**
	 * Sets the add team member remote service.
	 *
	 * @param addTeamMemberService the add team member remote service
	 */
	public void setAddTeamMemberService(
		com.liferay.famocom.erpcloud.service.AddTeamMemberService addTeamMemberService) {
		this.addTeamMemberService = addTeamMemberService;
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
	 * Returns the appraisal goal details remote service.
	 *
	 * @return the appraisal goal details remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsService getAppraisalGoalDetailsService() {
		return appraisalGoalDetailsService;
	}

	/**
	 * Sets the appraisal goal details remote service.
	 *
	 * @param appraisalGoalDetailsService the appraisal goal details remote service
	 */
	public void setAppraisalGoalDetailsService(
		com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsService appraisalGoalDetailsService) {
		this.appraisalGoalDetailsService = appraisalGoalDetailsService;
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
	 * Returns the appraisal goal master remote service.
	 *
	 * @return the appraisal goal master remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalGoalMasterService getAppraisalGoalMasterService() {
		return appraisalGoalMasterService;
	}

	/**
	 * Sets the appraisal goal master remote service.
	 *
	 * @param appraisalGoalMasterService the appraisal goal master remote service
	 */
	public void setAppraisalGoalMasterService(
		com.liferay.famocom.erpcloud.service.AppraisalGoalMasterService appraisalGoalMasterService) {
		this.appraisalGoalMasterService = appraisalGoalMasterService;
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
	 * Returns the appraisal master remote service.
	 *
	 * @return the appraisal master remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalMasterService getAppraisalMasterService() {
		return appraisalMasterService;
	}

	/**
	 * Sets the appraisal master remote service.
	 *
	 * @param appraisalMasterService the appraisal master remote service
	 */
	public void setAppraisalMasterService(
		com.liferay.famocom.erpcloud.service.AppraisalMasterService appraisalMasterService) {
		this.appraisalMasterService = appraisalMasterService;
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
	 * Returns the appraisal performance remote service.
	 *
	 * @return the appraisal performance remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalPerformanceService getAppraisalPerformanceService() {
		return appraisalPerformanceService;
	}

	/**
	 * Sets the appraisal performance remote service.
	 *
	 * @param appraisalPerformanceService the appraisal performance remote service
	 */
	public void setAppraisalPerformanceService(
		com.liferay.famocom.erpcloud.service.AppraisalPerformanceService appraisalPerformanceService) {
		this.appraisalPerformanceService = appraisalPerformanceService;
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
	 * Returns the appraisal project master remote service.
	 *
	 * @return the appraisal project master remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalProjectMasterService getAppraisalProjectMasterService() {
		return appraisalProjectMasterService;
	}

	/**
	 * Sets the appraisal project master remote service.
	 *
	 * @param appraisalProjectMasterService the appraisal project master remote service
	 */
	public void setAppraisalProjectMasterService(
		com.liferay.famocom.erpcloud.service.AppraisalProjectMasterService appraisalProjectMasterService) {
		this.appraisalProjectMasterService = appraisalProjectMasterService;
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
	 * Returns the appraisal setup remote service.
	 *
	 * @return the appraisal setup remote service
	 */
	public com.liferay.famocom.erpcloud.service.AppraisalSetupService getAppraisalSetupService() {
		return appraisalSetupService;
	}

	/**
	 * Sets the appraisal setup remote service.
	 *
	 * @param appraisalSetupService the appraisal setup remote service
	 */
	public void setAppraisalSetupService(
		com.liferay.famocom.erpcloud.service.AppraisalSetupService appraisalSetupService) {
		this.appraisalSetupService = appraisalSetupService;
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
	 * Returns the attendance remote service.
	 *
	 * @return the attendance remote service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceService getAttendanceService() {
		return attendanceService;
	}

	/**
	 * Sets the attendance remote service.
	 *
	 * @param attendanceService the attendance remote service
	 */
	public void setAttendanceService(
		com.liferay.famocom.erpcloud.service.AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
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
	 * Returns the attendance bio remote service.
	 *
	 * @return the attendance bio remote service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceBioService getAttendanceBioService() {
		return attendanceBioService;
	}

	/**
	 * Sets the attendance bio remote service.
	 *
	 * @param attendanceBioService the attendance bio remote service
	 */
	public void setAttendanceBioService(
		com.liferay.famocom.erpcloud.service.AttendanceBioService attendanceBioService) {
		this.attendanceBioService = attendanceBioService;
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
	public com.liferay.famocom.erpcloud.service.BillingTableLocalService getBillingTableLocalService() {
		return billingTableLocalService;
	}

	/**
	 * Sets the billing table local service.
	 *
	 * @param billingTableLocalService the billing table local service
	 */
	public void setBillingTableLocalService(
		com.liferay.famocom.erpcloud.service.BillingTableLocalService billingTableLocalService) {
		this.billingTableLocalService = billingTableLocalService;
	}

	/**
	 * Returns the billing table remote service.
	 *
	 * @return the billing table remote service
	 */
	public BillingTableService getBillingTableService() {
		return billingTableService;
	}

	/**
	 * Sets the billing table remote service.
	 *
	 * @param billingTableService the billing table remote service
	 */
	public void setBillingTableService(BillingTableService billingTableService) {
		this.billingTableService = billingTableService;
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
	 * Returns the booking room remote service.
	 *
	 * @return the booking room remote service
	 */
	public com.liferay.famocom.erpcloud.service.BookingRoomService getBookingRoomService() {
		return bookingRoomService;
	}

	/**
	 * Sets the booking room remote service.
	 *
	 * @param bookingRoomService the booking room remote service
	 */
	public void setBookingRoomService(
		com.liferay.famocom.erpcloud.service.BookingRoomService bookingRoomService) {
		this.bookingRoomService = bookingRoomService;
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
	 * Returns the branch remote service.
	 *
	 * @return the branch remote service
	 */
	public com.liferay.famocom.erpcloud.service.BranchService getBranchService() {
		return branchService;
	}

	/**
	 * Sets the branch remote service.
	 *
	 * @param branchService the branch remote service
	 */
	public void setBranchService(
		com.liferay.famocom.erpcloud.service.BranchService branchService) {
		this.branchService = branchService;
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
	 * Returns the client master remote service.
	 *
	 * @return the client master remote service
	 */
	public com.liferay.famocom.erpcloud.service.ClientMasterService getClientMasterService() {
		return clientMasterService;
	}

	/**
	 * Sets the client master remote service.
	 *
	 * @param clientMasterService the client master remote service
	 */
	public void setClientMasterService(
		com.liferay.famocom.erpcloud.service.ClientMasterService clientMasterService) {
		this.clientMasterService = clientMasterService;
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
	 * Returns the conference room remote service.
	 *
	 * @return the conference room remote service
	 */
	public com.liferay.famocom.erpcloud.service.ConferenceRoomService getConferenceRoomService() {
		return conferenceRoomService;
	}

	/**
	 * Sets the conference room remote service.
	 *
	 * @param conferenceRoomService the conference room remote service
	 */
	public void setConferenceRoomService(
		com.liferay.famocom.erpcloud.service.ConferenceRoomService conferenceRoomService) {
		this.conferenceRoomService = conferenceRoomService;
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
	 * Returns the email template remote service.
	 *
	 * @return the email template remote service
	 */
	public com.liferay.famocom.erpcloud.service.EmailTemplateService getEmailTemplateService() {
		return emailTemplateService;
	}

	/**
	 * Sets the email template remote service.
	 *
	 * @param emailTemplateService the email template remote service
	 */
	public void setEmailTemplateService(
		com.liferay.famocom.erpcloud.service.EmailTemplateService emailTemplateService) {
		this.emailTemplateService = emailTemplateService;
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
	 * Returns the employee remote service.
	 *
	 * @return the employee remote service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeService getEmployeeService() {
		return employeeService;
	}

	/**
	 * Sets the employee remote service.
	 *
	 * @param employeeService the employee remote service
	 */
	public void setEmployeeService(
		com.liferay.famocom.erpcloud.service.EmployeeService employeeService) {
		this.employeeService = employeeService;
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
	 * Returns the employee type remote service.
	 *
	 * @return the employee type remote service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeTypeService getEmployeeTypeService() {
		return employeeTypeService;
	}

	/**
	 * Sets the employee type remote service.
	 *
	 * @param employeeTypeService the employee type remote service
	 */
	public void setEmployeeTypeService(
		com.liferay.famocom.erpcloud.service.EmployeeTypeService employeeTypeService) {
		this.employeeTypeService = employeeTypeService;
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
	 * Returns the evaluation remote service.
	 *
	 * @return the evaluation remote service
	 */
	public com.liferay.famocom.erpcloud.service.EvaluationService getEvaluationService() {
		return evaluationService;
	}

	/**
	 * Sets the evaluation remote service.
	 *
	 * @param evaluationService the evaluation remote service
	 */
	public void setEvaluationService(
		com.liferay.famocom.erpcloud.service.EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
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
	 * Returns the exp category remote service.
	 *
	 * @return the exp category remote service
	 */
	public com.liferay.famocom.erpcloud.service.ExpCategoryService getExpCategoryService() {
		return expCategoryService;
	}

	/**
	 * Sets the exp category remote service.
	 *
	 * @param expCategoryService the exp category remote service
	 */
	public void setExpCategoryService(
		com.liferay.famocom.erpcloud.service.ExpCategoryService expCategoryService) {
		this.expCategoryService = expCategoryService;
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
	 * Returns the expense remote service.
	 *
	 * @return the expense remote service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseService getExpenseService() {
		return expenseService;
	}

	/**
	 * Sets the expense remote service.
	 *
	 * @param expenseService the expense remote service
	 */
	public void setExpenseService(
		com.liferay.famocom.erpcloud.service.ExpenseService expenseService) {
		this.expenseService = expenseService;
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
	 * Returns the expense entry history remote service.
	 *
	 * @return the expense entry history remote service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService getExpenseEntryHistoryService() {
		return expenseEntryHistoryService;
	}

	/**
	 * Sets the expense entry history remote service.
	 *
	 * @param expenseEntryHistoryService the expense entry history remote service
	 */
	public void setExpenseEntryHistoryService(
		com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService expenseEntryHistoryService) {
		this.expenseEntryHistoryService = expenseEntryHistoryService;
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
	 * Returns the geo attendance remote service.
	 *
	 * @return the geo attendance remote service
	 */
	public com.liferay.famocom.erpcloud.service.GeoAttendanceService getGeoAttendanceService() {
		return geoAttendanceService;
	}

	/**
	 * Sets the geo attendance remote service.
	 *
	 * @param geoAttendanceService the geo attendance remote service
	 */
	public void setGeoAttendanceService(
		com.liferay.famocom.erpcloud.service.GeoAttendanceService geoAttendanceService) {
		this.geoAttendanceService = geoAttendanceService;
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
	 * Returns the holiday calender management remote service.
	 *
	 * @return the holiday calender management remote service
	 */
	public com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService getHolidayCalenderManagementService() {
		return holidayCalenderManagementService;
	}

	/**
	 * Sets the holiday calender management remote service.
	 *
	 * @param holidayCalenderManagementService the holiday calender management remote service
	 */
	public void setHolidayCalenderManagementService(
		com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService holidayCalenderManagementService) {
		this.holidayCalenderManagementService = holidayCalenderManagementService;
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
	 * Returns the interview evaluation remote service.
	 *
	 * @return the interview evaluation remote service
	 */
	public com.liferay.famocom.erpcloud.service.InterviewEvaluationService getInterviewEvaluationService() {
		return interviewEvaluationService;
	}

	/**
	 * Sets the interview evaluation remote service.
	 *
	 * @param interviewEvaluationService the interview evaluation remote service
	 */
	public void setInterviewEvaluationService(
		com.liferay.famocom.erpcloud.service.InterviewEvaluationService interviewEvaluationService) {
		this.interviewEvaluationService = interviewEvaluationService;
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
	 * Returns the leave apply remote service.
	 *
	 * @return the leave apply remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveApplyService getLeaveApplyService() {
		return leaveApplyService;
	}

	/**
	 * Sets the leave apply remote service.
	 *
	 * @param leaveApplyService the leave apply remote service
	 */
	public void setLeaveApplyService(
		com.liferay.famocom.erpcloud.service.LeaveApplyService leaveApplyService) {
		this.leaveApplyService = leaveApplyService;
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
	 * Returns the leave apply dtl remote service.
	 *
	 * @return the leave apply dtl remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveApplyDtlService getLeaveApplyDtlService() {
		return leaveApplyDtlService;
	}

	/**
	 * Sets the leave apply dtl remote service.
	 *
	 * @param leaveApplyDtlService the leave apply dtl remote service
	 */
	public void setLeaveApplyDtlService(
		com.liferay.famocom.erpcloud.service.LeaveApplyDtlService leaveApplyDtlService) {
		this.leaveApplyDtlService = leaveApplyDtlService;
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
	 * Returns the leave management remote service.
	 *
	 * @return the leave management remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveManagementService getLeaveManagementService() {
		return leaveManagementService;
	}

	/**
	 * Sets the leave management remote service.
	 *
	 * @param leaveManagementService the leave management remote service
	 */
	public void setLeaveManagementService(
		com.liferay.famocom.erpcloud.service.LeaveManagementService leaveManagementService) {
		this.leaveManagementService = leaveManagementService;
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
	 * Returns the notification master manage remote service.
	 *
	 * @return the notification master manage remote service
	 */
	public com.liferay.famocom.erpcloud.service.NotificationMasterManageService getNotificationMasterManageService() {
		return notificationMasterManageService;
	}

	/**
	 * Sets the notification master manage remote service.
	 *
	 * @param notificationMasterManageService the notification master manage remote service
	 */
	public void setNotificationMasterManageService(
		com.liferay.famocom.erpcloud.service.NotificationMasterManageService notificationMasterManageService) {
		this.notificationMasterManageService = notificationMasterManageService;
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
	 * Returns the notification send manage remote service.
	 *
	 * @return the notification send manage remote service
	 */
	public com.liferay.famocom.erpcloud.service.NotificationSendManageService getNotificationSendManageService() {
		return notificationSendManageService;
	}

	/**
	 * Sets the notification send manage remote service.
	 *
	 * @param notificationSendManageService the notification send manage remote service
	 */
	public void setNotificationSendManageService(
		com.liferay.famocom.erpcloud.service.NotificationSendManageService notificationSendManageService) {
		this.notificationSendManageService = notificationSendManageService;
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
	 * Returns the project master remote service.
	 *
	 * @return the project master remote service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectMasterService getProjectMasterService() {
		return projectMasterService;
	}

	/**
	 * Sets the project master remote service.
	 *
	 * @param projectMasterService the project master remote service
	 */
	public void setProjectMasterService(
		com.liferay.famocom.erpcloud.service.ProjectMasterService projectMasterService) {
		this.projectMasterService = projectMasterService;
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
	 * Returns the project role remote service.
	 *
	 * @return the project role remote service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectRoleService getProjectRoleService() {
		return projectRoleService;
	}

	/**
	 * Sets the project role remote service.
	 *
	 * @param projectRoleService the project role remote service
	 */
	public void setProjectRoleService(
		com.liferay.famocom.erpcloud.service.ProjectRoleService projectRoleService) {
		this.projectRoleService = projectRoleService;
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
	 * Returns the project status remote service.
	 *
	 * @return the project status remote service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectStatusService getProjectStatusService() {
		return projectStatusService;
	}

	/**
	 * Sets the project status remote service.
	 *
	 * @param projectStatusService the project status remote service
	 */
	public void setProjectStatusService(
		com.liferay.famocom.erpcloud.service.ProjectStatusService projectStatusService) {
		this.projectStatusService = projectStatusService;
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
	 * Returns the project task remote service.
	 *
	 * @return the project task remote service
	 */
	public com.liferay.famocom.erpcloud.service.ProjectTaskService getProjectTaskService() {
		return projectTaskService;
	}

	/**
	 * Sets the project task remote service.
	 *
	 * @param projectTaskService the project task remote service
	 */
	public void setProjectTaskService(
		com.liferay.famocom.erpcloud.service.ProjectTaskService projectTaskService) {
		this.projectTaskService = projectTaskService;
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
	 * Returns the recruit process remote service.
	 *
	 * @return the recruit process remote service
	 */
	public com.liferay.famocom.erpcloud.service.RecruitProcessService getRecruitProcessService() {
		return recruitProcessService;
	}

	/**
	 * Sets the recruit process remote service.
	 *
	 * @param recruitProcessService the recruit process remote service
	 */
	public void setRecruitProcessService(
		com.liferay.famocom.erpcloud.service.RecruitProcessService recruitProcessService) {
		this.recruitProcessService = recruitProcessService;
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
	 * Returns the resignation remote service.
	 *
	 * @return the resignation remote service
	 */
	public com.liferay.famocom.erpcloud.service.ResignationService getResignationService() {
		return resignationService;
	}

	/**
	 * Sets the resignation remote service.
	 *
	 * @param resignationService the resignation remote service
	 */
	public void setResignationService(
		com.liferay.famocom.erpcloud.service.ResignationService resignationService) {
		this.resignationService = resignationService;
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
	 * Returns the schedules details remote service.
	 *
	 * @return the schedules details remote service
	 */
	public com.liferay.famocom.erpcloud.service.SchedulesDetailsService getSchedulesDetailsService() {
		return schedulesDetailsService;
	}

	/**
	 * Sets the schedules details remote service.
	 *
	 * @param schedulesDetailsService the schedules details remote service
	 */
	public void setSchedulesDetailsService(
		com.liferay.famocom.erpcloud.service.SchedulesDetailsService schedulesDetailsService) {
		this.schedulesDetailsService = schedulesDetailsService;
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
	 * Returns the schedules master remote service.
	 *
	 * @return the schedules master remote service
	 */
	public com.liferay.famocom.erpcloud.service.SchedulesMasterService getSchedulesMasterService() {
		return schedulesMasterService;
	}

	/**
	 * Sets the schedules master remote service.
	 *
	 * @param schedulesMasterService the schedules master remote service
	 */
	public void setSchedulesMasterService(
		com.liferay.famocom.erpcloud.service.SchedulesMasterService schedulesMasterService) {
		this.schedulesMasterService = schedulesMasterService;
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
	 * Returns the skill set remote service.
	 *
	 * @return the skill set remote service
	 */
	public com.liferay.famocom.erpcloud.service.SkillSetService getSkillSetService() {
		return skillSetService;
	}

	/**
	 * Sets the skill set remote service.
	 *
	 * @param skillSetService the skill set remote service
	 */
	public void setSkillSetService(
		com.liferay.famocom.erpcloud.service.SkillSetService skillSetService) {
		this.skillSetService = skillSetService;
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
	 * Returns the time sheet entry remote service.
	 *
	 * @return the time sheet entry remote service
	 */
	public com.liferay.famocom.erpcloud.service.TimeSheetEntryService getTimeSheetEntryService() {
		return timeSheetEntryService;
	}

	/**
	 * Sets the time sheet entry remote service.
	 *
	 * @param timeSheetEntryService the time sheet entry remote service
	 */
	public void setTimeSheetEntryService(
		com.liferay.famocom.erpcloud.service.TimeSheetEntryService timeSheetEntryService) {
		this.timeSheetEntryService = timeSheetEntryService;
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
	 * Returns the travel desk details remote service.
	 *
	 * @return the travel desk details remote service
	 */
	public com.liferay.famocom.erpcloud.service.TravelDeskDetailsService getTravelDeskDetailsService() {
		return travelDeskDetailsService;
	}

	/**
	 * Sets the travel desk details remote service.
	 *
	 * @param travelDeskDetailsService the travel desk details remote service
	 */
	public void setTravelDeskDetailsService(
		com.liferay.famocom.erpcloud.service.TravelDeskDetailsService travelDeskDetailsService) {
		this.travelDeskDetailsService = travelDeskDetailsService;
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
	 * Returns the work from home remote service.
	 *
	 * @return the work from home remote service
	 */
	public com.liferay.famocom.erpcloud.service.WorkFromHomeService getWorkFromHomeService() {
		return workFromHomeService;
	}

	/**
	 * Sets the work from home remote service.
	 *
	 * @param workFromHomeService the work from home remote service
	 */
	public void setWorkFromHomeService(
		com.liferay.famocom.erpcloud.service.WorkFromHomeService workFromHomeService) {
		this.workFromHomeService = workFromHomeService;
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
	 * Returns the works schedules remote service.
	 *
	 * @return the works schedules remote service
	 */
	public com.liferay.famocom.erpcloud.service.WorksSchedulesService getWorksSchedulesService() {
		return worksSchedulesService;
	}

	/**
	 * Sets the works schedules remote service.
	 *
	 * @param worksSchedulesService the works schedules remote service
	 */
	public void setWorksSchedulesService(
		com.liferay.famocom.erpcloud.service.WorksSchedulesService worksSchedulesService) {
		this.worksSchedulesService = worksSchedulesService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BillingTableService.class.getName();
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AddTeamMemberService.class)
	protected com.liferay.famocom.erpcloud.service.AddTeamMemberService addTeamMemberService;
	@BeanReference(type = AddTeamMemberPersistence.class)
	protected AddTeamMemberPersistence addTeamMemberPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsLocalService appraisalGoalDetailsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalDetailsService appraisalGoalDetailsService;
	@BeanReference(type = AppraisalGoalDetailsPersistence.class)
	protected AppraisalGoalDetailsPersistence appraisalGoalDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalMasterLocalService appraisalGoalMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalGoalMasterService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalGoalMasterService appraisalGoalMasterService;
	@BeanReference(type = AppraisalGoalMasterPersistence.class)
	protected AppraisalGoalMasterPersistence appraisalGoalMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalMasterLocalService appraisalMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalMasterService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalMasterService appraisalMasterService;
	@BeanReference(type = AppraisalMasterPersistence.class)
	protected AppraisalMasterPersistence appraisalMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalPerformanceLocalService appraisalPerformanceLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalPerformanceService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalPerformanceService appraisalPerformanceService;
	@BeanReference(type = AppraisalPerformancePersistence.class)
	protected AppraisalPerformancePersistence appraisalPerformancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalProjectMasterLocalService appraisalProjectMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalProjectMasterService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalProjectMasterService appraisalProjectMasterService;
	@BeanReference(type = AppraisalProjectMasterPersistence.class)
	protected AppraisalProjectMasterPersistence appraisalProjectMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalSetupLocalService appraisalSetupLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AppraisalSetupService.class)
	protected com.liferay.famocom.erpcloud.service.AppraisalSetupService appraisalSetupService;
	@BeanReference(type = AppraisalSetupPersistence.class)
	protected AppraisalSetupPersistence appraisalSetupPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceLocalService attendanceLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceService attendanceService;
	@BeanReference(type = AttendancePersistence.class)
	protected AttendancePersistence attendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceBioLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceBioLocalService attendanceBioLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceBioService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceBioService attendanceBioService;
	@BeanReference(type = AttendanceBioPersistence.class)
	protected AttendanceBioPersistence attendanceBioPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillingTableLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BillingTableLocalService billingTableLocalService;
	@BeanReference(type = BillingTableService.class)
	protected BillingTableService billingTableService;
	@BeanReference(type = BillingTablePersistence.class)
	protected BillingTablePersistence billingTablePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BookingRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BookingRoomLocalService bookingRoomLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BookingRoomService.class)
	protected com.liferay.famocom.erpcloud.service.BookingRoomService bookingRoomService;
	@BeanReference(type = BookingRoomPersistence.class)
	protected BookingRoomPersistence bookingRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BranchLocalService branchLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchService.class)
	protected com.liferay.famocom.erpcloud.service.BranchService branchService;
	@BeanReference(type = BranchPersistence.class)
	protected BranchPersistence branchPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterLocalService clientMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterService clientMasterService;
	@BeanReference(type = ClientMasterPersistence.class)
	protected ClientMasterPersistence clientMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService conferenceRoomLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomService conferenceRoomService;
	@BeanReference(type = ConferenceRoomPersistence.class)
	protected ConferenceRoomPersistence conferenceRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmailTemplateLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmailTemplateLocalService emailTemplateLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmailTemplateService.class)
	protected com.liferay.famocom.erpcloud.service.EmailTemplateService emailTemplateService;
	@BeanReference(type = EmailTemplatePersistence.class)
	protected EmailTemplatePersistence emailTemplatePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeLocalService employeeLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeService employeeService;
	@BeanReference(type = EmployeePersistence.class)
	protected EmployeePersistence employeePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService employeeTypeLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeService employeeTypeService;
	@BeanReference(type = EmployeeTypePersistence.class)
	protected EmployeeTypePersistence employeeTypePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EvaluationLocalService evaluationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EvaluationService.class)
	protected com.liferay.famocom.erpcloud.service.EvaluationService evaluationService;
	@BeanReference(type = EvaluationPersistence.class)
	protected EvaluationPersistence evaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpCategoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpCategoryLocalService expCategoryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpCategoryService.class)
	protected com.liferay.famocom.erpcloud.service.ExpCategoryService expCategoryService;
	@BeanReference(type = ExpCategoryPersistence.class)
	protected ExpCategoryPersistence expCategoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseLocalService expenseLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseService expenseService;
	@BeanReference(type = ExpensePersistence.class)
	protected ExpensePersistence expensePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService expenseEntryHistoryService;
	@BeanReference(type = ExpenseEntryHistoryPersistence.class)
	protected ExpenseEntryHistoryPersistence expenseEntryHistoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService geoAttendanceLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceService geoAttendanceService;
	@BeanReference(type = GeoAttendancePersistence.class)
	protected GeoAttendancePersistence geoAttendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService holidayCalenderManagementLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService holidayCalenderManagementService;
	@BeanReference(type = HolidayCalenderManagementPersistence.class)
	protected HolidayCalenderManagementPersistence holidayCalenderManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService interviewEvaluationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationService interviewEvaluationService;
	@BeanReference(type = InterviewEvaluationPersistence.class)
	protected InterviewEvaluationPersistence interviewEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyLocalService leaveApplyLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyService leaveApplyService;
	@BeanReference(type = LeaveApplyPersistence.class)
	protected LeaveApplyPersistence leaveApplyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyDtlLocalService leaveApplyDtlLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveApplyDtlService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveApplyDtlService leaveApplyDtlService;
	@BeanReference(type = LeaveApplyDtlPersistence.class)
	protected LeaveApplyDtlPersistence leaveApplyDtlPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementLocalService leaveManagementLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementService leaveManagementService;
	@BeanReference(type = LeaveManagementPersistence.class)
	protected LeaveManagementPersistence leaveManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationMasterManageLocalService notificationMasterManageLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationMasterManageService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationMasterManageService notificationMasterManageService;
	@BeanReference(type = NotificationMasterManagePersistence.class)
	protected NotificationMasterManagePersistence notificationMasterManagePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationSendManageLocalService notificationSendManageLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.NotificationSendManageService.class)
	protected com.liferay.famocom.erpcloud.service.NotificationSendManageService notificationSendManageService;
	@BeanReference(type = NotificationSendManagePersistence.class)
	protected NotificationSendManagePersistence notificationSendManagePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectMasterLocalService projectMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectMasterService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectMasterService projectMasterService;
	@BeanReference(type = ProjectMasterPersistence.class)
	protected ProjectMasterPersistence projectMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectRoleLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectRoleLocalService projectRoleLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectRoleService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectRoleService projectRoleService;
	@BeanReference(type = ProjectRolePersistence.class)
	protected ProjectRolePersistence projectRolePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectStatusLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectStatusLocalService projectStatusLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectStatusService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectStatusService projectStatusService;
	@BeanReference(type = ProjectStatusPersistence.class)
	protected ProjectStatusPersistence projectStatusPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectTaskLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectTaskLocalService projectTaskLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ProjectTaskService.class)
	protected com.liferay.famocom.erpcloud.service.ProjectTaskService projectTaskService;
	@BeanReference(type = ProjectTaskPersistence.class)
	protected ProjectTaskPersistence projectTaskPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitProcessLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitProcessLocalService recruitProcessLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitProcessService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitProcessService recruitProcessService;
	@BeanReference(type = RecruitProcessPersistence.class)
	protected RecruitProcessPersistence recruitProcessPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ResignationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ResignationLocalService resignationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ResignationService.class)
	protected com.liferay.famocom.erpcloud.service.ResignationService resignationService;
	@BeanReference(type = ResignationPersistence.class)
	protected ResignationPersistence resignationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesDetailsLocalService schedulesDetailsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesDetailsService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesDetailsService schedulesDetailsService;
	@BeanReference(type = SchedulesDetailsPersistence.class)
	protected SchedulesDetailsPersistence schedulesDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesMasterLocalService schedulesMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SchedulesMasterService.class)
	protected com.liferay.famocom.erpcloud.service.SchedulesMasterService schedulesMasterService;
	@BeanReference(type = SchedulesMasterPersistence.class)
	protected SchedulesMasterPersistence schedulesMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetLocalService skillSetLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetService skillSetService;
	@BeanReference(type = SkillSetPersistence.class)
	protected SkillSetPersistence skillSetPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService timeSheetEntryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryService timeSheetEntryService;
	@BeanReference(type = TimeSheetEntryPersistence.class)
	protected TimeSheetEntryPersistence timeSheetEntryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TravelDeskDetailsLocalService travelDeskDetailsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TravelDeskDetailsService.class)
	protected com.liferay.famocom.erpcloud.service.TravelDeskDetailsService travelDeskDetailsService;
	@BeanReference(type = TravelDeskDetailsPersistence.class)
	protected TravelDeskDetailsPersistence travelDeskDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.WorkFromHomeLocalService workFromHomeLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorkFromHomeService.class)
	protected com.liferay.famocom.erpcloud.service.WorkFromHomeService workFromHomeService;
	@BeanReference(type = WorkFromHomePersistence.class)
	protected WorkFromHomePersistence workFromHomePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.WorksSchedulesLocalService worksSchedulesLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.WorksSchedulesService.class)
	protected com.liferay.famocom.erpcloud.service.WorksSchedulesService worksSchedulesService;
	@BeanReference(type = WorksSchedulesPersistence.class)
	protected WorksSchedulesPersistence worksSchedulesPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}