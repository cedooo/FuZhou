
ALTER TABLE `t_schema`
	CHANGE COLUMN `vc_schema_data` `vc_schema_data` LONGTEXT NULL DEFAULT NULL AFTER `dt_schema_add_time`;