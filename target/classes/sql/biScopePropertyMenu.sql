-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性', '2010', '1', '/system/biScopeProperty', 'C', '0', 'system:biScopeProperty:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '范围属性菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeProperty:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeProperty:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeProperty:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeProperty:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeProperty:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('范围属性导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeProperty:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
