create index IX_82D041A1 on CandidateReview (recruitProcessId);

create index IX_B6D619B on Expense (employeeId);

create index IX_D6A0AB9B on FormSixteen (employeeId, financialYear[$COLUMN_LENGTH:75$]);

create index IX_EACF1C09 on JobEvaluation (jobPostId);

create index IX_EDB8C31D on MonthlyAdjustment (employeeId);
create index IX_A390D08E on MonthlyAdjustment (monthYear, employeeId, payComponentId);

create index IX_16447DEB on PayComponent (abbreviation[$COLUMN_LENGTH:75$], componentId);
create index IX_686D600E on PayComponent (name[$COLUMN_LENGTH:75$], componentId);
create index IX_D21812CE on PayComponent (payComponentOrder);
create index IX_FE4DDD37 on PayComponent (payType[$COLUMN_LENGTH:75$]);
create index IX_8B9E89C0 on PayComponent (taxStatus, payType[$COLUMN_LENGTH:75$]);

create index IX_C991E314 on RecruitProcess (employeeId);

create index IX_448FAE57 on RecruitmentProcess (groupId, status);

create index IX_5CD3CD3B on SchedulesDetails (employeeId, companyId, schedulesDate);
create index IX_51D712B1 on SchedulesDetails (employeeId, schedulesDate);
create index IX_2153DB15 on SchedulesDetails (worksSchedulesId);

create index IX_50F009CF on SelectedCandidatePayStructure (recruitmentProcessId, payStatus);

create index IX_CEA7100F on SelectedCandidatePayStructureMaster (recruitmentProcessId, payMasterStatus);

create index IX_6FCF59A4 on StopPay (employeeId, monthYear);
create index IX_BE837247 on StopPay (monthYear, status);

create index IX_AEAA4F16 on TravelDesk (employeeId);
create index IX_D92D1B2B on TravelDesk (projectId);

create index IX_4FDB5EBD on YearSetting (isActive);

create index IX_896AB90D on addTeamMember (employeeId, companyId);
create index IX_4D5FF0D on addTeamMember (employeeId, isProjectManager);
create index IX_6FB319A9 on addTeamMember (employeeId, projectId);
create index IX_201690B0 on addTeamMember (isProjectManager);
create index IX_9A420DD5 on addTeamMember (projectId, employeeId, isProjectManager);

create index IX_20581945 on appraisalGoalDetails (appraisalId, employeeId, projectId, evaluationId, goaldetailId);

create index IX_13D761C2 on appraisalGoalMaster (appraisalId, employeeId, projectId, evaluationId);

create index IX_DBC5EE64 on appraisalMaster (appraisalSettingId, employeeId);
create index IX_9145A63F on appraisalMaster (appraisalSettingId, submitStep);

create index IX_CBF17845 on appraisalPerformance (appraisalId, appraisalSettingId, employeeId, performanceId);

create index IX_FB7C2CFD on appraisalProjectMaster (appraisalSettingId, employeeId, appraisalId);
create index IX_C77409F1 on appraisalProjectMaster (appraisalSettingId, employeeId, projectId);
create index IX_50EBC126 on appraisalProjectMaster (appraisalSettingId, projectId, submitStep);

create index IX_6C82213C on appraisalSetup (financialYear[$COLUMN_LENGTH:75$], isActive);
create index IX_F824D6A2 on appraisalSetup (isActive);

create index IX_CCCD5853 on attendance (employeeId, attDate);
create index IX_61095AC3 on attendance (employeeId, companyId, attDate);

create index IX_1C0F27B9 on attendanceBio (employeeId, companyId, attDate);

create index IX_D4BD72B4 on candidatePayStructureMaster (recruitmentProcessId, payMasterStatus);

create index IX_C4F01704 on emailTemplates (emailFor[$COLUMN_LENGTH:75$]);

create index IX_5788F35A on empPayStructure (employeeId, payComponentId);
create index IX_B316F75A on empPayStructure (payComponentId, employeeId);

create index IX_9C8AA4E3 on employee (employeeCode);
create index IX_E61DA545 on employee (employeeStatus, employeeId);
create index IX_B433B91C on employee (groupId, status);
create index IX_94A51B2E on employee (userId);

create index IX_6D38E76D on expProofFiles (expenseId);

create index IX_28A37D50 on expenseEntry (groupId, status);
create index IX_F1020C7A on expenseEntry (userId);

create index IX_A521503 on expenseEntryHistory (expenseId);

create index IX_C9946CE7 on finalSalary (monthYear);

create index IX_EB8F3702 on geoAttendance (employeeId, attDate);

create index IX_2444D637 on goalDetails (goalId);

create index IX_C6BF3988 on holidayCalenderManagement (holidayDate, holidayId);
create index IX_7861FDCB on holidayCalenderManagement (holidayName[$COLUMN_LENGTH:75$], holidayId);

create index IX_4DBAE233 on leaveApply (groupId, status);
create index IX_C2B20C37 on leaveApply (userId);

create index IX_2B4D3926 on leaveApplyDtl (employeeId, leaveDate, isApprove);
create index IX_CC70B2AA on leaveApplyDtl (leaveDate);

create index IX_292FD72 on leaveManagement (leaveName[$COLUMN_LENGTH:75$]);

create index IX_74A7A10F on leaveOb (employeeId, leaveTypeId);

create index IX_8249A9B on leaveType (leaveName[$COLUMN_LENGTH:75$]);

create index IX_24814AF on notificationSendManage (branchId);
create index IX_B7163389 on notificationSendManage (notificationId, branchId);

create index IX_9ED5A882 on payDetails (employeeId, componentId, monthYear);
create index IX_3009EA58 on payDetails (employeeId, monthYear, componentId);
create index IX_6C64DEAA on payDetails (monthYear, employeeId);

create index IX_B91D626F on payrollIncrement (employeeId, appraisalSettingId, financialYear[$COLUMN_LENGTH:75$]);
create index IX_98D67D9B on payrollIncrement (employeeId, componentId, financialYear[$COLUMN_LENGTH:75$]);

create index IX_96D7DBC0 on payrollSlabs (appraisalSettingId, ratingId);

create index IX_BEA7C66A on projectMaster (employeeId, companyId);

create index IX_8E019F64 on taxDeclaration (employeeId, financialYear[$COLUMN_LENGTH:75$]);

create index IX_D955B98C on taxDeclarationMonthly (employeeId, monthYear);
create index IX_E00F3366 on taxDeclarationMonthly (monthYear, employeeId);

create index IX_DC40DC5D on taxSetting (componentId);

create index IX_6A22F98A on timeSheetEntry (groupId, status);

create index IX_B5068676 on timeSheetMaster (groupId, status);

create index IX_B3E5E09 on worksSchedules (fromDate, toDate);
create index IX_CB0D00C7 on worksSchedules (schedulesId);
create index IX_E1EDE9D on worksSchedules (toDate);