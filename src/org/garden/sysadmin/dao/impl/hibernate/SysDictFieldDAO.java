/*
 * Copyright (c) 2004, 2014, Garden Lee. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.garden.sysadmin.dao.impl.hibernate;

import java.util.List;

import org.garden.dao.hibernate.DAO;
import org.garden.sysadmin.dao.ISysDictFieldDAO;
import org.garden.sysadmin.dao.model.SysDictField;
import org.garden.sysadmin.dao.model.SysDictValue;
import org.hibernate.Query;

/**
 * 
 * SysDictFieldDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Tue Nov 11 23:34:50 CST 2014
 */
public class SysDictFieldDAO extends DAO<SysDictField> implements ISysDictFieldDAO {

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDictFieldDAO#findFieldValueByFieldCode(java.lang.String, java.lang.String)
	 */
	@Override
	public SysDictValue findFieldValueByFieldCode(String fieldCode,
			String fieldValue) {
		String hql = "select b from " + SysDictField.class.getName() + " a, " + SysDictValue.class.getName() + " b where " 
				+ " a.dictCode=? and a.dictId=b.dictId and b.value=?";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, fieldCode);
		query.setParameter(1, fieldValue);
		
		List<SysDictValue> list = query.list();
		
		if ( !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDictFieldDAO#getFieldValueByFieldCode(java.lang.String)
	 */
	@Override
	public List<SysDictValue> getFieldValueByFieldCode(String fieldCode) {
		String hql = "select b from " + SysDictField.class.getName() + " a, " + SysDictValue.class.getName() + " b where " 
				+ "a.dictId=b.dictId and a.dictCode=? order by b.orderNum";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, fieldCode);
		
		return query.list();
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDictFieldDAO#getFieldValueByFieldId(java.lang.Long, java.lang.String)
	 */
	@Override
	public SysDictValue getFieldValueByFieldId(Long dictId, String fieldValue) {
		String hql = "select b from " + SysDictValue.class.getName() + " b where " 
				+ " b.dictId=? and b.value=?";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, dictId);
		query.setParameter(1, fieldValue);
		
		List<SysDictValue> list = query.list();
		
		if ( !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	
}