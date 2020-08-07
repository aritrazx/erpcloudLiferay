package com.liferay.famocom.erpcloud.geoattendance.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.liferay.famocom.erpcloud.model.Employee;
import com.liferay.famocom.erpcloud.model.GeoAttendance;
import com.liferay.famocom.erpcloud.service.EmployeeLocalServiceUtil;
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
			if ("attDate".equalsIgnoreCase(sortByCol) && obj1 instanceof GeoAttendance) {
				GeoAttendance ts1 = (GeoAttendance) obj1;
				GeoAttendance ts2 = (GeoAttendance) obj2;
				value1 = ts1.getAttDate();
				value2 = ts2.getAttDate();
			} else if("employeeId".equalsIgnoreCase(sortByCol) && obj1 instanceof GeoAttendance) {
				GeoAttendance ts1 = (GeoAttendance) obj1;
				GeoAttendance ts2 = (GeoAttendance) obj2;
				Employee pt1 = EmployeeLocalServiceUtil.getEmployee(ts1.getEmployeeId());
				Employee pt2 = EmployeeLocalServiceUtil.getEmployee(ts2.getEmployeeId());
				value1 = pt1.getFirstName()+" "+pt1.getLastName();
				value2 = pt2.getFirstName()+" "+pt2.getLastName();
			} else if("inTime".equalsIgnoreCase(sortByCol) && obj1 instanceof GeoAttendance) {
				GeoAttendance ts1 = (GeoAttendance) obj1;
				GeoAttendance ts2 = (GeoAttendance) obj2;
				value1 = ts1.getInTime();
				value2 = ts2.getInTime();
			} else if("geoAddress".equalsIgnoreCase(sortByCol) && obj1 instanceof GeoAttendance) {
				GeoAttendance ts1 = (GeoAttendance) obj1;
				GeoAttendance ts2 = (GeoAttendance) obj2;
				value1 = ts1.getGeoAddress();
				value2 = ts2.getGeoAddress();
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

		} catch (InvocationTargetException e) {

			e.printStackTrace();

		} catch (PortalException e) {
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
