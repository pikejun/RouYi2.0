-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训', '2000', '1', '/system/biScopeTrainInfo', 'C', '0', 'system:biScopeTrainInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '培训菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeTrainInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeTrainInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeTrainInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeTrainInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
