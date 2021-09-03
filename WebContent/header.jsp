<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
	Gson gsonObj = new Gson();
	Map<Object,Object> map = null;
	List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
	 
	map = new HashMap<Object,Object>(); map.put("label", "Brazil"); map.put("y", 104); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "China"); map.put("y", 153); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "India"); map.put("y", 69); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "Japan"); map.put("y", 166); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "Korea, Rep"); map.put("y", 146); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "Russia"); map.put("y", 61); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "South Africa"); map.put("y", 78); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label", "United Kingdom"); map.put("y", 135); list.add(map);
	 
	String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="./Public/template/assets/img/apple-icon.png"/>
    <link rel="icon" type="image/png" href="./Public/template/assets/img/favicon.ico"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title> Application Suivi Stock | JAVA | JPA </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="./Public/template/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="./Public/template/assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="./Public/template/assets/css/demo.css" rel="stylesheet" />
	
</head>

<body>
	<script type="text/javascript">
		window.onload = function () {
		
		var chart = new CanvasJS.Chart("chartContainer", {
			theme: "light1", // "light2", "dark1", "dark2"
			animationEnabled: false, // change to true		
			title:{
				text: "Basic Column Chart"
			},
			data: [
			{
				// Change type to "bar", "area", "spline", "pie",etc.
				type: "column",
				dataPoints: [
					<%
					 //List<Produit> produits = (List<Produit>)request.getAttribute("List_produits");
					 %>
				]
				
							<% 
							out.print("[");
							out.print("{ label: 'Ordinateur',  y: 10  },");
							out.print("{ label: 'Fauteille', y: 18  },");
							out.print("{ label: 'Téléphone', y: 25  },");
							out.print("{ label: 'Télévision',  y: 15  },");
							out.print("{ label: 'Chemises',  y: 20  }");
							out.print("]");
							%>
					
			}
			]
		});
		chart.render();
			 //=====================================================================
			var chart1 = new CanvasJS.Chart("chartContainer1", {
				animationEnabled: true,
				title: {
					text: "Deposit Money Banks' Assets to GDP (percent), 2015"
				},
				axisY: {
					suffix: "%",
					includeZero: true
				},
				axisX: {
					title: "Countries"
				},
				data: [{
					type: "column",
					yValueFormatString: "#,##0\"%\"",
					dataPoints: <%out.print(dataPoints);%>
				}]
			});
			chart1.render();
			 
			}
	</script>
    <div class="wrapper">
        <div class="sidebar" data-image="./Public/template/assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="http://localhost:8080/SuiviStockJPA/Accueil" class="simple-text">
                        Cours JAVA/JEE
                    </a>
                </div>
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="Accueil">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Tableau de bord</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="User?page=profil">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Profil utilisateur</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="User?page=list">
                            <i class="nc-icon nc-notes"></i>
                            <p>Administration</p>
                        </a>
                    </li>
                     <li>
                        <a class="nav-link" href="Produit">
                            <i class="nc-icon nc-notes"></i>
                            <p>Gestion des produits</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="Categorie">
                            <i class="nc-icon nc-notes"></i>
                            <p>Gestion - Categories</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                      
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="User?page=profil">
                                    <span class="no-icon">Compte</span>
                                </a>
                            </li>
                             
                            <li class="nav-item">
                                <a class="nav-link" href="Logout">
                                    <span class="no-icon">Déconnexion</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>