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

import org.garden.dao.hibernate.DAO;
import org.garden.sysadmin.dao.ISysDepartmentDAO;
import org.garden.sysadmin.dao.model.SysDepartment;
import org.garden.sysadmin.dao.model.SysRoleDepartment;
import org.garden.sysadmin.dao.model.SysUser;
import org.garden.sysadmin.dao.model.SysUserDepartment;

/**
 * 
 * SysDepartmentDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Sat Sep 13 14:34:12 CST 2014
 */
public class SysDepartmentDAO extends DAO<SysDepartment> implements ISysDepartmentDAO {

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#findByUserCode(java.lang.String)
	 */
	@Override
	public List<SysDepartment> findByUserId(Long userId) {
		String hql = "select a from " + SysDepartment.class.getName() + " a, " + SysUserDepartment.class.getName() + " b where a.departId=b.sysUserDepartment.departId and b.sysUserDepartment.userId = :userId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("userId", userId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#deleteDepartmentById(java.lang.Long[])
	 */
	@Override
	public void deleteDepartmentByIds(Long[] departIds) {
		String hql = "delete from " + SysDepartment.class.getName() + " t where t.departId in (:departIds)";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("departIds", Arrays.asList(departIds));
		states.add(keyValue);
		
		excuteHql(hql, states);
		
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#getDepartmentByParentId(java.lang.Long)
	 */
	@Override
	public List<SysDepartment> getDepartmentByParentId(Long parentId) {
		String hql = "from " + SysDepartment.class.getName() + " t where t.parentId=:parentId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("parentId", parentId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#getDepartmentByParentIdCount(java.lang.Long)
	 */
	@Override
	public long getDepartmentByParentIdCount(Long parentId) {
		String hql = "select count(1) from " + SysDepartment.class.getName() + " t where t.parentId=:parentId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("parentId", parentId);
		states.add(keyValue);
		
		return findCount(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#findByUserCode(java.lang.String)
	 */
	@Override
	public List<SysDepartment> findByUserCode(String userCode) {
		String hql = "select a from " + SysDepartment.class.getName() + " a, " + SysUserDepartment.class.getName() + " b, " + SysUser.class.getName() + " c where a.departId=b.sysUserDepartment.departId and b.sysUserDepartment.userId=c.userId and c.userCode=:userCode";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("userCode", userCode);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#getDepartmentByCode(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysUserDepartmentDAO#getDepartmentByCode(java.lang.String)
	 */
	@Override
	public SysDepartment getDepartmentByCode(String deptCode) {
		String hql = "from " + SysDepartment.class.getName() + " t where t.departCode=:departCode";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("departCode", deptCode);
		states.add(keyValue);
		
		List<SysDepartment> depts = findByHql(hql, states);
		
		if (depts.isEmpty()) {
			return null;
		} else {
			return depts.get(0);
		}
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#getDepartmentByIds(java.lang.Long[])
	 */
	@Override
	public List<SysDepartment> getDepartmentByIds(Long[] ids) {
		String hql = "from " + SysDepartment.class.getName() + " t where t.departId in (:ids) order by t.departId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("ids", Arrays.asList(ids));
		states.add(keyValue);
		
		return findByHql(hql, states);
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysDepartmentDAO#findByRoleId(java.lang.Long)
	 */
	@Override
	public List<SysDepartment> findByRoleId(Long roleId) {
		String hql = "select a from " + SysDepartment.class.getName() + " a, " + SysRoleDepartment.class.getName() + " b where a.departId=b.sysRoleDepartment.departId and b.sysRoleDepartment.roleId = :roleId";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("roleId", roleId);
		states.add(keyValue);
		
		return findByHql(hql, states);
	}
}