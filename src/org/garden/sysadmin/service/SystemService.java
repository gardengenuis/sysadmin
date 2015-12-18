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
package org.garden.sysadmin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.garden.dao.IDAO;
import org.garden.sysadmin.dao.ISysDepartmentDAO;
import org.garden.sysadmin.dao.ISysDictFieldDAO;
import org.garden.sysadmin.dao.ISysDictValueDAO;
import org.garden.sysadmin.dao.ISysOperationDAO;
import org.garden.sysadmin.dao.ISysResourceDAO;
import org.garden.sysadmin.dao.ISysRoleDAO;
import org.garden.sysadmin.dao.ISysRoleResOperDAO;
import org.garden.sysadmin.dao.ISysUserDAO;
import org.garden.sysadmin.dao.ISysUserDepartmentDAO;
import org.garden.sysadmin.dao.ISysUserRoleDAO;
import org.garden.sysadmin.dao.model.SysDepartment;
import org.garden.sysadmin.dao.model.SysDictValue;
import org.garden.sysadmin.dao.model.SysResource;
import org.garden.sysadmin.dao.model.SysRole;
import org.garden.sysadmin.dao.model.SysRoleResOper;
import org.garden.sysadmin.dao.model.SysUser;
import org.garden.sysadmin.dao.model.SysUserDepartment;
import org.garden.sysadmin.dao.model.SysUserRole;
import org.garden.utils.Pager;

/**
 * AdminSecurityService.java
 *
 * @author Garden
 * create on 2014年9月13日 下午2:44:35
 */
public class SystemService {
	private static Log log = LogFactory.getLog(SystemService.class);
	
	private IDAO dao;
	private ISysUserDAO sysUserDAO;
	private ISysDepartmentDAO sysDepartmentDAO;
	private ISysOperationDAO sysOperationDAO;
	private ISysResourceDAO sysResourceDAO;
	private ISysRoleDAO sysRoleDAO;
	private ISysRoleResOperDAO sysRoleResOperDAO;
	private ISysUserDepartmentDAO sysUserDepartmentDAO;
	private ISysUserRoleDAO sysUserRoleDAO;
	private ISysDictFieldDAO sysDictFieldDAO;
	private ISysDictValueDAO sysDictValueDAO;
	
	public void setSysDictValueDAO(ISysDictValueDAO sysDictValueDAO) {
		this.sysDictValueDAO = sysDictValueDAO;
	}

	/**
	 * @param sysDictFieldDAO the sysDictFieldDAO to set
	 */
	public void setSysDictFieldDAO(ISysDictFieldDAO sysDictFieldDAO) {
		this.sysDictFieldDAO = sysDictFieldDAO;
	}
	
	public List<SysResource>getSysResourceByUserId(Long userId) {
		return sysResourceDAO.getSysResourceByUserId(userId);
	}

	public SysUser getUserById(Long userId) {
		return this.sysUserDAO.findById(SysUser.class, userId);
	}
	public SysDepartment getDepartmentByCode(String deptCode) {
		return sysDepartmentDAO.getDepartmentByCode(deptCode);
	}
	
	public List<SysResource> getMenuResources() {
		
		SysResource res = new SysResource();
		res.setResourceType("1");
		
		return sysResourceDAO.findByStats(res);
	}
	public List<SysDictValue> getFieldValueByFieldCode(String fieldCode) {
		return sysDictFieldDAO.getFieldValueByFieldCode(fieldCode);
	}
	public SysDictValue getFieldValueByFieldId(Long dictId, String fieldValue) {
		return sysDictFieldDAO.getFieldValueByFieldId(dictId, fieldValue);
	}
	public SysUser getSysUserByUserCode( String userCode) {
		SysUser sysUser = sysUserDAO.findByUserCode(userCode);
		
		return sysUser;
	}
	
	public SysDictValue getFieldValueByFieldCode(String fieldCode, String fieldValue) {
		return sysDictFieldDAO.findFieldValueByFieldCode(fieldCode, fieldValue);
	}
	public List<SysUser> getSysUsers() {
		return sysUserDAO.findAll(SysUser.class);
	}
	
