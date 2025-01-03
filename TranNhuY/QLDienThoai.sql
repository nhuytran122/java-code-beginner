USE [QLDienThoai]
GO
/****** Object:  Table [dbo].[tbl_DTCoDinh]    Script Date: 03/06/2023 04:09:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_DTCoDinh](
	[maDt] [nvarchar](50) NOT NULL,
	[tenDt] [nvarchar](50) NULL,
	[hangSx] [nvarchar](50) NULL,
	[gia] [numeric](18, 0) NULL,
 CONSTRAINT [PK_tbl_DTCoDinh] PRIMARY KEY CLUSTERED 
(
	[maDt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_DTDiDong]    Script Date: 03/06/2023 04:09:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_DTDiDong](
	[maDt] [nvarchar](50) NOT NULL,
	[tenDt] [nvarchar](50) NULL,
	[hangSx] [nvarchar](50) NULL,
	[gia] [numeric](18, 0) NULL,
	[timeBaohanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbl_DTDiDong] PRIMARY KEY CLUSTERED 
(
	[maDt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
