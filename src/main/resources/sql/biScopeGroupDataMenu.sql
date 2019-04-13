-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据', '2000', '1', '/system/biScopeGroupData', 'C', '0', 'system:biScopeGroupData:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '项目班组数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeGroupData:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeGroupData:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeGroupData:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeGroupData:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeGroupData:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('项目班组数据导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeGroupData:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
