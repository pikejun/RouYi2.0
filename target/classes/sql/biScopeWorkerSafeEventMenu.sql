-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件', '2000', '1', '/system/biScopeWorkerSafeEvent', 'C', '0', 'system:biScopeWorkerSafeEvent:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '工人安全事件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeWorkerSafeEvent:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
