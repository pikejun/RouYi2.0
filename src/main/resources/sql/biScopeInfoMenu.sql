-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围', '2010', '1', '/system/biScopeInfo', 'C', '0', 'system:biScopeInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '范围菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
