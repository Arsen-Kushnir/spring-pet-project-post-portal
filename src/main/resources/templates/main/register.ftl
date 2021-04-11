<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Registration</title>
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

<#include "../include/header.ftl">

    <div class="container">
        <div class="w-100 h-100 d-flex align-items-center justify-content-center mt-4 mb-3">
            <div class="col-md-8">
                <form method="POST" action="/accounts" class="form-signin">
                    <h2 class="form-heading text-center p-2">Registration</h2>
                    <div class="form-group">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <label for="first_name" class="form-label m-2">First name:</label>
                        <input id="first_name" name="firstName" type="text" class="form-control m-2" placeholder="First name..." autofocus="true"/>
                        <#if firstNameError??>
                            <div class="form-text text-center">${firstNameError}</div>
                        </#if>

                        <label for="last_name" class="form-label m-2">Last name:</label>
                        <input id="last_name" name="lastName" type="text" class="form-control m-2" placeholder="Last name..."/>
                        <#if lastNameError??>
                            <div class="form-text text-center">${lastNameError}</div>
                        </#if>

                        <label for="age" class="form-label m-2">Age:</label>
                        <input id="age" name="age" type="number" class="form-control m-2" placeholder="Age..."/>
                        <#if ageError??>
                            <div class="form-text text-center">${ageError}</div>
                        </#if>

                        <label for="username" class="form-label m-2">Username:</label>
                        <input id="username" name="username" type="text" class="form-control m-2" placeholder="Username..."/>
                        <#if duplicationException??>
                            <div class="form-text text-center">${duplicationException}</div>
                        </#if>
                        <#if usernameError??>
                            <div class="form-text text-center">${usernameError}</div>
                        </#if>

                        <#if passwordsException??>
                            <div class="form-text text-center">${passwordsException}</div>
                        </#if>
                        <label for="password" class="form-label m-2">Password:</label>
                        <input id="password" name="password" type="password" class="form-control m-2" placeholder="Password..."/>
                        <#if passwordError??>
                            <div class="form-text text-center">${passwordError}</div>
                        </#if>

                        <label for="repeated_password" class="form-label m-2">Repeat password:</label>
                        <input id="repeated_password" name="repeatedPassword" type="password" class="form-control m-2" placeholder="Repeat password..."/>
                        <#if repeatedPasswordError??>
                            <div class="form-text text-center">${repeatedPasswordError}</div>
                        </#if>

                        <div class="form-row text-center">
                            <button class="btn btn-primary m-3 p-2 w-50 center-block" type="submit">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <#include "../include/footer.ftl">

</body>
</html>