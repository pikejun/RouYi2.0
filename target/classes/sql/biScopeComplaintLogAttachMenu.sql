-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件', '2000', '1', '/system/biScopeComplaintLogAttach', 'C', '0', 'system:biScopeComplaintLogAttach:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '维权日志附件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('维权日志附件导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeComplaintLogAttach:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
