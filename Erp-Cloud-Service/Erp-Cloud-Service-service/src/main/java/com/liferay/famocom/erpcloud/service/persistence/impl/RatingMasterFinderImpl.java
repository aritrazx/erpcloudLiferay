package com.liferay.famocom.erpcloud.service.persistence.impl;

import java.math.BigInteger;

import com.liferay.famocom.erpcloud.service.persistence.RatingMasterFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

public class RatingMasterFinderImpl extends RatingMasterFinderBaseImpl implements RatingMasterFinder {

	public int getUsageCount(long ratingId) {
		BigInteger count = new BigInteger("0");
		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), GET_USAGE_COUNT);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(ratingId);
			qPos.add(ratingId);
			qPos.add(ratingId);
			qPos.add(ratingId);

			count = (BigInteger) q.uniqueResult();

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return count.intValue();
	}

	public static final String GET_USAGE_COUNT = RatingMasterFinder.class.getName() + ".getUsageCount";
}
