create table AttendanceCheckList (
	attendanceCheckListId LONG not null primary key,
	attDate DATE null,
	employeeCode LONG,
	fullName VARCHAR(75) null,
	inTimeHour VARCHAR(75) null,
	inTimeMin VARCHAR(75) null,
	outTimeHour VARCHAR(75) null,
	outTimeMin VARCHAR(75) null,
	status VARCHAR(75) null,
	msg VARCHAR(75) null,
	indexNumber INTEGER,
	pcDateAndTime DATE null
);

create table BookingRoom (
	bookingId LONG not null primary key,
	roomId LONG,
	bookingDate DATE null,
	fromTime VARCHAR(75) null,
	toTime VARCHAR(75) null,
	bookedBy LONG,
	note VARCHAR(75) null
);

create table CandidateApply (
	applyCandidateId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	yearOfExp INTEGER,
	monthOfExp INTEGER,
	currentCTC INTEGER,
	expectedCTC INTEGER,
	currentCompany VARCHAR(75) null,
	noticePeriod INTEGER,
	referenceEmployeeId LONG,
	cvFileId LONG,
	jobOpeningId LONG,
	skillset VARCHAR(75) null,
	status INTEGER
);

create table CandidateEvaluation (
	candidateEvaluationId LONG not null primary key,
	interviewerId LONG,
	jobPostId LONG,
	postEvaluationId LONG,
	applyCandidateId LONG,
	interviewerRating INTEGER,
	interviewerRemarks VARCHAR(75) null,
	hrRemarks VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	recruitmentProcessId LONG
);

create table CandidateReview (
	candidateReviewId LONG not null primary key,
	recruitProcessId LONG,
	evaluationId LONG,
	scroring VARCHAR(75) null
);

create table ConferenceRoom (
	roomId LONG not null primary key,
	roomNo LONG,
	floorNo LONG,
	capacity LONG,
	openTime VARCHAR(75) null,
	closeTime VARCHAR(75) null,
	building VARCHAR(75) null
);

create table Expense (
	expenseId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	projectId LONG,
	catId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	expDate DATE null,
	amount DOUBLE,
	status INTEGER,
	manEmployeeId LONG,
	manCommnets VARCHAR(75) null,
	manApprovedDate DATE null,
	accComments VARCHAR(75) null,
	accApprovedDate DATE null,
	monthYear LONG
);

create table FormSixteen (
	id_ LONG not null primary key,
	employeeId LONG,
	financialYear VARCHAR(75) null,
	fileEnteryId LONG,
	addedDate DATE null
);

create table FormSixteenErrorFile (
	errorId LONG not null primary key,
	fileName VARCHAR(75) null,
	errorMsg VARCHAR(75) null
);

