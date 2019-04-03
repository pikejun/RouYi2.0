-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权', '3', '1', '/system/biScopeComplaintInfo', 'C', '0', 'system:biScopeComplaintInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '维权菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeComplaintInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeComplaintInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeComplaintInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeComplaintInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
