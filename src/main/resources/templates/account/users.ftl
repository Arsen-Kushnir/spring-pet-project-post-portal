<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Account</title>
</head>
<body class="d-flex flex-column min-vh-100">

    <#include "../include/header.ftl">

    <main class="container-fluid pb-3 pt-3">
        <div class="d-grid gap-3" style="grid-template-columns: 1fr 2fr;">

            <#include "./include/aside.ftl">

            <div class="bg-light border rounded-3 p-3">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">First name</th>
                        <th scope="col">Last name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Username</th>
                        <th scope="col">Role</th>
                        <th scope="col">Active</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>

                    <#list users as user >
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.age}</td>
                            <td>${user.username}</td>
                            <th>${user.role}</th>
                            <td>${user.active?string("yes", "no")}</td>
                            <td>
                                <form method="POST" action="/accounts/delete/${user.id}">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                                    <button class="btn btn-outline-dark">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </#list>

                    </tbody>
                </table>
            </div>
        </div>
    </main>

    <#include "../include/footer.ftl">

</body>
</html>