<%-- 
    Document   : signup
    Created on : 26-Mar-2017, 1:48:33 PM
    Author     : damil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign Up</title>

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href = "<c:url value="/resources/css/bootstrap.min.css" />" />
   
</head>

<body ng-app>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./home">Esac Villa</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="./home">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="./availability">Search Rooms</a></li>
            </ul>
            <div>
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="Email" class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control" name="password">
                    </div>
                    <button type="submit" class="btn btn-success">Sign in</button>
                </form>
            </div>
        </div><!--/.navbar-collapse -->
    </div>
</nav>
<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron"  href="#about">
    <div class="container">
        <h1>Sign Up</h1>
       </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <h4>Please Enter following details</h4>
        <form method="post" action="./register">
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter user Name" name="customerusername"/>
                </div>
                <div class="col-md-4">
                    <input type="password" class="form-control" placeholder="Enter password" name="password"/>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter First Name" name="firstname"/>
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter Last Name" name="lastname"/>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-4">
                    <input type="email" class="form-control" placeholder="Enter Email" name="email"/>
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter phone" name="phone"/>
                </div>
            </div><br>
            <label>Mailing Address</label><br>
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter Street" name="mailingAddress.street"/>
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter City" name="mailingAddress.city"/>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter Province" name="mailingAddress.province"/>
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter Country" name="mailingAddress.country"/>
                </div>
            </div><br>
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Enter Postal code" name="mailingAddress.postalCode"/>
                </div>
            </div><br>
            <label>Biling Address &nbsp;</label><input type="checkbox" ng-model="check" checked> Same as Mailing address<br>
            <div ng-if="!check">
                <div class="row">
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter Street" name="billingAddress.street"/>
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter City" name="billingAddress.city"/>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter Province" name="billingAddress.province"/>
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter Country" name="billingAddress.country"/>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="Enter Postal code" name="billingAddress.postalCode"/>
                    </div>
                </div><br>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <input type="submit" class="btn btn-success" value="Sign up"/>
                </div>
            </div><br>
        </form>
    <hr>

    <footer>
        <p>&copy; 2016 Company, Esac Inc.</p>
    </footer>
</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>

<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
</body>
</html>
