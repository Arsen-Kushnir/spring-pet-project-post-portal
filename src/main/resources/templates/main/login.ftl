<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Login</title>
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

    <#include "../include/header.ftl">

    <div class="container">
        <div class="w-100 h-100 d-flex align-items-center justify-content-center mt-5">
            <div class="col-md-8">
                <form method="POST" action="/login" class="form-signin">
                    <h2 class="form-heading text-center p-3">Login</h2>
                    <div class="form-group">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <#if flashMessageError??>
                            <div class="form-text text-center">${flashMessageError}</div>
                        <#elseif flashMessageSuccess??>
                            <div class="form-text text-center">${flashMessageSuccess}</div>
                        </#if>

                        <label for="username" class="form-label m-3">Username:</label>
                        <input id="username" name="username" type="text" class="form-control m-3" placeholder="Username..." autofocus="true"/>

                        <label for="password" class="form-label m-3">Password:</label>
                        <input id="password" name="password" type="password" class="form-control m-3" placeholder="Password..."/>

                        <div class="form-row text-center">
                            <button class="btn btn-primary m-3 p-2 w-50 center-block" type="submit">Login</button>
                            <div class="form-text">If you do not have an account?!</div>
                            <a href="/register" class="btn btn-primary m-3 p-2 w-50 center-block" type="submit">Register</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <#include "../include/footer.ftl">

</body>
</html>