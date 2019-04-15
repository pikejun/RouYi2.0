-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门', '2000', '1', '/system/biScopeEnterpriseDepartment', 'C', '0', 'system:biScopeEnterpriseDepartment:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '企业部门菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('企业部门导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeEnterpriseDepartment:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
