<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.bson.Document"%>
<%@page import="com.mongodb.client.FindIterable"%>
<%@page import="java.util.*"%>
<%@page import="com.mongodb.client.MongoCursor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<title>User Page</title>
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  
    <%String usertype = (String)session.getAttribute("usertype"); %>
    <script>
            $(document).ready(function() { 
                 var checkedList;
                 
            
            $("#del").click(function() { 
        
            var checkedNum = $("input[name='subChk']:checked").length; 
            if(checkedNum == 0) { 
            alert("Please choose one！"); 
            return; 
            } 
        
            if(confirm("Are you sure to delete？")) { 
                checkedList = new Array(); 
            $("input[name='subChk']:checked").each(function() { 
            checkedList.push($(this).val()); 
            }); 
            $.ajax({ 
            type: "POST", 
            dataType: "html", 
            url: "<%=request.getContextPath()%>/deleteMore.jsp", 
            data: {'delitems':checkedList.toString()}, 
            success: function(result) { 
            $("[name ='subChk']:checkbox").attr("checked", false);
                var r = result.toString().split(",");
               if(r.length >= 1){
                for(var i=0;i < checkedList.length; i++){ 	
                    var index = document.getElementById(checkedList[i]).parentNode.parentNode.rowIndex;
                    document.getElementById("show").deleteRow(index);
                }
            }else{
                alert("error");
            }
            }
            }); 
            } 
            }); 
            }); 
        </script>
        
        <script>
        $(function(){
            var disabled = true;
            $("#modify").click(function(){
                if(!disabled){
                    $('input[type="text"]').attr('disabled', 'disabled');
                    $(this).text('Enable Input');
                } else {
                    $('input[type="text"]').removeAttr('disabled');
                     $(this).text('Disable Input');
                }
                disabled = !disabled;
            });
        });
       
        function write(){
      		document.getElementById("text1").readOnly=false;
      	}
        </script>
        
  
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <header class="main-header">
    <a class="logo">
      <%Document o = (Document)session.getAttribute("userObj");%>
      <span class="logo-mini"><%=o.get("username").toString()%></span>
      <span class="logo-lg"><b>We</b>Care</span>
    </a>
    <nav class="navbar navbar-static-top">
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                      page and may cause design problems
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i> 5 new members joined
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> You changed your username
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"><%=o.get("username").toString()%></span>
            </a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p><%=o.get("username").toString()%> - Admin</p>
              </li>
              <li class="user-footer">
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>

    </nav>
   </header>
   
   <aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=o.get("username").toString()%></p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
       
       <li>
          <a href="userActionServlet?action=displayUsers&type=nutritionist">
            <i class="fa fa-th"></i> <span>Nutritionist</span>
          </a>
        </li>
	<li>
          <a href="userActionServlet?action=displayUsers&type=advertiser">
            <i class="fa fa-pie-chart"></i> <span>Advertiser</span>
          </a>
        </li>
	<li>
          <a href="userActionServlet?action=displayUsers&type=vendor">
            <i class="fa fa-laptop"></i> <span>Vendor</span>
          </a>
        </li>
      </ul>
    </section>
  </aside>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>
      <%=usertype.toUpperCase()%>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"> <%=usertype.toUpperCase() +"INFO" %></li>
      </ol>
    </section>
    <section class="content">
      <div class="row">
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title"> <%=usertype.toUpperCase() %> Information</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
	    <form id="advertiser_information">
	     <div class="box-body">
              <div class="table-responsive">
                <table id = "show" class="table no-margin">
                  <thead>
                  <tr>
                  	<th>CheckBox</th>
                    <th>ID</th>
                    <th>username</th>
                    <th>password</th>
                 
				    <%
					FindIterable<Document> docs = (FindIterable<Document>) session.getAttribute("userlists");	
					MongoCursor<Document> mongoCursor = docs.iterator(); 
					Document details = null;
					int count = 0;
					while(mongoCursor.hasNext()) { 
					%>
						</tr>
		                </thead>
		                <tbody>
		                <tr class = "result">
					<%
				       details = mongoCursor.next();
						
				    %>
				    
				    <td><input id="<%=details.get("_id").toString() %>" type="checkbox" name="subChk" value="<%=details.get("_id").toString() %>"></td>
				    <td><%=details.get("_id").toString() %></td>
				    <td><%=details.get("username").toString() %></td>
				    <td><%=details.get("password").toString() %></td>
				    <%
					}
					%>
					</tr>
                  </tbody>
                </table>
              </div>
            </div>
	    </form>
	    </form>
	  
	   <div class="box-footer clearfix">
             <!-- <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-right">Add New User</a> --> 
	      <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-right" id="del">Delete User</a>
             <!-- <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-right" id="modify">Modify User</a> --> 
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
  <div class="control-sidebar-bg"></div>

</div>

</html>
