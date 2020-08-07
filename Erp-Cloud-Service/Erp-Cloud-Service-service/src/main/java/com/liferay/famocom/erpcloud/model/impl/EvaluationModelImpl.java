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

import com.liferay.famocom.erpcloud.model.Evaluation;
import com.liferay.famocom.erpcloud.model.EvaluationModel;
import com.liferay.famocom.erpcloud.model.EvaluationSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Evaluation service. Represents a row in the &quot;evaluation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link EvaluationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EvaluationImpl}.
 * </p>
 *
 * @author Samaresh
 * @see EvaluationImpl
 * @see Evaluation
 * @see EvaluationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class EvaluationModelImpl extends BaseModelImpl<Evaluation>
	implements EvaluationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a evaluation model instance should use the {@link Evaluation} interface instead.
	 */
	public static final String TABLE_NAME = "evaluation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "evaluationId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "evaluatedBy", Types.BIGINT },
			{ "evalMessage", Types.VARCHAR },
			{ "evalDate", Types.TIMESTAMP },
			{ "evalRating", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("evaluationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("evaluatedBy", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("evalMessage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("evalDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("evalRating", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table evaluation (evaluationId LONG not null primary key,employeeId LONG,evaluatedBy LONG,evalMessage VARCHAR(75) null,evalDate DATE null,evalRating INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table evaluation";
	public static final String ORDER_BY_JPQL = " ORDER BY evaluation.evaluationId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY evaluation.evaluationId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.famocom.erpcloud.model.Evaluation"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.famocom.erpcloud.model.Evaluation"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Evaluation toModel(EvaluationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Evaluation model = new EvaluationImpl();

		model.setEvaluationId(soapModel.getEvaluationId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setEvaluatedBy(soapModel.getEvaluatedBy());
		model.setEvalMessage(soapModel.getEvalMessage());
		model.setEvalDate(soapModel.getEvalDate());
		model.setEvalRating(soapModel.getEvalRating());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Evaluation> toModels(EvaluationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Evaluation> models = new ArrayList<Evaluation>(soapModels.length);

		for (EvaluationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.famocom.erpcloud.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.famocom.erpcloud.model.Evaluation"));

	public EvaluationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _evaluationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEvaluationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _evaluationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Evaluation.class;
	}

	@Override
	public String getModelClassName() {
		return Evaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evaluationId", getEvaluationId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("evaluatedBy", getEvaluatedBy());
		attributes.put("evalMessage", getEvalMessage());
		attributes.put("evalDate", getEvalDate());
		attributes.put("evalRating", getEvalRating());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long evaluationId = (Long)attributes.get("evaluationId");

		if (evaluationId != null) {
			setEvaluationId(evaluationId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long evaluatedBy = (Long)attributes.get("evaluatedBy");

		if (evaluatedBy != null) {
			setEvaluatedBy(evaluatedBy);
		}

		String evalMessage = (String)attributes.get("evalMessage");

		if (evalMessage != null) {
			setEvalMessage(evalMessage);
		}

		Date evalDate = (Date)attributes.get("evalDate");

		if (evalDate != null) {
			setEvalDate(evalDate);
		}

		Integer evalRating = (Integer)attributes.get("evalRating");

		if (evalRating != null) {
			setEvalRating(evalRating);
		}
	}

	@JSON
	@Override
	public long getEvaluationId() {
		return _evaluationId;
	}

	@Override
	public void setEvaluationId(long evaluationId) {
		_evaluationId = evaluationId;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	@JSON
	@Override
	public long getEvaluatedBy() {
		return _evaluatedBy;
	}

	@Override
	public void setEvaluatedBy(long evaluatedBy) {
		_evaluatedBy = evaluatedBy;
	}

	@JSON
	@Override
	public String getEvalMessage() {
		if (_evalMessage == null) {
			return "";
		}
		else {
			return _evalMessage;
		}
	}

	@Override
	public void setEvalMessage(String evalMessage) {
		_evalMessage = evalMessage;
	}

	@JSON
	@Override
	public Date getEvalDate() {
		return _evalDate;
	}

	@Override
	public void setEvalDate(Date evalDate) {
		_evalDate = evalDate;
	}

	@JSON
	@Override
	public int getEvalRating() {
		return _evalRating;
	}

	@Override
	public void setEvalRating(int evalRating) {
		_evalRating = evalRating;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Evaluation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Evaluation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Evaluation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EvaluationImpl evaluationImpl = new EvaluationImpl();

		evaluationImpl.setEvaluationId(getEvaluationId());
		evaluationImpl.setEmployeeId(getEmployeeId());
		evaluationImpl.setEvaluatedBy(getEvaluatedBy());
		evaluationImpl.setEvalMessage(getEvalMessage());
		evaluationImpl.setEvalDate(getEvalDate());
		evaluationImpl.setEvalRating(getEvalRating());

		evaluationImpl.resetOriginalValues();

		return evaluationImpl;
	}

	@Override
	public int compareTo(Evaluation evaluation) {
		long primaryKey = evaluation.getPrimaryKey();

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

		if (!(obj instanceof Evaluation)) {
			return false;
		}

		Evaluation evaluation = (Evaluation)obj;

		long primaryKey = evaluation.getPrimaryKey();

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
	public CacheModel<Evaluation> toCacheModel() {
		EvaluationCacheModel evaluationCacheModel = new EvaluationCacheModel();

		evaluationCacheModel.evaluationId = getEvaluationId();

		evaluationCacheModel.employeeId = getEmployeeId();

		evaluationCacheModel.evaluatedBy = getEvaluatedBy();

		evaluationCacheModel.evalMessage = getEvalMessage();

		String evalMessage = evaluationCacheModel.evalMessage;

		if ((evalMessage != null) && (evalMessage.length() == 0)) {
			evaluationCacheModel.evalMessage = null;
		}

		Date evalDate = getEvalDate();

		if (evalDate != null) {
			evaluationCacheModel.evalDate = evalDate.getTime();
		}
		else {
			evaluationCacheModel.evalDate = Long.MIN_VALUE;
		}

		evaluationCacheModel.evalRating = getEvalRating();

		return evaluationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{evaluationId=");
		sb.append(getEvaluationId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", evaluatedBy=");
		sb.append(getEvaluatedBy());
		sb.append(", evalMessage=");
		sb.append(getEvalMessage());
		sb.append(", evalDate=");
		sb.append(getEvalDate());
		sb.append(", evalRating=");
		sb.append(getEvalRating());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.famocom.erpcloud.model.Evaluation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>evaluationId</column-name><column-value><![CDATA[");
		sb.append(getEvaluationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evaluatedBy</column-name><column-value><![CDATA[");
		sb.append(getEvaluatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evalMessage</column-name><column-value><![CDATA[");
		sb.append(getEvalMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evalDate</column-name><column-value><![CDATA[");
		sb.append(getEvalDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evalRating</column-name><column-value><![CDATA[");
		sb.append(getEvalRating());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Evaluation.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Evaluation.class, ModelWrapper.class
		};
	private long _evaluationId;
	private long _employeeId;
	private long _evaluatedBy;
	private String _evalMessage;
	private Date _evalDate;
	private int _evalRating;
	private Evaluation _escapedModel;
}