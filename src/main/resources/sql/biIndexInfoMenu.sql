-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标', '2010', '1', '/system/biIndexInfo', 'C', '0', 'system:biIndexInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '指标菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标查询', @parentId, '1',  '#',  'F', '0', 'system:biIndexInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标新增', @parentId, '2',  '#',  'F', '0', 'system:biIndexInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标修改', @parentId, '3',  '#',  'F', '0', 'system:biIndexInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标删除', @parentId, '4',  '#',  'F', '0', 'system:biIndexInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标导入', @parentId, '5',  '#',  'F', '0', 'system:biIndexInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标导出', @parentId, '5',  '#',  'F', '0', 'system:biIndexInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
