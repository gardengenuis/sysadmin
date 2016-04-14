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
 */package org.garden.sysadmin.dao;

import java.util.List;

import org.garden.dao.IDAO;
import org.garden.sysadmin.dao.model.SysDepartment;

/**
 * ISysDepartmentDAO.java
 *
 * @author codegen-garden ver. 0.0.1
 * create on Sat Sep 13 14:28:50 CST 2014
 */
public interface ISysDepartmentDAO extends IDAO<SysDepartment> {

	/**
	 * @param userCode
	 * @return
	 */
	public List<SysDepartment> findByUserId(Long userCode);

	/**
	 * @param userIds
	 */
	public void deleteDepartmentByIds(Long[] userIds);

	/**
	 * @param parentId
	 * @return
	 */
	public List<SysDepartment> getDepartmentByParentId(Long parentId);

	/**
	 * @param parentId
	 * @return
	 */
	public long getDepartmentByParentIdCount(Long parentId);

	/**
	 * @param userCode
	 * @return
	 */
	public List<SysDepartment> findByUserCode(String userCode);

	/**
	 * @param deptCode
	 * @return
	 */
	public SysDepartment getDepartmentByCode(String deptCode);

	/**
	 * @param ids
	 * @return
	 */
	public List<SysDepartment> getDepartmentByIds(Long[] ids);
}