	public List<SysDictValue> getExceptDictValueList(Long dictId, String value) {
		return sysDictValueDAO.getExceptDictValueList( dictId, value);
	}
	
	public List<SysRole> getSysRoleByResourceId(Long resourceId) {
		return sysRoleDAO.findByResourceId(resourceId);
	}
	
	public List<SysRole> getSysRoles() {
		return sysRoleDAO.findAll(SysRole.class);
	}
	
	public List<SysDepartment> getDepartmentByUserId( Long userId) {
		return sysDepartmentDAO.findByUserId(userId);
	}
	
	public List<SysDepartment> getDepartmentByUserCode( String userCode) {
		return sysDepartmentDAO.findByUserCode(userCode);
	}
	
	public List<SysResource> getSysResources() {
		return sysResourceDAO.findAll(SysResource.class);
	}
	
	public List<SysResource> getSysResources(Pager pager) {
		return sysResourceDAO.findAll(SysResource.class, pager);
	}
	
	public List<SysDepartment> getDepartments() {
		return sysDepartmentDAO.findAll(SysDepartment.class);
	}
	
	public List<SysRole> getSysRoleByUserCode( String userCode) {
		List<SysRole> roleList = new ArrayList<SysRole>();
		SysUser sysUser = getSysUserByUserCode(userCode);
		
		if ( sysUser != null) {
			Long userId = sysUser.getUserId();
			
			roleList = sysRoleDAO.findByUserId(userId);
		}
		return roleList;
	}
	
	public List<SysRole> getSysRoleByUserId( Long userId) {
		return sysRoleDAO.findByUserId(userId);
	}
	
	public void saveSysUserDepartment( SysUserDepartment sysUserDepartment) {
		sysUserDepartmentDAO.save(sysUserDepartment);
	}
	
	public void removeAndSaveUserDepartment( Long userId, List<SysUserDepartment> sysUserDepartments) {
		sysUserDepartmentDAO.deleteByUserId(userId);
		for ( SysUserDepartment sysUserDepartment : sysUserDepartments) {
			sysUserDepartmentDAO.save(sysUserDepartment);
		}
	}
	
	public void removeAndSaveResourceRole( Long resourceId, List<SysRoleResOper> sysRoleResOpers) {
		sysRoleResOperDAO.deleteByResourceId(resourceId);
		for ( SysRoleResOper sysRoleResOper : sysRoleResOpers) {
			sysRoleResOperDAO.save(sysRoleResOper);
		}
	}
	
	public void removeAndSaveUserRole( Long userId, List<SysUserRole> sysUserRoles) {
		sysUserRoleDAO.deleteUserRoleByUserId(new Long[] {userId});
		for ( SysUserRole sysUserRole : sysUserRoles) {
			sysUserRoleDAO.save(sysUserRole);
		}
	}
	
	public void removeSysRole(Long[] roleIds) throws Exception {
		sysUserRoleDAO.deleteUserRoleByRoleId(roleIds);
		sysRoleDAO.deleteSysRoleById(roleIds);
		sysRoleResOperDAO.deleteSysRoleResOperByRoleId(roleIds);
	}
	
	public void removeSysUser(Long[] userIds) throws Exception {
		sysUserRoleDAO.deleteUserRoleByUserId(userIds);
		sysUserDAO.deleteSysUserById(userIds);
	}
	
	public void removeSysDepartments(Long[] ids) throws Exception {
		sysDepartmentDAO.deleteDepartmentByIds(ids);
	}
	
	public void removeSysDictValues(Long[] ids) throws Exception {
		sysDictValueDAO.deleteDictValueByIds(ids);
	}
	
	public void removeSysUsers(Long[] ids) throws Exception {
		sysUserDAO.deleteSysUserById(ids);
	}

	public void removeSysRoles(Long[] ids) throws Exception {
		sysRoleDAO.deleteSysRoleById(ids);
	}
	
