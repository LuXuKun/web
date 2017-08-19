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
                HOME
            </a>
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="glyphicon glyphicon-align-justify"></span>
            </button>
            <nav class="navbar-collapse collapse" role="navigation">
                <ul class="navbar-nav nav">
                    <li><a href="SignUp.jsp">Register</a></li>
                    <li><a href="LogIn.jsp">Login</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="banner">
        <div class="container">
            <h1>Welcome : This Is Universal Bookstore</h1>
            </br>
            <p>You can log in here to buy books . Wish you have a good day! </p>
        </div>
    </div>
    <div class="middle">
        <div class="container">
            <div class="col-md-9 content">
              <img src="img/3.jpg" 
                 alt="picture">
            </div>
            <div class="col-md-3">
            </br>
            </br>
            </br>
            </br>
                <h2>Log in</h2>
                <ul class="nav nav-pills nav-stacked">
                    <form id="register" action="LogIn" method="post">
           
            Email:
            <input class="easyui-textbox"  name="email" type="text" data-options="prompt:'Enter your email...',"style="width:100%;height:32px" required="true"></input>
            </br>
            Password:
            <input class="easyui-textbox"  name="password" type="text" data-options="prompt:'Enter your password...',"style="width:100%;height:32px" required="true"></input>
            </br>
            </br>
            <div>
                 <input href="#" class="btn btn-primary"  style="width:100%;height:32px" type="submit" value="Login"></input>
            </div>
            </div>
          </form>
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
