-- 任务表
CREATE TABLE [dbo].[quartz_task] (
[id] int NOT NULL IDENTITY(1,1) , -- 主键
[task_key] varchar(30) COLLATE Chinese_PRC_CI_AS NULL ,-- 任务key
[group_key] varchar(30) COLLATE Chinese_PRC_CI_AS NULL , -- 分组key
[trigger_key] varchar(30) COLLATE Chinese_PRC_CI_AS NULL , --触发器key
[message] varchar(50) COLLATE Chinese_PRC_CI_AS NULL ,-- 消息
[cron] varchar(20) COLLATE Chinese_PRC_CI_AS NULL ,-- cron 表达式
[onoff] varchar(10) COLLATE Chinese_PRC_CI_AS NULL DEFAULT ('OFF') , -- 页面开关
[communication] varchar(10) COLLATE Chinese_PRC_CI_AS NULL ,-- 通信方式 topic queue
CONSTRAINT [PK__quartz_t__3213E83F0B528E49] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO

DBCC CHECKIDENT(N'[dbo].[quartz_task]', RESEED, 25)
GO