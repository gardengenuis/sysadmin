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
 */package org.garden.sysadmin.dao.impl.hibernate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.garden.dao.hibernate.DAO;
import org.garden.sysadmin.dao.ISysResourceDAO;
import org.garden.sysadmin.dao.model.SysOperation;
import org.garden.sysadmin.dao.model.SysResource;
import org.garden.sysadmin.dao.model.SysRole;
import org.garden.sysadmin.dao.model.SysRoleResOper;
import org.garden.sysadmin.dao.model.SysUserRole;
import org.hibernate.Query;

/**
 * 
 * SysResourceDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Sat Sep 13 14:34:12 CST 2014
 */
public class SysResourceDAO extends DAO<SysResource> implements ISysResourceDAO {

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysResourceDAO#findByRoleId(java.lang.Long[])
	 */
	@Override
	public List<SysResource> findByRoleId(Long[] roleIds) {
		String hql = "select a, b from " + SysResource.class.getName() + " a," + SysOperation.class.getName() + " b," + SysRoleResOper.class.getName() + " c"
				+ " where a.resourceId=c.sysRoleResOper.resourceId and b.operationId=c.sysRoleResOper.operationId and c.sysRoleResOper.roleId in (:roleIds) order by a.orderNum";
		
		Query query = sessionFactory.getCurrentSession().createQuery( hql);
		query.setParameterList("roleIds", roleIds);
		
		List<?> list = query.list();
		Map<Long, SysResource> resMap = new HashMap<Long, SysResource>();
		List<SysResource> rltList = new ArrayList<SysResource>();
		
		for ( int i=0; i<list.size(); i++) {
			Object[] objs = (Object[])list.get(i);

			SysResource resource = (SysResource) objs[0];
			SysOperation operation = (SysOperation) objs[1];
			
			Long resourceId = resource.getResourceId();
			
			if ( !resMap.containsKey(resourceId)) {
				resMap.put(resourceId, resource);
				rltList.add(resource);
			} else {
				resource = resMap.get(resourceId);
			}
			
			resource.addOperation(operation);
		}
		
		return rltList;
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysResourceDAO#findAllResourcesWithRoles()
	 */
	@Override
	public List<SysResource> findAllResourcesWithRoles() {
		String hql = "select distinct c, b from " + SysRoleResOper.class.getName() + " a, " + SysRole.class.getName() + " b, " + SysResource.class.getName() 
				+ " c where a.sysRoleResOper.roleId=b.roleId and a.sysRoleResOper.resourceId=c.resourceId  order by c.orderNum";
		
		Query query = sessionFactory.getCurrentSession().createQuery( hql);
		List<?> list = query.list();
		
		Map<Long, SysResource> resMap = new HashMap<Long, SysResource>();
		List<SysResource> rltList = new ArrayList<SysResource>();
		
		for ( int i=0; i<list.size(); i++) {
			Object[] objs = (Object[])list.get(i);

			SysResource resource = (SysResource) objs[0];
			SysRole role = (SysRole) objs[1];
			
			Long resourceId = resource.getResourceId();
			
			if ( !resMap.containsKey(resourceId)) {
				resMap.put(resourceId, resource);
				rltList.add(resource);
			} else {
				resource = resMap.get(resourceId);
			}
			
			resource.addRole(role);
		}
		
		return rltList;
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysResourceDAO#deleteSysResourceById(java.lang.Long[])
	 */
	@Override
	public void deleteSysResourceById(Long[] ids) {
		String hql = "delete from " + SysResource.class.getName() + " t where t.resourceId in (:resourceIds)";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("resourceIds", Arrays.asList(ids));
		states.add(keyValue);
		
		excuteHql(hql, states);
		
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysResourceDAO#findByStats(org.garden.sysadmin.dao.model.SysResource)
	 */
	@Override
	public List<SysResource> findByStats(SysResource res) {
		String hql = "from " + SysResource.class.getName() + " t where 1=1";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		
		if ( res.getResourceId() != null) {
			hql += " and t.resourceId=:resourceId";
			keyValue.put("resourceId", res.getResourceId());
		}
		if ( StringUtils.isNotEmpty(res.getResourceName())) {
			hql += " and t.resourceName=:resourceName";
			keyValue.put("resourceName", res.getResourceName());
		}
		if ( res.getParentId() != null) {
			hql += " and t.parentId=:parentId";
			keyValue.put("parentId", res.getParentId());
		}
		if ( StringUtils.isNotEmpty(res.getResourceType())) {
			hql += " and t.resourceType=:resourceType";
			keyValue.put("resourceType", res.getResourceType());
		}
		states.add(keyValue);
		
		hql += "  order by t.orderNum";
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysResourceDAO#getSysResourceByUserId(java.lang.Long)
	 */
	@Override
	public List<SysResource> getSysResourceByUserId(Long userId) {
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		
		String hql = "select t from " + SysRoleResOper.class.getName() + " a, " + SysUserRole.class.getName() + " b, " + SysResource.class.getName() + " t"
				+ " where b.sysUserRole.userId=:userId and b.sysUserRole.roleId=a.sysRoleResOper.roleId and t.resourceId=a.sysRoleResOper.resourceId";
		
		keyValue.put("userId", userId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}	
}