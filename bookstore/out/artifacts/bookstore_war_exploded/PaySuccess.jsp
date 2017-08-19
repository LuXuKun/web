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
</head>
<body>
<header class="top" role="header">
    <div class="container">
        <a href="#" class="navbar-brand pull-left">
            Customer
        </a>
        <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="glyphicon glyphicon-align-justify"></span>
        </button>
        <nav class="navbar-collapse collapse" role="navigation">
            <ul class="navbar-nav nav">
                <li><a href="Userhome.jsp">Browing Books</a></li>
                <li><a href="UserSearchBook.jsp">Searching Specific Book</a></li>
                <li><a href="UserCart.jsp">Shopping Cart</a></li>
                <li><a href="UserOrders.jsp">My orders</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li class="pull-right"><a href="LogOut.action">Log out</a></li>
            </ul>
        </nav>
    </div>
</header>
<div class="banner">
    <div class="container">
        <h1>Congratulations</h1>
        </br>
        <p>Your have successfully pay for the books. </p>
    </div>
</div>
<div class="middle">
    <div class="container">
        </br>
        </br>
        <div class="col-md-9 content">
            <h2>The books you bought will reach your home in several work days.</h2>
            </br>
            <p>You can either browse the books again or simply log out.</p>
            <div class="to-tutorial">
                <br>
                <p><strong>Wish you have a good day!</strong></p>
                <a href="LogOut.action" class="btn btn-success">Log Out If You Want</a>
            </div>
        </div>
        <div class="col-md-3">
            <h2>Recommanded Books</h2>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">Web Designing</a></li>
                <li><a href="#">Database System Concepts</a></li>
                <li><a href="#">Introduction to Algorithms</a></li>
                <li><a href="#">UK: HTML & CSS: Design and Build</a></li>
                <li><a href="#">Computer Systems second edition</a></li>
                <li><a href="#">Software engineer</a></li>
                <li><a href="#">Meditations on First Philosophy</a></li>
            </ul>
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
