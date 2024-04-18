-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 11, 2024 lúc 10:02 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `javashop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_account`
--

CREATE TABLE `tbl_account` (
  `id_account` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_account`
--

INSERT INTO `tbl_account` (`id_account`, `username`, `password`, `status`) VALUES
('EM00', 'admin', '21232f297a57a5a743894a0e4a801fc3', 1),
('EM01', 'xuanthang', '4c5743a8dd37febf93286c0308800de0', 1),
('EM02', 'giahao', '5b3aa86f2ab97e949b04aeace3371a44', 1),
('EM03', 'duykhuong', '4e70875f8cde197f744ca41998fb120c', 1),
('EM04', 'minhhuu', 'd43a03baf78ace114191bd8d60d496be', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_brand`
--

CREATE TABLE `tbl_brand` (
  `id_brand` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_brand`
--

INSERT INTO `tbl_brand` (`id_brand`, `name`) VALUES
('BR1640534951452', 'CoolMate'),
('BR1640534998209', 'BJ'),
('BR1640621183156', 'Ivy Moda'),
('BR1640621183166', 'Elise'),
('BR1640621183176', 'Canifa'),
('BR1640621183186', 'BK');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_category`
--

CREATE TABLE `tbl_category` (
  `id_category` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_category`
--

INSERT INTO `tbl_category` (`id_category`, `name`) VALUES
('CA01', 'Áo'),
('CA02', 'Quần');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_categorychild`
--

CREATE TABLE `tbl_categorychild` (
  `id_categorychild` varchar(50) NOT NULL,
  `id_category` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_categorychild`
--

INSERT INTO `tbl_categorychild` (`id_categorychild`, `id_category`, `name`) VALUES
('CC1640534755791', 'CA02', 'Quần dài'),
('CC1640534755792', 'CA02', 'Quần short'),
('CC1640534755793', 'CA02', 'Quần jeans'),
('CC1640534755794', 'CA02', 'Quần kaki'),
('CC1640534755795', 'CA02', 'Quần thể thao'),
('CC1640934361882', 'CA01', 'Áo thun'),
('CC1640934361883', 'CA01', 'Áo sơ mi'),
('CC1640934361884', 'CA01', 'Áo lao động'),
('CC1640942441985', 'CA01', 'Áo học sinh'),
('CC1640942441986', 'CA01', 'Áo khoác'),
('CC1640942441989', 'CA01', 'Áo thể thao');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_customer`
--

CREATE TABLE `tbl_customer` (
  `id_customer` varchar(50) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `createdate` date NOT NULL,
  `point` int(11) NOT NULL DEFAULT 0,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_customer`
--

INSERT INTO `tbl_customer` (`id_customer`, `fullname`, `createdate`, `point`, `email`, `address`, `phone`) VALUES
('CU1640535729418', 'Trần Minh Nghĩa', '2024-01-26', 4115, 'nghia@gmail.com', 'TP.HCM', '0858347401'),
('CU1640621278509', 'Huỳnh Minh Hưng', '2024-02-27', 5130, 'hung0201@gmail.com', 'Bình Phước', '0341202891'),
('CU1640759442598', 'La Chí Bàng', '2024-03-29', 3940, 'chibang04@gmaill.com', 'Bình Dương', '0861121354'),
('CU1640759924238', 'Trương Tấn Đạt', '2024-01-29', 3050, 'datzero9@gmail.com', 'TP.HCM', '0901121601'),
('CU1640760118459', 'Nguyễn Thị Thu', '2024-02-29', 800, 'thusgu@gmail.com', 'Hà Nội', '0312100911'),
('CU1640760118460', 'Nguyễn Ánh Ngọc', '2024-03-05', 400, 'ngocnguyen@gmail.com', 'TP.HCM', '0821077113'),
('CU1640760118461', 'Lê Thị Huệ', '2024-03-10', 350, 'huehoa1203@gmail.com', 'TP.HCM', '0331560911');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_employee`
--

CREATE TABLE `tbl_employee` (
  `id_employee` varchar(50) NOT NULL,
  `id_position` varchar(50) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `image` varchar(20) NOT NULL,
  `cmnd` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_employee`
--

INSERT INTO `tbl_employee` (`id_employee`, `id_position`, `fullname`, `birthday`, `address`, `phone`, `email`, `image`, `cmnd`, `gender`) VALUES
('EM00', 'ad', 'Admin', '2000-01-01', 'TP.HCM', '0313565607', 'admin20@gmail.com', 'abc', '00000000', 'Nam'),
('EM01', 'p1', 'Xuân Thắng', '2004-06-22', 'Bình Thuận', '0388121009', 'xuanthang247.0404@gmail.com', 'abc', '261566121', 'Nam'),
('EM02', 'p3', 'Gia Hào', '2004-04-04', 'Đồng Nai', '0933814691', 'giahao2k4@gmail.com', 'abc', '261566951', 'Nam'),
('EM03', 'p3', 'Duy Khương', '2004-07-29', 'An Giang', '0912312444', 'duykhuong@gmail.com', 'abc', '102111343', 'Nam'),
('EM04', 'p2', 'Minh Hữu', '2004-07-21', 'Lâm Đồng', '0869160455', 'minhhhu@gmail.com', 'abc', '450123100', 'Nam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id_order` varchar(50) NOT NULL,
  `id_customer` varchar(50) NOT NULL,
  `id_voucher` varchar(50) NOT NULL,
  `id_employee` varchar(50) NOT NULL,
  `totalprice` float NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_order`
--

INSERT INTO `tbl_order` (`id_order`, `id_customer`, `id_voucher`, `id_employee`, `totalprice`, `date`) VALUES
('OR1640619547251', 'CU1640535729418', 'VC1640534625092', 'EM03', 268000, '2024-02-27'),
('OR1640621277398', 'CU1640621278509', 'VC1640534625092', 'EM01', 272000, '2024-02-27'),
('OR1640708447483', 'CU1640621278509', 'VC1640534625092', 'EM01', 320000, '2024-02-28'),
('OR1640710299343', 'CU1640621278509', 'VC1640534596143', 'EM01', 340000, '2024-02-28'),
('OR1640710386668', 'CU1640535729418', 'VC1640534596143', 'EM01', 600000, '2024-02-28'),
('OR1640710873732', 'CU1640535729418', 'VC1640534596143', 'EM01', 400000, '2024-02-29'),
('OR1640711007384', 'CU1640535729418', 'VC1640534596143', 'EM01', 600000, '2024-02-29'),
('OR1640711063411', 'CU1640535729418', 'VC1640534596143', 'EM02', 400000, '2024-02-29'),
('OR1640711198470', 'CU1640621278509', 'VC1640534596143', 'EM02', 600000, '2024-02-29'),
('OR1640711419372', 'CU1640621278509', 'VC1640534596143', 'EM02', 300000, '2024-02-29'),
('OR1640712353902', 'CU1640621278509', 'VC1640534596143', 'EM02', 340000, '2024-02-29'),
('OR1640712421065', 'CU1640621278509', 'VC1640534596143', 'EM03', 400000, '2024-02-29'),
('OR1640712594523', 'CU1640535729418', 'VC1640534596143', 'EM03', 300000, '2024-03-20'),
('OR1640745275103', 'CU1640621278509', 'VC1640534596143', 'EM03', 600000, '2024-03-20'),
('OR1640745415690', 'CU1640621278509', 'VC1640534596143', 'EM03', 400000, '2024-03-20'),
('OR1640745656670', 'CU1640621278509', 'VC1640534596143', 'EM02', 170000, '2024-03-21'),
('OR1640748301866', 'CU1640621278509', 'VC1640534596143', 'EM03', 300000, '2024-03-21'),
('OR1640748998798', 'CU1640621278509', 'VC1640534596143', 'EM03', 340000, '2024-03-21'),
('OR1640749143193', 'CU1640621278509', 'VC1640534596143', 'EM03', 600000, '2024-03-22'),
('OR1640751113962', 'CU1640535729418', 'VC1640534596143', 'EM03', 600000, '2024-03-22'),
('OR1640759378745', 'CU1640535729418', 'VC1640534596143', 'EM03', 500000, '2024-03-22'),
('OR1640759473345', 'CU1640759442598', 'VC1640534596143', 'EM03', 340000, '2024-03-22'),
('OR1640759922872', 'CU1640759924238', 'VC1640534596143', 'EM03', 200000, '2024-03-23'),
('OR1640760070611', 'CU1640759442598', 'VC1640534596143', 'EM02', 170000, '2024-03-23'),
('OR1640760099069', 'CU1640759924238', 'VC1640534596143', 'EM02', 600000, '2024-03-23'),
('OR1640760117350', 'CU1640760118459', 'VC1640534625092', 'EM02', 640000, '2024-03-23'),
('OR1640933648609', 'CU1640759924238', 'VC1640534625092', 'EM01', 320000, '2024-03-23'),
('OR1640942357617', 'CU1640759442598', 'VC1640534625092', 'EM01', 616000, '2024-03-23'),
('OR1711438057336', 'CU1640760118461', 'VC1640534596143', 'EM01', 150000, '2024-03-26'),
('OR1712821674140', 'CU1640535729418', 'VC1640534596143', 'EM01', 880000, '2024-04-11'),
('OR1712821722052', 'CU1640759442598', 'VC1640534625092', 'EM01', 1056000, '2024-04-11'),
('OR1712821852773', 'CU1640759442598', 'VC1640534596143', 'EM03', 1340000, '2024-04-11'),
('OR1712821958089', 'CU1640759924238', 'VC1640534596143', 'EM02', 1850000, '2024-04-11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_order_item`
--

CREATE TABLE `tbl_order_item` (
  `id_order` varchar(50) NOT NULL,
  `id_product` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_order_item`
--

INSERT INTO `tbl_order_item` (`id_order`, `id_product`, `quantity`, `price`) VALUES
('OR1640619547251', 'PR1640619150209', 1, 135000),
('OR1640619547251', 'PR1640619188733', 1, 200000),
('OR1640621277398', 'PR1640621209542', 2, 170000),
('OR1640708447483', 'PR1640619188733', 2, 200000),
('OR1640710299343', 'PR1640621209542', 2, 170000),
('OR1640710386668', 'PR1640621183186', 2, 300000),
('OR1640710873732', 'PR1640619188733', 2, 200000),
('OR1640711007384', 'PR1640621183186', 2, 300000),
('OR1640711063411', 'PR1640619188733', 2, 200000),
('OR1640711198470', 'PR1640621183186', 2, 300000),
('OR1640711419372', 'PR1640621183186', 1, 300000),
('OR1640712353902', 'PR1640621209542', 2, 170000),
('OR1640712421065', 'PR1640619188733', 2, 200000),
('OR1640712594523', 'PR1640621183186', 1, 300000),
('OR1640745275103', 'PR1640621183186', 2, 300000),
('OR1640745415690', 'PR1640619188733', 2, 200000),
('OR1640745656670', 'PR1640621209542', 1, 170000),
('OR1640748301866', 'PR1640621183186', 1, 300000),
('OR1640748998798', 'PR1640621209542', 2, 170000),
('OR1640749143193', 'PR1640621183186', 2, 300000),
('OR1640751113962', 'PR1640621183186', 2, 300000),
('OR1640759473345', 'PR1640621209542', 2, 170000),
('OR1640759922872', 'PR1640619188733', 1, 200000),
('OR1640760070611', 'PR1640621209542', 1, 170000),
('OR1640760099069', 'PR1640621183186', 2, 300000),
('OR1640760117350', 'PR1640619188733', 1, 200000),
('OR1640760117350', 'PR1640621183186', 2, 300000),
('OR1640933648609', 'PR1640619188733', 2, 200000),
('OR1640942357617', 'PR1640619188733', 1, 200000),
('OR1640942357617', 'PR1640621183186', 2, 285000),
('OR1711438057336', 'PR1640942292840', 1, 150000),
('OR1712821674140', 'PR1640942292220', 4, 220000),
('OR1712821722052', 'PR1640619150209', 2, 150000),
('OR1712821722052', 'PR1640942292220', 3, 220000),
('OR1712821722052', 'PR1640942292827', 3, 120000),
('OR1712821852773', 'PR1640619150209', 2, 150000),
('OR1712821852773', 'PR1640942292220', 2, 220000),
('OR1712821852773', 'PR1640942292840', 4, 150000),
('OR1712821958089', 'PR1640619150209', 5, 150000),
('OR1712821958089', 'PR1640942292220', 5, 220000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_permission`
--

CREATE TABLE `tbl_permission` (
  `id_permission` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_permission`
--

INSERT INTO `tbl_permission` (`id_permission`, `name`) VALUES
('PE01', 'Quản lý bán hàng'),
('PE02', 'Quản lý sản phẩm'),
('PE03', 'Quản lý danh mục'),
('PE04', 'Quản lý nhà cung cấp'),
('PE05', 'Quản lý nhập hàng'),
('PE06', 'Quản lý khuyến mãi'),
('PE07', 'Quản lý hóa đơn'),
('PE08', 'Quản lý nhân viên'),
('PE09', 'Quản lý khách hàng'),
('PE10', 'Quản lý quyền'),
('PE11', 'Quản lý thống kê');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_position`
--

CREATE TABLE `tbl_position` (
  `id_position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_position`
--

INSERT INTO `tbl_position` (`id_position`, `name`) VALUES
('ad', 'Admin'),
('p1', 'Quản lý'),
('p2', 'Nhân viên kho'),
('p3', 'Nhân viên kinh doanh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_pos_permission`
--

CREATE TABLE `tbl_pos_permission` (
  `id_permission` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_pos_permission`
--

INSERT INTO `tbl_pos_permission` (`id_permission`, `id_position`) VALUES
('PE01', 'p1'),
('PE01', 'p3'),
('PE02', 'p1'),
('PE02', 'p3'),
('PE03', 'p1'),
('PE03', 'p3'),
('PE04', 'p1'),
('PE05', 'p1'),
('PE05', 'p2'),
('PE06', 'p1'),
('PE06', 'p3'),
('PE07', 'p1'),
('PE07', 'p3'),
('PE08', 'ad'),
('PE08', 'p1'),
('PE09', 'p1'),
('PE09', 'p3'),
('PE10', 'ad'),
('PE11', 'p1'),
('PE11', 'p3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_product`
--

CREATE TABLE `tbl_product` (
  `id_product` varchar(50) NOT NULL,
  `id_brand` varchar(50) NOT NULL,
  `id_categorychild` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `image` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_product`
--

INSERT INTO `tbl_product` (`id_product`, `id_brand`, `id_categorychild`, `name`, `quantity`, `price`, `image`, `status`) VALUES
('PR1640619150209', 'BR1640534951452', 'CC1640934361882', 'Áo thun Cool', 50, 150000, '10.jpg', 1),
('PR1640619188733', 'BR1640534998209', 'CC1640934361883', 'Áo sơ mi BJ', 34, 200000, '25.jpg', 1),
('PR1640621183186', 'BR1640621183186', 'CC1640534755791', 'Quần dài BK', 79, 300000, '35.jpg', 1),
('PR1640621209542', 'BR1640534951452', 'CC1640934361883', 'Áo sơ mi hoa hòe', 18, 170000, '38.jpg', 1),
('PR1640942292220', 'BR1640621183156', 'CC1640534755793', 'Quần jeans', 23, 220000, '13.jpg', 1),
('PR1640942292827', 'BR1640621183176', 'CC1640534755792', 'Quần short Canifa', 22, 120000, '12.jpg', 1),
('PR1640942292840', 'BR1640621183166', 'CC1640534755794', 'Quần kaki Elise', 45, 150000, '14.jpg', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_product_sale`
--

CREATE TABLE `tbl_product_sale` (
  `id_product` varchar(50) NOT NULL,
  `salepercent` float NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_product_sale`
--

INSERT INTO `tbl_product_sale` (`id_product`, `salepercent`, `startdate`, `enddate`) VALUES
('PR1640619150209', 0.1, '2024-01-26', '2024-04-01'),
('PR1640621183186', 0.2, '2024-04-10', '2024-04-15'),
('PR1640942292840', 0.3, '2024-04-20', '2024-04-22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_supplier`
--

CREATE TABLE `tbl_supplier` (
  `id_supplier` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_supplier`
--

INSERT INTO `tbl_supplier` (`id_supplier`, `name`, `address`) VALUES
('SU1696419239320', 'Công ty Cổ Phần May Phú Thịnh', '13A, Tống Văn Trân, Phường 5, Quận 11 TP. Hồ Chí Minh'),
('SU1696419239321', 'Công ty TNHH May Trần Trúc', '292 - 294 Nguyễn Văn Luông, P. 12, Q. 6, TP. Hồ Chí Minh'),
('SU1696419239322', 'Tập Đoàn Dệt May Việt Nam', 'Số 10 Nguyễn Huệ, Q. 1, TP. Hồ Chí Minh'),
('SU1696419239323', 'Việt Hùng - Cơ Sở May Việt Hùng', '2385/87/21 Phạm Thế Hiển, P. 6, Q. 8, TP. Hồ Chí Minh'),
('SU1696419239324', 'Xưởng May Mặc Kim Hải', 'Số 725/3B, Khóm Tây Khánh 5, P. Mỹ Hòa, TP. Long Xuyên, An Giang'),
('SU1696419239325', 'Công Ty TNHH MTV Dệt May Phương Lan', 'Thôn Vĩnh Trị, Xã Yên Trị, Huyện ý Yên, Nam Định');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_voucher`
--

CREATE TABLE `tbl_voucher` (
  `id_voucher` varchar(50) NOT NULL,
  `code` varchar(10) NOT NULL,
  `discountpercent` float NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_voucher`
--

INSERT INTO `tbl_voucher` (`id_voucher`, `code`, `discountpercent`, `startdate`, `enddate`) VALUES
('VC1640534596143', 'Null', 0, '2024-01-01', '2024-12-31'),
('VC1640534625092', 'UuDai', 0.2, '2024-04-01', '2024-05-30');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_warehousereceipt`
--

CREATE TABLE `tbl_warehousereceipt` (
  `id_warehousereceipt` varchar(50) NOT NULL,
  `id_supplier` varchar(50) NOT NULL,
  `id_employee` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `totalprice` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_warehousereceipt`
--

INSERT INTO `tbl_warehousereceipt` (`id_warehousereceipt`, `id_supplier`, `id_employee`, `date`, `totalprice`) VALUES
('WA1640619120579', 'SU1696419239320', 'EM01', '2024-01-16 17:00:00', 12500000),
('WA1640619837606', 'SU1696419239320', 'EM02', '2024-01-16 17:00:00', 1100000),
('WA1640621144981', 'SU1696419239321', 'EM03', '2024-02-16 17:00:00', 19500000),
('WA1640934393665', 'SU1696419239321', 'EM04', '2024-01-20 17:00:00', 5000000),
('WA1640942260967', 'SU1696419239322', 'EM01', '2024-03-20 17:00:00', 1000000),
('WA1640942260976', 'SU1696419239322', 'EM02', '2024-02-21 17:00:00', 1200000),
('WA1640942260977', 'SU1696419239323', 'EM03', '2024-01-21 17:00:00', 2200000),
('WA1640942260978', 'SU1696419239324', 'EM04', '2024-01-21 17:00:00', 1500000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_warehousereceipt_detail`
--

CREATE TABLE `tbl_warehousereceipt_detail` (
  `id_warehousereceipt` varchar(50) NOT NULL,
  `id_product` varchar(50) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_warehousereceipt_detail`
--

INSERT INTO `tbl_warehousereceipt_detail` (`id_warehousereceipt`, `id_product`, `amount`, `price`) VALUES
('WA1640619120579', 'PR1640619150209', 50, 100000),
('WA1640619120579', 'PR1640619188733', 50, 150000),
('WA1640619837606', 'PR1640619150209', 10, 110000),
('WA1640621144981', 'PR1640621183186', 100, 150000),
('WA1640621144981', 'PR1640621209542', 30, 150000),
('WA1640934393665', 'PR1640942292840', 50, 100000),
('WA1640942260976', 'PR1640942292827', 25, 120000),
('WA1640942260977', 'PR1640942292220', 37, 220000),
('WA1640942260978', 'PR1640942292840', 50, 150000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_account`
--
ALTER TABLE `tbl_account`
  ADD PRIMARY KEY (`id_account`);

--
-- Chỉ mục cho bảng `tbl_brand`
--
ALTER TABLE `tbl_brand`
  ADD PRIMARY KEY (`id_brand`);

--
-- Chỉ mục cho bảng `tbl_category`
--
ALTER TABLE `tbl_category`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `tbl_categorychild`
--
ALTER TABLE `tbl_categorychild`
  ADD PRIMARY KEY (`id_categorychild`),
  ADD KEY `id_category` (`id_category`);

--
-- Chỉ mục cho bảng `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Chỉ mục cho bảng `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD PRIMARY KEY (`id_employee`);

--
-- Chỉ mục cho bảng `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_voucher` (`id_voucher`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_employee` (`id_employee`);

--
-- Chỉ mục cho bảng `tbl_order_item`
--
ALTER TABLE `tbl_order_item`
  ADD PRIMARY KEY (`id_order`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Chỉ mục cho bảng `tbl_permission`
--
ALTER TABLE `tbl_permission`
  ADD PRIMARY KEY (`id_permission`);

--
-- Chỉ mục cho bảng `tbl_position`
--
ALTER TABLE `tbl_position`
  ADD PRIMARY KEY (`id_position`);

--
-- Chỉ mục cho bảng `tbl_pos_permission`
--
ALTER TABLE `tbl_pos_permission`
  ADD PRIMARY KEY (`id_permission`,`id_position`),
  ADD KEY `id_position` (`id_position`);

--
-- Chỉ mục cho bảng `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_brand` (`id_brand`),
  ADD KEY `id_categorychild` (`id_categorychild`);

--
-- Chỉ mục cho bảng `tbl_product_sale`
--
ALTER TABLE `tbl_product_sale`
  ADD PRIMARY KEY (`id_product`);

--
-- Chỉ mục cho bảng `tbl_supplier`
--
ALTER TABLE `tbl_supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Chỉ mục cho bảng `tbl_voucher`
--
ALTER TABLE `tbl_voucher`
  ADD PRIMARY KEY (`id_voucher`);

--
-- Chỉ mục cho bảng `tbl_warehousereceipt`
--
ALTER TABLE `tbl_warehousereceipt`
  ADD PRIMARY KEY (`id_warehousereceipt`),
  ADD KEY `id_employee` (`id_employee`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Chỉ mục cho bảng `tbl_warehousereceipt_detail`
--
ALTER TABLE `tbl_warehousereceipt_detail`
  ADD PRIMARY KEY (`id_warehousereceipt`,`id_product`),
  ADD KEY `id_product` (`id_product`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbl_categorychild`
--
ALTER TABLE `tbl_categorychild`
  ADD CONSTRAINT `tbl_categorychild_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `tbl_category` (`id_category`);

--
-- Các ràng buộc cho bảng `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD CONSTRAINT `tbl_employee_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `tbl_account` (`id_account`);

--
-- Các ràng buộc cho bảng `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD CONSTRAINT `tbl_order_ibfk_1` FOREIGN KEY (`id_voucher`) REFERENCES `tbl_voucher` (`id_voucher`),
  ADD CONSTRAINT `tbl_order_ibfk_2` FOREIGN KEY (`id_customer`) REFERENCES `tbl_customer` (`id_customer`),
  ADD CONSTRAINT `tbl_order_ibfk_3` FOREIGN KEY (`id_employee`) REFERENCES `tbl_employee` (`id_employee`);

--
-- Các ràng buộc cho bảng `tbl_order_item`
--
ALTER TABLE `tbl_order_item`
  ADD CONSTRAINT `tbl_order_item_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `tbl_order` (`id_order`),
  ADD CONSTRAINT `tbl_order_item_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `tbl_product` (`id_product`);

--
-- Các ràng buộc cho bảng `tbl_pos_permission`
--
ALTER TABLE `tbl_pos_permission`
  ADD CONSTRAINT `tbl_pos_permission_ibfk_1` FOREIGN KEY (`id_permission`) REFERENCES `tbl_permission` (`id_permission`),
  ADD CONSTRAINT `tbl_pos_permission_ibfk_2` FOREIGN KEY (`id_position`) REFERENCES `tbl_position` (`id_position`);

--
-- Các ràng buộc cho bảng `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD CONSTRAINT `tbl_product_ibfk_1` FOREIGN KEY (`id_brand`) REFERENCES `tbl_brand` (`id_brand`),
  ADD CONSTRAINT `tbl_product_ibfk_2` FOREIGN KEY (`id_categorychild`) REFERENCES `tbl_categorychild` (`id_categorychild`);

--
-- Các ràng buộc cho bảng `tbl_product_sale`
--
ALTER TABLE `tbl_product_sale`
  ADD CONSTRAINT `tbl_product_sale_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `tbl_product` (`id_product`);

--
-- Các ràng buộc cho bảng `tbl_warehousereceipt`
--
ALTER TABLE `tbl_warehousereceipt`
  ADD CONSTRAINT `tbl_warehousereceipt_ibfk_1` FOREIGN KEY (`id_employee`) REFERENCES `tbl_employee` (`id_employee`),
  ADD CONSTRAINT `tbl_warehousereceipt_ibfk_2` FOREIGN KEY (`id_supplier`) REFERENCES `tbl_supplier` (`id_supplier`);

--
-- Các ràng buộc cho bảng `tbl_warehousereceipt_detail`
--
ALTER TABLE `tbl_warehousereceipt_detail`
  ADD CONSTRAINT `tbl_warehousereceipt_detail_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `tbl_product` (`id_product`),
  ADD CONSTRAINT `tbl_warehousereceipt_detail_ibfk_2` FOREIGN KEY (`id_warehousereceipt`) REFERENCES `tbl_warehousereceipt` (`id_warehousereceipt`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
