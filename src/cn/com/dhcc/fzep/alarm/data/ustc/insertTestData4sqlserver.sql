/* 插入一定数量的记录*/
declare @i int
set @i=1
while @i<30
begin 
insert into tb_alarm_detail(DevId, AlarmLevel,AlarmContent, AlarmLocation, AlarmTime,state) values(@i,@i%5, 'tesst', @i,DATEADD(second,@i, getdate()) ,1)
set @i=@i+1
end