create table JobEvaluation (
	postEvaluationId LONG not null primary key,
	jobPostId LONG,
	evaluationName VARCHAR(75) null,
	evaluationDescription VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table JobOpening (
	jobOpeningId LONG not null primary key,
	jobPostId LONG,
	openingFor VARCHAR(75) null,
	description VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table JobPost (
	jobPostId LONG not null primary key,
	postName VARCHAR(75) null,
	postDescription VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table LeaveDoc (
	leaveDocId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	leaveApplyId LONG,
	fileEntryId LONG,
	filePath VARCHAR(75) null,
	addedDate DATE null
);

create table Milestone (
	milestoneId LONG not null primary key,
	projectId LONG,
	clientId LONG,
	milestoneName VARCHAR(75) null,
	dueDate DATE null,
	checkGST INTEGER,
	amount DOUBLE,
	status INTEGER
);

create table MonthlyAdjustment (
	monthlyAdjustmentId LONG not null primary key,
	payComponentId LONG,
	amount DOUBLE,
	monthYear LONG,
	employeeId LONG
);

create table PayComponent (
	componentId LONG not null primary key,
	employeeTypeId LONG,
	name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	taxStatus INTEGER,
	payType VARCHAR(75) null,
	componentType INTEGER,
	componentValueFormula VARCHAR(75) null,
	partOfCtc INTEGER,
	effectiveDate DATE null,
	islock LONG,
	createDate DATE null,
	modifiedDate DATE null,
	amount DOUBLE,
	payComponentOrder LONG,
	autoAddPayStructure INTEGER
);

create table ProjectTask (
	projectTaskId LONG not null primary key,
	projectId LONG,
	employeeId LONG,
	taskId LONG,
	taskName VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	hours DOUBLE,
	addedDate DATE null
);

create table RecruitProcess (
	recruitProcessId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	employeeId LONG,
	interviewDate DATE null,
	interviewTime VARCHAR(75) null,
	fileEntryId LONG,
	fileUrl VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	interviewerRemarks VARCHAR(75) null,
	hrRemarks VARCHAR(75) null,
	isSelected INTEGER,
	status LONG,
	DOB DATE null,
	email VARCHAR(75) null,
	phoneNumber LONG,
	skillset VARCHAR(75) null,
	experience DOUBLE,
	noticePeriod INTEGER,
	currentCTC DOUBLE,
	expextedCTC DOUBLE,
	projectRoleId LONG,
	reference LONG
);

create table RecruitmentProcess (
	recruitmentProcessId LONG not null primary key,
	applyCandidateId LONG,
	interviewDate DATE null,
	interviewTime VARCHAR(75) null,
	fileEntryId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	interviewerRemarks VARCHAR(75) null,
	hrRemarks VARCHAR(75) null,
	isSelected BOOLEAN,
	interviewerId LONG,
	createdBy LONG,
	jobPostId LONG,
	groupId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	userId LONG
);

create table Resignation (
	ResignationId LONG not null primary key,
	employeeId LONG,
	resignationDate DATE null,
	resignationSubDate DATE null,
	Description VARCHAR(75) null,
	managerId LONG,
	mancomment VARCHAR(75) null,
	mancommentdate DATE null,
	status BOOLEAN
);

create table SchedulesDetails (
	schedulesDetailsId LONG not null primary key,
	schedulesDate DATE null,
	worksSchedulesId LONG,
	employeeId LONG,
	companyId LONG
);

create table SchedulesMaster (
	schedulesId LONG not null primary key,
	schedulesName VARCHAR(75) null,
	schedulesDescription VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table SelectedCandidatePayStructure (
	candidatePayStructureId LONG not null primary key,
	payComponentId LONG,
	componentValue DOUBLE,
	recruitmentProcessId LONG,
	payStatus INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table SelectedCandidatePayStructureMaster (
	candidatePayStructureMasterId LONG not null primary key,
	recruitmentProcessId LONG,
	totalAmount DOUBLE,
	totalBonus DOUBLE,
	payMasterStatus INTEGER,
	joiningDate DATE null,
	candidateBond VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table SkillSet (
	SkillId LONG not null primary key,
	SkillName VARCHAR(75) null
);

create table StopPay (
	stopPayId LONG not null primary key,
	monthYear LONG,
	employeeId LONG,
	reason VARCHAR(75) null,
	createdBy LONG,
	createdDate DATE null,
	modifiedDate DATE null,
	modifiedBy LONG,
	status LONG,
	isLock LONG
);

create table TravelDesk (
	travelDetailsId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	userId LONG,
	projectId LONG,
	projectTeamsId LONG,
	ticketType VARCHAR(75) null,
	hotel BOOLEAN,
	fromDate DATE null,
	toDate DATE null,
	fromTime VARCHAR(75) null,
	toTime VARCHAR(75) null,
	location VARCHAR(75) null,
	purpose VARCHAR(75) null,
	specialInstraction VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	managerComment VARCHAR(75) null
);

create table YearSetting (
	yearSettingId LONG not null primary key,
	financialYearStartDate DATE null,
	financialYearEndDate DATE null,
	calendarStartDate DATE null,
	calendarEndDate DATE null,
	isActive INTEGER
);

create table addTeamMember (
	projectTeamsId LONG not null primary key,
	employeeId LONG,
	projectId LONG,
	companyId LONG,
	roleId LONG,
	addedDate DATE null,
	isProjectManager BOOLEAN
);

create table appraisalGoalDetails (
	appraisalGoalDetailsId LONG not null primary key,
	appraisalGoalMasterId LONG,
	companyId LONG,
	appraisalId LONG,
	employeeId LONG,
	projectId LONG,
	evaluationId LONG,
	goaldetailId LONG,
	ratingIdEmp LONG,
	ratingIdMan LONG,
	createdDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table appraisalGoalMaster (
	appraisalGoalMasterId LONG not null primary key,
	companyId LONG,
	appraisalId LONG,
	appraisalProjectId LONG,
	employeeId LONG,
	projectId LONG,
	evaluationId LONG,
	employeeComment VARCHAR(75) null,
	employeeOverallRat LONG,
	managerComment VARCHAR(75) null,
	managerOverallRat LONG,
	createdDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table appraisalMaster (
	appraisalId LONG not null primary key,
	companyId LONG,
	appraisalSettingId LONG,
	employeeId LONG,
	accomplishmentsEmp VARCHAR(75) null,
	strengthsEmp VARCHAR(75) null,
	developmentEmp VARCHAR(75) null,
	careerEmp VARCHAR(75) null,
	overallRatingEmp LONG,
	overallCommentEmp VARCHAR(75) null,
	accomplishmentsMan VARCHAR(75) null,
	strengthsMan VARCHAR(75) null,
	developmentMan VARCHAR(75) null,
	careerMan VARCHAR(75) null,
	companyValue VARCHAR(75) null,
	developmentPlan VARCHAR(75) null,
	overallRatingMan LONG,
	overallCommentMan VARCHAR(75) null,
	submitStep LONG,
	addedDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table appraisalPerformance (
	appraisalPerformanceId LONG not null primary key,
	companyId LONG,
	appraisalId LONG,
	employeeId LONG,
	appraisalSettingId LONG,
	performanceId LONG,
	performanceComm VARCHAR(75) null,
	ratingIdEmp LONG,
	ratingIdMan LONG,
	createdDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table appraisalProjectMaster (
	appraisalProjectId LONG not null primary key,
	companyId LONG,
	appraisalId LONG,
	appraisalSettingId LONG,
	employeeId LONG,
	projectId LONG,
	projectDescription VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	submitStep LONG,
	addedDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table appraisalSetup (
	appraisalSettingId LONG not null primary key,
	companyId LONG,
	financialYear VARCHAR(75) null,
	fromDateCycle DATE null,
	toDateCycle DATE null,
	fromDateSubmission DATE null,
	toDateSubmission DATE null,
	appraisalPeriod LONG,
	totalEmp LONG,
	beforeCtcAll LONG,
	appraisalEmp LONG,
	beforeCtc LONG,
	afterCtc LONG,
	totalAreas LONG,
	totalBonus LONG,
	totalCtcAfter LONG,
	isLocked LONG,
	isActive LONG,
	employeeType VARCHAR(75) null,
	addedDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG
);

create table attendance (
	attendanceId LONG not null primary key,
	companyId LONG,
	employeeCode LONG,
	employeeId LONG,
	attDate DATE null,
	inTimeHour VARCHAR(75) null,
	inTimeMin VARCHAR(75) null,
	outTimeHour VARCHAR(75) null,
	outTimeMin VARCHAR(75) null,
	inTime VARCHAR(75) null,
	outTime VARCHAR(75) null,
	inDatePc DATE null,
	outDatePc DATE null,
	total VARCHAR(75) null,
	status VARCHAR(75) null,
	ipPc VARCHAR(75) null
);

create table attendanceBio (
	attendanceBioId LONG not null primary key,
	companyId LONG,
	employeeId LONG,
	attDate DATE null,
	attTime VARCHAR(75) null,
	uploadDate DATE null,
	status INTEGER
);

create table bankMaster (
	bankId LONG not null primary key,
	bankName VARCHAR(75) null,
	branchName VARCHAR(75) null,
	address VARCHAR(75) null,
	ifscCode VARCHAR(75) null,
	status INTEGER,
	bankType INTEGER,
	createdBy LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table billDocumentUploadFile (
	documentId LONG not null primary key,
	dlFileEntryId LONG,
	companyId LONG,
	billingId LONG,
	documentName VARCHAR(75) null,
	documentPath VARCHAR(75) null,
	uploadDate DATE null
);

create table billing (
	billingId LONG not null primary key,
	milestoneId LONG,
	billingNumber VARCHAR(75) null,
	billingDate VARCHAR(75) null
);

create table branch (
	branchId LONG not null primary key,
	branchName VARCHAR(75) null,
	branchAddress VARCHAR(75) null,
	status INTEGER,
	modifiedDate DATE null,
	createDate DATE null,
	createdById LONG
);

create table candidatePayStructureMaster (
	candidatePayStructureMasterId LONG not null primary key,
	recruitmentProcessId LONG,
	totalAmount DOUBLE,
	totalBonus DOUBLE,
	payMasterStatus INTEGER,
	joiningDate DATE null,
	candidateBond VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table clientMaster (
	clientId LONG not null primary key,
	clientName VARCHAR(75) null,
	officeAddress VARCHAR(75) null,
	billingAddress VARCHAR(75) null,
	contactNumber INTEGER,
	emailId VARCHAR(75) null,
	contactPerson VARCHAR(75) null,
	skypeId VARCHAR(75) null,
	gstNo LONG,
	panNo VARCHAR(75) null,
	bankName VARCHAR(75) null,
	branchName VARCHAR(75) null,
	bankAccountNumber LONG,
	bankAccountType VARCHAR(75) null,
	ifscCode VARCHAR(75) null,
	addedDate DATE null
);

create table companyPolicy (
	companyPolicyId LONG not null primary key,
	companyId LONG,
	daysLocking INTEGER,
	checkStatus INTEGER,
	addedDate DATE null,
	modifiedDate DATE null
);

create table documentUploadFile (
	documentId LONG not null primary key,
	companyId LONG,
	employeeId LONG,
	fileEntryId LONG,
	documentName VARCHAR(75) null,
	documentPath VARCHAR(75) null,
	uploadDate DATE null,
	travelDetailsId LONG
);

create table emailTemplates (
	id_ LONG not null primary key,
	templateName VARCHAR(75) null,
	emailFor VARCHAR(75) null,
	templateBody VARCHAR(75) null,
	createdBy DATE null,
	ModifiedBy DATE null,
	Status BOOLEAN,
	restoreTemplateBody VARCHAR(75) null
);

create table empPayStructure (
	empPayStructureId LONG not null primary key,
	payComponentId LONG,
	componentValue DOUBLE,
	employeeId LONG
);

create table employee (
	employeeId LONG not null primary key,
	companyId LONG,
	employeeCode LONG,
	dateOfJoing DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	designation VARCHAR(75) null,
	dateOfBirth DATE null,
	gender VARCHAR(75) null,
	maritalStatus VARCHAR(75) null,
	noOfChild LONG,
	note VARCHAR(75) null,
	address VARCHAR(75) null,
	state_ VARCHAR(75) null,
	postCode VARCHAR(75) null,
	homePhone INTEGER,
	mobileNumber INTEGER,
	emaiAddress VARCHAR(75) null,
	anniversary DATE null,
	employeePhoto BLOB,
	employeeStatus INTEGER,
	totalPay DOUBLE,
	basicPay DOUBLE,
	da DOUBLE,
	hra DOUBLE,
	medical DOUBLE,
	ta DOUBLE,
	conveyance DOUBLE,
	internet DOUBLE,
	mobile DOUBLE,
	fare DOUBLE,
	areas DOUBLE,
	bouns DOUBLE,
	insurance DOUBLE,
	otherAllowance DOUBLE,
	providentFund DOUBLE,
	professionTax DOUBLE,
	incomeTax DOUBLE,
	loan DOUBLE,
	otherDeduction DOUBLE,
	bankId LONG,
	branchAddress VARCHAR(75) null,
	accountNo VARCHAR(75) null,
	pfNo VARCHAR(75) null,
	aadhaarNo VARCHAR(75) null,
	employeetypeId INTEGER,
	ispfdeduct INTEGER,
	roleId INTEGER,
	addedDate DATE null,
	photoId LONG,
	userId LONG,
	branchId LONG,
	panNo VARCHAR(75) null,
	pesonalEmaiAddress VARCHAR(75) null,
	payPerMonth DOUBLE,
	groupId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	createDate DATE null,
	modifiedDate DATE null
);

create table employeeDocumentUpload (
	empDocumentId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	fileEntryId LONG,
	travelDeskDetailsId LONG,
	documentName VARCHAR(75) null,
	documentPath VARCHAR(75) null,
	uploadDate DATE null
);

create table employeeType (
	employeetypeId LONG not null primary key,
	typeName VARCHAR(75) null,
	pfDeduct LONG,
	status INTEGER,
	companyId LONG,
	addeddate DATE null,
	description VARCHAR(75) null
);

create table evaluation (
	evaluationId LONG not null primary key,
	employeeId LONG,
	evaluatedBy LONG,
	evalMessage VARCHAR(75) null,
	evalDate DATE null,
	evalRating INTEGER
);

create table expCategory (
	catId LONG not null primary key,
	companyId LONG,
	categoryName VARCHAR(75) null,
	frequency VARCHAR(75) null,
	salaryHead LONG,
	finalApprovalRoleId LONG,
	attachment BOOLEAN,
	componentId LONG
);

create table expProofFiles (
	fileId LONG not null primary key,
	financialYear VARCHAR(75) null,
	companyId LONG,
	employeeId LONG,
	expenseId LONG,
	fileName VARCHAR(75) null,
	fileOrigName VARCHAR(75) null,
	filePath VARCHAR(75) null,
	proofName VARCHAR(75) null,
	uploadDate DATE null
);

create table expenseEntry (
	expenseId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	projectId LONG,
	catId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	expDate DATE null,
	amount DOUBLE,
	status INTEGER,
	manEmployeeId LONG,
	manCommnets VARCHAR(75) null,
	manApprovedDate DATE null,
	accComments VARCHAR(75) null,
	accApprovedDate DATE null,
	monthYear LONG,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table expenseEntryHistory (
	expenseHistoryId LONG not null primary key,
	companyId LONG,
	expenseId LONG,
	status INTEGER,
	manEmployeeId LONG,
	manComments VARCHAR(75) null,
	addeddate DATE null
);

create table finalSalary (
	finSalaryId LONG not null primary key,
	monthYear LONG,
	totalEarning DOUBLE,
	totalDeduction DOUBLE,
	totalAmount DOUBLE,
	isLock LONG,
	createdBy LONG,
	createdDate DATE null
);

create table geoAttendance (
	attendanceId LONG not null primary key,
	employeeId LONG,
	attDate DATE null,
	inTime VARCHAR(75) null,
	outTime VARCHAR(75) null,
	workHour VARCHAR(75) null,
	latitude VARCHAR(75) null,
	longitude VARCHAR(75) null,
	outLatitude VARCHAR(75) null,
	outLongitude VARCHAR(75) null,
	geoAddress VARCHAR(75) null
);

create table goalDetails (
	goaldetailId LONG not null primary key,
	goalId LONG,
	evaluationId LONG,
	companyId LONG,
	parameter VARCHAR(75) null,
	scale VARCHAR(75) null,
	addedDate DATE null
);

create table goalMaster (
	goalId LONG not null primary key,
	employeeId LONG,
	projectId LONG,
	goalName VARCHAR(75) null,
	goalDescription VARCHAR(75) null,
	addedDate DATE null
);

create table holidayCalenderManagement (
	holidayId LONG not null primary key,
	holidayDate DATE null,
	holidayName VARCHAR(75) null,
	holidayStartDate DATE null,
	holidayEndDate DATE null,
	companyId LONG
);

create table incomeTaxSlab (
	incomeTaxSlabId LONG not null primary key,
	financialYear VARCHAR(75) null,
	companyId LONG,
	incomeFrom INTEGER,
	incomeTo INTEGER,
	taxRate DOUBLE
);

create table interviewEvaluation (
	evaluationId LONG not null primary key,
	roleId LONG,
	evaluationName VARCHAR(75) null
);

create table leaveApply (
	leaveApplyId LONG not null primary key,
	companyId LONG,
	employeeId LONG,
	leaveTypeId LONG,
	fromDate DATE null,
	fromDateSession VARCHAR(75) null,
	toDate DATE null,
	toDateSession VARCHAR(75) null,
	leaveDays DOUBLE,
	reason VARCHAR(75) null,
	attachedFile VARCHAR(75) null,
	cancelReason VARCHAR(75) null,
	hrComments VARCHAR(75) null,
	isApprove INTEGER,
	addedDate DATE null,
	userId LONG,
	fileEntryId LONG,
	groupId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	createDate DATE null,
	modifiedDate DATE null
);

create table leaveApplyDtl (
	leaveApplyDtlId LONG not null primary key,
	leaveApplyId LONG,
	employeeId LONG,
	companyId LONG,
	leaveTypeId LONG,
	leaveDate DATE null,
	sessionData VARCHAR(75) null,
	leaveDays DOUBLE,
	impectOnSalary INTEGER,
	isApprove INTEGER
);

create table leaveManagement (
	leaveId LONG not null primary key,
	leaveName VARCHAR(75) null,
	abb VARCHAR(75) null,
	encashmentDay INTEGER,
	forwardDay INTEGER,
	leaveStatus BOOLEAN,
	encashmentPer INTEGER,
	minServiceDay INTEGER,
	noticeDay INTEGER,
	employeetypeId LONG,
	maxCreditDay INTEGER,
	gender VARCHAR(75) null,
	maritalStatus VARCHAR(75) null,
	impectOnSalary INTEGER,
	companyId LONG,
	addedDate DATE null
);

create table leaveOb (
	leaveobId LONG not null primary key,
	employeeId LONG,
	leaveTypeId LONG,
	obVal INTEGER,
	isApprove BOOLEAN
);

create table leaveType (
	leaveTypeId LONG not null primary key,
	leaveName VARCHAR(75) null,
	abb VARCHAR(75) null,
	encashmentDay INTEGER,
	forwardDay INTEGER,
	leaveStatus BOOLEAN,
	encashmentPer INTEGER,
	minServiceDay INTEGER,
	noticeDay INTEGER,
	employeetypeId LONG,
	maxCreditDay INTEGER,
	gender VARCHAR(75) null,
	maritalStatus VARCHAR(75) null,
	impectOnSalary INTEGER,
	companyId LONG,
	addedDate DATE null
);

create table notificationMasterManage (
	notifyId LONG not null primary key,
	subject VARCHAR(75) null,
	body VARCHAR(75) null,
	createdBy VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	documentId LONG,
	documentUrl VARCHAR(75) null
);

create table notificationSendManage (
	notifyIdSendId LONG not null primary key,
	notificationId LONG,
	branchId LONG,
	sendingDate DATE null,
	sendBy VARCHAR(75) null,
	isOpen BOOLEAN,
	openBy VARCHAR(75) null,
	documentId LONG,
	isApproved INTEGER,
	comment_ VARCHAR(75) null,
	documentUrl VARCHAR(75) null
);

create table payDetails (
	SalDetailsId LONG not null primary key,
	monthYear LONG,
	componentId LONG,
	employeeId LONG,
	value DOUBLE
);

create table payrollIncrement (
	payrollIncrementId LONG not null primary key,
	appraisalSettingId LONG,
	employeeId LONG,
	companyId LONG,
	employeeCode LONG,
	overallRatingMan LONG,
	preCtc DOUBLE,
	postCtc DOUBLE,
	componentId LONG,
	preHeadComponentVal DOUBLE,
	postHeadComponentVal DOUBLE,
	bonusVal DOUBLE,
	financialYear VARCHAR(75) null
);

create table payrollSlabs (
	payrollSlabsId LONG not null primary key,
	companyId LONG,
	appraisalSettingId LONG,
	ratingId LONG,
	payrollPercentage DOUBLE,
	bonusPercentage DOUBLE
);

create table performance (
	performanceId LONG not null primary key,
	companyId LONG,
	performanceHeading VARCHAR(75) null,
	performanceDescription VARCHAR(75) null,
	createDate DATE null
);

create table performanceMaster (
	performanceId LONG not null primary key,
	companyId LONG,
	performanceHeading VARCHAR(75) null,
	performanceDescription VARCHAR(75) null,
	addedDate DATE null
);

create table projectMaster (
	projectId LONG not null primary key,
	companyId LONG,
	projectName VARCHAR(75) null,
	clientId LONG,
	employeeId LONG,
	projectStatus INTEGER,
	projectStatusId LONG,
	projectDesc VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	totalAmount DOUBLE,
	addedDate DATE null
);

create table projectRole (
	roleId LONG not null primary key,
	roleName VARCHAR(75) null
);

create table projectStatus (
	projectStatusId LONG not null primary key,
	companyId LONG,
	statusName VARCHAR(75) null,
	statusColor VARCHAR(75) null,
	addedDate DATE null
);

create table pushNotification (
	pushNotificationId LONG not null primary key,
	subject VARCHAR(75) null,
	message VARCHAR(75) null,
	fileId LONG,
	fileUrl VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table ratingMaster (
	ratingId LONG not null primary key,
	ratingNum VARCHAR(75) null,
	ratingKey VARCHAR(75) null,
	ratingDescription VARCHAR(75) null,
	salaryPercentage LONG,
	companyId LONG,
	addedDate DATE null
);

create table taskMaster (
	taskId LONG not null primary key,
	taskName VARCHAR(75) null,
	taskDesc VARCHAR(75) null,
	status INTEGER,
	createDate DATE null
);

create table taskMasterMapping (
	taskMappingId LONG not null primary key,
	taskId LONG,
	projectId LONG,
	createDate DATE null
);

create table taxDeclaration (
	taxDeclarationId LONG not null primary key,
	financialYear VARCHAR(75) null,
	monthYear INTEGER,
	employeeId LONG,
	companyId LONG,
	hraFromDate VARCHAR(75) null,
	hraToDate VARCHAR(75) null,
	hraCity VARCHAR(75) null,
	hraIsmetro VARCHAR(75) null,
	hraLandlordPan VARCHAR(75) null,
	hraRent DOUBLE,
	medicalIndividual DOUBLE,
	medicalParents DOUBLE,
	medicalParentsSenior DOUBLE,
	medicalHandiLess80 DOUBLE,
	medicalHandiGater80 DOUBLE,
	medicalGater60Less80 DOUBLE,
	medicalGater80 DOUBLE,
	educationLoan DOUBLE,
	physicalDisability DOUBLE,
	physicalDisabilitySevere DOUBLE,
	equitySavings DOUBLE,
	interestOnDeposit DOUBLE,
	nationalPension DOUBLE,
	lic DOUBLE,
	ppf DOUBLE,
	nsc DOUBLE,
	infraBonds DOUBLE,
	tuitionFees DOUBLE,
	mutualFunds DOUBLE,
	sukanya DOUBLE,
	ulip DOUBLE,
	timeDeposit DOUBLE,
	housingLoan DOUBLE,
	fixedDeposit DOUBLE,
	nscInterest DOUBLE,
	housingLoanInterest DOUBLE,
	housingAddress VARCHAR(75) null,
	previousIncome DOUBLE,
	previousPf DOUBLE,
	previousPt DOUBLE,
	previousTds DOUBLE,
	islock BOOLEAN,
	finalSubmission BOOLEAN,
	hraExempt DOUBLE,
	sectionBExempt DOUBLE,
	sectionCExempt DOUBLE,
	sectionDExempt DOUBLE,
	salaryAfterExempt DOUBLE,
	salaryBeforeExempt DOUBLE,
	taxRate DOUBLE,
	grossTds DOUBLE,
	totalPtax DOUBLE,
	totalProvidentFund DOUBLE,
	totalTds DOUBLE,
	tdsDeducted DOUBLE,
	tdsDuePerMonth DOUBLE,
	annualIncome DOUBLE,
	educationcess DOUBLE,
	addeddate DATE null
);

create table taxDeclarationMonthly (
	taxDeclarationMonthlyId LONG not null primary key,
	taxDeclarationId LONG,
	companyId LONG,
	financialYear VARCHAR(75) null,
	monthYear LONG,
	employeeId LONG,
	hraFromDate VARCHAR(75) null,
	hraToDate VARCHAR(75) null,
	hraCity VARCHAR(75) null,
	hraIsmetro VARCHAR(75) null,
	hraLandlordPan VARCHAR(75) null,
	hraRent DOUBLE,
	medicalIndividual DOUBLE,
	medicalParents DOUBLE,
	medicalParentsSenior DOUBLE,
	medicalHandiLess80 DOUBLE,
	medicalHandiGater80 DOUBLE,
	medicalGater60Less80 DOUBLE,
	medicalGater80 DOUBLE,
	educationLoan DOUBLE,
	physicalDisability DOUBLE,
	physicalDisabilitySevere DOUBLE,
	equitySavings DOUBLE,
	interestOnDeposit DOUBLE,
	nationalPension DOUBLE,
	lic DOUBLE,
	ppf DOUBLE,
	nsc DOUBLE,
	infraBonds DOUBLE,
	tuitionFees DOUBLE,
	mutualFunds DOUBLE,
	sukanya DOUBLE,
	ulip DOUBLE,
	timeDeposit DOUBLE,
	housingLoan DOUBLE,
	fixedDeposit DOUBLE,
	nscInterest DOUBLE,
	housingLoanInterest DOUBLE,
	housingAddress VARCHAR(75) null,
	previousIncome DOUBLE,
	previousPf DOUBLE,
	previousPt DOUBLE,
	previousTds DOUBLE,
	islock BOOLEAN,
	finalSubmission BOOLEAN,
	hraExempt DOUBLE,
	sectionBExempt DOUBLE,
	sectionCExempt DOUBLE,
	sectionDExempt DOUBLE,
	salaryAfterExempt DOUBLE,
	salaryBeforeExempt DOUBLE,
	taxRate DOUBLE,
	grossTds DOUBLE,
	totalTds DOUBLE,
	tdsDeducted DOUBLE,
	tdsDuePerMonth DOUBLE,
	educationCess DOUBLE,
	totalPtax DOUBLE,
	totalProvidentFund DOUBLE,
	totalConveyance DOUBLE,
	addedDate DATE null,
	currentMonthTax DOUBLE,
	sectionEExempt DOUBLE
);

create table taxProofFiles (
	fileId LONG not null primary key,
	financialYear VARCHAR(75) null,
	companyId LONG,
	employeeId LONG,
	taxDeclarationId LONG,
	fileName VARCHAR(75) null,
	fileOrigName VARCHAR(75) null,
	filePath VARCHAR(75) null,
	proofName VARCHAR(75) null,
	uploadDate DATE null
);

create table taxSetting (
	taxSettingId LONG not null primary key,
	componentId LONG,
	componentName VARCHAR(75) null,
	taxFormulla VARCHAR(75) null,
	createdBy LONG,
	createdDate DATE null,
	modifiedDate DATE null
);

create table timeSheetEntry (
	timesheetId LONG not null primary key,
	entryDate DATE null,
	employeeId LONG,
	projectId LONG,
	projectTaskId LONG,
	hours DOUBLE,
	workDescription VARCHAR(75) null,
	timesheetParentId LONG,
	addedDate DATE null,
	groupId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	createDate DATE null,
	modifiedDate DATE null
);

create table timeSheetMaster (
	timesheetParentId LONG not null primary key,
	employeeId LONG,
	fromDate DATE null,
	toDate DATE null,
	submitStatus INTEGER,
	addedDate DATE null,
	groupId LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	createDate DATE null,
	modifiedDate DATE null
);

create table workFromHome (
	workFromHomeId LONG not null primary key,
	employeeId LONG,
	companyId LONG,
	projectId LONG,
	appliedDate DATE null,
	description VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	workStatus INTEGER,
	hrComments VARCHAR(75) null
);

create table worksSchedules (
	worksSchedulesId LONG not null primary key,
	companyId LONG,
	employeeId LONG,
	fromDate DATE null,
	toDate DATE null,
	schedulesId LONG,
	islock INTEGER,
	status INTEGER,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null
);