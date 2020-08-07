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

package com.liferay.famocom.erpcloud.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.famocom.erpcloud.model.IncomeTaxSlab;
import com.liferay.famocom.erpcloud.model.IncomeTaxSlabModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the IncomeTaxSlab service. Represents a row in the &quot;incomeTaxSlab&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link IncomeTaxSlabModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IncomeTaxSlabImpl}.
 * </p>
 *
 * @author Samaresh
 * @see IncomeTaxSlabImpl
 * @see IncomeTaxSlab
 * @see IncomeTaxSlabModel
 * @generated
 */
@ProviderType
public class IncomeTaxSlabModelImpl extends BaseModelImpl<IncomeTaxSlab>
	implements IncomeTaxSlabModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a income tax slab model instance should use the {@link IncomeTaxSlab} interface instead.
	 */
	public static final String TABLE_NAME = "incomeTaxSlab";
	public static final Object[][] TABLE_COLUMNS = {
			{ "incomeTaxSlabId", Types.BIGINT },
			{ "financialYear", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "incomeFrom", Types.INTEGER },
			{ "incomeTo", Types.INTEGER },
			{ "taxRate", Types.DOUBLE }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("incomeTaxSlabId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("financialYear", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("incomeFrom", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("incomeTo", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("taxRate", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE = "create table incomeTaxSlab (incomeTaxSlabId LONG not null primary key,financialYear VARCHAR(75) null,companyId LONG,incomeFrom INTEGER,incomeTo INTEGER,taxRate DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table incomeTaxSlab";
	public static final String ORDER_BY_JPQL = " ORDER BY incomeTaxSlab.incomeTaxSlabId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY incomeTaxSlab.incomeTaxSlabId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.IncomeTaxSlab"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.IncomeTaxSlab"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.IncomeTaxSlab"));

	public IncomeTaxSlabModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _incomeTaxSlabId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIncomeTaxSlabId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _incomeTaxSlabId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return IncomeTaxSlab.class;
	}

	@Override
	public String getModelClassName() {
		return IncomeTaxSlab.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("incomeTaxSlabId", getIncomeTaxSlabId());
		attributes.put("financialYear", getFinancialYear());
		attributes.put("companyId", getCompanyId());
		attributes.put("incomeFrom", getIncomeFrom());
		attributes.put("incomeTo", getIncomeTo());
		attributes.put("taxRate", getTaxRate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long incomeTaxSlabId = (Long)attributes.get("incomeTaxSlabId");

		if (incomeTaxSlabId != null) {
			setIncomeTaxSlabId(incomeTaxSlabId);
		}

		String financialYear = (String)attributes.get("financialYear");

		if (financialYear != null) {
			setFinancialYear(financialYear);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer incomeFrom = (Integer)attributes.get("incomeFrom");

		if (incomeFrom != null) {
			setIncomeFrom(incomeFrom);
		}

		Integer incomeTo = (Integer)attributes.get("incomeTo");

		if (incomeTo != null) {
			setIncomeTo(incomeTo);
		}

		Double taxRate = (Double)attributes.get("taxRate");

		if (taxRate != null) {
			setTaxRate(taxRate);
		}
	}

	@Override
	public long getIncomeTaxSlabId() {
		return _incomeTaxSlabId;
	}

	@Override
	public void setIncomeTaxSlabId(long incomeTaxSlabId) {
		_incomeTaxSlabId = incomeTaxSlabId;
	}

	@Override
	public String getFinancialYear() {
		if (_financialYear == null) {
			return "";
		}
		else {
			return _financialYear;
		}
	}

	@Override
	public void setFinancialYear(String financialYear) {
		_financialYear = financialYear;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public int getIncomeFrom() {
		return _incomeFrom;
	}

	@Override
	public void setIncomeFrom(int incomeFrom) {
		_incomeFrom = incomeFrom;
	}

	@Override
	public int getIncomeTo() {
		return _incomeTo;
	}

	@Override
	public void setIncomeTo(int incomeTo) {
		_incomeTo = incomeTo;
	}

	@Override
	public double getTaxRate() {
		return _taxRate;
	}

	@Override
	public void setTaxRate(double taxRate) {
		_taxRate = taxRate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			IncomeTaxSlab.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public IncomeTaxSlab toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (IncomeTaxSlab)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IncomeTaxSlabImpl incomeTaxSlabImpl = new IncomeTaxSlabImpl();

		incomeTaxSlabImpl.setIncomeTaxSlabId(getIncomeTaxSlabId());
		incomeTaxSlabImpl.setFinancialYear(getFinancialYear());
		incomeTaxSlabImpl.setCompanyId(getCompanyId());
		incomeTaxSlabImpl.setIncomeFrom(getIncomeFrom());
		incomeTaxSlabImpl.setIncomeTo(getIncomeTo());
		incomeTaxSlabImpl.setTaxRate(getTaxRate());

		incomeTaxSlabImpl.resetOriginalValues();

		return incomeTaxSlabImpl;
	}

	@Override
	public int compareTo(IncomeTaxSlab incomeTaxSlab) {
		long primaryKey = incomeTaxSlab.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IncomeTaxSlab)) {
			return false;
		}

		IncomeTaxSlab incomeTaxSlab = (IncomeTaxSlab)obj;

		long primaryKey = incomeTaxSlab.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<IncomeTaxSlab> toCacheModel() {
		IncomeTaxSlabCacheModel incomeTaxSlabCacheModel = new IncomeTaxSlabCacheModel();

		incomeTaxSlabCacheModel.incomeTaxSlabId = getIncomeTaxSlabId();

		incomeTaxSlabCacheModel.financialYear = getFinancialYear();

		String financialYear = incomeTaxSlabCacheModel.financialYear;

		if ((financialYear != null) && (financialYear.length() == 0)) {
			incomeTaxSlabCacheModel.financialYear = null;
		}

		incomeTaxSlabCacheModel.companyId = getCompanyId();

		incomeTaxSlabCacheModel.incomeFrom = getIncomeFrom();

		incomeTaxSlabCacheModel.incomeTo = getIncomeTo();

		incomeTaxSlabCacheModel.taxRate = getTaxRate();

		return incomeTaxSlabCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{incomeTaxSlabId=");
		sb.append(getIncomeTaxSlabId());
		sb.append(", financialYear=");
		sb.append(getFinancialYear());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", incomeFrom=");
		sb.append(getIncomeFrom());
		sb.append(", incomeTo=");
		sb.append(getIncomeTo());
		sb.append(", taxRate=");
		sb.append(getTaxRate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.IncomeTaxSlab");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>incomeTaxSlabId</column-name><column-value><![CDATA[");
		sb.append(getIncomeTaxSlabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financialYear</column-name><column-value><![CDATA[");
		sb.append(getFinancialYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incomeFrom</column-name><column-value><![CDATA[");
		sb.append(getIncomeFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incomeTo</column-name><column-value><![CDATA[");
		sb.append(getIncomeTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxRate</column-name><column-value><![CDATA[");
		sb.append(getTaxRate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = IncomeTaxSlab.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			IncomeTaxSlab.class, ModelWrapper.class
		};
	private long _incomeTaxSlabId;
	private String _financialYear;
	private long _companyId;
	private int _incomeFrom;
	private int _incomeTo;
	private double _taxRate;
	private IncomeTaxSlab _escapedModel;
}