package com.liferay.famocom.erpcloud.workschedule.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.liferay.famocom.erpcloud.model.SchedulesMaster;
import com.liferay.famocom.erpcloud.model.WorksSchedules;
import com.liferay.famocom.erpcloud.service.SchedulesMasterLocalServiceUtil;
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
			if ("schedulesId".equalsIgnoreCase(sortByCol) && obj1 instanceof WorksSchedules) {
				WorksSchedules ts1 = (WorksSchedules) obj1;
				WorksSchedules ts2 = (WorksSchedules) obj2;
				SchedulesMaster pm1 = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ts1.getSchedulesId());
				SchedulesMaster pm2 = SchedulesMasterLocalServiceUtil.getSchedulesMaster(ts2.getSchedulesId());
				if (pm1 != null) {
					value1 = pm1.getSchedulesName();
				}
				if (pm1 != null) {
					value2 = pm2.getSchedulesName();
				}
			} else if("fromDate".equalsIgnoreCase(sortByCol) && obj1 instanceof WorksSchedules) {
				WorksSchedules ts1 = (WorksSchedules) obj1;
				WorksSchedules ts2 = (WorksSchedules) obj2;
				value1 = ts1.getFromDate();
				value2 = ts2.getFromDate();
			
			} else if("toDate".equalsIgnoreCase(sortByCol) && obj1 instanceof WorksSchedules) {
				WorksSchedules ts1 = (WorksSchedules) obj1;
				WorksSchedules ts2 = (WorksSchedules) obj2;
				value1 = ts1.getToDate();
				value2 = ts2.getToDate();
			} else if("schedulesName".equalsIgnoreCase(sortByCol) && obj1 instanceof SchedulesMaster) {
				SchedulesMaster ts1 = (SchedulesMaster) obj1;
				SchedulesMaster ts2 = (SchedulesMaster) obj2;
				value1 = ts1.getSchedulesName();
				value2 = ts2.getSchedulesName();
			} else if("schedulesDescription".equalsIgnoreCase(sortByCol) && obj1 instanceof SchedulesMaster) {
				SchedulesMaster ts1 = (SchedulesMaster) obj1;
				SchedulesMaster ts2 = (SchedulesMaster) obj2;
				value1 = ts1.getSchedulesDescription();
				value2 = ts2.getSchedulesDescription();
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
