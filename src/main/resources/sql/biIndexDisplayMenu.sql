-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示', '2010', '1', '/system/biIndexDisplay', 'C', '0', 'system:biIndexDisplay:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '指标展示菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示查询', @parentId, '1',  '#',  'F', '0', 'system:biIndexDisplay:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示新增', @parentId, '2',  '#',  'F', '0', 'system:biIndexDisplay:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示修改', @parentId, '3',  '#',  'F', '0', 'system:biIndexDisplay:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示删除', @parentId, '4',  '#',  'F', '0', 'system:biIndexDisplay:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示导入', @parentId, '5',  '#',  'F', '0', 'system:biIndexDisplay:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标展示导出', @parentId, '5',  '#',  'F', '0', 'system:biIndexDisplay:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
