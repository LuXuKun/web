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
    <style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
    <script type="text/javascript">
		var url;
		function AddToCart(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','Are you sure you want to add this book to cart?',function(r){
					if (r){
						$.post('AddToCart.action',{id:row.id},function(result){
							if (result.success){
								$('#dg').datagrid('reload');	// reload the user data
								$.messager.show({	// show error message
									title: 'Success',
									msg: result.msg
								});
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
		function getBookDetailJson(){
		var row = $('#dg').datagrid('getSelected');
			if (row){
						$.post('GetBookDetail.action',{id:row.id},function(result){
							if (result.success){
								$.messager.alert({	// show error message
									title: 'Details:',
									msg:"Title: "+result.title+"<br>Author: "
									+result.author+'\n'+"<br>Price: "+result.price+'\n'+"<br>Category: "+result.category						
								});
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
			}
		}
	</script>
      
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
                    <li><a href="UserHome.jsp">Browing Books</a></li>
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
            <h1>Buy books : Only For Customers</h1>
            </br>
            <p>You can add books to your shopping cart, books can be added only one by one. </p>
        </div>
    </div>
    <div class="middle">
        <div class="container">
            </br>
            </br>
            <div class="col-md-9 content">
	
	<table id="dg" title="Browsing books" class="easyui-datagrid" style="width:750px;height:400px"
			url="GetAllBooks.action"
			toolbar="#toolbar" pagination="true"
			rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="title" width="50">Title</th>
                <th field="author" width="50">Author</th>
                <th field="category" width="50">Category</th>
            </tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="AddToCart()">Add to shopping cart</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="getBookDetailJson()">Details of the book</a>
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




