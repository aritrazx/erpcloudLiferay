package com.liferay.famocom.erpcloud.geoattendance.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

public class CustomComparatorUtil {
	
	public static OrderByComparator getListOrderByComparator(String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (Validator.isNull(orderByType)) {
			orderByType = "asc";
		}

		if (Validator.isNull(orderByCol)) {
			orderByCol = "name";
		}

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		return new MyComparator(orderByAsc, orderByCol);
	}
}