	public void removeSysResources(Long[] ids) throws Exception {
		sysResourceDAO.deleteSysResourceById(ids);
	}
	
	public List<SysResource> getSysResourceByUserCode(String userCode) {
		List<SysResource> resourceList = new ArrayList<SysResource>();
		List<SysRole> roleList = getSysRoleByUserCode(userCode);
		
		if ( !roleList.isEmpty()) {
			Long[] roleIds = new Long[roleList.size()];
			
			for ( int i=0; i<roleList.size(); i++) {
				SysRole sysRole = roleList.get(i);
				
				roleIds[i] = sysRole.getRoleId();
			}
			
//			List<SysRoleResOper> resOprList = sysRoleResOperDAO.findByRoleId(roleIds);
			resourceList = sysResourceDAO.findByRoleId(roleIds);
		}
		
		return resourceList;
	}
	
	public List<Object> getObjects(String tableName, String[] columns, String state) {
		return dao.findObject(tableName, columns, state);
	}
	
	public List<SysDepartment> getDepartmentByParentId(Long parentId) {
		return sysDepartmentDAO.getDepartmentByParentId(parentId);
	}
	
	public long getDepartmentByParentIdCount(Long parentId) {
		return sysDepartmentDAO.getDepartmentByParentIdCount(parentId);
	}
	
	public List<SysResource> getAllResources() {
		return sysResourceDAO.findAll(SysResource.class);
	}
	
	public List<SysResource> getAllResourcesWithRoles() {
		return sysResourceDAO.findAllResourcesWithRoles();
	}
	
	public void saveSysDepartment(SysDepartment dept) {
		sysDepartmentDAO.saveOrUpdate(dept);
	}
	
	public void saveSysDictValue(SysDictValue sysDictValue) {
		sysDictValueDAO.saveOrUpdate(sysDictValue);
	}
	
	public void saveSysResource(SysResource sysResource) {
		sysResourceDAO.saveOrUpdate(sysResource);
	}
	
	public void saveSysRole(SysRole sysRole) {
		sysRoleDAO.saveOrUpdate(sysRole);
	}
	
	public void saveSysUser(SysUser sysUser) {
		sysUserDAO.saveOrUpdate(sysUser);
	}
	/**
	 * @param sysUserDAO the sysUserDAO to set
	 */
	public void setSysUserDAO(ISysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}
	/**
	 * @param sysDepartmentDAO the sysDepartmentDAO to set
	 */
	public void setSysDepartmentDAO(ISysDepartmentDAO sysDepartmentDAO) {
		this.sysDepartmentDAO = sysDepartmentDAO;
	}
	/**
	 * @param sysOperationDAO the sysOperationDAO to set
	 */
	public void setSysOperationDAO(ISysOperationDAO sysOperationDAO) {
		this.sysOperationDAO = sysOperationDAO;
	}
	/**
	 * @param sysResourceDAO the sysResourceDAO to set
	 */
	public void setSysResourceDAO(ISysResourceDAO sysResourceDAO) {
		this.sysResourceDAO = sysResourceDAO;
	}
	/**
	 * @param sysRoleDAO the sysRoleDAO to set
	 */
	public void setSysRoleDAO(ISysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}
	/**
	 * @param sysRoleResOperDAO the sysRoleResOperDAO to set
	 */
	public void setSysRoleResOperDAO(ISysRoleResOperDAO sysRoleResOperDAO) {
		this.sysRoleResOperDAO = sysRoleResOperDAO;
	}
	/**
	 * @param sysUserDepartmentDAO the sysUserDepartmentDAO to set
	 */
	public void setSysUserDepartmentDAO(ISysUserDepartmentDAO sysUserDepartmentDAO) {
		this.sysUserDepartmentDAO = sysUserDepartmentDAO;
	}
	/**
	 * @param sysUserRoleDAO the sysUserRoleDAO to set
	 */
	public void setSysUserRoleDAO(ISysUserRoleDAO sysUserRoleDAO) {
		this.sysUserRoleDAO = sysUserRoleDAO;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
}
