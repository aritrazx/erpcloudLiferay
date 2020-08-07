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

import com.liferay.famocom.erpcloud.model.BookingRoom;
import com.liferay.famocom.erpcloud.service.BookingRoomService;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the booking room remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.famocom.erpcloud.service.impl.BookingRoomServiceImpl}.
 * </p>
 *
 * @author Samaresh
 * @see com.liferay.famocom.erpcloud.service.impl.BookingRoomServiceImpl
 * @see com.liferay.famocom.erpcloud.service.BookingRoomServiceUtil
 * @generated
 */
public abstract class BookingRoomServiceBaseImpl extends BaseServiceImpl
	implements BookingRoomService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.famocom.erpcloud.service.BookingRoomServiceUtil} to access the booking room remote service.
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
	 * Returns the attendance check list remote service.
	 *
	 * @return the attendance check list remote service
	 */
	public com.liferay.famocom.erpcloud.service.AttendanceCheckListService getAttendanceCheckListService() {
		return attendanceCheckListService;
	}

	/**
	 * Sets the attendance check list remote service.
	 *
	 * @param attendanceCheckListService the attendance check list remote service
	 */
	public void setAttendanceCheckListService(
		com.liferay.famocom.erpcloud.service.AttendanceCheckListService attendanceCheckListService) {
		this.attendanceCheckListService = attendanceCheckListService;
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
	 * Returns the bank master remote service.
	 *
	 * @return the bank master remote service
	 */
	public com.liferay.famocom.erpcloud.service.BankMasterService getBankMasterService() {
		return bankMasterService;
	}

	/**
	 * Sets the bank master remote service.
	 *
	 * @param bankMasterService the bank master remote service
	 */
	public void setBankMasterService(
		com.liferay.famocom.erpcloud.service.BankMasterService bankMasterService) {
		this.bankMasterService = bankMasterService;
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
	 * Returns the bill document upload file remote service.
	 *
	 * @return the bill document upload file remote service
	 */
	public com.liferay.famocom.erpcloud.service.BillDocumentUploadFileService getBillDocumentUploadFileService() {
		return billDocumentUploadFileService;
	}

	/**
	 * Sets the bill document upload file remote service.
	 *
	 * @param billDocumentUploadFileService the bill document upload file remote service
	 */
	public void setBillDocumentUploadFileService(
		com.liferay.famocom.erpcloud.service.BillDocumentUploadFileService billDocumentUploadFileService) {
		this.billDocumentUploadFileService = billDocumentUploadFileService;
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
	 * Returns the billing remote service.
	 *
	 * @return the billing remote service
	 */
	public com.liferay.famocom.erpcloud.service.BillingService getBillingService() {
		return billingService;
	}

	/**
	 * Sets the billing remote service.
	 *
	 * @param billingService the billing remote service
	 */
	public void setBillingService(
		com.liferay.famocom.erpcloud.service.BillingService billingService) {
		this.billingService = billingService;
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
	 * Returns the booking room remote service.
	 *
	 * @return the booking room remote service
	 */
	public BookingRoomService getBookingRoomService() {
		return bookingRoomService;
	}

	/**
	 * Sets the booking room remote service.
	 *
	 * @param bookingRoomService the booking room remote service
	 */
	public void setBookingRoomService(BookingRoomService bookingRoomService) {
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
	 * Returns the candidate apply remote service.
	 *
	 * @return the candidate apply remote service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateApplyService getCandidateApplyService() {
		return candidateApplyService;
	}

	/**
	 * Sets the candidate apply remote service.
	 *
	 * @param candidateApplyService the candidate apply remote service
	 */
	public void setCandidateApplyService(
		com.liferay.famocom.erpcloud.service.CandidateApplyService candidateApplyService) {
		this.candidateApplyService = candidateApplyService;
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
	 * Returns the candidate evaluation remote service.
	 *
	 * @return the candidate evaluation remote service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateEvaluationService getCandidateEvaluationService() {
		return candidateEvaluationService;
	}

	/**
	 * Sets the candidate evaluation remote service.
	 *
	 * @param candidateEvaluationService the candidate evaluation remote service
	 */
	public void setCandidateEvaluationService(
		com.liferay.famocom.erpcloud.service.CandidateEvaluationService candidateEvaluationService) {
		this.candidateEvaluationService = candidateEvaluationService;
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
	 * Returns the candidate pay structure master remote service.
	 *
	 * @return the candidate pay structure master remote service
	 */
	public com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterService getCandidatePayStructureMasterService() {
		return candidatePayStructureMasterService;
	}

	/**
	 * Sets the candidate pay structure master remote service.
	 *
	 * @param candidatePayStructureMasterService the candidate pay structure master remote service
	 */
	public void setCandidatePayStructureMasterService(
		com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterService candidatePayStructureMasterService) {
		this.candidatePayStructureMasterService = candidatePayStructureMasterService;
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
	 * Returns the candidate review remote service.
	 *
	 * @return the candidate review remote service
	 */
	public com.liferay.famocom.erpcloud.service.CandidateReviewService getCandidateReviewService() {
		return candidateReviewService;
	}

	/**
	 * Sets the candidate review remote service.
	 *
	 * @param candidateReviewService the candidate review remote service
	 */
	public void setCandidateReviewService(
		com.liferay.famocom.erpcloud.service.CandidateReviewService candidateReviewService) {
		this.candidateReviewService = candidateReviewService;
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
	 * Returns the company policy remote service.
	 *
	 * @return the company policy remote service
	 */
	public com.liferay.famocom.erpcloud.service.CompanyPolicyService getCompanyPolicyService() {
		return companyPolicyService;
	}

	/**
	 * Sets the company policy remote service.
	 *
	 * @param companyPolicyService the company policy remote service
	 */
	public void setCompanyPolicyService(
		com.liferay.famocom.erpcloud.service.CompanyPolicyService companyPolicyService) {
		this.companyPolicyService = companyPolicyService;
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
	 * Returns the document upload file remote service.
	 *
	 * @return the document upload file remote service
	 */
	public com.liferay.famocom.erpcloud.service.DocumentUploadFileService getDocumentUploadFileService() {
		return documentUploadFileService;
	}

	/**
	 * Sets the document upload file remote service.
	 *
	 * @param documentUploadFileService the document upload file remote service
	 */
	public void setDocumentUploadFileService(
		com.liferay.famocom.erpcloud.service.DocumentUploadFileService documentUploadFileService) {
		this.documentUploadFileService = documentUploadFileService;
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
	 * Returns the employee document upload remote service.
	 *
	 * @return the employee document upload remote service
	 */
	public com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadService getEmployeeDocumentUploadService() {
		return employeeDocumentUploadService;
	}

	/**
	 * Sets the employee document upload remote service.
	 *
	 * @param employeeDocumentUploadService the employee document upload remote service
	 */
	public void setEmployeeDocumentUploadService(
		com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadService employeeDocumentUploadService) {
		this.employeeDocumentUploadService = employeeDocumentUploadService;
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
	 * Returns the emp pay structure remote service.
	 *
	 * @return the emp pay structure remote service
	 */
	public com.liferay.famocom.erpcloud.service.EmpPayStructureService getEmpPayStructureService() {
		return empPayStructureService;
	}

	/**
	 * Sets the emp pay structure remote service.
	 *
	 * @param empPayStructureService the emp pay structure remote service
	 */
	public void setEmpPayStructureService(
		com.liferay.famocom.erpcloud.service.EmpPayStructureService empPayStructureService) {
		this.empPayStructureService = empPayStructureService;
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
	 * Returns the expense entry remote service.
	 *
	 * @return the expense entry remote service
	 */
	public com.liferay.famocom.erpcloud.service.ExpenseEntryService getExpenseEntryService() {
		return expenseEntryService;
	}

	/**
	 * Sets the expense entry remote service.
	 *
	 * @param expenseEntryService the expense entry remote service
	 */
	public void setExpenseEntryService(
		com.liferay.famocom.erpcloud.service.ExpenseEntryService expenseEntryService) {
		this.expenseEntryService = expenseEntryService;
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
	 * Returns the exp proof files remote service.
	 *
	 * @return the exp proof files remote service
	 */
	public com.liferay.famocom.erpcloud.service.ExpProofFilesService getExpProofFilesService() {
		return expProofFilesService;
	}

	/**
	 * Sets the exp proof files remote service.
	 *
	 * @param expProofFilesService the exp proof files remote service
	 */
	public void setExpProofFilesService(
		com.liferay.famocom.erpcloud.service.ExpProofFilesService expProofFilesService) {
		this.expProofFilesService = expProofFilesService;
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
	 * Returns the fin salary remote service.
	 *
	 * @return the fin salary remote service
	 */
	public com.liferay.famocom.erpcloud.service.FinSalaryService getFinSalaryService() {
		return finSalaryService;
	}

	/**
	 * Sets the fin salary remote service.
	 *
	 * @param finSalaryService the fin salary remote service
	 */
	public void setFinSalaryService(
		com.liferay.famocom.erpcloud.service.FinSalaryService finSalaryService) {
		this.finSalaryService = finSalaryService;
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
	 * Returns the form sixteen remote service.
	 *
	 * @return the form sixteen remote service
	 */
	public com.liferay.famocom.erpcloud.service.FormSixteenService getFormSixteenService() {
		return formSixteenService;
	}

	/**
	 * Sets the form sixteen remote service.
	 *
	 * @param formSixteenService the form sixteen remote service
	 */
	public void setFormSixteenService(
		com.liferay.famocom.erpcloud.service.FormSixteenService formSixteenService) {
		this.formSixteenService = formSixteenService;
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
	 * Returns the form sixteen error file remote service.
	 *
	 * @return the form sixteen error file remote service
	 */
	public com.liferay.famocom.erpcloud.service.FormSixteenErrorFileService getFormSixteenErrorFileService() {
		return formSixteenErrorFileService;
	}

	/**
	 * Sets the form sixteen error file remote service.
	 *
	 * @param formSixteenErrorFileService the form sixteen error file remote service
	 */
	public void setFormSixteenErrorFileService(
		com.liferay.famocom.erpcloud.service.FormSixteenErrorFileService formSixteenErrorFileService) {
		this.formSixteenErrorFileService = formSixteenErrorFileService;
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
	 * Returns the goal details remote service.
	 *
	 * @return the goal details remote service
	 */
	public com.liferay.famocom.erpcloud.service.GoalDetailsService getGoalDetailsService() {
		return goalDetailsService;
	}

	/**
	 * Sets the goal details remote service.
	 *
	 * @param goalDetailsService the goal details remote service
	 */
	public void setGoalDetailsService(
		com.liferay.famocom.erpcloud.service.GoalDetailsService goalDetailsService) {
		this.goalDetailsService = goalDetailsService;
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
	 * Returns the goal master remote service.
	 *
	 * @return the goal master remote service
	 */
	public com.liferay.famocom.erpcloud.service.GoalMasterService getGoalMasterService() {
		return goalMasterService;
	}

	/**
	 * Sets the goal master remote service.
	 *
	 * @param goalMasterService the goal master remote service
	 */
	public void setGoalMasterService(
		com.liferay.famocom.erpcloud.service.GoalMasterService goalMasterService) {
		this.goalMasterService = goalMasterService;
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
	 * Returns the job evaluation remote service.
	 *
	 * @return the job evaluation remote service
	 */
	public com.liferay.famocom.erpcloud.service.JobEvaluationService getJobEvaluationService() {
		return jobEvaluationService;
	}

	/**
	 * Sets the job evaluation remote service.
	 *
	 * @param jobEvaluationService the job evaluation remote service
	 */
	public void setJobEvaluationService(
		com.liferay.famocom.erpcloud.service.JobEvaluationService jobEvaluationService) {
		this.jobEvaluationService = jobEvaluationService;
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
	 * Returns the job opening remote service.
	 *
	 * @return the job opening remote service
	 */
	public com.liferay.famocom.erpcloud.service.JobOpeningService getJobOpeningService() {
		return jobOpeningService;
	}

	/**
	 * Sets the job opening remote service.
	 *
	 * @param jobOpeningService the job opening remote service
	 */
	public void setJobOpeningService(
		com.liferay.famocom.erpcloud.service.JobOpeningService jobOpeningService) {
		this.jobOpeningService = jobOpeningService;
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
	 * Returns the job post remote service.
	 *
	 * @return the job post remote service
	 */
	public com.liferay.famocom.erpcloud.service.JobPostService getJobPostService() {
		return jobPostService;
	}

	/**
	 * Sets the job post remote service.
	 *
	 * @param jobPostService the job post remote service
	 */
	public void setJobPostService(
		com.liferay.famocom.erpcloud.service.JobPostService jobPostService) {
		this.jobPostService = jobPostService;
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
	 * Returns the leave doc remote service.
	 *
	 * @return the leave doc remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveDocService getLeaveDocService() {
		return leaveDocService;
	}

	/**
	 * Sets the leave doc remote service.
	 *
	 * @param leaveDocService the leave doc remote service
	 */
	public void setLeaveDocService(
		com.liferay.famocom.erpcloud.service.LeaveDocService leaveDocService) {
		this.leaveDocService = leaveDocService;
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
	 * Returns the leave ob remote service.
	 *
	 * @return the leave ob remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveObService getLeaveObService() {
		return leaveObService;
	}

	/**
	 * Sets the leave ob remote service.
	 *
	 * @param leaveObService the leave ob remote service
	 */
	public void setLeaveObService(
		com.liferay.famocom.erpcloud.service.LeaveObService leaveObService) {
		this.leaveObService = leaveObService;
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
	 * Returns the leave type remote service.
	 *
	 * @return the leave type remote service
	 */
	public com.liferay.famocom.erpcloud.service.LeaveTypeService getLeaveTypeService() {
		return leaveTypeService;
	}

	/**
	 * Sets the leave type remote service.
	 *
	 * @param leaveTypeService the leave type remote service
	 */
	public void setLeaveTypeService(
		com.liferay.famocom.erpcloud.service.LeaveTypeService leaveTypeService) {
		this.leaveTypeService = leaveTypeService;
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
	 * Returns the milestone remote service.
	 *
	 * @return the milestone remote service
	 */
	public com.liferay.famocom.erpcloud.service.MilestoneService getMilestoneService() {
		return milestoneService;
	}

	/**
	 * Sets the milestone remote service.
	 *
	 * @param milestoneService the milestone remote service
	 */
	public void setMilestoneService(
		com.liferay.famocom.erpcloud.service.MilestoneService milestoneService) {
		this.milestoneService = milestoneService;
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
	 * Returns the monthly adjustment remote service.
	 *
	 * @return the monthly adjustment remote service
	 */
	public com.liferay.famocom.erpcloud.service.MonthlyAdjustmentService getMonthlyAdjustmentService() {
		return monthlyAdjustmentService;
	}

	/**
	 * Sets the monthly adjustment remote service.
	 *
	 * @param monthlyAdjustmentService the monthly adjustment remote service
	 */
	public void setMonthlyAdjustmentService(
		com.liferay.famocom.erpcloud.service.MonthlyAdjustmentService monthlyAdjustmentService) {
		this.monthlyAdjustmentService = monthlyAdjustmentService;
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
	 * Returns the pay component remote service.
	 *
	 * @return the pay component remote service
	 */
	public com.liferay.famocom.erpcloud.service.PayComponentService getPayComponentService() {
		return payComponentService;
	}

	/**
	 * Sets the pay component remote service.
	 *
	 * @param payComponentService the pay component remote service
	 */
	public void setPayComponentService(
		com.liferay.famocom.erpcloud.service.PayComponentService payComponentService) {
		this.payComponentService = payComponentService;
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
	 * Returns the payroll increment remote service.
	 *
	 * @return the payroll increment remote service
	 */
	public com.liferay.famocom.erpcloud.service.PayrollIncrementService getPayrollIncrementService() {
		return payrollIncrementService;
	}

	/**
	 * Sets the payroll increment remote service.
	 *
	 * @param payrollIncrementService the payroll increment remote service
	 */
	public void setPayrollIncrementService(
		com.liferay.famocom.erpcloud.service.PayrollIncrementService payrollIncrementService) {
		this.payrollIncrementService = payrollIncrementService;
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
	 * Returns the payroll slabs remote service.
	 *
	 * @return the payroll slabs remote service
	 */
	public com.liferay.famocom.erpcloud.service.PayrollSlabsService getPayrollSlabsService() {
		return payrollSlabsService;
	}

	/**
	 * Sets the payroll slabs remote service.
	 *
	 * @param payrollSlabsService the payroll slabs remote service
	 */
	public void setPayrollSlabsService(
		com.liferay.famocom.erpcloud.service.PayrollSlabsService payrollSlabsService) {
		this.payrollSlabsService = payrollSlabsService;
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
	 * Returns the performance remote service.
	 *
	 * @return the performance remote service
	 */
	public com.liferay.famocom.erpcloud.service.PerformanceService getPerformanceService() {
		return performanceService;
	}

	/**
	 * Sets the performance remote service.
	 *
	 * @param performanceService the performance remote service
	 */
	public void setPerformanceService(
		com.liferay.famocom.erpcloud.service.PerformanceService performanceService) {
		this.performanceService = performanceService;
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
	 * Returns the performance master remote service.
	 *
	 * @return the performance master remote service
	 */
	public com.liferay.famocom.erpcloud.service.PerformanceMasterService getPerformanceMasterService() {
		return performanceMasterService;
	}

	/**
	 * Sets the performance master remote service.
	 *
	 * @param performanceMasterService the performance master remote service
	 */
	public void setPerformanceMasterService(
		com.liferay.famocom.erpcloud.service.PerformanceMasterService performanceMasterService) {
		this.performanceMasterService = performanceMasterService;
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
	 * Returns the push notification remote service.
	 *
	 * @return the push notification remote service
	 */
	public com.liferay.famocom.erpcloud.service.PushNotificationService getPushNotificationService() {
		return pushNotificationService;
	}

	/**
	 * Sets the push notification remote service.
	 *
	 * @param pushNotificationService the push notification remote service
	 */
	public void setPushNotificationService(
		com.liferay.famocom.erpcloud.service.PushNotificationService pushNotificationService) {
		this.pushNotificationService = pushNotificationService;
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
	 * Returns the rating master remote service.
	 *
	 * @return the rating master remote service
	 */
	public com.liferay.famocom.erpcloud.service.RatingMasterService getRatingMasterService() {
		return ratingMasterService;
	}

	/**
	 * Sets the rating master remote service.
	 *
	 * @param ratingMasterService the rating master remote service
	 */
	public void setRatingMasterService(
		com.liferay.famocom.erpcloud.service.RatingMasterService ratingMasterService) {
		this.ratingMasterService = ratingMasterService;
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
	 * Returns the recruitment process remote service.
	 *
	 * @return the recruitment process remote service
	 */
	public com.liferay.famocom.erpcloud.service.RecruitmentProcessService getRecruitmentProcessService() {
		return recruitmentProcessService;
	}

	/**
	 * Sets the recruitment process remote service.
	 *
	 * @param recruitmentProcessService the recruitment process remote service
	 */
	public void setRecruitmentProcessService(
		com.liferay.famocom.erpcloud.service.RecruitmentProcessService recruitmentProcessService) {
		this.recruitmentProcessService = recruitmentProcessService;
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
	 * Returns the sal details remote service.
	 *
	 * @return the sal details remote service
	 */
	public com.liferay.famocom.erpcloud.service.SalDetailsService getSalDetailsService() {
		return salDetailsService;
	}

	/**
	 * Sets the sal details remote service.
	 *
	 * @param salDetailsService the sal details remote service
	 */
	public void setSalDetailsService(
		com.liferay.famocom.erpcloud.service.SalDetailsService salDetailsService) {
		this.salDetailsService = salDetailsService;
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
	 * Returns the selected candidate pay structure remote service.
	 *
	 * @return the selected candidate pay structure remote service
	 */
	public com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureService getSelectedCandidatePayStructureService() {
		return selectedCandidatePayStructureService;
	}

	/**
	 * Sets the selected candidate pay structure remote service.
	 *
	 * @param selectedCandidatePayStructureService the selected candidate pay structure remote service
	 */
	public void setSelectedCandidatePayStructureService(
		com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureService selectedCandidatePayStructureService) {
		this.selectedCandidatePayStructureService = selectedCandidatePayStructureService;
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
	 * Returns the stop pay remote service.
	 *
	 * @return the stop pay remote service
	 */
	public com.liferay.famocom.erpcloud.service.StopPayService getStopPayService() {
		return stopPayService;
	}

	/**
	 * Sets the stop pay remote service.
	 *
	 * @param stopPayService the stop pay remote service
	 */
	public void setStopPayService(
		com.liferay.famocom.erpcloud.service.StopPayService stopPayService) {
		this.stopPayService = stopPayService;
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
	 * Returns the task master remote service.
	 *
	 * @return the task master remote service
	 */
	public com.liferay.famocom.erpcloud.service.TaskMasterService getTaskMasterService() {
		return taskMasterService;
	}

	/**
	 * Sets the task master remote service.
	 *
	 * @param taskMasterService the task master remote service
	 */
	public void setTaskMasterService(
		com.liferay.famocom.erpcloud.service.TaskMasterService taskMasterService) {
		this.taskMasterService = taskMasterService;
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
	 * Returns the task master mapping remote service.
	 *
	 * @return the task master mapping remote service
	 */
	public com.liferay.famocom.erpcloud.service.TaskMasterMappingService getTaskMasterMappingService() {
		return taskMasterMappingService;
	}

	/**
	 * Sets the task master mapping remote service.
	 *
	 * @param taskMasterMappingService the task master mapping remote service
	 */
	public void setTaskMasterMappingService(
		com.liferay.famocom.erpcloud.service.TaskMasterMappingService taskMasterMappingService) {
		this.taskMasterMappingService = taskMasterMappingService;
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
	 * Returns the tax declaration monthly remote service.
	 *
	 * @return the tax declaration monthly remote service
	 */
	public com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyService getTaxDeclarationMonthlyService() {
		return taxDeclarationMonthlyService;
	}

	/**
	 * Sets the tax declaration monthly remote service.
	 *
	 * @param taxDeclarationMonthlyService the tax declaration monthly remote service
	 */
	public void setTaxDeclarationMonthlyService(
		com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyService taxDeclarationMonthlyService) {
		this.taxDeclarationMonthlyService = taxDeclarationMonthlyService;
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
	 * Returns the tax proof files remote service.
	 *
	 * @return the tax proof files remote service
	 */
	public com.liferay.famocom.erpcloud.service.TaxProofFilesService getTaxProofFilesService() {
		return taxProofFilesService;
	}

	/**
	 * Sets the tax proof files remote service.
	 *
	 * @param taxProofFilesService the tax proof files remote service
	 */
	public void setTaxProofFilesService(
		com.liferay.famocom.erpcloud.service.TaxProofFilesService taxProofFilesService) {
		this.taxProofFilesService = taxProofFilesService;
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
	 * Returns the time sheet master remote service.
	 *
	 * @return the time sheet master remote service
	 */
	public com.liferay.famocom.erpcloud.service.TimeSheetMasterService getTimeSheetMasterService() {
		return timeSheetMasterService;
	}

	/**
	 * Sets the time sheet master remote service.
	 *
	 * @param timeSheetMasterService the time sheet master remote service
	 */
	public void setTimeSheetMasterService(
		com.liferay.famocom.erpcloud.service.TimeSheetMasterService timeSheetMasterService) {
		this.timeSheetMasterService = timeSheetMasterService;
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
	 * Returns the year setting remote service.
	 *
	 * @return the year setting remote service
	 */
	public com.liferay.famocom.erpcloud.service.YearSettingService getYearSettingService() {
		return yearSettingService;
	}

	/**
	 * Sets the year setting remote service.
	 *
	 * @param yearSettingService the year setting remote service
	 */
	public void setYearSettingService(
		com.liferay.famocom.erpcloud.service.YearSettingService yearSettingService) {
		this.yearSettingService = yearSettingService;
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
		return BookingRoomService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BookingRoom.class;
	}

	protected String getModelClassName() {
		return BookingRoom.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = bookingRoomPersistence.getDataSource();

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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceCheckListLocalService attendanceCheckListLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.AttendanceCheckListService.class)
	protected com.liferay.famocom.erpcloud.service.AttendanceCheckListService attendanceCheckListService;
	@BeanReference(type = AttendanceCheckListPersistence.class)
	protected AttendanceCheckListPersistence attendanceCheckListPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BankMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BankMasterLocalService bankMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BankMasterService.class)
	protected com.liferay.famocom.erpcloud.service.BankMasterService bankMasterService;
	@BeanReference(type = BankMasterPersistence.class)
	protected BankMasterPersistence bankMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BillDocumentUploadFileLocalService billDocumentUploadFileLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillDocumentUploadFileService.class)
	protected com.liferay.famocom.erpcloud.service.BillDocumentUploadFileService billDocumentUploadFileService;
	@BeanReference(type = BillDocumentUploadFilePersistence.class)
	protected BillDocumentUploadFilePersistence billDocumentUploadFilePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BillingLocalService billingLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BillingService.class)
	protected com.liferay.famocom.erpcloud.service.BillingService billingService;
	@BeanReference(type = BillingPersistence.class)
	protected BillingPersistence billingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BookingRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BookingRoomLocalService bookingRoomLocalService;
	@BeanReference(type = BookingRoomService.class)
	protected BookingRoomService bookingRoomService;
	@BeanReference(type = BookingRoomPersistence.class)
	protected BookingRoomPersistence bookingRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchLocalService.class)
	protected com.liferay.famocom.erpcloud.service.BranchLocalService branchLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.BranchService.class)
	protected com.liferay.famocom.erpcloud.service.BranchService branchService;
	@BeanReference(type = BranchPersistence.class)
	protected BranchPersistence branchPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateApplyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateApplyLocalService candidateApplyLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateApplyService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateApplyService candidateApplyService;
	@BeanReference(type = CandidateApplyPersistence.class)
	protected CandidateApplyPersistence candidateApplyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateEvaluationLocalService candidateEvaluationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateEvaluationService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateEvaluationService candidateEvaluationService;
	@BeanReference(type = CandidateEvaluationPersistence.class)
	protected CandidateEvaluationPersistence candidateEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterLocalService candidatePayStructureMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterService.class)
	protected com.liferay.famocom.erpcloud.service.CandidatePayStructureMasterService candidatePayStructureMasterService;
	@BeanReference(type = CandidatePayStructureMasterPersistence.class)
	protected CandidatePayStructureMasterPersistence candidatePayStructureMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateReviewLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateReviewLocalService candidateReviewLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CandidateReviewService.class)
	protected com.liferay.famocom.erpcloud.service.CandidateReviewService candidateReviewService;
	@BeanReference(type = CandidateReviewPersistence.class)
	protected CandidateReviewPersistence candidateReviewPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterLocalService clientMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ClientMasterService.class)
	protected com.liferay.famocom.erpcloud.service.ClientMasterService clientMasterService;
	@BeanReference(type = ClientMasterPersistence.class)
	protected ClientMasterPersistence clientMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.CompanyPolicyLocalService companyPolicyLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.CompanyPolicyService.class)
	protected com.liferay.famocom.erpcloud.service.CompanyPolicyService companyPolicyService;
	@BeanReference(type = CompanyPolicyPersistence.class)
	protected CompanyPolicyPersistence companyPolicyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomLocalService conferenceRoomLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ConferenceRoomService.class)
	protected com.liferay.famocom.erpcloud.service.ConferenceRoomService conferenceRoomService;
	@BeanReference(type = ConferenceRoomPersistence.class)
	protected ConferenceRoomPersistence conferenceRoomPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.DocumentUploadFileLocalService documentUploadFileLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.DocumentUploadFileService.class)
	protected com.liferay.famocom.erpcloud.service.DocumentUploadFileService documentUploadFileService;
	@BeanReference(type = DocumentUploadFilePersistence.class)
	protected DocumentUploadFilePersistence documentUploadFilePersistence;
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
	@BeanReference(type = EmployeeFinder.class)
	protected EmployeeFinder employeeFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadLocalService employeeDocumentUploadLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeDocumentUploadService employeeDocumentUploadService;
	@BeanReference(type = EmployeeDocumentUploadPersistence.class)
	protected EmployeeDocumentUploadPersistence employeeDocumentUploadPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeLocalService employeeTypeLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmployeeTypeService.class)
	protected com.liferay.famocom.erpcloud.service.EmployeeTypeService employeeTypeService;
	@BeanReference(type = EmployeeTypePersistence.class)
	protected EmployeeTypePersistence employeeTypePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService.class)
	protected com.liferay.famocom.erpcloud.service.EmpPayStructureLocalService empPayStructureLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.EmpPayStructureService.class)
	protected com.liferay.famocom.erpcloud.service.EmpPayStructureService empPayStructureService;
	@BeanReference(type = EmpPayStructurePersistence.class)
	protected EmpPayStructurePersistence empPayStructurePersistence;
	@BeanReference(type = EmpPayStructureFinder.class)
	protected EmpPayStructureFinder empPayStructureFinder;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryLocalService expenseEntryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryService expenseEntryService;
	@BeanReference(type = ExpenseEntryPersistence.class)
	protected ExpenseEntryPersistence expenseEntryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryLocalService expenseEntryHistoryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService.class)
	protected com.liferay.famocom.erpcloud.service.ExpenseEntryHistoryService expenseEntryHistoryService;
	@BeanReference(type = ExpenseEntryHistoryPersistence.class)
	protected ExpenseEntryHistoryPersistence expenseEntryHistoryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.ExpProofFilesLocalService expProofFilesLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.ExpProofFilesService.class)
	protected com.liferay.famocom.erpcloud.service.ExpProofFilesService expProofFilesService;
	@BeanReference(type = ExpProofFilesPersistence.class)
	protected ExpProofFilesPersistence expProofFilesPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FinSalaryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FinSalaryLocalService finSalaryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FinSalaryService.class)
	protected com.liferay.famocom.erpcloud.service.FinSalaryService finSalaryService;
	@BeanReference(type = FinSalaryPersistence.class)
	protected FinSalaryPersistence finSalaryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenLocalService formSixteenLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenService formSixteenService;
	@BeanReference(type = FormSixteenPersistence.class)
	protected FormSixteenPersistence formSixteenPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenErrorFileLocalService formSixteenErrorFileLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.FormSixteenErrorFileService.class)
	protected com.liferay.famocom.erpcloud.service.FormSixteenErrorFileService formSixteenErrorFileService;
	@BeanReference(type = FormSixteenErrorFilePersistence.class)
	protected FormSixteenErrorFilePersistence formSixteenErrorFilePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceLocalService geoAttendanceLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GeoAttendanceService.class)
	protected com.liferay.famocom.erpcloud.service.GeoAttendanceService geoAttendanceService;
	@BeanReference(type = GeoAttendancePersistence.class)
	protected GeoAttendancePersistence geoAttendancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GoalDetailsLocalService goalDetailsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalDetailsService.class)
	protected com.liferay.famocom.erpcloud.service.GoalDetailsService goalDetailsService;
	@BeanReference(type = GoalDetailsPersistence.class)
	protected GoalDetailsPersistence goalDetailsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.GoalMasterLocalService goalMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.GoalMasterService.class)
	protected com.liferay.famocom.erpcloud.service.GoalMasterService goalMasterService;
	@BeanReference(type = GoalMasterPersistence.class)
	protected GoalMasterPersistence goalMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementLocalService holidayCalenderManagementLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService.class)
	protected com.liferay.famocom.erpcloud.service.HolidayCalenderManagementService holidayCalenderManagementService;
	@BeanReference(type = HolidayCalenderManagementPersistence.class)
	protected HolidayCalenderManagementPersistence holidayCalenderManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService.class)
	protected com.liferay.famocom.erpcloud.service.IncomeTaxSlabLocalService incomeTaxSlabLocalService;
	@BeanReference(type = IncomeTaxSlabPersistence.class)
	protected IncomeTaxSlabPersistence incomeTaxSlabPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationLocalService interviewEvaluationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.InterviewEvaluationService.class)
	protected com.liferay.famocom.erpcloud.service.InterviewEvaluationService interviewEvaluationService;
	@BeanReference(type = InterviewEvaluationPersistence.class)
	protected InterviewEvaluationPersistence interviewEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobEvaluationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobEvaluationLocalService jobEvaluationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobEvaluationService.class)
	protected com.liferay.famocom.erpcloud.service.JobEvaluationService jobEvaluationService;
	@BeanReference(type = JobEvaluationPersistence.class)
	protected JobEvaluationPersistence jobEvaluationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobOpeningLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobOpeningLocalService jobOpeningLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobOpeningService.class)
	protected com.liferay.famocom.erpcloud.service.JobOpeningService jobOpeningService;
	@BeanReference(type = JobOpeningPersistence.class)
	protected JobOpeningPersistence jobOpeningPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobPostLocalService.class)
	protected com.liferay.famocom.erpcloud.service.JobPostLocalService jobPostLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.JobPostService.class)
	protected com.liferay.famocom.erpcloud.service.JobPostService jobPostService;
	@BeanReference(type = JobPostPersistence.class)
	protected JobPostPersistence jobPostPersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveDocLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveDocLocalService leaveDocLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveDocService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveDocService leaveDocService;
	@BeanReference(type = LeaveDocPersistence.class)
	protected LeaveDocPersistence leaveDocPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementLocalService leaveManagementLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveManagementService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveManagementService leaveManagementService;
	@BeanReference(type = LeaveManagementPersistence.class)
	protected LeaveManagementPersistence leaveManagementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveObLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveObLocalService leaveObLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveObService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveObService leaveObService;
	@BeanReference(type = LeaveObPersistence.class)
	protected LeaveObPersistence leaveObPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveTypeLocalService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveTypeLocalService leaveTypeLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.LeaveTypeService.class)
	protected com.liferay.famocom.erpcloud.service.LeaveTypeService leaveTypeService;
	@BeanReference(type = LeaveTypePersistence.class)
	protected LeaveTypePersistence leaveTypePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MilestoneLocalService.class)
	protected com.liferay.famocom.erpcloud.service.MilestoneLocalService milestoneLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MilestoneService.class)
	protected com.liferay.famocom.erpcloud.service.MilestoneService milestoneService;
	@BeanReference(type = MilestonePersistence.class)
	protected MilestonePersistence milestonePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService.class)
	protected com.liferay.famocom.erpcloud.service.MonthlyAdjustmentLocalService monthlyAdjustmentLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.MonthlyAdjustmentService.class)
	protected com.liferay.famocom.erpcloud.service.MonthlyAdjustmentService monthlyAdjustmentService;
	@BeanReference(type = MonthlyAdjustmentPersistence.class)
	protected MonthlyAdjustmentPersistence monthlyAdjustmentPersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayComponentLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayComponentLocalService payComponentLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayComponentService.class)
	protected com.liferay.famocom.erpcloud.service.PayComponentService payComponentService;
	@BeanReference(type = PayComponentPersistence.class)
	protected PayComponentPersistence payComponentPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollIncrementLocalService payrollIncrementLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollIncrementService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollIncrementService payrollIncrementService;
	@BeanReference(type = PayrollIncrementPersistence.class)
	protected PayrollIncrementPersistence payrollIncrementPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollSlabsLocalService payrollSlabsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PayrollSlabsService.class)
	protected com.liferay.famocom.erpcloud.service.PayrollSlabsService payrollSlabsService;
	@BeanReference(type = PayrollSlabsPersistence.class)
	protected PayrollSlabsPersistence payrollSlabsPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceLocalService performanceLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceService performanceService;
	@BeanReference(type = PerformancePersistence.class)
	protected PerformancePersistence performancePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceMasterLocalService performanceMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PerformanceMasterService.class)
	protected com.liferay.famocom.erpcloud.service.PerformanceMasterService performanceMasterService;
	@BeanReference(type = PerformanceMasterPersistence.class)
	protected PerformanceMasterPersistence performanceMasterPersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PushNotificationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.PushNotificationLocalService pushNotificationLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.PushNotificationService.class)
	protected com.liferay.famocom.erpcloud.service.PushNotificationService pushNotificationService;
	@BeanReference(type = PushNotificationPersistence.class)
	protected PushNotificationPersistence pushNotificationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RatingMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RatingMasterLocalService ratingMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RatingMasterService.class)
	protected com.liferay.famocom.erpcloud.service.RatingMasterService ratingMasterService;
	@BeanReference(type = RatingMasterPersistence.class)
	protected RatingMasterPersistence ratingMasterPersistence;
	@BeanReference(type = RatingMasterFinder.class)
	protected RatingMasterFinder ratingMasterFinder;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitmentProcessLocalService recruitmentProcessLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.RecruitmentProcessService.class)
	protected com.liferay.famocom.erpcloud.service.RecruitmentProcessService recruitmentProcessService;
	@BeanReference(type = RecruitmentProcessPersistence.class)
	protected RecruitmentProcessPersistence recruitmentProcessPersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SalDetailsLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SalDetailsLocalService salDetailsLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SalDetailsService.class)
	protected com.liferay.famocom.erpcloud.service.SalDetailsService salDetailsService;
	@BeanReference(type = SalDetailsPersistence.class)
	protected SalDetailsPersistence salDetailsPersistence;
	@BeanReference(type = SalDetailsFinder.class)
	protected SalDetailsFinder salDetailsFinder;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureLocalService selectedCandidatePayStructureLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureService.class)
	protected com.liferay.famocom.erpcloud.service.SelectedCandidatePayStructureService selectedCandidatePayStructureService;
	@BeanReference(type = SelectedCandidatePayStructurePersistence.class)
	protected SelectedCandidatePayStructurePersistence selectedCandidatePayStructurePersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetLocalService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetLocalService skillSetLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.SkillSetService.class)
	protected com.liferay.famocom.erpcloud.service.SkillSetService skillSetService;
	@BeanReference(type = SkillSetPersistence.class)
	protected SkillSetPersistence skillSetPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.StopPayLocalService.class)
	protected com.liferay.famocom.erpcloud.service.StopPayLocalService stopPayLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.StopPayService.class)
	protected com.liferay.famocom.erpcloud.service.StopPayService stopPayService;
	@BeanReference(type = StopPayPersistence.class)
	protected StopPayPersistence stopPayPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterLocalService taskMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterService taskMasterService;
	@BeanReference(type = TaskMasterPersistence.class)
	protected TaskMasterPersistence taskMasterPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterMappingLocalService taskMasterMappingLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaskMasterMappingService.class)
	protected com.liferay.famocom.erpcloud.service.TaskMasterMappingService taskMasterMappingService;
	@BeanReference(type = TaskMasterMappingPersistence.class)
	protected TaskMasterMappingPersistence taskMasterMappingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxDeclarationLocalService taxDeclarationLocalService;
	@BeanReference(type = TaxDeclarationPersistence.class)
	protected TaxDeclarationPersistence taxDeclarationPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyLocalService taxDeclarationMonthlyLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyService.class)
	protected com.liferay.famocom.erpcloud.service.TaxDeclarationMonthlyService taxDeclarationMonthlyService;
	@BeanReference(type = TaxDeclarationMonthlyPersistence.class)
	protected TaxDeclarationMonthlyPersistence taxDeclarationMonthlyPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxProofFilesLocalService taxProofFilesLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxProofFilesService.class)
	protected com.liferay.famocom.erpcloud.service.TaxProofFilesService taxProofFilesService;
	@BeanReference(type = TaxProofFilesPersistence.class)
	protected TaxProofFilesPersistence taxProofFilesPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TaxSettingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TaxSettingLocalService taxSettingLocalService;
	@BeanReference(type = TaxSettingPersistence.class)
	protected TaxSettingPersistence taxSettingPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryLocalService timeSheetEntryLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetEntryService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetEntryService timeSheetEntryService;
	@BeanReference(type = TimeSheetEntryPersistence.class)
	protected TimeSheetEntryPersistence timeSheetEntryPersistence;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetMasterLocalService timeSheetMasterLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.TimeSheetMasterService.class)
	protected com.liferay.famocom.erpcloud.service.TimeSheetMasterService timeSheetMasterService;
	@BeanReference(type = TimeSheetMasterPersistence.class)
	protected TimeSheetMasterPersistence timeSheetMasterPersistence;
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
	@BeanReference(type = com.liferay.famocom.erpcloud.service.YearSettingLocalService.class)
	protected com.liferay.famocom.erpcloud.service.YearSettingLocalService yearSettingLocalService;
	@BeanReference(type = com.liferay.famocom.erpcloud.service.YearSettingService.class)
	protected com.liferay.famocom.erpcloud.service.YearSettingService yearSettingService;
	@BeanReference(type = YearSettingPersistence.class)
	protected YearSettingPersistence yearSettingPersistence;
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