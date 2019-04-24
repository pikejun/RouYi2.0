-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程', '2000', '1', '/system/biScopeRootProjectData', 'C', '0', 'system:biScopeRootProjectData:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '总工程菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeRootProjectData:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeRootProjectData:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeRootProjectData:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeRootProjectData:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeRootProjectData:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('总工程导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeRootProjectData:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
