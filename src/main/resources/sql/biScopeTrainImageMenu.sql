-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片', '3', '1', '/system/biScopeTrainImage', 'C', '0', 'system:biScopeTrainImage:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '培训图片菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeTrainImage:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeTrainImage:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeTrainImage:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeTrainImage:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainImage:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训图片导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainImage:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
