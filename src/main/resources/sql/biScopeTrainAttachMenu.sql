-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件', '3', '1', '/system/biScopeTrainAttach', 'C', '0', 'system:biScopeTrainAttach:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '培训附件菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件查询', @parentId, '1',  '#',  'F', '0', 'system:biScopeTrainAttach:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件新增', @parentId, '2',  '#',  'F', '0', 'system:biScopeTrainAttach:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件修改', @parentId, '3',  '#',  'F', '0', 'system:biScopeTrainAttach:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件删除', @parentId, '4',  '#',  'F', '0', 'system:biScopeTrainAttach:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件导入', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainAttach:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('培训附件导出', @parentId, '5',  '#',  'F', '0', 'system:biScopeTrainAttach:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
