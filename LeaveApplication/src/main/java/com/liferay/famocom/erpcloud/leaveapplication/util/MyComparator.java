package com.liferay.famocom.erpcloud.leaveapplication.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.liferay.famocom.erpcloud.model.LeaveApply;
import com.liferay.famocom.erpcloud.model.LeaveType;
import com.liferay.famocom.erpcloud.service.LeaveTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

public class MyComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "id ASC";

	public static String ORDER_BY_DESC = "id DESC";

	String sortByCol = "name";

	public MyComparator() {

		this(false, "");
	}

	public MyComparator(boolean asc, String sortByCol) {

		_asc = asc;
		this.sortByCol = sortByCol;
	}

	@SuppressWarnings("unchecked")
	public int compare(Object obj1, Object obj2) {
		int value = 0;
		Object value1 = null;
		Object value2 = null;
		try {
			if ("fromDate".equalsIgnoreCase(sortByCol) && obj1 instanceof LeaveApply ) {
				LeaveApply ts1 = (LeaveApply ) obj1;
				LeaveApply ts2 = (LeaveApply ) obj2;
				value1 = ts1.getFromDate();
				value2 = ts2.getFromDate();
			} else if("toDate".equalsIgnoreCase(sortByCol) && obj1 instanceof LeaveApply ) {
				LeaveApply ts1 = (LeaveApply ) obj1;
				LeaveApply ts2 = (LeaveApply ) obj2;
				value1 = ts1.getToDate();
				value2 = ts2.getToDate();
			}else if("leaveId".equalsIgnoreCase(sortByCol) && obj1 instanceof LeaveApply) {
				LeaveApply ts1 = (LeaveApply) obj1;
				LeaveApply ts2 = (LeaveApply) obj2;
				LeaveType pt1 = LeaveTypeLocalServiceUtil.getLeaveType(ts1.getLeaveTypeId());
				LeaveType pt2 = LeaveTypeLocalServiceUtil.getLeaveType(ts2.getLeaveTypeId());
				if (pt1 != null) {
				value1 = pt1.getLeaveName();
				}
				if (pt1 != null) {
				value2 = pt2.getLeaveName();
				}
			}
			else {
				try {
					value1 = PropertyUtils.getProperty(obj1, sortByCol);
					value2 = PropertyUtils.getProperty(obj2, sortByCol);
				} catch (NoSuchMethodException e) {
				}
			}
			
			if (value1 == null) {
				value = -1;
			} else if (value2 == null) {
				value = +1;
			}
			if (value1 == null && value2 == null) {
				value = 0;
			}
			if (value1 != null && value2 != null) {
				if (value1 instanceof String) {
					value = ((String) value1).toLowerCase().compareTo(((String) value2).toLowerCase());
				} else if (value1 instanceof Integer) {
					value = ((Integer) value1).compareTo((Integer) value2);
				} else if (value1 instanceof Long) {
					value = ((Long) value1).compareTo((Long) value2);
				} else if (value1 instanceof Date) {
					value = ((Date) value1).compareTo((Date) value2);
				}else if (value1 instanceof Double) {
					value = ((Double) value1).compareTo((Double) value2);
				}
			}

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();

		} catch (SystemException e) {
			e.printStackTrace();
		}

		if (_asc) {
			return value;

		} else {

			return -value;
		}

	}

	public String getOrderBy() {

		if (_asc) {
			return this.sortByCol + " ASC";

		} else {

			return this.sortByCol + " DESC";
		}
	}

	@SuppressWarnings("unused")
	private static final Object Client = null;

	@SuppressWarnings("unused")
	private static final Object Inquiry = null;

	@SuppressWarnings("unused")
	private static final Object InquiryImpl = null;

	private boolean _asc;
}
