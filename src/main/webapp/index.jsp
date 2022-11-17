<!DOCTYPE html>
<html  lang="en">

<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

    <link rel="stylesheet" href=css/style.css>
<body>
<div class="container">
    
    <h1 class="text-center">Register</h1>
    <form class="registration-form" method="post" action="/registration">
        <label class="col-one-half">
            <span class="label-text">First Name</span>
            <input type="text" name="firstname">
        </label>
        <label class="col-one-half">
            <span class="label-text">Last Name</span>
            <input type="text" name="lastname">
        </label>
        <label>
            <span class="label-text">Email</span>
            <input type="text" name="email">
        </label>
        <label class="password">
            <span class="label-text">Password</span>
            <button class="toggle-visibility" title="toggle password visibility" tabindex="-1">
                <span class="glyphicon glyphicon-eye-close"></span>
            </button>
            <input type="text" name="password">
        </label>
        <label class="checkbox">
            <input type="radio" name="newsletter">
            <span>Male</span>
        </label>
        <label class="checkbox">
            <input type="radio" name="newsletter">
            <span>Female</span>
        </label>
        <div class="text-center">
            <button class="submit" name="register">Sign Me Up</button>
        </div>
    </form>
</div>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>
</html>
