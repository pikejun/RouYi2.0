-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件', '2000', '1', '/system/biScopeSafeEvent', 'C', '0', 'system:biScopeSafeEvent:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '安全事件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeSafeEvent:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeSafeEvent:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeSafeEvent:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeSafeEvent:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeSafeEvent:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('安全事件导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeSafeEvent:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
