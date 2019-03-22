INSERT INTO metric (id,created,name) VALUES( 1 , NOW(), 'speed');
INSERT INTO metric (id,created,name) VALUES( 2 , NOW(), 'height');
INSERT INTO metric (id,created,name) VALUES( 3 , NOW(), 'weight');


INSERT INTO metric_value (id,created_date,name,value,metric_id) VALUES( 1 , NOW(), 'speed' , 55.5 , 1);
INSERT INTO metric_value (id,created_date,name,value,metric_id) VALUES( 4 , NOW(), 'speed' , 78.5 , 1);
INSERT INTO metric_value (id,created_date,name,value,metric_id) VALUES( 2 , NOW(), 'height' , 55.5 , 2);
INSERT INTO metric_value (id,created_date,name,value,metric_id) VALUES( 3 , NOW(), 'weight' , 55.5 , 3);


