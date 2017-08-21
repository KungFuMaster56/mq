-- 消息表 存储消息方便复用
CREATE TABLE [dbo].[quartz_message] (
[id] int NOT NULL IDENTITY(1,1) ,
[message_code] varchar(20) COLLATE Chinese_PRC_CI_AS NULL ,-- 消息编码
[message_name] varchar(20) COLLATE Chinese_PRC_CI_AS NULL ,-- 消息描述
CONSTRAINT [PK__quartz_m__3213E83F1C7D1A4B] PRIMARY KEY ([id])
)
ON [PRIMARY]
GO

DBCC CHECKIDENT(N'[dbo].[quartz_message]', RESEED, 6)
GO