-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据', '2030', '1', '/system/biReportInfo', 'C', '0', 'system:biReportInfo:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '汇报数据菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据查询', @parentId, '1',  '#',  'F', '0', 'system:biReportInfo:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据新增', @parentId, '2',  '#',  'F', '0', 'system:biReportInfo:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据修改', @parentId, '3',  '#',  'F', '0', 'system:biReportInfo:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据删除', @parentId, '4',  '#',  'F', '0', 'system:biReportInfo:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据导入', @parentId, '5',  '#',  'F', '0', 'system:biReportInfo:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('汇报数据导出', @parentId, '5',  '#',  'F', '0', 'system:biReportInfo:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
