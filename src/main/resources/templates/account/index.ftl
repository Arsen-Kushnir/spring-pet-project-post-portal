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

                <#if posts?has_content>

                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Title</th>
                            <th scope="col">Created at</th>
                            <th scope="col">View</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list posts as post >
                            <tr>
                                <th scope="row">${post.title}</th>
                                <td>${post.createdAt}</td>
                                <td><a class="btn btn-outline-dark" href="/posts/${post.id}">View detail</a></td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>

                <#else>
                    <div class="text-center w-100">
                        <h2>Sorry, but not found any posts!</h2>
                    </div>
                </#if>

            </div>
        </div>
    </main>

    <#include "../include/footer.ftl">

</body>
</html>