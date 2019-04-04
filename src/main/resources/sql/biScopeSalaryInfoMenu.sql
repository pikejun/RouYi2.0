-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资', '3', '1', '/system/biScopeSalaryInfo', 'C', '0', 'system:biScopeSalaryInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '工资菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeSalaryInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeSalaryInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeSalaryInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeSalaryInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeSalaryInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工资导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeSalaryInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
