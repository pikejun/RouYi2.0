-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员', '2000', '1', '/system/biScopeProjectAdmin', 'C', '0', 'system:biScopeProjectAdmin:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '项目管理员菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeProjectAdmin:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeProjectAdmin:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeProjectAdmin:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeProjectAdmin:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeProjectAdmin:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目管理员导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeProjectAdmin:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
