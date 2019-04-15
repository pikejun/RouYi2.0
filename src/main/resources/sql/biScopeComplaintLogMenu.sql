-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志', '2000', '1', '/system/biScopeComplaintLog', 'C', '0', 'system:biScopeComplaintLog:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '维权日志菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeComplaintLog:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeComplaintLog:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeComplaintLog:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeComplaintLog:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintLog:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintLog:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
