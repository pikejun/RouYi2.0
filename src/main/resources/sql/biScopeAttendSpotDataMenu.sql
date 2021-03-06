-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点', '3', '1', '/system/biScopeAttendSpotData', 'C', '0', 'system:biScopeAttendSpotData:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '考勤点菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeAttendSpotData:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeAttendSpotData:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeAttendSpotData:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeAttendSpotData:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeAttendSpotData:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('考勤点导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeAttendSpotData:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
