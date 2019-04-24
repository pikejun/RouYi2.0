-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细', '2020', '1', '/system/biTemplateIndexProperty', 'C', '0', 'system:biTemplateIndexProperty:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '模板指标属性明细菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细查询', @parentId, '1',  '#',  'F', '0', 'system:biTemplateIndexProperty:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细新增', @parentId, '2',  '#',  'F', '0', 'system:biTemplateIndexProperty:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细修改', @parentId, '3',  '#',  'F', '0', 'system:biTemplateIndexProperty:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细删除', @parentId, '4',  '#',  'F', '0', 'system:biTemplateIndexProperty:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细导入', @parentId, '5',  '#',  'F', '0', 'system:biTemplateIndexProperty:import',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('模板指标属性明细导出', @parentId, '5',  '#',  'F', '0', 'system:biTemplateIndexProperty:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
