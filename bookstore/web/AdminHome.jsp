<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/demo/demo.css">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<header class="top" role="header">
    <div class="container">
        <a href="#" class="navbar-brand pull-left">
            Administrator
        </a>
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
        <nav class="navbar-collapse collapse" role="navigation">
            <ul class="navbar-nav nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Book Statistic <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="SearchBookByID.jsp">By ID</a></li>
                        <li class="divider"></li>
                        <li><a href="SearchBookByTitle.jsp">By Title</a></li>
                        <li class="divider"></li>
                        <li><a href="SearchBookByCategory.jsp">By Category</a></li>
                        <li class="divider"></li>
                        <li><a href="GetAllBook.jsp">Get All</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        User Statistic <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="SearchUserByEmail.jsp">By Email</a></li>
                        <li class="divider"></li>
                        <li><a href="SearchUserByName.jsp">By Name</a></li>
                        <li class="divider"></li>
                        <li><a href="GetAllUser.jsp">Get All</a></li>
                    </ul>
                </li>
                <li><a href="OrderStatistic.jsp">Order Statistic</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li class="pull-right"><a href="LogOut.action">Log out</a></li>
            </ul>
        </nav>
    </div>
</header>
<div class="banner">
    <div class="container">
        <h1>You Have Logged In As An Administrator</h1>
        </br>
        <p>Remember to be fair and justified. Good job! </p>
    </div>
</div>
<div class="middle">
    <div class="container">
        </br>
        </br>
        <div class="col-md-9 content">
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
<div class="bottom">
    <div class="container">
        <div class="col-md-4">
            <h3><span class="glyphicon glyphicon-heart"></span> John Ruskin </h3>
            <p>Living without an aim is like sailing without a compass.</p>
        </div>
        <div class="col-md-4">
            <h3><span class="glyphicon glyphicon-star"></span> Lincoln</h3>
            <p>Towering genius disdains a beaten path. It seeks regions hitherto unexplored.</p>
        </div>
        <div class="col-md-4">
            <h3><span class="glyphicon glyphicon-music"></span> J.H. Newman </h3>
            <p> Fear not that the life shall come to an end, but rather fear that it shall never have a beginning.</p>
        </div>
    </div>
</div>

</body>
</html>
