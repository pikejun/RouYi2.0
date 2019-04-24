-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件', '2000', '1', '/system/biScopeWorkerSafeEventAttachments', 'C', '0', 'system:biScopeWorkerSafeEventAttachments:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '工人安全事件附件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人安全事件附件导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeWorkerSafeEventAttachments:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
