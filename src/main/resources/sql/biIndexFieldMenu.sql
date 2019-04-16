-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细', '2010', '1', '/system/biIndexField', 'C', '0', 'system:biIndexField:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '指标字段明细菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细查询', @parentId, '1',  '#',  'F', '0', 'system:biIndexField:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细新增', @parentId, '2',  '#',  'F', '0', 'system:biIndexField:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细修改', @parentId, '3',  '#',  'F', '0', 'system:biIndexField:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细删除', @parentId, '4',  '#',  'F', '0', 'system:biIndexField:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细导入', @parentId, '5',  '#',  'F', '0', 'system:biIndexField:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('指标字段明细导出', @parentId, '5',  '#',  'F', '0', 'system:biIndexField:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
