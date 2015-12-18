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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.garden.dao.hibernate.DAO;
import org.garden.sysadmin.dao.ISysUserDAO;
import org.garden.sysadmin.dao.model.SysUser;

/**
 * 
 * SysUserDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Sat Sep 13 14:34:12 CST 2014
 */
public class SysUserDAO extends DAO<SysUser> implements ISysUserDAO {
	private static Log log = LogFactory.getLog(SysUserDAO.class);
	
	public SysUser findByUserCode(String userCode) {
		String hql = "from " + SysUser.class.getName() + " t where t.userCode = :userCode";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("userCode", userCode);
		states.add(keyValue);
		
		
		List<SysUser> list = findByHql(hql, states);
		
		if ( !list.isEmpty()) {
			return list.get(0);
		} else if ( !list.isEmpty() && list.size() > 0) {
			log.error("more than one user is named with usecode[" + userCode + "]");
			return null;
		} else {
			log.warn("cannot find any user with usecode[" + userCode + "]");
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.garden.sysadmin.dao.ISysUserDAO#deleteSysUserById(java.lang.Long[])
	 */
	@Override
	public void deleteSysUserById(Long[] userIds) {
		String hql = "delete from " + SysUser.class.getName() + " t where t.userId in (:userIds)";
		
		List<Map<String, Object>> states = new ArrayList<Map<String,Object>>();
		Map<String, Object> keyValue = new HashMap<String, Object>();
		keyValue.put("userIds", Arrays.asList(userIds));
		states.add(keyValue);
		
		excuteHql(hql, states);
		
	}
}