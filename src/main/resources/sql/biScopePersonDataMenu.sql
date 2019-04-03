-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员', '3', '1', '/system/biScopePersonData', 'C', '0', 'system:biScopePersonData:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '人员菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员查询', @parentId, '1',  '#',  'F', '0', 'system:biScopePersonData:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员新增', @parentId, '2',  '#',  'F', '0', 'system:biScopePersonData:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员修改', @parentId, '3',  '#',  'F', '0', 'system:biScopePersonData:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员删除', @parentId, '4',  '#',  'F', '0', 'system:biScopePersonData:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员导入', @parentId, '5',  '#',  'F', '0', 'system:biScopePersonData:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员导出', @parentId, '5',  '#',  'F', '0', 'system:biScopePersonData:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
