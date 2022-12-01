<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Live Journal - Registration Page </title>
    <link rel="stylesheet" href="assets/css/registration.css">
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-sixteen.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
          rel="stylesheet">
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div id="preloader">
    <div class="jumper">
        <div></div>
        <div></div>
        <div></div>
    </div>
</div>
<!-- ***** Preloader End ***** -->

<!-- Header -->
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="index.jsp"><h2>Live <em>Journal</em></h2></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/publications">Our Periodicals</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${!empty sessionScope}">
                            <a class="nav-link" href="addPublication.jsp">Add Periodicals</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${!empty sessionScope}">
                            <a class="nav-link" href="/logout">Log Out</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${empty sessionScope}">
                            <a class="nav-link" href="login.jsp">Log In</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${empty sessionScope}">
                            <a class="nav-link" href="/registration">Sign Up</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="middle">
    <h1>Register account</h1>
    <form method="post" action="/registration">
        <div style="color:white; text-align: center;background-color:red; border-radius:30px">${errorMessage}</div>
        <div id="fancy-inputs">
            <label class="input">
                <input type="text" required name="firstname" placeholder="Firstname">
            </label>
            <label class="input">
                <input type="text" required name="lastname" placeholder="Lastname">
            </label>
            <label class="input">
                <input type="email" required name="email" placeholder="Email">
            </label>
            <label class="input">
                <input type="password" required name="password" placeholder="Password">
            </label>
        </div>
        <div id="fancy-radio">
            <input type="radio" name="gender" value="MALE" id="questions" class="pull-left" style="display: none;">
            <label class="radio questions" for="questions">Male</label>

            <input type="radio" name="gender" value="FEMALE" id="photo" class="pull-left" style="display: none;">
            <label class="radio photo" for="photo">Female</label>
        </div>
        <input type="submit" value="Sign Up " class="btn">
    </form>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<!-- Additional Scripts -->
<script src="assets/js/custom.js"></script>
<script src="assets/js/owl.js"></script>
<script src="assets/js/slick.js"></script>
<script src="assets/js/isotope.js"></script>
<script src="assets/js/accordions.js"></script>
<script src="assets/js/form.js"></script>
<script language="text/Javascript">
    cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
    function clearField(t) {                   //declaring the array outside of the
        if (!cleared[t.id]) {                      // function makes it static and global
            cleared[t.id] = 1;  // you could use true and false, but that's more typing
            t.value = '';         // with more chance of typos
            t.style.color = '#fff';
        }
    }
</script>

</body>
</html>