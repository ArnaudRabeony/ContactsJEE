<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.1.1/css/mdb.min.css">	
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/main.css">

<header>
        <!--Navbar-->
        <nav class="navbar navbar-dark navbar-fixed-top scrolling-navbar mdb-gradient top-nav-collapse">
            <div class="container">
            	<span class="navbar-brand" style="color:azure;cursor:default;">Gestionnaire de contacts</span>
                    <!--Navbar icons-->
                    <ul class="nav navbar-nav nav-flex-icons">
                        <li class="nav-item">
                        	<button id="logout" class="btn btn-sm btn-default">Deconnexion</button>
                        </li>
                    </ul>
            </div>
        </nav>
        <!--/.Navbar-->
</header>

<div class="row">
	<div id="fabContainer" class="col-sm-1 col-mg-1">
		<a href="index.jsp" class="btn btn-info btn-fab-mini"><i class="material-icons">home</i></a>
		<a href="searchContact.jsp" class="btn btn-default btn-fab-mini"><i class="material-icons">search</i></a>
		<a href="create.jsp" class="btn btn-primary btn-fab-mini"><i class="material-icons">add</i></a>
		<a href="delete.jsp" class="btn btn-warning btn-fab-mini"><i class="material-icons">clear</i></a>
		<a href="update.jsp" class="btn btn-success btn-fab-mini"><i class="material-icons">mode_edit</i></a>
	</div>
	<div id="rightPanel" class="col-sm-11 col-mg-11">
		<h5 style="float:right">Bonjour, ${sessionScope.nom}</h5>
