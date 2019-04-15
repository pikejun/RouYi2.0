-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志', '2000', '1', '/system/biScopeTrainInfoLog', 'C', '0', 'system:biScopeTrainInfoLog:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '工人培训日志菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeTrainInfoLog:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeTrainInfoLog:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeTrainInfoLog:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeTrainInfoLog:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainInfoLog:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('工人培训日志导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainInfoLog:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
