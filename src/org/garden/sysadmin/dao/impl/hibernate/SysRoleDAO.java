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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.garden.dao.hibernate.DAO;
import org.garden.sysadmin.dao.ISysRoleDAO;
import org.garden.sysadmin.dao.model.SysRole;
import org.garden.sysadmin.dao.model.SysRoleResOper;
import org.garden.sysadmin.dao.model.SysUserRole;

/**
 * 
 * SysRoleDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Sat Sep 13 14:34:12 CST 2014
 */
public class SysRoleDAO extends DAO<SysRole> implements ISysRoleDAO {

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysRoleDAO#findByUserCode(java.lang.String)
	 */
	@Override
	public List<SysRole> findByUserId(Long userId) {
		String hql = "select a from " + SysRole.class.getName() + " a, " + SysUserRole.class.getName() + " b where a.roleId=b.sysUserRole.roleId and b.sysUserRole.userId=:userId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("userId", userId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysRoleDAO#deleteSysRoleById(java.lang.Long[])
	 */
	@Override
	public void deleteSysRoleById(Long[] roleIds) {
		String hql = "delete from " + SysRole.class.getName() + " t where t.roleId in (:roleIds)";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("roleIds", Arrays.asList(roleIds));
		states.add(keyValue);
		
		excuteHql(hql, states);
		
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysRoleDAO#findByResourceId(java.lang.Long)
	 */
	@Override
	public List<SysRole> findByResourceId(Long resourceId) {
		String hql = "select a from " + SysRole.class.getName() + " a, " + SysRoleResOper.class.getName() + " b where a.roleId=b.sysRoleResOper.roleId and b.sysRoleResOper.resourceId=:resourceId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("resourceId", resourceId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysRoleDAO#getSysRolesByDepartIds(java.lang.Long[])
	 */
	@Override
	public List<SysRole> getSysRolesByDepartIds(Long[] ids) {
		List<SysRole> rlt = new ArrayList<SysRole>();
		String sql = "select t.ROLE_ID, t.ROLE_CODE, t.ROLE_NAME, t.STATUS from SYS_ROLE t left join SYS_ROLE_DEPARTMENT a on a.ROLE_ID=t.ROLE_ID WHERE a.DEPART_ID in (";
		String idStr = "";
		for( int i=0; i<ids.length; i++) {
			idStr += ids[i];
			if( i < ids.length - 1) {
				idStr += ",";
			}
		}
		sql += idStr + ") OR a.DEPART_ID IS NULL";
		
		List list = findBySql(sql);
		
		for( Object obj : list) {
			Object[] objs = (Object[]) obj;
			BigInteger roleId = (BigInteger)objs[0];
			String roleCode = (String) objs[1];
			String roleName = (String) objs[2];
			String status = (String) objs[3];
			
			SysRole role = new SysRole();
			role.setRoleId(roleId.longValue());
			role.setRoleCode(roleCode);
			role.setRoleName(roleName);
			role.setStatus(status);
			
			rlt.add(role);
		}
		
		return rlt;
	}

}