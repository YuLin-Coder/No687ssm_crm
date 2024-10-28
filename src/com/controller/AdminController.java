package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Admin;
import com.service.AdminService;
import com.entity.Duty;
import com.service.DutyService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/admin", produces = "text/plain;charset=utf-8")
public class AdminController extends BaseController {
	// 注入Service 由于标签的存在 所以不需要getter setter
	@Autowired
	@Resource
	private AdminService adminService;
	@Autowired
	@Resource
	private DutyService dutyService;

	// 管理员登录 1 验证用户名是否存在 2 验证密码是否正确
	@RequestMapping("login.action")
	public String login() {
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Admin adminEntity = new Admin();
		adminEntity.setUsername(username);
		List<Admin> adminlist = this.adminService.getAdminByCond(adminEntity);
		if (adminlist.size() == 0) {
			this.getRequest().setAttribute("message", "用户名不存在");
			return "index";
		} else {
			Admin admin = adminlist.get(0);
			if (password.equals(admin.getPassword())) {
				this.getSession().setAttribute("adminid", admin.getAdminid());
				this.getSession().setAttribute("adminname", admin.getUsername());
				this.getSession().setAttribute("realname", admin.getRealname());
				this.getSession().setAttribute("dutyname", admin.getDutyname());
			} else {
				this.getRequest().setAttribute("message", "密码错误");
				return "index";
			}
		}
		return "main";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Admin admin = this.adminService.getAdminById(adminid);
		if (password.equals(admin.getPassword())) {
			admin.setPassword(repassword);
			this.adminService.updateAdmin(admin);
		} else {
			this.getRequest().setAttribute("message", "旧密码错误");
		}
		return "editpwd";
	}

	// 管理员退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.getSession().removeAttribute("adminid");
		this.getSession().removeAttribute("adminname");
		this.getSession().removeAttribute("realname");
		return "index";
	}

	// 准备添加数据
	@RequestMapping("createAdmin.action")
	public String createAdmin() {
		List<Duty> dutyList = this.dutyService.getAllDuty();
		this.getRequest().setAttribute("dutyList", dutyList);
		return "addadmin";
	}

	// 添加数据
	@RequestMapping("addAdmin.action")
	public String addAdmin(Admin admin) {
		admin.setAddtime(VeDate.getStringDateShort());
		this.adminService.insertAdmin(admin);
		return "redirect:/admin/createAdmin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteAdmin.action")
	public String deleteAdmin(String id) {
		this.adminService.deleteAdmin(id);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 批量删除数据
	@RequestMapping("deleteAdminByIds.action")
	public String deleteAdminByIds() {
		String[] ids = this.getRequest().getParameterValues("adminid");
		for (String adminid : ids) {
			this.adminService.deleteAdmin(adminid);
		}
		return "redirect:/admin/getAllAdmin.action";
	}

	// 更新数据
	@RequestMapping("updateAdmin.action")
	public String updateAdmin(Admin admin) {
		this.adminService.updateAdmin(admin);
		return "redirect:/admin/getAllAdmin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllAdmin.action")
	public String getAllAdmin(String number) {
		List<Admin> adminList = this.adminService.getAllAdmin();
		PageHelper.getPage(adminList, "admin", null, null, 10, number, this.getRequest(), null);
		return "listadmin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryAdminByCond.action")
	public String queryAdminByCond(String cond, String name, String number) {
		Admin admin = new Admin();
		if (cond != null) {
			if ("username".equals(cond)) {
				admin.setUsername(name);
			}
			if ("password".equals(cond)) {
				admin.setPassword(name);
			}
			if ("realname".equals(cond)) {
				admin.setRealname(name);
			}
			if ("sex".equals(cond)) {
				admin.setSex(name);
			}
			if ("birthday".equals(cond)) {
				admin.setBirthday(name);
			}
			if ("tel".equals(cond)) {
				admin.setTel(name);
			}
			if ("qq".equals(cond)) {
				admin.setQq(name);
			}
			if ("wechat".equals(cond)) {
				admin.setWechat(name);
			}
			if ("dutyname".equals(cond)) {
				admin.setDutyname(name);
			}
			if ("addtime".equals(cond)) {
				admin.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.adminService.getAdminByLike(admin), "admin", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "queryadmin";
	}

	// 按主键查询数据
	@RequestMapping("getAdminById.action")
	public String getAdminById(String id) {
		Admin admin = this.adminService.getAdminById(id);
		this.getRequest().setAttribute("admin", admin);
		List<Duty> dutyList = this.dutyService.getAllDuty();
		this.getRequest().setAttribute("dutyList", dutyList);
		return "editadmin";
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
