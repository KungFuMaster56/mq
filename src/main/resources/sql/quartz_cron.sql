-- 存储 cron 表达式
CREATE TABLE [dbo].[quartz_cron] (
[id] int NOT NULL IDENTITY(1,1) ,
[cron] varchar(30) COLLATE Chinese_PRC_CI_AS NULL ,-- cron表达式
[cron_name] varchar(30) COLLATE Chinese_PRC_CI_AS NULL ,-- cron 描述
CONSTRAINT [PK__quartz_c__3213E83F204DAB2F] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO

DBCC CHECKIDENT(N'[dbo].[quartz_cron]', RESEED, 3)
GO